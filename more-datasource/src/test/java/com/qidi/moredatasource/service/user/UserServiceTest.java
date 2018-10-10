package com.qidi.moredatasource.service.user;

import com.qidi.moredatasource.model.user.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: qidi
 * Date: 2018/10/10
 * Time: 下午7:03
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTest {
    @Autowired
    UserService userService;

    @Test
    public void insert() {
        User user = new User();
        user.setName("zoo test 1");
        user.setPwd("zoo-xxx");
        userService.insert(user);
        System.out.println("== insert success ====");
    }

    @Test
    public void update() {
    }

    @Test
    public void getUserById() {
    }

    @Test
    public void countUser() {
    }

    @Test
    public void getUserList() {
    }
}