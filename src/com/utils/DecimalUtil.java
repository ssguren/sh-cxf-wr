/**
 * 
 */
package com.utils;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class DecimalUtil {

	private static final DecimalFormat df0 = new DecimalFormat("###,###.000");// ʹ��ϵͳĬ�ϵĸ�ʽ
	private static final DecimalFormat df1 = (DecimalFormat) NumberFormat
			.getPercentInstance();
	private static final DecimalFormat df2 = (DecimalFormat) NumberFormat
			.getPercentInstance();

	static {
		df1.applyPattern("00.000%");
	}

	public static double formatDouble(double val) {
		String s = df0.format(val);
		return Double.parseDouble(s);
	}

	public static String formatDouble2Str(double val) {
		return df0.format(val);
	}

	public static String formatDouble2Precent(double val) {
		return df1.format(val);
	}

	public synchronized static String formatInteger(int val, String pattern) {
		df2.applyPattern(pattern);

		return df2.format(val);
	}

	public static void main(String[] args) {
		System.err.println(formatInteger(102, "0000"));
	}
}
