package com.example.disease_server_system.service.impl;

import com.example.disease_server_system.entity.UserRole;
import com.example.disease_server_system.dao.UserRoleDao;
import com.example.disease_server_system.service.UserRoleService;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/**
 * 用户角色中间表(UserRole)表服务实现类
 *
 * @author linqx
 * @since 2020-06-22 13:08:21
 */
@Service("userRoleService")
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    private UserRoleDao userRoleDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public UserRole queryById(Integer id) {
        return this.userRoleDao.queryById(id);
    }
    
    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    @Override
    public List<UserRole> queryAll() {
        return this.userRoleDao.queryAll();
    }

    /**
     * 新增数据
     *
     * @param userRole 实例对象
     * @return 实例对象
     */
    @Override
    public UserRole insert(UserRole userRole) {
        this.userRoleDao.insert(userRole);
        return userRole;
    }

    /**
     * 修改数据
     *
     * @param userRole 实例对象
     * @return 实例对象
     */
    @Override
    public UserRole update(UserRole userRole) {
        this.userRoleDao.update(userRole);
        return this.queryById(userRole.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.userRoleDao.deleteById(id) > 0;
    }
    
    /**
     * 选择性新增数据
     *
     * @param userRole 实例对象
     * @return 实例对象
     */
    @Override
    public UserRole insertSelective(UserRole userRole) {
        this.userRoleDao.insertSelective(userRole);
        return userRole;
    }
    
    /**
     * 返回表行数
     *
     * @return 返回表行数
     */
     @Override
     public Integer count(){
        return userRoleDao.count();
     }
}