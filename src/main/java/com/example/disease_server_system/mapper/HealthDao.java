package com.example.disease_server_system.mapper;

import com.example.disease_server_system.entity.Health;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 健康状况记录表(Health)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-23 10:47:42
 */
@Mapper
public interface HealthDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Health queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Health> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param health 实例对象
     * @return 对象列表
     */
    List<Health> queryAll(Health health);

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

}