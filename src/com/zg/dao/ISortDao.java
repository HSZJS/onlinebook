package com.zg.dao;

import java.util.List;

import com.zg.po.Sort;

public interface ISortDao {
	/** 
	 * ���ͼ������
	 * id   ͼ���id
	 * name ͼ������
	 * 
	 * **/
	public void saveSort(int id,String name);
	/**
	 * �޸�ͼ������
	 * id   ͼ���id
	 * name ͼ������
	 * */
	public void updateSort(int id ,String name);
	/**
	 * ɾ��ͼ������
	 * id ͼ��id
	 * 
	 * **/
	public void deleteSort(int id);
	
	/**
	 * ��һ�η�����ҳʱ(�൱�ڵ��������)
	 * 
	 *
	 * return ����������
	 * **/
	public List<Sort> findSorts();
	/**
	 * ����ӷ���
	 * id ����id
	 * return �ӷ���
	 * */
	public List<Sort> findSubSorts(int code);
	/**
	 * �������һ������      ���Ǹ���
	 * */
	
	public Sort findParentSort(int code);


}
