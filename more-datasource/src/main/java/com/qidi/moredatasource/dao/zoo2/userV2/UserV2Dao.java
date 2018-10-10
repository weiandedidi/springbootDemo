package com.qidi.moredatasource.dao.zoo2.userV2;


import com.qidi.moredatasource.model.user.User;

import java.util.List;
import java.util.Map;

public interface UserV2Dao {

	Integer insert(User user);
	
	void update(User user);
	
	User getUserById(Integer id);

    Integer countUser(Map<String, Object> params);

    List<User> getUserList(Map<String, Object> params);
	
}