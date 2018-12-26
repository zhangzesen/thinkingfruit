<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/context/begin-tags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/context/css-tags.jsp" />
<style>
#button {
	display: inline-block;
}

.layui-form-item .layui-input-inline {
	width: 300px;
}
</style>
</head>
<body>
	<div class="layui-tab-brief main-tab-container">
		<div class="layui-tab layui-tab-card">
			<ul class="layui-tab-title">
			</ul>
			<br />
			<div class="layui-form">
				<input name="id" value="" hidden="hidden">
				<fieldset class="layui-elem-field layui-field-title"
					style="margin-top: 30px;">
					<legend>订单信息</legend>
				</fieldset>
				<div class="layui-form-item">
					<label class="layui-form-label">订单编号</label>
					<div class="layui-input-inline input-custom-width">
						<input type="text" name="orderNo" autocomplete="off"
							class="layui-input" readonly="readonly">
					</div>
				</div>

				<div class="layui-form-item">
					<label class="layui-form-label">收件人</label>
					<div class="layui-input-inline input-custom-width">
						<input type="text" name="orderMemberName" autocomplete="off"
							class="layui-input" readonly="readonly">
					</div>
				</div>

				<div class="layui-form-item">
					<label class="layui-form-label">省</label>
					<div class="layui-input-inline input-custom-width">
						<input type="text" name="province" autocomplete="off"
							class="layui-input" readonly="readonly">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">市</label>
					<div class="layui-input-inline input-custom-width">
						<input type="text" name="city" autocomplete="off"
							class="layui-input" readonly="readonly">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">区</label>
					<div class="layui-input-inline input-custom-width">
						<input type="text" name="town" autocomplete="off"
							class="layui-input" readonly="readonly">
					</div>
				</div>

				<div class="layui-form-item">
					<label class="layui-form-label">详细地址</label>
					<div class="layui-input-inline input-custom-width">
						<input type="text" name="address" autocomplete="off"
							class="layui-input" readonly="readonly">
					</div>
				</div>

				<div class="layui-form-item" id="orderItem"></div>

				<div class="layui-form-item">
					<label class="layui-form-label">订单备注</label>
					<div class="layui-input-inline input-custom-width">
						<input type="text" name="remark" autocomplete="off"
							class="layui-input" readonly="readonly">
					</div>
				</div>


				<div class="layui-form-item">
					<label class="layui-form-label">订单状态</label>
					<div class="layui-input-inline input-custom-width">
						<input type="text" name="orderStatus" autocomplete="off"
							class="layui-input" readonly="readonly">
					</div>
				</div>


				<div class="layui-form-item">
					<label class="layui-form-label">发货时间</label>
					<div class="layui-input-inline input-custom-width">
						<input type="text" name="confirmTime" readonly="readonly"
							autocomplete="off" class="layui-input">
					</div>
				</div>

                  <div class="layui-form-item">
					<label class="layui-form-label">商品名</label>
					<div class="layui-input-inline input-custom-width">
						<input type="text" name="commodityName" autocomplete="off"
							class="layui-input">
					</div>
				</div>

				<div class="layui-form-item">
					<label class="layui-form-label">商品数量</label>
					<div class="layui-input-inline input-custom-width">
						<input type="text" name="commodityCount" autocomplete="off"
							class="layui-input">
					</div>
				</div>
<fieldset class="layui-elem-field layui-field-title"
					style="margin-top: 30px;">
					<legend>邮寄信息</legend>
				</fieldset>
				<div class="layui-form-item">
					<label class="layui-form-label">快递类型</label>
					<div class="layui-input-inline">
						<select name="logistics" id="logistics" lay-filter="logistics">
							<option value="">请选择快递类型</option>
						</select>
					</div>
				</div>

				<div class="layui-form-item">
					<label class="layui-form-label">运单编号</label>
					<div class="layui-input-inline input-custom-width">
						<input type="text" name="expressNo" autocomplete="off"
							class="layui-input">
					</div>
				</div>

				


				<div class="layui-form-item" id="btn">
					<div class="layui-input-block" id="button"></div>
				</div>
			</div>

		</div>
	</div>

	<jsp:include page="/context/js-tags.jsp" />
	<script type="text/javascript"
		src="<%=basePath%>/static/js/order/info.js"></script>
</body>
</html>