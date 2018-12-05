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
</style>
</head>
<body>
        <section class="aui-flexView">
            <header class="aui-bar aui-bar-nav aui-bar-light" style="color: black;">
                <a id="head" href="javascript:history.back(-1)" class="aui-navBar-item">
                    <i class="icon icon-return"></i>
                </a>
                <div class="aui-center">
                    <span class="aui-center-title">佣金信息</span>
                </div>
            </header>
            <section class="aui-scrollView">
                <div class="aui-tab" data-ydui-tab>
                    <ul class="tab-nav b-line">
                        <li class="tab-nav-item tab-active">
                            <a href="javascript:;">
                                <span>全部</span>
                            </a>
                        </li>
                        <li class="tab-nav-item">
                            <a href="javascript:;">
                                <span>邀请金</span>
                            </a>
                        </li>
                        <li class="tab-nav-item">
                            <a href="javascript:;">
                                <span>佣金</span>
                            </a>
                        </li>
                    </ul>
                    <div class="tab-panel tab-panel-clear-line">
                        <div class="tab-panel-item tab-active">
                            <a href="javascript:;" class="aui-order-list">
                                <div class="aui-flex">
                                    <div class="aui-flex-box">
                                        <h3>订单号:</h3></h3>001</h3>
                                    </div>
                                    
                                </div>
                                <div class="aui-flex aui-flex-order">
                                    <div class="aui-order-img">
                                        <img src="<%=basePath%>/static/images/banner/shili1.jpg" alt="">
                                    </div>
                                    <div class="aui-flex-box">
                                        <h2>商品1</h2>
                                        <h4>共 <i>1</i>佣金<em>￥9.9</em></h4>
                                    </div>
                                </div>
                            </a>
                            <a href="javascript:;" class="aui-order-list">
                                <div class="aui-flex">
                                    <div class="aui-flex-box">
                                        <h3>订单号:</h3></h3>001</h3>
                                    </div>
                                </div>
                                <div class="aui-flex aui-flex-order">
                                    <div class="aui-order-img">
                                        <img src="<%=basePath%>/static/images/banner/shili1.jpg" alt="">
                                    </div>
                                    <div class="aui-flex-box">
                                        <h2>商品1</h2>
                                        <h4>共 <i>1</i>佣金<em>￥9.9</em></h4>
                                    </div>
                                </div>
                            </a>
                            <a href="javascript:;" class="aui-order-list">
                                <div class="aui-flex">
                                    <div class="aui-flex-box">
                                        <h3>订单号:</h3></h3>001</h3>
                                    </div>
                                    <div class="aui-order-pay">
                                        <p>邀请金</p>
                                    </div>
                                </div>
                                <div class="aui-flex aui-flex-order">
                                    <div class="aui-order-img">
                                        <img src="<%=basePath%>/static/images/banner/shili1.jpg" alt="">
                                    </div>
                                    <div class="aui-flex-box">
                                        <h2>商品1</h2>
                                        <h4>共 <i>1</i>邀请金<em>￥9.9</em></h4>
                                    </div>
                                </div>
                            </a>
                        </div>
                        <div class="tab-panel-item">
                        <a href="javascript:;" class="aui-order-list">
                                <div class="aui-flex">
                                    <div class="aui-flex-box">
                                        <h3>订单号:</h3></h3>001</h3>
                                    </div>
                                    <div class="aui-order-pay">
                                        <p>邀请金</p>
                                    </div>
                                </div>
                                <div class="aui-flex aui-flex-order">
                                    <div class="aui-order-img">
                                        <img src="<%=basePath%>/static/images/banner/shili1.jpg" alt="">
                                    </div>
                                    <div class="aui-flex-box">
                                        <h2>商品1</h2>
                                        <h4>共 <i>1</i>佣金<em>￥9.9</em></h4>
                                    </div>
                                </div>
                            </a>
                        </div>
                        <div class="tab-panel-item">
                        <a href="javascript:;" class="aui-order-list">
                                <div class="aui-flex">
                                    <div class="aui-flex-box">
                                        <h3>订单号:</h3></h3>001</h3>
                                    </div>
                                    
                                </div>
                                <div class="aui-flex aui-flex-order">
                                    <div class="aui-order-img">
                                        <img src="<%=basePath%>/static/images/banner/shili1.jpg" alt="">
                                    </div>
                                    <div class="aui-flex-box">
                                        <h2>商品1</h2>
                                        <h4>共 <i>1</i>邀请金<em>￥9.9</em></h4>
                                    </div>
                                </div>
                            </a>
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
		src="<%=basePath%>/static/js/my/information.js"></script>
	<script>WEB_ROOT="<%=basePath%>"
	</script>
</body>
</html>