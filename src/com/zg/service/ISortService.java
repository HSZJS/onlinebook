package com.zg.service;

import java.util.List;
import java.util.Map;

import com.zg.po.Sort;

public interface ISortService {

	public void saveSort(int id,String name);

	public void updateSort(int id ,String name);

	public void deleteSort(int id);

	public List findSorts();
	
	public List findeSubSorts(int code);
}
