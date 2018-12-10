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
						<li class="layui-this">添加商品</li>
					</ul>
					
					<div class="layui-tab-content">
						<div class="layui-tab-item layui-show">
							<div class="layui-form">
								<div class="layui-form-item">
									<label class="layui-form-label">商品标题</label>
									<div class="layui-input-inline input-custom-width">
										<input type="text" name="name"
											value="" required="true" diyCheck="商品名称不能为空"
											autocomplete="off" placeholder="请输入商品名称" class="layui-input">
									</div>
								</div>
								
								
								<div class="layui-form-item">
								    <label class="layui-form-label"> <span class="x-red">*</span>图片上传
									</label>
									<div class="layui-input-inline input-custom-width layui-upload">
										<div class="layui-box layui-upload-button"
											style="float: left; left: 0px; border: 1px solid #D2D2D2; width: 150px; background-color: #98a3b9; text-align: center;">
											<span class="layui-upload-icon"><i class="layui-icon"></i>商品展示图片上传</span>
										</div>
										<input id="uploadImage" name="uploadImage"
											class="layui-input image-upload" type="file"
											autocomplete="off" style="opacity: 0;">
									</div>
									<div class="layui-input-inline input-custom-width">
										<img alt=" " border="none" name="cover"
											src="" width="70px"
											height="40px">
									</div>
								</div>
								
                                
                                <div class="layui-form-item">
									<div class="layui-input-inline input-custom-width layui-upload" style="margin-left: 130px;">
										<div class="layui-box layui-upload-button"
											style="float: left; left: 0px; border: 1px solid #D2D2D2; width: 150px; background-color: #98a3b9; text-align: center;">
											<span class="layui-upload-icon"><i class="layui-icon"></i>商品详情图上传</span>
										</div>
										<input class="layui-input image-upload" id="detailsImage" name="detailsImage" type="file" multiple="multiple"
										autocomplete="off" style="opacity: 0;">
									</div>
									<div class="layui-input-inline input-custom-width">
										<button class="layui-btn layui-btn-warm" name="detailsReset">重置</button>
									</div>
								</div>
								<div class="layui-upload">
                                  <blockquote class="layui-elem-quote layui-quote-nm" style="margin-top: 10px;margin-left: 130px;">
                                                                                          详情图预览：
                                    <div class="layui-upload-list" id="details">
                                            
                                    </div>
                                  </blockquote>
                                </div>
										
								
														
								<div class="layui-form-item">
									<label class="layui-form-label">商品卖点</label>
									<div class="layui-input-inline input-custom-width">
										<textarea name="description" lay-verify="" required="true" diyCheck="商品描述不能为空"
											autocomplete="off" placeholder="请输入商品描述"
											class="layui-textarea"></textarea>
									</div>
								</div>

								<div class="layui-form-item">
									<label class="layui-form-label">VIP价格</label>
									<div class="layui-input-inline input-custom-width">
										<input type="text" name="fifthPrice"
											value="" required="true" diyCheck="请输入正确的价格" diyRule="^(0|[1-9][0-9]{0,9})(\.[0-9]{1,2})?$"
											autocomplete="off" placeholder="请输入VIP价格" class="layui-input">
									</div>
								</div>
								
								<div class="layui-form-item">
									<label class="layui-form-label">SVIP价格</label>
									<div class="layui-input-inline input-custom-width">
										<input type="text" name="fourthPrice"
											value="" required="true" diyCheck="请输入正确的价格" diyRule="^(0|[1-9][0-9]{0,9})(\.[0-9]{1,2})?$"
											autocomplete="off" placeholder="请输入SVIP价格" class="layui-input">
									</div>
								</div>
								
								<div class="layui-form-item">
									<label class="layui-form-label">总监价格</label>
									<div class="layui-input-inline input-custom-width">
										<input type="text" name="thirdPrice"
											value="" required="true" diyCheck="请输入正确的价格" diyRule="^(0|[1-9][0-9]{0,9})(\.[0-9]{1,2})?$"
											autocomplete="off" placeholder="请输入总监价格" class="layui-input">
									</div>
								</div>
								
								<div class="layui-form-item">
									<label class="layui-form-label">春事价格</label>
									<div class="layui-input-inline input-custom-width">
										<input type="text" name="secondPrice"
											value="" required="true" diyCheck="请输入正确的价格" diyRule="^(0|[1-9][0-9]{0,9})(\.[0-9]{1,2})?$"
											autocomplete="off" placeholder="请输入春事价格" class="layui-input">
									</div>
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">联创价格</label>
									<div class="layui-input-inline input-custom-width">
										<input type="text" name="firstPrice"
											value="" required="true" diyCheck="请输入正确的价格" diyRule="^(0|[1-9][0-9]{0,9})(\.[0-9]{1,2})?$"
											autocomplete="off" placeholder="请输入联创价格" class="layui-input">
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
									<button class="layui-btn brand-set" lay-submit=""
										lay-filter="cate_add">立即添加</button>
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
		src="<%=basePath%>/static/js/commodity/set.js"></script>
</body>
</html>