package com.qidi.sharding.service.employee;

import com.qidi.sharding.dao.employee.EmployeeDao;
import com.qidi.sharding.model.employee.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: qidi
 * Date: 2018/8/24
 * Time: 上午11:07
 */
@Service
@Transactional(readOnly = true)
public class EmployeeService {

    @Autowired
    EmployeeDao employeeDao;

    @Transactional(readOnly = false)
    void insert(Employee employee) {
        employeeDao.insert(employee);
    }

    @Transactional(readOnly = false)
    void update(Employee employee) {
        employeeDao.update(employee);
    }

    Employee getEmployeeById(Long id) {
        return employeeDao.getEmployeeById(id);
    }

    Integer countEmployee(Map<String, Object> params) {
        return employeeDao.countEmployee(params);
    }

    List<Employee> getEmployeeList(Map<String, Object> params) {
        List<Employee> employees;
        employees = employeeDao.getEmployeeList(params);
        if (null == employees) {
            employees = new ArrayList<Employee>();
        }
        return employees;
    }


}
