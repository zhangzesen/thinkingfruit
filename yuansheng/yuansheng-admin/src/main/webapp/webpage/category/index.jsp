<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@ include file="/context/begin-tags.jsp"%> --%>
<!DOCTYPE html>
<html>
<head>
<%-- <jsp:include page="/context/css-tags.jsp" /> --%>
</head>
<body>
	<div style="margin-top: 20px;"
		class="layui-tab layui-tab-brief main-tab-container">
		<div class="layui-tab-content">
			<xblock>
			<button class="layui-btn layui-btn-lg layui-btn-normal btn-add">
				<i class="layui-icon">&#xe61f;</i>添加
			</button>
			<span class="x-right"
				style="line-height: 40px; float: right; font-size: 20px">共有数据：${pagination.totalItemsCount}
				条</span> </xblock>

			<div class="layui-tab-item layui-show">
				<table class="list-table" width="100%">
					<thead>
						<tr>
							<th style="text-align: center; width: 150px;">编号</th>
							<th style="text-align: center; width: 300px;">分类名</th>
							<th style="text-align: center;">分类描述</th>
							<th style="text-align: center; width: 350px;">操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${pagination.items}" var="category">
							<tr>
								<td>${category.id}</td>
								<td>${category.categoryName}</td>
								<td>${category.categoryDescription}</td>
								<td style="text-align: center;"><a
									href="<%=%>/category/set?id=${category.id}"
									class="layui-btn layui-btn-small" title="编辑"><i
										class="layui-icon">&#xe60a;</i></a> 
									<a class="layui-btn layui-btn-small layui-btn-danger del_btn" name="delete"
									category-id="${category.id}" title="删除" category-name="${category.categoryName}"><i
										class="layui-icon">&#xe640;</i></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
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
		src="<%=%>/plug-in/js/category/index.js"></script>
</body>
</html>