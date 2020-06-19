package com.example.disease_server_system.dao;

import com.example.disease_server_system.entity.User;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 用户表(User)表数据库访问层
 *
 * @author linqx
 * @since 2020-06-18 11:44:02
 */
@Mapper
@Repository 
public interface UserDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    User queryById(Integer id);

    /**
     * 查找所有记录
     *
     * @return 对象列表
     */
    List<User> queryAll();

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 影响行数
     */
    int insert(User user);

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 影响行数
     */
    int update(User user);

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
     * @param user 实例对象
     * @return 影响行数
     */
    int insertSelective(User user);
    
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
     * 根据可选字段查询
     * @param user 用户
     * @return
     */
    List<User> queryByOptionalField(User user);

}