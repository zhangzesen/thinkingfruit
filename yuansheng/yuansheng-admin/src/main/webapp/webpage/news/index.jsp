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
			<form class="layui-form xbs" method="get" action="<%=%>/news">
				<div class="layui-form-pane">
					<div class="layui-form-item" style="display: inline-block;">
						<label class="layui-form-label xbs768">时间范围</label>
						<div class="layui-input-inline xbs768">
							<input type="text" readonly="readonly" class="layui-input"
								value="${news.startTime}" placeholder="开始日" name="startTime">
						</div>
						<div class="layui-input-inline xbs768">
							<input type="text" readonly="readonly" class="layui-input"
								value="${news.endTime}" placeholder="截止日" name="endTime">
						</div>
						<div class="layui-input-inline xbs768">
							<input type="text" name="newsTitle" value="${news.newsTitle}"
								placeholder="请输入资讯标题" autocomplete="off" class="layui-input">
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
							<th style="text-align: center;width: 5%;"><input type="checkbox" class="check-all"></th>
							<th style="text-align: center;width: 5%;">ID</th>
							<th style="text-align: center;width: 10%;">资讯名</th>
							<th style="text-align: center;width: 15%;">资讯标题</th>
							<th style="text-align: center;width: 10%;">资讯图</th>
							<th style="text-align: center;width: 15%;">资讯描述</th>
							
							<th style="text-align: center;width: 5%;">点赞数</th>
							<th width="150px;">操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${pagination.items}" var="item">
							<tr>
								<td><input type="checkbox" value="${item.id}"
									class="check-item"></td>
								<td>${item.id}</td>
								<td>${item.newsName}</td>
								<td>${item.newsTitle}</td>
								<td><div class="x-img">
										<img alt="" src="<%=%>${item.newsImagePath}"
											height="50px" width="70px">
									</div></td>
								<td>${item.newsDescription}</td>
								
								<td>${item.praisedCount}</td>
								<td><a href="<%=%>/news/set?id=${item.id}"
									class="layui-btn layui-btn-small" title="编辑"><i
										class="layui-icon"></i></a> <a
									class="layui-btn layui-btn-small layui-btn-danger del_btn"
									news-id="${item.id}" title="删除"><i class="layui-icon"></i></a>
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
		src="<%=%>/plug-in/js/news/index.js"></script>
</body>
</html>