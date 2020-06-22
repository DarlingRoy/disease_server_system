package com.example.disease_server_system.entity;

import java.io.Serializable;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * 用户角色中间表(UserRole)实体类
 *
 * @author linqx
 * @since 2020-06-22 13:08:13
 */
@Data
@ApiModel("用户角色中间表")
public class UserRole implements Serializable {
    private static final long serialVersionUID = 670498257961742440L;
        
    @ApiModelProperty("$column.comment")
    private Integer id;
        
    @ApiModelProperty("$column.comment")
    private Integer userId;
        
    @ApiModelProperty("$column.comment")
    private Integer roleId;

}