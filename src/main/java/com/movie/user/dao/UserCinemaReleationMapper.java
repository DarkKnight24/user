package com.movie.user.dao;

import com.movie.user.dto.UserCinemaReleationDto;
import com.movie.user.entity.UserCinemaReleation;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @作者 ：soul
 * @创建日期 ：Created in 2020/3/29 11:58
 * @描述：${description}
 */
@Mapper
public interface UserCinemaReleationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserCinemaReleation record);

    int insertOrUpdate(UserCinemaReleation record);

    int insertOrUpdateSelective(UserCinemaReleation record);

    int insertSelective(UserCinemaReleation record);

    UserCinemaReleation selectByPrimaryKey(Long id);

    UserCinemaReleationDto selectByUserId(Long userId);

    int updateByPrimaryKeySelective(UserCinemaReleation record);

    int updateByPrimaryKey(UserCinemaReleation record);

    int updateBatch(List<UserCinemaReleation> list);

    int batchInsert(@Param("list") List<UserCinemaReleation> list);
}