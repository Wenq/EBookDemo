package com.wenq.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.content.Context;

//加载要显示的文本等内容
public class BookLoader {

	private BookItem book;
	private String[] pageNameLst; // 页总数

	/**
	 * 加载电子书内容
	 **/
	public BookItem LoadBook(Context context) {
		// 文本特定格式-》
		// 1.txt：简介(第3行为电子书名称)；2.txt：目录；3.txt：前言；4.txt～N.txt：正式内容；每个文本文件第一行为标题。

		InputStream stream = null;
		BufferedReader br1 = null;
		PageItem page = null;

		String pageTitle = "";
		String bookName = "";
		StringBuffer content = null;
		String rowStr = "";

		try {
			book = new BookItem();
			// 获取assert/book目录下所有文件
			pageNameLst = context.getResources().getAssets().list("book");
			if (pageNameLst.length > 0) {

				for (int i = 1; i <= pageNameLst.length; i++) {
					page = new PageItem();
					content = new StringBuffer();
					book.getPageLst().add(page);

					stream = OpenBook(context, String.valueOf(i));
					// txt文件本地全部使用“utf-8”编码保存
					br1 = new BufferedReader(new InputStreamReader(stream,
							"utf-8")); // 从txt文件读取内容
					// TODO:读取内容：
					pageTitle = br1.readLine();
					content.append(pageTitle + "\n");

					if (i == 1) {// 简介
						rowStr = br1.readLine(); // 读取空行
						content.append(rowStr + "\n");
						bookName = br1.readLine(); // 书名所在行内容
						book.setBookName(bookName);
					}

					while ((rowStr = br1.readLine()) != null) {
						content.append(rowStr + "\n");
					}
					page.setPageTitle(pageTitle);
					page.setPageContent(content.toString());
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return book;
	}

	/**
	 * 打开一个txt文件
	 **/
	private InputStream OpenBook(Context context, String name) {
		InputStream stream = null;
		try {
			stream = context.getResources().getAssets()
					.open("book/" + name + ".txt");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stream;
	}
}
