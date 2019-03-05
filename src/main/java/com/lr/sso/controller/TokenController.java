package com.lr.sso.controller;

import com.lr.common.base.ResultResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * token验证接口
 *
 * @author shijie.xu
 * @since 2019年03月05日
 */
@Controller
@RequestMapping("/token")
public class TokenController {

    @RequestMapping("/tokenCheck")
    public ResultResponse tokenCheck(HttpServletRequest request, @RequestParam String token) {

        return null;
    }
}
