package com.example.disease_server_system.entity;

import java.io.Serializable;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * 权限表(Permission)实体类
 *
 * @author linqx
 * @since 2020-06-18 11:44:02
 */
@Data
@ApiModel("权限表")
public class Permission implements Serializable {
    private static final long serialVersionUID = 744401564446722378L;
        
    @ApiModelProperty("$column.comment")
    private Integer id;
    /**
    * 权限名称
    */    
    @ApiModelProperty("权限名称")
    private String name;
    /**
    * 父权限的id
    */    
    @ApiModelProperty("父权限的id")
    private Integer parentId;
    /**
    * 权限的描述
    */    
    @ApiModelProperty("权限的描述")
    private String description;
        
    @ApiModelProperty("url接口")
    private String url;

}