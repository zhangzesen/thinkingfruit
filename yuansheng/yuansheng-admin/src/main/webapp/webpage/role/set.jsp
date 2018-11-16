<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@ include file="/context/begin-tags.jsp"%> --%>
<!DOCTYPE html>
<html>
<head>
<%-- <jsp:include page="/context/css-tags.jsp" /> --%>
</head>
<body>
	<div style="margin-top: 20px"
		class="layui-tab-brief main-tab-container">
		<ul class="layui-tab-title main-tab-title">
			<li><a href="<%=%>/role">角色列表</a></li>
			<c:if test="${userRole == null}">
				<li class="layui-this">添加角色</li>
			</c:if>
			<c:if test="${userRole != null}">
				<li class="layui-this">修改角色</li>
			</c:if>
			<div class="main-tab-item">角色管理</div>
		</ul>
		<div class="layui-tab-content">
			<div class="layui-tab-item layui-show">
				<div class="layui-tab layui-tab-card">
					<ul class="layui-tab-title">
						<c:if test="${userRole == null}">
							<li class="layui-this">添加角色</li>
						</c:if>
						<c:if test="${userRole != null}">
							<li class="layui-this">修改角色</li>
						</c:if>
					</ul>
					<div class="layui-tab-content">
						<div class="layui-tab-item layui-show">
							<div class="layui-form-item">
								<label class="layui-form-label">角色名称</label>
								<div class="layui-input-inline input-custom-width">
									<input type="text" name="userRoleName"
										<c:if test="${userRole != null}"> value="${userRole.userRoleName}" </c:if>
										lay-verify="required" autocomplete="off" placeholder="请输入角色名称"
										class="layui-input">
								</div>
							</div>
							<c:if test="${userRole != null}">
								<input name="id" value="${userRole.id}" hidden="hidden">
							</c:if>

							<div class="layui-form-item">
								<label class="layui-form-label">角色描述</label>
								<div class="layui-input-inline input-custom-width">
									<%-- <input value="${userRole.userRoleDescription}"> --%>
									<textarea name="userRoleDescription" lay-verify=""
										autocomplete="off" placeholder="请输入角色描述"
										class="layui-textarea"><c:if
											test="${userRole != null}">${userRole.userRoleDescription}</c:if></textarea>
								</div>
							</div>

							<div class="layui-form-item">
								<label class="layui-form-label">角色授权</label>
								<div class="layui-input-inline input-custom-width">
									<div id="permissionTree" class="grid"></div>
								</div>
							</div>
						</div>
						<div class="layui-form-item">
							<div class="layui-input-block">
								<c:if test="${userRole == null}">
									<button class="layui-btn" lay-submit="" lay-filter="">立即添加</button>
								</c:if>
								<c:if test="${userRole != null}">
									<button class="layui-btn" lay-submit="" lay-filter="">立即修改</button>
								</c:if>

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
<%-- 	<jsp:include page="/context/js-tags.jsp" /> --%>
	<script src="<%=%>/plug-in/layui/layui.js" charset="utf-8"></script>
	<script type="text/javascript"
		src="<%=%>/plug-in/js/role/set.js"></script>
</body>
</html>

