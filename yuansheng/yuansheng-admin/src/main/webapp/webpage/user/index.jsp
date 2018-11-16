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
			<li class="layui-this"><a href="<%=%>/user">用户列表</a></li>
				<li><a href="<%=%>/user/set">添加用户</a></li>
			<div class="main-tab-item">用户管理</div>
		</ul>
		<div class="layui-tab-content">
			<form class="layui-form xbs" method="get" action="<%=%>/user">
				<div class="layui-form-pane">
					<div class="layui-form-item" style="display: inline-block;">
						<label class="layui-form-label xbs768">时间范围</label>
						<div class="layui-input-inline xbs768">
							<input type="text" readonly="readonly" class="layui-input"
								value="${user.startTime}" placeholder="开始日" name="startTime">
						</div>
						<div class="layui-input-inline xbs768">
							<input type="text" readonly="readonly" class="layui-input"
								value="${user.endTime}" placeholder="截止日" name="endTime">
						</div>
						<div class="layui-input-inline xbs768">
							<select id="roleId" role="${user.roleId}" name="roleId"
								lay-filter="roleId">
								<option value="">请输入角色编号</option>
								<c:forEach items="${roles}" var="role">
									<option value="${role.id}"
										<c:if test="${user.roleId==role.id}">selected="selected"</c:if>>${role.userRoleName}</option>
								</c:forEach>
							</select>
						</div>
						<div class="layui-input-inline xbs768">
							<input type="text" name="loginName"
								value="${user.loginName}" placeholder="请输入用户名"
								autocomplete="off" class="layui-input">
						</div>
						<div class="layui-input-inline xbs768">
							<select id="status" name="status"
								lay-filter="status">
								<option value="">请输入用户状态</option>
							<option value="0" <c:if test="${user.status==0}">selected="selected"</c:if>>停用</option>
								<option value="1" <c:if test="${user.status==1}">selected="selected"</c:if>>启用</option>
							</select>
						</div>
						<div class="layui-input-inline xbs768" style="width: 80px">
							<button class="layui-btn btn-serach" lay-submit=""
								lay-filter="sreach">
								<i class="layui-icon">&#xe615;</i>
							</button>
						</div>
					</div>
				</div>
			</form>
			<xblock>
			<button
				class="layui-btn layui-btn-danger btn-loadmore btn-sreach-more">
				<i class="layui-icon">&#xe615;</i>搜索更多
			</button>
			<button class="layui-btn layui-btn-warm btn-reset">
				<i class="layui-icon">&#x1002;</i>重置
			</button>
			<span class="x-right" style="line-height: 40px; float:right;font-size: 20px">共有数据：${pagination.totalItemsCount}
				条</span> </xblock>
			<div class="layui-tab-item layui-show">
				<table class="list-table">
					<thead>
						<tr>
							<th>ID</th>
							<th>昵称</th>
							<th>角色</th>
							<th>加入时间</th>
							<th>状态</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${pagination.items}" var="item">
							<tr>
								<td>${item.id}</td>
								<td>${item.loginName}</td>
								<td><c:forEach items="${roles}" var="role">
										<c:if test="${item.roleId==role.id}">${role.userRoleName}</c:if>
									</c:forEach></td>
								<td><fmt:formatDate value="${item.createTime}"
										pattern="YYYY-MM-dd HH:mm:ss" /></td>
								<td><c:choose>
										<c:when test="${item.status == 1}">
											<span class="layui-btn layui-btn-normal layui-btn-mini">
												正常 </span>
										</c:when>
										<c:otherwise>
											<span class="layui-btn layui-btn-danger layui-btn-mini">
												停用 </span>
										</c:otherwise>
									</c:choose></td>
								<td><a href="<%=%>/user/information?id=${item.id}"
									class="layui-btn layui-btn-small" title="查看"><i
										class="layui-icon">&#xe62a;</i></a>
										<a href="<%=%>/user/set?id=${item.id}"
											class="layui-btn layui-btn-small" title="编辑"><i
											class="layui-icon"></i></a>
										<a style="text-decoration: none"
											class="layui-btn layui-btn-small user-password"
											userid="${item.id}"
											href="<%=%>/user/password?id=${item.id}" title="修改密码">
											<i class="layui-icon">&#xe631;</i>
										</a>
										<a class="layui-btn layui-btn-small layui-btn-danger del_btn"
											user-id="${item.id}"
											<c:choose><c:when test="${item.status == 1}">title="删除" status="1" </c:when><c:otherwise>title="恢复" status="0" </c:otherwise></c:choose>
											user-name="${item.loginName}"><c:if
												test="${item.status == 1}">
												<i class="layui-icon">&#xe640;</i>
											</c:if> <c:if test="${item.status == 2}">
												<i class="layui-icon">&#xe616;</i>
											</c:if></a>
									</td>

							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="bug-pie">
									<div id="bug-pie"></div>
								</div>
			<input type="hidden" name="totalPageCount"
				value="${pagination.totalPageCount}"> <input type="hidden"
				name="pageNum" value="${pagination.pageNum}"> <input
				type="hidden" name="totalItemsCount"
				value="${pagination.totalItemsCount}">
			<div id="page"></div>
		</div>
	</div>
<%-- 	<jsp:include page="/context/js-tags.jsp" /> --%>
	<script type="text/javascript"
		src="<%=%>/plug-in/js/user/index.js"></script>
</body>
</html>