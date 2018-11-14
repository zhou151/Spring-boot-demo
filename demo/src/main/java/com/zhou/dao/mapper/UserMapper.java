package com.zhou.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.zhou.entity.User;

@Mapper
public interface UserMapper
{
	/**
	 * @info 返回List集合的User
	 *@parameter  @return
	 *@return List<User>
	 *@author Mr_zhou
	 *@date 2018年8月4日 上午12:43:24
	 */
	/*带参数查询*/
	/*@Select("select * from tab where name=#{name}")
	User findName(@Param("name") String name);*/
	
	/*不带参数查询*/
	@Select("select * from tab")
	List<User> select();
	/**
	 * @info 数据插入接口
	 *@parameter  @param name
	 *@parameter  @param pass
	 *@parameter  @return
	 *@return int
	 *@author Mr_zhou
	 *@date 2018年8月3日 下午10:01:34
	 */

	@Insert("insert into tab(name,pass) values(#{name},#{pass})")
	int insertUser(@Param("name")  String name,@Param("pass")  String pass);
}
