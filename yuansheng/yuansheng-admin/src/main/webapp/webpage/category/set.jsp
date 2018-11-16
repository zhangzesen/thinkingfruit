<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@ include file="/context/begin-tags.jsp"%> --%>
<!DOCTYPE html>
<html>
<head>
<%-- <jsp:include page="/context/css-tags.jsp" /> --%>
</head>
<body>
	<div class="layui-tab layui-tab-brief main-tab-container">
		<div class="layui-tab-content">
			<div class="layui-tab layui-tab-card">
				<ul class="layui-tab-title">
					<c:if test="${categoryInfo == null}">
						<li class="layui-this">添加一级分类</li>
					</c:if>
					<c:if test="${categoryInfo != null}">
						<li class="layui-this">修改一级分类</li>
					</c:if>
				</ul>
				<div class="layui-form" style="margin-top: 10px;">
					<div class="layui-form-item">
						<label class="layui-form-label">分类名称</label>
						<div class="layui-input-inline input-custom-width">
							<input type="text" name="categoryName"
								<c:if test="${categoryInfo != null}"> value="${categoryInfo.categoryName}" </c:if>
								lay-verify="required" autocomplete="off" placeholder="请输入分类名称"
								class="layui-input">
						</div>
					</div>

					<c:if test="${categoryInfo != null}">
						<input name="id" value="${categoryInfo.id}" hidden="hidden">
					</c:if>

					<div class="layui-form-item">
						<label class="layui-form-label">分类描述</label>
						<div class="layui-input-inline input-custom-width">
							<textarea name="categoryDescription" lay-verify=""
								autocomplete="off" placeholder="请输入分类描述" class="layui-textarea"><c:if
									test="${categoryInfo != null}">${categoryInfo.categoryDescription}</c:if></textarea>
						</div>
					</div>

					<div class="layui-form-item" style="margin-left: 100px;">
						<div class="layui-input-block">
							<c:if test="${categoryInfo == null}">
								<button class="layui-btn" lay-submit="" lay-filter="cate_add">立即添加</button>
							</c:if>
							<c:if test="${categoryInfo != null}">
								<button class="layui-btn" lay-submit="" lay-filter="cate_add">立即修改</button>
							</c:if>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
<%-- 	<jsp:include page="/context/js-tags.jsp" /> --%>
	<script type="text/javascript"
		src="<%=%>/plug-in/js/category/set.js"></script>
</body>
</html>