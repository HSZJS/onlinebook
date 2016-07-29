<%@ page language="java"
	import="java.util.*,com.zg.util.Page"
	pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
	<head>

		<base href="<%=basePath%>">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv=”X-UA-Compatible” content=”IE=EmulateIE7″ />
		<title></title>
		<link href="admin/css/css.css" rel="stylesheet" type="text/css" />
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<script type="text/javascript" src="common/js/core.js"></script>
		<script type="text/javascript">
		
	
	
	</script>
      <style>
DIV.msdn {
	PADDING-RIGHT: 3px; PADDING-LEFT: 0px; FONT-SIZE: 13px; PADDING-BOTTOM: 2px; COLOR: #313031; PADDING-TOP: 2px; FONT-FAMILY: Verdana,Tahoma,Arial,Helvetica,Sans-Serif; BACKGROUND-COLOR: #fff; TEXT-ALIGN: right
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

		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td width="48%" class="pages">
					&nbsp;&nbsp;<span style="color:#0030D7">页次:
					<b>${page.currentPageIndex}</b>/
					<b>${page.totalPageNum}</b>页&nbsp;&nbsp;每页显示
					<b>${page.pageSize}</b>个&nbsp;&nbsp;共
					<b>${page.totalRowNum}</b>条数据</span>
				</td>

				<td align="right">


					<div class="digg">	
                      <div class="msdn">
						<s:if test="page.currentPageIndex>1">
							
							<a href="book/search?requirement=${requirement}&pn=${page.currentPageIndex-1}&search=${search}">上一页</a>
						</s:if>

						<s:iterator begin="page.startPageIndex" end="page.endPageIndex" status="i" var="p">
							<s:if test="page.currentPageIndex==#p">
								<span class="current">${p}</span>
							</s:if>
							<s:else>
								
								<a href="book/search?requirement=${requirement}&pn=${p}&search=${search}">${p }</a>
							</s:else>
						</s:iterator>

						<s:if test="page.currentPageIndex < page.totalPageNum">
							
							<a href="book/search?requirement=${requirement}&pn=${page.currentPageIndex+1}&search=${search}">下一页</a>
						</s:if>
                       </div>
					</div>
				</td>
			</tr>
		</table>

	</body>
</html>
