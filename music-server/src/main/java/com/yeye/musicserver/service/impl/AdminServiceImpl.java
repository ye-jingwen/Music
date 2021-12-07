package com.yeye.musicserver.service.impl;

import com.yeye.musicserver.dao.AdminMapper;
import com.yeye.musicserver.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: music-server
 * @description: 管理员业务逻辑实现类
 * @author: YEYE
 * @create: 2021-12-05
 **/
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    //验证密码是否正确
    @Override
    public boolean verifyPassword(String username, String password) {
        return adminMapper.verifyPassword(username, password) > 0;
    }
}
