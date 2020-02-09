package com.example.demo.SSO;


import org.springframework.security.core.GrantedAuthority;

/**
 *  AthorityInfo类:
 *    1 用于加载当前登录用户的权限信息
 *    2 实现Spring Security框架的GrantedAuthority接口
 */
public class AuthorityInfo implements GrantedAuthority {
    private static final long serialVersionUID = -175781100474818800L;

    /**
     * 权限CODE
     */
    private String authority;

    public AuthorityInfo(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

}
