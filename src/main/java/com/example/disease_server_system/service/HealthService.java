package com.example.disease_server_system.service;

import com.example.disease_server_system.entity.Health;
import java.util.List;

/**
 * 健康状况记录表(Health)表服务接口
 *
 * @author makejava
 * @since 2020-05-23 10:47:42
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
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Health> queryAllByLimit(int offset, int limit);

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

}