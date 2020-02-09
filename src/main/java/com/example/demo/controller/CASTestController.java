package com.example.demo.controller;


import com.example.demo.annotation.PassToken;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("cas")
public class CASTestController {

    @PassToken
    @RequestMapping("/")
    public String index() {
        return "访问了首页哦";
    }

    @RequestMapping("/hello")
    public String hello() {
        return "已登录";
    }

    @PassToken
    @RequestMapping("/logout")
    public String logout() {
        return "已退出";
    }

//    @PreAuthorize("hasAuthority('TEST')")//有TEST权限的才能访问
//    @RequestMapping("/security")
//    public String security() {
//        return "hello world security";
//    }
//
//    @PreAuthorize("hasAuthority('ADMIN')")//必须要有ADMIN权限的才能访问
//    @RequestMapping("/authorize")
//    public String authorize() {
//        return "有权限访问";
//    }

}
