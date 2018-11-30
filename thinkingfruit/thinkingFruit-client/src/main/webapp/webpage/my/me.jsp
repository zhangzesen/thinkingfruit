<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/context/begin-tags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<meta
	content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=0"
	name="viewport" />
<meta content="yes" name="apple-mobile-web-app-capable" />
<meta content="black" name="apple-mobile-web-app-status-bar-style" />
<meta content="telephone=no" name="format-detection" />
<link type="text/css" rel="stylesheet"
	href="<%=basePath%>/static/css/base.css">
<link type="text/css" rel="stylesheet"
	href="<%=basePath%>/static/css/icon.css">
<link type="text/css" rel="stylesheet"
	href="<%=basePath%>/static/css/home.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>/static/plugin/aui/css/aui.css" />
<link href="iTunesArtwork@2x.png" sizes="114x114"
	rel="apple-touch-icon-precomposed">

</head>
<body>
<div class="" style="overflow:hidden">
	<div class="">

		<div class="header">
			<div class="header-background"></div>
			<div class="toolbar statusbar-padding">
				<button class="bar-button back-button" onclick="history.go(-1);" dwz-event-on-click="click"><i class="icon icon-back"></i></button>
				<!--<a class="bar-button" data-href="home.html?dwz_callback=home_render" target="navTab" rel="home"><i class="icon icon-back"></i></a>-->
				<div class="header-title">
					<div class="title">个人信息</div>
				</div>
			</div>
		</div>
		<div style="height:44px"></div>

		<div class="aui-list-cells aui-list-clears">
			<a href="#" class="aui-list-cell">
				<div class="aui-list-cell-cn">头像</div>
				<div class="aui-list-cell-fr aui-list-cell-im"><img src="images/icon/he.png" alt=""></div>
			</a>
			<a href="#" class="aui-list-cell">
				<div class="aui-list-cell-cn">昵称</div>
				<div class="aui-list-cell-fr">紫罗兰</div>
			</a>
			<a href="#" class="aui-list-cell">
				<div class="aui-list-cell-cn">账号</div>
				<div class="aui-list-cell-fr">ZX-xinxiwdgsdg</div>
			</a>
			<a href="#" class="aui-list-cell">
				<div class="aui-list-cell-cn">性别</div>
				<div class="aui-list-cell-fr">男</div>
			</a>
			<div class="devider b-line"></div>
			<a href="#" class="aui-list-cell">
				<div class="aui-list-cell-cn">二维码</div>
				<div class="aui-list-cell-fr aui-list-cell-im"><img src="images/icon/he1.png" alt=""></div>
			</a>
			<a href="#" class="aui-list-cell">
				<div class="aui-list-cell-cn">签名</div>
				<div class="aui-list-cell-fr">未签名</div>
			</a>
			<div class="devider b-line"></div>
			<a href="#" class="aui-list-cell">
				<div class="aui-list-cell-cn">等级</div>
				<div class="aui-list-cell-fr">大班</div>
			</a>
		</div>



	</div>
</div>

</body>
</html>