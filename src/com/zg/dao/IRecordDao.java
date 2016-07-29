package com.zg.dao;

import java.util.Date;
import java.util.List;

import com.zg.po.Record;

public interface IRecordDao {
	/**
	 * ���
	 * record ���ļ�¼(���Ѽ�¼)
	 * */
	public void saveRecord(Record record);
	/**
	 * admin��ѯ
	 * return ���ж��ļ�¼
	 * */
	public List findRecords(int firstResult ,int maxResults);
	
	/**
	 * admin�� ʱ���ѯ
	 * time ʱ��
	 * return ���ж��ļ�¼
	 * */
	public List<Record> findRecords(Date time);
	
	
	/***
	 * ��ѯ���ļ�¼����������
	 **/
	public int findRecordSize();
}
