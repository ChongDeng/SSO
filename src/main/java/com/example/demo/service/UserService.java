package com.example.demo.service;


import com.alibaba.fastjson.JSON;
import com.example.demo.common.PageParams;
import com.example.demo.common.UserException;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.util.BeanHelper;
import com.example.demo.util.HashUtil;
import com.example.demo.util.JwtHelper;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableMap;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;


@Service("UserService")
public class UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Value("${domain.name}")
    private String domain_name;

    @Value("${image.url_prefix}")
    private String ImageUrlPrefix;

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

    public List<User> getUsers(User user) {
        List<User> users = userMapper.getUsers(user);
        users.forEach(u -> {
            u.setAvistar(ImageUrlPrefix + u.getAvistar());
        });
        return users;
    }

    private User getUserByEmail(String email) {
        User user = new User();
        user.setEmail(email);
        List<User> list = getUsers(user);
        if (!list.isEmpty()) {
            return list.get(0);
        }
        throw new UserException(UserException.Type.USER_NOT_FOUND,"User not found for " + email);
    }


    public User getLoginedUserByToken(String token) {
        Map<String, String> claims = null;

        try {
            claims = JwtHelper.verifyToken(token);
        } catch (Exception e) {
            throw new UserException(UserException.Type.USER_NOT_LOGIN,"User not login");
        }

        String email = claims.get("email");

        System.out.println("got email: " + email);

        Long expired = redisTemplate.getExpire(email);
        if (expired > 0L) {

            //在redis中更新token的过期时间： 因为本函数是验证token，所以一旦验证成功，就更新tokden过期时间
            renewToken(token, email);

            User user = getUserByEmail(email);
            //user.setToken(token);
            return user;
        }
        throw new UserException(UserException.Type.USER_NOT_LOGIN,"user not login");
    }

    //在redis中更新token的过期时间
    private String renewToken(String token, String email) {
        redisTemplate.opsForValue().set(email, token);
        redisTemplate.expire(email, 30, TimeUnit.MINUTES);
        return token;
    }

    public Pair<List<User>,Long> getPageUsers(PageParams pageParams) {
        List<User> agents =  userMapper.getPageUsers(new User(),pageParams);
        Long count  = Long.valueOf(agents.size());
        return ImmutablePair.of(agents, count);
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
     * 1.2 注册: 当cas登录成功后，把数据插入到数据库
     * @param user
     * @return
     */
    //@Async
    @Transactional(rollbackFor = Exception.class)
    /*
    * 在@Transactional注解中如果不配置rollbackFor属性,那么事物只会在遇到RuntimeException的时候才会回滚,
    * 加上rollbackFor=Exception.class,可以让事物在遇到非运行时异常时也回滚
    * */
    public boolean insertCasUser(User user) {

        try
        {
            if(user == null) return false;

            List<User> result = userMapper.getUsers(user);
            if(result != null && !result.isEmpty())
            {
                System.out.println("user " + user.getEmail() + " already exists.");
                return true;
            }

            List<String> encypted_info = HashUtil.hashSSHA("123456");
            user.setSalt(encypted_info.get(0));
            user.setPassword(encypted_info.get(1));

            user.setCompany_id(-1L);
            user.setConx_chat_notification(true);
            user.setEmail_notification(true);
            user.setStatus(1);
            user.setCreated_by("root");
            user.setModified_by("root");
            user.setIs_cloud(true);

            BeanHelper.onInsert(user);
            userMapper.insert(user);
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
    @Async
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

    //2 登录/鉴权
    /**
     * 校验用户名密码、生成token并返回{用户对象, token}
     * @param email
     * @param passwd
     * @return
     */
    public Pair<User, String> auth(String email, String passwd) {
        if (StringUtils.isBlank(email) || StringUtils.isBlank(passwd)) {
            throw new UserException(UserException.Type.USER_AUTH_FAIL,"User Auth Fail");
        }

        User user = new User();
        user.setEmail(email);
        user.setStatus(1); //因为只查询已被激活的用户。 对非激活的用户不关心

        List<User> list =  getUsers(user);
        if (!list.isEmpty()) {
            User retUser = list.get(0);

            try {
                if(HashUtil.getHashSSHA(retUser.getSalt(), passwd).equals(retUser.getPassword()))
                {
                    String token = onLogin(retUser); //用来在登录成功后生成token
                    return ImmutablePair.of(retUser, token);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        throw new UserException(UserException.Type.USER_AUTH_FAIL,"User Auth Fail");
    }

    //用来在登录成功后生成token, 并返回token
    public String onLogin(User user) {
        //将email，name和ts写入claims， 然后根据该claims生成token
        String token =  JwtHelper.genToken(ImmutableMap.of("email", user.getEmail(), "name", user.getLogin_name(),"ts", Instant.now().getEpochSecond()+""));
        System.out.println("=================  token is: " + token);

        //在redis中更新token的过期时间
        renewToken(token, user.getEmail());
        //user.setToken(token);
        return token;
    }

    //3 密码重置

    //4 修改用户信息

    //log out
    public void invalidate(String token) {
        Map<String, String> claims = JwtHelper.verifyToken(token);
        redisTemplate.delete(claims.get("email"));
    }
}
