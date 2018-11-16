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
						<label class="layui-form-label xbs768">时间范围</label>
						<div class="layui-input-inline xbs768">
							<input type="text" readonly="readonly" class="layui-input"
								value="${secondCategory.startTime}" placeholder="开始日"
								name="startTime">
						</div>
						<div class="layui-input-inline xbs768">
							<input type="text" readonly="readonly" class="layui-input"
								value="${secondCategory.endTime}" placeholder="截止日" name="endTime">
						</div>
						<div class="layui-input-inline xbs768">
								<input type="text" name="categoryName"
									value="${secondCategory.categoryName}"
									placeholder="请输入分类名" autocomplete="off" class="layui-input">
						</div>
						<div class="layui-input-inline xbs768">
								<input type="text" name="firstCategoryName"
									value="${secondCategory.firstCategoryName}"
									placeholder="请输入上级分类名" autocomplete="off" class="layui-input">
						</div>
						<div class="layui-input-inline xbs768">
							<input type="text" name="categoryDescription"
								value="${secondCategory.categoryDescription}"
								placeholder="请输入分类描述" autocomplete="off" class="layui-input">
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
						    <th style="text-align: center; width: 50px;"><input type="checkbox" class="check-all"></th>
							<th style="text-align: center; width: 50px;">编号</th>
							<th style="text-align: center;">二级分类名</th>
							<th style="text-align: center;">分类图片</th>
							<th style="text-align: center; width: 150px;">上级分类名</th>
							<th style="text-align: center; width: 200px;">分类描述</th>
							<th style="text-align: center; width: 200px;">操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${pagination.items}" var="secondCategory">
							<tr>
							    <td><input type="checkbox" name="${secondCategory.categoryName}" value="${secondCategory.id}" class="check-item"></td>
								<td>${secondCategory.id}</td>
								<td>${secondCategory.categoryName}</td>
								<td><img alt="" src="<%=%>${secondCategory.categoryImagePath}" height="50px" width="70px"></td>
								<td>${secondCategory.firstCategoryName}</td>
								<td style="word-break: break-all;">${secondCategory.categoryDescription}</td>
								<td style="text-align: center;"><a
									href="<%=%>/secondCategory/set?id=${secondCategory.id}"
									class="layui-btn layui-btn-small" title="编辑"><i
										class="layui-icon">&#xe60a;</i></a> 
									<a class="layui-btn layui-btn-small layui-btn-danger del_btn" name="delete"
									secondCategory-id="${secondCategory.id}" title="删除" secondCategory-name="${secondCategory.categoryName}"><i
										class="layui-icon">&#xe640;</i></a></td>
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
<%-- 	<jsp:include page="/context/js-tags.jsp"/> --%>
	<script type="text/javascript" src="<%=%>/plug-in/js/secondCategory/index.js"></script>
</body>
</html>