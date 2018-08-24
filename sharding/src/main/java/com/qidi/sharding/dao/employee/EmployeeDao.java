package com.qidi.sharding.dao.employee;


import com.qidi.sharding.model.employee.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeDao {

	void insert(Employee employee);
	
	void update(Employee employee);
	
	Employee getEmployeeById(Long id);

    Integer countEmployee(Map<String, Object> params);

    List<Employee> getEmployeeList(Map<String, Object> params);
	
}