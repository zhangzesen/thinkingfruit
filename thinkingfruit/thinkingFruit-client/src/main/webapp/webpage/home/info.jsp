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
    <div class="aui-title">爱因思果</div>
</header>
		<section class="aui-scrollView">
			<section class="aui-content">
			<div class="aui-card-list">
				<div class="aui-card-list-header">商品1</div>
				<div class="aui-card-list-content">
					<img src="<%=basePath%>/static/images/banner/shili1.jpg" />
				</div>
			</div>
			</section>
			<div class="aui-course-list">
					<div class="aui-flex-box">
						<h5>价格：<i>¥</i><i>99.00</i></h5>
					</div>
					<div class="aui-flex-box">
						<h5>规格（信息）</h5>
					</div>
				
				<div class="divHeight"></div>
				</div>
				<div class="aui-login-line">
                    <h2>商品详情</h2>
                </div>
                <div class="aui-page-box">
                    <p>
                        <img src="<%=basePath%>/static/images/banner/shili1.jpg" alt="">
                    </p>
                    <p>
                        <img src="<%=basePath%>/static/images/banner/shili2.jpg" alt="">
                    </p>
                    <p>
                        <img src="<%=basePath%>/static/images/banner/shili3.jpg" alt="">
                    </p>
                     <p>致力于打造更好的产品为更好的你</p>
                </div>
		</section>
		<footer class="aui-footer aui-footer-fixed">
			<a href="javascript:;" class="aui-tabBar-item aui-tabBar-item-active">
            	<span class="aui-tabBar-item-icon">
                	<i class="icon icon-home"></i>
                </span>
                <span class="aui-tabBar-item-text">首页</span>
            </a>
            <button class="aui-button-btn">
                                                            立即购买
            </button>
		</footer>
	</section>
	<jsp:include page="/context/js-tags.jsp" />
	<script type="text/javascript"
		src="<%=basePath%>/static/plugin/themes/jquery.min.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>/static/plugin/themes/slider.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>/static/plugin/themes/tab.js"></script>
		<script type="text/javascript"
		src="<%=basePath%>/static/js/home/info.js"></script>
<script>WEB_ROOT="<%=basePath%>"</script>
</body>
</html>