<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/context/begin-tags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>爱因思果</title>
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
<link href="iTunesArtwork@2x.png" sizes="114x114"
	rel="apple-touch-icon-precomposed">
<link rel="stylesheet" type="text/css" href="<%=basePath%>/static/plugin/aui/css/aui.css" />

</head>
<body>

	<section class="aui-flexView">
		<header class="aui-bar aui-bar-nav aui-bar-light" style="color: black;">
    <div class="aui-title">个人中心</div>
</header>
		<section class="aui-scrollView">
			<div class="aui-member-head">
				<div class="aui-member-user">
					<img src="<%=basePath%>/static/plugin/aui/images/gril.jpg" alt="">
				</div>
				<div class="aui-member-text">
					<h1>小脑斧</h1>
					<p style="color:#333;">id：18519232894</p>
				</div>
			</div>
			<div class="aui-flex b-line">
				<div class="aui-flex-box">
					<h4>我的订单</h4>
				</div>
				<div class="aui-flex-arrow">
					<p>全部订单</p>
				</div>
			</div>
			<div class="aui-layout">
					<div class="aui-layout-icon">
						<img src="themes/img/icon/icon-item-001.png" alt="">
					</div>
					<div class="aui-layout-text">待审核</div>
					<div class="aui-layout-icon">
						<img src="themes/img/icon/icon-item-002.png" alt="">
					</div>
					<div class="aui-layout-text">待发货</div>
					<div class="aui-layout-icon">
						<img src="themes/img/icon/icon-item-003.png" alt="">
					</div>
					<div class="aui-layout-text">待收货</div>
					<div class="aui-layout-icon">
						<img src="themes/img/icon/icon-item-004.png" alt="">
					</div>
					<div class="aui-layout-text">需确认订单</div>

			</div>
			<div class="divHeight"></div>
			<div class="aui-course-list">
					<div class="aui-course-icon">
						<img src="themes/img/icon/icon-ad-001.png" alt="">
					</div>
					<div class="aui-flex-box">
						<h5>收货地址</h5>
					</div>
					<div class="aui-course-icon">
						<img src="themes/img/icon/icon-ad-002.png" alt="">
					</div>
					<div class="aui-flex-box" id="information">
						<h5>用户设置</h5>
					</div>
					<div class="aui-course-icon">
						<img src="themes/img/icon/icon-ad-003.png" alt="">
					</div>
					<div class="aui-flex-box">
						<h5>关于我们</h5>
					</div>
				<div class="divHeight"></div>
					<div class="aui-course-icon">
						<img src="themes/img/icon/icon-ad-004.png" alt="">
					</div>
					<div class="aui-flex-box">
						<h5>佣金详情</h5>
					</div>

					<div class="aui-course-icon">
						<img src="themes/img/icon/icon-ad-004.png" alt="">
					</div>
					<div class="aui-flex-box">
						<h5>提现</h5>
					</div>


				<div class="divHeight"></div>
					<div class="aui-course-icon">
						<img src="themes/img/icon/icon-ad-006.png" alt="">
					</div>
					<div class="aui-flex-box">
						<h5>我的团队</h5>
					</div>

				<div class="divHeight"></div>
			</div>



		</section>
		<footer class="aui-footer aui-footer-fixed">
			<botton id="home" class="aui-tabBar-item "> <span
				class="aui-tabBar-item-icon"> <i class="icon icon-home"></i>
			</span> <span class="aui-tabBar-item-text">首页</span> </botton>
			<botton id="news" class="aui-tabBar-item "> <span
				class="aui-tabBar-item-icon"> <i class="icon icon-collage"></i>
			</span> <span class="aui-tabBar-item-text">文章</span> </botton>
			<botton id="my" class="aui-tabBar-item aui-tabBar-item-active">
			<span class="aui-tabBar-item-icon"> <i class="icon icon-my"></i>
			</span> <span class="aui-tabBar-item-text">我的</span> </span> </botton>
		</footer>
	</section>

	<script type="text/javascript"
		src="<%=basePath%>/static/plugin/themes/jquery.min.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>/static/plugin/themes/slider.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>/static/plugin/themes/tab.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>/static/js/my/index.js"></script>
	<script>WEB_ROOT="<%=basePath%>"
	</script>
</body>
</html>