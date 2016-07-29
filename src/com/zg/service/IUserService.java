package com.zg.service;

import java.util.List;

import com.zg.po.Book;
import com.zg.po.CostRecord;
import com.zg.po.User;
import com.zg.util.Page;
import com.zg.vo.UserVip;

public interface IUserService {
public User login(String email,String password);
	
	/**
	 * 用户注册
	 * user 用户 (默认添加ispay 为 0 , balance 为 0)
	 * */
	public void saveUser(User user);
	/**
	 * 验证用户是否存在
	 * email 邮箱
	 * return true表示存在, flase表示不存在
	 * */
	public boolean validateEmailIsExist(String email);
	
	/**
	 * 修改用户
	 * user 用户
	 * */
	public void updateUser(User user);
	
	/**
	 * 删除用户
	 * id 用户id
	 * */
	public void deleteUser(int id);
	/**
	 * 查看付费用户
	 *return 所有付费用户
	 * */
	public Page findPayUser(int id, int pn);
	/**
	 * 充值
	 * id 用户id
	 * money  充值钱数
	 * */
	public void recharge(int id,float money);
	/**
	 * 订阅
	 * userid 用户id
	 * bookid 图书id
	 * bookname 图书名字
	 * username 用户名字
	 * money  订阅图书花费的钱数
	 * */
	public void subscribe(int userid,int bookid,float money,String bookname,String username);
	/**
	 * 查看自定订阅的图书  读书
	 * id 用户id
	 * return 订阅的图书
	 * */
	public List<Book> findSubscribeBooks(int id);

	public void updatePhoto(int id, String rename);

	public List findUsers();

	public User findUserById(int id);
	
	public User findUserByEmail(String email);
	public void zhuanzhang(String fromEmail,String toEmail,float money) ;
	
	public float findBalance(int id);
	public void updatePwdByEmail(String email,String password);
	public void updateUserByHql(User user);
	public void changeBanlan(User user);
	public void saveRecord(String userid,float cost,String bookid,String chapterid);
	public boolean isCost(String userid,String chapterid);
	
	public List<CostRecord> listCost(String userid);
}
