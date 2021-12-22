package com.yeye.musicserver.service.impl;

import com.yeye.musicserver.dao.CollectMapper;
import com.yeye.musicserver.pojo.Collect;
import com.yeye.musicserver.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: music-server
 * @description: 收藏
 * @author: YEYE
 * @create: 2021-12-23
 **/
@Service
public class CollectServiceImpl implements CollectService {
    @Autowired
    private CollectMapper collectMapper;

    //判断是否增加成功
    @Override
    public boolean insert(Collect collect) {
        return collectMapper.insert(collect) > 0;
    }

    //判断是否删除成功
    @Override
    public boolean delete(Integer id) {
        return collectMapper.delete(id) > 0;
    }

    //根据用户id和歌曲id删除是否成功
    @Override
    public boolean deleteByUserIdAndSongId(Integer userId, Integer songId) {
        return collectMapper.deleteByUserIdAndSongId(userId, songId) > 0;
    }

    //查询某个用户的收藏列表
    @Override
    public List<Collect> selectByUserId(Integer userId) {
        return collectMapper.selectByUserId(userId);
    }

    //查询所有收藏
    @Override
    public List<Collect> allCollect() {
        return collectMapper.allCollect();
    }

    //查询某个用户是否已经收藏了某个歌曲
    @Override
    public boolean existSongId(Integer userId, Integer songId) {
        return collectMapper.existSongId(userId, songId) > 0;
    }
}
