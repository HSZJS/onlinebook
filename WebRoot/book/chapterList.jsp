<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.zg.po.Chapter"%>
<%@page import="com.zg.po.User"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>图书详情—悦读客</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<%
		User user = (User)session.getAttribute("user");
		boolean flag = false;
		float banlance = 0;
		
		if(user!=null){
			flag = true;
			banlance = user.getBalance();
		}
	 %>
	<script type="text/javascript" src="jslib/AjaxUtil.js"></script>
	<script type="text/javascript">
		function checkUser(){
			var userid = document.getElementById("userid").value;
			var bookid = document.getElementById("bookid").value;
			var money = document.getElementById("money").value;
			var userEmail = document.getElementById("userEmail").value;
			var isread = document.getElementById("isread").value;
			var params = "userid="+userid+"&bookid="+bookid+"&money="+money+"&userEmail="+userEmail+"&isread="+isread;
			sendAjaxRequest('post', 'book/borrow', true, params, wrietError);
		}
		
		function wrietError(obj){
			document.getElementById("errorMessage").innerHTML = returnMessage;
		}
		function readChapter(id,cost){
			if(cost == 0){
				window.location.href="book/readChapterById?chapterid="+id;
			}else{
				if(<%=flag%> == false){
					alert('请登录，此章节是付费章节。');
				}else if(<%=banlance%><cost){
					alert('你的余额不足，请充值。');
				}else{
					window.location.href="book/readChapterById?chapterid="+id;
				}
			}
		}
	</script>
<jsp:include page="user.jsp"></jsp:include>
<%
	List<Chapter> chapters = (List<Chapter>)request.getAttribute("chapters");
 %>
<div id="main_out">
	<div id="main">
		<br/>
		<h2 align="center" style="color:green">${bookInfo.name }  (${bookInfo.author })</h2>
		<br/><br/>
    	<table width="100%">
    		 <%
    			if(chapters!=null&&chapters.size()>0){
    			for(int i = 0;i < chapters.size();i++){
    				Chapter chapter = (Chapter)chapters.get(i);
    				String viewName = "第"+chapter.getIndex()+"章  "+chapter.getTitle();
    				if(i%4==0){
    					%>
    					<tr><td align="center" width="20%"><font color="green"><label onclick="readChapter(<%=chapter.getId() %>,<%=chapter.getCost() %>)"><%=viewName %>(<%=chapter.getCost() %>￥)</label></font></td>
    					<%
    				}else
    				if(i%4==3){
    					%>
    					<td align="center" width="20%"><font color="green"><label onclick="readChapter(<%=chapter.getId() %>,'<%=chapter.getCost() %>')"><%=viewName %>(<%=chapter.getCost() %>￥)</label></font></td></tr>
    					<%
    				}else
    				if(i == chapters.size()-1){
    					%>
    					<td align="center" width="20%"><font color="green"><label onclick="readChapter(<%=chapter.getId() %>,'<%=chapter.getCost() %>')"><%=viewName %>(<%=chapter.getCost() %>￥)</label></font></td></tr>
    					<%
    				}else{
    					%>
    					<td align="center" width="20%"><font color="green"><label onclick="readChapter(<%=chapter.getId() %>,<%=chapter.getCost() %>)"><%=viewName %>(<%=chapter.getCost() %>￥)</label></font></td>
    					<%
    				}
    			}
    		 %>
    		 <%}else{ %>
    		 <tr align="center"><td align="center">&nbsp;&nbsp;&nbsp;  作者未上传章节。<td/></tr>
    		 <%} %>
    		
    	</table>
    </div><!-- main-->
</div><!-- main_out -->  		

<br/>

 	 
 	
  
  
   <%@ include file="footer.jsp"%>