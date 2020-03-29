package com.movie.user.dto;

import com.movie.base.dto.UserBaseDto;
import lombok.Data;

/**
 * @作者 ：soul
 * @创建日期 ：Created in 2020/3/29 11:53
 * @描述：
 */
@Data
public class UserCinemaDto extends UserBaseDto {

    private Long cinemaTypeId;
    private String cinemaType;
}
