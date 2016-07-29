<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
	</script>
<jsp:include page="user.jsp"></jsp:include>

<div id="main_out">
	<div id="main">
    	<div id="bigbox">
    	  <div id="right2">           	
   	        <div align="center"><img src="css/read_left.gif" width="208" height="383"></div>
   	    </div><!-- end of right2 -->
            
          <div id="left2"> 
           <hr>
    <s:if test="bookInfo!=null">
    	当前位置：首页><a href="">${bookInfo.sort.name }</a>><a href="">${bookInfo.sortName}</a>
    	<hr/>        	               
           <div align="center" style="width:665">
            <div align="center" style="width:665; height:40; padding:4 0 0 0; font-family: '微软雅黑'; font-weight: bold; font-size: 24px;">${bookInfo.name }</div>
             <div align="center" style="width:665; height:40; padding:4 0 0 0">作者：${bookInfo.author }</div>
           <div style=" width:175; height:300; float:left">
           <img src="${bookInfo.pic}" width="150" height="200"/></div>
           <div style=" width:490; height:300; float:left">
           <div style=" width:490; height:40; float:left">
           订阅量：${bookInfo.downloads }
    	   搜索量：${bookInfo.search}
    	   点击量：${bookInfo.traffic }
    	   价格：${bookInfo.price}元
    	   大小:${bookInfo.size}
           </div>
    	   <div style=" width:490; float:left; text-align:left">
           内容提示：:${bookInfo.press }<br>
           </div>
           <div style=" width:490; padding:4 0 0 0; float:left; text-align:left">
           
    	   出版日期:${bookInfo.offerTime }
           </div>
    	&nbsp;<br/>
    	<a href="book/read?bookid=${bookInfo.id}">小说简介</a>
    	&nbsp;
    	<a href="book/readChapterBook?bookid=${bookInfo.id }">阅读章节</a>
    	&nbsp;
    	<a href="message/toMessage?bookid=${bookInfo.id }">反馈意见</a>
    	&nbsp;
    	
    	<a href="javascript:void(0)" onClick="checkUser()">收藏这本小说</a>
    	<br/>
    	<input type="hidden" id="userid" value="${user.id}"/>
    	<input type="hidden" id="bookid" value="${bookInfo.id}"/>
    	<input type="hidden" id="money" value="${bookInfo.price}"/>
    	<input type="hidden" id="userEmail" value="${user.email}"/>
    	<input type="hidden" id="isread" value="${bookInfo.isread}"/>
    	<span id="errorMessage"></span>
        <br>
    	<img src="css/book_fenxiang.gif"/>
           </div>
          
           </div>    
               
        </s:if>
    <s:else>
    	null
    </s:else>
                
          </div><!-- end of left -->
            
		</div><!-- bigbox-->
    </div><!-- main-->
</div><!-- main_out -->  		



 	 
 	
  
  
   <%@ include file="footer.jsp"%>