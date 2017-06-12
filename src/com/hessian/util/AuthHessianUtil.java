package com.hessian.util;

import java.util.Map;

import org.apache.log4j.Logger;

import com.hessian.client.IAuthHessianService;

public class AuthHessianUtil extends BaseHessianUtil {

	protected static final Logger log = Logger.getLogger(AuthHessianUtil.class);

	private static String uriMethod = "authService";

	public static IAuthHessianService service() {
		return createHessianProxyService(uriMethod, IAuthHessianService.class,
				false, null);
	}

	public static IAuthHessianService service4AuthHeader(
			Map<String, String> headParams) {
		return createHessianProxyService(uriMethod, IAuthHessianService.class,
				true, headParams);
	}
}
