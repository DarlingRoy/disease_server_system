package com.example.disease_server_system.dao;

import com.example.disease_server_system.entity.UserRole;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 用户角色中间表(UserRole)表数据库访问层
 *
 * @author linqx
 * @since 2020-06-22 13:08:21
 */
@Mapper
@Repository 
public interface UserRoleDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UserRole queryById(Integer id);

    /**
     * 查找所有记录
     *
     * @return 对象列表
     */
    List<UserRole> queryAll();

    /**
     * 新增数据
     *
     * @param userRole 实例对象
     * @return 影响行数
     */
    void insert(UserRole userRole);

    /**
     * 修改数据
     *
     * @param userRole 实例对象
     * @return 影响行数
     */
    int update(UserRole userRole);

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
     * @param userRole 实例对象
     * @return 影响行数
     */
    void insertSelective(UserRole userRole);
    
    /**
     * 返回表行数
     *
     * @return 返回表行数
     */
    Integer count();
}