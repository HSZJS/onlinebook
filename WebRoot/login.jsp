<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="/struts-tags" prefix="s"%>
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
		<h4>
			登录
		</h4>

		 <s:form  action="login.action" method="post">
			<div class="error">${exception.message }</div>
			用户名：
			
			<s:textfield  name="uname" value="%{uname}"></s:textfield>
			<span class="error"></span>
			<br />

			密&nbsp;&nbsp;码：
			 <s:password name="pwd"></s:password>
			<span class="error"></span>
			<br />
			<s:submit  value="登录"></s:submit>
		</s:form>
		<s:debug></s:debug>
	</body>
</html>
