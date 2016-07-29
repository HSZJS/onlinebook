<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>我的收藏—悦读客</title>
    
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
  	 		<b style="color:red"><a href="user/update.jsp">未命名</a></b>
  	 	</s:if>
  	 	<s:else>
  	 		<b style="color:red"><a href="user/update.jsp">${sessionScope.user.nickname }</a></b>
  	 	</s:else>
		|<a href="user/manageVip">付费用户管理</a>|
  		<a href="user/update.jsp">修改信息</a>|<a href="book/checkUploadBook">审查上传图书</a>|
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


 <div align="center">
    <div align="center" style="margin:8 0 8 0">
      <p><img src="css/record_title.png" width="160" height="30"></p>
   </div>

 	  <div align="center" style=" width:950px; height:28;  background-color:#CCC">
   <table width="950" height="28" border="0" align="center">
     
     
     <tr>
       <td width="41">&nbsp;</td>
       <td width="96">序号</td>
       <td width="199">用户名</td>
       <td width="193">书名</td>
       <td width="261">收藏时间</td>
       <td width="129">操作</td>
       <td width="10">&nbsp;</td>
      </tr>
   </table>
</div>
 
   <div  style=" width:950px;background-color:#EFF8FE">
   
  <s:if test="page!=null&&page.result!=null&&!page.result.empty">
  			<s:iterator value="page.result" var="record" status="i"> 
<table width="950" style=" border:solid 1 #CCC; border-top:none" align="center">
  <tr style="border:solid 0">
    <td style="border:solid 0" width="38" height="20">&nbsp;</td>
    <td width="99"><span class="a">${i.index+1}</span></td>
    <td width="197"><span class="a">${record.email }</span></td>
    <td width="193"><span>${record.bookName }</span></td>
    <td width="263"><span>${record.starttime }</span></td>
    <td width="127"><span><a href="book/readBook?name=${record.bookName }">阅读</a></span></td>
    <td width="10">&nbsp;</td>
    </tr>
  
</table>
   </s:iterator>
  		</s:if>
  		<s:else>
  			暂时没有借阅记录
  		</s:else>
  		
</div>
<div class="turnpage_table" style="width:667; margin:5 0 2 0">
					<s:include value="../fenye_record.jsp"></s:include>
				</div>   
</div>  		
        
        
  		
  		
  				
  				
  			
 <%@ include file="../book/footer.jsp"%> 