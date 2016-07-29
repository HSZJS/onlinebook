function login(){   
    /*找到div节点并返回*/  
    var winNode = $("#win");   
   //方法一：利用js修改css的值，实现显示效果   
   // winNode.css("display", "block");   
   //方法二：利用jquery的show方法，实现显示效果   
   // winNode.show("slow");   
    //方法三：利用jquery的fadeIn方法实现淡入   
    winNode.fadeIn("slow");   
}   
function hide(){   
    var winNode = $("#win");   
    //方法一：修改css的值   
    //winNode.css("display", "none");   
    //方法二：jquery的fadeOut方式   
    winNode.fadeOut("slow");   
    //方法三：jquery的hide方法   
    winNode.hide("slow");   
}
function check(){
	var error = $("#error");
	var email=$('#email').val();
    var password=$('#password').val();
    //判断是否为空
    if(email==""){
    	alert("账号不能为空！");
    	$('#email').focus();
    	return false;
     }
    if(password==""){
    	alert("密码不能为空");
    	$('#password').focus();
    	return false;    
     }
	//对电子邮件的验证
	var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
	if(!myreg.test(email)){
		error.innerHTML = "格式正确";
	 }
}