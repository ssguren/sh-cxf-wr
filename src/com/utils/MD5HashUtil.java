package com.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.log4j.Logger;

public class MD5HashUtil {

	private static Logger log = Logger.getLogger(MD5HashUtil.class);

	private static final char[] hexChars = { '0', '1', '2', '3', '4', '5', '6',
			'7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

	private static MessageDigest md = null;

	static {
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			log.error(MiscUtil.traceInfo(e));
		}
	}

	public static String hashCode(String dataToHash) {
		return hashData(dataToHash.getBytes(), false);
	}

	public static String hashCode(String dataToHash, boolean isLowerCase) {
		return hashData(dataToHash.getBytes(), isLowerCase);
	}

	public static String hashCode(String dataToHash, String charsetName) {
		try {
			return hashData(dataToHash.getBytes(charsetName), false);
		} catch (UnsupportedEncodingException e) {
			log.error(MiscUtil.traceInfo(e));
		}

		return null;
	}

	public static String hashCode(String dataToHash, String charsetName,
			boolean isLowerCase) {
		try {
			return hashData(dataToHash.getBytes(charsetName), isLowerCase);
		} catch (UnsupportedEncodingException e) {
			log.error(MiscUtil.traceInfo(e));
		}

		return null;
	}

	public static String hashCode(byte[] dataToHash, boolean isLowerCase) {
		return hashData(dataToHash, isLowerCase);
	}

	public static String to16BitMD5(String md5_32) {
		if (md5_32 != null && md5_32.length() == 32)
			return md5_32.substring(8, 24);

		return null;
	}

	private static String hashData(byte[] dataToHash, boolean isLowerCase) {
		if (isLowerCase)
			return hexStringFromBytes((calculateHash(dataToHash)))
					.toLowerCase();
		else
			return hexStringFromBytes((calculateHash(dataToHash)));
	}

	private static String hexStringFromBytes(byte[] b) {
		String hex = "";
		int msb;
		int lsb = 0;
		int i;

		for (i = 0; i < b.length; i++) {
			msb = (b[i] & 0x000000FF) / 16;
			lsb = (b[i] & 0x000000FF) % 16;
			hex = hex + hexChars[msb] + hexChars[lsb];
		}
		return (hex);
	}

	private static byte[] calculateHash(byte[] dataToHash) {
		md.update(dataToHash, 0, dataToHash.length);
		return (md.digest());
	}

	public static void main(String[] args) {
		String md5_32 = hashCode("331118", Boolean.TRUE);
		System.out.println(md5_32);
		// System.out.println(to16BitMD5(md5_32));
	}
}
