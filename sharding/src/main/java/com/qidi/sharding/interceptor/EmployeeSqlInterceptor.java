package com.qidi.sharding.interceptor;

import com.qidi.sharding.service.table.TableService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;


/**
 * Created with IntelliJ IDEA.
 * User: qidi
 * Date: 2018/8/24
 * Time: 下午7:33
 */
@Aspect
@Component
public class EmployeeSqlInterceptor {

    private static Map<String, String> TABLE_NAME_MAP = new HashMap<String, String>();

    private Logger logger = LoggerFactory.getLogger(EmployeeSqlInterceptor.class);
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");

    @Autowired
    TableService tableService;


    @Before("execution(* com.qidi.sharding.service.employee.EmployeeService.insert*(..))")
    public void insetNewTable(JoinPoint joinPoint) {
        String tableName = "employee";
        tableService.createNewTable(tableName);
    }


}
