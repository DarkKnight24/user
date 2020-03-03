package com.movie.user.service.impl;

import com.movie.base.dto.UserBaseDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.movie.user.entity.User;
import com.movie.user.dao.UserMapper;
import com.movie.user.service.UserService;
@Service
public class UserServiceImpl implements UserService{

    @Resource
    private UserMapper userMapper;

    @Override
    public int deleteByPrimaryKey(Long userId) {
        return userMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public int insert(User record) {
        return userMapper.insert(record);
    }

    @Override
    public int insertSelective(User record) {
        return userMapper.insertSelective(record);
    }

    @Override
    public UserBaseDto selectByPrimaryKey(Long userId) {
        UserBaseDto userBaseDto = new UserBaseDto();
        User user = userMapper.selectByPrimaryKey(userId);
        if(user!=null){
            BeanUtils.copyProperties(user,userBaseDto);
        }
        return userBaseDto;
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return userMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatchSelective(List<User> list) {
        return userMapper.updateBatchSelective(list);
    }

}
