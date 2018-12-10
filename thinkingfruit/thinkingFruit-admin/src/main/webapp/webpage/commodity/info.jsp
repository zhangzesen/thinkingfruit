<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/context/begin-tags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/context/css-tags.jsp" />
</head>
<body>
	<div class="layui-tab-brief main-tab-container">
		<div class="layui-tab-content">
			<div class="layui-tab-item layui-show">
				<div class="layui-tab layui-tab-card">
					<ul class="layui-tab-title">
						<li class="layui-this">添加商品</li>
					</ul>
					
					<div class="layui-tab-content">
						<div class="layui-tab-item layui-show">
							<div class="layui-form">
								<div class="layui-form-item">
									<label class="layui-form-label">商品标题</label>
									<div class="layui-input-inline input-custom-width">
										<input type="text" name="name" value="" autocomplete="off"
											placeholder="请输入商品名称" class="layui-input">
									</div>
								</div>
								
								
								<div class="layui-form-item">
									<label class="layui-form-label"> <span class="x-red">*</span>产品图片
									</label>
									<div class="layui-input-inline input-custom-width">
										<img alt=" " border="none" name="cover" src="" width="150px"
											height="120px">
									</div>
								</div>


								<div class="layui-upload">
									<blockquote class="layui-elem-quote layui-quote-nm"
										style="margin-top: 10px; margin-left: 130px;">
										详情图预览：
										<div class="layui-upload-list" id="details"></div>
									</blockquote>
								</div>
										
								
														
								<div class="layui-form-item">
									<label class="layui-form-label">商品卖点</label>
									<div class="layui-input-inline input-custom-width">
										<textarea name="description" lay-verify="" autocomplete="off"
											placeholder="请输入商品描述" class="layui-textarea"></textarea>
									</div>
								</div>
								
								<div class="layui-form-item">
									<label class="layui-form-label">VIP价格</label>
									<div class="layui-input-inline input-custom-width">
										<input type="text" name="fifthPrice" value="0"
											readonly="readonly" autocomplete="off" class="layui-input">
									</div>
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">SVIP价格</label>
									<div class="layui-input-inline input-custom-width">
										<input type="text" name="fourthPrice" value="0"
											readonly="readonly" autocomplete="off" class="layui-input">
									</div>
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">总监价格</label>
									<div class="layui-input-inline input-custom-width">
										<input type="text" name="thirdPrice" value="0"
											readonly="readonly" autocomplete="off" class="layui-input">
									</div>
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">春事价格</label>
									<div class="layui-input-inline input-custom-width">
										<input type="text" name="secondPrice" value="0"
											readonly="readonly" autocomplete="off" class="layui-input">
									</div>
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">联创价格</label>
									<div class="layui-input-inline input-custom-width">
										<input type="text" name="firstPrice" value="0"
											readonly="readonly" autocomplete="off" class="layui-input">
									</div>
								</div>
								
								<div class="layui-form-item">
									<label class="layui-form-label" style="text-align: center;">商品批准文号</label>
									<div class="layui-input-inline input-custom-width">
										<input type="text" name="approvalNumber"
											value=""
											autocomplete="off" placeholder="商品批准文号(选填)" class="layui-input">
									</div>
								</div>
								
								<input type="hidden" name="coverImagePath"
									value="" lay-verify="required"
									autocomplete="off" class="layui-input" readonly="readonly">
								

							</div>
							<div class="layui-form-item">
								<div class="layui-input-block" id="btn">
									<input onclick="history.go(-1)" type="button" value="返回"
										class="layui-btn layui-btn-lg">
								</div>
							</div>
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
		src="<%=basePath%>/static/js/commodity/info.js"></script>
</body>
</html>