package com.qidi.bootdemo.dao.user;

import com.qidi.bootdemo.model.user.User;

import java.util.List;
import java.util.Map;

public interface UserDao {

	Integer insert(User user);
	
	void update(User user);
	
	User getUserById(Integer id);

    Integer countUser(Map<String, Object> params);

    List<User> getUserList(Map<String, Object> params);
	
}