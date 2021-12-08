package com.yeye.musicserver.service.impl;

import com.yeye.musicserver.dao.SingerMapper;
import com.yeye.musicserver.pojo.Singer;
import com.yeye.musicserver.service.SingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: music-server
 * @description: 歌手业务逻辑实现类
 * @author: YEYE
 * @create: 2021-12-07
 **/
@Service
public class SingerServiceImpl implements SingerService {
    @Autowired
    private SingerMapper singerMapper;

    //判断是否增加成功
    @Override
    public boolean insert(Singer singer) {
        return singerMapper.insert(singer) > 0;
    }

    //判断是否修改成功
    @Override
    public boolean update(Singer singer) {
        return singerMapper.update(singer) > 0;
    }

    //判断是否删除成功
    @Override
    public boolean delete(Integer id) {
        return singerMapper.delete(id) > 0;
    }

    //根据id查询歌手
    @Override
    public Singer selectById(Integer id) {
        return singerMapper.selectById(id);
    }

    //根据性别查询歌手
    @Override
    public List<Singer> selectBySex(Integer sex) {
        return singerMapper.selectBySex(sex);
    }

    //根据歌手名字模糊查询列表
    @Override
    public List<Singer> selectByName(String name) {
        return singerMapper.selectByName(name);
    }

    //查询所有歌手
    @Override
    public List<Singer> allSinger() {
        return singerMapper.allSinger();
    }
}
