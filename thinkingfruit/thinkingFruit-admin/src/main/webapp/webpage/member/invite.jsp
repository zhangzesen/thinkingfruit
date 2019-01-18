<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/context/begin-tags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/context/css-tags.jsp" />
<style type="text/css">
h1{color: #737373; text-shadow: 0px 1px 0px #e5e5ee;}
h3{color: #737373; text-shadow: 0px 1px 0px #e5e5ee;}
h2{
	margin-bottom: 3%;
	color: #737373; text-shadow: 0px 1px 0px #e5e5ee;
}
</style>
</head>
<body>
	<div class="layui-tab layui-tab-brief main-tab-container">
		<div class="layui-tab-content">
			<div class="layui-tab layui-tab-card">
				<ul class="layui-tab-title">
					<li class="layui-this">公司邀请代理</li>
				</ul>
				<div style="margin: 30px 0 25px 0;">
					<div class="qr" style="width: 40%; display: inline-block">
						<h1 style="text-align: center;color:#c00;">公司直邀二维码</h1>
						<div style="text-align: center; vertical-align: middle;">
							<img src="<%=basePath%>/static/images/qr.png" alt="公司邀请二维码"
								style="height: 300px; width: 300px;" />
						</div>
						<h3 style="text-align: center;">（注：点击右键保存图片）</h3>
					</div>
					<div class="introduce"
						style="display: inline-block; width: 59%; text-align: center; vertical-align: top; margin-top: 9%;">
						<h1 style="margin-bottom: 3%;">扫描左侧二维码或搜索微信公众号</h1>
						<h2>"碱单爱"</h2>
						<h2>注册成为公司直系代理 ！</h2>
					</div>
				</div>
			</div>
		</div>
		<jsp:include page="/context/js-tags.jsp" />
</body>
</html>