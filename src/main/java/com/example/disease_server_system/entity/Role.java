package com.example.disease_server_system.entity;

import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * 权限表(Role)实体类
 *
 * @author linqx
 * @since 2020-06-18 11:44:02
 */
@Data
@ApiModel("权限表")
public class Role implements Serializable {
    private static final long serialVersionUID = -63705832299323611L;
        
    @ApiModelProperty("$column.comment")
    private Integer id;
        
    @ApiModelProperty("$column.comment")
    private String name;
        
    @ApiModelProperty("$column.comment")
    private Date createTime;
        
    @ApiModelProperty("$column.comment")
    private Date updateTime;

}