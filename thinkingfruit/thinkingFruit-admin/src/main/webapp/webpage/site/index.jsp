<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/context/begin-tags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/context/css-tags.jsp" />
<style type="text/css">
.laytable-cell-1-8{
    height: auto;
}
.laytable-cell-1-coverImagePath{
    height: auto;
}
.layui-table-cell{
    height:auto;
}
body{overflow-y: scroll;}
</style>
</head>
<body>
	<div style="margin-top: 20px;"
		class="layui-tab layui-tab-brief main-tab-container">
		<div class="layui-tab-content">

        	<!-- 表格 -->
            <div id="dateTable" lay-filter="table-data"></div>

		</div>
	</div>
	<jsp:include page="/context/js-tags.jsp"/>
	<script id="barOption" type="text/html">
   {{#
    var barOption = "<a class='layui-btn layui-btn-sm' title='编辑' lay-event='edit'><i class='layui-icon'>&#xe642;编辑</i></a>";
    return barOption;
   }} 
    </script>
	<script type="text/javascript" src="<%=basePath%>/static/js/site/index.js"></script>
</body>
</html>