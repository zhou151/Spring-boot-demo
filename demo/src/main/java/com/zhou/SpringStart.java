package com.zhou;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@EnableTransactionManagement
@SpringBootApplication
//#######################################################
//##################----SpringBoot启动类-----######################
//#######################################################
//-------------------------------------------------------
@ComponentScan(basePackages ={ "com.zhou.controller", "com.zhou.service" ,"com.zhou.config","com.zhou.aop"})
//-------------------------------------------------------
@MapperScan(basePackages ={ "com.zhou.mapper" })
//-------------------------------------------------------
@ServletComponentScan(basePackages={"com.zhou.servlet"})
//-------------------------------------------------------
public class SpringStart extends SpringBootServletInitializer 
{	
	public static void main(String[] args)
	{
		SpringApplication.run(SpringStart.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application)
	{
		return application.sources(SpringStart.class);
	}
}
