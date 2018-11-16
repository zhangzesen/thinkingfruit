<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@ include file="/context/begin-tags.jsp"%> --%>
<!DOCTYPE html>
<html>
<head>
<%-- <jsp:include page="/context/css-tags.jsp" /> --%>
</head>
<body>
	<div class="layui-layout layui-layout-admin">
		<div class="layui-header header">
			<div class="layui-main">
				<a class="logo" href="javascript:;"> <img
					src="<%=%>/plug-in/images/ys-top.png">
				</a>
				<ul class="layui-nav"
					style="margin-right: 5%; text-align: right; left: 90%;"
					lay-filter="">
					<li class="layui-nav-item"><a name="loginName"
						href="javascript:;" style="width: 60px;"></a>
						<dl class="layui-nav-child">
							<!-- 二级菜单 -->
							<dd class="user">
								<a href="<%=%>/user/information" target="main">个人信息</a>
							</dd>
							<dd class="message">
								<a name="noticeMessage" href="<%=%>/noticeMessage" target="main"
									messageCount="">消息</a>
							</dd>
							<dd>
								<a href="<%=%>/user/logout">退出</a>
							</dd>
						</dl></li>
				</ul>
				<ul class="layui-nav top-nav-container" style="left: 13.9%;">
					<li class="layui-nav-item layui-this message" menuType="message"><a
						href="javascript:void(0)">首页</a></li>

					<li class="layui-nav-item mall"><a href="javascript:void(0)">商城管理</a></li>

					<li class="layui-nav-item administration"><a
						href="javascript:void(0)">微信配置</a></li>

					<li class="layui-nav-item system"><a href="javascript:void(0)">系统</a>
					</li>
				</ul>
			</div>
		</div>
		<div class="layui-side layui-bg-black"
			style="border-right: 1px solid #cccccc">
			<div class="layui-side-scroll">
				<ul name="message"
					class="layui-nav layui-bg-white layui-nav-tree left_menu_ul content_put_message message">
					<li class="layui-nav-item layui-nav-title edging"
						style="height: 55px;"><a
						style="line-height: 57px; font-size: 18px;">消息中心</a></li>
					<li name="left_message" class="layui-nav-item layui-this edging"><a
						name="left_a" href="<%=%>/index" target="main"> <i
							class="layui-icon">&#xe638;</i> <cite>首页</cite>
					</a></li>

					<li name="left_message" class="layui-nav-item message edging"><a
						name="left_a" id="left_information"
						href="<%=%>/noticeMessage" target="main"> <i
							class="layui-icon">&#xe611;</i> <cite>消息</cite>
					</a></li>

					<li name="left_message" class="layui-nav-item count edging"><a
						name="left_a"
						href="<%=%>/statistics/site" target="main"> <i
							class="layui-icon">&#xe62d;</i> <cite>统计表</cite>
					</a></li>

					<li name="left_message" class="layui-nav-item count edging"><a
						name="left_a"
						href="<%=%>/charts/commodity" target="main"> <i
							class="layui-icon">&#xe634;</i> <cite>统计图</cite>
					</a></li>

				</ul>
				<ul name="mall"
					class="layui-nav layui-bg-white layui-nav-tree left_menu_ul content_put_commodity hide">

					<li class="layui-nav-item layui-nav-title edging"
						style="height: 55px;"><a
						style="line-height: 57px; font-size: 18px;">商城管理</a></li>
					<li class="layui-nav-item edging"><a href="<%=%>/category" target="main"><i
							class="layui-icon">&#xe60f;</i>商品分类管理</a>
						<dl class="layui-nav-child left-dl">
							<dd>
								<li name="left_mall" class="layui-nav-item edging"
									style="background-color: #fff; border-top: 1px solid #cccccc;"><a
									name="left_a" href="<%=%>/category" target="main">
										<i class="layui-icon">&#xe671;</i><cite>商品一级分类</cite>
								</a></li>
							</dd>
							<dd>
								<li name="left_mall" class="layui-nav-item"
									style="background-color: #fff;"><a name="left_a"
									href="<%=%>/secondCategory" target="main"> <i
										class="layui-icon">&#xe671;</i><cite>商品二级分类</cite>
								</a></li>
							</dd>
						</dl></li>

					<li name="left_mall"
						class="layui-nav-item content_commodity edging"><a
						name="left_a" id="commodityManagement" href="" target="main"> <i
							class="layui-icon">&#xe62a;</i> <cite>商品管理</cite>
					</a></li>
					<li name="left_mall" class="layui-nav-item edging"><a
						name="left_a" href="<%=%>/comment" target="main"> <i
							class="layui-icon">&#xe658;</i> <cite>评论</cite>
					</a></li>

					<li name="left_mall" class="layui-nav-item edging"><a
						name="left_a" href="<%=%>/brand" target="main"> <i
							class="layui-icon">&#xe630;</i> <cite>品牌列表</cite>
					</a></li>

					<li name="left_mall" class="layui-nav-item edging"><a
						name="left_a" href="<%=%>/scroll" target="main"> <i
							class="layui-icon">&#xe634;</i> <cite>轮播图列表</cite>

							<li name="left_mall" class="layui-nav-item edging"><a
								name="left_a" href="<%=%>/payOrder" target="main"> <i
									class="layui-icon">&#xe63c;</i> <cite>订单列表</cite>
							</a></li>

							<li name="left_mall" class="layui-nav-item edging"><a
								name="left_a" href="<%=%>/payOrder/address"
								target="main"> <i class="layui-icon">&#xe715;</i> <cite>地址统计</cite>
							</a></li>

							<li name="left_mall" class="layui-nav-item edging"><a
								name="left_a" href="<%=%>/news" target="main"> <i
									class="layui-icon">&#xe60a;</i> <cite>资讯列表</cite>
							</a></li>

							<li name="left_mall" class="layui-nav-item edging"><a
								name="left_a" href="<%=%>/member" target="main"> <i
									class="layui-icon">&#xe613;</i> <cite>会员列表</cite>
							</a></li>
				</ul>
				<ul name="administration"
					class="layui-nav layui-bg-white layui-nav-tree left_menu_ul setting_ul hide">
					<li class="layui-nav-item layui-nav-title edging"
						style="height: 55px;"><a
						style="line-height: 57px; font-size: 18px;">微信管理</a></li>

					<li name="left_administration" class="layui-nav-item edging"><a
						name="left_a" href="<%=%>/WeChatConfig" target="main">
							<i class="layui-icon">&#xe620;</i> <cite>微信配置</cite>
					</a></li>
					<li name="left_administration" class="layui-nav-item edging"><a
						name="left_a" href="<%=%>/WeChatNews" target="main"> <i
							class="layui-icon">&#xe61d;</i> <cite>图文消息</cite>
					</a></li>

					<li name="left_administration" class="layui-nav-item edging"><a
						name="left_a" href="<%=%>/WeChatSendNews" target="main">
							<i class="layui-icon">&#xe629;</i> <cite>发送图文消息</cite>
					</a></li>

					<li name="left_administration" class="layui-nav-item edging"><a
						name="left_a" href="<%=%>/WeChatPublicMenu" target="main">
							<i class="layui-icon">&#xe629;</i> <cite>更新菜单</cite>
					</a></li>
				</ul>
				<ul name="system"
					class="layui-nav layui-bg-white layui-nav-tree left_menu_ul content_put_manage hide">
					<li class="layui-nav-item layui-nav-title edging"
						style="height: 55px;"><a
						style="line-height: 57px; font-size: 18px;">系统管理</a></li>

					<li name="left_system" class="layui-nav-item edging"><a
						name="left_a" href="<%=%>/role" target="main"> <i
							class="layui-icon">&#xe609;</i> <cite>角色管理</cite>
					</a></li>

					<li name="left_system" class="layui-nav-item edging"><a
						name="left_a" href="<%=%>/permission" target="main"> <i
							class="layui-icon">&#xe63c;</i> <cite>权限管理</cite>
					</a></li>
					<li name="left_system" class="layui-nav-item content_manage edging"><a
						name="left_a" href="<%=%>/permission/0" target="main"> <i
							class="layui-icon">&#xe62e;</i> <cite>权限树</cite>
					</a></li>
					<li name="left_system" class="layui-nav-item user edging"><a
						name="left_a" href="<%=%>/user" target="main"> <i
							class="layui-icon">&#xe612;</i> <cite>用户管理</cite>
					</a></li>
				</ul>
				<div class="content_manage_container left_menu_ul hide">
					<div class="content_manage_title">权限树</div>
					<div id="content_manage_tree"></div>
				</div>
				<div class="content_commodity_container left_menu_ul hide">
					<div class="content_commodity_title edging">商品树</div>
					<div id="content_commodity_tree"></div>
				</div>
			</div>
		</div>

		<div class="layui-body iframe-container">
			<div class="iframe-mask" id="iframe-mask"></div>
			<iframe class="admin-iframe" id="admin-iframe" name="main"
				src="<%=%>/index"></iframe>
		</div>

		<div class="layui-footer footer">
			<div class="layui-main">
				<p>
					2018 © <a href="<%=%>/user/main">灵秀工坊</a>
				</p>
			</div>
		</div>
	</div>
<%-- 	<jsp:include page="/context/js-tags.jsp" /> --%>
	<script type="text/javascript"
		src="<%=%>/plug-in/js/user/main.js"></script>
</body>
</html>