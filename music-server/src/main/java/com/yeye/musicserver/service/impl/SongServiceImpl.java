package com.yeye.musicserver.service.impl;

import com.yeye.musicserver.dao.SongMapper;
import com.yeye.musicserver.pojo.Singer;
import com.yeye.musicserver.pojo.Song;
import com.yeye.musicserver.service.SingerService;
import com.yeye.musicserver.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: music-server
 * @description: 歌曲业务逻辑实现类
 * @author: YEYE
 * @create: 2021-12-10
 **/
@Service
public class SongServiceImpl implements SongService {
    @Autowired
    private SongMapper songMapper;

    //判断是否增加成功
    @Override
    public boolean insert(Song song) {
        return songMapper.insert(song) > 0;
    }

    //判断是否修改成功
    @Override
    public boolean update(Song song) {
        return songMapper.update(song) > 0;
    }

    //判断是否删除成功
    @Override
    public boolean delete(Integer id) {
        return songMapper.delete(id) > 0;
    }

    //根据id查询歌曲
    @Override
    public Song selectById(Integer id) {
        return songMapper.selectById(id);
    }

    //根据歌手id查询歌曲
    @Override
    public List<Song> selectBySingerId(Integer singerId) {
        return songMapper.selectBySingerId(singerId);
    }

    //根据歌曲名字查询列表
    @Override
    public List<Song> selectByName(String name) {
        return songMapper.selectByName(name);
    }

    //根据歌曲名字模糊查询列表
    @Override
    public List<Song> selectLikeName(String name) {
        return songMapper.selectLikeName("%"+name+"%");
    }

    //查询所有歌曲
    @Override
    public List<Song> allSong() {
        return songMapper.allSong();
    }
}
