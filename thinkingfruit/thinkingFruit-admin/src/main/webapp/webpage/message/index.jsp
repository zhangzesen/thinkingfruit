<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/context/begin-tags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/context/css-tags.jsp" />
<style type="text/css">
.laytable-cell-1-4{
    height: auto;
/*     width: 250px!important; */
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
							<input type="text" name="content"
								value="" placeholder="请输入消息内容"
								autocomplete="off" class="layui-input">
						</div>
<!-- 						<div class="layui-input-inline xbs768"> -->
<!-- 							<select name="status" lay-filter="status" lay-verify=""> -->
<!-- 								<option value="" selected="selected">请输入消息状态</option> -->
<%-- 								<option value="0" <c:if test="${noticeMessage.status==0}">selected="selected"</c:if>>未读</option> --%>
<%-- 								<option value="1" <c:if test="${noticeMessage.status==1}">selected="selected"</c:if>>已读</option> --%>
<!-- 							</select> -->
<!-- 						</div> -->
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
			<button class="layui-btn layui-btn-danger btn-delete-batch ">
				<i class="layui-icon">&#xe640;</i>批量删除
			</button>
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
    var barOption = "<a class='layui-btn layui-btn-small layui-btn-danger del_btn' title='删除' lay-event='del' ><i class='layui-icon'>&#xe640;</i></a>";
    return barOption;
   }} 
    </script>
	<script type="text/javascript" src="<%=basePath%>/static/js/message/index.js"></script>
</body>
</html>