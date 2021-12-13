package com.yeye.musicserver.service.impl;

import com.yeye.musicserver.dao.SongListMapper;
import com.yeye.musicserver.pojo.SongList;
import com.yeye.musicserver.service.SongListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: music-server
 * @description: 歌单业务逻辑实现类
 * @author: YEYE
 * @create: 2021-12-13
 **/
@Service
public class SongListServiceImpl implements SongListService {
    @Autowired
    private SongListMapper songListMapper;

    //判断是否增加成功
    @Override
    public boolean insert(SongList songList) {
        return songListMapper.insert(songList)>0;
    }

    //判断是否修改成功
    @Override
    public boolean update(SongList songList) {
        return songListMapper.update(songList)>0;
    }

    //判断是否删除成功
    @Override
    public boolean delete(Integer id) {
        return songListMapper.delete(id)>0;
    }

    //根据id查询整个对象
    @Override
    public SongList selectById(Integer id) {
        return songListMapper.selectById(id);
    }

    //根据标题精确查询歌单列表
    @Override
    public List<SongList> selectByTitle(String title) {
        return songListMapper.selectByTitle(title);
    }

    //根据标题模糊查询歌单列表
    @Override
    public List<SongList> selectLikeTitle(String title) {
        return songListMapper.selectLikeTitle(title);
    }

    //根据风格模糊查询歌单列表
    @Override
    public List<SongList> selectLikeStyle(String style) {
        return songListMapper.selectLikeStyle(style);
    }

    //查询所有歌单
    @Override
    public List<SongList> allSongList() {
        return songListMapper.allSongList();
    }
}
