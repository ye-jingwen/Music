package com.yeye.musicserver.service;

import com.yeye.musicserver.pojo.SongList;

import java.util.List;

/**
 * @program: music-server
 * @description: 歌单业务逻辑接口
 * @author: YEYE
 * @create: 2021-12-13
 **/
public interface SongListService {
    //判断是否增加成功
    public boolean insert(SongList songList);

    //判断是否修改成功
    public boolean update(SongList songList);

    //判断是否删除成功
    public boolean delete(Integer id);

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
