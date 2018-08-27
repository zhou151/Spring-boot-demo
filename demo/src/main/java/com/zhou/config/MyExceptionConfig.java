package com.zhou.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;

/**
 * 
 * @author Mr_zhou
 *	500处理
 *	404处理
 *	@ControllerAdvice 异常扫包范围
 */
@Controller
@ControllerAdvice(basePackages= {"com.zhou.controller"})
public class MyExceptionConfig implements ErrorController{
	private static Logger log = LogManager.getLogger(MyExceptionConfig.class);
	private static final String ERROR_PATH = "/error";	
	
	
	
	@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	public Map<String,Object> errorJson(RuntimeException e,HandlerMethod h)
	{
		HashMap<String, Object> msg=new  HashMap<String,Object>();
		msg.put("异常码","500");
		msg.put("系统繁忙","☹☹☹☹");
		log.warn("发生异常--(全局捕捉)--异常信息-------> {}", e.getMessage());
		log.warn("触发类.方法------>{}",h.toString());
		return msg;
	}
	
	
	/**
	 * 
	 * @fun-name handleError
	 * @return-type String
	 * @author Mr_zhou
	 * @date 2018年8月13日 上午12:42:50
	 * @return
	 * TODO	404处理
	 */
	@RequestMapping(value=ERROR_PATH) 
	public String handleError(){ 
	    return "404"; 
	}
	@Override
	public String getErrorPath()
	{
		return ERROR_PATH;
	}
}
