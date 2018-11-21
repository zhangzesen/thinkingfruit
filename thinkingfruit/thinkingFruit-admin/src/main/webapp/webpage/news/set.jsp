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
						<li class="layui-this">添加资讯</li>
						
					</ul>
					<div class="layui-tab-content">
						<div class="layui-tab-item layui-show">
							<form class="layui-form">
								
								<input name="id" value="" hidden="hidden">
								
								<div class="layui-form-item">
									<label class="layui-form-label">资讯名</label>
									<div class="layui-input-inline input-custom-width">
										<input type="text" name="name" value="" required="true" diyCheck="资讯名不能为空"
											autocomplete="off" placeholder="请输入咨询名"
											class="layui-input">
									</div>
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">资讯标题</label>
									<div class="layui-input-inline input-custom-width">
										<input type="text" name="title" value=""
											autocomplete="off" required="true" diyCheck="标题不能为空"
											placeholder="请输入咨询标题" class="layui-input">
									</div>
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label"> <span class="x-red">*</span>展示图片上传
									</label>

									<div class="layui-input-inline input-custom-width layui-upload">
										<div class="layui-box layui-upload-button"
											style="float: left; left: 0px; border: 1px solid #D2D2D2; width: 150px; background-color: #98a3b9; text-align: center;">
											<span class="layui-upload-icon"><i class="layui-icon"></i>上传图片</span>
										</div>
										<input id="uploadImage" name="uploadImage"
											class="layui-input image-upload" type="file"
											lay-verify="required" autocomplete="off" style="opacity: 0;">
									</div>
									<div class="layui-input-inline input-custom-width">
										<img alt=" " border="none"
											src="" width="70px"
											height="40px">
									</div>
								</div>
								
<!-- 								<div class="layui-form-item"> -->
<!-- 									<label class="layui-form-label">图片路径</label> -->
<!-- 									<div class="layui-input-inline input-custom-width"> -->
										<input type="text" name="coverImagePath"
											value="" hidden="hidden"
											autocomplete="off" readonly="readonly">
<!-- 									</div> -->
<!-- 								</div> -->
								
								<div class="layui-form-item">
									<label class="layui-form-label">资讯描述</label>
									<div class="layui-input-inline input-custom-width">
										<input type="text" name="description"
											value="" required="true" diyCheck="资讯描述不能为空"
											autocomplete="off" placeholder="请输入咨询描述" class="layui-input">
									</div>
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">资讯内容</label>
									<form class="layui-form">
										<div class="layui-form-item">
											<script id="editor" name="content" type="text/plain"
												style="position:relative; left:130px; top:-35px; height: 350px; width: 400px;">
											<c:if test="${news != null}">${news.newsContent}</c:if>
											</script>
										</div>
									</form>
								</div>
							</form>
							<div class="layui-form-item">
								<div class="layui-input-block">
									<button class="layui-btn news-set" lay-submit=""
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
	<script type="text/javascript" charset="utf-8"
		src="<%=basePath%>/static/plugin/ueditor/ueditor.config.js"></script>
	<script type="text/javascript" charset="utf-8"
		src="<%=basePath%>/static/plugin/ueditor/ueditor.all.min.js"></script>
	<script type="text/javascript" charset="utf-8"
		src="<%=basePath%>/static/plugin/ueditor/lang/zh-cn/zh-cn.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>/static/js/news/set.js"></script>
</body>
</html>

