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
						<c:if test="${scrollImage == null}">
							<li class="layui-this">添加图片</li>
						</c:if>
						<c:if test="${scrollImage != null}">
							<li class="layui-this">修改图片</li>
						</c:if>
					</ul>
					<div class="layui-tab-content">
						<div class="layui-tab-item layui-show">
							<div class="layui-form">
								<c:if test="${scrollImage != null}">
									<input name="id" value="${scrollImage.id}" hidden="hidden">
								</c:if>
								<div class="layui-form-item">
									<label class="layui-form-label">图片名</label>
									<div class="layui-input-inline input-custom-width">
										<input type="text" name="scrollImageName"
											value="${scrollImage.scrollImageName}" lay-verify="required"
											autocomplete="off" placeholder="请输入图片名" class="layui-input">
									</div>
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label"> <span class="x-red">*</span>图片上传
									</label>
									<div class="layui-input-inline input-custom-width layui-upload">
										<div class="layui-box layui-upload-button" style="float: left; left: 0px; border: 1px solid #D2D2D2; width: 150px; background-color: #98a3b9; text-align: center;"><span
												class="layui-upload-icon"><i class="layui-icon"></i>上传图片</span>
										</div>
											<input id="uploadImage" name="uploadImage"
												class="layui-input image-upload" type="file"
												lay-verify="required" autocomplete="off" style="opacity: 0;"> 
												
									</div>
									<div class="layui-input-inline input-custom-width">
										<img alt=" " border="none"
											src="<%=%>${scrollImage.scrollImagePath}"
											width="70px" height="40px">
									</div>
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">图片路径</label>
									<div class="layui-input-inline input-custom-width">
										<input type="text" name="scrollImagePath"
											value="${scrollImage.scrollImagePath}" lay-verify="required"
											autocomplete="off" class="layui-input" readonly="readonly">
									</div>
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">图片描述</label>
									<div class="layui-input-inline input-custom-width">
										<input type="text" name="scrollImageDescription"
											value="${scrollImage.scrollImageDescription}"
											lay-verify="required" autocomplete="off"
											placeholder="请输入图片描述" class="layui-input">
									</div>
								</div>
							</div>
							<div class="layui-form-item">
								<div class="layui-input-block">
									<c:if test="${scrollImage == null}">
										<button class="layui-btn scroll-set" lay-submit=""
											lay-filter="cate_add">立即添加</button>
									</c:if>
									<c:if test="${scrollImage != null}">
										<button class="layui-btn scroll-set" lay-submit=""
											lay-filter="cate_add">立即修改</button>
									</c:if>
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
		src="<%=%>/plug-in/js/scroll/set.js"></script>
</body>
</html>