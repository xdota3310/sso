package com.lr.sso.dao;

import com.lr.sso.model.dto.UserType;
import org.springframework.stereotype.Component;

@Component
public interface UserTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserType record);

    int insertSelective(UserType record);

    UserType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserType record);

    int updateByPrimaryKey(UserType record);
}