package com.zg.service.sh;

import java.util.List;

import com.zg.dao.IUserDao;
import com.zg.po.Book;
import com.zg.po.CostRecord;
import com.zg.po.User;
import com.zg.service.IUserService;
import com.zg.util.Page;
import com.zg.vo.UserVip;

public class UserServiceImpl implements IUserService {
	private IUserDao userDao;
	
	public void updatePwdByEmail(String email,String password){
		userDao.updatePwdByEmail(email, password);
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		userDao.deleteUser(id);
	}

	public Page findPayUser(int id, int pn) {
		int count = userDao.findVips();
		Page page = new Page(id,count,pn,10);
		List result = userDao.findPayUser(id, page.getFirstResult(), page.getMaxResults());
		page.setResult(result);
		return page;
	}

	public List<Book> findSubscribeBooks(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public User findUserById(int id) {
		// TODO Auto-generated method stub
		return userDao.findUserById(id);
	}

	public List<User> findUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	public User login(String email, String password) {
		// TODO Auto-generated method stub
		return userDao.login(email, password);
	}

	public void recharge(int id, float money) {
		// TODO Auto-generated method stub
		userDao.recharge(id, money);
	}

	public void saveUser(User user) {
		// TODO Auto-generated method stub
		userDao.saveUser(user);
	}

	public void subscribe(int userid, int bookid, float money, String bookname,
			String username) {
		// TODO Auto-generated method stub

	}

	public void updatePhoto(int id, String rename) {
		// TODO Auto-generated method stub

	}

	public void updateUser(User user) {
		// TODO Auto-generated method stub
		userDao.updateUser(user);
	}

	public boolean validateEmailIsExist(String email) {
		// TODO Auto-generated method stub
		return userDao.validateEmailIsExist(email);
	}

	public void zhuanzhang(String fromEmail, String toEmail, float money) {
		// TODO Auto-generated method stub
		//����
		userDao.zhuanzhang(fromEmail, -money);
		//����
		userDao.zhuanzhang(toEmail, money);
	}

	public User findUserByEmail(String email) {
		// TODO Auto-generated method stub
		return userDao.findUserByEmail(email);
	}

	public float findBalance(int id) {
		// TODO Auto-generated method stub
		return userDao.findBalance(id);
	}
	public void updateUserByHql(User user){
		userDao.updateUserByHql(user);
	}
	public void changeBanlan(User user){
		userDao.changeBanlan(user);
	}
	public void saveRecord(String userid,float cost,String bookid,String chapterid){
		userDao.saveRecord(userid, cost, bookid, chapterid);
	}
	public boolean isCost(String userid,String chapterid){
		return userDao.isCost(userid,chapterid);
	}
	public List<CostRecord> listCost(String userid){
		return userDao.listCost(userid);
	}
}
