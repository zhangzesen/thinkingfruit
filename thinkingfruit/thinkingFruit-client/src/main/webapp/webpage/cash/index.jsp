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
.aui-list-item {
width:100%;
float:none;
}
#head{
    width: 15%;
    float: left;}
       button{
 height:90%;
 }
 .aui-add-box{
     margin-top: -4%;
 }
 input{
     text-align: center;
 }
 h4{height:40px;line-height:40px;text-indent:10px;color:#bbb;font-size:16px;}
 p{height:80px;line-height:60px;text-align:center;color:#666;font-size:24px;}
</style>
</head>
<body>
        <section class="aui-flexView">
            <header class="aui-bar aui-bar-nav aui-bar-light" style="color: black;">
                <a id="head" href="javascript:history.back(-1)" class="aui-navBar-item">
                    <i class="icon icon-return"></i>
                </a>
                <div class="aui-center">
                    <span class="aui-center-title">提现</span>
                </div>
            </header>
            <section class="aui-scrollView">
            <div style="background:#fff;margin-bottom:10px" id="balance">
	    	</div>
            <div class="aui-content aui-margin-b-15">
        <ul class="aui-list aui-form-list">
            <li class="aui-list-item">
                <div class="aui-list-item-inner">
                    <div class="aui-list-item-label">
                        	提现金额
                    </div>
                    <div class="aui-list-item-input">
                        <input type="text" id="cash" placeholder="请输入提现金额">
                    </div>
                </div>
            </li>
            <li class="aui-list-item">
                <div class="aui-list-item-inner">
                    <div class="aui-list-item-label">
                        	开户银行
                    </div>
                    <div class="aui-list-item-input">
                        <input type="text" id="openBank" placeholder="请输入开户银行">
                    </div>
                </div>
            </li>
            <li class="aui-list-item">
                <div class="aui-list-item-inner">
                    <div class="aui-list-item-label">
                        	银行卡号
                    </div>
                    <div class="aui-list-item-input">
                        <input type="text" id="bankNumber" placeholder="请输入银行卡号">
                    </div>
                </div>
            </li>
            <li class="aui-list-item">
                <div class="aui-list-item-inner">
                    <div class="aui-list-item-label">
                        	备注
                    </div>
                    <div class="aui-list-item-input">
                        <input type="text" id="account" placeholder="备注">
                    </div>
                </div>
            </li>
            </ul>
            </div>
                    
                <div class="aui-add-box" id="withdrawal">
                    <button>确认提现</button>
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
		src="<%=basePath%>/static/js/cash/index.js"></script>
		<script type="text/javascript"
		src="<%=basePath%>/static/js/common/common.js"></script>
		<script type="text/javascript"
		src="<%=basePath%>/static/plugin/layui/layui.all.js"></script>
	<script>WEB_ROOT="<%=basePath%>"
	</script>
</body>
</html>