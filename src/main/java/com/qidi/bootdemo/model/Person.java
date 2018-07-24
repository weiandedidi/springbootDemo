package com.qidi.bootdemo.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * 1. 使用ConfigurationProperties prefix是前缀便于查找
 * 2. 使用value注解 通过spel表达式获取${user.name} yaml文件也可以这么获取
 * User: qidi
 * Date: 2018/7/20
 * Time: 上午10:41
 */
@ConfigurationProperties(prefix = "user" )
@Component
//校验
@Validated
public class Person {
//    @Value("${user.name}")

//    @Email   邮箱校验
    private String name;
    private Integer age;
    /**
     * 账户map
     */
    private Map<Integer,Integer> accountMap;
    private Department department;
    /**
     * 管理的部门号集合
     */
    private List<Integer> departmentNos;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Map<Integer, Integer> getAccountMap() {
        return accountMap;
    }

    public void setAccountMap(Map<Integer, Integer> accountMap) {
        this.accountMap = accountMap;
    }

    public List<Integer> getDepartmentNos() {
        return departmentNos;
    }

    public void setDepartmentNos(List<Integer> departmentNos) {
        this.departmentNos = departmentNos;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", accountMap=" + accountMap +
                ", department=" + department +
                ", departmentNos=" + departmentNos +
                '}';
    }
}
