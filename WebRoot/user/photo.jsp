<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>用户管理</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<link rel="stylesheet" type="text/css" href="css/common.css">
	</head>
	<body>
		<s:include value="/top.jsp"></s:include>
		<div>
			首页 >
			<a href='user/list.action'>用户列表</a> > 上传照片
		</div>
		<div>
			<h4>
				上传照片
			</h4>
		</div>
		<div>
	
				
			<s:form  name="uploadPhoto"  action="user/uploadPhoto.action"
				method="post" enctype="multipart/form-data">	
				<s:file name="photo"></s:file>		${fieldErrors.photoFileName[0] }
				<s:hidden  name="id"  value="%{#parameters.id[0]}"></s:hidden>
				<s:submit  value="上传照片"></s:submit>
			</s:form>
		</div>
	</body>
</html>
