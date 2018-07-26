package com.qidi.bootdemo.service.user;

import com.qidi.bootdemo.model.user.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: qidi
 * Date: 2018/7/24
 * Time: 上午11:44
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    UserService userService;
    @Autowired
    CacheManager cacheManager;

    @Test
    public void getUserById() {

        User userOne = userService.getUserById(4);
        System.out.println("================ 第一次调用 ================");
        User userTwo = userService.getUserById(4);

        System.out.println("================ 第二次调用 ================");
        System.out.println(userTwo.getId());

        System.out.println(userTwo.getName());
    }

    @Test
    public void getUserByIdV2() {

        User userOne = userService.getUserByIdV2(4);
        System.out.println("================ 第一次调用 ================");
        User userTwo = userService.getUserByIdV2(4);

        System.out.println("================ 第二次调用 ================");
        System.out.println(userTwo.getId());

        System.out.println(userTwo.getName());
    }

    @Test
    public void addUser() {
        User user = new User();
        user.setName("丽丽");
        user.setPwd("54321");
       User newUser =  userService.addUser(user);
        System.out.println(newUser.getId());

    }

    @Test
    public void updateUser() {
        User user = userService.getUserById(3);
        user.setPwd("12345");
        User newUser =  userService.updateUser(user);
        System.out.println(newUser.getPwd());
    }

    @Test
    public void testTransactional() {
        User user = userService.getUserById(3);
        user.setPwd("888888");
        User newUser =  userService.updateUserV2(user);
        System.out.println(newUser.getPwd());
    }

    @Test
    public void testTransactionManager() {
        User user = userService.getUserById(3);
        user.setPwd("888888");
        User newUser =  userService.updateUserV3(user);
        System.out.println(newUser.getPwd());
    }

}