package com.movie.user.dto;

import lombok.Data;

/**
 * @作者 ：soul
 * @创建日期 ：Created in 2020/3/29 11:59
 * @描述：
 */
@Data
public class UserCinemaReleationDto {

    private Long cinemaTypeId;

    private String cinemaType;

    private Long userId;

    private String userName;
}
