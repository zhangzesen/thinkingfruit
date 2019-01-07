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
#info{
    background-color: #fff;
    margin-bottom: 0;
}
.aui-page-box{
    background-color: #fff;
        padding: 15px 0;
}
.aui-page-box p {
margin:0;
}
input{
outline:none;
}
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
                    <span class="aui-center-title">购买商品</span>
                </div>
            </header>
		<section class="aui-scrollView">
			<section class="aui-content">
			<div class="aui-card-list">
			<div class="goods">
				
			</div>
			<div class="aui-card-list-footer">
			<div style="width:100%">
				<div><h5>价格：<i>¥</i><i id="price">0</i></h5></div>
				<div><h5>数量：<input placeholder="输入数量"id="count"></input></h5></div>
				<div><h5>总价：<i>¥</i><i id="priceTall">0</i></h5></div>
				<div>
				<h5 style="width:40%;position: absolute;bottom:0">点击上传交易凭证</h5>
				<input id="uploadImage" placeholder="请点击" name="uploadImage" type="file" autocomplete="off" style="opacity: 0;float: right;width: 100%;" value=""></input>
				</div>
			</div>
			</div>	
				<div><img id="certificateImage" alt="" src=""></div>
			</section>
			
				
				
				</div>
				<div class="aui-login-line" id="info">
                    <h2>商品详情</h2>
                </div>
                <div class="aui-page-box">
                <div class="descriptionImg"></div>
                     <p id="description"style="text-align: center; margin-top: 2%;">致力于打造更好的产品为更好的你</p>
                </div>
		</section>
		<footer class="aui-footer aui-footer-fixed">
			<a href="javascript:;" class="aui-tabBar-item aui-tabBar-item-active">
            	<span class="aui-tabBar-item-icon">
                	<i class="icon icon-home"></i>
                </span>
                <span class="aui-tabBar-item-text" id="home">首页</span>
            </a>
            <button class="aui-button-btn" id="purchase" type="file">
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