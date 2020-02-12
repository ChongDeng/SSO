package com.example.demo.controller;

import com.example.demo.annotation.PassToken;
import com.example.demo.common.*;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    //----------------------1 注册----------------------------------
    @RequestMapping("register")
    public RestResponse register(@RequestBody User user){
        if(!userService.addAccount(user))
            return RestResponse.error(RestCode.REGISTER_FAILURE);
        return RestResponse.success();
    }

    /**
     * 1.2 激活注册用户
     */
    @RequestMapping("enable")
    public RestResponse enable(String key){
        userService.enable(key);
        return RestResponse.success();
    }

    //------------------------2 登录: 返回生成的token --------------------------
    @PassToken
    @RequestMapping("auth")
    public RestResponse<SignInResponse> auth(@RequestBody User user){

        Pair<User, String> pair = userService.auth(user.getEmail(),user.getPassword());
        SignInResponse signInResponse =  new SignInResponse(pair.getKey(), pair.getValue());

        return RestResponse.success(signInResponse);
    }

    //------------------------2.2 鉴权：根据token返回用户信息 仅仅用于测试 --------------------------
    @RequestMapping("get")
    public RestResponse<User> getUser(String token){
        User finalUser = userService.getLoginedUserByToken(token);
        return RestResponse.success(finalUser);
    }

    //------------------------ log out --------------------------
    @PassToken
    @RequestMapping("logout")
    public RestResponse logout(String token){
        userService.invalidate(token);
        return RestResponse.success();
    }

    //------------------------ 仅仅用来测试分页功能 --------------------------
    @RequestMapping("page")
    public RestResponse<ListResponse<User>> page_test1(Integer limit, Integer offset) {
        PageParams pageParams = new PageParams();
        pageParams.setLimit(limit);
        pageParams.setOffset(offset);

        Pair<List<User>, Long> pair = userService.getPageUsers(pageParams);
        ListResponse<User> response = ListResponse.build(pair.getKey(), pair.getValue());

        return RestResponse.success(response);
    }

    //------------------------ 仅仅用来测试分页功能 2  --------------------------
    @RequestMapping("page2")
    public RestResponse<ListResponse<User>> page_test2(Integer pageIndex, Integer pageSize) {

        Pair<List<User>, Long> pair = userService.getPageUsers(PageParams.build(pageSize, pageIndex));
        ListResponse<User> response = ListResponse.build(pair.getKey(), pair.getValue());

        return RestResponse.success(response);
    }

    //------------------------ 更新用户  --------------------------
    @RequestMapping("update")
    public RestResponse<User> update(@RequestBody User user){
        User updateUser = userService.update(user);

        //以保密的形式返回给客户端
        updateUser.setPassword("***");
        updateUser.setSalt("***");

        return RestResponse.success(updateUser);
    }

    //------------------------ 重置密码  --------------------------
    //step 1: 发送重置密码的邮件
    @RequestMapping("resetNotify")
    public RestResponse<User> resetNotify(String email){

        String reset_url_suffix = "/user/rest";
        userService.resetNotify(email, reset_url_suffix);
        return RestResponse.success();
    }

    //step 2:
    @RequestMapping("reset")
    public RestResponse<User> reset(String key ,String password){
        User updateUser = userService.reset(key,password);
        return RestResponse.success(updateUser);
    }



//
//    @RequestMapping("getKeyEmail")
//    public RestResponse<String> getKeyEmail(String key){
//        String  email = userService.getResetKeyEmail(key);
//        return RestResponse.success(email);
//    }
//

}
