<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<title>审查上传图书—悦读客</title>
<%@ include file="header.jsp"%>


<div align="center">
    <div align="center" style="margin:8 0 8 0">
      <p><img src="css/showupdatebook_title.png" width="160" height="30"></p>
   </div>

 	  <div align="center" style=" width:950px; height:28;  background-color:#CCC">
   <table width="950" height="28" border="0" align="center">
     
     
     <tr>
       <td width="27">&nbsp;</td>
       <td width="117">序号</td>
       <td width="191">书名</td>
       <td width="124">作者</td>
       <td width="127">价格(元)</td>
       <td width="234">上传时间</td>
       <td width="77">状态</td>
       <td width="77">操作</td>
       <td width="19">&nbsp;</td>
      </tr>
   </table>
</div>
 
   <div  style=" width:950px;background-color:#EFF8FE">
   
  <s:if test="page!=null&&page.result!=null&&!page.result.empty">
    	<s:iterator value="page.result" var="book" status="i">
<table width="950" style=" border:solid 1 #CCC; border-top:none" align="center">
  <tr style="border:solid 0">
    <td style="border:solid 0" width="27" height="20">&nbsp;</td>
    <td width="117"><span class="a">${i.index+1}</span></td>
    <td width="192"><span class="a"><a href="book/read?bookid=${book.id }">${book.name }</a></span></td>
    <td width="124"><span class="a">${book.author }</span></td>
    <td width="125"><span>${book.price}</span></td>
    <td width="235"><span>${book.offerTime }</span></td>
     <td width="81"><span>未审查</span></td>
    <td width="81"><a href="book/checkBook?bookid=${book.id}"  onclick="return confirm('确定审查通过')"><span style="color: #008000">通过<span></a>   <a href="book/checkBookBack?bookid=${book.id}"  onclick="return confirm('确定审查打回')"><span style="color: #008000">打回<span></a></td>
    <td width="13">&nbsp;</td>
    </tr>
  
</table>
   </s:iterator>
   
    </s:if>
    <s:else>
    	暂时没有用户上传新书
    </s:else>
  
   	 
</div>
 <div class="turnpage_table" style="margin:5 0 2 0; width:667" >
		<s:include value="../fenye_checkUploadBook.jsp"></s:include>
	</div> 
</div>





   
    		
    		
    		
    		
    	


 <%@ include file="footer.jsp"%>
