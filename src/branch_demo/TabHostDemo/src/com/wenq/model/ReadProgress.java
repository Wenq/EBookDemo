package com.wenq.model;

//�Ķ�����(������Ϣ������SharedPreference��)
public class ReadProgress {

	private String bookName; // ������
	private int pageNum; // �Ķ�����ҳ��
	private int readedWordNum; // ҳ�����Ķ�����

	private String getBookName() {
		return bookName;
	}

	private void setBookName(String bookName) {
		this.bookName = bookName;
	}

	private int getPageNum() {
		return pageNum;
	}

	private void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	private int getReadedWordNum() {
		return readedWordNum;
	}

	private void setReadedWordNum(int readedWordNum) {
		this.readedWordNum = readedWordNum;
	}
}
