package com.example.disease_server_system.service;

import com.example.disease_server_system.entity.User;
import java.util.List;

/**
 * 用户表(User)表服务接口
 *
 * @author linqx
 * @since 2020-06-18 11:44:02
 */
public interface UserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    User queryById(Integer id);
 
    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    List<User> queryAll();

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User insert(User user);

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User update(User user);

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
     * @param user 实例对象
     * @return 实例对象
     */
    User insertSelective(User user);
    
    /**
     * 返回表行数
     *
     * @return 返回表行数
     */
     Integer count();

    /**
     * 通过邮箱查询用户
     *
     * @param email
     * @return
     */
    User queryByEmail(String email);

    /**
     * 根据可选字段查询用户
     * @param user 用户可选字段
     * @return 用户列表
     */
    List<User> queryByOptionalField(User user) ;
     
}