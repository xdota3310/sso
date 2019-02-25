package com.lr.sso.model;

import com.lr.sso.model.dto.UserInfo;

import java.util.List;

/**
 * 登录详情
 *
 * @author shijie.xu
 * @since 2019年02月18日
 */
public class UserLoginInfo<T> {
    protected UserInfo userInfo;
    protected String token;
    protected List<String> menus;
    protected List<T> router;

    public UserLoginInfo() {
    }

    public UserLoginInfo(UserInfo userInfo, String token) {
        this.userInfo = userInfo;
        this.token = token;
    }

    public UserLoginInfo(UserInfo userInfo, String token, List<String> menus, List<T> router) {
        this.userInfo = userInfo;
        this.token = token;
        this.menus = menus;
        this.router = router;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<String> getMenus() {
        return menus;
    }

    public void setMenus(List<String> menus) {
        this.menus = menus;
    }

    public List<T> getRouter() {
        return router;
    }

    public void setRouter(List<T> router) {
        this.router = router;
    }

    @Override
    public String toString() {
        return "UserLoginInfo{" + "userInfo=" + userInfo + ", token='" + token + '\'' + ", menus=" + menus + ", router=" + router + '}';
    }
}
