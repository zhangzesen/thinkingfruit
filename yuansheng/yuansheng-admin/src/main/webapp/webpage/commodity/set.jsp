<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@ include file="/context/begin-tags.jsp"%> --%>
<!DOCTYPE html>
<html>
<head>
<%-- <jsp:include page="/context/css-tags.jsp" /> --%>
<link rel="stylesheet" href="<%=%>/plug-in/layui/css/layui.css" />
</head>
<body>
	<div class="layui-tab-brief main-tab-container">
		<div class="layui-tab-content">
			<div class="layui-tab-item layui-show">
				<div class="layui-tab layui-tab-card">
					<ul class="layui-tab-title">
						<c:if test="${commodityInfo == null}">
							<li class="layui-this">添加商品</li>
						</c:if>
						<c:if test="${commodityInfo != null}">
							<li class="layui-this">修改商品</li>
						</c:if>
					</ul>
					<input type="hidden" name="firstCategoryId" value="${firstCategoryId}">
					<input type="hidden" name="commodityCategoryId" value="${commodityCategoryId}">
					<div class="layui-tab-content">
						<div class="layui-tab-item layui-show">
							<div class="layui-form">
								<c:if test="${commodityInfo != null}">
									<input name="id" value="${commodityInfo.id}" hidden="hidden">
								</c:if>
								<div class="layui-form-item">
									<label class="layui-form-label">宝贝标题</label>
									<div class="layui-input-inline input-custom-width">
										<input type="text" name="commodityName"
											value="${commodityInfo.commodityName}" lay-verify="required"
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
											lay-verify="required" autocomplete="off" style="opacity: 0;">
									</div>
									<div class="layui-input-inline input-custom-width">
										<img alt=" " border="none" name="cover"
											src="<%=%>${commodityInfo.coverImagePath}" width="70px"
											height="40px">
									</div>
								</div>
								
								<div class="layui-form-item">
									<div class="layui-input-inline input-custom-width layui-upload" style="margin-left: 110px;">
										<div class="layui-box layui-upload-button"
											style="float: left; left: 0px; border: 1px solid #D2D2D2; width: 150px; background-color: #98a3b9; text-align: center;">
											<span class="layui-upload-icon"><i class="layui-icon"></i>商品轮播图上传</span>
										</div>
										<input class="layui-input image-upload" id="carouselImage" name="carouselImage" type="file" multiple="multiple"
										lay-verify="required" autocomplete="off" style="opacity: 0;">
									</div>
									<div class="layui-input-inline input-custom-width">
										<button class="layui-btn layui-btn-warm" name="previewReset">重置</button>
									</div>
								</div>
								<div class="layui-upload">
                                  <blockquote class="layui-elem-quote layui-quote-nm" style="margin-top: 10px;margin-left: 110px;">
                                                                                          轮播图预览：
                                    <div class="layui-upload-list" id="preview">
											<c:forEach items="${commodityInfo.previewImagePath}"
												var="previewImagePath">
												<img alt=" " border="none" name="preview"
													src="<%=%>${previewImagePath}"
													style="max-width:100px;">
											</c:forEach>
										</div>
                                  </blockquote>
                                </div>
                                
                                <div class="layui-form-item">
									<div class="layui-input-inline input-custom-width layui-upload" style="margin-left: 110px;">
										<div class="layui-box layui-upload-button"
											style="float: left; left: 0px; border: 1px solid #D2D2D2; width: 150px; background-color: #98a3b9; text-align: center;">
											<span class="layui-upload-icon"><i class="layui-icon"></i>商品详情图上传</span>
										</div>
										<input class="layui-input image-upload" id="detailsImage" name="detailsImage" type="file" multiple="multiple"
										lay-verify="required" autocomplete="off" style="opacity: 0;">
									</div>
									<div class="layui-input-inline input-custom-width">
										<button class="layui-btn layui-btn-warm" name="detailsReset">重置</button>
									</div>
								</div>
								<div class="layui-upload">
                                  <blockquote class="layui-elem-quote layui-quote-nm" style="margin-top: 10px;margin-left: 110px;">
                                                                                          详情图预览：
                                    <div class="layui-upload-list" id="details">
                                            <c:forEach items="${commodityInfo.detailsImagePath}"
												var="detailsImagePath">
												<img alt=" " border="none" name="details"
													src="<%=%>${detailsImagePath}"
													style="max-width:100px;">
											</c:forEach>
                                    </div>
                                  </blockquote>
                                </div>
																
								<div class="layui-form-item">
									<label class="layui-form-label">宝贝卖点</label>
									<div class="layui-input-inline input-custom-width">
										<textarea name="commodityDescription" lay-verify=""
											autocomplete="off" placeholder="请输入商品描述"
											class="layui-textarea"><c:if
												test="${commodityInfo != null}">${commodityInfo.commodityDescription}</c:if></textarea>
									</div>
								</div>
							
								<c:if test="${firstCategoryId==1}">
									<div class="layui-form-item">
										<label class="layui-form-label">宝石类型</label>
										<div class="layui-input-inline input-custom-width">
											<input type="text" name="gemstonetype"
												value="${commodityInfo.gemstonetype}" lay-verify="required"
												autocomplete="off" placeholder="请输入宝石类型" class="layui-input">
										</div>
									</div>
									<div class="layui-form-item">
										<label class="layui-form-label">宝石产地</label>
										<div class="layui-input-inline input-custom-width">
											<input type="text" name="gemstoneOrigin"
												value="${commodityInfo.gemstoneOrigin}" lay-verify="required"
												autocomplete="off" placeholder="请输入宝石产地" class="layui-input">
										</div>
									</div>
								</c:if>
								
								<c:if test="${firstCategoryId==2 || firstCategoryId==3}">
								    <div class="layui-form-item">
										<label class="layui-form-label">陶瓷种类</label>
										<div class="layui-input-inline input-custom-width">
											<input type="text" name="ceramicSpecies"
												value="${commodityInfo.ceramicSpecies}" lay-verify="required"
												autocomplete="off" placeholder="请输入陶瓷种类" class="layui-input">
										</div>
									</div>
									<div class="layui-form-item">
										<label class="layui-form-label">陶瓷形状</label>
										<div class="layui-input-inline input-custom-width">
											<input type="text" name="shape"
												value="${commodityInfo.shape}" lay-verify="required"
												autocomplete="off" placeholder="请输入陶瓷形状" class="layui-input">
										</div>
									</div>
									<div class="layui-form-item">
										<label class="layui-form-label">陶瓷产区</label>
										<div class="layui-input-inline input-custom-width">
											<input type="text" name="producingUnit"
												value="${commodityInfo.producingUnit}" lay-verify="required"
												autocomplete="off" placeholder="请输入陶瓷产区" class="layui-input">
										</div>
									</div>
								</c:if>
								
								<c:if test="${firstCategoryId==5 || firstCategoryId==6}">
								    <div class="layui-form-item">
										<label class="layui-form-label">创作者</label>
										<div class="layui-input-inline input-custom-width">
											<input type="text" name="theCreator"
												value="${commodityInfo.theCreator}" lay-verify="required"
												autocomplete="off" placeholder="请输入创作者" class="layui-input">
										</div>
									</div>
								</c:if>
								
								<div class="layui-form-item">
									<label class="layui-form-label">商品规格</label>
									<div class="layui-input-inline input-custom-width">
										<input type="text" name="commoditySpecation"
											value="${commodityInfo.commoditySpecation}" lay-verify="required"
											autocomplete="off" placeholder="请输入商品规格" class="layui-input">
									</div>
								</div>

								<div class="layui-form-item">
									<label class="layui-form-label">商品库存</label>
									<div class="layui-input-inline input-custom-width">
										<input type="text" name="commoditySpecationStock"
											value="${commodityInfo.commoditySpecationStock}" lay-verify="required"
											autocomplete="off" placeholder="请输入商品库存" class="layui-input">
									</div>
								</div>

								<div class="layui-form-item">
									<label class="layui-form-label">商品价格</label>
									<div class="layui-input-inline input-custom-width">
										<input type="text" name="commodityPrice"
											value="${commodityInfo.commodityPrice}" lay-verify="required"
											autocomplete="off" placeholder="请输入商品价格" class="layui-input">
									</div>
								</div>

								<div class="layui-form-item">
									<label class="layui-form-label" style="text-align: center;">商品批准文号</label>
									<div class="layui-input-inline input-custom-width">
										<input type="text" name="commodityApprovalNumber"
											value="${commodityInfo.commodityApprovalNumber}" lay-verify="required"
											autocomplete="off" placeholder="商品批准文号" class="layui-input">
									</div>
								</div>
								<input type="hidden" name="coverImagePath"
									value="${commodityInfo.coverImagePath}" lay-verify="required"
									autocomplete="off" class="layui-input" readonly="readonly">
								
								<input type="hidden" name="previewImagePath"
									value="${commodityInfo.previewImagePathCollection}" lay-verify="required"
									autocomplete="off" class="layui-input" readonly="readonly">
									
								<input type="hidden" name="detailsImagePath"
									value="${commodityInfo.detailsImagePathCollection}" lay-verify="required"
									autocomplete="off" class="layui-input" readonly="readonly">
								
								<input type="hidden" name="commoditySpecificationId"
									value="${commodityInfo.commoditySpecificationId}" lay-verify="required"
									autocomplete="off" class="layui-input" readonly="readonly">
								
							</div>
							<div class="layui-form-item">
								<div class="layui-input-block">
									<c:if test="${commodityInfo == null}">
										<button class="layui-btn brand-set" lay-submit=""
											lay-filter="cate_add">立即添加</button>
									</c:if>
									<c:if test="${commodityInfo != null}">
										<button class="layui-btn brand-set" lay-submit=""
											lay-filter="cate_add">立即修改</button>
									</c:if>
									<button class="layui-btn layui-btn-warm btn-reset">
										<i class="layui-icon">&#x1002;</i>重置
									</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
<%-- 	<jsp:include page="/context/js-tags.jsp" /> --%>
	<script src="<%=%>/plug-in/layui/layui.js" charset="utf-8"></script>
	<script type="text/javascript"
		src="<%=%>/plug-in/js/commodity/set.js"></script>
</body>
</html>