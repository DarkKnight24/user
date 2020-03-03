package com.movie.user.service;

import java.util.List;

import com.movie.base.dto.UserBaseDto;
import com.movie.user.entity.User;
public interface UserService{


    int deleteByPrimaryKey(Long userId);

    int insert(User record);

    int insertSelective(User record);

    UserBaseDto selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int updateBatchSelective(List<User> list);

}
