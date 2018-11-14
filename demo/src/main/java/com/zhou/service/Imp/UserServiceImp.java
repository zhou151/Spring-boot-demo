package com.zhou.service.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhou.dao.mapper.UserMapper;
import com.zhou.entity.User;
import com.zhou.service.UserService;
/**
 * 
 * @author Mr_zhou
 * @date 2018年8月4日 上午12:47:21
 * @service是Mvc中的m,即业务层,主要关注业务逻辑
 * @Transactional 本类所有方法开启事务，异常时回滚数据
 */
@Service
@Transactional
public class UserServiceImp implements UserService
{
	@Autowired
	private UserMapper usermapper;
	
	/* (non-Javadoc)
	 * @see com.zhou.service.UserServiceInter#insertUser(java.lang.String, java.lang.String)
	 */
	@Override
	public int insertUser(String name,String pass)
	{
		int result =usermapper.insertUser(name, pass);
		return result;
	}
	/* (non-Javadoc)
	 * @see com.zhou.service.UserServiceInter#select(int, int)
	 */
	@Override
	@Transactional(readOnly=true)
	public PageInfo<User> select (int page,int pageSize)
	{
		PageHelper.startPage(page,pageSize);
		List<User> name=usermapper.select();
		PageInfo<User> pageInfo = new PageInfo<User>(name);
		return pageInfo;
	}
}
