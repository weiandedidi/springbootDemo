package com.qidi.sharding.shard;

import com.google.code.shardbatis.strategy.ShardStrategy;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: qidi
 * Date: 2018/8/24
 * Time: 下午2:52
 */
public class ShardStrategyByYearMonthImpl implements ShardStrategy {
    private static Log log = LogFactory.getLog(ShardStrategyByYearMonthImpl.class);
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");

    /**
     *
     * @param baseTableName 逻辑表名,一般是没有前缀或者是后缀的表名
     * @param params mybatis执行某个statement时使用的参数
     * @param mapperId mybatis配置的statement id
     * @return
     */
    @Override
    public String getTargetTableName(String baseTableName, Object params, String mapperId) {
        return baseTableName + "_" + sdf.format(new Date());
    }
}
