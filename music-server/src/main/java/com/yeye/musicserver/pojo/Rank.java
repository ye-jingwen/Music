package com.yeye.musicserver.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @program: music-server
 * @description: 评价
 * @author: YEYE
 * @create: 2021-12-19
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rank {
    private Integer id;   //主键
    private Integer songListId;   //歌单id
    private Integer consumerId;   //用户id
    private Integer score;   //评分
}
