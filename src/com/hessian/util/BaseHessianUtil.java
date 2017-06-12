package com.hessian.util;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import com.caucho.hessian.client.HessianConnectionFactory;
import com.caucho.hessian.client.HessianProxyFactory;

public abstract class BaseHessianUtil {

	protected static <T> T createHessianProxyService(String uriMethod,
			Class<T> cla, boolean hasHeader, Map<String, String> headParams) {
		return createHessianProxyService4Header(uriMethod, cla, -1, -1,
				hasHeader, headParams);
	}

	@SuppressWarnings("unchecked")
	protected static <T> T createHessianProxyService(String uriMethod,
			Class<T> cla, long connectTimeout, long readTimeout) {
		String url = HessianConfigUtil.url + uriMethod;
		HessianProxyFactory factory = new HessianProxyFactory();
		factory.setUser(HessianConfigUtil.hessianUser);
		factory.setPassword(HessianConfigUtil.hessianPassword);

		factory.setDebug(false);
		factory.setOverloadEnabled(true);
		factory.setHessian2Request(true);
		factory.setHessian2Reply(true);
		factory.setConnectTimeout(connectTimeout > 0 ? connectTimeout
				: HessianConfigUtil.connectionTimeout);
		factory.setReadTimeout(readTimeout > 0 ? readTimeout
				: HessianConfigUtil.readTimeout);

		T basic = null;

		try {
			basic = (T) factory.create(cla, url);
		} catch (MalformedURLException e) {
		}

		return basic;
	}

	@SuppressWarnings("unchecked")
	protected static <T> T createHessianProxyService4Header(String uriMethod,
			Class<T> cla, long connectTimeout, long readTimeout,
			boolean hasHeader, Map<String, String> headParams) {
		String url = HessianConfigUtil.url + uriMethod;
		HessianProxyFactory factory = new HessianProxyFactory();
		factory.setUser(HessianConfigUtil.hessianUser);
		factory.setPassword(HessianConfigUtil.hessianPassword);

		factory.setDebug(false);
		factory.setOverloadEnabled(true);
		factory.setHessian2Request(true);
		factory.setHessian2Reply(true);
		factory.setConnectTimeout(connectTimeout > 0 ? connectTimeout
				: HessianConfigUtil.connectionTimeout);
		factory.setReadTimeout(readTimeout > 0 ? readTimeout
				: HessianConfigUtil.readTimeout);

		if (hasHeader) {
			HessianConnectionFactory hessianConnectionFactory = null;
			if (null != headParams && headParams.size() > 0) {
				hessianConnectionFactory = new AuthHessianConnFactoryUtil(
						headParams);
			} else {
				hessianConnectionFactory = new AuthHessianConnFactoryUtil(
						HessianConfigUtil.getHeaderParamMap());
			}
			hessianConnectionFactory.setHessianProxyFactory(factory);
			try {
				hessianConnectionFactory.open(new URL(url));
			} catch (Exception e1) {
			}
			factory.setConnectionFactory(hessianConnectionFactory);
		}

		T basic = null;

		try {
			basic = (T) factory.create(cla, url);
		} catch (MalformedURLException e) {
		}

		return basic;
	}

}
