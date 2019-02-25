package com.lr.sso.dao;

import com.lr.sso.model.dto.User;
import com.lr.sso.model.dto.UserInfo;
import org.springframework.stereotype.Component;

@Component
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    UserInfo selectByPrimaryKey(User record);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}