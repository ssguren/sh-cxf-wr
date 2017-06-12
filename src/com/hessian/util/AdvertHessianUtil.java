package com.hessian.util;

import org.apache.log4j.Logger;

import com.hessian.client.IAdvertHessianService;

public class AdvertHessianUtil extends BaseHessianUtil {

	protected static final Logger log = Logger.getLogger(AuthHessianUtil.class);

	private static String uriMethod = "advertService";

	public static IAdvertHessianService service() {
		return createHessianProxyService(uriMethod,
				IAdvertHessianService.class, false, null);
	}

}
