package com.example.disease_server_system.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (Role)实体类
 *
 * @author makejava
 * @since 2020-05-23 11:01:25
 */
@Data
@ApiModel
public class Role implements Serializable {
    private static final long serialVersionUID = 706534366731247194L;
    
    private Integer id;
    
    private String name;
    
    private Date createTime;
    
    private Date updateTime;



}