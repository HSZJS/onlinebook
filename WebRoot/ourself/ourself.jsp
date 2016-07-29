<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
     <title>欢迎来到悦读客！</title>
     
      <%@ include file="../book/header.jsp"%>
      <div align="center">
    <div  style="background-color: #E9EEE8;padding: 0;margin: o;width: 950;">
    <div style="width: 750" align="left">
    <p  style="font-size: 40px;line-height: 20px; padding: 20px;" align="center">
    <b>
                 悦读客--电子书服务平台的设计与实现</b>
    </p>
    <p style="font-size: 16px;line-height: 20px;margin-left: 30px;" align="left">                           
         院系名称：软件学院<br>
         班          级：软件工程（JAVA方向）<br>
         成员姓名：张林克 陈礼松  余凯<br>
         指导教师：贾晓辉  
    </p>
    <p style="font-size: 12px;line-height: 20px;">
    <br>
   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;此电子图书借阅管理系统完成后，将会打破传统的文学传播方式，充分利用了网络的互动性、迅捷性。
      解决了传统图书馆有着图书来源缺乏、图书分类混乱、图书更新缓慢、纸质图书成本较高和携带阅读不方便、
      付费方式上仍主要靠人工操作、工作量较大、出错率较高。在另一方面盗版书的猖獗，导致读者和图书作者的权益受到了极大的损害的缺点。
      最终给读者带来极大的方便同时也大大的方便了图书管理员对图书的管理，节约人力物力，符合党建设节约型社会的基本国策。
      <br>&nbsp;
    </p>
     <p style="font-size: 12px;line-height: 20px;">
   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <b>涉及的技术</b>	<br>		
框架技术：struts2、hibernate、spring、jquery、ajax<br>
前端技术：html、css、javascript、<br>
中间件：tomcat、<br>
　　本系统采用Struts2+Hibernate+Spring三层框架设计模式，数据库采用Mysql，
开发工具使用Myeclipse 8.0，编程语言为Java，前台页面使用了JavaScript/CSS/Ajax/Jquery等技术来控制页面的显示和数据的验证。
在SSH三层设计模式中，模型相应客户请求并返回响应数据，试图负责格式化数据并把它们呈现给用户。
业务逻辑和表示层分离。同一个模型可以被不同的视图重用，所以大大提高了代码的可重用性。

      <br>&nbsp;
       </p>
       </div>
    </div>
</div>
  
  <%@ include file="../book/footer.jsp"%>