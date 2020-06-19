package com.example.disease_server_system.dao;

import com.example.disease_server_system.entity.Log;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 日志表(Log)表数据库访问层
 *
 * @author linqx
 * @since 2020-06-18 11:44:02
 */
@Mapper
@Repository 
public interface LogDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Log queryById(Integer id);

    /**
     * 查找所有记录
     *
     * @return 对象列表
     */
    List<Log> queryAll();

    /**
     * 新增数据
     *
     * @param log 实例对象
     * @return 影响行数
     */
    int insert(Log log);

    /**
     * 修改数据
     *
     * @param log 实例对象
     * @return 影响行数
     */
    int update(Log log);

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
     * @param log 实例对象
     * @return 影响行数
     */
    int insertSelective(Log log);
    
    /**
     * 返回表行数
     *
     * @return 返回表行数
     */
    Integer count();
}