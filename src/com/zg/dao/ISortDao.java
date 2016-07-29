package com.zg.dao;

import java.util.List;

import com.zg.po.Sort;

public interface ISortDao {
	/** 
	 * 添加图书种类
	 * id   图书的id
	 * name 图书的类别
	 * 
	 * **/
	public void saveSort(int id,String name);
	/**
	 * 修改图书种类
	 * id   图书的id
	 * name 图书的类别
	 * */
	public void updateSort(int id ,String name);
	/**
	 * 删除图书种类
	 * id 图书id
	 * 
	 * **/
	public void deleteSort(int id);
	
	/**
	 * 第一次访问主页时(相当于点击主分类)
	 * 
	 *
	 * return 返回主分类
	 * **/
	public List<Sort> findSorts();
	/**
	 * 获得子分类
	 * id 分类id
	 * return 子分类
	 * */
	public List<Sort> findSubSorts(int code);
	/**
	 * 获得其上一级分类      即是父亲
	 * */
	
	public Sort findParentSort(int code);


}
