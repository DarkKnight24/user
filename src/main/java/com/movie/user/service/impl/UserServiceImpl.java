package com.movie.user.service.impl;

import com.movie.base.dto.UserBaseDto;
import com.movie.base.utils.BeanUtil;
import com.movie.base.utils.MD5Utils;
import com.movie.user.dao.UserMapper;
import com.movie.user.dto.UserLoginDto;
import com.movie.user.entity.User;
import com.movie.user.service.UserService;
import com.movie.file.utils.Utils;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Autowired
    Utils utils;

    @Override
    public int deleteByPrimaryKey(Long userId) {
        return userMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public int insert(User record) {
        record.setUserPwd(MD5Utils.MD5(record.getUserName() + record.getUserPwd()));
        int i;
        try{
            i = userMapper.insert(record);
        }catch (Exception e){
            return 0;
        }
        return i;
    }

    @Override
    public int insertSelective(User record) {
        return userMapper.insertSelective(record);
    }

    @Override
    public UserBaseDto selectByPrimaryKey(Long userId) {
        UserBaseDto userBaseDto = new UserBaseDto();
        User user = userMapper.selectByPrimaryKey(userId);
        if (user != null) {
            BeanUtil.copyProperties(user, userBaseDto);
        }
        return userBaseDto;
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public User updateByPrimaryKey(User record) {
        int i = userMapper.updateByPrimaryKeySelective(record);
        record.setUserHeadImg(utils.getFileUrl(record.getUserHeadImg()));
        return i>0?record:null;
    }

    @Override
    public int updateBatchSelective(List<User> list) {
        return userMapper.updateBatchSelective(list);
    }

    @Override
    public Object login(UserLoginDto userLoginDto) {
        User user = userMapper.selectByUserName(userLoginDto.getUserName());
        if (MD5Utils.MD5(userLoginDto.getUserName() + userLoginDto.getUserPwd()).equals(user.getUserPwd())) {
            UserBaseDto userBaseDto = new UserBaseDto();
            BeanUtil.copyProperties(user,userBaseDto);
            userBaseDto.setUserHeadImg(utils.getFileUrl(userBaseDto.getUserHeadImg()));
            return userBaseDto;
        }
        return false;
    }
}
