
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
 

<%@ page contentType="text/html;charset=utf-8"%>
     <title>欢迎来到悦读客！</title>
      <%@ include file="header.jsp"%>
       
 
  <div align="center" style="margin:3 0 0 0">
   <Iframe src="testbanner/lefttree.jsp" width="950" height="300px" scrolling="no" frameborder="0" ></iframe>
    </div>
    
    <div align="center" style="margin:2 0 0 0" >
    <img src="photo/baoyueBannerNew.jpg" alt="" width="950" />
    </div>
   
   
    
<div>
   	
   	 <div align="center"  style=" margin-top:5; margin-bottom:5">
     <div align="center" style="width:950;">
  <div style="float:left; width:314; border-left:#ffffff solid 2; border-right:#ffffff solid 1; border-top:#ffffff solid 2; border-bottom:#ffffff solid 2">
    <div align="center" style=" width:315; height:25; border:#999 solid 1; padding:4 0 0 0; background-color: #CCC">
      <h3 style="color:green"><strong>点击量排行榜</strong></h3>
</div>
   		
   		<s:if test="booksByTraffic!=null&&booksByTraffic.size()>0" >
   			<s:iterator value="booksByTraffic" var="book">
    <div align="center" style="width:315; height:20; border-bottom:#CCC solid 1; border-left:#CCC solid 1; border-right:#CCC solid 1; padding:2 0 0 0">
    <div style="float:left; width:115; height:20; padding:2 0 0 0">
      <div align="right">[${book.sort.name}|${book.sortName}]</div>
    </div>
    <div style="float:left; width:190; height:20; padding:2 0 0 10">
      <div align="left"><a href="book/one?id=${book.id }">${book.name }</a></div>
    </div>
    
    </div>        
   				
		  </s:iterator>
   		</s:if>
   		<s:else>
   		null
   		</s:else>
   	</div>
    
    
   	<div style="float:left; width:314; border-left:#ffffff solid 1; border-right:#ffffff solid 1; border-top:#ffffff solid 2; border-bottom:#ffffff solid 2">
   		 <div align="center" style=" width:315; height:25; border:#999 solid 1; padding:4 0 0 0; background-color: #CCC">
      <h3 style="color:green"><strong>订阅量排行榜</strong></h3>
</div>
   		<s:if test="booksByDownload!=null&&booksByDownload.size()>0" >
   			<s:iterator value="booksByDownload" var="book">
   				  <div align="center" style="width:315; height:20; border-bottom:#CCC solid 1; border-left:#CCC solid 1; border-right:#CCC solid 1; padding:2 0 0 0">
    <div style="float:left; width:115; height:20; padding:2 0 0 0">
      <div align="right">[${book.sort.name}|${book.sortName}]</div>
    </div>
    <div style="float:left; width:190; height:20; padding:2 0 0 10">
      <div align="left"><a href="book/one?id=${book.id }">${book.name }</a></div>
    </div>
    
    </div>        
   			</s:iterator>
   		</s:if>
   		<s:else>
   		null
   		</s:else>
   	</div>
   	
  <div style="float:left; width:314; border-left:#ffffff solid 1; border-right:#ffffff solid 2; border-top:#ffffff solid 2; border-bottom:#ffffff solid 2">
   		 <div align="center" style=" width:315; height:25; border:#999 solid 1; padding:4 0 0 0; background-color: #CCC">
      <h3 style="color:green"><strong>搜索量排行榜</strong></h3>
</div>
   		<s:if test="booksBySearch!=null&&booksBySearch.size()>0" >
   			<s:iterator value="booksBySearch" var="book">
   				 <div align="center" style="width:315; height:20; border-bottom:#CCC solid 1; border-left:#CCC solid 1; border-right:#CCC solid 1; padding:2 0 0 0">
    <div style="float:left; width:115; height:20; padding:2 0 0 0">
      <div align="right">[${book.sort.name}|${book.sortName}]</div>
    </div>
    <div style="float:left; width:190; height:20; padding:2 0 0 10">
      <div align="left"><a href="book/one?id=${book.id }">${book.name }</a></div>
    </div>
    
    </div>        
		  </s:iterator>
   		</s:if>
   		<s:else>
   		null
   		</s:else>
   	</div>    
    
  
  <%@ include file="footer.jsp"%>