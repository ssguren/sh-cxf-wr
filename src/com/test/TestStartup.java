package com.test;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestStartup {

	private static ApplicationContext applicationContext;

	public static void init() {
		applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		((AbstractApplicationContext) applicationContext)
				.registerShutdownHook();
	}

	public static void init(ApplicationContext context) {
		applicationContext = context;
	}

	public static Object getBean(String name) {
		return applicationContext.getBean(name);
	}

	public static String[] getBeanNamesForType(Class<?> type) {
		return applicationContext.getBeanNamesForType(type);
	}
}
