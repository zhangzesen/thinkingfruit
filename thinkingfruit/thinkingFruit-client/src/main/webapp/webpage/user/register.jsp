<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/context/begin-tags.jsp"%>	
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/context/js-tags.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>thinkingFruit</title>
<link rel="stylesheet" href="<%=basePath%>/static/css/login/style.css" />
<style type="text/css">
.classification{
    margin-top: 25px;
}
.verification{
    width: 158px;
    float: left;
    margin-top: -1%;
}
.layui-layer-content{
color:black
}
</style>
</head>
<body>
<div class="register-container">
	<h1>用户注册</h1>
	
	<div class="connect">
		<p>welcome！</p>
	</div>
	
	<form action="" method="post" id="registerForm">
		<div>
			<input type="text" name="loginName" class="username" placeholder="您的用户名" autocomplete="off"/>
		</div>
		<div>
			<input type="password" name="loginPassword" class="password" placeholder="输入密码" oncontextmenu="return false" onpaste="return false" />
		</div>
		<div>
			<input type="password" name="confirm_password" class="confirm_password" placeholder="再次输入密码" oncontextmenu="return false" onpaste="return false" />
		</div>
		<div>
			<input type="text" name="mobile" class="mobile" placeholder="请输入手机号" autocomplete="off" />
		</div>
		<div class="classification">
				<input type="verification" class="verification" name="verification" autocomplete="off"
					 placeholder="请输入验证码">
				<div class="code">	
					<img src="<%=basePath%>/randCodeImage" alt="captche" title='点击切换' id="qrcode"
						onclick="this.src='<%=basePath%>/randCodeImage?id='+Math.random()">
				</div>
			<div class="clear"></div>	
		</div>
		<button id="submit" type="button">注册</button>
	</form>
	<button id="login" type="button" class="register-tis" >已经有账号？</button>
</div>


<script type="text/javascript" src="<%=basePath%>/static/js/user/loginStyle/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/static/js/user/loginStyle/common.js"></script>
<!--背景图片自动更换-->
<script type="text/javascript" src="<%=basePath%>/static/js/user/loginStyle/supersized.3.2.7.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/static/js/user/loginStyle/supersized-init.js"></script>
<!--表单验证-->
<script type="text/javascript" src="<%=basePath%>/static/js/user/loginStyle/jquery.validate.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/static/js/user/register.js"></script>

</body>
</html>