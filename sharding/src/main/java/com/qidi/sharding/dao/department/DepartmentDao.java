package com.qidi.sharding.dao.department;

import com.qidi.sharding.model.department.Department;

import java.util.List;
import java.util.Map;

public interface DepartmentDao {

	void insert(Department department);
	
	void update(Department department);
	
	Department getDepartmentById(Long id);

    Integer countDepartment(Map<String, Object> params);

    List<Department> getDepartmentList(Map<String, Object> params);
	
}