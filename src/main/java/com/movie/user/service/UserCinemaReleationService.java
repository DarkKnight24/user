package com.movie.user.service;

import java.util.List;

import com.movie.user.dto.UserCinemaReleationDto;
import com.movie.user.entity.UserCinemaReleation;
    /**
 * @作者 ：soul
 * @创建日期 ：Created in 2020/3/29 11:58
 * @描述：${description}
 */
public interface UserCinemaReleationService{


    int deleteByPrimaryKey(Long id);

    int insert(UserCinemaReleation record);

    int insertOrUpdate(UserCinemaReleation record);

    int insertOrUpdateSelective(UserCinemaReleation record);

    int insertSelective(UserCinemaReleation record);

    UserCinemaReleation selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserCinemaReleation record);

    int updateByPrimaryKey(UserCinemaReleation record);

    int updateBatch(List<UserCinemaReleation> list);

    int batchInsert(List<UserCinemaReleation> list);

    UserCinemaReleationDto selectByUserId(Long userId);

}
