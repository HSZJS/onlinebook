<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.zg.dao.sh.BookShDao"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="org.springframework.orm.hibernate3.HibernateTemplate"%>
<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.Query"%>
<%@page import="com.zg.po.Book"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    
    
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
    
    <script language="javascript"> 
	function loadimage(){ 
	document.getElementById("randImage").src = "user/image.jsp?"+Math.random(); 
	} 
	
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
	%>
</script> 
        
  </head>
 
  <body> 
  	    
  	<div id="top_out">
    
    
   <div align="left" style="width:950; height:23; background-image:url(css/body_bg.png); padding:7 0 0 0">  <!--顶部登陆开始-->
  <div align="left" style="width:500; float:left">

  <s:if test="sessionScope.user != null">
  		<s:if test="sessionScope.user.email != 'admin' ">
  	 		欢迎 
  	 		<s:if test="sessionScope.user.nickname == null">
  	 			 <b style="color:red"><a href="user/update.jsp">未命名</a></b>
  	 		</s:if>
  	 		<s:else>
  	 			 <b style="color:red"><a href="user/update.jsp">${sessionScope.user.nickname }</a></b>
  	 		</s:else>
  	 		|<a href="book/borrowBook?userid=${sessionScope.user.id}">我的图书</a>|<a href="book/uploadBook.jsp">上传图书</a>|<a href="user/recharge.jsp">充值</a>|
  			<a href="user/update.jsp">修改信息</a>|<a href="book/findUploadBook?userid=${sessionScope.user.id}">查看上传图书</a>|<a href="user/logout" onClick="">注销</a>
  		</s:if>
  		<s:else>
  			欢迎 ${sessionScope.user.nickname }|<a href="user/manageVip">付费用户管理</a>|<a href="record/record">我的收藏</a>|
  			<a href="user/update.jsp">修改信息</a>|<a href="book/checkUploadBook">审查上传图书</a>|
  			<a href="user/logout" onClick="">注销</a>
  		</s:else>
  	</s:if>
  	<s:else>
  		欢迎来到欢迎来到悦读客，请<a href="javascript:void()" onClick="login()" style="color:green"><strong>登陆</strong></a> 
  		或<a href="user/registe.jsp" style="color:green"><strong>注册</strong></a>  <h1 style="color:red">${exceptionMessage}</h1>
  		                                                                                                                                                            
  	</s:else>
   
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
   <p><a href="book/free" target="_new" style="color:green"><strong>上传图书</strong></a><br></p>
   <p><a href="book/free" target="_new" style="color:green"><strong>免费图书</strong></a></p>
  </div>
   
  
  
  
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
  	
  	
    <div id="win" >  
    <form action="user/login" method="post">
    
        <div id="title"><img src="css/login_title.png"><span style=" margin-right:2px" id="close" onClick="hide()">X</span></div>  
        <div id="content">
       <div align="center"> 
 
    <table width="450" border="0">
     <tr>
    <td height="31" colspan="3"></td>
  </tr>
  <tr>
    <td width="62" height="40">邮箱：</td>
    <td width="210"><input type="text" name="email" id="email" style="width:200px; height:30px; padding:5px"></td>
    <td width="164"><span>*请输入注册邮箱</span></td>
  </tr>
  <tr>
    <td height="43">密码:</td>
    <td><span id="error"></span>
      <input type="password" name="password" id="password" style="width:200px; height:30px">      <br></td>
    <td><span>*请输入6-14位密码</span></td>
  </tr>
  <tr>
    <td height="42">验证码:</td>
    <td><input type="text" name="email2" id="email2" style="width:200px; height:30px; padding:5px"></td>
    <td><img alt="code..." name="randImage" id="randImage" src="user/image.jsp" width="80" height="25" border="1" align="absmiddle"><span><a href="javascript:loadimage();">换一张</a></span></td>
  </tr>
  <tr>
    <td height="35">&nbsp;</td>
    <td><input type="image" value="登陆" src="css/login_button.gif"></td>
    <td><a href="user/registe.jsp">注册</a>|<a href="user/toFindPwd.jsp">忘记密码</a>|<a href="">反馈</a></td>
  </tr>
  <tr>
    <td height="8" colspan="3"></td>
  </tr>
  </table>     
		</div> 
	</form>
    </div> 
    </div>
    
    <div id="navout">
    	<div id="nav">
        	<ul><li><a href="sort/sort">首页</a></li>
                <li><a href="book/list">全本书库</a></li>
                <li><a href="book/free">免费专区</a></li>
                <li><a href="book/uploadBook.jsp">上传图书</a></li>
                <li><a href="user/recharge.jsp">我要充值</a></li>
                <li><a href="/onlinebook/record/record">我的收藏</a></li>
                <li><a href="/onlinebook/message/lookMessage">意见反馈</a></li>
                 <li><a href="help/help.jsp">阅读帮助</a></li>
                <li><a href="ourself/ourself.jsp">关于我们</a></li>
            </ul>
        </div>
    </div> 