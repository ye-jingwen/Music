package com.yeye.musicserver.service;

import com.yeye.musicserver.pojo.ListSong;

import java.util.List;

/**
 * @program: music-server
 * @description: 歌单歌曲业务逻辑接口
 * @author: YEYE
 * @create: 2021-12-13
 **/
public interface ListSongService {
    //判断是否增加成功
    public boolean insert(ListSong listSong);

    //判断是否修改成功
    public boolean update(ListSong listSong);

    //判断是否删除成功
    public boolean delete(Integer id);

    //判断是否根据歌曲id和歌单id删除成功
    public boolean deleteBySongIdAndSongListId(Integer songId, Integer songListId);

    //根据id查询整个对象
    public ListSong selectById(Integer id);

    //根据歌单id查询所有的歌曲
    public List<ListSong> selectListSongBySongListId(Integer songListId);

    //查询所有歌单里面的歌曲
    public List<ListSong> allListSong();
}
