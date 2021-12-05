package com.yeye.musicserver.dao;

import org.springframework.stereotype.Repository;

/**
 * @program: music-server
 * @description: 管理员接口
 * @author: YEYE
 * @create: 2021-12-05
 **/
@Repository
public interface AdminMapper {
    //验证密码是否正确
    public int verifyPassword(String username, String password);
}
