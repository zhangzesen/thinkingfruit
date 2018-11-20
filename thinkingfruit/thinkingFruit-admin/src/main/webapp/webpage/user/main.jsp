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
					src="<%=basePath%>/static/images/ljl-top.jpg">
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
				    
					<li class="layui-nav-item layui-this message" menuType="message"><a
						href="javascript:void(0)">首页</a></li>
					

					
						<li class="layui-nav-item mall"><a href="javascript:void(0)">商城管理</a></li>
					

					
						<li class="layui-nav-item system"><a
							href="javascript:void(0)">系统</a>
					
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
						name="left_a" href="<%=basePath%>/statistics" target="main"> <i
							class="layui-icon">&#xe638;</i> <cite>首页</cite>
					</a></li>
					
					
                    
					<li name="left_message" class="layui-nav-item message edging"><a
						name="left_a" id="left_information" href="<%=basePath%>/message"
						target="main"> <i class="layui-icon">&#xe611;</i> <cite>消息</cite>
					</a></li>
                   
					
				</ul>
				
				
					<ul name="mall"
						class="layui-nav layui-bg-white layui-nav-tree left_menu_ul content_put_commodity hide">

						<li class="layui-nav-item layui-nav-title edging"
							style="height: 55px;"><a
							style="line-height: 57px; font-size: 18px;">商城管理</a></li>
						
						
							<li name="left_mall"
								class="layui-nav-item content_commodity edging"><a
								name="left_a" id="commodityManagement" href="<%=basePath%>/commodity" target="main">
									<i class="layui-icon">&#xe62a;</i> <cite>商品管理</cite>
							</a></li>
						

						
							<li name="left_mall" class="layui-nav-item edging"><a
								name="left_a" href="<%=basePath%>/cash" target="main"> <i
									class="layui-icon">&#xe630;</i> <cite>用户提现</cite>
							</a></li>
						

						
							<li name="left_mall" class="layui-nav-item edging"><a
								name="left_a" href="<%=basePath%>/scroll" target="main"> <i
									class="layui-icon">&#xe634;</i> <cite>轮播图列表</cite>
							</a></li>
						

						
							<li name="left_mall" class="layui-nav-item edging"><a
								name="left_a" href="<%=basePath%>/order" target="main"> <i
									class="layui-icon">&#xe63c;</i> <cite>订单列表</cite>
							</a></li>
						

						
							<li name="left_mall" class="layui-nav-item edging"><a
								name="left_a" href="<%=basePath%>/commision" target="main">
									<i class="layui-icon">&#xe715;</i><cite>佣金列表</cite>
							</a></li>
						

						
							<li name="left_mall" class="layui-nav-item edging"><a
								name="left_a" href="<%=basePath%>/commision/person"
								target="main"> <i class="layui-icon">&#xe715;</i><cite>个人佣金</cite>
							</a></li>
						
						
						
							<li name="left_mall" class="layui-nav-item edging"><a
								name="left_a" href="<%=basePath%>/ranking"
								target="main"> <i class="layui-icon">&#xe62c;</i><cite>佣金排行</cite>
							</a></li>
						

						
							<li name="left_mall" class="layui-nav-item edging"><a
								name="left_a" href="<%=basePath%>/news" target="main"> <i
									class="layui-icon">&#xe60a;</i> <cite>资讯列表</cite>
							</a></li>
						

						
							<li name="left_mall" class="layui-nav-item edging"><a
								name="left_a" href="<%=basePath%>/member" target="main"> <i
									class="layui-icon">&#xe613;</i> <cite>会员列表</cite>
							</a></li>
						

						
							<li name="left_mall" class="layui-nav-item edging"><a
								name="left_a" href="<%=basePath%>/system" target="main"> <i
									class="layui-icon">&#xe641;</i> <cite>网体列表</cite>
							</a></li>
					

					
							<li name="left_mall" class="layui-nav-item edging"><a
								name="left_a" href="<%=basePath%>/shop" target="main"> <i
									class="layui-icon">&#xe647;</i> <cite>店铺列表</cite>
							</a></li>
						

						
							<li name="left_mall" class="layui-nav-item edging"><a
								name="left_a" href="<%=basePath%>/businessApplication"
								target="main"> <i class="layui-icon">&#xe638;</i> <cite>商家申请</cite>
							</a></li>
						
					</ul>
				
				
					<ul name="system"
						class="layui-nav layui-bg-white layui-nav-tree left_menu_ul content_put_manage hide">
						
							<li class="layui-nav-item layui-nav-title edging"
								style="height: 55px;"><a
								style="line-height: 57px; font-size: 18px;">系统管理</a></li>
						
						
							<li name="left_system" class="layui-nav-item edging"><a
								name="left_a" href="<%=basePath%>/role" target="main"> <i
									class="layui-icon">&#xe609;</i> <cite>角色管理</cite>
							</a></li>
						
						
							<li name="left_system" class="layui-nav-item edging"><a
								name="left_a" href="<%=basePath%>/permission" target="main">
									<i class="layui-icon">&#xe63c;</i> <cite>权限管理</cite>
							</a></li>
						
						
							<li name="left_system"
								class="layui-nav-item content_manage edging"><a
								name="left_a" href="<%=basePath%>/permission/infoson?id=0"
								target="main"> <i class="layui-icon">&#xe62e;</i> <cite>权限树</cite>
							</a></li>
						
						
							<li name="left_system" class="layui-nav-item user edging"><a
								name="left_a" href="<%=basePath%>/user" target="main"> <i
									class="layui-icon">&#xe612;</i> <cite>用户管理</cite>
							</a></li>
						
					</ul>
				
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
					2018 © <a href="<%=basePath%>/main">揽菁灵后台管理系统</a>
				</p>
			</div>
		</div>
	</div>
	<jsp:include page="/context/js-tags.jsp" />
	<script type="text/javascript"
		src="<%=basePath%>/static/js/main/main.js"></script>
</body>
</html>