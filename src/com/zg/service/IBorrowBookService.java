package com.zg.service;

import java.util.List;

import com.zg.po.Borrowbook;
import com.zg.util.Page;
import com.zg.vo.BorrowBookInfo;

public interface IBorrowBookService {
	/**
	 * ���
	 * userid �û�id
	 * bookid ͼ��id
	 * */
	public void save(Borrowbook borrowBook);
	/**
	 * ����û����ĵ�ͼ��
	 * id  �û�id
	 * return ��Ӧ�û����ĵ�����ͼ��id
	 * */
	public Page findBooks(int userid,int pn);
	/**
	 * �޸�  ���ڵ�ͼ�齫�����Զ�  ʧЧ
	 * userid �û�id
	 * bookid ͼ��id
	 * */
	public void update(int userid,int bookid);
	
	public List findUserBookID(int userid);
}
