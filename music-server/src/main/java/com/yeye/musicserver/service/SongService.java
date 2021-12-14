package com.yeye.musicserver.service;

import com.yeye.musicserver.pojo.Song;

import java.util.List;

/**
 * @program: music-server
 * @description: 歌曲业务逻辑接口
 * @author: YEYE
 * @create: 2021-12-10
 **/
public interface SongService {
    //判断是否增加成功
    public boolean insert(Song song);

    //判断是否修改成功
    public boolean update(Song song);

    //判断是否删除成功
    public boolean delete(Integer id);

    //根据id查询歌曲
    public Song selectById(Integer id);

    //根据歌手id查询歌曲
    public List<Song> selectBySingerId(Integer singerId);

    //根据歌曲名字查询列表
    public List<Song> selectByName(String name);

    //根据歌曲名字模糊查询列表
    public List<Song> selectLikeName(String name);

    //查询所有歌曲
    public List<Song> allSong();
}
