<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
 <title>搜索结果页面-悦读客</title>
     
      <%@ include file="header.jsp"%>
       
    <base href="<%=basePath%>">
    
 <div id="main_out">
	<div id="main">
    	<div id="bigbox">
    	  <div id="right2">           	
   	        <div align="center"><img src="css/read_left.gif" width="208" height="383"></div>
   	    </div><!-- end of right2 -->
            
            <div id="left2">   
            
                 <s:if test="page!=null&&page.result!=null&&!page.result.empty">
			<s:iterator  value="page.result"  var="book" status="j"> 	               
              <div  align="left"  style="width:650; padding:5 0 16 0 "> 
               <div style="text-decoration: none; width:650; height:25; font-size: 18px; color: #00F">
			<span style="color:#00F; font-size: 18px;">${j.index+1} .</span> <a href="book/one?id=${book.id }"><u><span style="color:#00F; font-size: 18px;">${book.name}</span></u></a></div>
               <div style="width:650">内容提示：${book.press }</div>
               <div style="width:650 
               ; padding:3 0 0 0"><span style="color:#00F">作者：</span>${book.author }<span style="color:#00F"> &nbsp;&nbsp;&nbsp;&nbsp;更新日期：</span>${book.offerTime }<span style="color:#00F"> &nbsp;&nbsp;&nbsp;&nbsp;借阅价格：</span>${book.price }元</div>
		         
					

			
   	          </div>
              </s:iterator >
                
		  </s:if>
		  <s:else>
			暂无数据
		</s:else>	
            <div class="turnpage_table" style=" margin:2 2 2 2">
					<s:include value="../fenye_search.jsp"></s:include>
				</div>      
            </div><!-- end of left -->
            
		</div><!-- bigbox-->
    </div><!-- main-->
</div><!-- main_out -->  
    

 
  <%@ include file="footer.jsp"%>
