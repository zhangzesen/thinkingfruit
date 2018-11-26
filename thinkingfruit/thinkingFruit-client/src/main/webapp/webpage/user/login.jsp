<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/context/begin-tags.jsp"%>	
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>thinkingFruit</title>

<link rel="stylesheet" href="<%=basePath%>/static/css/login/style.css" />

<body>

<div class="login-container">
	<h1>爱因思果用户登录</h1>
	
	<div class="connect">
		<p>把精彩留给自己</p>
	</div>
	
	<form action="" method="post" id="loginForm">
		<div>
			<input type="text" name="username" class="username" placeholder="用户名" autocomplete="off"/>
		</div>
		<div>
			<input type="password" name="password" class="password" placeholder="密码" oncontextmenu="return false" onpaste="return false" />
		</div>
		<button id="submit" type="submit">登 陆</button>
	</form>

	<a href="register.html">
		<button type="button" class="register-tis">还有没有账号？</button>
	</a>
	
</div>

<script src="<%=basePath%>/static/js/user/login/jquery.min.js"></script>
<script src="<%=basePath%>/static/js/user/login/common.js"></script>
<!--背景图片自动更换-->
<script src="<%=basePath%>/static/js/user/login/supersized.3.2.7.min.js"></script>
<script src="<%=basePath%>/static/js/user/login/supersized-init.js"></script>
<!--表单验证-->
<script src="<%=basePath%>/static/js/user/login/jquery.validate.min.js"></script>

</body>
</html>