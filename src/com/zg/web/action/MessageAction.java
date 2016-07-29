package com.zg.web.action;

import java.util.Date;
import java.util.List;

import com.zg.dao.IMessageDao;
import com.zg.po.Message;
import com.zg.po.User;

public class MessageAction extends BaseAction{
	
	private IMessageDao messageDao; 
	
	private String bookid;
	
	private List list;
	
	public String to(){
		bookid = this.getRequest().getParameter("bookid");
		return "to";
	}
	
	public String save (){
		
		String notic = this.getRequest().getParameter("notic");
		User user = (User)this.getRequest().getSession().getAttribute("user");
		String userid = user.getId()+"";
		Message m = new Message ();
		if(bookid!=null&&!"".equals(bookid)){
			m.setBookid(bookid);
		}
		m.setContent(notic);
		m.setCreatetime(new Date());
		m.setUserid(userid);
		messageDao.save(m);
		if(bookid!=null&&!"".equals(bookid)){
			return "save";	
		}
		return "look";
	}
	public String look (){
		User user = (User)this.getRequest().getSession().getAttribute("user");
		
		list = messageDao.getByUser(user.getId()+"");
		this.getRequest().setAttribute("list", list);
		return "look";
	}
	public void setMessageDao(IMessageDao messageDao) {
		this.messageDao = messageDao;
	}

	public String getBookid() {
		return bookid;
	}

	public void setBookid(String bookid) {
		this.bookid = bookid;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

}
