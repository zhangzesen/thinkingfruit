<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/context/begin-tags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/context/css-tags.jsp" />
<jsp:include page="/context/css-tags.jsp" />
<style type="text/css">
.laytable-cell-1-8{
    height: auto;
}
.laytable-cell-1-status{
height: auto;
}
.layui-table-body{
    overflow:visible;
}
body{overflow-y: scroll;}
</style>
</head>
<body>
    <div style="margin-top: 20px;"
		class="layui-tab layui-tab-brief main-tab-container">
		<div class="layui-tab-content">
			<div class="layui-form xbs">
				<div class="layui-form-pane">
					<div class="layui-form-item" style="display: inline-block;">
						<label class="layui-form-label xbs768">时间范围</label>
						<div class="layui-input-inline xbs768">
							<input type="text" readonly="readonly" class="layui-input"
								value="" placeholder="开始日"
								name="startTime">
						</div>
						<div class="layui-input-inline xbs768">
							<input type="text" readonly="readonly" class="layui-input"
								value="" placeholder="截止日" name="endTime">
						</div>
						<div class="layui-input-inline xbs768">
								<input type="text" name="loginName"
									value="" placeholder="登录名" autocomplete="off" class="layui-input">
						</div>
						<div class="layui-input-inline xbs768">
							<select name="status">
							   <option value="">请选择提现状态</option>
							   <option value="0">未提现</option>
							   <option value="1">已提现</option>
							</select>
						</div>
						<div class="layui-input-inline xbs768" style="width: 80px">
							<button class="layui-btn btn-serach" lay-submit=""
								lay-filter="sreach">
								<i class="layui-icon">&#xe615;</i>搜索
							</button>
						</div>
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
    <jsp:include page="/context/js-tags.jsp"/>
    <script id="barOption" type="text/html">
	<a class='layui-btn layui-btn-sm layui-btn-warm edit_btn' lay-event='edit' style='display:none;'><i class='layui-icon'>确认提现</i></a>
    <a class='layui-btn layui-btn-sm completed_btn' lay-event='completed' style='display:none;'><i class='layui-icon'>已提现</i></a>
    </script>
	<script type="text/javascript"
		src="<%=basePath%>/static/js/cash/index.js"></script>
</body>
</html>