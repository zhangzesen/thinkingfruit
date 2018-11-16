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
				action="<%=%>/scroll">
				<div class="layui-form-pane">
					<div class="layui-form-item" style="display: inline-block;">
						<label class="layui-form-label xbs768">时间范围</label>
						<div class="layui-input-inline xbs768">
							<input type="text" readonly="readonly" class="layui-input"
								value="${scrollImage.startTime}" placeholder="开始日"
								name="startTime">
						</div>
						<div class="layui-input-inline xbs768">
							<input type="text" readonly="readonly" class="layui-input"
								value="${scrollImage.endTime}" placeholder="截止日" name="endTime">
						</div>
						<div class="layui-input-inline xbs768">
							<input type="text" name="scrollImageName"
								value="${scrollImage.scrollImageName}" placeholder="请输入图片名"
								autocomplete="off" class="layui-input">
						</div>
						<div class="layui-input-inline xbs768">
							<input type="text" name="scrollImageDescription"
								value="${scrollImage.scrollImageDescription}"
								placeholder="请输入图片描述" autocomplete="off" class="layui-input">
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
			<button id="layui-btn"
				class="layui-btn layui-btn-danger btn-delete-batch ">
				<i class="layui-icon">&#xe640;</i>批量删除
			</button>
			<button class="layui-btn layui-btn-warm btn-reset">
				<i class="layui-icon">&#x1002;</i>重置
			</button>
			<button class="layui-btn layui-btn-normal btn-set">
				<i class="layui-icon">&#xe608;</i>添加
			</button>
			<span class="x-right"
				style="line-height: 40px; float: right; font-size: 20px">共有数据：${pagination.totalItemsCount}
				条</span> </xblock>
			<div class="layui-tab-item layui-show">
				<table class="list-table">
					<thead>
						<tr>
							<th><input type="checkbox" class="check-all"></th>
							<th>ID</th>
							<th>图片名</th>
							<th>商品名</th>
							<th>图片</th>
							<th>图片描述</th>
							<th width="150px;">操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${pagination.items}" var="item">
							<tr>
								<td><input type="checkbox" value="${item.id}"
									class="check-item"></td>
								<td>${item.id}</td>
								<td>${item.scrollImageName}</td>
								<td><c:if test="${item.commodityId==0}">首页轮播图</c:if> <c:forEach
										items="${commodities}" var="commodity">
										<c:if test="${commodity.id==item.commodityId}">${commodity.commodityName}</c:if>
									</c:forEach></td>
								<td><div class="x-img">
										<img src="<%=%>${item.scrollImagePath}" alt=""
											height="50px" width="70px">
									</div></td>
								<td>${item.scrollImageDescription}</td>
								<td><a href="<%=%>/scroll/set?id=${item.id}"
									class="layui-btn layui-btn-small" title="编辑"><i
										class="layui-icon"></i></a> <a
									class="layui-btn layui-btn-small layui-btn-danger del_btn"
									scroll-id="${item.id}" title="删除"><i class="layui-icon"></i></a>
								</td>
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
		src="<%=%>/plug-in/js/scroll/index.js"></script>
</body>
</html>