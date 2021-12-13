package com.yeye.musicserver.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @program: music-server
 * @description: 歌单
 * @author: YEYE
 * @create: 2021-12-13
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SongList implements Serializable {
    private Integer id; //主键
    private String title;   //歌单标题
    private String pic;   //歌单图片
    private String introduction;   //简介
    private String style;   //风格
}
