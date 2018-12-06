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
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>/static/plugin/aui/css/aui.css" />
<link rel="stylesheet"
	href="<%=basePath%>/static/plugin/layui/css/layui.css" media="all">
</head>
<body>

	<section class="aui-flexView">
		<header class="aui-bar aui-bar-nav aui-bar-light"
			style="color: black;">
			<div class="aui-title">爱因思果</div>
		</header>
		<section class="aui-scrollView">
			<div class="m-slider" data-ydui-slider>
				<div class="slider-wrapper">
					<div class="slider-item">
						<a href="javascript:;"> <img
							src="<%=basePath%>/static/images/banner/shili1.jpg">
						</a>
					</div>



					<div class="slider-item">
						<a href="javascript:;"> <img
							src="<%=basePath%>/static/images/banner/shili2.jpg">
						</a>
					</div>
					<div class="slider-item">
						<a href="javascript:;"> <img
							src="<%=basePath%>/static/images/banner/shili3.jpg">
						</a>
					</div>

				</div>
				<div class="slider-pagination"></div>
			</div>
			<section class="aui-content">

				<div class="aui-card-list">
					<div class="aui-card-list-header">商品1</div>
					<div class="aui-card-list-content">
						<img src="<%=basePath%>/static/images/banner/shili1.jpg" value="8" />
					</div>
				</div>

				<div class="aui-card-list">
					<div class="aui-card-list-header">商品2</div>
					<div class="aui-card-list-content">
						<img src="<%=basePath%>/static/images/banner/shili2.jpg" />
					</div>
				</div>

				<div class="aui-card-list">
					<div class="aui-card-list-header">商品3</div>
					<div class="aui-card-list-content">
						<img src="<%=basePath%>/static/images/banner/shili3.jpg" />
					</div>
				</div>

			</section>
		</section>
		<footer class="aui-footer aui-footer-fixed">
			<div id="home" class="aui-tabBar-item aui-tabBar-item-active">
			<span class="aui-tabBar-item-icon"> <i class="icon icon-home"></i>
			</span> <span class="aui-tabBar-item-text">首页</span> </div>
			<div id="news" class="aui-tabBar-item "> <span
				class="aui-tabBar-item-icon"> <i class="icon icon-collage"></i>
			</span> <span class="aui-tabBar-item-text">文章</span> </div>
			<div id="my" class="aui-tabBar-item"> <span
				class="aui-tabBar-item-icon"> <i class="icon icon-my"></i>
			</span> <span class="aui-tabBar-item-text">我的</span> </span> </div>
		</footer>
	</section>

	<script type="text/javascript"
		src="<%=basePath%>/static/plugin/themes/jquery.min.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>/static/plugin/themes/slider.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>/static/plugin/themes/tab.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>/static/js/home/index.js"></script>
	<script>WEB_ROOT="<%=basePath%>"</script>
</body>
</html>