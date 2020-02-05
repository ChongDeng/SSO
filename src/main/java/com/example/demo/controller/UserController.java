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

    //----------------------注册----------------------------------
    @RequestMapping("add")
    public RestResponse<User> add(@RequestBody User user){
        userService.addAccount(user);
        return RestResponse.success();
    }
}
