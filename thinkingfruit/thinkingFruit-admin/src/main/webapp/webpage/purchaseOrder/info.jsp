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
					<label class="layui-form-label">代理人</label>
					<div class="layui-input-inline input-custom-width">
						<input type="text" name="orderMemberName" autocomplete="off"
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
					<label class="layui-form-label">凭证图片</label>
						<div class="layui-input-inline input-custom-width">
							<img alt=" " border="none" name="certificate" src="" width="300px" height="120px">
						</div>
				</div>
				<fieldset class="layui-elem-field layui-field-title"
					style="margin-top: 30px;">
					<legend>分佣信息</legend>
				</fieldset>
				<div class="layui-form-item">
					<label class="layui-form-label">邀请者id</label>
					<div class="layui-input-inline input-custom-width">
						<input type="text" name="inviterId" autocomplete="off"
							class="layui-input" readonly="readonly">
					</div>
				</div>

				<div class="layui-form-item">
					<label class="layui-form-label">邀请金</label>
					<div class="layui-input-inline input-custom-width">
						<input type="text" name="inviteMoney" autocomplete="off"
							class="layui-input" readonly="readonly">
					</div>
				</div>

				<div class="layui-form-item">
					<label class="layui-form-label">邀请者获得的分佣</label>
					<div class="layui-input-inline input-custom-width">
						<input type="text" name="inviterTotalMoney" autocomplete="off"
							class="layui-input" readonly="readonly">
					</div>
				</div>

				<div class="layui-form-item">
					<label class="layui-form-label">邀请者上级代理id</label>
					<div class="layui-input-inline input-custom-width">
						<input type="text" name="inviterUpperId" autocomplete="off"
							class="layui-input" readonly="readonly">
					</div>
				</div>

				<div class="layui-form-item">
					<label class="layui-form-label">邀请者上级分佣比例</label>
					<div class="layui-input-inline input-custom-width">
						<input type="text" name="commisionProportion" autocomplete="off"
							class="layui-input" readonly="readonly">
					</div>
				</div>

				<div class="layui-form-item">
					<label class="layui-form-label">邀请者上级分得的佣金</label>
					<div class="layui-input-inline input-custom-width">
						<input type="text" name="commision" autocomplete="off"
							class="layui-input" readonly="readonly">
					</div>
				</div>
				<fieldset class="layui-elem-field layui-field-title"
					style="margin-top: 30px;">
					<legend>货物信息</legend>
				</fieldset>
				

				

				


				<div class="layui-form-item">
					<label class="layui-form-label">商品名</label>
					<div class="layui-input-inline input-custom-width">
						<input type="text" name="commodityName" autocomplete="off"
							class="layui-input">
					</div>
				</div>

				<div class="layui-form-item">
					<label class="layui-form-label">商品价格</label>
					<div class="layui-input-inline input-custom-width">
						<input type="text" name="commodityPrice" autocomplete="off"
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

				<div class="layui-form-item">
					<label class="layui-form-label">创建时间</label>
					<div class="layui-input-inline input-custom-width">
						<input type="text" name="createTime" readonly="readonly"
							autocomplete="off" class="layui-input">
					</div>
				</div>

				<div class="layui-form-item">
					<label class="layui-form-label">发货时间</label>
					<div class="layui-input-inline input-custom-width">
						<input type="text" name="confirmTime" readonly="readonly"
							autocomplete="off" class="layui-input">
					</div>
				</div>

				<input name="orderStatusNo" value="" hidden="hidden">
				<div class="layui-form-item" id="btn">
					<div class="layui-input-block" id="button"></div>
				</div>
			</div>

		</div>
	</div>

	<jsp:include page="/context/js-tags.jsp" />
	<script type="text/javascript"
		src="<%=basePath%>/static/js/purchaseOrder/info.js"></script>
</body>
</html>