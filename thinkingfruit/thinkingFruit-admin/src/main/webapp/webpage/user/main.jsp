<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/context/begin-tags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/context/css-tags.jsp" />
</head>
<body>
	<div class="layui-layout layui-layout-admin">
		<div class="layui-header header">
			<div class="layui-main">
				<a class="logo" href="javascript:;"> <img
					style="padding-top: 7px; height: 52px;"
					src="<%=basePath%>/static/images/ljl-top.png">
				</a>
				<ul class="layui-nav"
					style="margin-right: 5%; text-align: right; left: 90%;"
					lay-filter="">
					<li class="layui-nav-item"><a name="loginName"
						href="javascript:;" style="width: 60px;"> <shiro:principal
								property="loginName" />
					</a>
						<dl class="layui-nav-child">
							<!-- 二级菜单 -->
							<dd class="user">
								<a href="<%=basePath%>/user/information" target="main">个人信息</a>
							</dd>
							<dd class="message">
								<a name="noticeMessage" href="<%=basePath%>/message"
									target="main" messageCount="">消息</a>
							</dd>
							<dd>
								<a href="<%=basePath%>/user/logout">退出</a>
							</dd>
						</dl></li>
				</ul>
				<ul class="layui-nav top-nav-container" style="left: 13.9%;">
					<shiro:hasPermission name="home:manager">
						<li class="layui-nav-item layui-this message" menuType="message"><a
							href="javascript:void(0)">首页</a></li>
					</shiro:hasPermission>

					<shiro:hasPermission name="mall:manager">
						<li class="layui-nav-item mall"><a href="javascript:void(0)">商城管理</a></li>
					</shiro:hasPermission>

					<shiro:hasPermission name="system:manager">
						<li class="layui-nav-item system"><a
							href="javascript:void(0)">系统</a>
					</shiro:hasPermission>
					</li>
				</ul>
			</div>
		</div>
		<div class="layui-side layui-bg-black"
			style="border-right: 1px solid #cccccc">
			<div class="layui-side-scroll">
				<shiro:hasPermission name="home:manager">
					<ul name="message"
						class="layui-nav layui-bg-white layui-nav-tree left_menu_ul content_put_message message">
						<li class="layui-nav-item layui-nav-title edging"
							style="height: 55px;"><a
							style="line-height: 57px; font-size: 18px;">消息中心</a></li>

						<shiro:hasPermission name="statictis:index">
							<li name="left_message" class="layui-nav-item layui-this edging"><a
								name="left_a" href="<%=basePath%>/statistics" target="main">
									<i class="layui-icon">&#xe638;</i> <cite>首页</cite>
							</a></li>
						</shiro:hasPermission>
						<shiro:hasPermission name="message:index">
							<li name="left_message" class="layui-nav-item message edging"><a
								name="left_a" id="left_information" href="<%=basePath%>/message"
								target="main"> <i class="layui-icon">&#xe611;</i> <cite>消息</cite>
							</a></li>
						</shiro:hasPermission>
						<li name="left_message" class="layui-nav-item edging"><a
							name="left_a" href="<%=basePath%>/help" target="main"> <i
								class="layui-icon">&#xe60c;</i> <cite>帮助</cite>
						</a></li>


					</ul>
				</shiro:hasPermission>
				<shiro:hasPermission name="mall:manager">
					<ul name="mall"
						class="layui-nav layui-bg-white layui-nav-tree left_menu_ul content_put_commodity hide">

						<li class="layui-nav-item layui-nav-title edging"
							style="height: 55px;"><a
							style="line-height: 57px; font-size: 18px;">商城管理</a></li>

						<shiro:hasPermission name="commodity:manager">
							<li name="left_mall"
								class="layui-nav-item content_commodity edging"><a
								name="left_a" id="commodityManagement"
								href="<%=basePath%>/commodity" target="main"> <i
									class="layui-icon">&#xe657;</i> <cite>商品管理</cite>
							</a></li>
						</shiro:hasPermission>
						<shiro:hasPermission name="order:manager">
							<li name="left_mall" class="layui-nav-item edging"><a
								name="left_a" href="javascript:;" target="main"> <i
									class="layui-icon">&#xe63c;</i><cite>订单列表</cite> <span
									class="layui-nav-more"></span>
							</a>
								<dl class="layui-nav-child">
									<dd class="">
										<a href="<%=basePath%>/order" target="main">公司总仓发货订单</a>
									</dd>
									<dd class="">
										<a href="<%=basePath%>/purchase" target="main">上下级代理交易订单</a>
									</dd>
								</dl></li>
						</shiro:hasPermission>

						<shiro:hasPermission name="commision:manager">
							<li name="left_mall" class="layui-nav-item edging"><a
								name="left_a" href="javascript:;" target="main"> <i
									class="layui-icon">&#xe65e;</i><cite>佣金管理</cite> <span
									class="layui-nav-more"></span>
							</a>
								<dl class="layui-nav-child">
									<dd class="">
										<a href="<%=basePath%>/commision" target="main">佣金列表</a>
									</dd>
									<dd class="">
										<a href="<%=basePath%>/commision/person" target="main">个人佣金</a>
									</dd>
								</dl></li>
						</shiro:hasPermission>

						<shiro:hasPermission name="news:manager ">
							<li name="left_mall" class="layui-nav-item edging"><a
								name="left_a" href="<%=basePath%>/news" target="main"> <i
									class="layui-icon">&#xe629;</i> <cite>文章编辑</cite>
							</a></li>
						</shiro:hasPermission>

						<shiro:hasPermission name="member:manager">

							<li name="left_mall" class="layui-nav-item edging"><a
								name="left_a" href="javascript:;" target="main"> <i
									class="layui-icon">&#xe612;</i><cite>代理管理</cite> <span
									class="layui-nav-more"></span>
							</a>
								<dl class="layui-nav-child">
									<dd class="">
										<a href="<%=basePath%>/member" target="main">代理列表</a>
									</dd>
									<dd class="">
										<a href="<%=basePath%>/member/examine" target="main">注册代理审核</a>
									</dd>
									<dd class="">
										<a href="<%=basePath%>/member/upExamine" target="main">升级代理审核</a>
									</dd>
									<dd class="">
										<a href="<%=basePath%>/member/invite" target="main">代理邀请</a>
									</dd>
								</dl></li>
						</shiro:hasPermission>
						<shiro:hasPermission name="business:manager">
							<li name="left_mall" class="layui-nav-item edging"><a
								name="left_a" href="javascript:;" target="main"> <i
									class="layui-icon">&#xe614;</i><cite>设置</cite> <span
									class="layui-nav-more"></span>
							</a>
								<dl class="layui-nav-child">
									<dd class="">
										<a href="<%=basePath%>/site" target="main">分佣比例</a>
									</dd>
									<dd class="">
										<a href="<%=basePath%>/site/about" target="main">关于我们</a>
									</dd>
								</dl></li>
						</shiro:hasPermission>
						<shiro:hasPermission name="cash:manager">
							<li name="left_mall" class="layui-nav-item edging"><a
								name="left_a" href="<%=basePath%>/cash" target="main"> <i
									class="layui-icon">&#xe629;</i> <cite>提现管理</cite>
							</a></li>
						</shiro:hasPermission>
					</ul>
				</shiro:hasPermission>
				<shiro:hasPermission name="system:manager">
					<ul name="system"
						class="layui-nav layui-bg-white layui-nav-tree left_menu_ul content_put_manage hide">
						<shiro:hasPermission name="system:manager">
							<li class="layui-nav-item layui-nav-title edging"
								style="height: 55px;"><a
								style="line-height: 57px; font-size: 18px;">系统管理</a></li>
						</shiro:hasPermission>
						<shiro:hasPermission name="role:manager">
							<li name="left_system" class="layui-nav-item edging"><a
								name="left_a" href="<%=basePath%>/role" target="main"> <i
									class="layui-icon">&#xe609;</i> <cite>角色管理</cite>
							</a></li>
						</shiro:hasPermission>
						<shiro:hasPermission name="permission:manager">
							<li name="left_system" class="layui-nav-item edging"><a
								name="left_a" href="<%=basePath%>/permission" target="main">
									<i class="layui-icon">&#xe63c;</i> <cite>权限管理</cite>
							</a></li>
						</shiro:hasPermission>
						<shiro:hasPermission name="permission:tree">
							<li name="left_system"
								class="layui-nav-item content_manage edging"><a
								name="left_a" href="<%=basePath%>/permission/infoson?id=0"
								target="main"> <i class="layui-icon">&#xe62e;</i> <cite>权限树</cite>
							</a></li>
						</shiro:hasPermission>
						<shiro:hasPermission name="user:manager">
							<li name="left_system" class="layui-nav-item user edging"><a
								name="left_a" href="<%=basePath%>/user" target="main"> <i
									class="layui-icon">&#xe612;</i> <cite>用户管理</cite>
							</a></li>
						</shiro:hasPermission>
					</ul>
				</shiro:hasPermission>
				<div class="content_manage_container left_menu_ul hide">
					<div class="content_manage_title">返回</div>
					<div id="content_manage_tree"></div>
				</div>
				<div class="content_commodity_container left_menu_ul hide">
					<div class="content_commodity_title edging">返回</div>
					<div id="content_commodity_tree"></div>
				</div>
			</div>
		</div>

		<div class="layui-body iframe-container">
			<div class="iframe-mask" id="iframe-mask"></div>
			<iframe class="admin-iframe" id="admin-iframe" name="main"
				src="<%=basePath%>/statistics"></iframe>
		</div>

		<div class="layui-footer footer">
			<div class="layui-main">
				<p>
					2019 © <a href="<%=basePath%>/main">爱因思果后台管理系统</a>
				</p>
			</div>
		</div>
	</div>
	<jsp:include page="/context/js-tags.jsp" />
	<script type="text/javascript"
		src="<%=basePath%>/static/js/common/date.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>/static/js/main/main.js"></script>
</body>
</html>