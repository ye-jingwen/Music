package com.yeye.musicserver.dao;

import com.yeye.musicserver.pojo.ListSong;
import com.yeye.musicserver.pojo.Song;
import com.yeye.musicserver.pojo.SongList;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: music-server
 * @description: 歌单歌曲接口
 * @author: YEYE
 * @create: 2021-12-13
 **/
@Repository
public interface ListSongMapper {
    //增加
    public int insert(ListSong listSong);

    //修改
    public int update(ListSong listSong);

    //删除
    public int delete(Integer id);

    //根据歌曲id和歌单id删除
    public int deleteBySongIdAndSongListId(Integer songId, Integer songListId);

    //根据id查询整个对象
    public ListSong selectById(Integer id);

    //根据歌单id查询所有的歌曲
    public List<ListSong> selectListSongBySongListId(Integer songListId);

    //查询所有歌单里面的歌曲
    public List<ListSong> allListSong();
}
