package com.qidi.bootdemo.service.user;

import com.qidi.bootdemo.dao.user.UserDao;
import com.qidi.bootdemo.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

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

    /**
     * 通过获取用户
     *
     * @return
     */
    @Cacheable(value = "users", key = "'user_'+#id")
    public User getUserById(Integer id) {

        return userDao.getUserById(id);
    }


    public User addUser(User user) {
        userDao.insert(user);
        return user;
    }

    public User updateUser(User user) {
        userDao.update(user);
        return user;
    }


}
