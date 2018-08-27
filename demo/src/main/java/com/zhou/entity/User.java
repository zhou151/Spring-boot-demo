package com.zhou.entity;


/**
 * User实体类
 * @author Mr_zhou
 * @date 2018年8月3日 下午11:54:12
 * @Data 自动完成get,set.使用插件lombok自动完成
 */
public class User
{
	private String name;
	private String pass;
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getPass()
	{
		return pass;
	}
	public void setPass(String pass)
	{
		this.pass = pass;
	}
	
}
