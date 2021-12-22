package com.yeye.musicserver.service.impl;

import com.yeye.musicserver.dao.CommentMapper;
import com.yeye.musicserver.pojo.Comment;
import com.yeye.musicserver.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: music-server
 * @description: 评论业务逻辑实现类
 * @author: YEYE
 * @create: 2021-12-22
 **/
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;

    //判断是否增加成功
    @Override
    public boolean insert(Comment comment) {
        return commentMapper.insert(comment) > 0;
    }

    //判断是否修改成功
    @Override
    public boolean update(Comment comment) {
        return commentMapper.update(comment) > 0;
    }

    //判断是否删除成功
    @Override
    public boolean delete(Integer id) {
        return commentMapper.delete(id) > 0;
    }

    //根据主键查询整个对象
    @Override
    public Comment selectById(Integer id) {
        return commentMapper.selectById(id);
    }

    //查询某个歌曲下的所有评论
    @Override
    public List<Comment> selectBySongId(Integer songId) {
        return commentMapper.selectBySongId(songId);
    }

    //查询某个歌单下的所有评论
    @Override
    public List<Comment> selectBySongListId(Integer songListId) {
        return commentMapper.selectBySongListId(songListId);
    }

    //查询所有评论
    @Override
    public List<Comment> allComment() {
        return commentMapper.allComment();
    }
}
