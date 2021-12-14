package com.yeye.musicserver.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: music-server
 * @description: 用户
 * @author: YEYE
 * @create: 2021-12-14
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Consumer implements Serializable {
    private Integer id;   //主键
    private String username;   //用户名
    private String password;   //密码
    private Byte sex;   //性别
    private String phoneNum;   //手机号
    private String email;   //电子邮箱
    private Date birth;   //生日
    private String introduction;   //签名
    private String location;   //地区
    private String avator;   //头像
    private Date createTime;   //创建时间
    private Date updateTime;   //更新时间
}
