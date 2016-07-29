<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
			<a href='user/list.action'>用户列表</a> > 用户信息查看
		</div>
		<div>
			<h4>
				用户信息查看
			</h4>
		</div>

		<div style="width: 150px; float: left;">
		
			<img width="120px" height="120px"
				src='photo/<s:property value="user.photo"  default="default.gif" />'>
		</div>
		<div style="width: 600px; float: left;">
			<table>
				<tbody>
					<tr>
						<td>
							序号
						</td>
						<td>
							${user.id}
						</td>
					</tr>
					<tr>

						<td>
							用户名
						</td>
						<td>
							${user.uname }
						</td>
					</tr>
					<tr>
						<td>
							密码
						</td>

						<td>
							${user.pwd }
						</td>
					</tr>
					<tr>
						<td>
							电子邮箱
						</td>
						<td>
							${user.email }
						</td>

					</tr>
					<tr>
						<td>
							性别
						</td>
						<td>
							<s:property value="#{'M':'男','F':'女'}[user.gender]"/>
						</td>
					</tr>

					<tr>
						<td>
							爱好
						</td>
						<td>
		
						    
						    <s:if test="user.favs!=null&&user.favs.length>0">
						    <s:iterator  value="user.favs"  var="fav">
						      <s:property value="#{1:'购物',2:'看电影',3:'打游戏'}[#fav]"/>
						    </s:iterator>
						    </s:if>	
						</td>
					</tr>
					<tr>
						<td>
							地区
						</td>
						<td>
							<s:property value="#{1:'北京',2:'上海',3:'天津'}[user.loc]"/>
						</td>

					</tr>
					<tr>
						<td>
							生日
						</td>

						<td>
							<s:date name="user.birthday"  format="yyyy-MM-dd"/>
						</td>
					</tr>
					<tr>
						<td>
							自我介绍
						</td>
						<td>
							${user.introduce }
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</body>
</html>
