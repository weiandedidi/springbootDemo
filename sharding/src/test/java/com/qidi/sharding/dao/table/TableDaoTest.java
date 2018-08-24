package com.qidi.sharding.dao.table;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: qidi
 * Date: 2018/8/24
 * Time: 下午8:17
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TableDaoTest {
    @Autowired
    TableDao tableDao;

    @Test
    public void existTable() {
        String tableName = "user";
        Integer a = tableDao.existTable(tableName);
        System.out.println(a);
    }

    @Test
    public void createNewTable() {
        String tableName = "user_201702";
        Integer a = tableDao.existTable(tableName);
        if (a < 1) {
            tableDao.createNewTable(tableName);
        }
        System.out.println("创建成功");
    }
}