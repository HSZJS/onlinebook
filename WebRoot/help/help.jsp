<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
     <title>欢迎来到悦读客！</title>
     
      <%@ include file="../book/header.jsp"%>
      <div align="center">
    <div  style="background-color: #E9EEE8;padding: 0;margin: o;width: 950;">
    <div style="width: 750"><br>
  <center>
 <p style="font-size: 30px"><b>悦读客系统帮助文档</b></p>
 </center>
 <br>
  <img alt="主页" src="help/zhuye.png">
   <center>
 <p style="font-size: 12px">图 1：网站主页</p>
 </center><br>
 <p align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;当用户登录网站地址，就会直接跳转到网站的主页上来，如上图。
 在主页的左上角是注册和登录提示，主页上有分类导航、热门推荐、新书推荐导航栏等等</p>
  <br>
  <img alt="登录" src="help/denglu.png">
   <center>
 <p style="font-size: 12px">图 2：登录界面</p>
 </center>
 <br>
 <p align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;点击登录，会在主页见面上出现一个登录的指示框。
 在界面上输入邮箱，密码，验证码点击登录登录成功。登入失败会在顶部提示用户登录失败</p>
  <br>
  <img alt="注册" src="help/zhuce.png">
   <center>
 <p style="font-size: 12px">图 3：注册界面</p>
 </center>
  <br>
 <p align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;点击注册，会跳转到注册界面，注册信息时需要输入邮箱、密码、验证码
 然后点击注册，实现注册功能。</p>
  <br>
  <img alt="修改信息" src="help/xiugaixinxi.png">
   <center>
 <p style="font-size: 12px">图4：修改信息界面</p>
 </center>
  <br>
 <p align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;用户成功登录主页以后，可以修改自己的信息。点击左上角的修改信息，可以跳转到信息展示界面。
 在界面上用户可以看到自己的已注册信息，用户可以在这个界面上直接去修改自己的信息。在界面上修改完以后点击提交，就可以成功额修改自己的信息。</p>
       </div>
    </div>
</div>
  
  <%@ include file="../book/footer.jsp"%>