package com.example.disease_server_system.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 日志表(Log)实体类
 *
 * @author makejava
 * @since 2020-05-23 10:56:22
 */
@Data
@ApiModel
public class Log implements Serializable {
    private static final long serialVersionUID = -34098352670353964L;
    
    private Integer id;
    
    private Integer userId;
    
    private String operation;
    
    private Date operationTime;


}