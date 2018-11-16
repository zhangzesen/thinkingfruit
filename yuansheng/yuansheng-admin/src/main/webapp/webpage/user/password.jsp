<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@ include file="/context/begin-tags.jsp"%> --%>
<!DOCTYPE html>
<html>
<head>
<%-- <jsp:include page="/context/css-tags.jsp" /> --%>
</head>
<body>
	<div class="layui-tab layui-tab-brief main-tab-container"
		style="margin-top: 20px">
		<ul class="layui-tab-title main-tab-title">
			<li class="layui-this">修改密码</li>
			<div class="main-tab-item">用户：${user.loginName}</div>
		</ul>
		<div class="layui-tab-content">
			<div class="layui-tab-item layui-show">
<%-- 			<input type="hidden" name="roleId" value="${currentUser.roleId}"> --%>
					<div class="layui-form-item">
						<label class="layui-form-label">旧密码</label>
						<div class="layui-input-inline input-custom-width">
							<input type="password" name="oldLoginPassword" value=""
								lay-verify="required" autocomplete="off" class="layui-input">
						</div>
					</div>
				<div class="layui-form-item">
					<label class="layui-form-label">新密码</label>
					<div class="layui-input-inline input-custom-width">
						<input type="password" name="newLoginPassword" value=""
							lay-verify="required" autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">确定密码</label>
					<div class="layui-input-inline input-custom-width">
						<input type="password" name="sureLoginPassword" value=""
							lay-verify="required" autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label"> </label> <input type="hidden"
						name="id" value="${user.id}">
					<button class="layui-btn btn-user-password-edit">修改</button>
				</div>
			</div>
		</div>
	</div>
<%-- 	<jsp:include page="/context/js-tags.jsp" /> --%>
	<script src="<%=%>/plug-in/js/user/password.js"></script>
</body>
</html>