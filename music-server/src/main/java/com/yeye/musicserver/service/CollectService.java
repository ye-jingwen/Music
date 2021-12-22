package com.yeye.musicserver.service;

import com.yeye.musicserver.pojo.Collect;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: music-server
 * @description: 收藏
 * @author: YEYE
 * @create: 2021-12-23
 **/
public interface CollectService {
    //判断是否增加成功
    public boolean insert(Collect collect);

    //判断是否删除成功
    public boolean delete(Integer id);

    //根据用户id和歌曲id删除
    public boolean deleteByUserIdAndSongId(Integer userId, Integer songId);

    //查询某个用户的收藏列表
    public List<Collect> selectByUserId(Integer userId);

    //查询所有收藏
    public List<Collect> allCollect();

    //查询某个用户是否已经收藏了某个歌曲
    public boolean existSongId(@Param("userId") Integer userId, @Param("songId") Integer songId);
}
