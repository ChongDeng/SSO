package com.example.demo.common;

import com.example.demo.entity.User;

public class SignInResponse {

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    private String token;
    private User user;

    public SignInResponse() {}

    public SignInResponse(User user, String token) {
        this.token = token;
        this.user = user;
    }


}
