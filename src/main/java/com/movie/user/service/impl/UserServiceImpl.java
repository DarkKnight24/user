package com.movie.user.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.movie.base.dto.UserBaseDto;
import com.movie.base.utils.BeanUtil;
import com.movie.base.utils.MD5Utils;
import com.movie.base.utils.Page;
import com.movie.base.utils.Util;
import com.movie.file.utils.Utils;
import com.movie.user.dao.UserMapper;
import com.movie.user.dto.UserCinemaDto;
import com.movie.user.dto.UserCinemaReleationDto;
import com.movie.user.dto.UserLoginDto;
import com.movie.user.entity.User;
import com.movie.user.param.UserSelectParam;
import com.movie.user.service.UserCinemaReleationService;
import com.movie.user.service.UserService;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {
    
    @Resource
    private UserMapper userMapper;
    
    @Autowired
    private Utils utils;
    
    @Autowired
    private UserCinemaReleationService userCinemaReleationService;
    
    @Override
    public int deleteByPrimaryKey(Long userId) {
        return userMapper.deleteByPrimaryKey(userId);
    }
    
    @Override
    public int insert(User record) {
        record.setUserPwd(MD5Utils.MD5(record.getUserName() + record.getUserPwd()));
        int i;
        try {
            i = userMapper.insert(record);
        }
        catch (Exception e) {
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
        return i > 0 ? record : null;
    }
    
    @Override
    public int updateBatchSelective(List<User> list) {
        return userMapper.updateBatchSelective(list);
    }
    
    @Override
    public Object login(UserLoginDto userLoginDto) {
        User user = userMapper.selectByUserName(userLoginDto.getUserName());
        if (user == null) {
            return false;
        }
        if (MD5Utils.MD5(userLoginDto.getUserName() + userLoginDto.getUserPwd()).equals(user.getUserPwd())) {
            UserBaseDto userBaseDto = new UserBaseDto();
            BeanUtil.copyProperties(user, userBaseDto);
            userBaseDto.setUserHeadImg(utils.getFileUrl(userBaseDto.getUserHeadImg()));
            UserCinemaDto userCinemaDto = new UserCinemaDto();
            BeanUtil.copyProperties(userBaseDto, userCinemaDto);
            if (userBaseDto.getUserRole() == 2) {
                UserCinemaReleationDto userCinemaReleationDto =
                    userCinemaReleationService.selectByUserId(userBaseDto.getUserId());
                BeanUtil.copyProperties(userCinemaReleationDto, userCinemaDto);
            }
            return userCinemaDto;
        }
        return false;
    }
    
    @Override
    public Page findByParam(UserSelectParam param, Page page) {
        PageHelper.startPage(page);
        List<UserCinemaDto> userBaseDtos = userMapper.findByParam(param);
        userBaseDtos.forEach(p -> {
            if (p.getUserRole() == 2) {
                UserCinemaReleationDto userCinemaReleationDto =
                    userCinemaReleationService.selectByUserId(p.getUserId());
                if (Util.isEmpty(userCinemaReleationDto)) {
                    return;
                }
                BeanUtil.copyProperties(userCinemaReleationDto, p);
            }
        });
        PageInfo<UserCinemaDto> pageInfo = new PageInfo<>(userBaseDtos);
        BeanUtil.copyProperties(pageInfo, page);
        page.setList(userBaseDtos);
        return page;
    }
}
