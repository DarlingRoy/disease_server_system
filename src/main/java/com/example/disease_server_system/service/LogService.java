package com.example.disease_server_system.service;

import com.example.disease_server_system.entity.Log;
import java.util.List;

/**
 * 日志表(Log)表服务接口
 *
 * @author linqx
 * @since 2020-06-18 11:44:02
 */
public interface LogService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Log queryById(Integer id);
 
    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    List<Log> queryAll();

    /**
     * 新增数据
     *
     * @param log 实例对象
     * @return 实例对象
     */
    Log insert(Log log);

    /**
     * 修改数据
     *
     * @param log 实例对象
     * @return 实例对象
     */
    Log update(Log log);

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
     * @param log 实例对象
     * @return 实例对象
     */
    Log insertSelective(Log log);
    
    /**
     * 返回表行数
     *
     * @return 返回表行数
     */
     Integer count();
     
}