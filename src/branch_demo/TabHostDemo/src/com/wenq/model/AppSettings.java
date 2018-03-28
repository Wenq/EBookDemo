package com.wenq.model;

//app�������
public class AppSettings {

	// ����SharedPreference��Key�������û�����Ķ�����ҳ������
	public static String KeyPageNumber = "PageNumber";

	// ����SharedPreference��Key�������û�����Ķ�����ҳ������
	public static String KeyAppStyle = "AppStyle";

	// ����SharedPreference��Key�������û�����Ķ�����ҳ������
	public static String KeyFontSize = "FontSize";

	/**
	 * ���������ַ�������ȡfont size��
	 */
	private static int GetFontSize(String size) {
		int fontsize = 16; // Ĭ��ֵ

		if (size.equalsIgnoreCase("small")) {
			fontsize = 12;
		} else if (size.equalsIgnoreCase("middle")) {
			fontsize = 16;
		} else if (size.equalsIgnoreCase("big")) {
			fontsize = 25;
		} else if (size.equalsIgnoreCase("biggest")) {
			fontsize = 36;
		} else {
			// fontsize = 16;
		}

		return fontsize;
	}

	/**
	 * ����ѡ�е������С��������ȡfont size��
	 */
	public static int GetFontSize(int index) {
		String fontsize = "Middle";
		switch (index) {
		case 0:
			fontsize = "Small";
			break;
		case 1:
			fontsize = "Middle";
			break;
		case 2:
			fontsize = "Big";
			break;
		case 3:
			fontsize = "Biggest";
			break;
		default:
			break;
		}
		return GetFontSize(fontsize);
	}
}
