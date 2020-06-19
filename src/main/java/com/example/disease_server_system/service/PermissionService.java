package com.example.disease_server_system.service;

import com.example.disease_server_system.entity.Permission;
import com.example.disease_server_system.entity.User;

import java.util.List;

/**
 * 权限表(Permission)表服务接口
 *
 * @author linqx
 * @since 2020-06-18 11:44:02
 */
public interface PermissionService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Permission queryById(Integer id);
 
    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    List<Permission> queryAll();

    /**
     * 新增数据
     *
     * @param permission 实例对象
     * @return 实例对象
     */
    Permission insert(Permission permission);

    /**
     * 修改数据
     *
     * @param permission 实例对象
     * @return 实例对象
     */
    Permission update(Permission permission);

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
     * @param permission 实例对象
     * @return 实例对象
     */
    Permission insertSelective(Permission permission);
    
    /**
     * 返回表行数
     *
     * @return 返回表行数
     */
     Integer count();

    /**
     * 通过userId找到user对应的权限
     *
     * @param userId
     * @return
     */
    List<Permission> queryByUserId(Integer userId);
     
}