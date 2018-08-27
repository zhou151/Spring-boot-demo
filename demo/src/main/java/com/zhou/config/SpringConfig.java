package com.zhou.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zhou.servlet.TestFilter;
import com.zhou.servlet.TestListener;
import com.zhou.servlet.TestServlet;
/**
 * 
 * @author Mr_zhou
 * @date 2018年8月3日 下午11:42:04
 * @info  Spring配置类,用于配置依赖注入
 */
@Configuration
public class SpringConfig 
{
	@Bean //服务Servlet bean
	public ServletRegistrationBean<TestServlet> testServlet()
	{
		ServletRegistrationBean<TestServlet> bean=new ServletRegistrationBean<TestServlet>();
		bean.setServlet(new TestServlet());
		bean.addUrlMappings("/TestServlet");
		return bean;
	}
	@Bean // 过滤器Filter bean
	public FilterRegistrationBean<TestFilter> testFilter()
	{
		FilterRegistrationBean<TestFilter>  bean = new FilterRegistrationBean<TestFilter> ();
		bean.setFilter(new TestFilter());
		bean.addUrlPatterns("/*");
		return bean;
	}
	@Bean  //监听器Listener bean
	public ServletListenerRegistrationBean<TestListener> testListener()
	{
		ServletListenerRegistrationBean<TestListener> bean = new  ServletListenerRegistrationBean<TestListener>();
		bean.setListener(new TestListener());
		return bean;
	}
}
