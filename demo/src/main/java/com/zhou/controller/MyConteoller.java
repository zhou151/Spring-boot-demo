package com.zhou.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * spring控制器类
 * 
 * @author Mr_zhou
 * @date 2018年8月3日 下午5:09:42
 * @info 测试JdbcTemplate
 * @RestController 本类所有方法返回json格式，这里用于直接输出到页面
 * @RequestMapping("dbtest")跳转映射
 * @Autowired 自动装配依赖
 */
@Controller
public class MyConteoller 
{
	/*@Autowired
	private JdbcTemplate jdbcTemplate;*/
	private static final String ERROR_PATH = "/error";
	/**
	 * 
	 * @fun-name mvc2
	 * @return-type String
	 * @author Mr_zhou
	 * @date 2018年8月10日 下午6:47:04
	 * @param i
	 * @return
	 * TODO 模拟异常发生
	 */
	@ResponseBody
	@RequestMapping("errorTest")
	public String mvc2(int i)
	{
		return 5/i+"";
	}
}
