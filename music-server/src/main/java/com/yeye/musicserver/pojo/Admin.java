package com.yeye.musicserver.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @program: music-server
 * @description: 管理员
 * @author: YEYE
 * @create: 2021-12-05
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin implements Serializable {
    private Integer id;   //主键
    private String name;   //账号
    private String password;   //密码
}
