package com.qidi.sharding.service.user;

import com.qidi.sharding.dao.user.UserDao;
import com.qidi.sharding.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * user的service
 * User: qidi
 * Date: 2018/7/24
 * Time: 上午11:38
 */
@Service
public class UserService {

    @Autowired
    UserDao userDao;


    public User addUser(User user) {
        userDao.insert(user);
        return user;
    }

    /**
     * @return
     */

    public User getUserById(Long id) {

        return userDao.getUserById(id);
    }

    /**
     * @param user
     * @return
     * @Caching可以和 类的@CacheConfig(value="") 配合使用
     */
    public User updateUser(User user) {
        System.out.println("员工更新方法调用");
        userDao.update(user);
        return user;
    }

    /**
     *
     * @param params
     * @return
     */
    List<User> getUserList(Map<String, Object> params) {
        List<User> list;
        list = userDao.getUserList(params);
        if (null == list) {
            list = new ArrayList<User>();
        }
        return list;
    }

}
