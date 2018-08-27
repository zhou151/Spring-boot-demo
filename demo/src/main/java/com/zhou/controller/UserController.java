package com.zhou.controller;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.zhou.entity.User;
import com.zhou.service.UserService;
/**
 * 
 * @author Mr_zhou
 * @date 2018年8月4日 上午12:48:46
 * @RestController 对应的是mvc模式中的c，即控制层，主要关注请求分发
 */

@Aspect
@RestController
public class UserController
{
	@Autowired
	private UserService userService ;
	@RequestMapping("/inuser")
	public int insertUser(String name,String pass)
	{
		return userService.insertUser(name, pass);
	}
	
	@RequestMapping("/select")
	public PageInfo<User> select(int page,int pageSize)
	{
		return userService.select(page, pageSize);
	}
}
