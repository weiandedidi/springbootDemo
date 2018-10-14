package com.qidi.bootdemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 继承 重写WebSecurityConfigurerAdapter
 * .mvcMatchers("/hello").permitAll() 放权
 * <p>
 * post和 delete403 解决办法
 * https://docs.spring.io/spring-security/site/docs/3.2.x/reference/htmlsingle/html5/
 * <p>
 * User: qidi
 * Date: 2018/8/10
 * Time: 上午10:42
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //定制请求的授权规则
        http.authorizeRequests().mvcMatchers("/css/**", "/index", "/caface/add", "hi").permitAll()
                .and()
                .formLogin().loginPage("/login").failureUrl("/login-error");
        //post delete 的403请求拒绝 解决办法
        http
                .csrf().disable();
        //url权限拦截


    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("user").password("password").roles("USER");
    }
}
