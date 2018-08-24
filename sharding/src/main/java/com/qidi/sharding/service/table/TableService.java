package com.qidi.sharding.service.table;

import com.qidi.sharding.dao.table.TableDao;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 操作table的操作类
 * User: qidi
 * Date: 2018/8/24
 * Time: 下午8:11
 */
@Service
@Transactional(readOnly = true)
public class TableService {

    @Autowired
    TableDao tableDao;

    private static Map<String, String> TABLE_NAME_MAP = new HashMap<String, String>();

    private Logger logger = LoggerFactory.getLogger(TableService.class);
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");

    public boolean existTable(String tableName) {
        Integer count = tableDao.existTable(tableName);
        boolean hasTable = false;
        if (count > 0) {
            hasTable = true;
        }
        return hasTable;
    }

    @Transactional(readOnly = false)
    public void createNewTable(String tableName) {
        String baseTableName = tableName;
        String nowTable = baseTableName + "_" + sdf.format(new Date());
        boolean hasTable = false;
        hasTable = (TABLE_NAME_MAP.get(nowTable) != null);
        if (!hasTable) {
            hasTable = (tableDao.existTable(nowTable) > 0);
            if (!hasTable) {
                tableDao.createNewTable(nowTable);
                logger.info("========= create new +" + nowTable + "+ table ");
            }
            TABLE_NAME_MAP.put(nowTable, nowTable);
        }
    }

}
