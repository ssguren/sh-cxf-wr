package com.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class StartUpListener implements ServletContextListener {

	private static final Logger log = Logger.getLogger(StartUpListener.class);

	private static WebApplicationContext applicationContext;

	public void contextInitialized(ServletContextEvent ctxEvn) {
		applicationContext = WebApplicationContextUtils
				.getWebApplicationContext(ctxEvn.getServletContext());
		if (applicationContext != null) {
			log.info("applicationContext:" + applicationContext);
			log.info("StartUpListener inited!");
		} else {
			log.fatal("StartUpListener init failed!");
		}
	}

	public void contextDestroyed(ServletContextEvent ctxEvn) {
		log.info("StartUpListener destroyed!");
	}

	public static Object getBean(String beanName) {
		return applicationContext.getBean(beanName);
	}

	public static String[] getBeanNamesForType(Class<?> type) {
		return applicationContext.getBeanNamesForType(type);
	}
}
