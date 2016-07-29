package com.zg.service;

import java.util.Date;
import java.util.List;

import com.zg.po.Record;
import com.zg.util.Page;

public interface IRecordService {
	/**
	 * 添加
	 * record 订阅记录(消费记录)
	 * */
	public void saveRecord(Record record);
	/**
	 * admin查询
	 * return 所有订阅记录
	 * */
	public Page findRecords(int pn);
	
	/**
	 * admin按 时间查询
	 * time 时间
	 * return 所有订阅记录
	 * */
	public List<Record> findRecords(Date time);
}
