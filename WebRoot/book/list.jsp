<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib prefix="s" uri="/struts-tags" %>


	<%@ include file="header1.jsp"%>
    
   <style>
DIV.msdn {
	PADDING-RIGHT: 3px; PADDING-LEFT: 0px; FONT-SIZE: 13px; PADDING-BOTTOM: 2px; COLOR: #313031; PADDING-TOP: 2px; FONT-FAMILY: Verdana,Tahoma,Arial,Helvetica,Sans-Serif
}
DIV.msdn A {
	BORDER-RIGHT: #b7d8ee 1px solid; PADDING-RIGHT: 3px; BORDER-TOP: #b7d8ee 1px solid; PADDING-LEFT: 2px; PADDING-BOTTOM: 2px; MARGIN: 0px 3px; BORDER-LEFT: #b7d8ee 1px solid; COLOR: #0030ce; PADDING-TOP: 2px; BORDER-BOTTOM: #b7d8ee 1px solid; TEXT-DECORATION: none
}
DIV.msdn A:hover {
	BORDER-RIGHT: #b7d8ee 1px solid; BORDER-TOP: #b7d8ee 1px solid; BORDER-LEFT: #b7d8ee 1px solid; COLOR: #0066a7; BORDER-BOTTOM: #b7d8ee 1px solid; BACKGROUND-COLOR: #d2eaf6
}
DIV.pagination A:active {
	BORDER-RIGHT: #b7d8ee 1px solid; BORDER-TOP: #b7d8ee 1px solid; BORDER-LEFT: #b7d8ee 1px solid; COLOR: #0066a7; BORDER-BOTTOM: #b7d8ee 1px solid; BACKGROUND-COLOR: #d2eaf6
}
DIV.msdn SPAN.current {
	BORDER-RIGHT: #b7d8ee 1px solid; PADDING-RIGHT: 3px; BORDER-TOP: #b7d8ee 1px solid; PADDING-LEFT: 2px; FONT-WEIGHT: bold; PADDING-BOTTOM: 2px; MARGIN: 0px 3px; BORDER-LEFT: #b7d8ee 1px solid; COLOR: #444444; PADDING-TOP: 3px; BORDER-BOTTOM: #b7d8ee 1px solid; BACKGROUND-COLOR: #d2eaf6
}
DIV.msdn SPAN.disabled {
	DISPLAY: none
}
</style>
  </head>
  <body>
    
<div id="main_out">
	<div id="main">
    	<div id="bigbox">
    	  <div id="right2">           	
   	        <div align="center"><img src="css/read_left.gif" width="208" height="383"></div>
   	    </div><!-- end of right2 -->
            
          <div id="left2">         	               
               
               
               
               
               
          <div style="margin:15 0 0 0">
<s:if test="sorts!=null&&sorts.size()>0">  
   			<s:iterator value="sorts" var="sortTree1" >
<div style="width:685">
 
   		
<div style="width:70px; float:left; padding:2 0 2 0;" >       
<b>一级分类：</b></div> 
<div>
<table width="613" style=" margin:3 0 3 0; border: #FF0 solid 1">
  <tr>
    <td height="18"><div class="msdn" align="left" style="float:left">
    					<s:iterator value="#sortTree1.subTrees" var="sortTree2" status="i">
   							<a href="sort/subSort?subSort=${i.index}&code=${sortTree2.root.code}"><span>${sortTree2.root.name}</span></a>	
   						</s:iterator>
 <s:if test="subSort != null">
   							<s:set value="subSort" var="i"></s:set>
		  </s:if>
			<s:else>
   							<s:set value="0" var="i"></s:set>
		  </s:else>                       
           </div>             
        </td>
    
  </tr>
</table>
</div></div>


<div style="width:685">
 
   		
<div style="width:70px; float:left; padding:2 0 2 0">       
<b>二级分类：</b></div> 
<div>

 <table width="613" style=" margin:3 0 3 0; border: #FF0 solid 1">
  <tr>
    <td height="18">
    <div class="msdn" align="left" style="float:left">
    					
    					<s:iterator value="#sortTree1.subTrees[#i].subTrees" var="sortTree3">
   							<a href="sort/book?code=${sortTree3.root.code}&subSort=${i}"><span>${sortTree3.root.name}</span></a>	
   						</s:iterator>	
   						</div>		
	  </td>
  </tr>
</table>
</div>
</div>        
   		  </s:iterator>
   			<br/>
  </s:if>
  <s:else>
   			暂无数据
   		</s:else>
 						
</div>
  
  
 
 <s:if test="page!=null&&page.result!=null&&!page.result.empty">
	 <s:iterator  value="page.result"  var="book" status="j">  
     <div class="div0"> 
  <div class="div1">
  
    <div class="div2">${j.index+1}</div>
      <div class="div3"><a href="book/one?id=${book.id }"><img src="${book.pic }" style="width:110; height:140"/></a></div>
  
  <div class="div4">
  <div class="div6">
  <div class="div41"><a href="book/one?id=${book.id }">书名：${book.name}</a></div>
  <div class="div42">作者：${book.author }</div>
  <div class="div45">借阅价格：${book.price }</div></div>
  <div class="div43">点击率：${book.traffic }</div>
  <div class="div44">上传时间：${book.offerTime }</div>
  <div class="div46">内容提要：${book.press }</div>
  </div>
  <div class="div5"><a href="book/one?id=${book.id }">阅读</a></div>
  
  </div>
  </div>
   </s:iterator >
	    </s:if>
				  <s:else>
				  	暂无数据
				  </s:else>	
    <div class="turnpage_table" style=" margin:2 2 2 2">
		<s:include value="../fenye.jsp"></s:include>
	</div>       
     </div>   
           
          </div><!-- end of left -->
            
		</div><!-- bigbox-->
    </div><!-- main-->
</div><!-- main_out -->  		
   	

   	
    
 <%@ include file="footer.jsp"%>