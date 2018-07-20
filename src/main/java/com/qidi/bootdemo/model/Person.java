package com.qidi.bootdemo.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: qidi
 * Date: 2018/7/20
 * Time: 上午10:41
 */
@ConfigurationProperties(prefix = "person")
@Component
public class Person {
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
}
