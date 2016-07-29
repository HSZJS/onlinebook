<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
		function check(){
			var money = document.getElementById("money");
			alert(money.val());
			return false;
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
            
            
            <form action="book/search" method="post"  onsubmit="return check();">

<div style="width:580; height:45" >
  <div  style="float:left; width:300; height:45; padding:0 -5 0 0">
    <input name="search";type="text" class="searchtext" id="search" onFocus="aa()" onBlur="bb()" value="请输入书名或者作者名" size="40" maxlength="20"  height="40"></div>
   
    <div style="float:left;width:129; height:45">
   <input  type="image" name="搜索" src="css/search_button.png" align="left"></div>
   
   <div align="left" style="float:right; width:80">
   <p><a href="book/free" target="_new" style="color:red"><strong>上传图书</strong></a><br></p>
   <p><a href="book/free" target="_new" style="color:red"><strong>免费图书</strong></a></p>
  </div>
   
  
  
  
</div>
		<div id="wrap" class="clearfix">
   			<inputonClick="document.formName.submit()"><br/>
   			<input type="radio" name="requirement" value="bookName" checked="checked">
   			书名
   			<input type="radio" name="requirement" value="bookAuthor">
   			作者 &nbsp;&nbsp;&nbsp; <b  style="text-align:right"><!-- 热门搜索：龙魂变 纨绔太子 灭道夺天 九阳炼神 医世无双 --></b></div>
            
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
                <li><a href="#">阅读帮助</a></li>
                <li><a href="#">关于我们</a></li>
            </ul>
        </div>
</div> 

<form action="user/recharge" method="post" onsubmit="return check();">
<div align="center">
<table width="950" border="0" bgcolor="#EFF8FE">
  <tr>
    <td width="69">&nbsp;</td>
    <td width="86">&nbsp;</td>
    <td width="324">&nbsp;</td>
    <td width="324">&nbsp;</td>
    <td width="69">&nbsp;</td>
    <td width="62">&nbsp;</td>
  </tr>
  <tr>
    <td height="41">&nbsp;</td>
    <td>充值账号:</td>
    <td> <input type="text" readonly="readonly"  style="width:200px; height:30px" value="${sessionScope.user.email}"></td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td height="42">&nbsp;</td>
    <td>充值金额:</td>
    <td><input type="text" name="money" id="money" style="width:180px; height:30px">
      元</td>
    <td><a href="javascript:window.location.href='user/cost.action';">查看消费记录</a></td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td colspan="6"><Iframe src="testbank/index.html" width="954px" height="450px" scrolling="no" frameborder="0" ></iframe></td>
    </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td><input type="radio">
    我已确认上述输入数据正确无误</td>
    <td><input type="hidden" name="userId" value="${sessionScope.user.id}">      <input type="image" value="充值" src="css/bank_button.gif"></td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
</table>

</div>
   		
  
 	
 	
  </form>
    
    
    
 <%@ include file="../book/footer.jsp"%>