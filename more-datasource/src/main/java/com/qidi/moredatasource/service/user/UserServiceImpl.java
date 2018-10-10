package com.qidi.moredatasource.service.user;

import com.qidi.moredatasource.dao.zoo.user.UserDao;
import com.qidi.moredatasource.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 测试各自的事务类
 * <p>
 * User: qidi
 * Date: 2018/10/10
 * Time: 下午5:51
 */
@Service
@Transactional(transactionManager = "primaryTransactionManager", readOnly = true)
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    @Transactional(readOnly = false)
    public void insert(User user) {
        userDao.insert(user);
    }

    @Override
    @Transactional(readOnly = false)
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public User getUserById(Integer id) {
        return userDao.getUserById(id);
    }

    @Override
    public Integer countUser(Map<String, Object> params) {
        return userDao.countUser(params);
    }

    @Override
    public List<User> getUserList(Map<String, Object> params) {
        List<User> users = userDao.getUserList(params);
        if (users == null) {
            users = new ArrayList<>();
        }
        return users;
    }
}
