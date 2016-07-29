package com.zg.service.sh;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.zg.dao.IRecordDao;
import com.zg.po.Record;
import com.zg.service.IRecordService;
import com.zg.util.Page;

public class RecordServiceImpl implements IRecordService {
	private IRecordDao recordDao;
	
	public void setRecordDao(IRecordDao recordDao) {
		this.recordDao = recordDao;
	}

	public Page findRecords(int pn) {
		int count = recordDao.findRecordSize();
		Page page = new Page(1, count, pn,10 );
		List result = recordDao.findRecords(page.getFirstResult(), page.getMaxResults());
		page.setResult(result);
		return page;
	}

	public List<Record> findRecords(Date time) {
		// TODO Auto-generated method stub
		return null;
	}

	public void saveRecord(Record record) {
		// TODO Auto-generated method stub
		recordDao.saveRecord(record);
	}

}
