package com.example.demo.interceptor;

import com.example.demo.annotation.PassToken;
import com.example.demo.annotation.UserLoginToken;
import com.example.demo.common.UserException;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

//该拦截器用来获取并验证token
public class AuthenticationInterceptor implements HandlerInterceptor {
    @Autowired
    UserService userService;
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) throws Exception {

        //step 1:  如果不是映射到方法, 直接通过
        if(!(object instanceof HandlerMethod)){
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod)object;
        Method method = handlerMethod.getMethod();
        //step 2: 检查是否有passtoken注释，有则跳过认证
        if (method.isAnnotationPresent(PassToken.class)) {
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()) {
                return true;
            }
        }

        //step 3: 检查有没有需要用户权限的注解
        //if (method.isAnnotationPresent(UserLoginToken.class)) {
        else{
            //UserLoginToken userLoginToken = method.getAnnotation(UserLoginToken.class);
            //if (userLoginToken.required()) { //开始执行认证

                //get token from header
                String token = httpServletRequest.getHeader("token");// 从 http 请求头中取出 token

                if (token == null) {
                    throw new UserException(UserException.Type.USER_NOT_LOGIN,"no token");
                }

                User user = userService.getLoginedUserByToken(token);
                if (user == null) {
                    throw new UserException(UserException.Type.USER_NOT_LOGIN,"user not exist, please sign in again.");
                }
            //}
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
