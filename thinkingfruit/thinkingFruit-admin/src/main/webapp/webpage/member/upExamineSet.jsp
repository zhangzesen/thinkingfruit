<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/context/begin-tags.jsp"%>
<!DOCTYPE html">
<html>
<head>
<jsp:include page="/context/css-tags.jsp" />
<style type="text/css">
.error{
color:red;
}
input{
color:#666!important;
}
</style>
</head>
<body>
<div class="layui-tab layui-tab-brief main-tab-container">
		<div class="layui-tab-content">
			<div class="layui-tab layui-tab-card">
				<div class="layui-form" style="margin-top: 10px;">
				
				    <div class="layui-form-item">
						<label class="layui-form-label">选择级别</label>
						<div class="layui-input-block" style="width: 300px; text-align: center;">
							<select name="memberLevelId" lay-filter="reportType" required="true" diyCheck="请选择等级">
								<option value="">请选择级别</option>
								<option value="1">联创</option>
								<option value="2">董事</option>
								<option value="3">总监</option>
								<option value="4">svip</option>
								<option value="5">vip</option>
							</select>
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">选择商品</label>
						<div class="layui-input-block" style="width: 300px; text-align: center;">
							<select name="commodityId" lay-filter="reportType" required="true" diyCheck="请选择商品">
								<option value="">请选择商品</option>
							</select>
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">商品数量</label>
						<div class="layui-input-inline input-custom-width">
							<input type="text" name="commodityCount" diyRule="^[0-9]+.?[0-9]*$" diyCheck="输入的不是数字"
								required="true" value="" autocomplete="off"
								placeholder="请输入商品数量" class="layui-input" lay-verType="alert">
						</div>
					</div>
					<input name="id" value="" hidden="hidden">

					<div class="layui-form-item" style="margin-left: 100px;">
						<div class="layui-input-block" id="btn">
							<button class="layui-btn" lay-submit="" lay-filter="cate_add">立即修改</button>
						</div>
					</div>
					
					<br>
					<br>
					<br>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/context/js-tags.jsp" />
	<script type="text/javascript"
		src="<%=basePath%>/static/plugin/jquery-validation/jquery.validate.min.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>/static/plugin/jquery-validation/localization/messages_zh.min.js"></script>
    <script type="text/javascript" 
       src="<%=basePath%>/static/plugin/jquery-validation/additional-methods.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>/static/js/member/upExamineSet.js"></script>
</body>
</html>