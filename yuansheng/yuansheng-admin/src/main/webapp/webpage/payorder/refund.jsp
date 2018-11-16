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
		<ul class="layui-tab-title main-tab-title">
			<li><a href="<%=%>/payOrder">交易订单</a></li>
			<li class="layui-this"><a href="<%=%>/payOrder/refund">退款订单</a></li>
			<div class="main-tab-item">订单</div>
		</ul>
		<div class="layui-tab-content">
			<form class="layui-form xbs" method="get"
				action="<%=%>/payOrder/refund">
				<div class="layui-form-pane">
					<div class="layui-form-item" style="display: inline-block;">
						<label class="layui-form-label xbs768">时间范围</label>
						<div class="layui-input-inline xbs768">
							<input type="text" readonly="readonly" class="layui-input"
								value="${payOrder.startTime}" placeholder="开始日" name="startTime">
						</div>
						<div class="layui-input-inline xbs768">
							<input type="text" readonly="readonly" class="layui-input"
								value="${payOrder.endTime}" placeholder="截止日" name="endTime">
						</div>
						<div class="layui-input-inline xbs768">
							<input type="text" name="orderRandomNumber"
								value="${payOrder.orderRandomNumber}" placeholder="请输入订单号"
								autocomplete="off" class="layui-input">
						</div>
						<div class="layui-input-inline xbs768">
							<input type="text" name="memberName"
								value="${payOrder.memberName}" placeholder="请输入顾客姓名"
								autocomplete="off" class="layui-input">
						</div>
						<div class="layui-input-inline xbs768">
							<select id="refundStatus" refundStatus="${payOrder.refundStatus}"
								name="refundStatus" lay-filter="refundStatus">
								<option value=""></option>
								<option value="1" <c:if test="${payOrder.refundStatus==1}">selected="selected"</c:if>>申请退款</option>
								<option value="2" <c:if test="${payOrder.refundStatus==2}">selected="selected"</c:if>>已退款</option>
								<option value="3" <c:if test="${payOrder.refundStatus==3}">selected="selected"</c:if>>退款失败</option>
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
							<th>订单号</th>
							<th>顾客姓名</th>
							<th>商品名</th>
							<th>商品图片</th>
							<th>商品规格</th>
							<th>商品单价</th>
							<th>商品数量</th>
							<th>总价</th>
							<th>地址</th>
							<th>备注</th>
							<th>状态</th>
							<th>所属平台</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${pagination.items}" var="item">
							<tr>
								<td rowspan="${item.payOrderEntries.size()+1}">${item.orderRandomNumber}</td>
								<td rowspan="${item.payOrderEntries.size()+1}"><c:if test="${item.platformState==0}">${item.memberName}</c:if><c:if test="${item.platformState==1}">${item.appletMemberName}</c:if></td>
								<td
									style="height: 0px !important; padding-bottom: 0px; padding-top: 0px;"></td>
								<td
									style="height: 0px !important; padding-bottom: 0px; padding-top: 0px;"></td>
								<td
									style="height: 0px !important; padding-bottom: 0px; padding-top: 0px;"></td>
								<td
									style="height: 0px !important; padding-bottom: 0px; padding-top: 0px;"></td>
								<td
									style="height: 0px !important; padding-bottom: 0px; padding-top: 0px;"></td>
								<td rowspan="${item.payOrderEntries.size()+1}">${item.totalPrice}</td>
								<td rowspan="${item.payOrderEntries.size()+1}"><c:if test="${item.platformState==0}">${item.expressAddress}</c:if><c:if test="${item.platformState==1}">${item.appletExpressAddress}</c:if></td>
								<td rowspan="${item.payOrderEntries.size()+1}">${item.remarks}</td>
								<td rowspan="${item.payOrderEntries.size()+1}"><c:choose>
										<c:when test="${item.refundStatus==1}">
											<span class="layui-btn layui-btn-normal layui-btn-mini">
												申请退款 </span>
										</c:when>
										<c:when test="${item.refundStatus==2}">
											<span class="layui-btn layui-btn-normal layui-btn-mini">
												商家已确认 </span>
										</c:when>
										<c:when test="${item.refundStatus==3}">
											<span class="layui-btn layui-btn-normal layui-btn-mini">
												已退款 </span>
										</c:when>
									</c:choose></td>
							    <td rowspan="${item.payOrderEntries.size()+1}"><c:if test="${item.platformState==0}">公众号</c:if><c:if test="${item.platformState==1}">小程序</c:if></td>
								<td rowspan="${item.payOrderEntries.size()+1}"><button
										class="layui-btn input-custom-width send-btn"
										id="${item.id}">查看详情</button></td>
							</tr>
							<c:forEach items="${item.payOrderEntries}" var="payOrderEntry">
								<tr>
									<td>${payOrderEntry.commodityName}</td>
									<td><div class="x-img">
											<img alt=""
												src="<%=%>${payOrderEntry.commodityImagePath}"
												height="50px" width="70px">
										</div></td>
									<td>${payOrderEntry.commoditySpecation}</td>
									<td>${payOrderEntry.commodityPrice}</td>
									<td>${payOrderEntry.commodityNumber}</td>
								</tr>
							</c:forEach>
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
		src="<%=%>/plug-in/js/payorder/refund.js"></script>
</body>
</html>