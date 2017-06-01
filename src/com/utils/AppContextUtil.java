package com.utils;

import java.util.Map;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppContextUtil {

	private static AbstractApplicationContext context;

	private AppContextUtil() {
	}

	public static boolean isInited() {
		return context != null;
	}

	public static void startAppContext(String beans) {
		context = new ClassPathXmlApplicationContext(beans);
		context.registerShutdownHook();
	}

	public static AbstractApplicationContext creatAppContext(String beans) {
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext(
				beans);
		ctx.registerShutdownHook();

		return ctx;
	}

	public static Object getBean(String beanName) {
		return context.getBean(beanName);
	}


	public static String[] getBeanNamesForType(Class<?> type) {
		return context.getBeanNamesForType(type);
	}
}
