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
								value="${noticeMessage.startTime}" placeholder="开始日"
								name="startTime">
						</div>
						<div class="layui-input-inline xbs768">
							<input type="text" readonly="readonly" class="layui-input"
								value="${noticeMessage.endTime}" placeholder="截止日" name="endTime">
						</div>
						<div class="layui-input-inline xbs768">
							<input type="text" name="content"
								value="${noticeMessage.content}" placeholder="请输入消息内容"
								autocomplete="off" class="layui-input">
						</div>
						<div class="layui-input-inline xbs768">
							<select name="status" lay-filter="status" lay-verify="">
								<option value="" selected="selected">请输入消息状态</option>
								<option value="0" <c:if test="${noticeMessage.status==0}">selected="selected"</c:if>>未读</option>
								<option value="1" <c:if test="${noticeMessage.status==1}">selected="selected"</c:if>>已读</option>
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
			<button class="layui-btn layui-btn-danger btn-delete-batch ">
				<i class="layui-icon">&#xe640;</i>批量删除
			</button>
			<button class="layui-btn layui-btn-warm btn-reset">
				<i class="layui-icon">&#x1002;</i>重置
			</button>
			<span class="x-right"
				style="line-height: 40px; float: right; font-size: 20px">共有数据：${pagination.totalItemsCount}
				条</span> </xblock>

			<div class="layui-tab-item layui-show">
				<table class="list-table" width="100%">
					<thead>
						<tr>
						    <th style="text-align: center; width: 50px;"><input type="checkbox" class="check-all"></th>
							<th style="text-align: center;width:45px;">编号</th>
							<th style="text-align: center;width:100px;">消息状态</th>
							<th style="text-align: center;">消息内容</th>
							<th style="text-align: center;">生成时间</th>
							<th style="text-align: center;">操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${pagination.items}" var="noticeMessage">
							<tr>
							    <td><input type="checkbox" value="${noticeMessage.id}" class="check-item"></td>
								<td>${noticeMessage.id}</td>
								<td><c:if test="${noticeMessage.status==0}"><button name="status" noticeMessageId="${noticeMessage.id}" class="layui-btn layui-btn-warm status">未读</c:if>
								    <c:if test="${noticeMessage.status==1}"><button noticeMessageId="${noticeMessage.id}" class="layui-btn layui-btn-normal">已读</c:if></td>
								<td style="word-break: break-all;">${noticeMessage.content}</td>
								<td><fmt:formatDate pattern="YYYY-MM-dd HH-mm-ss" value="${noticeMessage.createTime}"/></td>
								<td style="text-align: center;">
									<a class="layui-btn layui-btn-small layui-btn-danger del_btn" name="delete"
									noticeMessage-id="${noticeMessage.id}" title="删除"><i
										class="layui-icon">&#xe640;</i></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
                <input type="hidden" name="totalPageCount"
				value="${pagination.totalPageCount}"> 
				<input type="hidden"
				name="pageNum" value="${pagination.pageNum}"> 
				<input
				type="hidden" name="totalItemsCount"
				value="${pagination.totalItemsCount}">
			<div id="page"></div>
		</div>
	</div>
<%-- 	<jsp:include page="/context/js-tags.jsp" /> --%>
	<script type="text/javascript" src="<%=%>/plug-in/js/noticeMessage/index.js"></script>
</body>
</html>