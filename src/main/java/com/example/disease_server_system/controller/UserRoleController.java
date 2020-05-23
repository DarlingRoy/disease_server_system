package com.example.disease_server_system.controller;

import com.example.disease_server_system.entity.UserRole;
import com.example.disease_server_system.service.UserRoleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 用户角色中间表(UserRole)表控制层
 *
 * @author makejava
 * @since 2020-05-23 11:05:39
 */
@RestController
@RequestMapping("userRole")
public class UserRoleController {
    /**
     * 服务对象
     */
    @Resource
    private UserRoleService userRoleService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public UserRole selectOne(Integer id) {
        return this.userRoleService.queryById(id);
    }

}