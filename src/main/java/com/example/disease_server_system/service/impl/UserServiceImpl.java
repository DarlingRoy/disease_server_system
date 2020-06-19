package com.example.disease_server_system.service.impl;

import com.example.disease_server_system.entity.User;
import com.example.disease_server_system.dao.UserDao;
import com.example.disease_server_system.service.UserService;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/**
 * 用户表(User)表服务实现类
 *
 * @author linqx
 * @since 2020-06-18 11:44:02
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public User queryById(Integer id) {
        return this.userDao.queryById(id);
    }
    
    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    @Override
    public List<User> queryAll() {
        return this.userDao.queryAll();
    }

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User insert(User user) {
        this.userDao.insert(user);
        return user;
    }

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User update(User user) {
        this.userDao.update(user);
        return this.queryById(user.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.userDao.deleteById(id) > 0;
    }
    
    /**
     * 选择性新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User insertSelective(User user) {
        this.userDao.insert(user);
        return user;
    }
    
    /**
     * 返回表行数
     *
     * @return 返回表行数
     */
     @Override
     public Integer count(){
        return userDao.count();
     }

    /**
     * 通过邮箱查询用户
     *
     * @param email
     * @return
     */
    @Override
    public User queryByEmail(String email){
        return userDao.queryByEmail(email);
    }

    /**
     * 根据可选字段查询用户
     *
     * @param user 用户可选字段
     * @return 用户列表
     */
    @Override
    public List<User> queryByOptionalField(User user) {
        return this.userDao.queryByOptionalField(user);
    }
}