<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/context/begin-tags.jsp"%>
<!DOCTYPE html">
<html>
<head>
<jsp:include page="/context/css-tags.jsp" />
<style type="text/css">
.error {
	color: red;
}

input {
	color: #666 !important;
}
</style>
</head>
<body>
	<div class="layui-tab layui-tab-brief main-tab-container">
		<div class="layui-tab-content">
			<div class="layui-tab layui-tab-card">
				<div class="layui-form" style="margin-top: 10px;">

					<div class="layui-form-item">
						<label class="layui-form-label"> 密码 </label>
						<div class="layui-input-inline">
							<input type="password" name="pswd" required=""
								autocomplete="off" class="layui-input">
						</div>
						<div class="layui-form-mid layui-word-aux">6到16个字符</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label"> 确认密码 </label>
						<div class="layui-input-inline">
							<input type="password" name="surePswd" required=""
								autocomplete="off" class="layui-input">
						</div>
					</div>
					<input name="id" value="" hidden="hidden">

					<div class="layui-form-item" style="margin-left: 100px;">
						<div class="layui-input-block" id="btn">
							<button class="layui-btn" lay-submit="" lay-filter="cate_add">立即修改</button>
						</div>
					</div>

					<br> <br> <br>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/context/js-tags.jsp" />
	<script type="text/javascript"
		src="<%=basePath%>/static/plugin/jquery-validation/jquery.validate.min.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>/static/plugin/jquery-validation/localization/messages_zh.min.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>/static/plugin/jquery-validation/additional-methods.min.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>/static/js/member/set.js"></script>
</body>
</html>