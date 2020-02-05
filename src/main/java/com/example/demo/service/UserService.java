package com.example.demo.service;


import com.alibaba.fastjson.JSON;
import com.example.demo.common.UserException;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.util.BeanHelper;
import com.example.demo.util.HashUtil;
import com.google.common.base.Strings;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;


@Service("UserService")
public class UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Value("${domain.name}")
    private String domain_name;

    @Value("${file.path}")
    private String imgPrefix;

    @Autowired
    private FileService fileService;

    @Autowired
    private MailService mailService;

    /**
     * 1.首先通过缓存获取
     * 2.不存在将从通过数据库获取用户对象
     * 3.将用户对象写入缓存，设置缓存时间5分钟
     * 4.返回对象
     * @param id
     * @return
     */
    public User getUserById(Long id) {

        User user = null;

        String key = "user:"+id;
        String json =  redisTemplate.opsForValue().get(key);

        if (Strings.isNullOrEmpty(json)) {
            user =  userMapper.selectByPrimaryKey(id);

            String string  = JSON.toJSONString(user);
            redisTemplate.opsForValue().set(key, string);
            redisTemplate.expire(key, 5, TimeUnit.MINUTES);

            System.out.println("not hit cache");
        }else {
            user = JSON.parseObject(json,User.class);
            System.out.println("hit cache");
        }
        return user;
    }

    /**
     * 1 注册
     * @param user
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    /*
    * 在@Transactional注解中如果不配置rollbackFor属性,那么事物只会在遇到RuntimeException的时候才会回滚,
    * 加上rollbackFor=Exception.class,可以让事物在遇到非运行时异常时也回滚
    * */
    public boolean addAccount(User user) {

        try
        {
            List<String> encypted_info = HashUtil.hashSSHA(user.getPassword());
            user.setSalt(encypted_info.get(0));
            user.setPassword(encypted_info.get(1));

            user.setCompany_id(-1L);
            user.setConx_chat_notification(true);
            user.setEmail_notification(true);
            user.setStatus(0);
            user.setCreated_by("root");
            user.setModified_by("root");
            user.setIs_cloud(false);

            BeanHelper.onInsert(user);
            userMapper.insert(user);

            String enableUrlPrefix = "http://" + domain_name + "/user/enable";
            registerNotify(user.getEmail(), enableUrlPrefix);
        }
        catch (Exception ex)
        {
            System.out.println("exception ex: " + ex.getMessage());
            return false;
        }
        return true;
    }

    /**
     * 1.2 发送注册激活邮件
     * @param email
     * @param enableUrlPrefix
     */
    private void registerNotify(String email, String enableUrlPrefix) {
        String randomKey = HashUtil.hashString(email) + RandomStringUtils.randomAlphabetic(10);

        redisTemplate.opsForValue().set(randomKey, email);
        redisTemplate.expire(randomKey, 1,TimeUnit.HOURS);

        String content = enableUrlPrefix +"?key="+  randomKey;
        mailService.sendSimpleMail("系统激活邮件", content, email);
    }

    /**
     * 1.3 激活用户
     * @param key
     */
    public boolean enable(String key) {
        String email = redisTemplate.opsForValue().get(key);
        if (StringUtils.isBlank(email)) {
            throw new UserException(UserException.Type.USER_NOT_FOUND, "无效的key");
        }

        User updateUser = new User();
        updateUser.setEmail(email);
        updateUser.setStatus(1);
        userMapper.updateByEmail(updateUser);

        //问题：需要删除redis中的key吗？？？
        return true;
    }
}
