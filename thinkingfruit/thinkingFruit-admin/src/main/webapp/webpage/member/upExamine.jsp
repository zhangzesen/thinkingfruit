<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/context/begin-tags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/context/css-tags.jsp" />
<style type="text/css">
.laytable-cell-1-10{
    height: auto;
    width: 290px!important;
}
.layui-table{
    width: 100%!important;
}
body{overflow-y: scroll;}
</style>
</head>
<body>
	<div class="layui-tab layui-tab-brief main-tab-container">
		<div class="layui-tab-content">
				<div class="layui-form-pane">
					<div class="layui-form-item" style="display: inline-block;">
						<label class="layui-form-label xbs768">时间范围</label>
						<div class="layui-input-inline xbs768">
							<input type="text" readonly="readonly" class="layui-input"
								value="" placeholder="开始日" name="startTime">
						</div>
						<div class="layui-input-inline xbs768">
							<input type="text" readonly="readonly" class="layui-input"
								value="" placeholder="截止日" name="endTime">
						</div>
						<div class="layui-input-inline xbs768">
							<input type="text" name="loginName" value=""
								placeholder="登录名" autocomplete="off" class="layui-input">
						</div>
					<div class="layui-input-inline xbs768" style="width: 80px">
							<button class="layui-btn btn-serach" lay-submit=""
								lay-filter="sreach">
								<i class="layui-icon">&#xe615;</i>搜索
							</button>
						</div>
					</div>
				</div>
			<xblock>
			<button class="layui-btn layui-btn-warm btn-reset">
				<i class="layui-icon">&#x1002;</i>重置
			</button>
			</xblock>
			
			<!-- 表格 -->
            <div id="dateTable" lay-filter="table-data"></div>
		</div>
	</div>
	<jsp:include page="/context/js-tags.jsp" />
	<script id="barOption" type="text/html">
   {{#
    var barOption ="<a class='layui-btn layui-btn-small edit_btn' title='审核' lay-event='examine'><i class='layui-icon'>&#xe642;</i></a>";
    barOption+="<a class='layui-btn layui-btn-small layui-btn-danger del_btn' title='删除' lay-event='del' ><i class='layui-icon'>&#xe640;</i></a>";
    return barOption;
   }} 
    </script>
	<script type="text/javascript"
		src="<%=basePath%>/static/js/member/upExamine.js"></script>
</body>
</html>