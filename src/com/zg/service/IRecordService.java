package com.zg.service;

import java.util.Date;
import java.util.List;

import com.zg.po.Record;
import com.zg.util.Page;

public interface IRecordService {
	/**
	 * ���
	 * record ���ļ�¼(���Ѽ�¼)
	 * */
	public void saveRecord(Record record);
	/**
	 * admin��ѯ
	 * return ���ж��ļ�¼
	 * */
	public Page findRecords(int pn);
	
	/**
	 * admin�� ʱ���ѯ
	 * time ʱ��
	 * return ���ж��ļ�¼
	 * */
	public List<Record> findRecords(Date time);
}
