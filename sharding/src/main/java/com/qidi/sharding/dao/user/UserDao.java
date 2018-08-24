package com.qidi.sharding.dao.user;


import com.qidi.sharding.model.user.User;

import java.util.List;
import java.util.Map;

public interface UserDao {

	void insert(User user);
	
	void update(User user);
	
	User getUserById(Long id);

    Integer countUser(Map<String, Object> params);

    List<User> getUserList(Map<String, Object> params);
	
}