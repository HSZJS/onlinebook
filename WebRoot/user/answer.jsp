<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="com.zg.po.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
User user = (User)request.getAttribute("user");
String question = user.getQuestion();
String answer = user.getAnswer();
System.out.println(answer);
%>

 <%@ include file="header.jsp"%>
 <title>用户注册</title>
	<link rel="stylesheet" type="text/css" href="styles.css">
	<script type="text/javascript" src="jslib/AjaxUtil.js"></script>
	<script type="text/javascript">
		function checkAnswer(){
			var answer = document.getElementById('answer');
			if(answer.value == '<%=answer%>'){
				window.location.href = "user/toUpdatePwd?email=<%=user.getEmail()%>";
			}else{
				alert('你输入的答案错误。');
			}
		
		}
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
		var trueMessage = '<img src="photo/right.jpg"><b style="color:green">通过验证</b>';
		var falseMessage = '<img src="photo/wrong.jpg"><b style="color:red">不存在该用户</b>';
		var message = '';
		if(returnMessage.indexOf('该邮箱已经被占用')>=0){
			message = trueMessage;
		}else{
			message = falseMessage;
		}
			document.getElementById("emailError").innerHTML = message;
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
<script language="javascript"> 
function loadimage(){ 
document.getElementById("randImage").src = "user/image.jsp?"+Math.random(); 
} 
</script> 
  </head>
  
<body>
  <div align="center">

  <table width="945" border="0" align="center">
  <tr>
    <td height="43">&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td height="47" colspan="2"><div align="center"><img src="css/findPwd.gif" width="100" height="37"></div></td>
    <td width="157">&nbsp;</td>
    <td width="27" rowspan="6"><div align="center"><img src="css/regist_shuxian.gif" width="4" height="300"></div></td>
    <td width="496" rowspan="6"><img src="css/regist_banner.gif" width="496" height="300"></td>
  </tr>
  <tr>
    <td width="37" height="48">你的问题是:</td>
    <td width="206"><input type="text" readOnly="true" style="width:200px; height:30px" value="<%= question%>"></td>
  </tr>
  <tr>
    <td width="37" height="48">你的答案是:</td>
    <td width="206"><input type="text" style="width:200px; height:30px" name="answer" id = "answer"></td>
  </tr>
  <tr>
    <td><input type="image" value="提交" src="css/uoload_button.gif"  onclick="checkAnswer()"></td></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
</table>
 
   	
</div>
 <%@ include file="../book/footer.jsp"%>
