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
body{overflow-y: scroll;}
</style>
</head>
<body>
<div class="tpl-content-wrapper">
	<div style="margin-top: 20px;"
		class="layui-tab layui-tab-brief main-tab-container">
		<div class="layui-tab-content">
				<div class="layui-form-pane">
					<div class="layui-form-item" style="display: inline-block;">
						<div class="layui-input-inline xbs768">
								<input type="text" name="name"
									value=""
									placeholder="请输入商品名" autocomplete="off" class="layui-input">
						</div>
						<div class="layui-input-inline xbs768">
								<input type="text" name="description"
									value=""
									placeholder="请输入商品卖点" autocomplete="off" class="layui-input">
						</div>
						<div class="layui-input-inline xbs768" style="width: 80px">
							<button class="layui-btn btn-serach" lay-submit=""
								lay-filter="sreach">
								<i class="layui-icon">&#xe615;</i>
							</button>
						</div>
					</div>
				</div>
			<xblock>
			<button class="layui-btn layui-btn-warm btn-reset">
				<i class="layui-icon">&#x1002;</i>重置
			</button>
			<button class="layui-btn layui-btn-normal btn-add">
				<i class="layui-icon">&#xe61f;</i>添加
			</button>
			</xblock>

        	<!-- 表格 -->
            <div id="dateTable" lay-filter="table-data"></div>

		</div>
	</div>
	</div>
	<jsp:include page="/context/js-tags.jsp"/>
	<script id="barOption" type="text/html">
   {{#
    var barOption = "<a class='layui-btn layui-btn-small layui-btn-warm look_btn' title='查看' lay-event='detail'><i class='layui-icon'>&#xe615;</i></a>";
    barOption += "<a class='layui-btn layui-btn-small' title='编辑' lay-event='edit'><i class='layui-icon'>&#xe642;</i></a>";
    barOption+="<a class='layui-btn layui-btn-small layui-btn-danger del_btn' title='删除' lay-event='del' ><i class='layui-icon'>&#xe640;</i></a>";
    return barOption;
   }} 
    </script>
	<script type="text/javascript" src="<%=basePath%>/static/js/commodity/index.js"></script>
</body>
</html>