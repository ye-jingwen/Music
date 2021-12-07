package com.yeye.musicserver.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: music-server
 * @description: 歌手
 * @author: YEYE
 * @create: 2021-12-06
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Singer implements Serializable {
    private Integer id;   //主键
    private String name;   //账号
    private Byte sex;   //性别
    private String pic;   //头像
    private Date birth;   //生日
    private String location;   //地区
    private String introduction;   //简介
}
