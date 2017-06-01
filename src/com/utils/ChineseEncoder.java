package com.utils;

import java.nio.ByteBuffer;

import org.apache.log4j.Logger;

public class ChineseEncoder {

	private static final Logger log = Logger.getLogger(ChineseEncoder.class);

	public static byte GBK_CODE = 1;

	public static byte BIG5_CODE = 2;

	public static byte NOTKOWN = 10;

	private static String GBKCODE_FILE = "GBKCode.bin";

	private static String BIG5CODE_FILE = "Big5Code.bin";

	private static byte[] GBK_TABLE = null;

	private static byte[] BIG5_TABLE = null;

	static {
		if (GBK_TABLE == null)
			GBK_TABLE = getBytesFromFile(GBKCODE_FILE);
		if (BIG5_TABLE == null)
			BIG5_TABLE = getBytesFromFile(BIG5CODE_FILE);
	}

	private static byte[] getBytesFromFile(String fileprop) {
		try {
			ByteBuffer bb = FileUtil.File2ByteBuffer(FileUtil.getFileURLInCP(
					fileprop).getFile());
			return bb.array();
		} catch (Exception e) {
			log.error("Load word lib error!");
			return null;
		}
	}

	public static String simplify(String source, byte src_code) {
		byte[] convertTable = null;
		byte[] Text = null;

		if (source == null)
			return "";
		try {
			if (src_code == GBK_CODE) {
				convertTable = GBK_TABLE;
				Text = source.getBytes("GBK");
			} else if (src_code == BIG5_CODE) {
				convertTable = BIG5_TABLE;
				Text = source.getBytes("BIG5");
			} else
				convertTable = GBK_TABLE;

			int max = Text.length - 1;
			int p = 0;
			for (int i = 0; i < max; i++) {
				if (Text[i] < 0) {
					p = ((Text[i] & 0xff) << 8 | (Text[i + 1] & 0xff)) << 1;
					Text[i++] = convertTable[p++];
					Text[i] = convertTable[p];
				}
			}
			return Full2Semi(new String(Text, "GBK"));
		} catch (Exception e) {
			return "";
		}
	}

	// ȫ��ת���
	private static String Full2Semi(String source) {
		char[] Text = source.toCharArray();
		int max = Text.length;
		int n = 0;
		for (int i = 0; i < max; i++) {
			n = Text[i];
			if ((n >= 65281) && (n < 65373)) {
				n = n - 65248;
				Text[i] = (char) n;
			}
		}

		return new String(Text);
	}

	// �ж��Ƿ��ɺ����ַ�
	public static boolean IsChinese(String source) {
		char[] Text = source.toCharArray();
		int max = Text.length;
		for (int i = 0; i < max; i++) {
			int n = Text[i];
			if (n > 128)
				return true;
		}

		return false;
	}
}