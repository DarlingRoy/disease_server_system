package com.example.disease_server_system.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * 权限表(Permission)实体类
 *
 * @author makejava
 * @since 2020-05-23 10:59:33
 */
@Data
@ApiModel
public class Permission implements Serializable {
    private static final long serialVersionUID = -34655150191809801L;
    
    private Integer id;
    /**
    * 权限名称
    */
    private String name;
    /**
    * 父权限的id
    */
    private Integer parentId;
    /**
    * 权限的描述
    */
    private String description;



}