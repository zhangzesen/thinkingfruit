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
			<li class="layui-this"><a href="<%=%>/role">角色列表</a></li>

				<li><a href="<%=%>/role/set">添加角色</a></li>
			<div class="main-tab-item">角色管理</div>
		</ul>
		<div class="layui-tab-content">
			<div class="layui-tab-item layui-show">
				<table class="list-table">
					<thead>
						<tr>
							<th>角色ID</th>
							<th>角色名称</th>
							<th>角色描述</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${userRoleList}" var="role">
							<tr>
								<td>${role.id}</td>
								<td>${role.userRoleName}</td>
								<td>${role.userRoleDescription}</td>
								<td style="text-align: center;"><a
									href="<%=%>/role/information/${role.id}"
									class="layui-btn layui-btn-small" title="查看"><i
										class="layui-icon">&#xe62a;</i></a> 
										<a href="<%=%>/role/set?id=${role.id}"
											class="layui-btn layui-btn-small" title="编辑"><i
											class="layui-icon"></i></a>
									
										<a class="layui-btn layui-btn-small layui-btn-danger del_btn"
											category-id="${role.id}" title="删除"
											category-name="${role.userRoleName}"><i
											class="layui-icon"></i></a>
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
		src="<%=%>/plug-in/js/role/index.js"></script>
</body>
</html>