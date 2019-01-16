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
.layui-table-cell{
    height:40px;
}
input{
width:90%
}
.layui-input-inline.xbs768{margin-right:1%;}
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
							name="startTime" id="startTime">
					</div>
					<div class="layui-input-inline xbs768" >
						<input type="text" readonly="readonly" class="layui-input endTime"
							value="" placeholder="截止日" name="endTime"
							id="endTime">
					</div>
					<div class="layui-input-inline xbs768" >
						<input type="text" class="orderNo layui-input" lay-verify="required"
							value="" autocomplete="off" id="orderNo"
							placeholder="请输入订单号" class="layui-input">
					</div>
					
					<div class="layui-input-inline xbs768">
						<input type="text" class="orderMemberName layui-input" lay-verify="required"
							value="" autocomplete="off" id="orderMemberName"
							placeholder="请输入代理名" class="layui-input">
					</div>
					
					<div class="layui-input-inline xbs768" style="width: 50px;">
						<button class="layui-btn btn-serach" lay-filter="sreach">
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
	<script type="text/html" id="barOption">
			{{#
			var barOption ="<a class='layui-btn layui-btn-small layui-btn-normal add_btn' lay-event='check' title='审核' ><i class='layui-icon'>&#xe642;</i></a>";
    			barOption+= "<a class='layui-btn layui-btn-small cancel_btn' lay-event='cancel'  title='取消'><i class='layui-icon'>&#xe640;</i></a>";
    			return barOption;

			}} 
	</script>
	<script type="text/javascript"
		src="<%=basePath%>/static/js/common/date.js"></script>
	<script type="text/html" id="date_formate">
    {{#  
     console.log("dateTime--->"+d.createTime);
     return new Date(d.createTime).format("yyyy-MM-dd hh:mm:ss");
    }} 
    </script>
	<script type="text/javascript"
		src="<%=basePath%>/static/js/purchaseOrder/checkIndex.js"></script>
</body>
</html>