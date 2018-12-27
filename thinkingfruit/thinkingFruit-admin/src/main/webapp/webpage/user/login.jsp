<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/context/begin-tags.jsp"%>	
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="<%=basePath%>/static/css/user/login.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>爱因思果登录</title>
</head>
<body>
	<div class="container">
	    <form class="formarea">
		<div class="header">
			<a href="#"> <img src="<%=basePath%>/static/images/ljl-top.png">
			<div>
			爱因思果
			</div>
			</a>
			<div id="option">登录</div>
		</div>
		<div class="center">
			<div>
			
			<div class="classification">
				<div class="label">登录名</div>
				<input type="text" class="loginName" name="loginName"
				  required="true"	placeholder="请输入用户名">
				<div class="clear"></div>
			</div>

			<div class="classification">
				<div class="label">登录密码</div>
				<input type="password" required="true" minlength="8" maxlength="20" class="password" name="password" placeholder="请输入密码">
				<div class="clear"></div>
			</div>
			
			<div class="classification">
				<div class="label">验证码</div>
				<input type="verification" class="verification" name="verification" autocomplete="off"
					style="width: 250px;float: left;" placeholder="请输入验证码">
					<div class="code">	
				<img src="<%=basePath%>/randCodeImage" alt="captche" title='点击切换' id="qrcode"
						onclick="this.src='<%=basePath%>/randCodeImage?id='+Math.random()">
						</div>
			<div class="clear"></div>	
			</div>
			<input id="login" class="button" type="button" value="登录">		
		</div>
		</form>
	</div>
	<jsp:include page="/context/js-tags.jsp" />
	<script type="text/javascript"
		src="<%=basePath%>/static/js/user/login.js"></script>
</body>
</html>