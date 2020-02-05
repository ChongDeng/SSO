package com.example.demo.controller;

import com.example.demo.common.RestResponse;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    //----------------------1 注册----------------------------------
    @RequestMapping("add")
    public RestResponse<User> add(@RequestBody User user){
        userService.addAccount(user);
        return RestResponse.success();
    }

    /**
     * 1.2 激活注册用户
     */
    @RequestMapping("enable")
    public RestResponse<Object> enable(String key){
        userService.enable(key);
        return RestResponse.success();
    }

    //------------------------2 登录: 返回生成的token --------------------------
    @RequestMapping("auth")
    public RestResponse<User> auth(@RequestBody User user){
        User finalUser = userService.auth(user.getEmail(),user.getPassword());
        return RestResponse.success(finalUser);
    }

    //------------------------2.2 鉴权：根据token返回用户信息 --------------------------
    @RequestMapping("get")
    public RestResponse<User> getUser(String token){
        User finalUser = userService.getLoginedUserByToken(token);
        return RestResponse.success(finalUser);
    }

    //------------------------ log out --------------------------
    @RequestMapping("logout")
    public RestResponse<Object> logout(String token){
        userService.invalidate(token);
        return RestResponse.success();
    }

//    @RequestMapping("update")
//    public RestResponse<User> update(@RequestBody User user){
//        User updateUser = userService.updateUser(user);
//        return RestResponse.success(updateUser);
//    }
//
//    @RequestMapping("reset")
//    public RestResponse<User> reset(String key ,String password){
//        User updateUser = userService.reset(key,password);
//        return RestResponse.success(updateUser);
//    }
//
//    @RequestMapping("getKeyEmail")
//    public RestResponse<String> getKeyEmail(String key){
//        String  email = userService.getResetKeyEmail(key);
//        return RestResponse.success(email);
//    }
//
//    @RequestMapping("resetNotify")
//    public RestResponse<User> resetNotify(String email,String url){
//        userService.resetNotify(email,url);
//        return RestResponse.success();
//    }
}
