<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.zg.util.HibernateTemplate"%>
<%@page import="com.zg.dao.sh.BookShDao"%>
<%@page import="org.hibernate.Query"%>
<%@page import="com.zg.po.Book"%>
<%@page import="org.hibernate.Session"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>会员充值—悦读客</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<script type="text/javascript" src="jslib/jquery.js"></script>  
    <script type="text/javascript" src="jslib/jquerywin.js"></script>  
    
    <script type='text/javascript' src='dwr/util.js'></script>
  	<script type='text/javascript' src='dwr/engine.js'></script>
	<script type='text/javascript' src='dwr/interface/userAction.js'></script>
	

	<link rel="stylesheet" type="text/css" href="css/style.css">
    <link type="text/css" rel="stylesheet" href="css/win.css"/> 
    
    <script type="text/javascript">
		function aa(){
			var search = document.getElementById("search");
			if(search.value == "请输入书名或者作者名"){
				search.value = "";
			}
			
		}
		function bb(){
			var search = document.getElementById("search");
			if(search.value == ""){
				search.value = "请输入书名或者作者名";
			}	
		}
	</script>
    
    
        
  </head>
 
  <body> 
  	    
  	<div id="top_out">
    
    <div align="left" style="width:950; height:23; background-image:url(css/body_bg.png); padding:7 0 0 0">  <!--顶部登陆开始-->
  <div align="left" style="width:500; float:left">

 欢迎 
  	 	<s:if test="sessionScope.user.nickname == null">
  	 		<b style="color:red">未命名</b>
  	 	</s:if>
  	 	<s:else>
  	 		<b style="color:red">${sessionScope.user.nickname }</b>
  	 	</s:else>
		|<a href="book/borrowBook?userid=${sessionScope.user.id}">我的图书</a>|
  	 	<a href="">上传图书</a>|
  	 	<a href="book/findUploadBook?userid=${sessionScope.user.id}">查看上传图书</a>|
  		<a href="user/logout" onClick="">注销</a>
   
    </div>
    <div align="center" style="width:450;text-align:right; float:left"><Iframe src="testbanner/gonggao.html" width="450px" height="20px" scrolling="no" frameborder="0"></iframe></div>
    </div> <!--顶部导航结束-->

   
	<div id="top">
    

     
    <div id="mdzone" style="background-color:#E9EEE8 ">
        <div class="logo"><a href=""><img src="photo/logo.png" /></a></div>
        <div class="kh">
            
            
            <form action="book/search" method="post" >

<div style="width:580; height:45" >
  <div  style="float:left; width:300; height:45; padding:0 -5 0 0">
    <input name="search";type="text" class="searchtext" id="search" onFocus="aa()" onBlur="bb()" value="请输入书名或者作者名" size="40" maxlength="20"  height="40"></div>
   
    <div style="float:left;width:129; height:45">
   <input  type="image" name="搜索" src="css/search_button.png" align="left"></div>
   
   <div align="left" style="float:right; width:80">
   <p><a href="book/free" target="_new" style="color:red"><strong>上传图书</strong></a><br></p>
   <p><a href="book/free" target="_new" style="color:red"><strong>免费图书</strong></a></p>
  </div>
   
  <%
	HibernateTemplate s = new BookShDao().getSessionFactory();
	String hql = "from Book where isCheck = 1 and isdel = 0 order by search desc";
	Session sess = s.getSessionFactory().openSession();
		Query   query   =   sess.createQuery(hql); 
		query.setFirstResult(0); 
		query.setMaxResults(5); 
		List<Book> bookSear= (List<Book>)query.list();
		Book b1 = (Book)bookSear.get(0);
		Book b2 = (Book)bookSear.get(1);
		Book b3 = (Book)bookSear.get(2);
		Book b4 = (Book)bookSear.get(3);
		Book b5 = (Book)bookSear.get(4);
	%>
  
  
</div>
		<div id="wrap" class="clearfix">
   			<inputonClick="document.formName.submit()"><br/>
   			<input type="radio" name="requirement" value="bookName" checked="checked">
   			书名
   			<input type="radio" name="requirement" value="bookAuthor">
   			作者 &nbsp;&nbsp;&nbsp; <b  style="text-align:right">热门搜索：<a href="book/one?id=<%=b1.getId() %>"><%=b1.getName() %></a> <a href="book/one?id=<%=b2.getId() %>"><%=b2.getName() %></a> <a href="book/one?id=<%=b3.getId() %>"><%=b3.getName() %></a></b></div>
            
  	</form>
        
   		
   		</div>
            	<div class="lag">
            	
            
            	   
            
            	</div>	
                <div id="topzone">
                    <!-- 前台会员登录 -->
               
  	
  	</div>
    
    
  	  </div><!-- end of topzone -->
            </div>
		</div><!-- mdzone -->
                 
    </div>
</div><!-- top_out -->
  	
    
    <div id="navout">
    	<div id="nav">
        	<ul><li><a href="sort/sort">首页</a></li>
                <li><a href="book/list">全本书库</a></li>
                <li><a href="book/free">免费专区</a></li>
                <li><a href="book/uploadBook.jsp">上传图书</a></li>
                <li><a href="user/recharge.jsp">我要充值</a></li>
                <li><a href="record/record">我的收藏</a></li>
                <li><a href="message/lookMessage">意见反馈</a></li>
                <li><a href="help/help.jsp">阅读帮助</a></li>
                <li><a href="ourself/ourself.jsp">关于我们</a></li>
            </ul>
        </div>
</div> 

