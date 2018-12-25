<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/context/begin-tags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/context/css-tags.jsp" />
<style>
	.laytable-cell-1-imagePath {
		height: auto;
	}
	
	.laytable-cell-1-8 {
		height: auto;
	}
</style>
</head>
<body>
	<div style="margin-top: 20px" class="layui-tab layui-tab-brief main-tab-container">
		<ul class="layui-tab-title main-tab-title">
			<li class="layui-this"><a href="<%=basePath%>/user">用户列表</a></li>
				<shiro:hasPermission name="user:edit">
					<li><a href="<%=basePath%>/user/set">添加用户</a></li>
				</shiro:hasPermission>
			<div class="main-tab-item layui-bg-blue">用户管理</div>
		</ul>
		<div class="layui-tab-content">
			<div class="layui-form xbs" align="center">
				<div class="layui-form-pane">
					<div class="layui-form-item" style="display: inline-block;">
						<label class="layui-form-label xbs768">时间范围</label>
						<div class="layui-input-inline xbs768">
							<input type="text" readonly="readonly" class="layui-input"
								value="" placeholder="开始日"
								name="startTime">
						</div>
						<div class="layui-input-inline xbs768">
							<input type="text" readonly="readonly" class="layui-input"
								value="" placeholder="截止日" name="endTime">
						</div>
						<div class="layui-input-inline xbs768">
								<input type="text" name="nicknameStr"
									value="" placeholder="用户昵称" autocomplete="off" class="layui-input">
						</div>
						<div class="layui-input-inline xbs768">
								<input type="text" name="loginNameStr"
									value="" placeholder="登录名" autocomplete="off" class="layui-input">
						</div>
						<div class="layui-input-inline xbs768" style="width: 80px">
							<button class="layui-btn btn-serach" lay-submit=""
								lay-filter="sreach">
								<i class="layui-icon">&#xe615;</i>搜索
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
			<!-- 表格 -->
            <div id="dateTable" lay-filter="table-data"></div>
			
		</div>
	</div>
	<jsp:include page="/context/js-tags.jsp" />
	<shiro:hasPermission name="admin:pswd">
		<script id="barOption" type="text/html">
			{{#
				var barOption = "<a class='layui-btn layui-btn-small' title='编辑' lay-event='detail'><i class='layui-icon'>&#xe642;</i></a>";
				barOption+="<a class='layui-btn layui-btn-small layui-btn-danger del_btn' title='删除' lay-event='del' ><i class='layui-icon'>&#xe640;</i></a>";
				barOption+="<a class='layui-btn layui-btn-small layui-btn-normal' title='密码修改' lay-event='editPswd' ><i class='layui-icon'>&#xe631;</i></a>";
				return barOption;
			}} 
		</script>
	</shiro:hasPermission>
	<script type="text/javascript"
		src="<%=basePath%>/static/js/user/index.js"></script>
</body>
</html>