package com.yeye.musicserver.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: music-server
 * @description: 收藏
 * @author: YEYE
 * @create: 2021-12-23
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Collect implements Serializable {
    private Integer id;   //主键
    private Integer userId;   //用户id
    private Byte type;   //收藏类型（0歌曲1歌单）
    private Integer songId;   //歌曲id
    private Integer songListId;   //歌单id
    private Date createTime;   //收藏时间
}
