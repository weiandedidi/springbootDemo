package com.qidi.sharding.service.employee;

import com.qidi.sharding.model.employee.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: qidi
 * Date: 2018/8/24
 * Time: 上午11:34
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class EmployeeServiceTest {

    @Autowired
    EmployeeService employeeService;

    @Test
    public void insert() {
        Employee employee = new Employee();
        employee.setEmail("weiandedidi@163.com");
        employee.setGender(1L);
        employee.setLastname("我是分表");
        employee.setDId(5L);
        employeeService.insert(employee);
        System.out.println("====== 插入成功 =========");
    }

    @Test
    public void update() {
    }

    @Test
    public void getEmployeeById() {
    }

    @Test
    public void countEmployee() {
    }

    @Test
    public void getEmployeeList() {
        Map<String, Object> params = new HashMap<>();
        params.put("gender", 1l);
        List<Employee> employeeList = employeeService.getEmployeeList(params);
        System.out.println(employeeList.size());
    }
}