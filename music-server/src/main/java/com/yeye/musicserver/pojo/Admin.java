package com.yeye.musicserver.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: music-server
 * @description: 管理员
 * @author: YEYE
 * @create: 2021-12-05
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
    private Integer id;
    private String password;
}
