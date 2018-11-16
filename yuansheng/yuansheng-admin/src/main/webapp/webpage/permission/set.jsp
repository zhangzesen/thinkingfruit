<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@ include file="/context/begin-tags.jsp"%> --%>
<!DOCTYPE html>
<html>
<head>
<%-- <jsp:include page="/context/css-tags.jsp" /> --%>
</head>
<body>
	<div style="margin-top: 20px" class="layui-tab-brief main-tab-container">
		<ul class="layui-tab-title main-tab-title">
			<li><a href="<%=%>/permission">权限列表</a></li>
			<c:if test="${userPermission != null}">
				<li class="layui-this">修改权限</li>
			</c:if>
			<c:if test="${userPermission == null}">
				<li class="layui-this">添加权限</li>
			</c:if>
			<div class="main-tab-item">权限管理</div>
		</ul>
		<div class="layui-tab-content">
			<div class="layui-tab-item layui-show">
				<div class="layui-tab layui-tab-card">
					<ul class="layui-tab-title">
						<c:if test="${userPermission != null}">
							<li class="layui-this">修改权限</li>
						</c:if>
						<c:if test="${userPermission == null}">
							<li class="layui-this">添加权限</li>
						</c:if>
					</ul>
					<div class="layui-tab-content">
						<div class="layui-tab-item layui-show">
							<div class="layui-form">
								<div class="layui-form-item">
									<label class="layui-form-label">上级权限</label>
									<div class="layui-input-inline input-custom-width">
										<select class="parentId" name="parentId" lay-verify=""><option
												value="">请选择</option>
											<option value="0" selected="">≡ 作为上级权限 ≡</option>
											<c:if test="${userPermission != null}">
												<c:forEach items="${userPermissionList}" var="permission">
													<option value="${permission.id }"
														<c:if test="${permission.id == userPermission.userPermissionParentId}">selected="selected"</c:if>>${permission.userPermissionName }</option>
												</c:forEach>
											</c:if>
											<c:if test="${userPermission == null}">
												<c:forEach items="${userPermissionList}" var="permission">
													<option value="${permission.id }">${permission.userPermissionName }</option>
												</c:forEach>
											</c:if>

										</select>
									</div>
									<div class="layui-form-mid layui-word-aux"></div>
								</div>
								<c:if test="${userPermission != null}">
									<input name="id" value="${userPermission.id}" hidden="hidden">
								</c:if>
								<div class="layui-form-item">
									<label class="layui-form-label">权限等级</label>
									<div class="layui-input-inline input-custom-width">
										<input type="text" name="userPermissionLevel"
											<c:if test="${userPermission != null}"> value="${userPermission.userPermissionLevel }" </c:if>
											lay-verify="required" autocomplete="off"
											placeholder="请输入权限等级" class="layui-input">
									</div>
								</div>

								<div class="layui-form-item">
									<label class="layui-form-label">权限名称</label>
									<div class="layui-input-inline input-custom-width">
										<input type="text" name="userPermissionName"
											<c:if test="${userPermission != null}"> value="${userPermission.userPermissionName }" </c:if>
											lay-verify="required" autocomplete="off"
											placeholder="请输入权限名称" class="layui-input">
									</div>
								</div>

								<div class="layui-form-item">
									<label class="layui-form-label">权限URL</label>
									<div class="layui-input-inline input-custom-width">
										<input type="text" name="userPermissionUrl"
											<c:if test="${userPermission != null}"> value="${userPermission.userPermissionUrl }" </c:if>
											lay-verify="required" autocomplete="off"
											placeholder="请输入权限URL" class="layui-input">
									</div>
								</div>

								<div class="layui-form-item">
									<label class="layui-form-label">权限连接</label>
									<div class="layui-input-inline input-custom-width">
										<input type="text" name="userPermissionHref"
											<c:if test="${userPermission != null}"> value="${userPermission.userPermissionHref }" </c:if>
											lay-verify="required" autocomplete="off"
											placeholder="请输入权限连接" class="layui-input">
									</div>
								</div>

								<div class="layui-form-item">
									<label class="layui-form-label">权限描述</label>
									<div class="layui-input-inline input-custom-width">
										<textarea name="userPermissionDescription" lay-verify="required" autocomplete="off"
										autocomplete="off" placeholder="请输入权限描述"
										class="layui-textarea"><c:if
											test="${userPermission != null}">${userPermission.userPermissionDescription}</c:if></textarea>
									</div>
								</div>

							</div>
							<div class="layui-form-item">
								<div class="layui-input-block">
									<c:if test="${userPermission == null}">
										<button class="layui-btn" lay-submit="" lay-filter="cate_add">立即添加</button>
									</c:if>
									<c:if test="${userPermission != null}">
										<button class="layui-btn" lay-submit="" lay-filter="cate_add">立即修改</button>
									</c:if>

								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
<%-- 	<jsp:include page="/context/js-tags.jsp" /> --%>
	<script type="text/javascript"
		src="<%=%>/plug-in/js/permission/set.js"></script>
</body>
</html>

