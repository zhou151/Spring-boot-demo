package com.zhou.service;

import com.github.pagehelper.PageInfo;
import com.zhou.entity.User;

public interface UserService {

	int insertUser(String name, String pass);

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
	PageInfo<User> select(int page, int pageSize);

}