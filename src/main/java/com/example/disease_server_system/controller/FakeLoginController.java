package com.example.disease_server_system.controller;

import com.example.disease_server_system.common.entity.JsonResult;
import com.example.disease_server_system.common.utils.ResultTool;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: linqx
 * @date: 2020/6/22 13:47
 */
@Api(tags = "登录登出")
@RestController
public class FakeLoginController {

    @ApiOperation(value = "用户登录")
    @PostMapping("/login")
    public JsonResult login(@ApiParam(value = "用户邮箱") String email,
                            @ApiParam(value = "密码") String password) {
        return ResultTool.fail();
    }

    @ApiOperation(value = "用户登出")
    @GetMapping("/logout")
    public JsonResult logout() {
        return ResultTool.fail();
    }
}
