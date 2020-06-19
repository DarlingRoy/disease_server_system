package com.example.disease_server_system.entity;

import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * 日志表(Log)实体类
 *
 * @author linqx
 * @since 2020-06-18 11:44:02
 */
@Data
@ApiModel("日志表")
public class Log implements Serializable {
    private static final long serialVersionUID = 208517331037661759L;
        
    @ApiModelProperty("$column.comment")
    private Integer id;
        
    @ApiModelProperty("$column.comment")
    private Integer userId;
        
    @ApiModelProperty("$column.comment")
    private String operation;
        
    @ApiModelProperty("$column.comment")
    private Date operationTime;

}