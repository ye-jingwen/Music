package com.yeye.musicserver.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: music-server
 * @description: 歌曲
 * @author: YEYE
 * @create: 2021-12-10
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Song implements Serializable {
    private Integer id;   //主键
    private Integer singerId;   //歌手id
    private String name;   //歌名
    private String introduction;   //简介
    private Date createTime;   //创建时间
    private Date updateTime;   //更新时间
    private String pic;   //歌曲图片
    private String lyric;   //歌词
    private String url;   //歌曲地址
}
