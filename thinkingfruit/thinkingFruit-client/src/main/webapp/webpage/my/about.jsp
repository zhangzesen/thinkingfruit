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
<style type="text/css">
#head{
    width: 15%;
    float: left;}
</style>
</head>
<body>
        <section class="aui-flexView">
            <header class="aui-bar aui-bar-nav aui-bar-light" style="color: black;">
                <a id="head" href="javascript:history.back(-1)" class="aui-navBar-item">
                    <i class="icon icon-return"></i>
                </a>
                <div class="aui-center">
                    <span class="aui-center-title">关于爱因斯果</span>
                </div>
            </header>

	爱因斯果致力于产品研发，吧了巴拉巴拉~~
	联系方式：12345677
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
	<script>WEB_ROOT="<%=basePath%>"</script>
</body>
</html>