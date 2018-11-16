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
			<li class="layui-this"><a href="<%=%>/charts/commodity">商品统计</a></li>
			<li><a href="<%=%>/charts/member">会员统计</a></li>
			<li><a href="<%=%>/count/countSpecationSales">规格统计</a></li>
			<li><a href="<%=%>/count/countCommentGrade">评价统计</a></li>
			<li><a href="<%=%>/count/countSystemClick">浏览量统计</a></li>
		</ul>
		<div class="layui-tab-content">
			<div class="layui-form xbs" lay-filter="statCommodity">
				<div class="layui-form-pane">
					<div class="layui-form-item" style="display: inline-block;">
						<label class="layui-form-label xbs768">分类方式</label>
						<div class="layui-input-inline xbs768">
							<select id="style" name="style" lay-filter="style">
								<option value="time">按时间</option>
								<option value="commodity">按商品</option>
							</select>
						</div>
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
						<label class="layui-form-label xbs768 time">日期选择</label>
						<div class="layui-input-inline xbs768 day-choose time">
							<input type="text" readonly="readonly"
								class="layui-input day-choose" value="${statCommodity.day}"
								placeholder="统计日期" name="day">
						</div>
						<div class="layui-input-inline xbs768 month-choose time"
							style="display: none;">
							<input type="text" readonly="readonly"
								class="layui-input month-choose" value="${statCommodity.month}"
								placeholder="统计日期" name="month">
						</div>
						<div class="layui-input-inline xbs768 year-choose time"
							style="display: none;">
							<input type="text" readonly="readonly"
								class="layui-input year-choose" value="${statCommodity.year}"
								placeholder="统计日期" name="year">
						</div>
						<label class="layui-form-label xbs768 commodity">一级分类</label>
						<div class="layui-input-inline xbs768 commodity">
							<select id="parentId" name="parentId" lay-filter="parentId">
								<option value="">请选择一级分类</option>
								<c:forEach items="${categories}" var="category">
									<option value="${category.id}">${category.categoryName}</option>
								</c:forEach>
							</select>
						</div>
						<label class="layui-form-label xbs768 commodity">二级分类</label>
						<div class="layui-input-inline xbs768 commodity">
							<select id="commodityCategoryId" name="commodityCategoryId"
								lay-filter="commodityCategoryId">
								<option value="">请选择二级分类</option>
								<c:forEach items="${secondCategories}" var="secondCategory">
									<option value="${secondCategory.id}">${secondCategory.categoryName}</option>
								</c:forEach>
							</select>
						</div>
						<br />
						<br />
						<br /> <label class="layui-form-label xbs768 commodity">商品选择</label>
						<div class="layui-input-inline xbs768 commodity">
							<select id="commodityId" name="commodityId"
								lay-filter="commodityId">
								<option value="">请选择商品</option>
								<c:forEach items="${commodities}" var="commodity">
									<option value="${commodity.id}">${commodity.commodityName}</option>
								</c:forEach>
							</select>
						</div>
						<label class="layui-form-label xbs768">类型选择</label>
						<div class="layui-input-inline xbs768">
							<select id="type" name="type" lay-filter="type">
								<option value="count">销售量</option>
								<option value="payMoney">销售额</option>
							</select>
						</div>
						<div class="layui-input-inline xbs768">
							<button class="layui-btn btn-search" lay-submit=""
								lay-filter="sreach">
								<i class="layui-icon">&#xe615;</i>
							</button>
						</div>
					</div>
				</div>
				</form>
				<xblock>
				<div class="layui-tab-item layui-show"
					style="position: relative; width: 45%; float: left;">
					<div id="line" style="height: 500px; width: 100%;"></div>
				</div>
				<div class="layui-tab-item layui-show"
					style="position: relative; width: 45%; float: left;">
					<div id="bar" style="height: 500px; width: 100%;"></div>
				</div>
			</div>
		</div>
	</div>
<%-- 	<jsp:include page="/context/js-tags.jsp" /> --%>
	<script type="text/javascript"
		src="<%=%>/plug-in/echarts/echarts.min.js"></script>
	<script type="text/javascript"
		src="<%=%>/plug-in/js/charts/commodity.js"></script>
</body>
</html>