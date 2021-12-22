package com.yeye.musicserver.dao;

import com.yeye.musicserver.pojo.Consumer;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: music-server
 * @description: 用户接口
 * @author: YEYE
 * @create: 2021-12-14
 **/
@Repository
public interface ConsumerMapper {
    //增加
    public int insert(Consumer consumer);

    //修改
    public int update(Consumer consumer);

    //删除
    public int delete(Integer id);

    //根据id查询用户
    public Consumer selectById(Integer id);

    //根据用户名查询
    public Consumer selectByUsername(String username);

    //查询所有用户
    public List<Consumer> allConsumer();

    //验证密码
    public int verifyPassword(String username,String password);
}
