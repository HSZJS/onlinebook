<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">  
<title>图片上传</title>  
<script>  
function viewmypic(mypic,imgfile) {  
if (imgfile.value){  
mypic.src=imgfile.value;  
mypic.style.display="";  
mypic.border=1;  
}  
}  
</script>  
</head>  
<body>  
<center>  
<form name="upmyimg" method="post" enctype="multipart/form-data" action="getyourpic/" onsubmit="return checkimg( this );" >  
<input name="imgfile" type="file" id="imgfile" size="40" onchange="viewmypic(showimg,this.form.imgfile);" />  
<br />  
</form>  
<img name="showimg" id="showimg" src="" style="display:none;" alt="预览图片" />  
<br />  
<div style="display:none">  
</div>  
</center>  
</body>  
</html>  