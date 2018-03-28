package com.wenq.model;

//app设置相关
public class AppSettings {

	// 访问SharedPreference的Key：保存用户最近阅读到的页数号码
	public static String KeyPageNumber = "PageNumber";

	// 访问SharedPreference的Key：保存用户最近阅读到的页数号码
	public static String KeyAppStyle = "AppStyle";

	// 访问SharedPreference的Key：保存用户最近阅读到的页数号码
	public static String KeyFontSize = "FontSize";

	/**
	 * 根据描述字符串，获取font size。
	 */
	private static int GetFontSize(String size) {
		int fontsize = 16; // 默认值

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
	 * 根据选中的字体大小索引，获取font size。
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
