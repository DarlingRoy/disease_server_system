package com.example.disease_server_system.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * 角色权限中间表(RolePermission)实体类
 *
 * @author makejava
 * @since 2020-05-23 11:02:51
 */
@Data
@ApiModel
public class RolePermission implements Serializable {
    private static final long serialVersionUID = 678530730922563137L;
    
    private Integer id;
    /**
    * 角色id
    */
    private Integer roleId;
    
    private Integer permissionId;

}