package com.example.disease_server_system.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 用户表(User)实体类
 *
 * @author makejava
 * @since 2020-05-23 11:04:15
 */
@Data
@ApiModel
public class User implements Serializable {
    private static final long serialVersionUID = -75216574464491025L;
    
    private Integer id;
    /**
    * 用户名
    */
    private String userName;
    /**
    * 用户注册邮箱
    */
    private String email;
    /**
    * 创建用户的时间
    */
    private Date createTime;
    /**
    * 手机号码
    */
    private String telephone;
    /**
    * qq号
    */
    private String qq;
    /**
    * 用户修改时间
    */
    private String updateTime;
    /**
    * 微信号
    */
    private String wechat;
    /**
    * 学院
    */
    private String college;
    /**
    * 专业
    */
    private String major;
    /**
    * 现居住地
    */
    private String livingCity;
    /**
    * 籍贯
    */
    private String hometown;
    /**
    * 性别
    */
    private String sex;
    /**
    * 密码
    */
    private String password;

}