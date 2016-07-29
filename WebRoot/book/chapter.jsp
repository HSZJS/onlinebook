<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="com.zg.po.*"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 <title>已上传图书—悦读客</title>
<%@ include file="header.jsp"%>


<div align="center">
    <div align="center" style="margin:8 0 8 0">
      <p><h2>《${bookName }》章节管理</h2></p>
   </div>

 	  <div align="center" style=" width:950px; height:28;  background-color:#CCC">
   <table width="950" height="28" border="0" align="center">
     
     
     <tr>
       <td width="33">&nbsp;</td>
       <td width="162">序号</td>
       <td width="156">章节名</td>
       <td width="199">价格(元)</td>
       <td width="65">操作</td>
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
  <s:iterator value="list" var="chapter" status="i">
  <tr style="border:solid 0">
    <td style="border:solid 0" width="30" height="20">&nbsp;</td>
    <td width="140"><span class="a">第${chapter.index}章</span></td>
    <td width="140"><span class="a">${chapter.title	}</span></td>
    <td width="180"><span>
    	${chapter.cost }
    </span></td>
    <td width="19"><a href="book/editChapter.jsp?id=${chapter.id }&bookid=${chapter.bookid}&bookName=${bookName }&index=${index	}">修改</a>&nbsp;<a href="book/downloadBook?id=${chapter.id }">下载</a></td>
    </tr>
    </s:iterator>
</table>
     
</s:if>    
    
<s:else>
  	 		暂无上传章节<br>
  	 		
  	 	</s:else><a href="book/uploadChapter.jsp?bookid=${id}&bookName=${bookName }&index=${index	}">点击此处，按顺序上传章节。</a>
</div>
<div class="turnpage_table" style="width:667; margin:5 0 2 0">
	</div>    
</div>



  	 	
 			 

  	 			
  	 		
  	 	
 <%@ include file="footer.jsp"%>
