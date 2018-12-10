<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/context/begin-tags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/context/css-tags.jsp" />
</head>
<body>
	<div class="layui-tab layui-tab-brief main-tab-container">
		<div class="layui-tab-content">
		<div class="layui-tab layui-tab-card">
		    <ul class="layui-tab-title">
				<li class="layui-this">公司邀请代理</li>
			</ul>
		    <div class="layui-form" style="margin-top:50px;">
		    <h1>点击右键保存二维码</h1>
		    <img src="<%=basePath%>/static/images/qr.png"  alt="公司邀请二维码" style="height:300px;width:300px;"/>
			</div>
		</div>
		</div>
	</div>
	<jsp:include page="/context/js-tags.jsp" />
</body>
</html>