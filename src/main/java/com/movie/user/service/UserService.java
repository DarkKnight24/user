package com.movie.user.service;

import java.util.List;

import com.movie.base.dto.UserBaseDto;
import com.movie.base.utils.Page;
import com.movie.user.dto.UserLoginDto;
import com.movie.user.entity.User;
import com.movie.user.param.UserSelectParam;

public interface UserService {
    
    int deleteByPrimaryKey(Long userId);
    
    int insert(User record);
    
    int insertSelective(User record);
    
    UserBaseDto selectByPrimaryKey(Long userId);
    
    int updateByPrimaryKeySelective(User record);
    
    User updateByPrimaryKey(User record);
    
    int updateBatchSelective(List<User> list);
    
    Object login(UserLoginDto userLoginDto);
    
    Page findByParam(UserSelectParam param, Page page);
}
