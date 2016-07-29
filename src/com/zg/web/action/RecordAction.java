package com.zg.web.action;

import java.util.List;

import com.opensymphony.xwork2.Action;
import com.zg.po.Record;
import com.zg.service.IRecordService;
import com.zg.util.Page;

public class RecordAction extends BaseAction{
	private IRecordService recordService;
	private int pn = 1;
	private Page page;
	
	
	public void setRecordService(IRecordService recordService) {
		this.recordService = recordService;
	}
	//管理员查询借阅记录
	public String findRecords(){
		page = recordService.findRecords(pn);
		return Action.SUCCESS;
	}
	public int getPn() {
		return pn;
	}
	public void setPn(int pn) {
		this.pn = pn;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}

	
	

}
