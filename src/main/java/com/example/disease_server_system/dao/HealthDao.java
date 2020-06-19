package com.example.disease_server_system.dao;

import com.example.disease_server_system.bo.DangerousNum;
import com.example.disease_server_system.entity.Health;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 健康状况记录表(Health)表数据库访问层
 *
 * @author linqx
 * @since 2020-06-18 11:44:02
 */
@Mapper
@Repository 
public interface HealthDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Health queryById(Integer id);

    /**
     * 查找所有记录
     *
     * @return 对象列表
     */
    List<Health> queryAll();

    /**
     * 新增数据
     *
     * @param health 实例对象
     * @return 影响行数
     */
    int insert(Health health);

    /**
     * 修改数据
     *
     * @param health 实例对象
     * @return 影响行数
     */
    int update(Health health);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);
    
    /**
     * 选择性插入数据
     *
     * @param health 实例对象
     * @return 影响行数
     */
    int insertSelective(Health health);
    
    /**
     * 返回表行数
     *
     * @return 返回表行数
     */
    Integer count();

    /**
     * 根据可选字段查询
     * @return 健康列表
     */
    List<Health> queryByOptionalField(Health health);

    /**
     * 统计当天填报总人数
     * @return
     */
    Integer countTodayTotalNum();

    /**
     * 统计当天内 去过湖北、在国外、去过国外、接触过境人员、接触病例、非健康状态 的人数
     * @return
     */
    public DangerousNum countTodayDangerousNum();
}