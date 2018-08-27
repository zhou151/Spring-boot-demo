package com.zhou.aop;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import lombok.extern.log4j.Log4j2;
/**
 * @author Mr_zhou
 * 2018年8月11日 下午3:43:18
 * TODO Spring Boot Aop切面编程
 */
@Aspect
@Component
public class WebAop {
	private static Logger log = LogManager.getLogger(WebAop.class);
//	@Pointcut("execution(public * com.zhou.controller..*.*(..))")
//	public void webLog() {}
//	
//	/**
//	 * *前置通知，方法调用前被调用
//	 * @param joinPoint
//	 */
//	@Before("webLog()")
//	public void doBefore(JoinPoint joinPoint)
//	{
//		log.info("@Before-----前置感知-----访问者信息");
//		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = attributes.getRequest();
//        log.info("访问者ip:--> "+request.getRemoteAddr());
//        log.info("触发的--包名--方法名"+joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
//	}
//	
//	// 方法体执行后，在方法return返回值前执行
//    @After("webLog()")
//    public void doAfterAdvice(JoinPoint joinPoint) 
//    {
//    	log.info("@After----After通知-----------");
//    }
//	
//	/**
//	 * *方法return返回值之后执行，需要对方法返回值做加工的可以用此通知
//	 * @param ret
//	 */
//	/*@AfterReturning在切入点return内容之后切入内容（可以处理返回结果）*/
//	@AfterReturning(returning = "ret", pointcut = "webLog()")
//	public void doAfterReturning(Object ret) 
//	{
//		log.info("@AfterReturning--------return内容之后切入内容---返回的内容--> "+ret);
//	}
}
