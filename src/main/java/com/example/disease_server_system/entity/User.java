package com.example.disease_server_system.entity;

import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * 用户表(User)实体类
 *
 * @author linqx
 * @since 2020-06-18 11:44:02
 */
@Data
@ApiModel("用户表")
public class User implements Serializable {
    private static final long serialVersionUID = -76631725875049336L;
        
    @ApiModelProperty("$column.comment")
    private Integer id;
    /**
    * 用户名
    */    
    @ApiModelProperty("用户名")
    private String userName;
    /**
    * 用户注册邮箱
    */    
    @ApiModelProperty("用户注册邮箱")
    private String email;
    /**
    * 创建用户的时间
    */    
    @ApiModelProperty("创建用户的时间")
    private Date createTime;
    /**
    * 手机号码
    */    
    @ApiModelProperty("手机号码")
    private String telephone;
    /**
    * qq号
    */    
    @ApiModelProperty("qq号")
    private String qq;
    /**
    * 用户修改时间
    */    
    @ApiModelProperty("用户修改时间")
    private Date updateTime;
    /**
    * 微信号
    */    
    @ApiModelProperty("微信号")
    private String wechat;
    /**
    * 学院
    */    
    @ApiModelProperty("学院")
    private String college;
    /**
    * 专业
    */    
    @ApiModelProperty("专业")
    private String major;
    /**
    * 现居住地
    */    
    @ApiModelProperty("现居住地")
    private String livingCity;
    /**
    * 籍贯
    */    
    @ApiModelProperty("籍贯")
    private String hometown;
    /**
    * 性别
    */    
    @ApiModelProperty("性别")
    private String sex;
    /**
    * 密码
    */    
    @ApiModelProperty("密码")
    private String password;

}