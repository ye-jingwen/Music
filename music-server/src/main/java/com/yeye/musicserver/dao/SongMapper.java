package com.yeye.musicserver.dao;

import com.yeye.musicserver.pojo.Singer;
import com.yeye.musicserver.pojo.Song;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: music-server
 * @description: 歌曲接口
 * @author: YEYE
 * @create: 2021-12-10
 **/
@Repository
public interface SongMapper {
    //增加
    public int insert(Song song);

    //修改
    public int update(Song song);

    //删除
    public int delete(Integer id);

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
