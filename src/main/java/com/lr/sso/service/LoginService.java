package com.lr.sso.service;

import com.lr.common.base.ResultResponse;
import com.lr.sso.model.dto.UserInfo;
import com.lr.sso.model.vo.UserLoginVO;

/**
 * 登录处理服务
 *
 * @author shijie.xu
 * @since 2019年02月13日
 */
public interface LoginService {
    ResultResponse<UserInfo> getUserInfo(UserLoginVO userLoginVO);
}
