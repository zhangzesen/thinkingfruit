<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@ include file="/context/begin-tags.jsp"%> --%>
<!DOCTYPE html>
<html>
<head>
<%-- <jsp:include page="/context/css-tags.jsp" /> --%>
</head>
<body>
	<div class="layui-upload">
		<blockquote class="layui-elem-quote layui-quote-nm"
			style="margin-top: 10px; margin-left: 10px;width:540px;">
			轮播图预览：
			<div class="layui-upload-list" id="preview" style="width:540px;">
				<c:forEach items="${commodityInfo.previewImagePath}"
					var="previewImagePath">
					<img alt=" " border="none" name="preview"
						src="<%=%>${previewImagePath}" style="max-width: 100px;">
				</c:forEach>
			</div>
			详情图预览：
			<div class="layui-upload-list" id="details" style="width:540px;">
				<c:forEach items="${commodityInfo.detailsImagePath}"
					var="detailsImagePath">
					<img alt=" " border="none" name="details"
						src="<%=%>${detailsImagePath}" style="max-width: 100px;">
				</c:forEach>
			</div>
		</blockquote>
	</div>
</body>
</html>