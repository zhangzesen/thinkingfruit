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
			<form class="layui-form xbs" method="get"
				action="<%=%>/comment">
				<div class="layui-form-pane">
					<div class="layui-form-item" style="display: inline-block;">
						<label class="layui-form-label xbs768">时间范围</label>
						<div class="layui-input-inline xbs768">
							<input type="text" readonly="readonly" class="layui-input"
								value="${comment.startTime}" placeholder="开始日" name="startTime">
						</div>
						<div class="layui-input-inline xbs768">
							<input type="text" readonly="readonly" class="layui-input"
								value="${comment.endTime}" placeholder="截止日" name="endTime">
						</div>
						<div class="layui-input-inline xbs768">
							<input type="text" name="memberName"
								value="${comment.memberName}" placeholder="请输入顾客名"
								autocomplete="off" class="layui-input">
						</div>

						<div class="layui-input-inline xbs768">
							<input type="text" name="commodityName"
								value="${comment.commodityName}" placeholder="请输入商品名"
								autocomplete="off" class="layui-input">
						</div>
						<div class="layui-input-inline xbs768">
							<select id="level" state="${comment.level}" name="level"
								lay-filter="level">
								<option value="">请输入评论等级</option>
								<option value="1"
									<c:if test="${comment.level==1}">selected="selected"</c:if>>1星</option>
								<option value="2"
									<c:if test="${comment.level==2}">selected="selected"</c:if>>2星</option>
								<option value="3"
									<c:if test="${comment.level==3}">selected="selected"</c:if>>3星</option>
								<option value="4"
									<c:if test="${comment.level==4}">selected="selected"</c:if>>4星</option>
								<option value="5"
									<c:if test="${comment.level==5}">selected="selected"</c:if>>5星</option>
							</select>
						</div>
						<div class="hide-display" style="display: none">
							<div class="layui-input-inline xbs768">
								<select id="status" state="${comment.status}" name="status"
									lay-filter="status">
									<option value="">请输入评论状态</option>
									<option value="0"
										<c:if test="${comment.status==0}">selected="selected"</c:if>>已评论</option>
									<option value="1"
										<c:if test="${comment.status==1}">selected="selected"</c:if>>未评论</option>
								</select>
							</div>
						</div>
						<div class="layui-input-inline xbs768" style="width: 80px">
							<button class="layui-btn btn-serach" lay-submit=""
								lay-filter="sreach">
								<i class="layui-icon">&#xe615;</i>
							</button>
						</div>
					</div>
				</div>
			</form>
			<xblock>
			<button
				class="layui-btn layui-btn-danger btn-loadmore btn-sreach-more">
				<i class="layui-icon">&#xe615;</i>搜索更多
			</button>
			<button class="layui-btn layui-btn-warm btn-reset">
				<i class="layui-icon">&#x1002;</i>重置
			</button>
			<span class="x-right"
				style="line-height: 40px; float: right; font-size: 20px">共有数据：${pagination.totalItemsCount}
				条</span> </xblock>
			<div class="layui-tab-item layui-show">
				<table class="list-table">
					<thead>
						<tr>
							<th>订单号</th>
							<th>商品名</th>
							<th>商品图片</th>
							<th>顾客名</th>
							<th>顾客头像</th>
							<th>等级</th>
							<th>消息内容</th>
							<th>回复状态</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${pagination.items}" var="item">
							<tr>
								<td>${item.orderRandomNumber}</td>
								<td>${item.commodityName}</td>
								<td><div class="x-img">
										<img alt="" src="<%=%>${item.commodityImagePath}"
											height="50px" width="70px">
									</div></td>
								<td>${item.memberName}</td>
								<td><div class="x-img">
										<img alt="" src="<%=%>${item.memberImagePath}"
											height="50px" width="70px">
									</div></td>
								<td>${item.level}星</td>
								<td>${item.commentContent}<c:forEach items="${item.images}" var="image"><div class="x-img">
										<img alt="" src="<%=%>${image}"
											height="50px" width="70px">
									</div></c:forEach></td>
								<td><c:choose>
										<c:when test="${item.status == 0}">
											<span class="layui-btn layui-btn-normal layui-btn-mini">
												未回复 </span>
										</c:when>
										<c:otherwise>
											<span class="layui-btn layui-btn-danger layui-btn-mini">
												已回复 </span>
										</c:otherwise>
									</c:choose></td>
								<td><a href="<%=%>/comment/set?id=${item.id}"
									class="layui-btn layui-btn-small" title="查看详情"><i
										class="layui-icon"></i></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<input type="hidden" name="totalPageCount"
				value="${pagination.totalPageCount}"> <input type="hidden"
				name="pageNum" value="${pagination.pageNum}"> <input
				type="hidden" name="totalItemsCount"
				value="${pagination.totalItemsCount}">
			<div id="page"></div>
		</div>
	</div>
<%-- 	<jsp:include page="/context/js-tags.jsp" /> --%>
	<script type="text/javascript"
		src="<%=%>/plug-in/js/comment/index.js"></script>
</body>
</html>