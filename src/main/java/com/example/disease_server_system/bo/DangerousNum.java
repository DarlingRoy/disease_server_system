package com.example.disease_server_system.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: linqx
 * @date: 2020/6/19 09:25
 */
@ApiModel("危险人数统计")
@Data
public class DangerousNum {
    /**
     * 去过湖北（一个月内）
     */
    @ApiModelProperty("去过湖北（一个月内）")
    private Integer huBei;

    /**
     * 在国外
     */
    @ApiModelProperty("人在国外")
    private Integer foreignRelatives;

    /**
     * 最近出国（一个月内）
     */
    @ApiModelProperty("最近出国（一个月内）")
    private Integer abroad;

    /**
     * 最近接触到外国人员
     */
    @ApiModelProperty("最近接触到外国人员")
    private Integer contactForeigner;

    /**
     * 接触过疑似/确诊病例（一个月内）
     */
    @ApiModelProperty("接触过疑似/确诊病例（一个月内）")
    private Integer contactCase;


    /**
     * 本人身体状况
     */
    @ApiModelProperty("非健康状态")
    private Integer myPhysicalCondition;

}
