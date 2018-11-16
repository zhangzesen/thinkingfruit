<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@ include file="/context/begin-tags.jsp"%> --%>
<!DOCTYPE html>
<html>
<head>
<%-- <jsp:include page="/context/css-tags.jsp" /> --%>
</head>
<body>
	<div style="margin-top: 20px;"
		class="layui-tab layui-tab-brief main-tab-container">
		<div class="layui-tab-content">
			<form class="layui-form xbs" method="get" action="">
				<div class="layui-form-pane">
					<div class="layui-form-item" style="display: inline-block;">
						<div class="layui-input-inline xbs768">
								<input type="text" name="commodityName"
									value="${commodity.commodityName}"
									placeholder="请输入宝贝标题" autocomplete="off" class="layui-input">
						</div>
						<div class="layui-input-inline xbs768">
								<input type="text" name="commodityDescription"
									value="${commodity.commodityDescription}"
									placeholder="请输入宝贝卖点" autocomplete="off" class="layui-input">
						</div>
						<div class="layui-input-inline xbs768">
							<input type="text" name="commoditySpecation"
								value="${commodity.commoditySpecation}" placeholder="请输入商品规格"
								autocomplete="off" class="layui-input">
						</div>
						<c:if test="${firstCategoryId == 1}">
							<div class="layui-input-inline xbs768">
								<input type="text" name="gemstonetype"
									value="${commodity.gemstonetype}" placeholder="请输入宝石类型"
									autocomplete="off" class="layui-input">
							</div>
							<div class="layui-input-inline xbs768">
								<input type="text" name="gemstoneOrigin"
									value="${commodity.gemstoneOrigin}" placeholder="请输入宝石产地"
									autocomplete="off" class="layui-input">
							</div>
						</c:if>
						<c:if test="${firstCategoryId==2 || firstCategoryId==3}">
							<div class="layui-input-inline xbs768">
								<input type="text" name="ceramicSpecies"
									value="${commodity.ceramicSpecies}" placeholder="请输入陶瓷种类"
									autocomplete="off" class="layui-input">
							</div>
							<div class="layui-input-inline xbs768">
								<input type="text" name="shape"
									value="${commodity.shape}" placeholder="请输入陶瓷形状"
									autocomplete="off" class="layui-input">
							</div>
							<br/><br/><br/>
							<div class="layui-input-inline xbs768">
								<input type="text" name="producingUnit"
									value="${commodity.producingUnit}" placeholder="请输入陶瓷产区"
									autocomplete="off" class="layui-input">
							</div>
						</c:if>
						<c:if test="${firstCategoryId==5 || firstCategoryId==6}">
							<div class="layui-input-inline xbs768">
								<input type="text" name="theCreator"
									value="${commodity.theCreator}" placeholder="请输入创作者"
									autocomplete="off" class="layui-input">
							</div>
						</c:if>
						<input type="hidden" name="commodityCategoryId" value="${commodityCategoryId}">
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
			<button class="layui-btn layui-btn-danger btn-delete-batch ">
				<i class="layui-icon">&#xe640;</i>批量删除
			</button>
			<button class="layui-btn layui-btn-warm btn-reset">
				<i class="layui-icon">&#x1002;</i>重置
			</button>
			<button class="layui-btn layui-btn-normal btn-add">
				<i class="layui-icon">&#xe61f;</i>添加
			</button>
			<span class="x-right" style="line-height: 40px; float:right;font-size: 20px">共有数据：${pagination.totalItemsCount}
				条</span> </xblock>

			<div class="layui-tab-item layui-show">
				<table class="list-table" width="100%">
					<thead>
						<tr>
						    <th style="text-align: center;width: 5%;"><input type="checkbox" class="check-all"></th>
							<th style="text-align: center;width: 5%;">编号</th>
							<th style="text-align: center;width: 7%;">宝贝标题</th>
							<th style="text-align: center;width: 9%;">商品图片</th>
							<th style="text-align: center;width: 10%;">宝贝卖点</th>
							<th style="text-align: center;width: 8%;">商品规格</th>
							<c:if test="${firstCategoryId == 1}">
							   <th style="text-align: center;width: 8%;">宝石类型</th>
							   <th style="text-align: center;width: 8%;">宝石产地</th>
							</c:if>
							<c:if test="${firstCategoryId==2 || firstCategoryId==3}">
							   <th style="text-align: center;width: 5%;">陶瓷种类</th>
							   <th style="text-align: center;width: 5%;">陶瓷形状</th>
							   <th style="text-align: center;width: 5%;">陶瓷产区</th>
							</c:if>
							<c:if test="${firstCategoryId==5 || firstCategoryId==6}">
							   <th style="text-align: center;width: 5%;">创作者</th>
							</c:if>
							<th style="text-align: center;width: 7%;">商品价格</th>
							<th style="text-align: center;width: 5%;">库存</th>
							<th style="text-align: center;width: 12%;">操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${pagination.items}" var="commodity">
							<tr>
							    <td><input type="checkbox" commoditySpecificationId="${commodity.commoditySpecificationId}" value="${commodity.id}" class="check-item"></td>
								<td>${commodity.id}</td>
								<td>${commodity.commodityName}</td>
								<td><a name="image" commodityName="${commodity.commodityName}" href="javascript:;"><img alt="" src="<%=%>${commodity.coverImagePath}" height="50px" width="70px"></a></td>
								<td style="word-break: break-all;">${commodity.commodityDescription}</td>
								<td>${commodity.commoditySpecation}</td>
								<c:if test="${firstCategoryId == 1}">
								   <td>${commodity.gemstonetype}</td>
								   <td>${commodity.gemstoneOrigin}</td>
								</c:if>
								<c:if test="${firstCategoryId==2 || firstCategoryId==3}">
								   <td>${commodity.ceramicSpecies}</td>
								   <td>${commodity.shape}</td>
								   <td>${commodity.producingUnit}</td>
								</c:if>
								<c:if test="${firstCategoryId==5 || firstCategoryId==6}">
								   <td>${commodity.theCreator}</td>
								</c:if>
								<td>${commodity.commodityPrice}</td>
								<td>${commodity.commoditySpecationStock}</td>
								<td style="text-align: center;"><a
									href="<%=%>/commodity/set?id=${commodity.id}&commoditySpecificationId=${commodity.commoditySpecificationId}&firstCategoryId=${firstCategoryId}&commodityCategoryId=${commodityCategoryId}"
									class="layui-btn layui-btn-small" title="编辑"><i
										class="layui-icon">&#xe60a;</i></a> 
									<a class="layui-btn layui-btn-small layui-btn-danger del_btn" name="delete"
									commodity-id="${commodity.id}" title="删除" commoditySpecification-id="${commodity.commoditySpecificationId}" commodityCategory-id="${commodityCategoryId}"><i
										class="layui-icon">&#xe640;</i></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<input type="hidden" name="firstCategoryId" value="${firstCategoryId}">
			<input type="hidden" name="commodityCategoryId" value="${commodityCategoryId}">
			<input type="hidden" name="totalPageCount"
				value="${pagination.totalPageCount}"> <input type="hidden"
				name="pageNum" value="${pagination.pageNum}"> <input
				type="hidden" name="totalItemsCount"
				value="${pagination.totalItemsCount}">
			<div id="page"></div>
		</div>
	</div>
<%-- 	<jsp:include page="/context/js-tags.jsp"/> --%>
	<script type="text/javascript" src="<%= %>/plug-in/js/commodity/index.js"></script>
</body>
</html>