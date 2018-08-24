package com.qidi.sharding.service.user;

import com.qidi.sharding.model.user.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: qidi
 * Date: 2018/8/24
 * Time: 上午11:32
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    public void addUser() {
        User userOne = new User();
        userOne.setName("haha");
        userOne.setPwd("xxx");
        userService.addUser(userOne);
    }

    @Test
    public void getUserById() {
        User userOne = userService.getUserById(4L);
        System.out.println("================ 第一次调用 ================");
        User userTwo = userService.getUserById(4L);

        System.out.println("================ 第二次调用 ================");
        System.out.println(userTwo.getId());

        System.out.println(userTwo.getName());
    }

    @Test
    public void updateUser() {
    }

    @Test
    public void getUserList() {
    }
}