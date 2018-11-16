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
			<li class="layui-this"><a
				href="<%=%>/statistics/commodity">商品统计</a></li>
			<li><a href="<%=%>/statistics/member">会员统计</a></li>
		</ul>
		<div class="layui-tab-content">
			<form class="layui-form xbs" method="get" lay-filter="statCommodity"
				action="<%=%>/statistics/commodity">
				<div class="layui-form-pane">
					<div class="layui-form-item" style="display: inline-block;">
						<label class="layui-form-label xbs768">查询方式</label>
						<div class="layui-input-inline xbs768">
							<select id="choose" choose="${statCommodity.choose}"
								name="choose" lay-filter="choose">
								<option value="day"
									<c:if test="${statCommodity.choose=='day'}">selected="selected"</c:if>>按天查询</option>
								<option value="month"
									<c:if test="${statCommodity.choose=='month'}">selected="selected"</c:if>>按月查询</option>
								<option value="year"
									<c:if test="${statCommodity.choose=='year'}">selected="selected"</c:if>>按年查询</option>
							</select>
						</div>
						<label class="layui-form-label xbs768">日期选择</label>
						<div class="layui-input-inline xbs768 day-choose">
							<input type="text" readonly="readonly"
								class="layui-input day-choose" value="${statCommodity.day}"
								placeholder="统计日期" name="day">
						</div>
						<div class="layui-input-inline xbs768 month-choose"
							style="display: none;">
							<input type="text" readonly="readonly"
								class="layui-input month-choose" value="${statCommodity.month}"
								placeholder="统计日期" name="month">
						</div>
						<div class="layui-input-inline xbs768 year-choose"
							style="display: none;">
							<input type="text" readonly="readonly"
								class="layui-input year-choose" value="${statCommodity.year}"
								placeholder="统计日期" name="year">
						</div>
						<label class="layui-form-label xbs768">一级分类</label>
						<div class="layui-input-inline xbs768">
							<select id="parentId" parentId="${statCommodity.parentId}"
								name="parentId" lay-filter="parentId">
								<option value="">请选择一级分类</option>
								<c:forEach items="${categories}" var="category">
									<option value="${category.id}"
										<c:if test="${statCommodity.parentId==category.id}">selected="selected"</c:if>>${category.categoryName}</option>
								</c:forEach>
							</select>
						</div>
						<label class="layui-form-label xbs768">二级分类</label>
						<div class="layui-input-inline xbs768">
							<select id="commodityCategoryId"
								commodityCategoryId="${statCommodity.commodityCategoryId}"
								name="commodityCategoryId" lay-filter="commodityCategoryId">
								<option value="">请选择二级分类</option>
								<c:forEach items="${secondCategories}" var="secondCategory">
									<option value="${secondCategory.id}"
										<c:if test="${statCommodity.commodityCategoryId==secondCategory.id}">selected="selected"</c:if>>${secondCategory.categoryName}</option>
								</c:forEach>
							</select>
						</div>
						<br /> <br /> <br /> <label class="layui-form-label xbs768">商品选择</label>
						<div class="layui-input-inline xbs768">
							<select id="commodityId"
								commodityId="${statCommodity.commodityId}" name="commodityId"
								lay-filter="commodityId">
								<option value="">请选择商品名</option>
								<c:forEach items="${commodities}" var="commodity">
									<option value="${commodity.id}"
										<c:if test="${statCommodity.commodityId==commodity.id}">selected="selected"</c:if>>${commodity.commodityName}</option>
								</c:forEach>
							</select>
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
							<th>商品名</th>
							<th>商品图片</th>
							<th>销售量</th>
							<th>销售额</th>
							<th>日期</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${pagination.items}" var="item">
							<tr>
								<td>${item.id}</td>
								<td>${item.commodityName}</td>
								<td><div class="x-img">
										<img alt="" src="<%=%>${item.commodityImagePath}"
											height="50px" width="70px">
									</div></td>
								<td>${item.totalCount}</td>
								<td>${item.totalMoney}</td>
								<td><c:if test="${statCommodity.choose=='day'}">
										${item.day}
									</c:if> <c:if test="${statCommodity.choose=='month'}">${item.month}</c:if>
									<c:if test="${statCommodity.choose=='year'}">${item.year}</c:if></td>
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
		src="<%=%>/plug-in/js/statistics/commodity.js"></script>
</body>
</html>