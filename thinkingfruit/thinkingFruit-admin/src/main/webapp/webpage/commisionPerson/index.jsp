<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/context/begin-tags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/context/css-tags.jsp" />
<style type="text/css">
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
								<input type="text" name="nickname"
									value="" placeholder="昵称" autocomplete="off" class="layui-input">
						</div>
						<div class="layui-input-inline xbs768" style="width: 80px">
							<button class="layui-btn btn-serach" lay-submit=""
								lay-filter="sreach">
								<i class="layui-icon">&#xe615;</i>
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
<!--     <script id="barOption" type="text/html"> -->
<!--    {{# -->
<!--     var barOption = "<a class='layui-btn layui-btn-small layui-btn-warm look_btn' title='查看' lay-event='detail'><i class='layui-icon'>&#xe615;</i></a>"; -->
<!--     return barOption; -->
<!--    }}  -->
<!--     </script> -->
	<script type="text/javascript"
		src="<%=basePath%>/static/js/commisionPerson/index.js"></script>
</body>
</html>