package com.yeye.musicserver.service.impl;

import com.yeye.musicserver.dao.ConsumerMapper;
import com.yeye.musicserver.pojo.Consumer;
import com.yeye.musicserver.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: music-server
 * @description: 用户业务逻辑实现类
 * @author: YEYE
 * @create: 2021-12-14
 **/
@Service
public class ConsumerServiceImpl implements ConsumerService {
    @Autowired
    private ConsumerMapper consumerMapper;

    //判断是否增加成功
    @Override
    public boolean insert(Consumer consumer) {
        return consumerMapper.insert(consumer) > 0;
    }

    //判断是否修改成功
    @Override
    public boolean update(Consumer consumer) {
        return consumerMapper.update(consumer) > 0;
    }

    //判断是否删除成功
    @Override
    public boolean delete(Integer id) {
        return consumerMapper.delete(id) > 0;
    }

    //根据id查询用户
    @Override
    public Consumer selectById(Integer id) {
        return consumerMapper.selectById(id);
    }

    //根据用户名查询
    @Override
    public Consumer selectByUsername(String username) {
        return consumerMapper.selectByUsername(username);
    }

    //查询所有用户
    @Override
    public List<Consumer> allConsumer() {
        return consumerMapper.allConsumer();
    }

    //验证密码是否正确
    @Override
    public boolean verifyPassword(String username, String password) {
        return consumerMapper.verifyPassword(username, password) > 0;
    }
}
