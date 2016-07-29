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
    
    <title>修改个人信息—悦读客</title>
    
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
	
		function checkForm(){
			var flag = true;
			var idcard = document.getElementById("idcard").value;
			var realname = document.getElementById("realname").value;
			var phonenumber = document.getElementById("phonenumber").value;
			var qq = document.getElementById("qq").value;
			var file = document.getElementById("file").value;
			var question = document.getElementById("question").value;
			var answer = document.getElementById("answer").value;
			if(idcard == ""){
				flag = false;
				document.getElementById("span1").innerHTML = "<b style='color:red;font-weight:lighter;font-size:14px'>身份证是必填的</b>";
			}
			if(realname == ""){
				flag = false;
				document.getElementById("span2").innerHTML = "<b style='color:red;font-weight:lighter;font-size:14px'>真实姓名是必填的</b>";
			}
			if(phonenumber == ""){
				flag = false;
				document.getElementById("span3").innerHTML = "<b style='color:red;font-weight:lighter;font-size:14px'>联系方式是必填的</b>";
			}
			if(qq == ""){
				flag = false;
				document.getElementById("span4").innerHTML = "<b style='color:red;font-weight:lighter;font-size:14px'>QQ是必填的</b>";
			}
			if(question == ""){
				flag = false;
				document.getElementById("span5").innerHTML = "<b style='color:red;font-weight:lighter;font-size:14px'>问题是必填的</b>";
			}
			if(answer == ""){
				flag = false;
				document.getElementById("span6").innerHTML = "<b style='color:red;font-weight:lighter;font-size:14px'>答案是必填的</b>";
			}
			if(file != ""){
				var lastname = file.substr(file.lastIndexOf("."));
				if(lastname != ".jpg" && lastname != ".gif" && lastname  != "png"){
					flag = false;
					alert("必须是图片才能上传");
				}
			}
			return flag;
		}
		function viewmypic(headpic,file) {  
            headpic.src = file;
		}
		function checkIdcard(){
			var idcard = document.getElementById("idcard").value;
			if(idcard != ""){
				if(idcard.length != 18){
					document.getElementById("span1").innerHTML = "<b style='color:red;font-weight:lighter;font-size:14px'>身份证数位不为18</b>";
				}else{
					document.getElementById("span1").innerHTML = "<b style='color:#00FF66;font-weight:lighter;font-size:14px'>√ </b>";
				}
			}
		}
		function checkRealname(){
			var realname = document.getElementById("realname").value;
 			var reg = /^[\u4e00-\u9fa5]+$/i; 
 			if (!reg.test(realname)) {
  				document.getElementById("span2").innerHTML = "<b style='color:red;font-weight:lighter;font-size:14px'>请输入中文名字</b>";
 			}else{
 				document.getElementById("span2").innerHTML = "<b style='color:#00FF66;font-weight:lighter;font-size:14px'>√ </b>";
 			}	
		}
		function checkPhonenumber(){
			var phonenumber = document.getElementById("phonenumber").value;
			if(phonenumber != ""){
				if(phonenumber.length != 11){
					document.getElementById("span3").innerHTML = "<b style='color:red;font-weight:lighter;font-size:14px'>手机号不正确</b>";
				}else{
					document.getElementById("span3").innerHTML = "<b style='color:#00FF66;font-weight:lighter;font-size:14px'>√ </b>";
				}
			}
		}
		function checkQq(){
			var qq = document.getElementById("qq").value;
			if(qq != ""){
				if(qq.length < 5){
					document.getElementById("span4").innerHTML = "<b style='color:red;font-weight:lighter;font-size:14px'>qq号不正确 </b>";
				}else{
					document.getElementById("span4").innerHTML = "<b style='color:#00FF66;font-weight:lighter;font-size:14px'>√ </b>";
				}
			}
		}
		function checkQuestion(){
			var question = document.getElementById("question").value;
				if(question == ""){
					document.getElementById("span5").innerHTML = "<b style='color:red;font-weight:lighter;font-size:14px'>问题不能为空 </b>";
				}else{
					document.getElementById("span5").innerHTML = "<b style='color:#00FF66;font-weight:lighter;font-size:14px'>√ </b>";
				}
		}
		function checkAnswer(){
			var answer = document.getElementById("answer").value;
				if(answer == ""){
					document.getElementById("span6").innerHTML = "<b style='color:red;font-weight:lighter;font-size:14px'>答案不能为空 </b>";
				}else{
					document.getElementById("span6").innerHTML = "<b style='color:#00FF66;font-weight:lighter;font-size:14px'>√ </b>";
				}
		}
		function clickButton()  {    
	    //alert($('#name').val());
        	var url = "user/uploadPhoto";
        	var file = $("#file");
        	alert(file);
        	//var params = {
              // file:$("#file").val()
        	//};
        	jQuery.post(url, file, callbackFun, 'json');
    	}
    	function callbackFun(data){
       		$("#headpic").attr("src","bookpics/"+data.result);
       		//alert(data.result);
    	}	  
	</script>

</head>
 
  <body> 
  	    
  	<div id="top_out">
    
  <div align="left" style="width:950; height:23; background-image:url(css/body_bg.png); padding:7 0 0 0">  <!--顶部登陆开始-->
  <div align="left" style="width:500; float:left">


  	 	欢迎 
  	 	<s:if test="sessionScope.user.nickname == null">
  	 		<b style="color:red"><a href="user/update.jsp">未命名</a></b>
  	 	</s:if>
  	 	<s:else>
  	 		<b style="color:red"><a href="user/update.jsp">${sessionScope.user.nickname }</a></b>
  	 	</s:else>
		|<a href="book/borrowBook?userid=${sessionScope.user.id}">我的图书</a>|
  	 	<a href="">上传图书</a>|<a href="user/recharge.jsp">充值</a>|
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
                <li><a href="book/list">书库</a></li>
                <li><a href="{$siteurl}">全本小说</a></li>
                <li><a href="{$siteurl}">连载小说</a></li>
                <li><a href="{$siteurl}">VIP专区</a></li>
                <li><a href="{$siteurl}">免费专区</a></li>
                <li><a href="../onlinebook/user/recharge.jsp">充值</a></li>
                <li><a href="{$siteurl}">作家专区</a></li>
                <li><a href="{$siteurl}">留言区</a></li>
                <li><a href="{$siteurl}">关于我们</a></li>
            </ul>
        </div>
</div> 



  
   
  <div align="center" style="margin:8 0 8 0">
	<h2>个人信息管理</h2>  
  </div>
  <div align="center" >
 
  <form style=" background-color:#EFF8FE;width:950px" id="form" action="user/update" method="post"  enctype="multipart/form-data" onSubmit="return checkForm()" >
 
   <table align="center" style="width:950px" border="0">
  <tr>
    <td width="292">&nbsp;</td>
    <td width="86">&nbsp;</td>
    <td width="235">&nbsp;</td>
    <td width="287">&nbsp;</td>
    <td width="11">&nbsp;</td>
    <td width="13">&nbsp;</td>
  </tr>
  <tr>
    <td height="42">&nbsp;</td>
    <td>昵称:</td>
    <td><input type="text" style="height:30px; width:200px" name="nickname" id="nickname" value="${sessionScope.user.nickname}"></td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td height="32">&nbsp;</td>
    <td>性别:</td>
    <td><input type="radio" name="sex" value="男" checked="checked">
      男
      <input type="radio" name="sex" value="女">
      女</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>头像:</td>
    <td><img src="${sessionScope.user.pic}" name="headpic" id="headpic" height="150" width="150">
      <input type="file" name="file" id="file"></td>
    <td>&nbsp;</td>
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
  <tr>
    <td height="50">&nbsp;</td>
    <td>身份证:</td>
    <td><input type="text" style="height:30px; width:200px" name="idCard" id="idcard" value="${sessionScope.user.idCard}" onBlur="checkIdcard()"></td>
    <td><span id="span1" >*必填信息</span></td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td height="45">&nbsp;</td>
    <td>真实姓名:</td>
    <td><input type="text" style="height:30px; width:200px" name="realName" id="realname" value="${sessionScope.user.realName}" onBlur="checkRealname()"></td>
    <td><span id="span2">*必填信息</span></td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td height="48">&nbsp;</td>
    <td>联系方式:</td>
    <td><input type="text" style="height:30px; width:200px" name="phoneNumber" id="phonenumber" value="${sessionScope.user.phoneNumber}" onMouseUp="checkPhonenumber()"></td>
    <td><span id="span3" >*必填信息</span></td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td height="43">&nbsp;</td>
    <td>QQ：</td>
    <td><input type="text" style="height:30px; width:200px" name="qq" id="qq" value="${sessionScope.user.qq}" onBlur="checkQq()"></td>
    <td><span id="span4">*必填信息</span></td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td height="48">&nbsp;</td>
    <td>你的问题:</td>
    <td><input type="text" style="height:30px; width:200px" name="question" id="question" value="${sessionScope.user.question}" onMouseUp="checkQuestion()"></td>
    <td><span id="span5" >*必填信息</span></td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td height="48">&nbsp;</td>
    <td>你的答案:</td>
    <td><input type="text" style="height:30px; width:200px" name="answer" id="answer" value="${sessionScope.user.answer}" onMouseUp="checkAnswer()"></td>
    <td><span id="span6" >*必填信息</span></td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td height="66">&nbsp;</td>
    <td>&nbsp;</td>
    <td><input type="hidden" name="userId" value="${sessionScope.user.id}">
      <input type="image" value="保存设置" src="css/uoload_button.gif"></td>
    <td>&nbsp;</td>
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
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
</table>

   </form>
  </div>
  
<%@ include file="../book/footer.jsp"%>
