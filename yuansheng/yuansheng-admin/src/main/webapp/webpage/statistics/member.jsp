<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@ include file="/context/begin-tags.jsp"%> --%>
<!DOCTYPE html>
<html>
<head>
<%-- <jsp:include page="/context/css-tags.jsp" /> --%>
</head>
<body>
<div style="margin-top: 20px;" class="layui-tab layui-tab-brief">
	<ul class="layui-tab-title" style="margin-left: 10px;">
			<li><a href="<%=%>/statistics/site">总统计</a></li>
			<li><a
				href="<%=%>/statistics/commodity">商品统计</a></li>
			<li class="layui-this"><a href="<%=%>/statistics/member">会员统计</a></li>
		</ul>
		<div class="layui-tab-content">
			<form class="layui-form xbs" method="get" lay-filter="statMember"
				action="<%=%>/statistics/member">
				<div class="layui-form-pane">
					<div class="layui-form-item" style="display: inline-block;">
						<label class="layui-form-label xbs768">查询方式</label>
						<div class="layui-input-inline xbs768">
							<select id="choose" choose="${statMember.choose}"
								name="choose" lay-filter="choose">
								<option value="day" <c:if test="${statMember.choose=='day'}">selected="selected"</c:if>>按天查询</option>
								<option value="month" <c:if test="${statMember.choose=='month'}">selected="selected"</c:if>>按月查询</option>
								<option value="year" <c:if test="${statMember.choose=='year'}">selected="selected"</c:if>>按年查询</option>
							</select>
						</div>
						<label class="layui-form-label xbs768">日期选择</label>
						<div class="layui-input-inline xbs768 day-choose">
							<input type="text" readonly="readonly" class="layui-input day-choose"
								value="${statMember.day}" placeholder="统计日期"
								name="day">
						</div>
						<div class="layui-input-inline xbs768 month-choose" style="display: none;">
							<input type="text" readonly="readonly" class="layui-input month-choose"
								value="${statMember.month}" placeholder="统计日期"
								name="month">
						</div>
						<div class="layui-input-inline xbs768 year-choose" style="display: none;">
							<input type="text" readonly="readonly" class="layui-input year-choose"
								value="${statMember.year}" placeholder="统计日期"
								name="year">
						</div>
						<div class="layui-input-inline xbs768">
							<input type="text" name="memberName" value="${statMember.memberName}"
								placeholder="请输入用户名" autocomplete="off" class="layui-input">
						</div>
						<div class="layui-input-inline xbs768" style="width: 50px">
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
							<th>分享数</th>
							<th>支付额</th>
							<th>日期</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${pagination.items}" var="item">
							<tr>
								<td>${item.id}</td>
								<td>${item.memberName}</td>
								<td>${item.totalShareCount}</td>
								<td>${item.totalPayMoney}</td>
								<td><c:if test="${statMember.choose=='day'}">
										${item.day}
									</c:if> <c:if test="${statMember.choose=='month'}">${item.month}</c:if> <c:if
										test="${statMember.choose=='year'}">${item.year}</c:if></td>
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
		src="<%=%>/plug-in/js/statistics/member.js"></script>
</body>
</html>