<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="com.zg.po.*"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

User user = (User)session.getAttribute("user");
int id = user.getId();
%>
 <title>已上传图书—悦读客</title>
<%@ include file="header.jsp"%>


<div align="center">
    <div align="center" style="margin:8 0 8 0">
      <p><h2>反馈意见查看</h2></p>
   </div>

 	  <div align="center" style=" width:950px; height:28;  background-color:#CCC">
   <table width="950" height="28" border="0" align="center">
     
     
     <tr>
       <td width="33">&nbsp;</td>
       <td width="162">发起者</td>
       <td width="156">书籍</td>
       <td width="199">内容</td>
       <td width="65">时间</td>
       <td width="15">&nbsp;</td>
      </tr>
   </table>
</div>
   <div  style=" width:950px;background-color:#EFF8FE">
   <s:if test="list!=null">
	
<table width="950" style=" border:solid 1 #CCC; border-top:none" align="center">
 <tr>
       <td width="33">&nbsp;</td>
       <td width="162"></td>
       <td width="156"></td>
       <td width="199"></td>
       <td width="65"></td>
       <td width="15"></td>
      </tr>
  <s:iterator value="list" var="message" status="i">
  <tr style="border:solid 0">
    <td style="border:solid 0" width="30" height="20">&nbsp;</td>
    <td width="140"><span class="a">${message.userView}</span></td>
    <td width="140"><span class="a">${message.bookView	}</span></td>
    <td width="180"><span>
    	${message.content }
    </span></td>
    <td width="19">${message.createtime }</td>
    </tr>
    </s:iterator>
</table>
     
</s:if>    
    
<s:else>
  	 		暂时无人反馈意见<br>
  	 	</s:else>
</div>
<div class="turnpage_table" style="width:667; margin:5 0 2 0">
	</div>    
</div>

 <%if (id != 1) {%>
 <div align="center">
     <form id="form" action="message/saveMessage" method="post" onSubmit="return checkForm()" style="background-color:#EFF8FE; width:950px">
     
     <input type="hidden" id ="bookid" name="bookid" value="${bookid }"/>
     <input type="hidden" name="userid" value="${sessionScope.user.id}">
     
     <div align="center">
     <table width="950" border="0">
  <tr>
    <td width="240" height="77">&nbsp;</td>
    <td width="77">&nbsp;</td>
    <td width="145">&nbsp;</td>
    <td width="18">&nbsp;</td>
    <td width="153">&nbsp;</td>
  </tr>
 <tr><td>&nbsp;</td></tr>
  <tr>
    <td height="38">&nbsp;</td>
    <td>对系统意见：</td>
    <td style="height:72px;"><textarea style="height:72px;" name="notic" id="bookName"  onBlur="checkName()" style="height:30px; width:200px"></textarea></td>
    <td> <span id="nameSpan" ></span></td>
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
 <%} %>

  	 	
 			 

  	 			
  	 		
  	 	
 <%@ include file="footer.jsp"%>
