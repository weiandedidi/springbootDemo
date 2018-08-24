package com.qidi.sharding.service.department;

import com.qidi.sharding.dao.department.DepartmentDao;
import com.qidi.sharding.model.department.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: qidi
 * Date: 2018/8/24
 * Time: 上午11:26
 */
@Service
public class DepartmentService {
    @Autowired
    DepartmentDao departmentDao;

    void insert(Department department){
        departmentDao.insert(department);
    }

    void update(Department department) {
        departmentDao.update(department);
    }

    Department getDepartmentById(Long id) {
        return departmentDao.getDepartmentById(id);
    }

    Integer countDepartment(Map<String, Object> params) {
        return departmentDao.countDepartment(params);
    }

    List<Department> getDepartmentList(Map<String, Object> params) {

        List<Department> list;
        list = departmentDao.getDepartmentList(params);
        if (null==list) {
            list = new ArrayList<Department>();
        }
        return list;
    }
}
