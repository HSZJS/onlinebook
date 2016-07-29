<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.zg.dao.sh.BookShDao"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="org.springframework.orm.hibernate3.HibernateTemplate"%>
<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.Query"%>
<%@page import="com.zg.po.Book"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>top</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">


	<%
	HibernateTemplate s = new BookShDao().getSessionFactory();
	String hql = "from Book where isCheck = 1 and isdel = 0 order by offerTime desc ,search desc";
	Session sess = s.getSessionFactory().openSession();
		Query   query   =   sess.createQuery(hql); 
		query.setFirstResult(0); 
		query.setMaxResults(6); 
		List<Book> bookSear= (List<Book>)query.list();
		Book b1 = (Book)bookSear.get(0);
		Book b2 = (Book)bookSear.get(1);
		Book b3 = (Book)bookSear.get(2);
		Book b4 = (Book)bookSear.get(3);
		Book b5 = (Book)bookSear.get(4);
		Book b6 = (Book)bookSear.get(5);
	%>
<!-- Save for Web Slices (top.jpg) -->
<table id="__01" width="290" height="296" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td colspan="5">
			<img src="images/top_01.gif" width="290" height="42" alt=""></td>
	</tr>
	<tr>
		<td colspan="2"  style="border-left:1px solid #96A8C4">
			<a href="#">
				<img src="images/top_02.gif" width="117" height="124" border="0" alt=""></a></td>
		<td>
			<img src="images/top_03.gif" width="21" height="124" alt=""></td>
		<td colspan="2" style="border-right:1px solid #96A8C4">
			
				<div style="width:152px;height:124px;margin: 0px;padding: 0px;line-height: 28px;font-size:13px;color:green">
					<a href="../book/one?id=<%=b6.getId()%>" target="_blank" style="color:green;font-size:13px;"><%=b6.getName()%></a><br/>
					作者：<%=b1.getAuthor()%>
				</div>	
		</td>
	</tr>
	<tr>
		
		<td colspan="4" style="color:green;font-size:13px;text-indent:20px;border-left:1px solid #96A8C4"><a href="../book/one?id=<%=b2.getId()%>" target="_blank" style="color:green;font-size:13px;"><%=b2.getName()%></a></td>
		
		<td style=" color:green;font-size:13px;width:40px;margin: 0px;border-right:1px solid #96A8C4;" align="center" style="font-size:12px"><%=b2.getAuthor()%></td>
	</tr>
	<tr>
		<td colspan="4" style="font-size:13px;text-indent:20px;border-left:1px solid #96A8C4"><a href="../book/one?id=<%=b3.getId()%>" target="_blank" style="color:green;font-size:13px;"><%=b3.getName()%></a></td>
		<td style=" color:green;font-size:13px;border-right:1px solid #96A8C4;width:40px;" align="center" style="font-size:12px"><%=b3.getAuthor()%></td>
	</tr>
	<tr>
		<td colspan="4" style="font-size:13px;text-indent:20px;border-left:1px solid #96A8C4"><a href="../book/one?id=<%=b4.getId()%>" target="_blank" style="color:green;font-size:13px;"><%=b4.getName()%></a></td>
		<td style=" color:green;font-size:13px;border-right:1px solid #96A8C4;width:40px;" align="center" style="font-size:12px"><%=b4.getAuthor()%></td>
	</tr>
	<tr>
		<td colspan="4" style="font-size:13px;text-indent:20px; border-left:1px solid #96A8C4"><a href="../book/one?id=<%=b5.getId()%>" target="_blank" style="color:green;font-size:13px;"><%=b5.getName()%></a></td>
		<td style=" color:green;font-size:13px;border-right:1px solid #96A8C4;" align="center" style="font-size:12px"><%=b5.getAuthor()%></td>
	</tr>
	<tr>
		<td colspan="4" style="font-size:13px;text-indent:20px;border-bottom:1px solid #96A8C4;border-left:1px solid #96A8C4"><a href="../book/one?id=<%=b6.getId()%>" target="_blank" style="color:green;font-size:13px;"><%=b6.getName()%></a></td>
		<td style=" color:green;font-size:13px;border-right:1px solid #96A8C4;border-bottom:1px solid #96A8C4;" align="center" ><%=b6.getAuthor()%></td>
	</tr>

	<tr>
		<td>
			<img src="images/&#x5206;&#x9694;&#x7b26;.gif" width="97" height="1" alt=""></td>
		<td>
			<img src="images/&#x5206;&#x9694;&#x7b26;.gif" width="20" height="1" alt=""></td>
		<td>
			<img src="images/&#x5206;&#x9694;&#x7b26;.gif" width="21" height="1" alt=""></td>
		<td>
			<img src="images/&#x5206;&#x9694;&#x7b26;.gif" width="55" height="1" alt=""></td>
		<td>
			<img src="images/&#x5206;&#x9694;&#x7b26;.gif" width="97" height="1" alt=""></td>
	</tr>
</table>
<!-- End Save for Web Slices -->
</body>
</html>