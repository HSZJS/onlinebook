<i><%@page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags"%>
<title>免费图书—悦读客</title>
    <jsp:include page="user.jsp"></jsp:include>
    
    
    <div align="center">
    <div align="center" style="margin:8 0 8 0">
      <p><img src="css/freebook_title.png" width="160" height="30"></p>
   </div>

 	  <div align="center" style=" width:950px; height:28;  background-color:#CCC">
   <table width="950" height="28" border="0" align="center">
     
     
     <tr>
       <td width="27">&nbsp;</td>
       <td width="117">序号</td>
       <td width="191">书名</td>
       <td width="124">作者</td>
       <td width="127">点击量</td>
       <td width="234">上传时间</td>
       <td width="77">操作</td>
       <td width="19">&nbsp;</td>
      </tr>
   </table>
</div>
 
   <div style=" width:950px;background-color:#EFF8FE">
   
  <s:if test="page!=null&amp;&amp;page.result!=null&amp;&amp;!page.result.empty">
				    <s:iterator value="page.result" var="book" status="i">
<table width="950" style=" border:solid 1 #CCC; border-top:none" align="center">
  <tr style="border:solid 0">
    <td style="border:solid 0" width="27" height="20">&nbsp;</td>
    <td width="117"><span>${i.index+1}</span></td>
    <td width="192"><span>${book.name }</span></td>
    <td width="124"><span>${book.author }</span></td>
    <td width="125"><span>${book.traffic }</span></td>
    <td width="235"><span>${book.offerTime }</span></td>
    <td width="81"><a href="book/one?id=${book.id }"><img src="css/borrowbook_button.png"></a></td>
    <td width="13">&nbsp;</td>
    </tr>
  
</table>
   </s:iterator>
				  </s:if>
				  <s:else>
				  	<tr><td colspan="5">暂无数据</td></tr>
				  </s:else>	
				  

   	 
</div>
          <div class="turnpage_table" style="width:667; margin:5 0 2 0">
					<s:include value="../fenye_freebooks.jsp"></s:include>
				</div>
</div>

    
    
    
    
    
    
    
    
    
 <%@include file="footer.jsp"%></i>