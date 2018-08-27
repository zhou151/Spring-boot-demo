package com.zhou.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 
 * @author Mr_zhou
 * @date 2018年8月3日 下午4:40:28
 * @info @Controller 控制器类 用于映射jsp页面
 */
@Controller
public class TaskController
{
	
	/**
	 * @info 配置映射http://127.0.0.1:8080/index 即可访问index.jsp
	 *@parameter  @return
	 *@return String
	 *@author Mr_zhou
	 *@date 2018年8月3日 下午4:40:09
	 */
	
	@RequestMapping("/index")
    public String mvc1(ModelMap model) {
		model.addAttribute("message", "Hello Spring MVC Framework!");
        return "index";
    }

	
}
