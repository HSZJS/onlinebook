<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
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

		<div  style='width: 200px;height: 50px;line-height:50px; border: 1px solid #eee;text-align: center;margin: 100px;'>   
			保存成功!
		</div>

	
	</body>
</html>
