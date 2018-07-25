package com.qidi.bootdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;



//servlet组件扫描
@ServletComponentScan	//servlet组件扫描
@SpringBootApplication
@MapperScan(value = "com.qidi.bootdemo.dao")	//mapper包注解扫描
@EnableScheduling	//开启定时任务
@EnableAsync	//开启异步调用
public class BootdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootdemoApplication.class, args);
//		SpringApplicationBuilder()
	}

	@Bean
	public ViewResolver myViewResoler(){
		return new MyViewResoler();
	}
	private static class MyViewResoler implements ViewResolver{

		@Override
		public View resolveViewName(String s, Locale locale) throws Exception {
			return null;
		}
	}
}
