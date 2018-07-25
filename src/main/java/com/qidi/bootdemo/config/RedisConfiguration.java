package com.qidi.bootdemo.config;

import com.alibaba.fastjson.support.spring.FastJsonRedisSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: qidi
 * Date: 2018/7/24
 * Time: 下午8:39
 * <p>
 * 缓存倒入自动配置类
 * 0 = "org.springframework.boot.autoconfigure.cache.GenericCacheConfiguration"
 * 1 = "org.springframework.boot.autoconfigure.cache.JCacheCacheConfiguration"
 * 2 = "org.springframework.boot.autoconfigure.cache.EhCacheCacheConfiguration"
 * 3 = "org.springframework.boot.autoconfigure.cache.HazelcastCacheConfiguration"
 * 4 = "org.springframework.boot.autoconfigure.cache.InfinispanCacheConfiguration"
 * 5 = "org.springframework.boot.autoconfigure.cache.CouchbaseCacheConfiguration"
 * 6 = "org.springframework.boot.autoconfigure.cache.RedisCacheConfiguration"
 * 7 = "org.springframework.boot.autoconfigure.cache.CaffeineCacheConfiguration"
 * 8 = "org.springframework.boot.autoconfigure.cache.SimpleCacheConfiguration"
 * 9 = "org.springframework.boot.autoconfigure.cache.NoOpCacheConfiguration"
 * 配置生效条件：
 *
 * @Configuration
 * @ConditionalOnBean({Cache.class})
 * @ConditionalOnMissingBean({CacheManager.class})
 * @Conditional({CacheCondition.class}) 意味着
 * 1. 需要有cache ben
 * 2. 配置类中生成CacheManager缓存管理器，管理各种缓存(Cache)组件
 * <p>
 * @CacheEvict 用于delete方法
 * @Cacheable 主要针对方法配置，能够根据方法的请求参数对其结果进行缓存
 * @CacheEvict 清空缓存
 * keyGenerator 生成器
 * <p>
 *
 * 不要使用fastjson作为序列化，因为没有"@class"属性，无法反序列化成javeBEAN
 */
@EnableCaching
@Configuration
@ConditionalOnClass(RedisOperations.class)
@EnableConfigurationProperties(RedisProperties.class)
@ConfigurationProperties(prefix = "spring.cache.redis")

public class RedisConfiguration {

    private Logger logger = LoggerFactory.getLogger(RedisConfiguration.class);

    //此处配置的序列化是失败的，需要配置RedisCacheConfiguration 中keySerializationPair 和value
    @Bean(name = "redisTemplate")
    @ConditionalOnMissingBean(name = "redisTemplate")
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();

        //使用fastjson序列化
        FastJsonRedisSerializer fastJsonRedisSerializer = new FastJsonRedisSerializer(Object.class);
        // value值的序列化采用fastJsonRedisSerializer
        template.setValueSerializer(valueSerializer());
        template.setHashValueSerializer(valueSerializer());
        // key的序列化采用StringRedisSerializer
        template.setKeySerializer(keySerializer());
        template.setHashKeySerializer(keySerializer());
        template.setConnectionFactory(redisConnectionFactory);
        logger.debug("自定义序列化模版");
        return template;
    }

    //缓存管理器

    /**
     * 缓存管理器可以使用本地缓存，也可以使用redis
     * 详见{@link CacheProperties}
     * 添加了build方法，可以用redisConnectionFactory创建
     *
     * @param redisConnectionFactory
     * @return
     */
//    @Bean("myCacheManager")
    @Bean("myCacheManager")
    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
        //方法一： 建造器构建 这里需要给出别的序列化方法
//        RedisCacheManager.RedisCacheManagerBuilder builder = RedisCacheManager
//                .RedisCacheManagerBuilder
//                .fromConnectionFactory(redisConnectionFactory);
//        return builder.build();
        //1. 获取缓存写入器  是否加入读写锁头
        RedisCacheWriter cacheWriter = RedisCacheWriter.lockingRedisCacheWriter(redisConnectionFactory);
        //2. 获取默认配置
        //3. 失效时间
        RedisCacheConfiguration cacheConfig = RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofMinutes(15))
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(valueSerializer()));
        //5.序列化
        RedisCacheManager cm = RedisCacheManager.builder(redisConnectionFactory)
                .cacheDefaults(cacheConfig)
                .build();
        return cm;
    }


    //这里可以自己写keygenerate
    @Bean("myKeyGenerator")
    public KeyGenerator keyGenerator() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object o, Method method, Object... objects) {
                return method.getName() + "[" + Arrays.asList(objects).toString() + "]";
            }
        };
    }


    private RedisSerializer<String> keySerializer() {
        return new StringRedisSerializer();
    }

    private RedisSerializer<Object> valueSerializer() {
        return new GenericJackson2JsonRedisSerializer();
    }


}