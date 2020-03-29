package com.movie.user.service.impl;

import com.movie.user.dto.UserCinemaReleationDto;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.movie.user.dao.UserCinemaReleationMapper;
import com.movie.user.entity.UserCinemaReleation;
import com.movie.user.service.UserCinemaReleationService;
/**
 * @作者 ：soul
 * @创建日期 ：Created in 2020/3/29 11:58
 * @描述：${description}
 */
@Service
public class UserCinemaReleationServiceImpl implements UserCinemaReleationService{

    @Resource
    private UserCinemaReleationMapper userCinemaReleationMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return userCinemaReleationMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(UserCinemaReleation record) {
        return userCinemaReleationMapper.insert(record);
    }

    @Override
    public int insertOrUpdate(UserCinemaReleation record) {
        return userCinemaReleationMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(UserCinemaReleation record) {
        return userCinemaReleationMapper.insertOrUpdateSelective(record);
    }

    @Override
    public int insertSelective(UserCinemaReleation record) {
        return userCinemaReleationMapper.insertSelective(record);
    }

    @Override
    public UserCinemaReleation selectByPrimaryKey(Long id) {
        return userCinemaReleationMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(UserCinemaReleation record) {
        return userCinemaReleationMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UserCinemaReleation record) {
        return userCinemaReleationMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<UserCinemaReleation> list) {
        return userCinemaReleationMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<UserCinemaReleation> list) {
        return userCinemaReleationMapper.batchInsert(list);
    }

    @Override
    public UserCinemaReleationDto selectByUserId(Long userId) {
        return userCinemaReleationMapper.selectByUserId(userId);
    }
}
