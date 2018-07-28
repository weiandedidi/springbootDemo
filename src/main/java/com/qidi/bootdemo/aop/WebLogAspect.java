package com.qidi.bootdemo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: qidi
 * Date: 2018/7/28
 * Time: 上午11:33
 */
@Aspect
@Component
public class WebLogAspect {
    private Logger logger = LoggerFactory.getLogger(WebLogAspect.class);

    @Pointcut("execution(* com.qidi.bootdemo.web.controller..*(..))")
    public void pointCut(){}


    @Around("pointCut()")
    public Object aroundInvoke(ProceedingJoinPoint point) throws Throwable {
        logger.info("around 执行参数是：" + Arrays.asList(point.getArgs()));

        Object object = point.proceed(point.getArgs());
        logger.info("返回结果  " + object);
        return object;

    }
}
