package com.example.disease_server_system.controller;

import com.example.disease_server_system.entity.Health;
import com.example.disease_server_system.service.HealthService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 健康状况记录表(Health)表控制层
 *
 * @author makejava
 * @since 2020-05-23 10:47:44
 */
@RestController
@RequestMapping("health")
@Api("健康信息表接口")
public class HealthController {
    /**
     * 服务对象
     */
    @Resource
    private HealthService healthService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation("通过主键查询单条数据")
    @GetMapping("selectOne")
    public Health selectOne(Integer id) {
        return this.healthService.queryById(id);
    }

    /**
     * 插入一条健康信息记录
     * @param health
     */
    @ApiOperation("插入一条健康信息记录")
    @PostMapping("insert")
    public void insert(Health health){
        healthService.insert(health);
    }

    /**
     * 更新用户健康信息
     * @param health
     */
    @ApiOperation("更新用户健康信息")
    @PutMapping("update")
    public void update(Health health){
        healthService.update(health);
    }

    /**
     * 删除用户的健康信息记录
     * @param id
     */
    @ApiOperation("删除用户的健康信息记录")
    @DeleteMapping("delete")
    public void delete(Integer id){
        healthService.deleteById(id);
    }
}