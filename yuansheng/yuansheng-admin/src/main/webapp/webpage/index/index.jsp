<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@ include file="/context/begin-tags.jsp"%> --%>
<!DOCTYPE html>
<html>
<head>
<%-- <jsp:include page="/context/css-tags.jsp" /> --%>
<link rel="stylesheet" href="<%=%>/plug-in/css/task/count.css">
<link rel="stylesheet" href="<%=%>/plug-in/css/user/border.css">
</head>
<body>
	<div class="layui-tab layui-tab-brief main-tab-container"
		style="margin-top: 20px; margin-left: 18px">
		<div>
			<div class="bit-4">
				<div class="x-box-header" style="width: 30%; float: left;">
					<cite class="layui-icon" style="margin-left: 20%; font-size: 30px;">&#xe613;</cite>
				</div>
				<div class="x-box-body"
					style="width: 56%; float: left; text-align: center;">
					<br /> <span style="font-size: 35px;">${statSite.totalMemberCount}</span><br />
					<span style="font-size: 13px;">商城用户</span>
				</div>
			</div>
			<div class="bit-4">
				<div class="x-box-header"
					style="width: 30%; float: left; background: #f8d347;">
					<cite class="layui-icon" style="margin-left: 20%; font-size: 30px;">&#xe641;</cite>
				</div>
				<div class="x-box-body"
					style="width: 56%; float: left; text-align: center;">
					<br /> <span style="font-size: 35px;">${statSite.totalShareCount}</span><br />
					<span style="font-size: 13px;">分享次数</span>
				</div>
			</div>
			<div class="bit-4">
				<div class="x-box-header"
					style="width: 30%; float: left; background: #ff6c60;">
					<cite class="layui-icon" style="margin-left: 20%; font-size: 30px;">&#xe698;</cite>
				</div>
				<div class="x-box-body"
					style="width: 56%; float: left; text-align: center;">
					<br /> <span style="font-size: 35px;">${statSite.totalOrderCount}</span><br />
					<span style="font-size: 13px;">订单量</span>
				</div>
			</div>
			<div class="bit-4">
				<div class="x-box-header"
					style="width: 30%; float: left; background: #FFFF00;">
					<cite class="layui-icon" style="margin-left: 20%; font-size: 30px;">&#xe65e;</cite>
				</div>
				<div class="x-box-body"
					style="width: 56%; float: left; text-align: center;">
					<br /> <span style="font-size: 35px;">${statSite.totalPayMoney}</span><br />
					<span style="font-size: 13px;">交易总金额</span>
				</div>
			</div>
			<div class="bit-4">
				<div class="x-box-header" style="width: 30%; float: left;">
					<cite class="layui-icon" style="margin-left: 20%; font-size: 30px;">&#xe613;</cite>
				</div>
				<div class="x-box-body"
					style="width: 56%; float: left; text-align: center;">
					<br /> <span style="font-size: 35px;">${statSite.totalNewMemberCount}</span><br />
					<span style="font-size: 13px;">新加会员数</span>
				</div>
			</div>
		</div>
		<div class="bottom-left-table">
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
								<div id="totalPayMoney" style="height: 300px; width: 100%;"></div>
							</div></td>
					</tr>
				</tbody>
			</table>
			<br />
			<table class="list-table" style="table-layout: fixed;">
				<thead>
					<tr>
						<th>新增会员量</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>
							<div class="layui-tab-item layui-show"
								style="position: relative; width: 100%; float: left;">
								<div id="totalNewMemberCount"
									style="height: 300px; width: 100%;"></div>
							</div></td>
					</tr>
				</tbody>
			</table>
		</div>

		<div class="bottom-right-table">
			<table class="list-table" style="height: 100%;">
				<thead>
					<tr>
						<th style="height:10px;!important;">热销商品</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><c:forEach items="${commodities}" var="commodity">
								<p style="width: 95%;">
									<a name="content" href="javascript:;" id="">${commodity.commodityName}</a><span
										style="float: right; margin-right: 20px;">${commodity.totalCount}</span>
								</p>
								<hr>
							</c:forEach></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
<%-- 	<jsp:include page="/context/js-tags.jsp" /> --%>
	<script type="text/javascript"
		src="<%=%>/plug-in/echarts/echarts.min.js"></script>
	<script type="text/javascript"
		src="<%=%>/plug-in/js/index/index.js"></script>
</body>
</html>