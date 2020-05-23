package com.example.disease_server_system.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户角色中间表(UserRole)实体类
 *
 * @author makejava
 * @since 2020-05-23 11:05:39
 */
@Data
@ApiModel
public class UserRole implements Serializable {
    private static final long serialVersionUID = -40889219232205254L;
    
    private Integer id;
    
    private Integer userId;
    
    private Integer roleId;

}