<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/context/begin-tags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/context/css-tags.jsp" />
</head>
<body>
	<div class="layui-tab-brief main-tab-container" style="margin-top: 20px">
		<ul class="layui-tab-title main-tab-title">
			<li><a href="<%=basePath%>/user">用户列表</a></li>
			<li class="layui-this"><div class="add-edit">添加用户</div></li>
			<div class="main-tab-item  layui-bg-blue">用户管理</div>
		</ul>
		<div class="layui-tab-content">
			<div class="layui-tab-item layui-show">
				<div class="layui-tab layui-tab-card">
					<ul class="layui-tab-title">
						<li class="layui-this add-edit">添加用户</li>
					</ul>
					<div class="layui-form">
						<div class="layui-tab-content">
							<div class="layui-tab-item layui-show">
								<input name="id" hidden="hidden">

								<div class="layui-form-item">
									<label class="layui-form-label">登录名</label>
									<div class="layui-input-inline input-custom-width">
										<input type="text" name="loginName"
											lay-verify="required" autocomplete="off" placeholder="请输入登录名"
											class="layui-input">
									</div>
								</div>
								
								<div class="layui-form-item">
									<label class="layui-form-label">昵称</label>
									<div class="layui-input-inline input-custom-width">
										<input type="text" name="nickname"
											lay-verify="required" autocomplete="off" placeholder="请输入昵称"
											class="layui-input">
									</div>
								</div>

								<div class="layui-form-item">
									<label class="layui-form-label">性别</label>
									<div class="layui-input-block">
										<input type="radio" name="sex" value="0" title="男" checked>
										<input type="radio" name="sex" value="1" title="女">
									</div>
								</div>

								<div class="layui-form-item">
									<label class="layui-form-label"> 邮箱 </label>
									<div class="layui-input-inline">
										<input type="text" name="email" required="" autocomplete="off" class="layui-input">
									</div>
								</div>

								<div class="layui-form-item ">
									<label class="layui-form-label"> 省 </label>
									<div class="layui-input-inline">
										<select id="provName"
											name="provName" lay-filter="provName">
										</select>
									</div>
								</div>
								<div class="layui-form-item ">
									<label class="layui-form-label"> 市 </label>
									<div class="layui-input-inline">
										<select id="cityName"
											name="cityName" lay-filter="cityName">
										</select>
									</div>
								</div>
								<div class="layui-form-item ">
									<label class="layui-form-label"> 区 </label>
									<div class="layui-input-inline">
										<select id="townName"
											name="townName" lay-filter="townName">
										</select>
									</div>
								</div>

								<div class="layui-form-item">
									<label class="layui-form-label"> 手机 </label>
									<div class="layui-input-inline">
										<input type="text" name="mobile" required=""
											autocomplete="off" class="layui-input">
									</div>
								</div>
								
								<div class="layui-form-item ">
									<label class="layui-form-label"> 角色 </label>
									<div class="layui-input-inline">
										<select id="role" name="role" lay-filter="role"></select>
									</div>
								</div>

								<div class="layui-form-item" id="loginPassword">
									<label class="layui-form-label"> 密码 </label>
									<div class="layui-input-inline">
										<input type="password" name="loginPassword" required=""
											autocomplete="off" class="layui-input">
									</div>
									<div class="layui-form-mid layui-word-aux">6到16个字符</div>
								</div>
								<div class="layui-form-item" id="surePassword">
									<label class="layui-form-label"> 确认密码 </label>
									<div class="layui-input-inline">
										<input type="password" name="surePassword" required=""
											autocomplete="off" class="layui-input">
									</div>
								</div>
							</div>
							<shiro:hasPermission name="user:edit">
								<div class="layui-form-item">
									<div class="layui-input-block editbtn">
										<button class="layui-btn" lay-submit="" lay-filter="">立即添加</button>
									</div>
								</div>
							</shiro:hasPermission>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/context/js-tags.jsp" />
	<script src="<%=basePath%>/static/plugin/city/data.js"></script>
	<script src="<%=basePath%>/static/plugin/city/province.js"></script>
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
	</script>
	<script type="text/javascript"
		src="<%=basePath%>/static/js/user/set.js"></script>
</body>
</html>

