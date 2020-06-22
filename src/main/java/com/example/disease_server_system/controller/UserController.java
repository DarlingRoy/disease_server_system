package com.example.disease_server_system.controller;

import com.example.disease_server_system.common.entity.JsonResult;
import com.example.disease_server_system.common.utils.ResultTool;
import com.example.disease_server_system.entity.Role;
import com.example.disease_server_system.entity.User;
import com.example.disease_server_system.entity.UserRole;
import com.example.disease_server_system.service.RoleService;
import com.example.disease_server_system.service.UserRoleService;
import com.example.disease_server_system.service.UserService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/**
 * 用户表(User)表控制层
 *
 * @author linqx
 * @since 2020-06-18 11:44:02
 */
@Api(tags = "用户表(User)") 
@RestController
@RequestMapping("user")
public class UserController {
    /**
     * 服务对象
     */
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserRoleService userRoleService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation(value = "根据id查询 用户表")
    @GetMapping("selectOne")
    public JsonResult selectOne(@ApiParam(value = " ID") Integer id) {
        return ResultTool.success(this.userService.queryById(id));
    }
    
    /**
     * 增加一条记录(只填入不为空的字段)
     * @param user 实例对象
     */
    @ApiOperation("增加一条记录(只填入不为空的字段)")
    @PostMapping("insertSelective")
    public JsonResult insertSelective(User user){
        this.userService.insertSelective(user);
        return ResultTool.success();
    }
    
    /**
     * 增加一条记录(填入所有字段)
     * @param user 实例对象
     */
    @ApiOperation("增加一条记录(填入所有字段)")
    @PostMapping("insert")
    public JsonResult insert(User user){
        this.userService.insert(user);
        return ResultTool.success();
    }
    
    /**
     * 更新一条记录(只对不为空的字段进行更新)
     * @param user 实例对象
     */
    @ApiOperation("更新一条记录(只对不为空的字段进行更新)")
    @PutMapping("update")
    public JsonResult update(User user){
        this.userService.update(user);
        return ResultTool.success();
    }
    
    /**
     * 根据id删除一条记录
     * @param id
     */
    @ApiOperation("根据id删除一条记录")
    @DeleteMapping("delete")
    public JsonResult delete(@ApiParam(value = " ID") Integer id){
        this.userService.deleteById(id);
        return ResultTool.success();
    }
    
    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    @ApiOperation(value = "查询表中所有数据")
    @GetMapping("selectAll")   
    public JsonResult selectAll() {
        return ResultTool.success(this.userService.queryAll());
    }
    
    /**
     * 返回表行数
     *
     * @return 返回表行数
     */
     @ApiOperation(value = "返回表中行数")
     @GetMapping("count")
     public JsonResult count() {
        return ResultTool.success(this.userService.count());
     }

    /**
     * 根据可选字段查询用户
     * @param user 用户
     * @return 用户列表
     */
    @ApiOperation(value = "根据可选字段查询用户")
    @GetMapping("selectByOptionalField")
     public JsonResult selectByOptionalField(User user) {
         return ResultTool.success(this.userService.queryByOptionalField(user));
     }

    /**
     * 用户注册接口
     */
    @ApiOperation(value = "用户注册接口")
    @PostMapping("register")
    @Transactional
    public JsonResult register(User user, @ApiParam(value = "角色名称") String roleName) {
        User newUser = this.userService.insertSelective(user);
        Role role = roleService.queryByRoleName(roleName);
        if (role != null) {
            UserRole userRole = new UserRole();
            userRole.setUserId(newUser.getId());
            userRole.setRoleId(role.getId());
            userRoleService.insertSelective(userRole);
        }
        if (role == null) {
            role = new Role();
            role.setName("roleName");
            role = roleService.insertSelective(role);
            UserRole userRole = new UserRole();
            userRole.setUserId(newUser.getId());
            userRole.setRoleId(role.getId());
            userRoleService.insertSelective(userRole);
        }
        return ResultTool.success();
    }


}