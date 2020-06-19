package com.example.disease_server_system.service;

import com.example.disease_server_system.entity.Role;
import java.util.List;

/**
 * 权限表(Role)表服务接口
 *
 * @author linqx
 * @since 2020-06-18 11:44:02
 */
public interface RoleService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Role queryById(Integer id);
 
    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    List<Role> queryAll();

    /**
     * 新增数据
     *
     * @param role 实例对象
     * @return 实例对象
     */
    Role insert(Role role);

    /**
     * 修改数据
     *
     * @param role 实例对象
     * @return 实例对象
     */
    Role update(Role role);

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
     * @param role 实例对象
     * @return 实例对象
     */
    Role insertSelective(Role role);
    
    /**
     * 返回表行数
     *
     * @return 返回表行数
     */
     Integer count();

    /**
     * 根据用户id查询角色列表
     * @param userId 用户id
     * @return 角色列表
     */
     String queryByUserId(Integer userId);
     
}