//图片滚动代码
//div_1是最外面的包围的样式，且必须overflow:hidden;
//div_2和div_3是同一个级别的DIV
function marquee(div_1,div_2,div_3,mt)
{
	var speed=90;
	var FGDemo = document.getElementById(div_1);
	var FGDemo1 = document.getElementById(div_2);
	var FGDemo2 = document.getElementById(div_3);
	
	FGDemo2.innerHTML=FGDemo1.innerHTML
	function Marquee1()
	{
		if(FGDemo2.offsetHeight-FGDemo.scrollTop<=0)
		{
			FGDemo.scrollTop-=FGDemo1.offsetHeight;
		}
		else
		{
			FGDemo.scrollTop++;
		}
	}
	var MyMar1=setInterval(Marquee1,speed);
	FGDemo.onmouseover=function()
	{
		clearInterval(MyMar1);
	}
	FGDemo.onmouseout=function()
	{
		MyMar1=setInterval(Marquee1,speed);
	}
}

function openwinx(url,name,w,h)
{
	var url;        //转向网页的地址;
	var name;       //网页名称，可为空;
	var w;     //弹出窗口的宽度;
	var h;    //弹出窗口的高度;
	var t = (window.screen.availHeight-30-h)/2;       //获得窗口的垂直位置;
	var l = (window.screen.availWidth-10-w)/2;           //获得窗口的水平位置;
	window.open(url,name,'height='+h+',,innerHeight='+h+',width='+w+',innerWidth='+w+',top='+t+',left='+l+',toolbar=no,menubar=no,scrollbars=auto,resizeable=no,location=no,status=no');
}

function Dialog(url,name,w,h)
{
	return showModalDialog(url, name, 'dialogWidth:'+w+'px; dialogHeight:'+h+'px; help: no; scroll: yes; status: no');
}

function setidval(id,value)
{ 
    document.getElementById(id).innerHTML = value;
}

function getidval(id)
{ 
    return document.getElementById(id).innerHTML;
}

function checkall(form)
{
	for(var i = 0;i < form.elements.length; i++) 
	{
		var e = form.elements[i];
		if(e.name != 'chkall' && e.disabled != true) e.checked = form.chkall.checked;
	}
}

function redirect(url)
{
	window.location.replace(url);
}

function confirmurl(url,message)
{
	if(confirm(message)) location.href = url;
}

function confirmform(form,message)
{
	if(confirm(message)) form.submit();
}

function setcookie(name, value)
{
    name = cookiepre+name;
    var argc = setcookie.arguments.length; 
	var argv = setcookie.arguments; 
	var path = (argc > 3) ? argv[3] : null; 
	var domain = (argc > 4) ? argv[4] : null; 
	var secure = (argc > 5) ? argv[5] : false; 
	document.cookie = name + "=" + value + ((path == null) ? "" : ("; path=" + path)) + ((domain == null) ? "" : ("; domain=" + domain)) + ((secure == true) ? "; secure" : ""); 
} 

function deletecookie(name)
{
    var exp = new Date(); 
	exp.setTime (exp.getTime() - 1); 
	var cval = getcookie(name);
    name = cookiepre+name;
	document.cookie = name + "=" + cval + "; expires=" + exp.toGMTString(); 
}

function getcookieval(offset)
{
	var endstr = document.cookie.indexOf (";", offset); 
	if (endstr == -1) 
	endstr = document.cookie.length; 
	return unescape(document.cookie.substring(offset, endstr)); 
}

function getcookie(name)
{
	name = cookiepre+name;
	var arg = name + "="; 
	var alen = arg.length; 
	var clen = document.cookie.length; 
	var i = 0; 
	while (i < clen) { 
	var j = i + alen; 
	if (document.cookie.substring(i, j) == arg) 
	return getcookieval(j); 
	i = document.cookie.indexOf(" ", i) + 1; 
	if (i == 0) break; 
	} 
	return null; 
}

var tID=0;
function ShowTabs(ID)
{
	var tTabTitle=document.getElementById("TabTitle"+tID);
	var tTabs=document.getElementById("Tabs"+tID);
	var TabTitle=document.getElementById("TabTitle"+ID);
	var Tabs=document.getElementById("Tabs"+ID);
	if(ID!=tID)
	{
		tTabTitle.className='title1';
		TabTitle.className='title2';
		tTabs.style.display='none';
		Tabs.style.display='';
		tID=ID;
	}
}

function ChangeInput (objSelect,objInput)
{
	if (!objInput) return;
	var str = objInput.value;
	var arr = str.split(",");
	for (var i=0; i<arr.length; i++){
	  if(objSelect.value==arr[i])return;
	}
	if(objInput.value=='' || objInput.value==0 || objSelect.value==0){
	   objInput.value=objSelect.value
	}else{
	   objInput.value+=','+objSelect.value
	}
}

var flag=false; 
function setpicWH(ImgD,w,h)
{ 
	var image=new Image();
	image.src=ImgD.src; 
	if(image.width>0 && image.height>0)
	{ 
		flag=true; 
		if(image.width/image.height>= w/h)
		{ 
			if(image.width>w)
			{  
				ImgD.width=w; 
				ImgD.height=(image.height*w)/image.width; 
				ImgD.style.display="block";
			}else{ 
				ImgD.width=image.width;  
				ImgD.height=image.height; 
				ImgD.style.display="block";
			} 
		}else{
			if(image.height>h)
			{  
				ImgD.height=h; 
				ImgD.width=(image.width*h)/image.height; 
				ImgD.style.display="block"; 
			}else{ 
				ImgD.width=image.width;  
				ImgD.height=image.height; 
				ImgD.style.display="block";
			} 
		} 
	} 
}

function checkradio(radio)
{
	var result = false;
	for(var i=0; i<radio.length; i++)
	{
		if(radio[i].checked)
		{
			result = true;
			break;
		}
	}
    return result;
}

function checkselect(select)
{
	var result = false;
	for(var i=0;i<select.length;i++)
	{
		if(select[i].selected && select[i].value!='' && select[i].value!=0)
		{
			result = true;
			break;
		}
	}
    return result;
}

var Browser = new Object();
Browser.isMozilla = (typeof document.implementation != 'undefined') && (typeof document.implementation.createDocument != 'undefined') && (typeof HTMLDocument!='undefined');
Browser.isIE = window.ActiveXObject ? true : false;
Browser.isFirefox = (navigator.userAgent.toLowerCase().indexOf("firefox")!=-1);
Browser.isSafari = (navigator.userAgent.toLowerCase().indexOf("safari")!=-1);
Browser.isOpera = (navigator.userAgent.toLowerCase().indexOf("opera")!=-1);

var Common = new Object();
Common.htmlEncode = function(str) 
{
	return str.replace(/&/g, '&amp;').replace(/"/g, '&quot;').replace(/</g, '&lt;').replace(/>/g, '&gt;');
}

Common.trim = function(str)
{
	return str.replace(/(^\s*)|(\s*$)/g, "");
}

Common.strlen = function (str)
{
   return str.replace(/[^\x00-\xff]/g, "**").length;
}

Common.isdate =function (str)
{
   var result=str.match(/^(\d{4})(-|\/)(\d{1,2})\2(\d{1,2})$/);
   if(result==null) return false;
   var d=new Date(result[1], result[3]-1, result[4]);
   return (d.getFullYear()==result[1] && d.getMonth()+1==result[3] && d.getDate()==result[4]);
}

Common.isnumber = function(val)
{
    var reg = /[\d|\.|,]+/;
    return reg.test(val);
}

Common.isalphanumber= function (str)
{
	var result=str.match(/^[a-zA-Z0-9]+$/);
	if(result==null) return false;
	return true;
}

Common.isint = function(val)
{
    var reg = /\d+/;
    return reg.test(val);
}

Common.isemail = function(email)
{
    var reg = /([\w|_|\.|\+]+)@([-|\w]+)\.([A-Za-z]{2,4})/;
    return reg.test( email );
}

Common.fixeventargs = function(e) 
{
    var evt = (typeof e == "undefined") ? window.event : e;
    return evt;
}

Common.srcelement = function(e)
{
    if (typeof e == "undefined") e = window.event;
    var src = document.all ? e.srcElement : e.target;
    return src;
}

Common.isdatetime = function(val)
{
	var result=str.match(/^(\d{4})(-|\/)(\d{1,2})\2(\d{1,2}) (\d{1,2}):(\d{1,2}):(\d{1,2})$/);
	if(result==null) return false;
	var d= new Date(result[1], result[3]-1, result[4], result[5], result[6], result[7]);
	return (d.getFullYear()==result[1]&&(d.getMonth()+1)==result[3]&&d.getDate()==result[4]&&d.getHours()==result[5]&&d.getMinutes()==result[6]&&d.getSeconds()==result[7]);
}