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
			<li class="layui-this">用户详情</li>
			<div class="main-tab-item">用户：${user.loginName}</div>
			<li><a href="<%=%>/user">用户列表</a></li>
		</ul>
		<div class="layui-tab-content">
			<div class="layui-tab-item layui-show">
				<div class="layui-form-item">
					<label class="layui-form-label">用户名</label>
					<div class="layui-input-inline input-custom-width">
						<input type="text" name="loginName" value="${user.loginName}"
							lay-verify="required" autocomplete="off" readonly="readonly"
							class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">联系方式</label>
					<div class="layui-input-inline input-custom-width">
						<input type="text" name="mobile" value="${user.mobile}"
							lay-verify="required" autocomplete="off" readonly="readonly"
							class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">邮箱</label>
					<div class="layui-input-inline input-custom-width">
						<input type="text" name="email" value="${user.email}"
							lay-verify="required" autocomplete="off" readonly="readonly"
							class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">性别</label>
					<div class="layui-input-inline input-custom-width">
						<input type="text" name="sex"
							value="<c:if test="${user.sex==0}">男</c:if><c:if test="${user.sex==1}">女</c:if>"
							lay-verify="required" autocomplete="off" readonly="readonly"
							class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">地址</label>
					<div class="layui-input-inline input-custom-width">
						<input type="text" name="address"
							value="${user.provName}${user.cityName}${user.townName}"
							lay-verify="required" autocomplete="off" readonly="readonly"
							class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">状态</label>
					<div class="layui-input-inline input-custom-width">
						<input type="text" name="status"
							value="<c:if test="${user.status==0}">禁用</c:if><c:if test="${user.status==1}">启用</c:if>"
							lay-verify="required" autocomplete="off" readonly="readonly"
							class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">创建时间</label>
					<div class="layui-input-inline input-custom-width">
						<input type="text" name="createTime"
							value="<fmt:formatDate value="${user.createTime}"
										pattern="YYYY-MM-dd HH:mm:ss" />"
							lay-verify="required" autocomplete="off" readonly="readonly"
							class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">最后登录时间</label>
					<div class="layui-input-inline input-custom-width">
						<input type="text" name="lastTime"
							value="<fmt:formatDate value="${user.lastTime}"
										pattern="YYYY-MM-dd HH:mm:ss" />"
							lay-verify="required" autocomplete="off" readonly="readonly"
							class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">角色</label>
					<div class="layui-input-inline input-custom-width">
						<input type="text" name="roleName" value="${user.roleName}"
							lay-verify="required" autocomplete="off" readonly="readonly"
							class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">拥有权限</label>

					<div class="layui-input-inline input-custom-width">
						<input type="text" name="userPermissions"
							value="<c:forEach items="${userPermissions}" var="userPermission">${userPermission.userPermissionName}|</c:forEach>"
							lay-verify="required" autocomplete="off" readonly="readonly"
							class="layui-input">
					</div>


				</div>
				<c:if test="${loginMine}">
						<a class="layui-btn" lay-submit="" lay-filter="user-password"
							href="<%=%>/user/editPassword?id=${user.id}" title="修改密码"
							style="margin-left: 50px;">修改密码</a>
					<a href="<%=%>/user/edit?id=${user.id}"
						class="layui-btn layui-btn-small" title="编辑">编辑</a>
				</c:if>

			</div>
		</div>
	</div>
<%-- 	<jsp:include page="/context/js-tags.jsp" /> --%>
</body>
</html>