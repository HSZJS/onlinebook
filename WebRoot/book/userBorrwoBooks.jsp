<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>

     <title>已借阅图书—悦读客</title>

      <%@ include file="header.jsp"%>

 <div align="center">
    <div align="center" style="margin:8 0 8 0">
      <p><h2>已收藏的图书</h2></p>
   </div>

 	  <div align="center" style=" width:950px; height:28;  background-color:#CCC">
   <table width="950" height="28" border="0" align="center">
     
     
     <tr>
       <td width="33">&nbsp;</td>
       <td width="162">序号</td>
       <td width="156">书名</td>
       <td width="199">作者</td>
       <!-- <td width="290">到期剩余时间</td> -->
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
    <td width="199"><span class="a">${book.author}</span></td>
   <!--  <td width="276"><span  class="a" id="endtime" style="color:green; ">${book.reTime}</span></td> -->
    <td width="69"><input type="hidden" id="bookid" value="${book.bookid }"/>
      <input type="hidden" id="userid" value="${sessionScope.user.id}"/>
      <a href="book/read?bookid=${book.bookid}"><img src="css/borrowbook_button.png"></a></td>
    <td width="19">&nbsp;</td>
    </tr>
  
</table>
         
          
</s:iterator>
 
    </s:if>
    <s:else>
   	 无借阅书籍<br>
    	
    </s:else>
</div>
<div class="turnpage_table"  style="width:667; margin:6 0 6 0">
		<s:include value="../fenye_borrowbooks.jsp"></s:include>
	</div> 
 <a href="book/list"><img src="css/bank_go.jpg" width="195" height="45"></a>
</div>
<script type="text/javascript">
		var CID = "endtime";
		if(window.CID != null){
    		var iTime = document.getElementById(CID).innerText;
    		var Account;
    		RemainTime();
		}
		function RemainTime(){
			var bookid = document.getElementById("bookid").value;
			var userid = document.getElementById("userid").value;
			var flag = true;
    		var iDay,iHour,iMinute,iSecond;
   		 	var sDay="",sHour="",sMinute="",sSecond="",sTime="";
    		if (iTime >= 0){
        		iDay = parseInt(iTime/24/3600);
        		if (iDay > 0){
            		sDay = iDay + "天";
        		}
        		iHour = parseInt((iTime/3600)%24);
       			if (iHour > 0){
            		sHour = iHour + "小时";
        		}
        		iMinute = parseInt((iTime/60)%60);
        		if (iMinute > 0){
            		sMinute = iMinute + "分钟";
        		}
        		iSecond = parseInt(iTime%60);
        		if (iSecond >= 0){
            		sSecond = iSecond + "秒";
        		}	
        		if ((sDay=="")&&(sHour=="")){
            		sTime="<span style='color:darkorange'>" + sMinute+sSecond + "</font>";
        		}else{
            		sTime=sDay+sHour+sMinute+sSecond;
        		}
        		if(iTime==0){
            		clearTimeout(Account);
            		flag = false;
                	sTime="<span style='color:red'>节约时间到了 </span>";
                	document.getElementById("read").style.display = "none";
                	window.location.href="book/changeBorrowBook?bookid="+bookid+"&userid="+userid;
        		}else{
            		Account = setTimeout("RemainTime()",1000);
        		}
        		iTime=iTime-1;
    		}else{
    			document.getElementById("read").style.display = "none";
            	sTime="<span style='color:red'>借阅到期 </span>";
   			}
   			document.getElementById(CID).innerHTML = sTime;
		}
</script>
      <%@ include file="footer.jsp"%>
