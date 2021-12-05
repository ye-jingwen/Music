package com.yeye.musicserver.service;

/**
 * @program: music-server
 * @description: 管理员业务逻辑接口
 * @author: YEYE
 * @create: 2021-12-05
 **/
public interface AdminService {
    //验证密码是否正确
    public boolean verifyPassword(String username, String password);
}
