<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/context/begin-tags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/context/css-tags.jsp" />
</head>
<body>
	<div style="margin-top: 20px" class="layui-tab-brief main-tab-container">
		<ul class="layui-tab-title main-tab-title">
			<li><a href="<%=basePath%>/permission">权限列表</a></li>
			<li class="layui-this"><div class="add-edit">添加权限</div></li>
			<div class="main-tab-item layui-bg-blue">权限管理</div>
		</ul>
		<div class="layui-tab-content">
			<div class="layui-tab-item layui-show">
				<div class="layui-tab layui-tab-card">
					<ul class="layui-tab-title">
						<li class="layui-this add-edit">添加权限</li>
					</ul>
					<div class="layui-tab-content">
						<div class="layui-tab-item layui-show">
							<div class="layui-form">
								<div class="layui-form-item">
									<label class="layui-form-label">上级权限</label>
									<div name="parentId" class="layui-input-inline input-custom-width">
										<select id="parentId" class="parentId" lay-filter="parentId" name="parentId" lay-verify="">
										</select>
									</div>
									<div class="layui-form-mid layui-word-aux"></div>
								</div>
								<input name="id" hidden="hidden">
								<div class="layui-form-item">
									<label class="layui-form-label">权限等级</label>
									<div class="layui-input-inline input-custom-width">
										<input type="text" name="level"
											lay-verify="" autocomplete="off" required="true" diyCheck="权限等级不能为空"
											placeholder="请输入权限等级" class="layui-input">
									</div>
								</div>

								<div class="layui-form-item">
									<label class="layui-form-label">权限名称</label>
									<div class="layui-input-inline input-custom-width">
										<input type="text" name="name"
											lay-verify="" autocomplete="off" required="true" diyCheck="权限名称不能为空"
											placeholder="请输入权限名称" class="layui-input">
									</div>
								</div>

								<div class="layui-form-item">
									<label class="layui-form-label">权限URL</label>
									<div class="layui-input-inline input-custom-width">
										<input type="text" name="url"
											lay-verify="" autocomplete="off" required="true" diyCheck="权限URL不能为空"
											placeholder="请输入权限URL" class="layui-input">
									</div>
								</div>

								<div class="layui-form-item">
									<label class="layui-form-label">权限连接</label>
									<div class="layui-input-inline input-custom-width">
										<input type="text" name="href"
											lay-verify="" autocomplete="off" required="true" diyCheck="权限链接不能为空"
											placeholder="请输入权限连接" class="layui-input">
									</div>
								</div>

								<div class="layui-form-item">
									<label class="layui-form-label">权限描述</label>
									<div class="layui-input-inline input-custom-width">
										<textarea name="description" lay-verify="" autocomplete="off"
										autocomplete="off" placeholder="请输入权限描述"
										class="layui-textarea"></textarea>
									</div>
								</div>

							</div>
							<shiro:hasPermission name="permission:edit">
								<div class="layui-form-item">
									<div class="layui-input-block">
										<button class="layui-btn" lay-submit="" lay-filter="cate_add">立即添加</button>
									</div>
								</div>
							</shiro:hasPermission>
						</div>
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
		src="<%=basePath%>/static/js/permission/set.js"></script>
</body>
</html>

