package com.example.disease_server_system.controller;

import com.example.disease_server_system.common.entity.JsonResult;
import com.example.disease_server_system.common.utils.ResultTool;
import com.example.disease_server_system.entity.Health;
import com.example.disease_server_system.service.HealthService;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 健康状况记录表(Health)表控制层
 *
 * @author linqx
 * @since 2020-06-18 11:44:02
 */
@Api(tags = "健康状况记录表(Health)")
@RestController
@RequestMapping("health")
public class HealthController {
    /**
     * 服务对象
     */
    @Autowired
    private HealthService healthService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation(value = "根据id查询 健康状况记录表")
    @GetMapping("selectOne")
    public JsonResult selectOne(@ApiParam(value = "健康表id ID") Integer id) {
        return ResultTool.success(this.healthService.queryById(id));
    }

    /**
     * 增加一条记录(只填入不为空的字段)
     *
     * @param health 实例对象
     */
    @ApiOperation("增加一条记录(只填入不为空的字段)")
    @PostMapping("insertSelective")
    public JsonResult insertSelective(Health health) {
        this.healthService.insertSelective(health);
        return ResultTool.success();
    }

    /**
     * 增加一条记录(填入所有字段)
     *
     * @param health 实例对象
     */
    @ApiOperation("增加一条记录(填入所有字段)")
    @PostMapping("insert")
    public JsonResult insert(Health health) {
        this.healthService.insert(health);
        return ResultTool.success();
    }

    /**
     * 更新一条记录(只对不为空的字段进行更新)
     *
     * @param health 实例对象
     */
    @ApiOperation("更新一条记录(只对不为空的字段进行更新)")
    @PutMapping("update")
    public JsonResult update(Health health) {
        this.healthService.update(health);
        return ResultTool.success();
    }

    /**
     * 根据id删除一条记录
     *
     * @param id
     */
    @ApiOperation("根据id删除一条记录")
    @DeleteMapping("delete")
    public JsonResult delete(@ApiParam(value = "健康表id ID") Integer id) {
        this.healthService.deleteById(id);
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
        return ResultTool.success(this.healthService.queryAll());
    }

    /**
     * 返回表行数
     *
     * @return 返回表行数
     */
    @ApiOperation(value = "返回表中行数")
    @GetMapping("count")
    public JsonResult count() {
        return ResultTool.success(this.healthService.count());
    }

    /**
     * 根据字段查询
     *
     * @return
     */
    @ApiOperation(value = "根据字段查询，表中字段都为可选")
    @PostMapping("selectByOptionalField")
    public JsonResult selectByOptionalField(Health health) {
        return ResultTool.success(this.healthService.queryByOptionalField(health));
    }

    /**
     * 统计当天内填报的总人数
     * @return
     */
    @ApiOperation(value = "统计当天内填报的总人数")
    @GetMapping("countTodayTotalNum")
    public JsonResult countTodayTotalNum() {
        return ResultTool.success(this.healthService.countTodayTotalNum());
    }

    @ApiOperation(value = "当天内 去过湖北、在国外、去过国外、接触过境人员、接触病例、非健康状态 的人数")
    @GetMapping("countTodayDangerousNum")
    public JsonResult countTodayDangerousNum() {
        return ResultTool.success(this.healthService.countTodayDangerousNum());
    }
}