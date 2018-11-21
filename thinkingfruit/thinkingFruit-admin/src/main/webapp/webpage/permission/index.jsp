<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/context/begin-tags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/context/css-tags.jsp" />
<style type="text/css">
	.laytable-cell-1-5 {
		height: auto;
	}
	
	body {
		overflow-y: scroll;
	}
</style>
</head>
<body>
	<div style="margin-top: 20px"
		class="layui-tab layui-tab-brief main-tab-container">
		<ul class="layui-tab-title main-tab-title">
			<li class="layui-this">权限列表</li>
			<shiro:hasPermission name="permission:edit">
				<li><a href="<%=basePath%>/permission/set">添加权限</a></li>
			</shiro:hasPermission>
			<div class="main-tab-item layui-bg-blue">权限管理</div>
		</ul>
		<div class="layui-tab-content">
			<div class="layui-form xbs" align="center">
				<div class="layui-form-pane">
					<div class="layui-form-item" style="display: inline-block;">
						<label class="layui-form-label xbs768">搜索栏</label>
						<div class="layui-input-inline xbs768">
								<input type="text" name="permissionName"
									value="" placeholder="权限名称" autocomplete="off" class="layui-input">
						</div>
						
						<div class="layui-input-inline xbs768">
								<input type="text" name="permissionUrl"
									value="" placeholder="权限url" autocomplete="off" class="layui-input">
						</div>
						
						<div class="layui-input-inline xbs768" style="width: 80px">
							<button class="layui-btn btn-serach" lay-submit=""
								lay-filter="sreach">
								<i class="layui-icon">&#xe615;</i>
							</button>
						</div>
						<xblock>
							<button class="layui-btn layui-btn-warm btn-reset">
								<i class="layui-icon">&#x1002;</i>重置
							</button>
						</xblock>
					</div>
				</div>
			</div>
			<div class="layui-tab-item layui-show">
				<div id="dateTable" lay-filter="table-data"></div>
			</div>
		</div>
	</div>
	<jsp:include page="/context/js-tags.jsp" />
	<shiro:hasPermission name="permission:delete">
		<script id="barOption" type="text/html">
			{{#
				var barOption = "<a class='layui-btn layui-btn-small' title='编辑' lay-event='detail'><i class='layui-icon'>&#xe642;</i></a>";
				barOption+="<a class='layui-btn layui-btn-small layui-btn-danger del_btn' title='删除' lay-event='del' ><i class='layui-icon'>&#xe640;</i></a>";
				return barOption;
			}} 
		</script>
	</shiro:hasPermission>
	<script type="text/javascript"
		src="<%=basePath%>/static/js/permission/index.js"></script>
</body>
</html>