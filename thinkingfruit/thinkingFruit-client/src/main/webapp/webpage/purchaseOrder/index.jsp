<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/context/begin-tags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="/context/js-tags.jsp" />
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
<style type="text/css">
.aui-list-item {
width:100%;
float:none;
}
input{
     text-align: center;
 }
 #head{
    width: 15%;
    float: left;}
    .time{
        text-align: left;
    }
    .tab-nav-item{width:25%;}
</style>
</head>
<body>
        <section class="aui-flexView">
            <header class="aui-bar aui-bar-nav aui-bar-light" style="color: black;">
                <a id="head" href="javascript:history.back(-1)" class="aui-navBar-item">
                    <i class="icon icon-return"></i>
                </a>
                <div class="aui-center">
                    <span class="aui-center-title">订单信息</span>
                </div>
            </header>
            <section class="aui-scrollView">
                <div class="aui-tab" data-ydui-tab>
                    <ul class="tab-nav b-line">
                        <li class="tab-nav-item">
                            <a href="javascript:;">
                                <span>待上级确认</span>
                            </a>
                        </li>
                        <li class="tab-nav-item">
                            <a href="javascript:;">
                                <span>上级已确认</span>
                            </a>
                        </li>
                        <li class="tab-nav-item">
                            <a href="javascript:;">
                                <span>下级需求</span>
                            </a>
                        </li>
                        <li class="tab-nav-item">
                            <a href="javascript:;">
                                <span>我已确认</span>
                            </a>
                        </li>
                    </ul>
                    <div class="tab-panel tab-panel-clear-line">
                        <div class="tab-panel-item tab-active" id="tab1">
                            <div class="aui-order-list">
                                <div class="aui-flex">
                                    <div class="aui-flex-box">
                                        <h3>待上级确认订单 </h3>
                                    </div>
                                </div>
                                <div class="aui-flex aui-flex-order">
                                    <div class="aui-order-img">
                                        <img src="<%=basePath%>/static/images/banner/shili1.jpg" alt="">
                                    </div>
                                    <div class="aui-flex-box">
                                        <h2>商品1</h2>
                                        <h4>共 <i>1</i> 件商品 需付款 <em>￥9.9</em></h4>
                                    </div>
                                </div>
                                <div class="aui-flex aui-flex-button">
                                <div class="aui-flex-box time">
                                        <h3>购买时间</h3>
                                    </div>
                                    <div class="aui-flex-box">
                                        <button class="aui-order-cancel">取消订单</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="tab-panel-item" id="tab2">
                            <div class="aui-order-list">
                                <div class="aui-flex">
                                    <div class="aui-flex-box">
                                        <h3>上级已确认订单</h3>
                                    </div>
                                </div>
                                <div class="aui-flex aui-flex-order">
                                    <div class="aui-order-img">
                                        <img src="<%=basePath%>/static/images/banner/shili1.jpg" alt="">
                                    </div>
                                    <div class="aui-flex-box">
                                        <h2>商品1</h2>
                                        <h4>共 <i>1</i> 件商品 需付款 <em>￥9.9</em></h4>
                                    </div>
                                </div>
                                <div class="aui-flex aui-flex-button">
                                 <div class="aui-flex-box time">
                                        <h3>确认时间</h3>
                                    </div>
                                    </div>
                            </div>
                        </div>
                        <div class="tab-panel-item" id="tab3">
                            <div class="aui-order-list">
                                <div class="aui-flex">
                                    <div class="aui-flex-box">
                                        <h4>下级申请购买订单</h4>
                                    </div>
                                </div>
                                <div class="aui-flex aui-flex-order">
                                    <div class="aui-order-img">
                                        <img src="<%=basePath%>/static/images/banner/shili1.jpg" alt="">
                                    </div>
                                    <div class="aui-flex-box">
                                        <h2>商品1</h2>
                                        <h4>共 <i>1</i> 件商品 需付款 <em>￥9.9</em></h4>
                                    </div>
                                </div>
                                <div class="aui-flex aui-flex-button">
                                <div class="aui-flex-box time">
                                        <h3>购买时间</h3>
                                    </div>
                                    <div class="aui-flex-box">
                                        <button>发货</button>
                                    </div>
                                </div>
                            </div>

                        </div>
                        <div class="tab-panel-item" id="tab4">
                            <div  class="aui-order-list">
                                <div class="aui-flex">
                                    <div class="aui-flex-box">
                                       <h4>已确认下级订单</h4>
                                    </div>
                                </div>
                                <div class="aui-flex aui-flex-order">
                                    <div class="aui-order-img">
                                        <img src="<%=basePath%>/static/images/banner/shili1.jpg" alt="">
                                    </div>
                                    <div class="aui-flex-box">
                                        <h2>商品1</h2>
                                        <h4>共 <i>1</i> 件商品 需付款 <em>￥9.9</em></h4>
                                    </div>
                                </div>
                                <div class="aui-flex aui-flex-button">
                                <div class="aui-flex-box time">
                                        <h3>确认时间</h3>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>


            </section>
        </section>
	<script type="text/javascript"
		src="<%=basePath%>/static/plugin/themes/jquery.min.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>/static/plugin/themes/slider.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>/static/plugin/themes/tab.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>/static/js/purchaseOrder/index.js"></script>
	<script>WEB_ROOT="<%=basePath%>"
	</script>
</body>
</html>