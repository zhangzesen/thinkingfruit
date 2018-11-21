<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/context/begin-tags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/context/css-tags.jsp" />
</head>
<body>
	<div class="layui-tab layui-tab-brief main-tab-container"
		style="margin-top: 20px">
		<ul class="layui-tab-title main-tab-title">
			<li class="layui-this">用户详情</li>
			<div class="main-tab-item layui-bg-blue">用户：<shiro:principal property="loginName"/></div>
			<li><a href="<%=basePath%>/user">用户列表</a></li>
		</ul>
		<div class="layui-tab-content">
			<div class="layui-tab-item layui-show">
				<div class="layui-form-item">
					<label class="layui-form-label">用户名</label>
					<div class="layui-input-inline input-custom-width">
						<input type="text" name="loginName" value=""
							lay-verify="required" autocomplete="off" readonly="readonly"
							class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">联系方式</label>
					<div class="layui-input-inline input-custom-width">
						<input type="text" name="mobile" value=""
							lay-verify="required" autocomplete="off" readonly="readonly"
							class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">邮箱</label>
					<div class="layui-input-inline input-custom-width">
						<input type="text" name="email" value=""
							lay-verify="required" autocomplete="off" readonly="readonly"
							class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">性别</label>
					<div class="layui-input-inline input-custom-width">
						<input type="text" name="sex"
							value=""
							lay-verify="required" autocomplete="off" readonly="readonly"
							class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">地址</label>
					<div class="layui-input-inline input-custom-width">
						<input type="text" name="address"
							value=""
							lay-verify="required" autocomplete="off" readonly="readonly"
							class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">状态</label>
					<div class="layui-input-inline input-custom-width">
						<input type="text" name="status"
							value=""
							lay-verify="required" autocomplete="off" readonly="readonly"
							class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">创建时间</label>
					<div class="layui-input-inline input-custom-width">
						<input type="text" name="createTime"
							value=""
							lay-verify="required" autocomplete="off" readonly="readonly"
							class="layui-input">
					</div>
				</div>
				<!-- <div class="layui-form-item">
					<label class="layui-form-label">最后登录时间</label>
					<div class="layui-input-inline input-custom-width">
						<input type="text" name="lastTime"
							value=""
							lay-verify="required" autocomplete="off" readonly="readonly"
							class="layui-input">
					</div>
				</div> -->
				<div class="layui-form-item">
					<label class="layui-form-label">角色</label>
					<div class="layui-input-inline input-custom-width">
						<input type="text" name="roleName" value=""
							lay-verify="required" autocomplete="off" readonly="readonly"
							class="layui-input">
					</div>
				</div>
				<%-- <div class="layui-form-item">
					<label class="layui-form-label">拥有权限</label>
					<div class="layui-input-inline input-custom-width">
						<input type="text" name="userPermissions"
							value="<c:forEach items="${userPermissions}" var="userPermission">${userPermission.userPermissionName}|</c:forEach>"
							lay-verify="required" autocomplete="off" readonly="readonly"
							class="layui-input">
					</div>
				</div> --%>
				<a class="layui-btn" lay-submit="" lay-filter="user-password"
					href="<%=basePath%>/user/password" title="修改密码"
					style="margin-left: 50px;">修改密码</a>

			</div>
		</div>
	</div>
	<jsp:include page="/context/js-tags.jsp" />
	<script type="text/javascript"
		src="<%=basePath%>/static/js/user/information.js"></script>
</body>
</html>