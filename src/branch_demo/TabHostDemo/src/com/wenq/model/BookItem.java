package com.wenq.model;

import java.util.ArrayList;
import java.util.List;

import com.wenq.tabhostdemo.R;

//��
public class BookItem {

	public BookItem() {
		bookName = "";
		bookSubjectSourceID = R.drawable.subject_150x178;
		pageLst = new ArrayList<PageItem>();
	}

	private String bookName; // ������
	private int bookSubjectSourceID; // ������ͼ����Դid
	private String bookIntroduce; // ���
	private String bookDirctory; // Ŀ¼
	private String bookPreface; // ǰ��

	private List<PageItem> pageLst; // �鱾ҳ�б�

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
