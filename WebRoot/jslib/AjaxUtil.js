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
				alert("���ܴ���XmlHttpRequest");
			}
		}
	}
}

/**
 * @param method :�ô�ajax���ύ��ʽ  get������post
 * @param url ���ô�ajaxҪ���͵�����  ע�⣺�����get�ύ��ʽ��url��Ӧ�ð��������б�  �����post�򲻰��������б�
 * @param async ���ô�ajax���ύģʽ ͬ�������첽ģʽ  true�����첽ģʽ
 * @param params : �����get��ʽ��Ϊnull  post��ʽ��Ϊ�ύ�Ĳ����б�
 * @param writeMessage:������һ�������Ĳ���  ���Ǵ�����ֵ�Ĵ���ĺ�����
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
				returnMessage = "<b style='color:red'>��������æ</b>";
			}
			/*
			 * ������ֵ
			 */
			writeMessage();
		}
	};
}