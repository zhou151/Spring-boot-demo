package com.zhou.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhou.entity.User;
import com.zhou.mapper.UserMapper;
/**
 * 
 * @author Mr_zhou
 * @date 2018年8月4日 上午12:47:21
 * @service是Mvc中的m,即业务层,主要关注业务逻辑
 * @Transactional 本类所有方法开启事务，异常时回滚数据
 */
@Service
@Transactional
public class UserService
{
	@Autowired
	private UserMapper usermapper;
	
	public int insertUser(String name,String pass)
	{
		int result =usermapper.insertUser(name, pass);
		return result;
	}
	/**
	 * 
	 * @fun-name select
	 * @return-type List<User>
	 * @author Mr_zhou
	 * @date 2018年8月7日 上午10:29:19
	 * @param page 当前页
	 * @param pagesize  当前展示多少页
	 * @return
	 * TODO readOnly=true 只读=是
	 */
	@Transactional(readOnly=true)
	public PageInfo<User> select (int page,int pageSize)
	{
		PageHelper.startPage(page,pageSize);
		List<User> name=usermapper.select();
		PageInfo<User> pageInfo = new PageInfo<User>(name);
		return pageInfo;
	}
}
