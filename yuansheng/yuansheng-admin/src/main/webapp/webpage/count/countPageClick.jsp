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
			<li><a href="<%=%>/count/countSpecationSales">规格统计</a></li>
			<li><a href="<%=%>/count/countCommentGrade">评价统计</a></li>
			<li class="layui-this"><a href="<%=%>/count/countSystemClick">浏览量统计</a></li>
		</ul>
	<div class="layui-tab-content">
		<form class="layui-form" action="">
			<div class="layui-form-item">
				<label class="layui-form-label">请选择时间</label>
				<div class="layui-input-inline">
					<select name="time" lay-filter="time" lay-verify="">
						<option value="1" selected="selected">最近7天</option>
						<option value="2">最近一个月</option>
						<option value="3">最近一年</option>
						<option value="4">全部</option>
					</select>
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
	<script type="text/javascript"
		src="<%=%>/plug-in/echarts/echarts.min.js"></script>
	<script type="text/javascript" src="<%=%>/plug-in/js/count/countPageClick.js"></script>
</body>
</html>