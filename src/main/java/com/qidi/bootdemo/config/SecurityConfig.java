package com.qidi.bootdemo.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 继承 重写WebSecurityConfigurerAdapter
 *
 * User: qidi
 * Date: 2018/8/10
 * Time: 上午10:42
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //放行的
        http.authorizeRequests().mvcMatchers("/css/**", "/index").permitAll()
        .mvcMatchers("/hello","/index").permitAll();
        //不放行的
    }
}
