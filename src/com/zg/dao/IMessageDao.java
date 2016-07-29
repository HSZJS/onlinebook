package com.zg.dao;

import java.util.List;

import com.zg.po.Message;

public interface IMessageDao {
	
	public void save(Message m);
	
	public List getAll(String userid);
	
	public List getByUser(String userid);
}
