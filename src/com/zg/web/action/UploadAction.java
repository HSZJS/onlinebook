package com.zg.web.action;

import java.io.File;
import java.util.UUID;

import org.apache.commons.io.FileUtils;

import com.zg.vo.UserLoginInfo;


public class UploadAction extends BaseAction{

	private File file;
	private String fileFileName;
	private String fileContentType;
	private String nickname;
	private String sex;
	private String idCard;
	private String realName;
	private String phoneNumber;
	private String qq;
	

	public String upload() throws Exception {
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
		File uploadFile=new File(rootDir,rename);
		FileUtils.copyFile(file, uploadFile);
		
		return null;
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
	
	
}
