package com.lr.sso.service.impl;

import com.lr.common.base.ResultResponse;
import com.lr.sso.dao.UserMapper;
import com.lr.sso.model.dto.User;
import com.lr.sso.model.dto.UserInfo;
import com.lr.sso.model.vo.UserLoginVO;
import com.lr.sso.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 请填写类注释
 *
 * @author shijie.xu
 * @since 2019年02月13日
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    UserMapper userMapper;

    @Override
    public ResultResponse<UserInfo> getUserInfo(UserLoginVO userLoginVO) {
        User user = new User();
        String em = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
        String ph = "^[1][34578]\\d{9}$";
        if(userLoginVO != null) {
            String userName = userLoginVO.getUserName();
            user.setPassword(userLoginVO.getPassWord());
            if(userName != null && userName.matches(em)) {
                user.setEmail(userName);
            } else if(userName != null && userName.matches(ph)) {
                user.setPhone(userName);
            } else if(userName != null) {
                user.setUserName(userName);
            } else {
                return ResultResponse.createByError("-2", "账号不能为空！");
            }
            UserInfo userInfo = userMapper.selectByPrimaryKey(user);
            if(userInfo != null && userInfo.getPassword() != null && userLoginVO.getPassWord().trim().equals(userInfo.getPassword().trim())) {
                return ResultResponse.createBySuccess(userInfo);
            } else {
                return ResultResponse.createByError("-2", "用户名或密码错误");
            }
        } else {
            return ResultResponse.createByError("-1", "invalid login");
        }
    }
}
