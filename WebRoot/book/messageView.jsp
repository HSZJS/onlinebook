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
    
    <title>图书上传—悦读客</title>
    
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
    
<div align="left" style="width:950; height:23; background-image:url(css/body_bg.png); padding:7 0 0 0">  <!--顶部登陆开始-->  <div align="left" style="width:500; float:left">

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

    
  <script type="text/javascript">
		
		function checkName(){
			var obj = document.getElementById("bookName").value;
 			var reg = /^[\u4e00-\u9fa5]+$/i; 
			if(obj == "" || !reg.test(obj)){
				document.getElementById("nameSpan").innerHTML = "<b style='color:red;font-weight:lighter;font-size:14px'>格式不正确 </b>";
			}
			if(obj != "" && reg.test(obj)){
				document.getElementById("nameSpan").innerHTML = "<b style='color:green;font-weight:lighter;font-size:14px'> √ </b>";
			}
		}
		function checkAuthor(){
			var obj = document.getElementById("author").value;
 			var reg = /^[\u4e00-\u9fa5]+$/i; 
			if(obj == "" || !reg.test(obj)){
				document.getElementById("authorSpan").innerHTML = "<b style='color:red;font-weight:lighter;font-size:14px'>格式不正确 </b>";
			}
			if(obj != "" && reg.test(obj)){
				document.getElementById("authorSpan").innerHTML = "<b style='color:green;font-weight:lighter;font-size:14px'> √ </b>";
			}
		}
		function checkPrice(){
			var obj = document.getElementById("price").value;
			if(obj == "" || isNaN(obj)){
				document.getElementById("priceSpan").innerHTML = "<b style='color:red;font-weight:lighter;font-size:14px'>格式不正确 </b>";
			}
			if(obj != "" && !isNaN(obj)){
				document.getElementById("priceSpan").innerHTML = "<b style='color:green;font-weight:lighter;font-size:14px'>√</b>";
			}
		}
		function checkBook(){
			var obj = document.getElementById("bookFile").value;
			if(obj != ""){
				var lastname = obj.substr(obj.lastIndexOf("."));
				
				if(lastname != ".txt"){
					document.getElementById("bookSpan").innerHTML = "<b style='color:red;font-weight:lighter;font-size:14px'>格式不正确 </b>";
				}
			}
		}
		function checkForm(){
			var flag = true;
			var picFile = document.getElementById("picFile").value;
			var bookFile = document.getElementById("bookFile").value;
			var one = document.getElementById("one").value;
			var two = document.getElementById("sortid").value;
			if(picFile != ""){
				var lastname = picFile.substr(picFile.lastIndexOf("."));
				if(lastname != ".jpg" && lastname != ".gif" && lastname  != "png"){
					flag = false;
					document.getElementById("picSpan").innerHTML = "<b style='color:red;font-weight:lighter;font-size:14px'>格式不正确 </b>";
				}
			}
			if(bookFile == ""){
				flag = false;
				document.getElementById("bookSpan").innerHTML = "<b style='color:red;font-weight:lighter;font-size:14px'>请添加书 </b>";
				
			}else{
				var lastname = bookFile.substr(bookFile.lastIndexOf("."));
				if(lastname != ".txt"){
					flag = false;
					document.getElementById("bookSpan").innerHTML = "<b style='color:red;font-weight:lighter;font-size:14px'>格式不正确 </b>";
				}
			}
			if(one == "000" || two == "000"){				
				document.getElementById("selectSpan").innerHTML = "<b style='color:red;font-weight:lighter;font-size:14px'>请选择分类  </b>";
				flag = false;
			}else{
				document.getElementById("selectSpan").innerHTML = "<b style='color:green;font-weight:lighter;font-size:14px'>√ </b>";
			
			}
			if(flag){
				alert('提交成功，作者会很快看到你的意见。');
			}
			return flag;
		}
		function createSecondLevel(obj){
			var opt;
			var opt1;
			var opt2;
			var opt3;
			var opt4;
			if(obj == "101000"){
				opt = new Option("东方玄幻","101010");
				opt1 = new Option("远古神话","101011");
			}
			if(obj == "101100"){
				opt = new Option("传统武侠","101110");
				opt1 = new Option("浪子武侠","101111");
				opt2 = new Option("国术武侠","101112");

			}
			if(obj == "101200"){
				opt = new Option("都市生活","101210");
				opt1 = new Option("商战风云","101211");
				opt2 = new Option("官场沉浮","101212");
				opt3 = new Option("爱情婚姻","101213");
				opt4 = new Option("乡土小说","101214");
			}
			if(obj == "101300"){
				opt = new Option("军事战争","101310");
				opt1 = new Option("抗战烽火","101311");
				opt2 = new Option("战争幻想","101312");
				opt3 = new Option("军旅生活","101313");
			}
			if(obj == "101400"){
				opt = new Option("青春校园","101410");
				opt1 = new Option("校园异能","101411");
			}
			var city = document.getElementById("sortid");
			city.options.length = 1;
			city.options.add(opt);
			city.options.add(opt1);
			city.options.add(opt2);
			city.options.add(opt3);
			city.options.add(opt4);
		}
	</script>

  </head>
  
  <body>
     <div align="center">
     <form id="form" action="message/saveMessage" method="post" onSubmit="return checkForm()" style="background-color:#EFF8FE; width:950px">
     
     <input type="hidden" id ="bookid" name="bookid" value="${bookid }"/>
     <input type="hidden" name="userid" value="${sessionScope.user.id}">
     
     <div align="center">
     <table width="950" border="0">
  <tr>
    <td width="240" height="77">&nbsp;</td>
    <td width="77">&nbsp;</td>
    <td width="291">&nbsp;<font size="6">反馈意见</font></td>
    <td width="145">&nbsp;</td>
    <td width="18">&nbsp;</td>
    <td width="153">&nbsp;</td>
  </tr>
 <tr><td>&nbsp;</td></tr>
  <tr>
    <td height="38">&nbsp;</td>
    <td>意见域：</td>
    <td style="height:72px;"><textarea style="height:72px;" name="notic" id="bookName"  onBlur="checkName()" style="height:30px; width:200px"></textarea></td>
    <td> <span id="nameSpan" >*必填信息(中文)</span></td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
 <tr><td>&nbsp;</td></tr>
 <tr><td>&nbsp;</td></tr>
  <tr>
    <td height="45">&nbsp;</td>
    <td>&nbsp;</td>
    <td>
      <input type="image" value="提交" src="css/uoload_button.gif"></td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
</table>
</div>

<span id="offerTimeSpan" style="color:red"></span><br><br>
    </form>
    </div>
<%@ include file="footer.jsp"%>