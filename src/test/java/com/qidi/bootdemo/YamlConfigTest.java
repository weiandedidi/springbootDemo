package com.qidi.bootdemo;

import com.qidi.bootdemo.model.Person;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created with IntelliJ IDEA.
 * User: qidi
 * Date: 2018/7/20
 * Time: 上午10:56
 */
@Ignore
@RunWith(SpringRunner.class)
@SpringBootTest
public class YamlConfigTest {
    @Autowired
    Person person;

    @Test
    public void testConfiguer() {
        //成功注入
        System.out.println(person.getName());
        System.out.println(person.getDepartmentNos());
        System.out.println(person.getAccountMap());
    }
}