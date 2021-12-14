package com.yeye.musicserver.service;

import com.yeye.musicserver.pojo.Consumer;
import com.yeye.musicserver.pojo.Singer;

import java.util.List;

/**
 * @program: music-server
 * @description: 用户业务逻辑接口
 * @author: YEYE
 * @create: 2021-12-14
 **/
public interface ConsumerService {
    //判断是否增加成功
    public boolean insert(Consumer consumer);

    //判断是否修改成功
    public boolean update(Consumer consumer);

    //判断是否删除成功
    public boolean delete(Integer id);

    //根据id查询用户
    public Singer selectById(Integer id);

    //根据用户名查询
    public Consumer selectByUsername(String username);

    //查询所有用户
    public List<Consumer> allConsumer();

    //验证密码是否正确
    public boolean verifyPassword(String username,String password);
}
