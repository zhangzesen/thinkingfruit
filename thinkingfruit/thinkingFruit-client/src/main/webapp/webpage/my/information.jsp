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
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>/static/plugin/aui/css/aui.css" />
<style type="text/css">
.aui-list-item {
	width: 100%;
	float: none;
}

input {
	text-align: right;
}

#head {
	width: 15%;
	float: left;
}

button {
	height: 90%;
}

.aui-add-box {
	margin-top: -4%;
}
img{
    position: absolute;
    top: 50%;
    left: 50%;
    margin-top: -15px;
    margin-left: -25px;
}

</style>
</head>
<body>


	<section class="aui-flexView">
		<header class="aui-navBar aui-navBar-fixed"
			style="background-color: #fff;">
			<a href="javascript:history.back(-1)" class="aui-navBar-item"> <i
				class="icon icon-return"></i>
			</a>
			<div class="aui-center">
				<span class="aui-center-title">完善信息</span>
			</div>
			<a href="javascript:;" class="aui-navBar-item"> <i
				class="icon icon-sys"></i>
			</a>
		</header>
		<section class="aui-scrollView">
		<div class="aui-content aui-margin-b-15">
		<ul class="aui-list aui-form-list">
			<li class="aui-list-item">
			<div class="aui-list-item-inner">
			<div class="aui-list-item-label">头像</div>
			<div class="layui-form-item" style="min-height: 2.2rem;">
			<div class="layui-input-inline input-custom-width layui-upload" style="min-height: 2.2rem;max-height: 2.2rem;">
			<div class="aui-list-item-input">
				<input id="uploadImage" name="uploadImage" class="layui-input image-upload" type="file" autocomplete="off" style="width: 120%;opacity: 0;float: left;margin-left: -17%;">
			</div>
			<div class="aui-flex-arrow" style="width:14%;margin-left:83%;min-height: 2.2rem;">
				<img alt=" " border="none" name="avatar" src="<%=basePath%>/static/plugin/aui/images/gril.jpg" width="70px" height="40px">
			</div>
			</div>
			</div>
			</div>
			</li>			
			
					<li class="aui-list-item">
						<div class="aui-list-item-inner">
							<div class="aui-list-item-label">代理id</div>
							<div class="aui-list-item-input">
								<input id="id" type="text" readonly="readonly">
							</div>
						</div>
					</li>
					<li class="aui-list-item">
						<div class="aui-list-item-inner">
							<div class="aui-list-item-label">登录名</div>
							<div class="aui-list-item-input">
								<input id="loginName" type="text" readonly="readonly">
							</div>
						</div>
					</li>
					<li class="aui-list-item">
						<div class="aui-list-item-inner">
							<div class="aui-list-item-label">性别</div>
							<div class="aui-list-item-input" style="text-align: right;">
								<label><input class="aui-radio" type="radio" name="sex" value="1" checked>男</label>
                                <label><input class="aui-radio" type="radio" name="sex" value="0"> 女</label>
							</div>
						</div>
					</li>
					<li class="aui-list-item">
						<div class="aui-list-item-inner">
							<div class="aui-list-item-label">手机号</div>
							<div class="aui-list-item-input">
								<input id="mobile" type="text" placeholder="请输入手机号">
							</div>
						</div>
					</li>
					<li class="aui-list-item">
						<div class="aui-list-item-inner">
							<div class="aui-list-item-label">真实姓名</div>
							<div class="aui-list-item-input">
								<input id="name" type="text" placeholder="请输入真实姓名">
							</div>
						</div>
					</li>
					<li class="aui-list-item">
						<div class="aui-list-item-inner">
							<div class="aui-list-item-label">邀请者id</div>
							<div class="aui-list-item-input">
								<input id="inviterId" type="text" readonly="readonly">
							</div>
						</div>
					</li>
					<li class="aui-list-item">
						<div class="aui-list-item-inner">
							<div class="aui-list-item-label">邀请者上级id</div>
							<div class="aui-list-item-input">
								<input id="inviterUpperId" type="text" readonly="readonly">
							</div>
						</div>
					</li>
					<li class="aui-list-item">
						<div class="aui-list-item-inner">
							<div class="aui-list-item-label">身份证号</div>
							<div class="aui-list-item-input">
								<input id="identityNo" type="text" placeholder="请输入身份证号">
							</div>
						</div>
					</li>
					<li class="aui-list-item">
						<div class="aui-list-item-inner">
							<div class="aui-list-item-label">代理级别</div>
							<div class="aui-list-item-input" style="width: auto; margin: 0;">
								<select id="memberLevelId" disabled="disabled">
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


			<div class="aui-add-box" id="update">
				<button>保存修改</button>
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
	<script>WEB_ROOT_ADMIN="<%=admin%>"</script>
	<script type="text/javascript"
		src="<%=basePath%>/static/plugin/layui/layui.all.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>/static/js/common/common.js"></script>

</body>
</html>