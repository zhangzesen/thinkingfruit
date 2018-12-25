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
                        </div>
                        <div class="tab-panel-item" id="tab2">
                        </div>
                        <div class="tab-panel-item" id="tab3">

                        </div>
                        <div class="tab-panel-item" id="tab4">

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
	<script>WEB_ROOT_ADMIN="<%=admin%>"</script>
</body>
</html>