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
 #my{
   margin-bottom:-1px;}
   #news{
   margin-bottom:-1px;}
</style>
</head>
<body>

	<section class="aui-flexView">
		<header class="aui-bar aui-bar-nav aui-bar-light" style="color: black;">
    <div class="aui-title">个人中心</div>
</header>
		<section class="aui-scrollView">
			<div class="aui-member-head">
				<div class="aui-member-user">
					<img id="balance" src="<%=basePath%>/static/plugin/aui/images/gril.jpg" alt="">
				</div>
				<div class="aui-member-text" id="head">
				</div>
			</div>
			
			<div class="divHeight"></div>
			<div class="aui-course-list">
				<a href="<%=basePath%>/purchaseOrder" class="aui-flex b-line">
					<div class="aui-course-icon">
						<img src="<%=basePath%>/static/images/icon/4.png" alt="">
					</div>
					<div class="aui-flex-box">
						<h5>我的订单</h5>
					</div>
				</a> 
				<div class="divHeight"></div>
				<a href="<%=basePath%>/my/address" class="aui-flex b-line">
					<div class="aui-course-icon">
						<img src="<%=basePath%>/static/images/icon/1.png" alt="">
					</div>
					<div class="aui-flex-box">
						<h5>收货地址</h5>
					</div>
				</a> <a href="<%=basePath%>/my/information" class="aui-flex b-line">
					<div class="aui-course-icon">
						<img src="<%=basePath%>/static/images/icon/5.png" alt="">
					</div>
					<div class="aui-flex-box">
						<h5>完善信息</h5>
					</div>
				</a> <a href="<%=basePath%>/my/upgrade" class="aui-flex">
					<div class="aui-course-icon">
						<img src="<%=basePath%>/static/images/icon/6.png" alt="">
					</div>
					<div class="aui-flex-box">
						<h5>升级</h5>
					</div>
				</a>
				<div class="divHeight"></div>
				<a href="<%=basePath%>/agent/team" class="aui-flex b-line">
					<div class="aui-course-icon">
						<img src="<%=basePath%>/static/images/icon/8.png" alt="">
					</div>
					<div class="aui-flex-box">
						<h5>我的团队</h5>
					</div>

				</a>
				<div class="divHeight"></div>
				<a href="<%=basePath%>/commision" class="aui-flex b-line">
					<div class="aui-course-icon">
						<img src="<%=basePath%>/static/images/icon/2.png" alt="">
					</div>
					<div class="aui-flex-box">
						<h5>佣金详情</h5>
					</div>

				</a> <a href="<%=basePath%>/cash" class="aui-flex b-line">
					<div class="aui-course-icon">
						<img src="<%=basePath%>/static/images/icon/9.png" alt="">
					</div>
					<div class="aui-flex-box">
						<h5>提现</h5>
					</div>
					<a href="<%=basePath%>/cash/cashList" class="aui-flex b-line">
					<div class="aui-course-icon">
						<img src="<%=basePath%>/static/images/icon/7.png" alt="">
					</div>
					<div class="aui-flex-box">
						<h5>提现记录</h5>
					</div>
				</a><a href="<%=basePath%>/order/depot" class="aui-flex b-line">
					<div class="aui-course-icon">
						<img src="<%=basePath%>/static/images/icon/10.png" alt="">
					</div>
					<div class="aui-flex-box">
						<h5>云仓库</h5>
					</div>

				</a>
				<div class="divHeight"></div>
				<div id="invite" class="aui-flex b-line">
					<div class="aui-course-icon">
						<img src="<%=basePath%>/static/images/icon/3.png" alt="">
					</div>
					<div class="aui-flex-box">
						<h5>邀请好友</h5>
					</div>
				</div>
                    <img src="" alt="" id="shareDiv">
                    
	
				<div class="divHeight"></div>
					<div class="aui-flex-box" style="text-align: center;" id="loginOut">
						<h5 style="color: #ff3366;">用户退出</h5>
					</div>

			</div>



		</section>
		<footer class="aui-footer aui-footer-fixed">
			<div id="home" class="aui-tabBar-item "> <span
				class="aui-tabBar-item-icon"> <i class="icon icon-home"></i>
			</span> <span class="aui-tabBar-item-text">首页</span> </div>
			<div id="news" class="aui-tabBar-item "> <span
				class="aui-tabBar-item-icon"> <i class="icon icon-collage"></i>
			</span> <span class="aui-tabBar-item-text">文章</span> </div>
			<div id="my" class="aui-tabBar-item aui-tabBar-item-active">
			<span class="aui-tabBar-item-icon"> <i class="icon icon-my"></i>
			</span> <span class="aui-tabBar-item-text">我的</span> </span> </div>
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
	<script>memberId="<%=session.getAttribute("agentId")%>"</script>
	<script type="text/javascript"
		src="<%=basePath%>/static/plugin/layui/layui.all.js"></script>
</body>
</html>