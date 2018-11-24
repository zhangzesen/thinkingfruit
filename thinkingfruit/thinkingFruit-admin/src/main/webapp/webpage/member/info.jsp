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
				<li class="layui-this">会员详情</li>
			</ul>
		    <div class="layui-form" style="margin-top: 10px;">
				<div class="layui-form-item">
					<label class="layui-form-label">昵称</label>
					<div class="layui-input-inline input-custom-width">
						<input type="text" name="nicknameStr" 
							value="" autocomplete="off" readonly="readonly"
							class="layui-input">
					</div>
				</div>
				
				<div class="layui-form-item">
					<label class="layui-form-label">性别</label>
					<div class="layui-input-inline input-custom-width">
						<input type="text" name="gender" 
							value="" autocomplete="off" readonly="readonly"
							class="layui-input">
					</div>
				</div>
				
				<div class="layui-form-item">
					<label class="layui-form-label">手机号</label>
					<div class="layui-input-inline input-custom-width">
						<input type="text" name="mobile" 
							value="" autocomplete="off" readonly="readonly"
							class="layui-input">
					</div>
				</div>
				
				<div class="layui-form-item">
					<label class="layui-form-label">省</label>
					<div class="layui-input-inline input-custom-width">
						<input type="text" name="country" 
							value="" autocomplete="off" readonly="readonly"
							class="layui-input">
					</div>
				</div>
				
				<div class="layui-form-item">
					<label class="layui-form-label">市</label>
					<div class="layui-input-inline input-custom-width">
						<input type="text" name="city" 
							value="" autocomplete="off" readonly="readonly"
							class="layui-input">
					</div>
				</div>
				
				<div class="layui-form-item">
						<label class="layui-form-label">身份证</label>
						<div class="layui-input-inline input-custom-width">
							<input type="text" name="identityNo"
								value="" autocomplete="off" placeholder="请输入身份证"
								class="layui-input">
					    </div>
				</div>
			
				<div class="layui-form-item">
					<label class="layui-form-label">上级id</label>
					<div class="layui-input-inline input-custom-width">
						<input type="text" name="parentMemberId" 
							value="" autocomplete="off" readonly="readonly"
							class="layui-input">
					</div>
				</div>
			</div>
		</div>
		</div>
	</div>
	<jsp:include page="/context/js-tags.jsp" />
	<script type="text/javascript"
		src="<%=basePath%>/static/js/member/info.js"></script>
</body>
</html>