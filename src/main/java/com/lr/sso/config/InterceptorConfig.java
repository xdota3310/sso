package com.lr.sso.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 请求拦截器
 *
 * @author shijie.xu
 * @since 2019年01月17日
 */
public class InterceptorConfig implements HandlerInterceptor {
    private static final Logger LOGGER = LoggerFactory.getLogger(InterceptorConfig.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setHeader("Access-Control-Allow-Origin", "http://www.sso.sjsite.com");

        response.setHeader("Access-Control-Allow-Headers", "Content-Type,Access-Control-Allow-Origin,request-ajax,Access-Control-Allow-Credentials");

        response.setHeader("Access-Control-Allow-Credentials","true");

        response.setHeader("Access-Control-Allow-Methods", "PUT,POST,GET,DELETE,OPTIONS");

        response.setHeader("X-Powered-By", "Jetty");

        String method = request.getMethod();

        Cookie[] cookies = request.getCookies();

        LOGGER.warn(method);
        if(cookies != null){
            LOGGER.error(cookies.toString());
        }
        return true;
    }
}
