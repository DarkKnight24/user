package com.movie.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.movie.user.dto.UserCinemaDto;
import com.movie.user.entity.User;
import com.movie.user.param.UserSelectParam;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Long userId);
    
    int insert(User record);
    
    int insertSelective(User record);
    
    User selectByPrimaryKey(Long userId);
    
    int updateByPrimaryKeySelective(User record);
    
    int updateByPrimaryKey(User record);
    
    int updateBatchSelective(List<User> list);
    
    User selectByUserName(String userName);
    
    List<UserCinemaDto> findByParam(UserSelectParam param);
}