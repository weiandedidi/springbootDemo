package com.qidi.bootdemo.service.user;

import com.qidi.bootdemo.dao.user.UserDao;
import com.qidi.bootdemo.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * user的service
 *
 * @CacheEvict 用于delete方法
 * @Cacheable 主要针对方法配置，能够根据方法的请求参数对其结果进行缓存
 * @CacheEvict 清空缓存
 * <p>
 * User: qidi
 * Date: 2018/7/24
 * Time: 上午11:38
 */
@Service
@CacheConfig(cacheManager = "myCacheManager")
public class UserService {

    @Autowired
    UserDao userDao;


    public User addUser(User user) {
        userDao.insert(user);
        return user;
    }


    /**
     * 通过获取用户
     * 缓存不指定key 只写cacheNames 或者默认只输入一个值 ，key就是参数 param：：id（传入参数）
     *
     * @return
     */
//    @Cacheable(value = "users", key = "'user_'+#id")
//    @Cacheable(cacheNames = "users")
//    @Cacheable(value = "users", keyGenerator = "myKeyGenerator")
//    @Cacheable(value = "users", condition = "#id>2",cacheManager = "myCacheManager")
    @Cacheable(value = "users", condition = "#id>2")
    public User getUserById(Integer id) {

        return userDao.getUserById(id);
    }

    @Cacheable(value = "users", keyGenerator = "myKeyGenerator")
    public User getUserByIdV2(Integer id) {

        return userDao.getUserById(id);
    }

    /**
     * 调用，更新缓存
     * 先调用方法，然后将结果缓存
     * key = "#user.id"
     *
     * @param user
     * @return
     * @Caching可以和 类的@CacheConfig(value="") 配合使用
     */
//    @CachePut(value = "users",keyGenerator = "myKeyGenerator")

//    @Caching(put = @CachePut(),cacheable = @Cacheable(),evict = @CacheEvict)
    @CachePut(value = "users", key = "#user.id")
    @Transactional
    public User updateUser(User user) {
        System.out.println("员工更新方法调用");
        userDao.update(user);
        return user;
    }

    /**
     * 测试事务使用
     *
     * @param user
     * @return
     */
    @Transactional
    public User updateUserV2(User user) {
        System.out.println("员工更新方法调用");
        userDao.update(user);
        throw new RuntimeException("自造一个错误 数据回滚。。。");
    }

    /**
     * 测试事务的maneger
     * 看使用哪个事务管理器
     *
     * @param user
     * @return
     */
    @Transactional("transactionManager1")
//    @Transactional("transactionManager2")
    public User updateUserV3(User user) {
        System.out.println("员工更新方法调用");
        userDao.update(user);
        throw new RuntimeException("自造一个错误 数据回滚。。。");
    }


}
