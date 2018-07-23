package com.qidi.bootdemo.dao;

import com.qidi.bootdemo.model.Person;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: qidi
 * Date: 2018/7/23
 * Time: 下午8:57
 */
@Repository
public interface PersonDao {
    void personAdd(Person person);

}
