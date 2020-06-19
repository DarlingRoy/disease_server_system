package com.example.disease_server_system.service.impl;

import com.example.disease_server_system.entity.Permission;
import com.example.disease_server_system.dao.PermissionDao;
import com.example.disease_server_system.service.PermissionService;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/**
 * 权限表(Permission)表服务实现类
 *
 * @author linqx
 * @since 2020-06-18 11:44:02
 */
@Service("permissionService")
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionDao permissionDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Permission queryById(Integer id) {
        return this.permissionDao.queryById(id);
    }
    
    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    @Override
    public List<Permission> queryAll() {
        return this.permissionDao.queryAll();
    }

    /**
     * 新增数据
     *
     * @param permission 实例对象
     * @return 实例对象
     */
    @Override
    public Permission insert(Permission permission) {
        this.permissionDao.insert(permission);
        return permission;
    }

    /**
     * 修改数据
     *
     * @param permission 实例对象
     * @return 实例对象
     */
    @Override
    public Permission update(Permission permission) {
        this.permissionDao.update(permission);
        return this.queryById(permission.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.permissionDao.deleteById(id) > 0;
    }
    
    /**
     * 选择性新增数据
     *
     * @param permission 实例对象
     * @return 实例对象
     */
    @Override
    public Permission insertSelective(Permission permission) {
        this.permissionDao.insert(permission);
        return permission;
    }
    
    /**
     * 返回表行数
     *
     * @return 返回表行数
     */
     @Override
     public Integer count(){
        return permissionDao.count();
     }

    /**
     * 通过userId找到user对应的权限
     *
     * @param userId
     * @return
     */
    @Override
    public List<Permission> queryByUserId(Integer userId){
        return permissionDao.queryByUserId(userId);
    }


}