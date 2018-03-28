package com.wenq.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.content.Context;

//����Ҫ��ʾ���ı�������
public class BookLoader {

	private BookItem book;
	private String[] pageNameLst; // ҳ����

	/**
	 * ���ص���������
	 **/
	public BookItem LoadBook(Context context) {
		// �ı��ض���ʽ-��
		// 1.txt�����(��3��Ϊ����������)��2.txt��Ŀ¼��3.txt��ǰ�ԣ�4.txt��N.txt����ʽ���ݣ�ÿ���ı��ļ���һ��Ϊ���⡣

		InputStream stream = null;
		BufferedReader br1 = null;
		PageItem page = null;

		String pageTitle = "";
		String bookName = "";
		StringBuffer content = null;
		String rowStr = "";

		try {
			book = new BookItem();
			// ��ȡassert/bookĿ¼�������ļ�
			pageNameLst = context.getResources().getAssets().list("book");
			if (pageNameLst.length > 0) {

				for (int i = 1; i <= pageNameLst.length; i++) {
					page = new PageItem();
					content = new StringBuffer();
					book.getPageLst().add(page);

					stream = OpenBook(context, String.valueOf(i));
					// txt�ļ�����ȫ��ʹ�á�utf-8�����뱣��
					br1 = new BufferedReader(new InputStreamReader(stream,
							"utf-8")); // ��txt�ļ���ȡ����
					// TODO:��ȡ���ݣ�
					pageTitle = br1.readLine();
					content.append(pageTitle + "\n");

					if (i == 1) {// ���
						rowStr = br1.readLine(); // ��ȡ����
						content.append(rowStr + "\n");
						bookName = br1.readLine(); // ��������������
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
	 * ��һ��txt�ļ�
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
