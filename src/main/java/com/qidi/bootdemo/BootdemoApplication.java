package com.qidi.bootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

@SpringBootApplication
//servlet组件扫描
@ServletComponentScan
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
