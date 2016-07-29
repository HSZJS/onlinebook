<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

 <%@ include file="header.jsp"%>
 <title>用户登录</title>
	<link rel="stylesheet" type="text/css" href="styles.css">
	<script type="text/javascript" src="jslib/AjaxUtil.js"></script>
	<script type="text/javascript">
		
		function checkEmail(obj){
			var flag = false;
			var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
			if(obj == "" || !myreg.test(obj)){
				document.getElementById("emailError").innerHTML = 
				"<b style='color:red;font-weight:lighter;font-size:14px'>电子邮箱格式不正确</b>";
			}
			if(obj != "" && myreg.test(obj)){
				flag = true;
			}
			if(flag){
				var params = "email=" + obj;
				sendAjaxRequest('post', 'user/checkEmail', true, params, wrietEmail);
			}
		}
		
		function wrietEmail(obj){
			document.getElementById("emailError").innerHTML = returnMessage;
		}
		function checkPwd(){
			var password = document.getElementById("password").value;
			var password2 = document.getElementById("password2").value;
			if(password == ""){
				document.getElementById("pwd1Error").innerHTML 
				= "<b style='color:red;font-weight:lighter;font-size:14px'>密码不能为空 </b>";
			}else{
				if(password.length < 6 || password.length > 20){
					document.getElementById("pwd1Error").innerHTML 
					= "<b style='color:red;font-weight:lighter;font-size:14px'>密码长度应为6~20个字符 </b>";
				}else{
					document.getElementById("pwd1Error").innerHTML 
					= "";
				}
				if(password2 == "" || password2 != password){
					document.getElementById("pwd2Error").innerHTML 
					= "<b style='color:red;font-weight:lighter;font-size:14px'>确认密码不一致</b> ";
				}else{
					document.getElementById("pwd2Error").innerHTML 
					= "";
				}
			}
			
		}
		
	</script>

  </head>
  
<body>
  <div align="center">
    <form action="user/login" method="post">
       
       
       
      <table width="945" border="0" align="center">
  <tr>
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
  </tr>
  <tr>
    <td height="67" colspan="2"><div align="center"><img src="css/login_title.gif" ></div></td>
    <td width="157">&nbsp;</td>
    <td width="27" rowspan="5"><div align="center"><img src="css/regist_shuxian.gif" width="4" height="300"></div></td>
    <td width="496" rowspan="5"><img src="css/regist_banner.gif" width="496" height="300"></td>
  </tr>
  <tr>
    <td width="37" height="62">邮箱:</td>
    <td width="206"><input type="text" name="email" id="email" style="width:200px; height:30px; padding:5px"><span id="error"></span></td>
    <td><span></>请输入注册邮箱</span></td>
    </tr>
  <tr>
    <td height="43">密码:</td>
    <td><input type="password" name="password" id="password" style="width:200px; height:30px"></td>
    <td><span id="pwd1Error">*请输入6-14位密码</span></td>
    </tr>
  <tr>
     <td height="21"></td>
    <td>&nbsp;</td>
    <td><span id="pwd2Error"></span></td>
    </tr>
  <tr>
    <td height="74">&nbsp;</td>
    <td><input type="image" value="登陆" src="css/login_button.gif"></td>
    <td>还没有账号？请<a href="user/registe.jsp">注册</a><br><a href="">忘记密码？</a>|<a href="">反馈</a></td>
    </tr>
  <tr>
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
  </tr>
</table>
 
	</form>
	
	
</div>
 <%@ include file="../book/footer.jsp"%>
