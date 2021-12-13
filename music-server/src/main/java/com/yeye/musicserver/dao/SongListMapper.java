package com.yeye.musicserver.dao;

import com.yeye.musicserver.pojo.SongList;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: music-server
 * @description: 歌单接口
 * @author: YEYE
 * @create: 2021-12-13
 **/
@Repository
public interface SongListMapper {
    //增加
    public int insert(SongList songList);

    //修改
    public int update(SongList songList);

    //删除
    public int delete(Integer id);

    //根据id查询整个对象
    public SongList selectById(Integer id);

    //根据标题精确查询歌单列表
    public List<SongList> selectByTitle(String title);

    //根据标题模糊查询歌单列表
    public List<SongList> selectLikeTitle(String title);

    //根据风格模糊查询歌单列表
    public List<SongList> selectLikeStyle(String style);

    //查询所有歌单
    public List<SongList> allSongList();
}
