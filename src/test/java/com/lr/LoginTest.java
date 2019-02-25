package com.lr;

import com.lr.sso.model.dto.UserInfo;
import com.lr.sso.model.vo.UserLoginVO;
import com.lr.sso.service.LoginService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 请填写类注释
 *
 * @author shijie.xu
 * @since 2019年02月14日
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/spring-*.xml"})
public class LoginTest {
    @Autowired
    LoginService loginService;

    @Test
    public void doLoginTest() {
        UserLoginVO userLoginVO = new UserLoginVO();
        userLoginVO.setPhone("15071475909");
        UserInfo userInfo = loginService.getUserInfo(userLoginVO).getData();
        System.out.println(userInfo.toString());
    }
}
