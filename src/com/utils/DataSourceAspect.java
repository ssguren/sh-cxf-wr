package com.utils;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DataSourceAspect {

	protected final Logger log = LogManager.getLogger(getClass());

	private Map<String, String> method_type = new HashMap<String, String>();

	@Pointcut("execution(* com.servicecenter.service.buss.*.*(..))")
	public void aspect() {
	};

	@Before("aspect()")
	public void before(JoinPoint point) {
		Object target = point.getTarget();
		log.info(target.toString());
		String methodName = point.getSignature().getName();
		// log.info(methodName);
		Class<?>[] classz = target.getClass().getInterfaces();
		Class<?>[] parameterTypes = ((MethodSignature) point.getSignature())
				.getMethod().getParameterTypes();
		try {
			Method method = classz[0].getMethod(methodName, parameterTypes);
			log.info(method.getName());
			// getRightDbType4All(methodName);
			getRightDbType4Anno(method);
		} catch (Exception e) {
			log.info(MiscUtil.traceInfo(e));
		}
	}

	// 完全匹配方法名
	private void getRightDbType4All(String methodName) {
		if (method_type.containsKey(methodName)) {
			if (StringUtil.isEmptyStr(DataSourceKeyHolder.getCustomerType())
					|| !DataSourceKeyHolder.getCustomerType().equals(
							method_type.get(methodName))) {
				DataSourceKeyHolder
						.setCustomerType(method_type.get(methodName));
			}
		}
	}

	// 按方法开头匹配方法名
	private void getRightDbType4Start(String methodName) {
		Set<String> ks = method_type.keySet();
		for (String key : ks) {
			if (methodName.startsWith(key)) {
				DataSourceKeyHolder.setCustomerType(method_type.get(key));
				break;
			}
		}
	}

	// 按注解匹配方法
	private void getRightDbType4Anno(Method method) {
		if (null != method) {
			boolean flag = method.isAnnotationPresent(DataSource.class);
			if (flag) {
				DataSource data = method.getAnnotation(DataSource.class);
				DataSourceKeyHolder.setCustomerType(data.value());
			}
		}
	}

	public Map<String, String> getMethod_type() {
		return method_type;
	}

	public void setMethod_type(Map<String, String> method_type) {
		this.method_type = method_type;
	}

}
