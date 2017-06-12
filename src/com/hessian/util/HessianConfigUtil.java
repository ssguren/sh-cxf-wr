package com.hessian.util;

import java.util.HashMap;
import java.util.Map;

import com.utils.DateUtil;
import com.utils.MD5HashUtil;

public class HessianConfigUtil {

	protected static long connectionTimeout = 5000;

	protected static long readTimeout = 180000;

	/**
	 * 默认Hessian请求验证用户姓名
	 */
	protected static String hessianUser = "client1";

	/**
	 * 默认Hessian请求验证用户密码
	 */
	protected static String hessianPassword = "client1";

	protected static String headKey = "hessianDemo";

	protected static String url;

	protected static Map<String, String> headerParamMap = new HashMap<String, String>();

	public static Map<String, String> getHeaderParamMap() {
		if (headerParamMap == null) {
			headerParamMap = new HashMap<String, String>();
		}
		String timestamp = DateUtil.getDate().getTime() + "";
		headerParamMap.put("timestamp", timestamp);
		headerParamMap.put("sign", MD5HashUtil.hashCode(timestamp + headKey));
		return headerParamMap;
	}

	public static void setHeaderParamMap(Map<String, String> headerParamMap) {
		HessianConfigUtil.headerParamMap = headerParamMap;
	}

	public static long getConnectionTimeout() {
		return connectionTimeout;
	}

	public void setConnectionTimeout(long connectionTimeout) {
		HessianConfigUtil.connectionTimeout = connectionTimeout;
	}

	public static long getReadTimeout() {
		return readTimeout;
	}

	public void setReadTimeout(long readTimeout) {
		HessianConfigUtil.readTimeout = readTimeout;
	}

	public static String getHessianUser() {
		return hessianUser;
	}

	public void setHessianUser(String hessianUser) {
		HessianConfigUtil.hessianUser = hessianUser;
	}

	public static String getHessianPassword() {
		return hessianPassword;
	}

	public void setHessianPassword(String hessianPassword) {
		HessianConfigUtil.hessianPassword = hessianPassword;
	}

	public static String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		HessianConfigUtil.url = url;
	}

	public void setHeadKey(String headKey) {
		HessianConfigUtil.headKey = headKey;
	}

}
