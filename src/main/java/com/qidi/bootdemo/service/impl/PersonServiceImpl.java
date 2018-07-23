package com.qidi.bootdemo.service.impl;

import com.qidi.bootdemo.dao.PersonDao;
import com.qidi.bootdemo.model.Person;
import com.qidi.bootdemo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created with IntelliJ IDEA.
 * User: qidi
 * Date: 2018/7/23
 * Time: 下午9:00
 */
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonDao personDao;

    @Override
    public void personAdd(Person person) {
        personDao.personAdd(person);
    }
}
