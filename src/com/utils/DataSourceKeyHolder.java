package com.utils;

public class DataSourceKeyHolder {

	public static final String DATA_SOURCE_A = "readDb";
	public static final String DATA_SOURCE_B = "writeDb";
	private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

	public static void setCustomerType(String customerType) {
		contextHolder.set(customerType);
	}

	public static String getCustomerType() {
		return contextHolder.get();
	}

	public static void clearCustomerType() {
		contextHolder.remove();
	}

	public static void changeDbsa() {
		setCustomerType(DATA_SOURCE_A);
	}

	public static void changeDbsb() {
		setCustomerType(DATA_SOURCE_B);
	}
}
