<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@ include file="/context/begin-tags.jsp"%> --%>
<!DOCTYPE html>
<html>
<head>
<%-- <jsp:include page="/context/css-tags.jsp" /> --%>
<link rel="stylesheet" href="<%=%>/plug-in/layui/css/layui.css" />
</head>
<body>
	<div class="layui-tab-brief main-tab-container" style="margin-top: 20px">
		<ul class="layui-tab-title main-tab-title">
			<li><a href="<%=%>/user">用户列表</a></li>
			<c:if test="${user == null}">
				<li class="layui-this">添加用户</li>
			</c:if>
			<c:if test="${user != null}">
				<li class="layui-this">修改用户</li>
			</c:if>
			<div class="main-tab-item">用户管理</div>
		</ul>
		<div class="layui-tab-content">
			<div class="layui-tab-item layui-show">
				<div class="layui-tab layui-tab-card">
					<ul class="layui-tab-title">
						<c:if test="${user == null}">
							<li class="layui-this">添加用户</li>
						</c:if>
						<c:if test="${user != null}">
							<li class="layui-this">修改用户</li>
						</c:if>
					</ul>
					<div class="layui-form">
						<div class="layui-tab-content">
							<div class="layui-tab-item layui-show">
								<c:if test="${user != null}">
									<input name="id" value="${user.id}" hidden="hidden">
								</c:if>

								<div class="layui-form-item">
									<label class="layui-form-label">用户名</label>
									<div class="layui-input-inline input-custom-width">
										<input type="text" name="loginName" value="${user.loginName}"
											lay-verify="required" autocomplete="off" placeholder="请输入用户名"
											class="layui-input">
									</div>
								</div>

								<div class="layui-form-item">
									<label class="layui-form-label">性别</label>
									<div class="layui-input-block">
										<input type="radio" name="sex" value="0" title="男"
											<c:if test="${user.sex == 0 or user.sex == null }">checked="checked"</c:if>>
										<input type="radio" name="sex" value="1" title="女"
											<c:if test="${user.sex == 1}">checked="checked"</c:if>>
									</div>
								</div>

								<div class="layui-form-item">
									<label class="layui-form-label"> 邮箱 </label>
									<div class="layui-input-inline">
										<input type="text" name="email" required="" autocomplete="off"
											value="${user.email}" class="layui-input">
									</div>
								</div>

								<div class="layui-form-item ">
									<label class="layui-form-label"> 省 </label>
									<div class="layui-input-inline">
										<select id="provName" provName="${user.provName}"
											name="provName" lay-filter="provName">
										</select>
									</div>
								</div>
								<div class="layui-form-item ">
									<label class="layui-form-label"> 市 </label>
									<div class="layui-input-inline">
										<select id="cityName" cityName="${user.cityName}"
											name="cityName" lay-filter="cityName">
										</select>
									</div>
								</div>
								<div class="layui-form-item ">
									<label class="layui-form-label"> 区 </label>
									<div class="layui-input-inline">
										<select id="townName" townName="${user.townName}"
											name="townName" lay-filter="townName">
										</select>
									</div>
								</div>

								<div class="layui-form-item">
									<label class="layui-form-label"> 手机 </label>
									<div class="layui-input-inline">
										<input type="text" name="mobile" required=""
											autocomplete="off" value="${user.mobile}" class="layui-input">
									</div>
								</div>
								<div class="layui-form-item ">
									<label class="layui-form-label"> 角色 </label>
									<div class="layui-input-inline">
										<select id="role" role="${user.roleId}" name="role"
											lay-filter="role">
											<c:forEach items="${roles}" var="role">
												<option value="${role.id}"
													<c:if test="${user.roleId==role.id}">selected="selected"</c:if>>${role.userRoleName}</option>
											</c:forEach>
										</select>
									</div>
								</div>

								<c:if test="${empty user}">
									<div class="layui-form-item">
										<label class="layui-form-label"> 密码 </label>
										<div class="layui-input-inline">
											<input type="password" name="loginPassword" required=""
												autocomplete="off" class="layui-input">
										</div>
										<div class="layui-form-mid layui-word-aux">6到16个字符</div>
									</div>
									<div class="layui-form-item">
										<label class="layui-form-label"> 确认密码 </label>
										<div class="layui-input-inline">
											<input type="password" name="surePassword" required=""
												autocomplete="off" class="layui-input">
										</div>
									</div>
								</c:if>

							</div>
							<div class="layui-form-item">
								<div class="layui-input-block">
									<c:if test="${user == null}">
										<button class="layui-btn" lay-submit="" lay-filter="cate_add">立即添加</button>
									</c:if>
									<c:if test="${user != null}">
										<button class="layui-btn" lay-submit="" lay-filter="cate_add">立即修改</button>
									</c:if>

								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

<%-- 	<jsp:include page="/context/js-tags.jsp" /> --%>
	<script src="<%=%>/plug-in/layui/layui.js" charset="utf-8"></script>
	<script src="<%=%>/plug-in/city/data.js"></script>
	<script src="<%=%>/plug-in/city/province.js"></script>
	<script type="text/javascript">
		var defaults = {
			s1 : 'provName',
			s2 : 'cityName',
			s3 : 'townName',
			v1 : $(".layui-tab-content select[name='provName']").attr(
					"provName"),
			v2 : $(".layui-tab-content select[name='cityName']").attr(
					"cityName"),
			v3 : $(".layui-tab-content select[name='townName']").attr(
					"townName")
		};
		alert(k);
	</script>
	<script type="text/javascript"
		src="<%=%>/plug-in/js/user/set.js"></script>
</body>
</html>

