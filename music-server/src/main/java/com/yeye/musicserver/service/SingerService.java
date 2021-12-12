package com.yeye.musicserver.service;

import com.yeye.musicserver.pojo.Singer;

import java.util.List;

/**
 * @program: music-server
 * @description: 歌手业务逻辑接口
 * @author: YEYE
 * @create: 2021-12-07
 **/
public interface SingerService {
    //判断是否增加成功
    public boolean insert(Singer singer);

    //判断是否修改成功
    public boolean update(Singer singer);

    //判断是否删除成功
    public boolean delete(Integer id);

    //根据id查询歌手
    public Singer selectById(Integer id);

    //根据性别查询歌手
    public List<Singer> selectBySex(Integer sex);

    //根据歌手名字模糊查询列表
    public List<Singer> selectByName(String name);

    //查询所有歌手
    public List<Singer> allSinger();
}
