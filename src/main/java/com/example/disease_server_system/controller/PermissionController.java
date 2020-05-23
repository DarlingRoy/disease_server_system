package com.example.disease_server_system.controller;

import com.example.disease_server_system.entity.Permission;
import com.example.disease_server_system.service.PermissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 权限表(Permission)表控制层
 *
 * @author makejava
 * @since 2020-05-23 10:59:34
 */
@RestController
@RequestMapping("permission")
@Api("权限信息接口")
public class PermissionController {
    /**
     * 服务对象
     */
    @Resource
    private PermissionService permissionService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation("通过主键查询单条数据")
    @GetMapping("selectOne")
    public Permission selectOne(Integer id) {
        return this.permissionService.queryById(id);
    }

    /**
     * 插入一条权限
     * @param permission
     */
    @ApiOperation("插入一条权限")
    @PostMapping("insert")
    public void insert(Permission permission){
        permissionService.insert(permission);
    }

    /**
     * 更新一条权限
     * @param permission
     */
    @ApiOperation("更新一条权限")
    @PutMapping("update")
    public void update(Permission permission){
        permissionService.update(permission);
    }

    /**
     * 删除一条权限
     * @param id
     */
    @ApiOperation("删除一条权限")
    @DeleteMapping("delete")
    public void delete(Integer id){
        permissionService.deleteById(id);
    }
}