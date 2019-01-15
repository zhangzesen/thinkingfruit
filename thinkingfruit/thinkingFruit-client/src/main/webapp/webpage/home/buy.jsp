<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/context/begin-tags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品购买</title>
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
   #qty_item_1{
        height: 27px;
    width: 50px;
    }
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
		<section class="aui-scrollView" style="margin-top:1px;">
		<section class="aui-content">
			<div class="aui-card-list">
			<div class="goods">
			</div>
		<div class="p_number">
		<div style="height:36px;font-size:16px;">商品单价:￥<strong id="price_item_1">350.00</strong></div>
		<div class="f_l add_chose">
			<a class="reduce" onClick="setAmount.reduce('#qty_item_1')" href="javascript:void(0)">
			-</a>
			<input type="text" name="qty_item_1" value="1" id="qty_item_1" onKeyUp="setAmount.modify('#qty_item_1')" class="text" />
			<a class="add" onClick="setAmount.add('#qty_item_1')" href="javascript:void(0)">
			+</a>
		</div>
		<div class="f_l buy">
			总价：￥<span class="total-font" id="total_item_1">89.00</span>
			<input type="hidden" name="total_price" id="total_price" value="" onkeyup="value=value.replace(/[^\d]/g,'') " ng-pattern="/[^a-zA-Z]/"/>
		</div>
	</div>
	    <div class="aui-card-list-footer" style="width:100%;">
			<div style="width:100%">
				<div>
				<h5 style="width:100%;position: absolute;bottom:0;text-align: center;">点击上传交易凭证</h5>
				<input id="uploadImage" placeholder="请点击" name="uploadImage" type="file" autocomplete="off" style="opacity: 0;float: right;width: 100%;" value=""></input>
				</div>
			</div>
			</div>	
				<div><img id="certificateImage" alt="" src=""></div>
			</div>
		</section>
		</section>
		<footer class="aui-footer aui-footer-fixed">
            <button class="aui-button-btn" id="purchase" type="file"  style="margin:auto">
                                                           确认购买
            </button>
		</footer>
	</section>
	<jsp:include page="/context/js-tags.jsp" />
	<script type="text/javascript"
		src="<%=basePath%>/static/plugin/themes/jquery.min.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>/static/plugin/themes/slider.js"></script>
		<script type="text/javascript"
		src="<%=basePath%>/static/plugin/themes/payfor.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>/static/plugin/themes/tab.js"></script>
		<script type="text/javascript"
		src="<%=basePath%>/static/js/home/buy.js"></script>
<script>WEB_ROOT="<%=basePath%>"</script>
</body>
</html>