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
			<li><a
				href="<%=%>/charts/commodity">商品统计</a></li>
			<li class="layui-this"><a href="<%=%>/charts/member">会员统计</a></li>
			<li><a href="<%=%>/count/countSpecationSales">规格统计</a></li>
			<li><a href="<%=%>/count/countCommentGrade">评价统计</a></li>
			<li><a href="<%=%>/count/countSystemClick">浏览量统计</a></li>
		</ul>
		<div class="layui-tab-content">
			<div class="layui-form xbs" lay-filter="statCommodity">
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
						<div class="layui-input-inline xbs768">
							<input type="text" name="memberName" value="${statMember.memberName}"
								placeholder="请输入用户名" autocomplete="off" class="layui-input">
						</div>
						<label class="layui-form-label xbs768">类型选择</label>
						<div class="layui-input-inline xbs768">
							<select id="type" name="type" lay-filter="type">
								<option value="totalShareCount">分享次数</option>
								<option value="totalPayMoney">销售额</option>
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
<%-- 	<jsp:include page="/context/js-tags.jsp" /> --%>
	<script type="text/javascript"
		src="<%=%>/plug-in/echarts/echarts.min.js"></script>
	<script type="text/javascript"
		src="<%=%>/plug-in/js/charts/member.js"></script>
</body>
</html>