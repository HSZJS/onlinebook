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
	 * �û�ע��
	 * user �û� (Ĭ�����ispay Ϊ 0 , balance Ϊ 0)
	 * */
	public void saveUser(User user);
	/**
	 * ��֤�û��Ƿ����
	 * email ����
	 * return true��ʾ����, flase��ʾ������
	 * */
	public boolean validateEmailIsExist(String email);
	
	/**
	 * �޸��û�
	 * user �û�
	 * */
	public void updateUser(User user);
	
	/**
	 * ɾ���û�
	 * id �û�id
	 * */
	public void deleteUser(int id);
	/**
	 * �鿴�����û�
	 *return ���и����û�
	 * */
	public Page findPayUser(int id, int pn);
	/**
	 * ��ֵ
	 * id �û�id
	 * money  ��ֵǮ��
	 * */
	public void recharge(int id,float money);
	/**
	 * ����
	 * userid �û�id
	 * bookid ͼ��id
	 * bookname ͼ������
	 * username �û�����
	 * money  ����ͼ�黨�ѵ�Ǯ��
	 * */
	public void subscribe(int userid,int bookid,float money,String bookname,String username);
	/**
	 * �鿴�Զ����ĵ�ͼ��  ����
	 * id �û�id
	 * return ���ĵ�ͼ��
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
