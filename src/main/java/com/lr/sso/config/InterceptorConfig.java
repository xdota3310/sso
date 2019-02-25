package com.lr.sso.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

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
        response.setHeader("Access-Control-Allow-Origin", "*");

        response.setHeader("Access-Control-Allow-Headers", "Content-Type" );

        response.setHeader("Access-Control-Allow-Methods","PUT,POST,GET,DELETE,OPTIONS");

        response.setHeader("X-Powered-By","Jetty");

        String method= request.getMethod();

        LOGGER.warn(method);
        return true;
    }
}
