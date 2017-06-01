package com.utils;

public class DealStringTimeUtil {

	/**
	 * �Ƚ�����ʱ���,��������true������false�����ﲻ�����賿ʱ���23:00-1:00.
	 * 
	 * @param timeStr
	 * @param timeStr2
	 * @return
	 */
	public static boolean compareDealStringTime(String timeStr1, String timeStr2) {
		String[] timeArr1 = timeStr1.split("-");
		String[] timeArr2 = timeStr2.split("-");
		if (changeTimeStrToInt(timeArr1[0]) >= changeTimeStrToInt(timeArr2[0])
				&& changeTimeStrToInt(timeArr1[0]) <= changeTimeStrToInt(timeArr2[1])) {
			return true;
		}
		if (changeTimeStrToInt(timeArr1[1]) >= changeTimeStrToInt(timeArr2[0])
				&& changeTimeStrToInt(timeArr1[1]) <= changeTimeStrToInt(timeArr2[1])) {
			return true;
		}
		if (changeTimeStrToInt(timeArr1[0]) <= changeTimeStrToInt(timeArr2[0])
				&& changeTimeStrToInt(timeArr1[1]) >= changeTimeStrToInt(timeArr2[1])) {
			return true;
		}
		return false;
	}

	private static int changeTimeStrToInt(String timeStr) {
		String[] str = timeStr.split(":");
		String temp = str[0] + str[1];
		int ret = 0;
		try {
			ret = Integer.parseInt(temp);
		} catch (Exception e) {
			e.printStackTrace();
			ret = 0;
		}
		return ret;
	}
}
