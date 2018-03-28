package com.wenq.model;

//阅读进度(进度信息保存在SharedPreference中)
public class ReadProgress {

	private String bookName; // 书名称
	private int pageNum; // 阅读进度页号
	private int readedWordNum; // 页中已阅读字数

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
