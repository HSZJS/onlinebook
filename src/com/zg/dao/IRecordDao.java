package com.zg.dao;

import java.util.Date;
import java.util.List;

import com.zg.po.Record;

public interface IRecordDao {
	/**
	 * 添加
	 * record 订阅记录(消费记录)
	 * */
	public void saveRecord(Record record);
	/**
	 * admin查询
	 * return 所有订阅记录
	 * */
	public List findRecords(int firstResult ,int maxResults);
	
	/**
	 * admin按 时间查询
	 * time 时间
	 * return 所有订阅记录
	 * */
	public List<Record> findRecords(Date time);
	
	
	/***
	 * 查询借阅记录总数据总数
	 **/
	public int findRecordSize();
}
