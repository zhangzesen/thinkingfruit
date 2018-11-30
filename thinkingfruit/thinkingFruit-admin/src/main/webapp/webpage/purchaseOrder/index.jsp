<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/context/begin-tags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/context/css-tags.jsp" />
<style>
.laytable-cell-1-imagePath{
height:auto;
}
td .layui-table-cell{
height:auto;
}
</style>
</head>
<body>
	<div class="layui-tab layui-tab-brief main-tab-container">
		<div class="layui-tab-content">
		
			<div class="layui-form-pane">
				<div class="layui-form-item">
					<label class="layui-form-label xbs768" style="width:150px;">订单创建时间范围</label>
					<div class="layui-input-inline xbs768" >
						<input type="text" readonly="readonly" class="layui-input startTime"
							value="" placeholder="开始日"
							name="startTime" id="start">
					</div>
					<div class="layui-input-inline xbs768" >
						<input type="text" readonly="readonly" class="layui-input endTime"
							value="" placeholder="截止日" name="endTime"
							id="end">
					</div>
					<div class="layui-input-inline xbs768" >
						<input type="text" class="orderNo layui-input" lay-verify="required"
							value="" autocomplete="off" name="orderNo"
							placeholder="请输入订单号" class="layui-input">
					</div>
					
					<div class="layui-input-inline xbs768" >
						<input type="text" class="orderMemberName layui-input" lay-verify="required"
							value="" autocomplete="off" name="orderMemberName"
							placeholder="请输入代理名" class="layui-input">
					</div>
					
					<div class="layui-input-inline xbs768" >
						<div class="layui-form">
							<select id="orderStatus" name="orderStatus" lay-filter="orderStatus">
								<option value="">请选择订单状态</option>
							</select>
						</div>
					</div>
					<div class="layui-input-inline xbs768" style="width: 50px">
						<button class="layui-btn btn-serach" lay-filter="sreach">
							<i class="layui-icon">&#xe615;</i>
						</button>
					</div>
				</div>
			</div>
			<xblock>
			<button class="layui-btn layui-btn-warm btn-reset">
				<i class="layui-icon">&#x1002;</i>重置
			</button>
			<a href="<%=basePath%>/purchase/export"  class="layui-btn layui-btn-danger btn-export-excel" name="exportExcel"><i class="layui-icon">&#xe601;</i> 导出当前页面的Excel</a>
			</xblock>
			<!-- 表格 -->
            <div id="dateTable" lay-filter="table-data"></div>
			<script type="text/html" id="barOption">
			<a class='layui-btn layui-btn-small layui-btn-normal add_btn' lay-event='deliver' style='display:none;'><i class='layui-icon'>发货</i></a>
			<a class="layui-btn layui-btn-small cancel_btn" lay-event="cancel" style='display:none;'><i class='layui-icon'>取消</i></a>
			<a class='layui-btn layui-btn-small layui-btn-warm look_btn' lay-event='detail' style='display:none;'><i class='layui-icon'>查看</i></a>
			</script>
			
		</div>
	</div>
	<jsp:include page="/context/js-tags.jsp" />
	<script type="text/javascript"
		src="<%=basePath%>/static/js/purchaseOrder/index.js"></script>
</body>
</html>