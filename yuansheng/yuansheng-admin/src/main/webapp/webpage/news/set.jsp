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
						<c:if test="${news == null}">
							<li class="layui-this">添加品牌</li>
						</c:if>
						<c:if test="${news != null}">
							<li class="layui-this">修改品牌</li>
						</c:if>
					</ul>
					<div class="layui-tab-content">
						<div class="layui-tab-item layui-show">
							<div class="layui-form">
								<c:if test="${news != null}">
									<input name="id" value="${news.id}" hidden="hidden">
								</c:if>
								<div class="layui-form-item">
									<label class="layui-form-label">咨询名</label>
									<div class="layui-input-inline input-custom-width">
										<input type="text" name="newsName" value="${news.newsName}"
											lay-verify="required" autocomplete="off" placeholder="请输入咨询名"
											class="layui-input">
									</div>
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">资讯标题</label>
									<div class="layui-input-inline input-custom-width">
										<input type="text" name="newsTitle" value="${news.newsTitle}"
											lay-verify="required" autocomplete="off"
											placeholder="请输入咨询标题" class="layui-input">
									</div>
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label"> <span class="x-red">*</span>图片上传
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
											src="<%=%>${news.newsImagePath}" width="70px"
											height="40px">
									</div>
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">图片路径</label>
									<div class="layui-input-inline input-custom-width">
										<input type="text" name="newsImagePath"
											value="${news.newsImagePath}" lay-verify="required"
											autocomplete="off" class="layui-input" readonly="readonly">
									</div>
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">资讯描述</label>
									<div class="layui-input-inline input-custom-width">
										<input type="text" name="newsDescription"
											value="${news.newsDescription}" lay-verify="required"
											autocomplete="off" placeholder="请输入咨询描述" class="layui-input">
									</div>
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">资讯内容</label>
									<form class="layui-form">
										<div class="layui-form-item">
											<script id="editor" name="content" type="text/plain"
												style="position:relative; left:110px; top:-35px; height: 150px; width: 400px;">
											<c:if test="${news != null}">${news.newsContent}</c:if>
											</script>
										</div>
									</form>
								</div>
							</div>
							<div class="layui-form-item">
								<div class="layui-input-block">
									<c:if test="${news == null}">
										<button class="layui-btn news-set" lay-submit=""
											lay-filter="cate_add">立即添加</button>
									</c:if>
									<c:if test="${news != null}">
										<button class="layui-btn news-set" lay-submit=""
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
	<script type="text/javascript" charset="utf-8"
		src="<%=%>/plug-in/ueditor/ueditor.config.js"></script>
	<script type="text/javascript" charset="utf-8"
		src="<%=%>/plug-in/ueditor/ueditor.all.min.js"></script>
	<script type="text/javascript" charset="utf-8"
		src="<%=%>/plug-in/ueditor/lang/zh-cn/zh-cn.js"></script>
	<script src="<%=%>/plug-in/layui/layui.js" charset="utf-8"></script>
	<script type="text/javascript"
		src="<%=%>/plug-in/js/news/set.js"></script>
</body>
</html>

