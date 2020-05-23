package com.example.disease_server_system.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * 健康状况记录表(Health)实体类
 *
 * @author makejava
 * @since 2020-05-23 10:47:35
 */
@Data
@ApiModel
public class Health implements Serializable {
    private static final long serialVersionUID = -16725209929737593L;
    
    private Integer id;
    
    private Integer userId;
    /**
    * 本人身体状况
    */
    private String myPhysicalCondition;
    /**
    * 家人身体状况
    */
    private String familyPhysicalCondition;
    /**
    * 最近是否去过湖北（一个月内）
    */
    private Boolean huBei;
    /**
    * 最近是否出国（一个月内）
    */
    private Boolean abroad;
    /**
    * 是否有外国亲戚
    */
    private Boolean foreignRelatives;
    /**
    * 是否接触过疑似/确诊病例（一个月内）
    */
    private Boolean contactCase;
    /**
    * 最近是否接触到外国人员
    */
    private Boolean contactForeigner;

}