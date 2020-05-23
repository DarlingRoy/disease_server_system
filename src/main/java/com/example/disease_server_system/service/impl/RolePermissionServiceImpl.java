package com.example.disease_server_system.service.impl;

import com.example.disease_server_system.entity.RolePermission;
import com.example.disease_server_system.mapper.RolePermissionDao;
import com.example.disease_server_system.service.RolePermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 角色权限中间表(RolePermission)表服务实现类
 *
 * @author makejava
 * @since 2020-05-23 11:02:51
 */
@Service("rolePermissionService")
public class RolePermissionServiceImpl implements RolePermissionService {
    @Resource
    private RolePermissionDao rolePermissionDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public RolePermission queryById(Integer id) {
        return this.rolePermissionDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<RolePermission> queryAllByLimit(int offset, int limit) {
        return this.rolePermissionDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param rolePermission 实例对象
     * @return 实例对象
     */
    @Override
    public RolePermission insert(RolePermission rolePermission) {
        this.rolePermissionDao.insert(rolePermission);
        return rolePermission;
    }

    /**
     * 修改数据
     *
     * @param rolePermission 实例对象
     * @return 实例对象
     */
    @Override
    public RolePermission update(RolePermission rolePermission) {
        this.rolePermissionDao.update(rolePermission);
        return this.queryById(rolePermission.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.rolePermissionDao.deleteById(id) > 0;
    }
}