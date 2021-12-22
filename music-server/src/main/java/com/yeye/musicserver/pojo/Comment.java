package com.yeye.musicserver.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: music-server
 * @description: 评论
 * @author: YEYE
 * @create: 2021-12-21
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment implements Serializable {
    private Integer id;   //主键
    private Integer userId;   //用户id
    private Byte type;   //评论类型（0歌曲1歌单）
    private Integer songId;   //歌曲id
    private Integer songListId;   //歌单i
    private String content;   //评论内容
    private Date createTime;   //评论时间
    private Integer up;   //评论点赞数
}
