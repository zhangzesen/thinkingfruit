<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
</head>
<body>
<h1>用户登录</h1>
<div>
用户名:<input type="text" name="name"><br>
密码:<input type="password" name="password">
<input type="button" onclick="login()" value="登录">
</div>
<script type="text/javascript" src="/yuansheng-admin/static/plugin/jquery/jquery-2.1.4.min.js"></script>
<script type="text/javascript">
function login(){
	$.ajax({
		url:"/yuansheng-admin/user/login",
		method:"POST",
		type:"text/json",
		data:{name:$("input[name='name']").val(),
			  password:$("input[name='password']").val()
		     },
	    success:function(res){
	    	console.log(res);
	    	if(res.code == 0){
	    		alert("登录成功");
	    	}
	    	else{
	    		alert(res.msg);
	    	}
	    }
		
	})
}



</script>
</body>
</html>