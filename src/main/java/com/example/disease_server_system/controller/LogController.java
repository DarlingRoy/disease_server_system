package com.example.disease_server_system.controller;

import com.example.disease_server_system.entity.Log;
import com.example.disease_server_system.service.LogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 日志表(Log)表控制层
 *
 * @author makejava
 * @since 2020-05-23 10:56:22
 */
@RestController
@RequestMapping("log")
@Api("日志信息接口")
public class LogController {
    /**
     * 服务对象
     */
    @Resource
    private LogService logService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation("通过主键查询单条数据")
    @GetMapping("selectOne")
    public Log selectOne(Integer id) {
        return this.logService.queryById(id);
    }

    /**
     * 插入一条日志记录
     * @param log
     */
    @ApiOperation("插入一条日志记录")
    @PostMapping("insert")
    public void insert(Log log){
        logService.insert(log);
    }

    /**
     * 更新一条日志记录
     * @param log
     */
    @ApiOperation("更新一条日志记录")
    @PutMapping("update")
    public void update(Log log){
        logService.update(log);
    }

    /**
     * 删除一条日志记录
     * @param id
     */
    @ApiOperation("删除一条日志记录")
    @DeleteMapping("delete")
    public void delete(Integer id){
        logService.deleteById(id);
    }
}