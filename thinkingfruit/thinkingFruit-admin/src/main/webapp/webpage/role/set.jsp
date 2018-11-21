<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/context/begin-tags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/context/css-tags.jsp" />
</head>
<body>
	<div style="margin-top: 20px"
		class="layui-tab-brief main-tab-container">
		<ul class="layui-tab-title main-tab-title">
			<li><a href="<%=basePath%>/role">角色列表</a></li>
			<li class="layui-this"><div class="add-edit">添加角色</div></li>
			<div class="main-tab-item layui-bg-blue">角色管理</div>
		</ul>
		<div class="layui-tab-content">
			<div class="layui-tab-item layui-show">
				<div class="layui-tab layui-tab-card">
					<ul class="layui-tab-title">
						<li class="layui-this add-edit">添加角色</li>
					</ul>
					<div class="layui-tab-content">
						<div class="layui-tab-item layui-show">
							<div class="layui-form-item">
								<label class="layui-form-label">角色名称</label>
								<div class="layui-input-inline input-custom-width">
									<input type="text" name="name"
										lay-verify="required" autocomplete="off" placeholder="请输入角色名称"
										class="layui-input">
								</div>
							</div>
							<input name="id" hidden="hidden">
							<div class="layui-form-item">
								<label class="layui-form-label">角色描述</label>
								<div class="layui-input-inline input-custom-width">
									<textarea name="description" lay-verify=""
										autocomplete="off" placeholder="请输入角色描述"
										class="layui-textarea"></textarea>
								</div>
							</div>

							<div class="layui-form-item">
								<label class="layui-form-label">角色授权</label>
								<div class="layui-input-inline input-custom-width">
									<div id="permissionTree" class="grid"></div>
								</div>
							</div>
						</div>
						<shiro:hasPermission name="role:edit">
							<div class="layui-form-item">
								<div class="layui-input-block">
									<button class="layui-btn" lay-submit="" lay-filter="">立即添加</button>
								</div>
							</div>
						</shiro:hasPermission>
					</div>
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
		src="<%=basePath%>/static/js/role/set.js"></script>
</body>
</html>

