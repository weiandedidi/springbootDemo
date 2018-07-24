package com.qidi.bootdemo.web.listener;

import com.qidi.bootdemo.model.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * 需要resources中META-INF 配置spring.factories
 * User: qidi
 * Date: 2018/7/24
 * Time: 下午4:49
 */
public class MySpringApplicationRunListener implements SpringApplicationRunListener {

//    Caused by: java.lang.NoSuchMethodException: com.qidi.bootdemo.web.listener.MySpringApplicationRunListener.<init>(org.springframework.boot.SpringApplication, [Ljava.lang.String;)
    //需要初始化init方法 否则

    public MySpringApplicationRunListener(SpringApplication application, String[] args) {

    }



    @Override
    public void starting() {
        System.out.println("SpringApplicationRunListener 。。。 start");
    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {

    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {

    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        System.out.println("contextLoaded   。。。。");
    }

    @Override
    public void started(ConfigurableApplicationContext context) {
        //此处已经可以获取所有的bean了，或如spring里的bean
        System.out.println("started   。。。。");
        Person person = (Person) context.getBean("person");
        System.out.println("我是bean person  "+person.getName());

    }

    @Override
    public void running(ConfigurableApplicationContext context) {
        System.out.println("running   。。。。");
    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {

    }
}
