<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 <title>已上传图书—悦读客</title>
<%@ include file="header.jsp"%>


<div align="center">
    <div align="center" style="margin:8 0 8 0">
      <p><img src="css/showupdatebook_title.png" width="160" height="30"></p>
   </div>

 	  <div align="center" style=" width:950px; height:28;  background-color:#CCC">
   <table width="950" height="28" border="0" align="center">
     
     
     <tr>
       <td width="33">&nbsp;</td>
       <td width="162">序号</td>
       <td width="156">书名</td>
       <td width="199">价格(元)</td>
       <td width="290">是否通过</td>
       <td width="65">操作</td>
       <td width="15">&nbsp;</td>
      </tr>
   </table>
</div>
 
   <div  style=" width:950px;background-color:#EFF8FE">
   
   <s:if test="page!=null&&page.result!=null&&!page.result.empty">
	  <s:iterator value="page.result" var="book" status="i">
<table width="950" style=" border:solid 1 #CCC; border-top:none" align="center">
  <tr style="border:solid 0">
    <td style="border:solid 0" width="42" height="20">&nbsp;</td>
    <td width="151"><span class="a">${i.index+1}</span></td>
    <td width="156"><span class="a">${book.name }</span></td>
    <td width="199"><span>${book.price}</span></td>
    <td width="276"><!--<span>${book.isCheck }</span>-->
      <s:set value="book.isCheck" var="isCheck"></s:set>
      <s:if test="isCheck == 1 "> <span style="color:#063"><strong>通过</strong></span> </s:if>
      <s:elseif test="isCheck == 0"> <span style="color:#063"><strong>正在审核中</strong></span></s:elseif>
      <s:else><span style="color:red"><strong>打回</strong></span></s:else>
      </td>
    	<td width="69">
    		<!-- <a href="book/toUpdateBook?bookid=${book.id}"><img src="css/showupdatebook_button.png"></a> -->
    		
    		 <s:if test="isCheck == 1 "><a href="book/manageChapterBook?bookid=${book.id}" >管理章节</a></s:if>
     		 <s:else> <span style="color:#063"><strong>抱歉，你的书尚未通过，无法上传章节。</strong></span></s:else>
      	</td>
    <td width="19">&nbsp;</td>
    </tr>
  
</table>
     </s:iterator>
</s:if>    
    
<s:else>
  	 		暂无上传图书<br>
  	 		<a href="book/uploadBook.jsp">上传图书</a>
  	 	</s:else>
   	 
</div>
<div class="turnpage_table" style="width:667; margin:5 0 2 0">
		<s:include value="../fenye_uploadBooks.jsp"></s:include>
	</div>    
</div>



  	 	
 			 

  	 			
  	 		
  	 	
 <%@ include file="footer.jsp"%>
