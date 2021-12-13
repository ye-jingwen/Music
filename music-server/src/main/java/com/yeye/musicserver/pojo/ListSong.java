package com.yeye.musicserver.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @program: music-server
 * @description: 歌单歌曲
 * @author: YEYE
 * @create: 2021-12-13
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListSong implements Serializable {
    private Integer id;   //主键
    private Integer songId;   //歌曲id
    private Integer songListId;   //歌单id
}
