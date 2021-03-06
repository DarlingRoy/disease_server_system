package com.example.disease_server_system.service;

import com.example.disease_server_system.bo.DangerousNum;
import com.example.disease_server_system.common.entity.JsonResult;
import com.example.disease_server_system.entity.Health;
import java.util.List;

/**
 * 健康状况记录表(Health)表服务接口
 *
 * @author linqx
 * @since 2020-06-18 11:44:02
 */
public interface HealthService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Health queryById(Integer id);
 
    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    List<Health> queryAll();

    /**
     * 新增数据
     *
     * @param health 实例对象
     * @return 实例对象
     */
    Health insert(Health health);

    /**
     * 修改数据
     *
     * @param health 实例对象
     * @return 实例对象
     */
    Health update(Health health);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);
    
    /**
     * 选择性插入数据
     *
     * @param health 实例对象
     * @return 实例对象
     */
    Health insertSelective(Health health);
    
    /**
     * 返回表行数
     *
     * @return 返回表行数
     */
     Integer count();

    /**
     * 根据可选字段查询
     * @return
     */
    List<Health> queryByOptionalField(Health health);

    /**
     * 统计当天内填报总人数
     * @return
     */
    Integer countTodayTotalNum();

    /**
     * 当天内 去过湖北、在国外、去过国外、接触过境人员、接触病例、非健康状态 的人数
     * @return
     */
    public DangerousNum countTodayDangerousNum();
}