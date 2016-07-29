package com.zg.web.action;



import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;

import com.opensymphony.xwork2.Action;
import com.zg.po.CostRecord;
import com.zg.po.User;
import com.zg.service.IUserService;
import com.zg.util.Page;
import com.zg.util.WebUtil;

public class UserAction extends BaseAction {
	private IUserService userService;
	private String email;
	private String password;
	private User user;
	
	private File file;
	private String fileFileName;
	private String fileContentType;
	private String nickname;
	private String sex;
	private String idCard;
	private String realName;
	private String phoneNumber;
	private String qq;
	private int userId;
	private String question;
	private String answer;
	
	private float money;
	
	private int pn = 1;
	private Page page;
	
	private List list ;
	
	
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	//登陆
	public String login(){
		user = userService.login(email, password);
		HttpSession session = this.getRequest().getSession();
		session.setAttribute("user", user);
		return Action.SUCCESS;
	}
	//注销
	public String logout(){
		HttpSession session=this.getRequest().getSession(false);
		if(session!=null)
			session.invalidate();
		return Action.SUCCESS;
	}
	//修改个人信息
	public String update() throws IOException{
		
		String question = this.getRequest().getParameter("question");
		
		
		
		String rename_pic = null;
		if(file != null){
			// 1.找到bookpics跟路径
			String rootPath = this.getServletContext().getRealPath("/headpics");
			
			File rootDir = new File(rootPath);
			if (!rootDir.exists()) {
				rootDir.mkdirs();
			}
			// 2.上传文件，重命名文件名
			fileFileName = fileFileName.replaceAll(".tmp", ".jpg");
			String rename = UUID.randomUUID().toString().replace("-", "")
					+ fileFileName.substring(fileFileName.lastIndexOf("."));
			rename_pic = "headpics\\"+rename;
			File uploadFile=new File(rootDir,rename);
			FileUtils.copyFile(file, uploadFile);
		}
		
		User uploadUser = new User();
		uploadUser.setId(userId);
		uploadUser.setIdCard(idCard);
		uploadUser.setNickname(nickname);
		uploadUser.setPhoneNumber(phoneNumber);
		uploadUser.setPic(rename_pic);
		uploadUser.setQq(qq);
		uploadUser.setRealName(realName);
		uploadUser.setSex(sex);
		uploadUser.setQuestion(question);
		uploadUser.setAnswer(answer);
		userService.updateUser(uploadUser);
		
		user = userService.findUserById(userId);
		HttpSession session = this.getRequest().getSession();
		session.setAttribute("user", user);
		WebUtil.alert(getRequest(), getResponse(), "update success", null, false);
		return null;
	}
	//充值
	public String recharge() throws IOException{
		userService.recharge(userId, money);
		HttpSession session = this.getRequest().getSession();
		session.setAttribute("user", userService.findUserById(userId));
		return Action.SUCCESS;
	}
	public String cost(){
		list = new ArrayList();
		User user = (User)this.getRequest().getSession().getAttribute("user");
		list = userService.listCost(user.getId()+"");
		return "success";
	}
	//管理员管理vip用户
	public String manageVip(){
		page = userService.findPayUser(1,pn);	
		return Action.SUCCESS;
	}
	//管理员删除  不老实的用户
	public String delete() throws IOException{
		userService.deleteUser(userId);
		WebUtil.alert(getRequest(), getResponse(), "delete success", null, false);
		return null;
	}
	//注册时判断用户名是否是存在
	public String checkEmail() throws IOException {
		getRequest().setCharacterEncoding("UTF-8");
		getResponse().setContentType("text/html;charset=UTF-8");
		boolean flag = userService.validateEmailIsExist(email);
		PrintWriter out = getResponse().getWriter();
		if(flag != true){
			out.println("<img src='photo/right.jpg'><b style='color:green'>可以注册</b>");
		}else{
			out.println("<img src='photo/wrong.jpg'><b style='color:red'>该邮箱已经被占用</b>");
		}
		return null;
	}
	//注册
	public String registe(){
		User newUser = new User();
		newUser.setEmail(email);
		newUser.setPassword(password);
		userService.saveUser(newUser);
		HttpSession session = this.getRequest().getSession();
		user = userService.findUserByEmail(email);
		session.setAttribute("user", user);
		return Action.SUCCESS;
	}
	//跳转向需要验证问题的页面
	public String toAnswerJsp(){
		String email = this.getRequest().getParameter("loginname");
		User user = userService.findUserByEmail(email);
		this.getRequest().setAttribute("user", user);
		return "toAnswerJsp";
	}
	//跳转向修改密码的页面
	public String toUpdatePwd(){
		String email = this.getRequest().getParameter("email");
		User user = userService.findUserByEmail(email);
		this.getRequest().setAttribute("user", user);
		return "toUpdatePwd";
	}
	public String updatePwd(){
		String email = this.getRequest().getParameter("email");
		String password = this.getRequest().getParameter("password");
		userService.updatePwdByEmail(email, password);
		return "updatePwd";
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public float getMoney() {
		return money;
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
	public void setMoney(float money) {
		this.money = money;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}

}
