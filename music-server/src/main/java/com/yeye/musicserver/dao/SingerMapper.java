package com.yeye.musicserver.dao;

import com.yeye.musicserver.pojo.Singer;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: music-server
 * @description: 歌手接口
 * @author: YEYE
 * @create: 2021-12-06
 **/
@Repository
public interface SingerMapper {
    //增加
    public int insert(Singer singer);

    //修改
    public int update(Singer singer);

    //删除
    public int delete(Integer id);

    //根据id查询歌手
    public Singer selectById(Integer id);

    //根据性别查询歌手
    public List<Singer> selectBySex(Integer sex);

    //根据歌手名字模糊查询列表
    public List<Singer> selectByName(String name);

    //查询所有歌手
    public List<Singer> allSinger();
}
