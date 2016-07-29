<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.zg.po.Chapter"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
<title></title>
<link rel="stylesheet" type="text/css" href="../css/read.css">
<style type="text/css" media="screen">
 body {-moz-user-select: none;-webkit-user-select: none;}
 #span_text
 {
   text-align:left;
 }
</style>
<script type="text/javascript">
document.onselectstart = function(e) {
    return false;
}
document.oncontextmenu = function(e) {
    return false;
}
</script>
<script type="text/javascript" src="../js/jquery1.3.2.js"></script>
<script type="text/javascript">
$(document).ready(function() {
     $("#fontsize").change(
        function()
        {
            $("span").css({fontSize:this.value});//dom
        }
      )
      // change the font color
      $("#backgroundcolor").change(
        function()
        {
            $("span").css({background:this.value});
        }
        
      )
	   // change the font color
      $("#fontfamily").change(
        function()
        {
            $("span").css({fontFamily:this.value});
        }
        
      )
      // change the background color
      $("#fontcolor").change(
        function()
        {
            $("span").css({color:this.value});
        }
      )
});

   
</script>
</head>
<body id="body_css">
<%  
		String indexBefore = (String)request.getAttribute("indexBefore");  
		String indexAfter = (String)request.getAttribute("indexAfter");  
		Chapter chapter = (Chapter)request.getAttribute("chapter");  
 %>
<div id="top_out">
	<div id="top">
    	<div id="mdzone" style="background-color:#E9EEE8 ">
        	<div class="logo"></div>
            <div class="kh1">
            <a href="../sort/sort">首页</a>|
            <a href="list.jsp">排行榜</a>|
            <a href="">书库</a>|
            <a href="">我借阅的图书</a>
            </div>
            <div class="kh">
                   <div id="formstylecontrols">
        <label for="fontsize">字体大小</label>
        <select id="fontsize">
                <option value="12px">小号</option>
                <option value="14px">较小</option>
                <option value="16px" >中号</option>
                <option value="18px">较大</option>
                <option value="24px">大号</option>
        </select>

        <label for="backgroundbackground">背景颜色</label>
        <select id="backgroundcolor">
                <option value="#F4FBFF">默认</option>
                <option value="gray">淡灰</option>
                <option value="red">红色</option>
                <option value="green">绿色</option>
        <option value="yellow">明黄</option>
        </select>
        
        <label for="fontfamily">字体</label>
        <select id="fontfamily">
                <option value="宋体">默认</option>
                <option value="黑体">黑体</option>
                <option value="微软雅黑">微软雅黑</option>
                <option value="楷体">楷体</option>
                <option value="新宋体">新宋体</option>
        </select>

        <label for="fontcolor">字体颜色</label>
        <select id="fontcolor">
                <option value="#000000">黑色</option>
                <option value="#ff0000">红色</option>
                <option value="#006600">绿色</option>
                <option value="#0000ff">蓝色</option>
                <option value="#660000">棕色</option>
        </select>
        
     
        <label>
        
    <input type="submit" id="style" value="保存设置" />
    </label>
</div>
            </div>
            
            
		</div><!-- mdzone -->
                 
    </div>
</div><!-- top_out -->



<div id="main_out2">
   	    	<br/>
            <h2 align="center">第<%=chapter.getIndex() %>章 <%=chapter.getTitle() %></h2>
            <br/>
            <div style="algin:center;text-align:center"> <a href="readChapterById?chapterid=<%=indexBefore %>"><font color="green">上一章</font></a>&nbsp;&nbsp;<a href="readChapterBook?bookid=${bookid }"><font color="green">返回目录</font></a>&nbsp;&nbsp;<a href="readChapterById?chapterid=<%=indexAfter %>"><font color="green">下一章</font></a></div>
            <div id="left3" style="width:920px;margin-left:210px;" >	               
                <span>
                 <s:if test="list!=null">
    	<s:iterator value="list" var="l">
    		<span id="span_text">${l}</span><br/>
    	</s:iterator>
    </s:if>
    <s:else>
    	null
    </s:else>
      </span>
                
   <div style="text-align:center"> <a href="readChapterById?chapterid=<%=indexBefore %>"><font color="green">上一章</font></a>&nbsp;&nbsp;<a href="readChapterBook?bookid=${bookid }"><font color="green">返回目录</font></a>&nbsp;&nbsp;<a href="readChapterById?chapterid=<%=indexAfter %>"><font color="green">下一章</font></a></div>
</div><!-- main_out2 -->
<br>

<img src="../css/read_footer.gif" >
</body>
</html>
