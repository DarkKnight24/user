package com.movie.user.entity;

import java.util.Date;
import lombok.Data;

/**
 * @作者 ：soul
 * @创建日期 ：Created in 2020/3/29 11:58
 * @描述：${description}
 */
@Data
public class UserCinemaReleation {
    /**
    * 主键ID
    */
    private Long id;

    /**
    * 电影院ID
    */
    private Long cinemaId;

    /**
    * 用户ID
    */
    private Long userId;

    /**
    * 删除标识
    */
    private Boolean deleteMark;

    /**
    * 创建时间
    */
    private Date createTime;
}