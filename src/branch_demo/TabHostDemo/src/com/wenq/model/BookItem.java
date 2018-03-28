package com.wenq.model;

import java.util.ArrayList;
import java.util.List;

import com.wenq.tabhostdemo.R;

//书
public class BookItem {

	public BookItem() {
		bookName = "";
		bookSubjectSourceID = R.drawable.subject_150x178;
		pageLst = new ArrayList<PageItem>();
	}

	private String bookName; // 书名称
	private int bookSubjectSourceID; // 书主题图像资源id
	private String bookIntroduce; // 简介
	private String bookDirctory; // 目录
	private String bookPreface; // 前言

	private List<PageItem> pageLst; // 书本页列表

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getBookSubjectSourceID() {
		return bookSubjectSourceID;
	}

	public void setBookSubjectSourceID(int bookSubjectSourceID) {
		this.bookSubjectSourceID = bookSubjectSourceID;
	}

	public List<PageItem> getPageLst() {
		return pageLst;
	}

	public void setPageLst(List<PageItem> pageLst) {
		this.pageLst = pageLst;
	}

	public String getBookIntroduce() {
		return bookIntroduce;
	}

	public void setBookIntroduce(String bookIntroduce) {
		this.bookIntroduce = bookIntroduce;
	}

	public String getBookDirctory() {
		return bookDirctory;
	}

	public void setBookDirctory(String bookDirctory) {
		this.bookDirctory = bookDirctory;
	}

	public String getBookPreface() {
		return bookPreface;
	}

	public void setBookPreface(String bookPreface) {
		this.bookPreface = bookPreface;
	}
}
