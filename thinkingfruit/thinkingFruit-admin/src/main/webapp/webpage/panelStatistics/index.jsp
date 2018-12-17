<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/context/begin-tags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/context/css-tags.jsp" />
<link rel="stylesheet"
	href="<%=basePath%>/static/css/statistics/count.css">
<link rel="stylesheet"
	href="<%=basePath%>/static/css/statistics/border.css">

<style>
.bottom-left-table {
	width: 100%;
}

.list-table {
	width: 100%;
	float: left;
	margin-right: 1%;
}

.bit-4 {
	width: 18.5%;
	margin-bottom: 10px;
}

.layui-card-header {
	font-size: 20px;
}

.layui-badge {
	line-height: 20px;
}

tr {
	background-color: #fff;
}

th {
	background-color: #fff;
}

legend {
	font-size: 24px;
	color: black
}
</style>
</head>
<body>
	<div class="layui-tab layui-tab-brief main-tab-container"
		style="margin-top: 20px; margin-left: 18px">
		<shiro:hasPermission name="total:statistic">
			<fieldset class="layui-elem-field layui-field-title"
				style="margin-top: 30px;">
				<legend>流量统计</legend>
			</fieldset>
			<div class="layui-row layui-col-space15" style="width: 99%;">
				<div class="layui-col-sm6 layui-col-md3">
					<div class="layui-card">
						<div class="layui-card-header">
							总代理数 <span class="layui-badge layui-bg-blue layuiadmin-badge">总</span>
						</div>
						<div class="layui-card-body layuiadmin-card-list">
							<p class="layuiadmin-big-font memberTotal">9,999,666</p>
						</div>
					</div>
				</div>
				<div class="layui-col-sm6 layui-col-md3">
					<div class="layui-card">
						<div class="layui-card-header">
							总订单量 <span class="layui-badge layui-bg-blue layuiadmin-badge">总</span>
						</div>
						<div class="layui-card-body layuiadmin-card-list">
							<p class="layuiadmin-big-font orderTotal">33,555</p>
						</div>
					</div>
				</div>
				<div class="layui-col-sm6 layui-col-md3">
					<div class="layui-card">
						<div class="layui-card-header">
							交易总金额 <span class="layui-badge layui-bg-blue layuiadmin-badge">总</span>
						</div>
						<div class="layui-card-body layuiadmin-card-list">

							<p class="layuiadmin-big-font transactionTotal">999,666</p>
						</div>
					</div>
				</div>
				<div class="layui-col-sm6 layui-col-md3">
					<div class="layui-card">
						<div class="layui-card-header">
							销售总商品 <span class="layui-badge layui-bg-blue layuiadmin-badge">总</span>
						</div>
						<div class="layui-card-body layuiadmin-card-list">
							<p class="layuiadmin-big-font commodityTotal">66,666</p>
						</div>
					</div>
				</div>
				<div class="layui-col-sm6 layui-col-md3">
					<div class="layui-card">
						<div class="layui-card-header">
							本月销售金额<span class="layui-badge layui-bg-green layuiadmin-badge">月</span>
						</div>
						<div class="layui-card-body layuiadmin-card-list">
							<p class="layuiadmin-big-font transactionTotalMonth">9,999,666</p>
						</div>
					</div>
				</div>
				<div class="layui-col-sm6 layui-col-md3">
					<div class="layui-card">
						<div class="layui-card-header">
							昨日销售金额 <span class="layui-badge layui-bg-cyan layuiadmin-badge">日</span>
						</div>
						<div class="layui-card-body layuiadmin-card-list">
							<p class="layuiadmin-big-font transactionTotalDay">33,555</p>
						</div>
					</div>
				</div>
				<div class="layui-col-sm6 layui-col-md3">
					<div class="layui-card">
						<div class="layui-card-header">
							新加代理数 <span class="layui-badge layui-bg-cyan layuiadmin-badge">日</span>
						</div>
						<div class="layui-card-body layuiadmin-card-list">

							<p class="layuiadmin-big-font newMember">999,666</p>
						</div>
					</div>
				</div>
				<div class="layui-col-sm6 layui-col-md3">
					<div class="layui-card">
						<div class="layui-card-header">
							总提现数<span class="layui-badge layui-bg-blue layuiadmin-badge">总</span>
						</div>
						<div class="layui-card-body layuiadmin-card-list">

							<p class="layuiadmin-big-font cashTotal">66,666</p>
						</div>
					</div>
				</div>
			</div>

			<fieldset class="layui-elem-field layui-field-title"
				style="margin-top: 30px;">
				<legend>流量趋势</legend>
			</fieldset>
			<div class="bottom-left-table">
				<shiro:hasPermission name="total:statistic">
					<div class="layui-col-sm6"
						style="width: 48.5%; margin-right: 1%; margin-left: -1%;">
						<table class="list-table" style="table-layout: fixed;">
							<thead>
								<tr>
									<th>总订单量</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>
										<div class="layui-tab-item layui-show"
											style="position: relative; width: 100%; float: left;">
											<div id="orderTotal" style="height: 300px; width: 100%;"></div>
										</div>
									</td>
								</tr>
							</tbody>
						</table>
					</div>
					<div class="layui-col-sm6" style="width: 48.5%;">
						<table class="list-table" style="table-layout: fixed;">
							<thead>
								<tr>
									<th>总交易金额</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>
										<div class="layui-tab-item layui-show"
											style="position: relative; width: 100%; float: left;">
											<div id="transactionTotal"
												style="height: 300px; width: 100%;"></div>
										</div>
									</td>
								</tr>
							</tbody>
						</table>
					</div>
				</shiro:hasPermission>
				<fieldset class="layui-elem-field layui-field-title"
					style="margin-top: 30px;">
					<legend>全国大数据</legend>
				</fieldset>
				<shiro:hasPermission name="total:statistic">
					<table class="list-table"
						style="table-layout: fixed; width: 98%; margin-left: -1%;">
						<thead>
							<tr>
								<th>各个省订单数量</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>
									<div class="layui-tab-item layui-show"
										style="position: relative; width: 100%; float: left;">

										<div class="layui-tab-item layui-show">
											<div id="main" style="height: 600px; width: 100%;"></div>
										</div>
									</div>
								</td>
							</tr>
						</tbody>
					</table>
				</shiro:hasPermission>
			</div>
	</div>
	</shiro:hasPermission>
	<jsp:include page="/context/js-tags.jsp" />
	<script type="text/javascript"
		src="<%=basePath%>/static/plugin/echarts/echarts.min.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>/static/plugin/chart/chart.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>/static/plugin/echarts/map/data.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>/static/plugin/echarts/map/china.js"></script>


	<script type="text/javascript"
		src="<%=basePath%>/static/js/panelStatistics/index.js"></script>
</body>
</html>