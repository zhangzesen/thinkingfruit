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
				<table class="list-table">
					<thead>
						<tr>
							<th>ID</th>
							<th>商品名</th>
							<th>顾客名</th>
							<th>评论等级</th>
							<th>消息内容</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>${comment.id}</td>
							<td>${comment.commodityName}</td>
							<td>${comment.memberName}</td>
							<td>${comment.level}星</td>
							<td>${comment.commentContent}</td>
						</tr>
					</tbody>
				</table>
			</div>
			<br>
			
			
			
			<table class="list-table">
				<thead>
					<tr>
						<th colspan="2">回复消息<span class="show-more layui-nav-more" style="float: right; margin-right: 5%; "><i class="layui-icon">&#x1002;</i></span></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td width="20%">姓名</td>
						<td width="80%">内容</td>
					</tr>
					<c:forEach items="${items}" var="item">
						<tr class="comment-show" id="comment-show" style="display: ;">
							<td><c:if test="${item.memberId==0}">掌柜回复</c:if>${item.memberName}</td>
							<td>${item.commentContent}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<br>
			
			

			<table class="list-table">
				<thead>
					<tr>
						<th>添加回复消息</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>
							<form class="layui-form">
								<div class="layui-form-item">
									<script id="editor" name="content" type="text/plain"
										style="height: 350px;"></script>
								</div>
							</form>
						</td>
					</tr>
					<tr>
						<td><button class="layui-btn layui-btn-warm btn-reply">
								<i class="layui-icon">&#x1002;</i>回复
							</button></td>
					</tr>
				</tbody>
			</table>

			<input name="id" type="hidden" value="${comment.id}">

		</div>
	</div>
<%-- 	<jsp:include page="/context/js-tags.jsp" /> --%>
	<script type="text/javascript" charset="utf-8"
		src="<%=%>/plug-in/ueditor/ueditor.config.js"></script>
	<script type="text/javascript" charset="utf-8"
		src="<%=%>/plug-in/ueditor/ueditor.all.min.js"></script>
	<script type="text/javascript" charset="utf-8"
		src="<%=%>/plug-in/ueditor/lang/zh-cn/zh-cn.js"></script>
	<script type="text/javascript"
		src="<%=%>/plug-in/js/comment/set.js"></script>
</body>
</html>