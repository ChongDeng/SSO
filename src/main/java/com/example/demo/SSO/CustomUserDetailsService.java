package com.example.demo.SSO;


import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.cas.authentication.CasAssertionAuthenticationToken;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 该类：
 *   1 用于加载用户信息
 *   2 实现Spring Security框架的UserDetailsService接口，或者实现AuthenticationUserDetailsService接口
 *
 */
public class CustomUserDetailsService /*
	//方法1 实现UserDetailsService接口，实现loadUserByUsername方法
	implements UserDetailsService {
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("当前的用户名是："+username);
		//这里我为了方便，就直接返回一个用户信息，实际当中这里修改为查询数据库或者调用服务什么的来获取用户信息
		UserInfo userInfo = new UserInfo();
		userInfo.setUsername("admin");
		userInfo.setName("admin");
		Set<AuthorityInfo> authorities = new HashSet<AuthorityInfo>();
		AuthorityInfo authorityInfo = new AuthorityInfo("TEST");
		authorities.add(authorityInfo);
		userInfo.setAuthorities(authorities);
		return userInfo;
	}*/


        //方法 2 实现AuthenticationUserDetailsService，实现loadUserDetails方法
        implements AuthenticationUserDetailsService<CasAssertionAuthenticationToken> {

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserDetails(CasAssertionAuthenticationToken token) throws UsernameNotFoundException {
        System.out.println("当前的CAS用户名："+token.getName());

        Map<String, Object> UserAttributes = token.getAssertion().getPrincipal().getAttributes();
        if (UserAttributes != null) {

            String Email = String.valueOf(UserAttributes.get("email"));
            if (Email != null)
            {
                System.out.println("CAS 邮箱：" + Email);
            }

            String CommonName = String.valueOf(UserAttributes.get("commonName"));
            if (CommonName != null)
            {
                System.out.println("CommonName：" + CommonName);
            }

            User user = new User();
            user.setEmail(Email);
            user.setLogin_name(token.getName());
            userService.insertCasUser(user);
            String jwt = userService.onLogin(user);
            System.out.println("========= JWT toke is " + jwt);
        }

		/*这里我为了方便，就直接返回一个用户信息，实际当中这里修改为查询数据库或者
		  调用服务什么的来获取用户信息*/
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("admin");
        userInfo.setName("admin");

        Set<AuthorityInfo> authorities = new HashSet<AuthorityInfo>();
        AuthorityInfo authorityInfo = new AuthorityInfo("TEST");
        authorities.add(authorityInfo);

        userInfo.setAuthorities(authorities);

        return userInfo;
    }

}
