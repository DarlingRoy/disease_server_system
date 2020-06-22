package com.example.disease_server_system.service.impl;

import com.example.disease_server_system.entity.Role;
import com.example.disease_server_system.dao.RoleDao;
import com.example.disease_server_system.service.RoleService;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/**
 * 权限表(Role)表服务实现类
 *
 * @author linqx
 * @since 2020-06-18 11:44:02
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Role queryById(Integer id) {
        return this.roleDao.queryById(id);
    }
    
    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    @Override
    public List<Role> queryAll() {
        return this.roleDao.queryAll();
    }

    /**
     * 新增数据
     *
     * @param role 实例对象
     * @return 实例对象
     */
    @Override
    public Role insert(Role role) {
        this.roleDao.insert(role);
        return role;
    }

    /**
     * 修改数据
     *
     * @param role 实例对象
     * @return 实例对象
     */
    @Override
    public Role update(Role role) {
        this.roleDao.update(role);
        return this.queryById(role.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.roleDao.deleteById(id) > 0;
    }
    
    /**
     * 选择性新增数据
     *
     * @param role 实例对象
     * @return 实例对象
     */
    @Override
    public Role insertSelective(Role role) {
        this.roleDao.insert(role);
        return role;
    }
    
    /**
     * 返回表行数
     *
     * @return 返回表行数
     */
     @Override
     public Integer count(){
        return roleDao.count();
     }

    /**
     * 根据用户id查询角色列表
     *
     * @param userId 用户id
     * @return 角色列表
     */
    @Override
    public String queryByUserId(Integer userId) {
        return this.roleDao.queryByUserId(userId);
    }

    /**
     * 根据角色名查询角色
     *
     * @param roleName
     */
    @Override
    public Role queryByRoleName(String roleName) {
        return this.roleDao.queryByRoleName(roleName);
    }
}