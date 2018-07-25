package com.qidi.bootdemo.service.user;

import com.alibaba.fastjson.JSONObject;
import com.qidi.bootdemo.dao.user.UserDao;
import com.qidi.bootdemo.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

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
    public User updateUser(User user) {
        System.out.println("员工更新方法调用");
        userDao.update(user);
        return user;
    }

}
