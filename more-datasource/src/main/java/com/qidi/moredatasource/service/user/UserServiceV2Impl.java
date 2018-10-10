package com.qidi.moredatasource.service.user;

import com.qidi.moredatasource.dao.zoo2.userV2.UserV2Dao;
import com.qidi.moredatasource.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: qidi
 * Date: 2018/10/10
 * Time: 下午6:54
 */
@Service
@Transactional(transactionManager = "secondTransactionManager", readOnly = true)
public class UserServiceV2Impl implements UserServiceV2 {

    @Autowired
    UserV2Dao userV2Dao;

    @Override
    @Transactional(readOnly = false)
    public void insert(User user) {
        userV2Dao.insert(user);
    }

    @Override
    @Transactional(readOnly = false)
    public void update(User user) {
        userV2Dao.update(user);
    }

    @Override
    public User getUserById(Integer id) {
        return userV2Dao.getUserById(id);
    }

    @Override
    public Integer countUser(Map<String, Object> params) {
        return userV2Dao.countUser(params);
    }

    @Override
    public List<User> getUserList(Map<String, Object> params) {
        List<User> users = userV2Dao.getUserList(params);
        if (users == null) {
            users = new ArrayList<>();
        }
        return users;
    }
}
