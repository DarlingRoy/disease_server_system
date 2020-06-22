package com.example.disease_server_system.service;

import com.example.disease_server_system.entity.UserRole;
import java.util.List;

/**
 * 用户角色中间表(UserRole)表服务接口
 *
 * @author linqx
 * @since 2020-06-22 13:08:21
 */
public interface UserRoleService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UserRole queryById(Integer id);
 
    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    List<UserRole> queryAll();

    /**
     * 新增数据
     *
     * @param userRole 实例对象
     * @return 实例对象
     */
    UserRole insert(UserRole userRole);

    /**
     * 修改数据
     *
     * @param userRole 实例对象
     * @return 实例对象
     */
    UserRole update(UserRole userRole);

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
     * @param userRole 实例对象
     * @return 实例对象
     */
    UserRole insertSelective(UserRole userRole);
    
    /**
     * 返回表行数
     *
     * @return 返回表行数
     */
     Integer count();
     
}