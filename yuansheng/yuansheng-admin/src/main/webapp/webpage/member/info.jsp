<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@ include file="/context/begin-tags.jsp"%> --%>
<!DOCTYPE html>
<html>
<head>
<%-- <jsp:include page="/context/css-tags.jsp" /> --%>
</head>
<body>
	<div class="layui-tab layui-tab-brief main-tab-container">
		<div class="layui-tab-content">
			<div class="layui-tab-item layui-show">
			<c:if test="${comments.size()==0}"><h1>暂时还未评论</h1></c:if>
				<c:forEach var="comment" items="${comments}">
					<table class="list-table" style="margin-bottom: 0;">
						<thead>
							<tr>
								<th>ID</th>
								<th>商品名</th>
								<th>商品图片</th>
								<th>评论等级</th>
								<th>消息内容</th>
								<th>上传图片</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>${comment.id}</td>
								<td>${comment.commodityName}</td>
								<td><div class="x-img">
										<img alt="" src="<%=%>${comment.commodityImagePath}"
											height="50px" width="70px">
									</div></td>
								<td>${comment.level}星</td>
								<td>${comment.commentContent}</td>
								<td><c:forEach items="${comment.images}" var="image">
										<div class="x-img">
											<img alt="" src="<%=%>${image}" height="50px"
												width="70px">
										</div>
									</c:forEach></td>
							</tr>
						</tbody>
					</table>

					<table class="list-table" style="margin-top: 0;">
						<thead>
							<tr>
								<th colspan="2" style="font-size: 20px; text-align: left;">回复消息<span class="show-more layui-nav-more"
									style="float: right; margin-right: 5%;"><i
										class="layui-icon">&#x1002;</i></span></th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td width="20%">姓名</td>
								<td width="80%">内容</td>
							</tr>
							<c:forEach items="${comment.replyContents}" var="replyContent">
								<tr class="comment-show" id="comment-show" style="display:;">
									<td><c:if test="${replyContent.memberId==0}">掌柜回复</c:if>${replyContent.memberName}</td>
									<td>${replyContent.commentContent}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:forEach>
			</div>
		</div>
	</div>
<%-- 	<jsp:include page="/context/js-tags.jsp" /> --%>
	<script type="text/javascript"
		src="<%=%>/plug-in/js/member/info.js"></script>
</body>
</html>