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
			<a href='user/list.action'>用户列表</a> > 添加用户
		</div>

		<div>
			<h4>
				添加用户
			</h4>
		</div>
	
		<s:form  name="saveUserForm" action="user/save.action" method="post">
			<table>
				<tbody>
					<tr>
						<td>
							用户名
						</td>
						<td>
							<s:textfield name="uname" value=""></s:textfield>${fieldErrors.uname[0] }
						</td>
					</tr>

					<tr>
						<td>

							密码
						</td>
						<td>
						
						
							<s:password name="pwd"></s:password>${fieldErrors.pwd[0] }
						</td>
					</tr>
					<tr>
						<td>
							确认密码
						</td>

						<td>
				
							<s:password name="pwd2"></s:password>${fieldErrors.pwd2[0] }
						</td>
					</tr>
					<tr>
						<td>
							电子邮箱
						</td>
						<td>	
							<s:textfield name="email"></s:textfield>${fieldErrors.email[0] }
						</td>
					</tr>
					<tr>
						<td>							
							<s:reset value="重置"></s:reset>

						</td>
						<td>

							<s:submit value="添加用户"></s:submit>

						</td>
					</tr>
				</tbody>
			</table>
	</s:form>
	</body>
</html>
