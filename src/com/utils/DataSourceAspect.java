package com.utils;

import java.lang.reflect.Method;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.utils.DataSourceKeyHolder;

@Aspect
@Component
public class DataSourceAspect {

	protected final Logger log = LogManager.getLogger(getClass());

	// @Pointcut("execution(* com.apc.cms.service.*.*(..))")
	public void pointCut() {
	};

	@Before("execution(* card.servicecenter.db.*.*(..))")
	public void before(JoinPoint point) {
		Object target = point.getTarget();
		System.out.println(target.toString());
		String method = point.getSignature().getName();
		System.out.println(method);
		Class<?>[] classz = target.getClass().getInterfaces();
		Class<?>[] parameterTypes = ((MethodSignature) point.getSignature())
				.getMethod().getParameterTypes();
		try {
			Method m = classz[0].getMethod(method, parameterTypes);
			System.out.println(m.getName());
			if (m != null && m.isAnnotationPresent(DataSource.class)) {
				DataSource data = m.getAnnotation(DataSource.class);
				DataSourceKeyHolder.setCustomerType(data.value());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
