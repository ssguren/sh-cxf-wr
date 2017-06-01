package com.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	public static final String HH = "HH";

	public static final String HHMM = "HH:mm";

	public static final String HHMMSS = "HH:mm:ss";

	public static final String YYYYMMDD = "yyyy-MM-dd";

	public static final String YYYYMMDD_S = "yyyyMMdd";

	public static final String YYYYMMDDHHMM = "yyyy-MM-dd HH:mm";

	public static final String YYYYMMDDHHMMSS = "yyyy-MM-dd HH:mm:ss";

	public static final String YYYYMMDDHHMMSS_S = "yyyyMMddHHmmss";

	public static final String YYYYMMDDHHMMSSSSS = "yyyy-MM-dd HH:mm:ss,SSS";

	public static final String YYYYMMDDHHMMSSSSS_S = "yyyyMMddHHmmssSSS";

	public static java.sql.Date DateToSQLDate(java.util.Date date) {
		return new java.sql.Date(date.getTime());
	}

	public static java.util.Date SQLDateToDate(java.sql.Date date) {
		return new java.util.Date(date.getTime());
	}

	public static synchronized java.util.Date getDate() {
		return new java.util.Date();
	}

	public static synchronized java.util.Date getDate(long millis) {
		return new java.util.Date(millis);
	}

	public static synchronized Calendar getCalendar() {
		return Calendar.getInstance();
	}

	public static synchronized Calendar getCalendar(java.util.Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);

		return cal;
	}

	public static synchronized String getCurrDateTimeFormat() {
		return getDateTimeFormat(getDate());
	}

	public static synchronized String getHourFormat(java.util.Date date) {
		return parseDateFormat(date, HH);
	}

	public static synchronized Calendar parseCalendarHourMinFormat(
			String strDate) throws ParseException {
		return parseCalendarFormat(strDate, HHMM);
	}

	public static synchronized String getDateTimeFormat(java.util.Date date) {
		return parseDateFormat(date, HHMMSS);
	}

	public static synchronized java.util.Date parseDateTimeFormat(String strDate)
			throws ParseException {
		return parseDateFormat(strDate, HHMMSS);
	}

	public static synchronized Calendar parseCalendarTimeFormat(String strDate)
			throws ParseException {
		return parseCalendarFormat(strDate, HHMMSS);
	}

	public static synchronized String getCurrDateDayFormat() {
		return getDateDayFormat(getDate());
	}

	public static synchronized String getDateDayFormat(java.util.Date date) {
		return parseDateFormat(date, YYYYMMDD);
	}

	public static synchronized String getDateDayFormat2(java.util.Date date) {
		return parseDateFormat(date, YYYYMMDD_S);
	}

	public static synchronized java.util.Date parseDateDayFormat(String strDate)
			throws ParseException {
		return parseDateFormat(strDate, YYYYMMDD);
	}

	public static synchronized java.util.Date parseDateDayFormat2(String strDate)
			throws ParseException {
		return parseDateFormat(strDate, YYYYMMDD_S);
	}

	public static synchronized Calendar parseCalendarDayFormat(String strDate)
			throws ParseException {
		return parseCalendarFormat(strDate, YYYYMMDD);
	}

	public static synchronized Calendar parseCalendarDayFormat2(String strDate)
			throws ParseException {
		return parseCalendarFormat(strDate, YYYYMMDD_S);
	}

	public static synchronized String getCurrDateMinuteFormat() {
		return getDateMinuteFormat(getDate());
	}

	public static synchronized String getDateMinuteFormat(java.util.Date date) {
		return parseDateFormat(date, YYYYMMDDHHMM);
	}

	public static synchronized java.util.Date parseDateMinuteFormat(
			String strDate) throws ParseException {
		return parseDateFormat(strDate, YYYYMMDDHHMM);
	}

	public static synchronized Calendar parseCalendarMinuteFormat(String strDate)
			throws ParseException {
		return parseCalendarFormat(strDate, YYYYMMDDHHMM);
	}

	public static synchronized String getCurrDateSecondFormat() {
		return getDateSecondFormat(getDate());
	}

	public static synchronized String getDateSecondFormat(java.util.Date date) {
		return parseDateFormat(date, YYYYMMDDHHMMSS);
	}

	public static synchronized String getDateSecondFormat2(java.util.Date date) {
		return parseDateFormat(date, YYYYMMDDHHMMSS_S);
	}

	public static synchronized java.util.Date parseDateSecondFormat(
			String strDate) throws ParseException {
		return parseDateFormat(strDate, YYYYMMDDHHMMSS);
	}

	public static synchronized java.util.Date parseDateSecondFormat2(
			String strDate) throws ParseException {
		return parseDateFormat(strDate, YYYYMMDDHHMMSS_S);
	}

	public static synchronized Calendar parseCalendarSecondFormat(String strDate)
			throws ParseException {
		return parseCalendarFormat(strDate, YYYYMMDDHHMMSS);
	}

	public static synchronized Calendar parseCalendarSecondFormat2(
			String strDate) throws ParseException {
		return parseCalendarFormat(strDate, YYYYMMDDHHMMSS_S);
	}

	public static synchronized String getCurrDateMilliFormat() {
		return getDateMilliFormat(getDate());
	}

	public static synchronized String getDateMilliFormat(java.util.Date date) {
		return parseDateFormat(date, YYYYMMDDHHMMSSSSS);
	}

	public static synchronized String getDateMilliFormat2(java.util.Date date) {
		return parseDateFormat(date, YYYYMMDDHHMMSSSSS_S);
	}

	public static synchronized java.util.Date parseDateMilliFormat(
			String strDate) throws ParseException {
		return parseDateFormat(strDate, YYYYMMDDHHMMSSSSS);
	}

	public static synchronized java.util.Date parseDateMilliFormat2(
			String strDate) throws ParseException {
		return parseDateFormat(strDate, YYYYMMDDHHMMSSSSS_S);
	}

	public static synchronized Calendar parseCalendarMilliFormat(String strDate)
			throws ParseException {
		return parseCalendarFormat(strDate, YYYYMMDDHHMMSSSSS);
	}

	public static synchronized Calendar parseCalendarMilliFormat2(String strDate)
			throws ParseException {
		return parseCalendarFormat(strDate, YYYYMMDDHHMMSSSSS_S);
	}

	public static synchronized String parseDateFormat(java.util.Date date,
			String pattern) {
		if (date == null)
			return "";

		SimpleDateFormat sdf = new SimpleDateFormat();
		if (pattern != null)
			sdf.applyPattern(pattern);

		return sdf.format(date);
	}

	public static synchronized java.util.Date parseDateFormat(String strDate,
			String pattern) throws ParseException {
		if (StringUtil.isEmptyStr(strDate))
			return null;

		SimpleDateFormat sdf = new SimpleDateFormat();
		if (pattern != null)
			sdf.applyPattern(pattern);

		return sdf.parse(strDate);
	}

	public static synchronized Calendar parseCalendarFormat(String strDate,
			String pattern) throws ParseException {
		if (StringUtil.isEmptyStr(strDate))
			return null;

		SimpleDateFormat sdf = new SimpleDateFormat();
		if (pattern != null)
			sdf.applyPattern(pattern);
		sdf.parse(strDate);

		return (Calendar) sdf.getCalendar().clone();
	}

	public static synchronized boolean isLeapYear() {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		return isLeapYear(year);
	}

	public static synchronized int getYear() {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		return year;
	}

	public static synchronized boolean isLeapYear(java.util.Date date) {
		Calendar gc = Calendar.getInstance();
		gc.setTime(date);
		return isLeapYear(gc.get(Calendar.YEAR));
	}

	public static synchronized boolean isLeapYear(int year) {
		/**
		 * ��ϸ��ƣ� 1.��400��������꣬���� 2.���ܱ�4����������� 3.�ܱ�4���ͬʱ���ܱ�100�����������
		 * 3.�ܱ�4���ͬʱ�ܱ�100�����������
		 */
		if ((year % 400) == 0)
			return true;
		else if ((year % 4) == 0) {
			if ((year % 100) == 0)
				return false;
			else
				return true;
		} else
			return false;
	}

	public static int getDaysBetween(String d1, String d2)
			throws ParseException {
		Calendar c1 = parseCalendarDayFormat(d1);
		Calendar c2 = parseCalendarDayFormat(d2);

		return getDaysBetween(c1, c2);
	}

	public static int getDaysBetween(java.util.Date d1, java.util.Date d2) {
		Calendar c1 = getCalendar(d1);
		Calendar c2 = getCalendar(d2);

		return getDaysBetween(c1, c2);
	}

	public static int getDaysBetween(Calendar c1, Calendar c2) {
		if (c1.after(c2)) {
			java.util.Calendar swap = c1;
			c1 = c2;
			c2 = swap;
		}

		int days = c2.get(Calendar.DAY_OF_YEAR) - c1.get(Calendar.DAY_OF_YEAR);
		int y2 = c2.get(Calendar.YEAR);
		if (c1.get(Calendar.YEAR) != y2) {
			Calendar tmp = (Calendar) c1.clone();
			do {
				days += tmp.getActualMaximum(Calendar.DAY_OF_YEAR);// �õ������ʵ������
				tmp.add(Calendar.YEAR, 1);
			} while (tmp.get(Calendar.YEAR) != y2);
		}

		return days;
	}

	public static synchronized String getDateTimeByTimeRange(String strDate) {
		String res = "";
		String str = strDate.substring(0, 2);
		int num = Integer.parseInt(str);
		if (num >= 0 && num < 12) {
			res = "����";
		} else if (num >= 12 && num < 18) {
			res = "����";
		} else {
			res = "ҹ��";
		}

		return res;
	}

	// ��ȡ�����磬0 ���磬1 ����
	public static synchronized int getAmPmByTimeRange(String strDate)
			throws ParseException {
		java.util.Date date = parseDateFormat(strDate, HHMM);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int res = cal.get(Calendar.AM_PM);

		return res;
	}

	/**
	 * ��yyyyMMddHHmmss�ַ��ʽ������ת����TimeStamp
	 * 
	 * @return
	 */
	public static Timestamp str2TimeStamp14(String ts) {
		if (null == ts || ts.trim().length() != 14)
			return null;
		StringBuilder sb = new StringBuilder();
		sb.append(ts.substring(0, 4));
		sb.append("-");
		sb.append(ts.substring(4, 6));
		sb.append("-");
		sb.append(ts.substring(6, 8));
		sb.append(" 00:00:00.0");

		return Timestamp.valueOf(sb.toString());
	}

	/**
	 * ��yyyymmdd�ַ��ʽ������ת����TimeStamp
	 * 
	 * @return
	 */
	public static Timestamp str2TimeStamp(String ts) {
		if (null == ts || ts.trim().length() != 8)
			return null;
		StringBuilder sb = new StringBuilder();
		sb.append(ts.substring(0, 4));
		sb.append("-");
		sb.append(ts.substring(4, 6));
		sb.append("-");
		sb.append(ts.substring(6, 8));
		sb.append(" 00:00:00");

		return Timestamp.valueOf(sb.toString());
	}

	/**
	 * ��ȡ��ǰ���ڵ���һ��
	 * 
	 * @param currDate
	 * @return
	 */
	public static Date getNextDay(Date currDate) {
		Calendar cd = Calendar.getInstance();
		cd.setTime(currDate);
		cd.set(Calendar.HOUR_OF_DAY, 0);
		cd.set(Calendar.MINUTE, 0);
		cd.set(Calendar.SECOND, 0);
		cd.set(Calendar.MILLISECOND, 0);
		cd.add(Calendar.DAY_OF_YEAR, 1);
		return cd.getTime();
	}

	/**
	 * ��ȡǰһ���ͬ��ʱ��
	 * 
	 * @param currDate
	 * @return
	 */
	public static Date getLastDay(Date currDate) {
		Calendar cd = Calendar.getInstance();
		cd.setTime(currDate);
		cd.add(Calendar.DATE, -1);
		return cd.getTime();
	}

	/**
	 * ��ȡ���ڵĳ�ʼʱ��
	 * 
	 * @param currDate
	 * @return
	 */
	public static Date getInitDateTime(Date currDate) {
		Calendar cd = Calendar.getInstance();
		cd.setTime(currDate);
		cd.set(Calendar.HOUR_OF_DAY, 0);
		cd.set(Calendar.MINUTE, 0);
		cd.set(Calendar.SECOND, 0);
		cd.set(Calendar.MILLISECOND, 0);
		return cd.getTime();
	}

	/**
	 * ��ȡ����Ŀ�ʼʱ��
	 * 
	 * @return
	 * @throws ParseException
	 */
	public static Date getDateTimeOrigin(java.util.Date date)
			throws ParseException {
		Date re = parseDateSecondFormat(getDateDayFormat(date) + " 00:00:00");
		return re;
	}

	/**
	 * ��ȡ����Ľ���ʱ��
	 * 
	 * @return
	 * @throws ParseException
	 */
	public static Date getDateTimeEnd(java.util.Date date)
			throws ParseException {
		Date re = parseDateSecondFormat(getDateDayFormat(date) + " 23:59:59");
		return re;
	}

	/**
	 * ȡ��ָ���·ݵĵ�һ�켰��ʼʱ��
	 * 
	 * @param strdate
	 *            String
	 * @return Date
	 * @throws ParseException
	 */
	public static java.util.Date getMonthBegin(String strdate)
			throws ParseException {
		java.util.Date date = parseDateDayFormat(strdate);
		String beginMonth = parseDateFormat(date, "yyyy-MM") + "-01 00:00:00";

		return parseDateFormat(beginMonth, YYYYMMDDHHMMSS);
	}

	/**
	 * ȡ��ָ���·ݵ����һ�켰����ʱ��
	 * 
	 * @param strdate
	 *            String
	 * @return Date
	 * @throws ParseException
	 */
	public static Date getMonthEnd(String strdate) throws ParseException {
		java.util.Date date = getMonthBegin(strdate);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, 1);
		calendar.add(Calendar.DATE, -1);
		String endMonth = parseDateFormat(calendar.getTime(), "yyyy-MM-dd")
				+ " 23:59:59";
		return parseDateFormat(endMonth, YYYYMMDDHHMMSS);
	}

	/**
	 * �ж��Ƿ���ͬһ��
	 * 
	 * @param when
	 * @param toWhen
	 * @return
	 */
	public static boolean isSameDate(Date when, Date toWhen) {
		String toDate = parseDateFormat(toWhen, "yyyyMMdd");
		String whenDate = parseDateFormat(when, "yyyyMMdd");
		return whenDate.equals(toDate);
	}

	public static void main(String[] args) throws Exception {
		Date when = new Date();
		Date towhen = new Date();
		System.out.println(isSameDate(when, towhen));
		System.out.println(getLastDay(when));
	}

	/**
	 * ǰһ��Ŀ�ʼʱ��
	 * */
	public static Date getAfterStartDay(Date currDate) {
		Calendar cd = Calendar.getInstance();
		cd.setTime(currDate);
		cd.set(Calendar.HOUR_OF_DAY, 0);
		cd.set(Calendar.MINUTE, 0);
		cd.set(Calendar.SECOND, 0);
		cd.set(Calendar.MILLISECOND, 0);
		cd.add(Calendar.DAY_OF_YEAR, -1);
		return cd.getTime();
	}

	/**
	 * ǰһ��Ľ���ʱ��
	 * */
	public static Date getAfterEndDay(Date currDate) {
		Calendar cd = Calendar.getInstance();
		cd.setTime(currDate);
		cd.set(Calendar.HOUR_OF_DAY, 23);
		cd.set(Calendar.MINUTE, 59);
		cd.set(Calendar.SECOND, 59);
		cd.set(Calendar.MILLISECOND, 999);
		cd.add(Calendar.DAY_OF_YEAR, -1);
		return cd.getTime();
	}
}
