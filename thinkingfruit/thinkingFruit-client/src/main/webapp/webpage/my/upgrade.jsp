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
input{
         text-align: right;
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
</style>
</head>
<body>

	
        <section class="aui-flexView">
            <header class="aui-navBar aui-navBar-fixed" style="background-color: #fff;">
                <a href="javascript:history.back(-1)" class="aui-navBar-item">
                    <i class="icon icon-return"></i>
                </a>
                <div class="aui-center">
                    <span class="aui-center-title">级别提升</span>
                </div>
                <a href="javascript:;" class="aui-navBar-item">
                    <i class="icon icon-sys"></i>
                </a>
            </header>
            <section class="aui-scrollView">
                <div class="aui-user-set-box">
            <div class="aui-content aui-margin-b-15">
        <ul class="aui-list aui-form-list">
        <li class="aui-list-item">
                <div class="aui-list-item-inner">
                    <div class="aui-list-item-label">
                        	代理级别
                    </div>
                    <div class="aui-list-item-input" style="width: auto;margin: 0;">
                        <select id="memberLevelId">
							<option value="1">联创</option>
							<option value="2">春事</option>
							<option value="3">总监</option>
							<option value="4">SVIP</option>
							<option value="5">VIP</option>
						</select>
                    </div>
                </div>
            </li>
            </ul>
            </div>
                    
                </div>
                <div class="aui-add-box" id="update">
                    <button>确认升级</button>
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
	<script>WEB_ROOT="<%=basePath%>"</script>
</body>
</html>