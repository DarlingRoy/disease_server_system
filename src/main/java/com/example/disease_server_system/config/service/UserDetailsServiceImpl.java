package com.example.disease_server_system.config.service;

import com.example.disease_server_system.entity.Permission;
import com.example.disease_server_system.entity.User;
import com.example.disease_server_system.service.PermissionService;
import com.example.disease_server_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    private UserService userService;

    @Autowired
    private PermissionService permissionService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        if(email==null||"".equals(email)){
            throw new RuntimeException("用户不能为空");
        }
        //根据邮箱查询用户
        User user=userService.queryByEmail(email);
        if(user==null){
            throw new RuntimeException("用户不存在");
        }
        List<GrantedAuthority> grantedAuthorities=new ArrayList<>();
        //获取该用户所拥有的权限
        List<Permission> permissions=permissionService.queryByUserId(user.getId());
        //声明用户授权
        permissions.forEach(permission -> {
            GrantedAuthority grantedAuthority=new SimpleGrantedAuthority(permission.getName());
            grantedAuthorities.add(grantedAuthority);
        });

        return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),grantedAuthorities);
    }
}
