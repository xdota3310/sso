package com.lr.sso.controller;

import com.lr.common.base.ResultResponse;
import com.lr.common.constant.RredisConstant;
import com.lr.common.model.UserToken;
import com.lr.common.utils.JwtUtil;
import com.lr.sso.constant.SsoConstant;
import com.lr.sso.model.UserLoginInfo;
import com.lr.sso.model.dto.UserInfo;
import com.lr.sso.model.vo.UserLoginVO;
import com.lr.sso.service.LoginService;
import com.lr.sso.service.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录接口
 *
 * @author shijie.xu
 * @since 2019年02月13日
 */
@Controller
@RequestMapping("/Login")
public class LoginController {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    LoginService loginService;
    @Autowired
    RedisService redisService;

    @RequestMapping("/doLogin")
    @ResponseBody
    public ResultResponse doLogin(HttpServletRequest request, HttpServletResponse response,
                                  RedirectAttributes redirectAttributes, @RequestBody UserLoginVO userLoginVO) {
        String token = "";
        if(userLoginVO != null) {
            boolean isRem = "on".equals(userLoginVO.getisRemember());
            ResultResponse<UserInfo> res = loginService.getUserInfo(userLoginVO);
            if(!ResultResponse.SUCCESS.equals(res.getCode())) {
                return res;
            }
            UserInfo userInfo = res.getData();
            UserToken userToken = new UserToken(userInfo.getUserName(), userInfo.getId().toString(), SsoConstant.redisExpireMinite);

            try {
                token = JwtUtil.generateToken(userToken);
            } catch (Exception e) {
                LOGGER.error("userToken: " + userToken.toString());
                LOGGER.error(e.toString());
                return ResultResponse.createByError("-1", "登录失败！");
            }
            redisService.put(userInfo.getUserName(), token);
            redisService.put(RredisConstant.USER_INFO_PREFIX + userInfo.getUserName(), userInfo);

            return ResultResponse.createBySuccess(new UserLoginInfo(userInfo, token));
        } else {
            return ResultResponse.createByError("-1", "登录失败！");
        }
    }

    @RequestMapping(value = "/test")
    @ResponseBody
    public ResultResponse test() {
        return ResultResponse.createBySuccess("123131321321");
    }
}
