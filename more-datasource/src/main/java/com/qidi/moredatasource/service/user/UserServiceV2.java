package com.qidi.moredatasource.service.user;

import com.qidi.moredatasource.model.user.User;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: qidi
 * Date: 2018/10/10
 * Time: 下午5:53
 */
public interface UserServiceV2 {

    void insert(User user);

    void update(User user);

    User getUserById(Integer id);

    Integer countUser(Map<String, Object> params);

    List<User> getUserList(Map<String, Object> params);
}
