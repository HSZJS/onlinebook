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
    
    
    
		<div>
			您好，${sessionScope.userLoginInfo.uname }(${sessionScope.userLoginInfo.email })
			<a href="logout.action">注销</a>
		</div>
        
        
         

	</body>
</html>
