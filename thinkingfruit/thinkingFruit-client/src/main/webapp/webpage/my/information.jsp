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
            <header class="aui-navBar aui-navBar-fixed">
                <a href="javascript:history.back(-1)" class="aui-navBar-item">
                    <i class="icon icon-return"></i>
                </a>
                <div class="aui-center">
                    <span class="aui-center-title">完善信息</span>
                </div>
                <a href="javascript:;" class="aui-navBar-item">
                    <i class="icon icon-sys"></i>
                </a>
            </header>
            <section class="aui-scrollView">
                <div class="aui-user-set-box">
                    <a href="javascript:;" class="aui-flex b-line">
                        <div class="aui-flex-box">
                            <h5>修改头像</h5>
                        </div>
                        <div class="aui-flex-arrow">
                            <img id="avatar" src="themes/img/user/user-logo-003.png" alt="">
                        </div>
                    </a>
                    <ul class="aui-list aui-form-list">
            <div class="aui-content aui-margin-b-15">
        <ul class="aui-list aui-form-list">
        <li class="aui-list-item">
                <div class="aui-list-item-inner">
                    <div class="aui-list-item-label">
                       	 代理id
                    </div>
                    <div class="aui-list-item-input">
                        <input id="id" type="text" readonly="readonly">
                    </div>
                </div>
            </li>
            <li class="aui-list-item">
                <div class="aui-list-item-inner">
                    <div class="aui-list-item-label">
                       	 登录名
                    </div>
                    <div class="aui-list-item-input">
                        <input id="loginName" type="text" readonly="readonly">
                    </div>
                </div>
            </li>
            <li class="aui-list-item">
                <div class="aui-list-item-inner">
                    <div class="aui-list-item-label">
                       	 性别
                    </div>
                    <div class="aui-list-item-input">
                        <select id="gender" lay-filter="reportType">
							<option value="0">女</option>
							<option value="1">男</option>
						</select>
                    </div>
                </div>
            </li>
            <li class="aui-list-item">
                <div class="aui-list-item-inner">
                    <div class="aui-list-item-label">
                        	手机号
                    </div>
                    <div class="aui-list-item-input">
                        <input id="mobile" type="text" placeholder="请输入手机号">
                    </div>
                </div>
            </li>
            <li class="aui-list-item">
                <div class="aui-list-item-inner">
                    <div class="aui-list-item-label">
                        	真实姓名
                    </div>
                    <div class="aui-list-item-input">
                        <input id="name" type="text" placeholder="请输入真实姓名">
                    </div>
                </div>
            </li>
            <li class="aui-list-item">
                <div class="aui-list-item-inner">
                    <div class="aui-list-item-label">
                        	邀请者id
                    </div>
                    <div class="aui-list-item-input">
                        <input id="inviterId" type="text" readonly="readonly">
                    </div>
                </div>
            </li>
            <li class="aui-list-item">
                <div class="aui-list-item-inner">
                    <div class="aui-list-item-label">
                        	邀请者上级id
                    </div>
                    <div class="aui-list-item-input">
                        <input id="inviterUpperId" type="text" readonly="readonly">
                    </div>
                </div>
            </li>
            <li class="aui-list-item">
                <div class="aui-list-item-inner">
                    <div class="aui-list-item-label">
                       	 身份证号
                    </div>
                    <div class="aui-list-item-input">
                        <input id="identityNo" type="text" placeholder="请输入身份证号">
                    </div>
                </div>
            </li>
            <li class="aui-list-item">
                <div class="aui-list-item-inner">
                    <div class="aui-list-item-label">
                        	代理级别
                    </div>
                    <div class="aui-list-item-input">
                        <select id="memberLevelId" lay-filter="reportType" disabled="disabled">
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
                    <button>保存修改</button>
                </div>


            </section>
        </section>
		<footer class="aui-footer aui-footer-fixed">
			<button id="home" class="aui-tabBar-item "> <span
				class="aui-tabBar-item-icon"> <i class="icon icon-home"></i>
			</span> <span class="aui-tabBar-item-text">首页</span> </button>
			<button id="news" class="aui-tabBar-item "> <span
				class="aui-tabBar-item-icon"> <i class="icon icon-collage"></i>
			</span> <span class="aui-tabBar-item-text">文章</span> </button>
			<button id="my" class="aui-tabBar-item aui-tabBar-item-active">
			<span class="aui-tabBar-item-icon"> <i class="icon icon-my"></i>
			</span> <span class="aui-tabBar-item-text">我的</span></button>
		</footer>

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