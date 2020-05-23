package com.example.disease_server_system.controller;

import com.example.disease_server_system.entity.Role;
import com.example.disease_server_system.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Role)表控制层
 *
 * @author makejava
 * @since 2020-05-23 11:01:25
 */
@RestController
@RequestMapping("role")
@Api("角色信息接口")
public class RoleController {
    /**
     * 服务对象
     */
    @Resource
    private RoleService roleService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation("通过主键查询单条数据")
    @GetMapping("selectOne")
    public Role selectOne(Integer id) {
        return this.roleService.queryById(id);
    }

    /**
     * 增加一个角色
     * @param role
     */
    @ApiOperation("增加一个角色")
    @PostMapping("insert")
    public void insert(Role role){
        roleService.insert(role);
    }

    /**
     * 更新一个角色
     * @param role
     */
    @ApiOperation("更新一个角色")
    @PutMapping("update")
    public void update(Role role){
        roleService.update(role);
    }

    /**
     * 删除一个角色
     * @param id
     */
    @ApiOperation("删除一个角色")
    @DeleteMapping("delete")
    public void delete(Integer id){
        roleService.deleteById(id);
    }
}