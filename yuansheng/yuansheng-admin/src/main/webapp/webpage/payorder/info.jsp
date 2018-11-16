<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@ include file="/context/begin-tags.jsp"%> --%>
<!DOCTYPE html>
<html>
<head>
<%-- <jsp:include page="/context/css-tags.jsp" /> --%>
</head>
<body>
	<div class="layui-tab layui-tab-brief main-tab-container"
		style="margin-top: 20px">
		<div class="layui-tab-content">
			<div class="layui-tab-item layui-show">
				<div class="layui-form-item">
					<label class="layui-form-label">订单号</label>
					<div class="layui-input-inline input-custom-width">
						<input type="text" name="orderRandomNumber"
							value="${refund.orderRandomNumber}" lay-verify="required"
							autocomplete="off" readonly="readonly" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">退款类型</label>
					<div class="layui-input-inline input-custom-width">
						<input type="text" name="refundType"
							value="<c:if test='${refund.refundType==0}'>仅退款</c:if><c:if test='${refund.refundType==1}'>退货退款</c:if>"
							lay-verify="required" autocomplete="off" readonly="readonly"
							class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">退款图片</label>
					<div class="layui-input-inline input-custom-width">
						<img alt=" " border="none" name="refundImagePath"
							src="<%=%>${refund.refundImagePath}" width="70px"
							height="40px">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">退款理由</label>
					<div class="layui-input-inline input-custom-width">
						<textarea name="refundContent" lay-verify="" autocomplete="off"
							class="layui-textarea">${refund.refundContent}</textarea>
					</div>
				</div>
				<c:if test="${refund.status==0}">
					<a class="layui-btn btn-choose" lay-submit="" lay-filter="agree"
						status="2" title="同意" style="margin-left: 100px;">同意</a>
					<a status="3" lay-filter="disagree"
						class="layui-btn layui-btn-small btn-choose" title="不同意"
						style="margin-left: 300px; position: relative; top: -38px;">不同意</a>
				</c:if>
				<c:if test="${refund.status!=0}">
					<div class="layui-form-item">
						<label class="layui-form-label">审核状态</label>
						<div class="layui-input-inline input-custom-width">
							<input type="text" name="status"
								value="<c:if test='${refund.status==2}'>同意</c:if><c:if test='${refund.status==3}'>不同意</c:if>"
								lay-verify="required" autocomplete="off" readonly="readonly"
								class="layui-input">
						</div>
					</div>
				</c:if>
			</div>
		</div>
	</div>
<%-- 	<jsp:include page="/context/js-tags.jsp" /> --%>
	<script type="text/javascript"
		src="<%=%>/plug-in/js/payorder/info.js"></script>
</body>
</html>