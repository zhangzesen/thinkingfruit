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
		class="layui-tab layui-tab-brief main-tab-container">
		<ul class="layui-tab-title main-tab-title">
			<li class="layui-this">权限列表</li>
				<li><a href="<%=%>/permission/set">添加权限</a></li>
			<div class="main-tab-item">权限管理</div>
		</ul>
		<div class="layui-tab-content">
			<div class="layui-tab-item layui-show">
				<table class="list-table">
					<thead>
						<tr>
							<th>权限ID</th>
							<th>权限名称</th>
							<th>上级权限ID</th>
							<th>权限URL</th>
							<th>权限规则描述</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${userPermissionList}" var="permission">
							<tr>
								<td>${permission.id}</td>
								<td>${permission.userPermissionName}</td>
								<td>${permission.userPermissionParentId}</td>
								<td>${permission.userPermissionUrl}</td>
								<td>${permission.userPermissionDescription}</td>
								<td style="text-align: center;">
										<a href="<%=%>/permission/set?id=${permission.id}"
											class="layui-btn layui-btn-small" title="编辑"><i
											class="layui-icon"></i>
										</a>
										<a class="layui-btn layui-btn-small layui-btn-danger del_btn"
											category-id="${permission.id}" title="删除"
											category-name="${permission.userPermissionName}"><i
											class="layui-icon"></i>
										</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
<%-- 	<jsp:include page="/context/js-tags.jsp" /> --%>
	<script type="text/javascript"
		src="<%=%>/plug-in/js/permission/index.js"></script>
</body>
</html>