package com.example.disease_server_system.config.handler;

import com.alibaba.fastjson.JSON;
import com.example.disease_server_system.common.entity.JsonResult;
import com.example.disease_server_system.common.utils.ResultTool;
import com.example.disease_server_system.entity.User;
import com.example.disease_server_system.service.RoleService;
import com.example.disease_server_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class CustomizeAuthenticationSuccessHandler implements AuthenticationSuccessHandler{

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        //更新用户表更新时间字段
        org.springframework.security.core.userdetails.User userDetails= (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userService.queryByEmail(userDetails.getUsername());
        Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("userId", user.getId());
        hashMap.put("roleName", roleService.queryByUserId(user.getId()));
        //返回json数据
        JsonResult result= ResultTool.success(hashMap);
        httpServletResponse.setContentType("text/json;charset=utf-8");
        httpServletResponse.getWriter().write(JSON.toJSONString(result));
    }
}
