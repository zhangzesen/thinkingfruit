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
			<div class="layui-tab-item layui-show">
				<div id="main" style="height: 600px; width: 100%;"></div>
			</div>
		</div>
	</div>
<%-- 	<jsp:include page="/context/js-tags.jsp" /> --%>
	<script type="text/javascript"
		src="<%=%>/plug-in/city/data.js"></script>
	<script type="text/javascript"
		src="<%=%>/plug-in/echarts/echarts.min.js"></script>
	<script type="text/javascript"
		src="<%=%>/plug-in/echarts/map/china.js"></script>
	<script type="text/javascript"
		src="<%=%>/plug-in/js/payorder/address.js"></script>
</body>
</html>