package com.lr.sso.model.vo;

/**
 * 登录实例
 *
 * @author shijie.xu
 * @since 2019年02月13日
 */
public class UserLoginVO {
    private String userName;
    private String phone;
    private String email;
    private String passWord;
    private String isRemember;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getisRemember() {
        return isRemember;
    }

    public void setisRemember(String isRemember) {
        this.isRemember = isRemember;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserLoginVO{" + "userName='" + userName + '\'' + ", phone='" + phone + '\'' + ", email='" + email + '\'' + ", passWord='" + passWord + '\'' + ", isRemember='" + isRemember + '\'' + '}';
    }
}
