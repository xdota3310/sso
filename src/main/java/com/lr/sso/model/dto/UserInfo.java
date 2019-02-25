package com.lr.sso.model.dto;

import java.io.Serializable;

/**
 * 用户详情类
 *
 * @author shijie.xu
 * @since 2019年02月14日
 */
public class UserInfo extends User implements Serializable {

    protected String typeName;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }


    @Override
    public String toString() {
        return "UserInfo{" + "typeName='" + typeName + '\'' + ", id=" + id + ", userName='" + userName + '\'' + ", createTime=" + createTime + ", modifyTime=" + modifyTime + ", phone='" + phone + '\'' + ", qq='" + qq + '\'' + ", weChat='" + weChat + '\'' + ", password='" + password + '\'' + ", email='" + email + '\'' + ", type=" + type + '}';
    }
}
