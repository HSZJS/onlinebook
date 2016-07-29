package com.zg.dao.sh;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;

import com.zg.dao.IUserDao;
import com.zg.exception.LoginFailException;
import com.zg.po.Book;
import com.zg.po.CostRecord;
import com.zg.po.User;
import com.zg.util.HibernateTemplate;
import com.zg.vo.UserVip;

public class UserShDao implements IUserDao {
	private HibernateTemplate hibernateTemplate;

	public void setSessionFactory(SessionFactory sessionFactory) {
		hibernateTemplate = new HibernateTemplate(sessionFactory);
	}

	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		String sql = "update user set isdel = 1 where id = ?";
		hibernateTemplate.updateWithSQL(sql, new Object[]{id});
	}


	public List findPayUser(int id ,int firstResult ,int maxResults) {
		// TODO Auto-generated method stub
		String hql = "select new com.zg.vo.UserVip(id,email,nickname,realName,idCard,qq,phoneNumber,sex) from User where ispay = 1 and isdel = 0";
		return hibernateTemplate.queryForList(hql, null, firstResult, maxResults);
	}


	public List<Book> findSubscribeBooks(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	public User login(String email, String password) {
		// TODO Auto-generated method stub
		String hql = "from User where email = ? and password = ?";
		User user = (User) hibernateTemplate.queryForObject(hql, new Object[]{email,password});
		if(user == null){
			throw new LoginFailException();
		}
		return user;
	}


	public void recharge(int id, float money) {
		// TODO Auto-generated method stub
		String sql = "update user set balance = balance+ ? ,ispay = 1 where id = ?";
		hibernateTemplate.updateWithSQL(sql, new Object[]{money,id});
		
		CostRecord cr = new CostRecord();
		cr.setCost(money);
		cr.setUserid(id+"");
		hibernateTemplate.save(cr);
		
	}


	public void saveUser(User user) {
		// TODO Auto-generated method stub
		///String hql = "insert into User where email = ? and password = ?";
		hibernateTemplate.saveOrUpdate(user);
	}


	public void subscribe(int userid, int bookid, float money, String bookname,
			String username) {
		// TODO Auto-generated method stub

	}

	public void updateUserByHql(User user){
		hibernateTemplate.update(user);
	}
	
	public void changeBanlan(User user){
		String sql = "update user set balance = "+user.getBalance()+" where id ="+user.getId()+"";
		hibernateTemplate.updateWithSQL(sql, null);
	}
	
	public void saveRecord(String userid,float cost,String bookid,String chapterid){
		
		String bookName = hibernateTemplate.find("select name from Book where id="+bookid).get(0).toString();
		String chapterName = hibernateTemplate.find("select title from Chapter where id="+chapterid).get(0).toString();
		
		CostRecord cr = new CostRecord();
		cr.setUserid(userid);
		cr.setCost(cost);
		cr.setBookid(bookid);
		cr.setChapterid(chapterid);
		cr.setBookName(bookName);
		cr.setChapterName(chapterName);
		hibernateTemplate.save(cr);
	}
	
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer();
		List<Object> params = new ArrayList<Object>();
		sql.append("update user set isdel = 0 ");
		if(user.getNickname() != null){
			sql.append(", nickname = ? ");
			params.add(user.getNickname());
		}
		if(user.getSex() != null){
			sql.append(", sex = ? ");
			params.add(user.getSex());
		}
		if(user.getPic() != null){
			sql.append(", pic = ? ");
			params.add(user.getPic());
		}
		if(user.getIdCard() != null){
			sql.append(", idCard = ? ");
			params.add(user.getIdCard());
		}
		if(user.getPhoneNumber() != null){
			sql.append(", phoneNumber = ? ");
			params.add(user.getPhoneNumber());
		}
		if(user.getRealName() != null){
			sql.append(", realName = ? ");
			params.add(user.getRealName());
		}
		if(user.getQq() != null){
			sql.append(", qq = ? ");
			params.add(user.getQq());
		}
		if(user.getQuestion() != null){
			sql.append(", question = ? ");
			params.add(user.getQuestion());
		}
		if(user.getAnswer() != null){
			sql.append(", answer = ? ");
			params.add(user.getAnswer());
		}
		sql.append("where id = ?");
		params.add(user.getId());
		hibernateTemplate.updateWithSQL(sql.toString(), params.toArray());
		
	}


	public boolean validateEmailIsExist(String email) {
		// TODO Auto-generated method stub
		//falg = true 表示email已被占用
		//flag = false 表示可以注册

		boolean flag = false;
		String sql = "select id from user where email = ?";
		
		Object obj = hibernateTemplate.queryForObjectWithSQL(sql, new Object[]{email});
		if(obj != null){
			flag = true;
		}
		return flag;
	}


	public User findUserById(int id) {
		// TODO Auto-generated method stub
		String hql = "from User where id = ?";
		return (User) hibernateTemplate.queryForObject(hql, new Object[]{id});
	}


	public List findUsers() {
		// TODO Auto-generated method stub
		return null;
	}


	public void updatePhoto(int id, String rename) {
		// TODO Auto-generated method stub
		
	}

	public void zhuanzhang(String email, float money) {
		// TODO Auto-generated method stub
		String hql = "update User set balance = balance + ? where email = ? ";
		hibernateTemplate.bulkUpdate(hql, new Object[]{money,email});
	}

	public User findUserByEmail(String email) {
		// TODO Auto-generated method stub
		String hql = "from User where email = ?";
		return (User) hibernateTemplate.queryForObject(hql, new Object[]{email});
	}

	public float findBalance(int id) {
		// TODO Auto-generated method stub
		String hql = "select balance from User where id = ?";
		return (Float) hibernateTemplate.queryForObject(hql, new Object[]{id});
	}

	public int findVips() {
		String sql = "select count(*) from user where ispay = 1 and isdel = 0";
		return ((BigInteger)hibernateTemplate.queryForObjectWithSQL(sql, null)).intValue();
	}

	public void updatePwdByEmail(String email,String password){
		String sql = "update user set password = '"+password+"' where email = '"+email+"'";
		hibernateTemplate.updateWithSQL(sql, null);
	}
	public boolean isCost(String userid,String chapterid){
		String hql = "from CostRecord where userid = "+userid+" and chapterid ="+chapterid;
		List list = hibernateTemplate.find(hql);
		if(list!=null&&list.size()>0){
			return true;
		}else{
			return false;
		}
		
	}
	public List<CostRecord> listCost(String userid){
		String hql = "";
		if("1".equals(userid)){
		hql = "from CostRecord order by id desc";
		}else{
			hql = "from CostRecord where userid = "+userid+" order by id desc";
		}
		List list = hibernateTemplate.find(hql);
		return list;
	}
}
