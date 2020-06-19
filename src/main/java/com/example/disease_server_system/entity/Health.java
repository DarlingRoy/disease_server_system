package com.example.disease_server_system.entity;

import java.io.Serializable;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * 健康状况记录表(Health)实体类
 *
 * @author linqx
 * @since 2020-06-18 11:44:02
 */
@Data
@ApiModel("健康状况记录表")
public class Health implements Serializable {
    private static final long serialVersionUID = 705825181611924788L;
    /**
    * 健康表id
    */    
    @ApiModelProperty("健康表id")
    private Integer id;
    /**
    * 用户id
    */    
    @ApiModelProperty("用户id")
    private Integer userId;
    /**
    * 本人身体状况
    */    
    @ApiModelProperty("本人身体状况")
    private String myPhysicalCondition;
    /**
    * 家人身体状况
    */    
    @ApiModelProperty("家人身体状况")
    private String familyPhysicalCondition;
    /**
    * 最近是否去过湖北（一个月内）
    */    
    @ApiModelProperty("最近是否去过湖北（一个月内）")
    private Boolean huBei;
    /**
    * 最近是否出国（一个月内）
    */    
    @ApiModelProperty("最近是否出国（一个月内）")
    private Boolean abroad;
    /**
    * 是否有外国亲戚
    */    
    @ApiModelProperty("是否有外国亲戚")
    private Boolean foreignRelatives;
    /**
    * 是否接触过疑似/确诊病例（一个月内）
    */    
    @ApiModelProperty("是否接触过疑似/确诊病例（一个月内）")
    private Boolean contactCase;
    /**
    * 最近是否接触到外国人员
    */    
    @ApiModelProperty("最近是否接触到外国人员")
    private Boolean contactForeigner;

}