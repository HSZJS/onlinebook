package com.zg.dao;

import java.util.List;

import com.zg.po.Borrowbook;
import com.zg.vo.BorrowBookInfo;

public interface IBorrowBookDao {
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
	public List findBooks(int userid,int firstResult,int maxResults);
	/**
	 * �޸�  ���ڵ�ͼ�齫�����Զ�  ʧЧ
	 * userid �û�id
	 * bookid ͼ��id
	 * */
	public void update(int userid,int bookid);
	/**
	 * ͨ���û�id  �õ����������ܹ��Ķ���ͼ��(�����жϽ��ģ����Ĺ�����û�е��ڵ� �����ٽ���)
	 * userid  �û�id
	 * */
	public List findUserBookID(int userid);
	
	/**
	 * �����û�����ͼ����ܸ���
	 * **/
	public int findUserBorrowBooks(int userid);
	
}
