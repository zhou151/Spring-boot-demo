package com.zhou.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.zhou.controller.AjaxController;

import lombok.extern.log4j.Log4j2;

/**
 * Application Lifecycle Listener implementation class TestListener
 *
 */
@WebListener
public class TestListener implements ServletContextListener {
	private static Logger log= LogManager.getLogger(TestListener.class);
    public void contextDestroyed(ServletContextEvent sce)  { 
    	log.info("Web-Servlet-监听器销毁");
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	log.info("Web-Servlet-监听器启动");
    }
	
}
