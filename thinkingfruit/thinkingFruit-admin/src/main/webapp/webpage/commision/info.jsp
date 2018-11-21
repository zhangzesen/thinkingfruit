<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/context/begin-tags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/context/css-tags.jsp" />
</head>
<body>
    <div class="layui-tab layui-tab-brief main-tab-container">
		<div class="layui-tab-content">
		<div class="layui-tab layui-tab-card">
		    <ul class="layui-tab-title">
				<li class="layui-this">佣金详情</li>
			</ul>
		    <div class="layui-form" style="margin-top: 10px;">
				<div class="layui-form-item">
					<label class="layui-form-label">订单号</label>
					<div class="layui-input-inline input-custom-width">
						<input type="text" name="orderNo" 
							value="" autocomplete="off" readonly="readonly"
							class="layui-input">
					</div>
				</div>
				
				<div class="layui-form-item">
					<label class="layui-form-label">订单时间</label>
					<div class="layui-input-inline input-custom-width">
						<input type="text" name="createTime" 
							value="" autocomplete="off" readonly="readonly"
							class="layui-input">
					</div>
				</div>
				
				<div class="layui-form-item">
					<label class="layui-form-label">总金额</label>
					<div class="layui-input-inline input-custom-width">
						<input type="text" name="totalAmount" 
							value="" autocomplete="off" readonly="readonly"
							class="layui-input">
					</div>
				</div>
				
				<div class="layui-form-item">
					<label class="layui-form-label">总佣金</label>
					<div class="layui-input-inline input-custom-width">
						<input type="text" name="commision" 
							value="" autocomplete="off" readonly="readonly"
							class="layui-input">
					</div>
				</div>
				
				<div class="layui-form-item">
					<label class="layui-form-label">佣金占比</label>
					<div class="layui-input-inline input-custom-width">
						<input type="text" name="percent" 
							value="" autocomplete="off" readonly="readonly"
							class="layui-input">
					</div>
				</div>
				
				<div class="layui-form-item">
					<label class="layui-form-label">佣金受益人</label>
					<div class="layui-input-inline input-custom-width">
					    <textarea name="nicknames" class="layui-textarea" readonly="readonly"></textarea>
<!-- 						<input type="text" name="nicknames"  -->
<!-- 							value="" autocomplete="off" readonly="readonly" -->
<!-- 							class="layui-input"> -->
					</div>
				</div>
				
			</div>
		</div>
		</div>
	</div>
	<jsp:include page="/context/js-tags.jsp" />
	<script type="text/javascript"
		src="<%=basePath%>/static/js/commision/info.js"></script>
</body>
</html>