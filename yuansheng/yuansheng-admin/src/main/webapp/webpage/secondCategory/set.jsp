<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@ include file="/context/begin-tags.jsp"%> --%>
<!DOCTYPE html>
<html>
<head>
<%-- <jsp:include page="/context/css-tags.jsp" /> --%>
</head>
<body>
	<div class="layui-tab-brief main-tab-container"">
		<div class="layui-tab-content">
			<div class="layui-tab layui-tab-card">
				<ul class="layui-tab-title">
					<c:if test="${secondCategoryInfo == null}">
						<li class="layui-this">添加二级分类</li>
					</c:if>
					<c:if test="${secondCategoryInfo != null}">
						<li class="layui-this">修改二级分类</li>
					</c:if>
				</ul>
				<div class="layui-form" style="margin-top: 10px;">
					<div class="layui-form-item">
						<label class="layui-form-label">分类名称</label>
						<div class="layui-input-inline input-custom-width">
							<input type="text" name="secondCategoryName"
								<c:if test="${secondCategoryInfo != null}"> value="${secondCategoryInfo.categoryName}" </c:if>
								lay-verify="required" autocomplete="off" placeholder="请输入二级分类名称"
								class="layui-input">
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
								src="<%=%>${secondCategoryInfo.categoryImagePath}"
								width="70px" height="40px">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">图片路径</label>
						<div class="layui-input-inline" style="width: 300px;">
							<input type="text" readonly="readonly"
								value="${secondCategoryInfo.categoryImagePath}"
								placeholder="请上传图片" name="secondCategoryImagePath"
								autocomplete="off" class="layui-input">
						</div>
					</div>

					<div class="layui-form-item">
						<label class="layui-form-label">上级分类名</label>
						<div class="layui-input-block"
							style="width: 300px; text-align: center;">
							<select name="firstCategory" lay-filter="reportType">
								<option value="-1">请选择上级分类名</option>
								<c:forEach items="${firstCategory}" var="first">
									<option value="${first.id}"
										<c:if test="${secondCategoryInfo.parentId==first.id}">selected</c:if>>${first.categoryName}</option>
								</c:forEach>
							</select>
						</div>
					</div>

					<c:if test="${secondCategoryInfo != null}">
						<input name="id" value="${secondCategoryInfo.id}" hidden="hidden">
					</c:if>

					<div class="layui-form-item">
						<label class="layui-form-label">二级分类描述</label>
						<div class="layui-input-inline input-custom-width">
							<textarea name="secondCategoryDescription" lay-verify=""
								autocomplete="off" placeholder="请输入分类描述" class="layui-textarea"><c:if
									test="${secondCategoryInfo != null}">${secondCategoryInfo.categoryDescription}</c:if></textarea>
						</div>
					</div>

					<div class="layui-form-item" style="margin-left: 100px;">
						<div class="layui-input-block">
							<c:if test="${secondCategoryInfo == null}">
								<button class="layui-btn" lay-submit="" lay-filter="cate_add">立即添加</button>
							</c:if>
							<c:if test="${secondCategoryInfo != null}">
								<button class="layui-btn" lay-submit="" lay-filter="cate_add">立即修改</button>
							</c:if>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
<%-- 	<jsp:include page="/context/js-tags.jsp" /> --%>
	<script src="<%=%>/plug-in/layui/layui.js" charset="utf-8"></script>
	<script type="text/javascript"
		src="<%=%>/plug-in/js/secondCategory/set.js"></script>
</body>
</html>