package com.example.disease_server_system.dao;

import com.example.disease_server_system.entity.Role;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 权限表(Role)表数据库访问层
 *
 * @author linqx
 * @since 2020-06-18 11:44:02
 */
@Mapper
@Repository 
public interface RoleDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Role queryById(Integer id);

    /**
     * 查找所有记录
     *
     * @return 对象列表
     */
    List<Role> queryAll();

    /**
     * 新增数据
     *
     * @param role 实例对象
     * @return 影响行数
     */
    int insert(Role role);

    /**
     * 修改数据
     *
     * @param role 实例对象
     * @return 影响行数
     */
    int update(Role role);

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
     * @param role 实例对象
     * @return 影响行数
     */
    int insertSelective(Role role);
    
    /**
     * 返回表行数
     *
     * @return 返回表行数
     */
    Integer count();

    /**
     * 返回角色权限列表
     */
    List<Map<String, String>> queryRolePermission();

    /**
     * 根据用户id查询角色
     * @param userId
     * @return
     */
    String queryByUserId(Integer userId);
}