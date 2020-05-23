package com.example.disease_server_system.controller;

import com.example.disease_server_system.entity.User;
import com.example.disease_server_system.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 用户表(User)表控制层
 *
 * @author makejava
 * @since 2020-05-23 11:04:15
 */
@RestController
@RequestMapping("user")
@Api("用户管理接口")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation("通过主键查询单条数据")
    @GetMapping("selectOne")
    public User selectOne(Integer id) {
        return this.userService.queryById(id);
    }

    /**
     * 增加一条用户记录
     * @param user
     */
    @ApiOperation("增加一条用户记录")
    @PostMapping("insert")
    public void insert(User user){
        userService.insert(user);
    }

    /**
     * 更新一条用户记录
     * @param user
     */
    @ApiOperation("更新一条用户记录")
    @PutMapping("update")
    public void update(User user){
        userService.update(user);
    }

    /**
     * 删除一条用户记录
     * @param id
     */
    @ApiOperation("删除一条用户记录")
    @DeleteMapping("delete")
    public void delete(Integer id){
        userService.deleteById(id);
    }
}