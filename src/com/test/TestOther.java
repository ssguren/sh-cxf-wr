package com.test;

import java.text.ParseException;
import java.util.Date;

import com.utils.DateUtil;

public class TestOther {
	public static void main(String[] args) {
		String str="2013-09-23 00:00:00";
		try {
			System.out.println(DateUtil.parseDateSecondFormat(str).toString());
			if (new Date().after(DateUtil.parseDateSecondFormat(str))) {
				System.out.println("11111");
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println(str.substring(0,10));
//		System.out.println(str.substring(11,19));
	}
}	
