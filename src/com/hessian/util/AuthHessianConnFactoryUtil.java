package com.hessian.util;

import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.Set;

import com.caucho.hessian.client.HessianConnection;
import com.caucho.hessian.client.HessianURLConnection;
import com.caucho.hessian.client.HessianURLConnectionFactory;

public class AuthHessianConnFactoryUtil extends HessianURLConnectionFactory {

	// 报文头参数
	private Map<String, String> headerParamMap = null;

	/**
	 * 报文头参数，通过构造方法传入
	 * 
	 * @param headerParamMap
	 */
	public AuthHessianConnFactoryUtil(Map<String, String> headerParamMap) {
		this.headerParamMap = headerParamMap;
	}

	@Override
	public HessianConnection open(URL url) throws IOException {
		HessianURLConnection hessianURLConnection = (HessianURLConnection) super
				.open(url);

		if (null != headerParamMap && !headerParamMap.isEmpty()) {
			Set<String> keySet = headerParamMap.keySet();
			for (String key : keySet) {
				// 向报文头中添加参数
				hessianURLConnection.addHeader(key, headerParamMap.get(key));
			}
		}
		return hessianURLConnection;
	}
}
