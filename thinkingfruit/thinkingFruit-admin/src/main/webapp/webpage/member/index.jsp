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
.layui-table-cell{
    height:40px;
}
.layui-form{
    float: left;
}
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
						<form class="layui-form" action="">
						<div class="layui-input-inline xbs768">
							<select id="memberLevelId" name="memberLevelId" lay-filter="discount">
								<option value="">请选择级别</option>
								<option value="1">联创</option>
								<option value="2">春事</option>
								<option value="3">总监</option>
								<option value="4">SVIP</option>
								<option value="5">VIP</option>
							</select>
						</div>
					</form>
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
	<script type="text/javascript"
		src="<%=basePath%>/static/js/common/date.js"></script>
	<script type="text/html" id="date_formate">
    {{#  
     console.log("dateTime--->"+d.createTime);
     return new Date(d.createTime).format("yyyy-MM-dd hh:mm:ss");
    }} 
    </script>
	<script id="barOption" type="text/html">
   {{#
    var barOption ="<a class='layui-btn layui-btn-small layui-btn-warm look_btn' title='查看' lay-event='info'><i class='layui-icon'>&#xe615;</i></a>";
    barOption+="<a class='layui-btn layui-btn-small edit_btn' title='修改' lay-event='edit'><i class='layui-icon'>&#xe642;</i></a>";
    barOption+= "<a class='layui-btn layui-btn-small layui-btn-normal add_btn' title='修改密码' lay-event='setPswd'><i class='layui-icon'>&#xe631;</i></a>";
    barOption+= "<a class='layui-btn layui-btn-small layui-btn-danger add_btn' title='删除' lay-event='delete'><i class='layui-icon'>&#xe640;</i></a>";
    return barOption;
   }} 
    </script>
	<script type="text/javascript"
		src="<%=basePath%>/static/js/member/index.js"></script>
</body>
</html>