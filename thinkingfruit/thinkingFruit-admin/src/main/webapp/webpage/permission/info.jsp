<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/context/begin-tags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/context/css-tags.jsp" />
</head>
<body>
	<div style="margin-top: 20px" class="layui-tab layui-tab-brief main-tab-container">
		<ul class="layui-tab-title main-tab-title">
			<li class="layui-this">权限展示列表</li>
			<div class="main-tab-item layui-bg-blue">权限展示</div>
		</ul>
		<div class="layui-tab-content">
			<div class="layui-tab-item layui-show">
				<div class="layui-tab-item layui-show">
					<div id="dateTable" lay-filter="table-data"></div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/context/js-tags.jsp" />
	<script id="barOption" type="text/html">
   {{#
    var barOption = "<a class='layui-btn layui-btn-small' title='编辑' lay-event='detail'><i class='layui-icon'>&#xe642;</i></a>";
    barOption+="<a class='layui-btn layui-btn-small layui-btn-danger del_btn' title='删除' lay-event='del' ><i class='layui-icon'>&#xe640;</i></a>";
    return barOption;
   }} 
</script>
	<script type="text/javascript"
		src="<%=basePath%>/static/js/permission/info.js"></script>
</body>
</html>