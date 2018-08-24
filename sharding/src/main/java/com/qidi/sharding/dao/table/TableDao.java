package com.qidi.sharding.dao.table;

import org.apache.ibatis.annotations.Param;

/**
 * 操作table的操作类
 * User: qidi
 * Date: 2018/8/24
 * Time: 下午8:11
 */
public interface TableDao {

    int existTable(String tableName);

    void createNewTable(@Param("tableName") String tableName);

}
