package com.yeye.musicserver.service;

import com.yeye.musicserver.pojo.Comment;

import java.util.List;

/**
 * @program: music-server
 * @description: 评论业务逻辑接口
 * @author: YEYE
 * @create: 2021-12-22
 **/
public interface CommentService {
    //增加
    public boolean insert(Comment comment);

    //修改
    public boolean update(Comment comment);

    // 删除
    public boolean delete(Integer id);

    //根据主键查询整个对象
    public Comment selectById(Integer id);

    //查询所有评论
    public List<Comment> allComment();

    // 查询某个歌曲下的所有评论
    public List<Comment> selectBySongId(Integer songId);

    // 查询某个歌单下的所有评论
    public List<Comment> selectBySongListId(Integer songListId);
}
