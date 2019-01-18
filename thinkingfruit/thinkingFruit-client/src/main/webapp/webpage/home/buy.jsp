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
    }
    #btnHide{
        position: absolute;
    width: 100%;
    top: 0px;
    z-index: -1;
    }
    h5{
        color:#757575;
            margin-top: 5px;
    }
    h3{
        font-size: larger;
    }
    .head{
    width:100%;
    text-align: center;
    }
    em{
 
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
		<div style="height:36px;font-size:16px;color:#757575;">商品单价:￥<strong id="price_item_1">350.00</strong></div>
		<div class="f_l add_chose">
		<div class="aui-bar-btn-item1">
			<i class="aui-iconfont reduce aui-icon-minus" onClick="setAmount.reduce('#qty_item_1')"></i>
			</div>
			<div class="aui-bar-btn-item1" style="width:2%;">
			<input type="text" name="qty_item_1" value="1" id="qty_item_1" onKeyUp="setAmount.modify('#qty_item_1')" class="text" style="border:none;text-align: center;"/>
			</div>
			<div class="aui-bar-btn-item1">
			<i class="aui-iconfont add aui-icon-plus" onClick="setAmount.add('#qty_item_1')"></i>
	        </div>	
		</div>
		<div class="f_l buy" style="margin-left: 15%;color:#FF5722;">
			合计：￥<span class="total-font" id="total_item_1">89.00</span>
			<input type="hidden" name="total_price" id="total_price" value="" onkeyup="value=value.replace(/[^\d]/g,'') " ng-pattern="/[^a-zA-Z]/"/>
		</div>
	</div>
	    <div class="aui-card-list-footer" style="width:100%;border-top: 1px solid #e2e2e2;margin-top: 10px;display:block;">
		
			<div style="width:100%" class="aui-btn aui-btn-success aui-btn-block aui-btn-outlined">
				<h3 class="head">点击上传交易凭证<em>截图</em></h3>
				<input id="uploadImage" placeholder="请点击" name="uploadImage" type="file" autocomplete="off" style="opacity: 0;position: absolute;top: 0px;left: 0px;width: 100%;" value=""></input>
			</div>
			<div>
			<h5 class="head" style="">（注：苹果用户上传截图请<em>双击</em>选中图片）</h5>	
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
		src="<%=basePath%>/static/plugin/jquery/upload/compress.js"></script>
		<script type="text/javascript"
		src="<%=basePath%>/static/js/home/buy.js"></script>
<script>WEB_ROOT="<%=basePath%>"</script>
</body>
</html>