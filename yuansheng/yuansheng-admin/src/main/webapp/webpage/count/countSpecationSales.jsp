<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@ include file="/context/begin-tags.jsp"%> --%>
<!DOCTYPE html>
<html>
<head>
<%-- <jsp:include page="/context/css-tags.jsp" /> --%>
</head>
<body>
<div style="margin-top: 20px;" class="layui-tab layui-tab-brief">
    <ul class="layui-tab-title" style="margin-left: 10px;">
			<li><a
				href="<%=%>/charts/commodity">商品统计</a></li>
			<li><a href="<%=%>/charts/member">会员统计</a></li>
			<li class="layui-this"><a href="<%=%>/count/countSpecationSales">规格统计</a></li>
			<li><a href="<%=%>/count/countCommentGrade">评价统计</a></li>
			<li><a href="<%=%>/count/countSystemClick">浏览量统计</a></li>
		</ul>
	<div class="layui-tab-content">
		<form class="layui-form" lay-filter="boardFilter">
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">一级分类</label>
					<div class="layui-input-inline">
						<select name="firstCategory" lay-filter="firstCategory" lay-verify="">
							<option value="">请选择</option>
							<c:forEach items="${firstCategoryIndex}" var="firstCategory">
							    <option value="${firstCategory.id}">${firstCategory.categoryName}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">二级分类</label>
					<div class="layui-input-inline">
						<select name="secondCategory" lay-filter="secondCategory" lay-verify="">
							<option value="">请选择</option>
						</select>
					</div>
				</div>
				<div class="layui-inline">
					<label class="layui-form-label">商品名</label>
					<div class="layui-input-inline">
						<select id="commodity" name="commodity" lay-filter="commodity" lay-verify="">
							<option value="">请选择</option>
						</select>
					</div>
				</div>
			</div>
		</form>
	</div>
	<div class="content">
		<div id="bar" style="width: 30%; height: 240px; float: left;"></div>
		<div id="line" style="width: 30%; height: 240px; float: left;"></div>
		<div id="pie" style="width: 30%; height: 240px; float: left;"></div>
	</div>
	</div>
<%-- 	<jsp:include page="/context/js-tags.jsp" /> --%>
	<script type="text/javascript" src="<%=%>/plug-in/echarts/echarts.min.js"></script>
	<script type="text/javascript" src="<%=%>/plug-in/js/count/countSpecationSales.js"></script>
</body>
</html>