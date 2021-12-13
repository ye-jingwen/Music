package com.yeye.musicserver.service.impl;

import com.yeye.musicserver.dao.ListSongMapper;
import com.yeye.musicserver.pojo.ListSong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: music-server
 * @description: 歌单歌曲业务逻辑实现类
 * @author: YEYE
 * @create: 2021-12-14
 **/
@Service
public class ListSongServiceImpl implements com.yeye.musicserver.service.ListSongService {
    @Autowired
    private ListSongMapper listSongMapper;

    //判断是否增加成功
    @Override
    public boolean insert(ListSong listSong) {
        return listSongMapper.insert(listSong) > 0;
    }

    //判断是否修改成功
    @Override
    public boolean update(ListSong listSong) {
        return listSongMapper.update(listSong) > 0;
    }

    //判断是否删除成功
    @Override
    public boolean delete(Integer id) {
        return listSongMapper.delete(id) > 0;
    }

    //判断是否根据歌曲id和歌单id删除成功
    @Override
    public boolean deleteBySongIdAndSongListId(Integer songId, Integer songListId) {
        return listSongMapper.deleteBySongIdAndSongListId(songId, songListId) > 0;
    }

    //根据id查询整个对象
    @Override
    public ListSong selectById(Integer id) {
        return listSongMapper.selectById(id);
    }

    //根据歌单id查询所有的歌曲
    @Override
    public List<ListSong> selectListSongBySongListId(Integer songListId) {
        return listSongMapper.selectListSongBySongListId(songListId);
    }

    //查询所有歌单里面的歌曲
    @Override
    public List<ListSong> allListSong() {
        return listSongMapper.allListSong();
    }
}
