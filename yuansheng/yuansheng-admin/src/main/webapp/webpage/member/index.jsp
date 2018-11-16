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
				action="<%=%>/member">
				<div class="layui-form-pane">
					<div class="layui-form-item" style="display: inline-block;">
						<label class="layui-form-label xbs768">时间范围</label>
						<div class="layui-input-inline xbs768">
							<input type="text" readonly="readonly" class="layui-input"
								value="${member.startTime}" placeholder="开始日" name="startTime">
						</div>
						<div class="layui-input-inline xbs768">
							<input type="text" readonly="readonly" class="layui-input"
								value="${member.endTime}" placeholder="截止日" name="endTime">
						</div>
						<div class="layui-input-inline xbs768">
							<input type="text" name="nickname" value="${member.nickname}"
								placeholder="请输入会员名" autocomplete="off" class="layui-input">
						</div>
						<div class="layui-input-inline xbs768">
							<select id="status" state="${member.status}" name="status"
								lay-filter="status">
								<option value="">请选择用户状态</option>
								<option value="0"
									<c:if test="${member.status==0}">selected="selected"</c:if>>已登录</option>
								<option value="1"
									<c:if test="${member.status==1}">selected="selected"</c:if>>未登录</option>
							</select>
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
							<th>ID</th>
							<th>会员名</th>
							<th>头像</th>
							<th>性别</th>
							<th>手机号</th>
							<th>登录状态</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${pagination.items}" var="item">
							<tr>
								<td>${item.id}</td>
								<td>${item.nickname}</td>
								<td><div class="x-img">
										<img alt="" src="<%=%>${item.avatar}" height="50px"
											width="70px">
									</div></td>
								<td>
								<c:if test="${item.sex==0}">未知</c:if>
								<c:if test="${item.sex==1}">男</c:if>
								<c:if test="${item.sex==2}">女</c:if></td>
								<td>${item.mobile}</td>
								<td><c:choose>
										<c:when test="${item.status == 0}">
											<span class="layui-btn layui-btn-normal layui-btn-mini">
												已登陆 </span>
										</c:when>
										<c:otherwise>
											<span class="layui-btn layui-btn-danger layui-btn-mini">
												未登录 </span>
										</c:otherwise>
									</c:choose></td>
									<td><a href="<%=%>/member/information?id=${item.id}"
									class="layui-btn layui-btn-small" title="查看"><i
										class="layui-icon">&#xe62a;</i></a></td>
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
		src="<%=%>/plug-in/js/member/index.js"></script>
</body>
</html>