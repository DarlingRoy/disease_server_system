package com.example.disease_server_system.config;

import com.example.disease_server_system.config.handler.*;
import com.example.disease_server_system.config.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

    /**
     * 登录成功处理逻辑
     */
    @Autowired
    private CustomizeAuthenticationSuccessHandler authenticationSuccessHandler;

    /**
     * 登录失败处理逻辑
     */
    @Autowired
    private CustomizeAuthenticationFailureHandler authenticationFailureHandler;

    /**
     * 登出成功处理逻辑
     */
    @Autowired
    private CustomizeLogoutSuccessHandler logoutSuccessHandler;

    /**
     * 匿名用户访问无权限资源时的异常
     */
    @Autowired
    private CustomizeAuthenticationEntryPoint authenticationEntryPoint;

    /**
     * 权限拒绝处理逻辑
     */
    @Autowired
    private CustomizeAccessDeniedHandler accessDeniedHandler;

    @Override
    @Bean
    public UserDetailsService userDetailsService() {
        //获取用户账号密码及权限信息
        return new UserDetailsServiceImpl();
    }
    /**
     * 设置密码的加密方式
     * @return
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsService());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().
                antMatchers("/user/register").permitAll().
                anyRequest().authenticated().
                //登出
                and().logout().
                permitAll().
                logoutSuccessHandler(logoutSuccessHandler).
                deleteCookies("JSESSIONID").
                //登录
                and().formLogin().
                permitAll().
                loginProcessingUrl("/login").
                successHandler(authenticationSuccessHandler).
                failureHandler(authenticationFailureHandler).
                //异常处理
                and().exceptionHandling().
                accessDeniedHandler(accessDeniedHandler).
                authenticationEntryPoint(authenticationEntryPoint);
        http.cors().and().csrf().disable();
    }


    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring(). antMatchers("/v2/api-docs",
                "/configuration/ui",
                "/swagger-resources/**",
                "/configuration/security",
                "/swagger-ui.html",
                "/webjars/**",
                "/client/register");
    }


}

