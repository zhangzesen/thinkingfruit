<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@ include file="/context/begin-tags.jsp"%> --%>
<!DOCTYPE html>
<html>
<head>
<%-- <jsp:include page="/context/css-tags.jsp" /> --%>
</head>
<body>
	<div style="margin-top: 20px" class="layui-tab layui-tab-brief main-tab-container">
		<ul class="layui-tab-title main-tab-title">
			<li class="layui-this">权限展示列表</li>
			<div class="main-tab-item">权限展示</div>
		</ul>
		<div class="layui-tab-content">
			<div class="layui-tab-item layui-show">
				<table class="list-table">
					<thead>
						<tr>
							<th>权限ID</th>
							<th>权限名称</th>
							<th>上级权限ID</th>
							<th>权限规则描述</th>
							<th>权限URL</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${userPermissionList}" var="permission">
							<tr>
								<td>${permission.id}</td>
								<td>${permission.userPermissionName}</td>
								<td>${permission.userPermissionParentId}</td>
								<td>${permission.userPermissionDescription}</td>
								<td>${permission.userPermissionUrl}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
<%-- 	<jsp:include page="/context/js-tags.jsp" /> --%>
</body>
</html>