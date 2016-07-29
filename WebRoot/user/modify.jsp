<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>

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
		<sx:head />
	</head>

	<body>
		<s:include value="/top.jsp"></s:include>
        <div>
			首页 >
			<a href='user/list.action'>用户列表</a> > 修改用户
		</div>

		<div>
			<h4>
				修改用户
			</h4>
		</div>


		<s:form name="updateUserForm" action="user/update.action" method="post">
			<table>
				<tbody>

					<tr>
						<td>
							用户名
						</td>
						<td>
							<s:textfield  name="uname" value="%{user.uname}" disabled="true"></s:textfield>
						</td>
					</tr>
					<tr>

						<td>
							电子邮箱
						</td>
						<td>
				
							<s:textfield name="email" value="%{user.email}" disabled="true"></s:textfield>
						</td>
					</tr>
					<tr>
						<td>

							性别
						</td>
						<td>
	<!--
							<input type="radio" name="gender" checked="checked" value="M"/>男
							<input type="radio" name="gender" value="F"/>女  -->
							<s:radio list="#{'M':'男','F':'女'}"  listKey="key"  listValue="value"  name="gender" value="%{user.gender}"></s:radio>

						</td>
					</tr>
					<tr>

						<td>
							爱好
						</td>
						<td>	
						<!--  				
							<input type="checkbox" name="favs" value="1"/>
							购物
							<input type="checkbox" name="favs" value="2"/>
							看电影
							<input type="checkbox" name="favs" value="3"/>
							打游戏-->	
							<s:checkboxlist list="#{1:'购物',2:'看电影',3:'打游戏'}"  listKey="key"  listValue="value"  name="favs"   value="%{user.favs}"></s:checkboxlist>
						</td>

					</tr>
					<tr>
						<td>
							地区
						</td>
						<td>	
						<!-- 
							<select name="loc">
								<option value="1">北京</option>
								<option value="2" selected="selected">上海</option>
								<option value="3">天津</option>
							</select> -->
							<s:select list="#{1:'北京',2:'上海',3:'天津'}"  listKey="key"  listValue="value"  name="loc"  value="%{user.loc}"></s:select>
						</td>
					</tr>
					<tr>
						<td>
							生日
						</td>

						<td>
						    <sx:datetimepicker name="birthday" value="%{user.birthday}"></sx:datetimepicker>
						</td>

					</tr>
					<tr>
						<td>
							自我介绍
						</td>
						<td>	
							<s:textarea  name="introduce"  cols="50"  rows="5"  value="%{user.introduce}"></s:textarea>
						</td>
					</tr>
					<tr>
						<td>
			
							 <s:hidden  name="id"  value="%{user.id}"></s:hidden>
							<s:reset value="重置" ></s:reset>
						</td>
						<td>
							<s:submit value="修改用户"></s:submit>
						</td>
					</tr>
				</tbody>
			</table>
		</s:form>
	</body>
</html>
