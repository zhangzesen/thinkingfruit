<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/context/begin-tags.jsp"%>
<!DOCTYPE html>
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
	<div class="layui-tab-brief main-tab-container">
		<div class="layui-tab-content">
			<div class="layui-tab-item layui-show">
				<div class="layui-tab layui-tab-card">
					<ul class="layui-tab-title">
						<li class="layui-this">修改代理分佣比例</li>
					</ul>
					
					<div class="layui-tab-content">
						<div class="layui-tab-item layui-show">
							<div class="layui-form">
								<div class="layui-form-item">
									<label class="layui-form-label">代理级别</label>
									<div class="layui-input-inline input-custom-width">
										<input type="text" name="level"
											autocomplete="off" class="layui-input" readonly="readonly">
									</div>
								</div>
								
								<div class="layui-form-item">
									<label class="layui-form-label">代理名称</label>
									<div class="layui-input-inline input-custom-width">
										<input type="text" name="levelName" readonly="readonly"
											value="" required="true" diyCheck="代理名称不能为空"
											autocomplete="off" placeholder="请输入代理名称" class="layui-input">
									</div>
								</div>
								
								<div class="layui-form-item">
									<label class="layui-form-label">平级分佣/邀请奖比例</label>
									<div class="layui-input-inline input-custom-width">
										<input type="text" name="levelingDiscount" required="true"
										 value="" autocomplete="off" diyRule="^[0-9]+.?[0-9]*$" diyCheck="输入的不是数字"
										placeholder="请输入商品价格" class="layui-input" lay-verType="alert">
									</div>
								</div>
								

								<div class="layui-form-item">
									<label class="layui-form-label">跨级分佣/邀请奖比例</label>
									<div class="layui-input-inline input-custom-width">
										<input type="text" name="crossLevelDiscount"
											value="" required="true" diyCheck="请输入正确的跨级比例" diyRule="^[0-9]+.?[0-9]*$"
											autocomplete="off" placeholder="请输入跨级分佣/邀请奖比例" class="layui-input">
									</div>
								</div>
								
								<div class="layui-form-item">
									<label class="layui-form-label">反向级别分佣/邀请奖比例</label>
									<div class="layui-input-inline input-custom-width">
										<input type="text" name="reverseLevelDiscount"
											value="" required="true" diyCheck="请输入正确的反向比例" diyRule="^[0-9]+.?[0-9]*$"
											autocomplete="off" placeholder="请输入跨反向级别分佣/邀请奖比例" class="layui-input">
									</div>
								</div>
								
								
								<div class="layui-form-item">
									<div class="layui-input-block"
										style="margin-left: 10%; margin-bottom: 5%">
										<button class="layui-btn layui-btn-lg" type="button" lay-submit="确认修改"
									lay-filter="site_edit"></button>
									</div>
								</div>
							</div>
						</div>
					</div>
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
	<script type="text/javascript"
		src="<%=basePath%>/static/js/site/set.js"></script>
</body>
</html>