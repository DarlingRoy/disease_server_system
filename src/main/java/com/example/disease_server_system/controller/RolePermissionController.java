package com.example.disease_server_system.controller;

import com.example.disease_server_system.entity.RolePermission;
import com.example.disease_server_system.service.RolePermissionService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 角色权限中间表(RolePermission)表控制层
 *
 * @author makejava
 * @since 2020-05-23 11:02:51
 */
@RestController
@RequestMapping("rolePermission")
public class RolePermissionController {
    /**
     * 服务对象
     */
    @Resource
    private RolePermissionService rolePermissionService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public RolePermission selectOne(Integer id) {
        return this.rolePermissionService.queryById(id);
    }

}