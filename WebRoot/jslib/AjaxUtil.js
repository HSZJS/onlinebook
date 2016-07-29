var xmlHttp;
var returnMessage;
function createXmlHttp() {
	if (window.XMLHttpRequest) {
		xmlHttp = new XMLHttpRequest();
		if (xmlHttp.overrideMimeType) {
			xmlHttp.overrideMimeType("text/xml");
		}
	} else if (window.ActiveXObject) {
		try {
			xmlHttp = new ActiveXObject("MSXML2.XMLHTTP");
		} catch (e) {
			try {
				xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e) {
				alert("不能创建XmlHttpRequest");
			}
		}
	}
}

/**
 * @param method :该次ajax的提交方式  get或者是post
 * @param url ：该次ajax要发送的请求  注意：如果是get提交方式该url中应该包含参数列表  如果是post则不包含参数列表
 * @param async ：该次ajax的提交模式 同步还是异步模式  true代表异步模式
 * @param params : 如果是get方式则为null  post方式则为提交的参数列表
 * @param writeMessage:并不是一个真正的参数  而是处理返回值的代码的函数名
 * @return
 */
function sendAjaxRequest(method,url,async,params,writeMessage){
	createXmlHttp();
	if(method == 'get'){
		url = encodeURI(url);
	}
	xmlHttp.open(method, url, async);
	if(method == 'post'){
		xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	}
	xmlHttp.send(params);
	xmlHttp.onreadystatechange = function(){
		if(xmlHttp.readyState == 4){
			if(xmlHttp.status == 200){
				returnMessage = xmlHttp.responseText;
			}else{
				returnMessage = "<b style='color:red'>服务器正忙</b>";
			}
			/*
			 * 处理返回值
			 */
			writeMessage();
		}
	};
}