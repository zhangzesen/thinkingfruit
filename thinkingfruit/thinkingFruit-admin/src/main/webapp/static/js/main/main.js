isLogin = false;
var user_main_ops = {
	init : function() {
//		this.inintComponent();
//		this.initMessageWebscoket();
		this.eventBind();
		this.inintMessageRedis();
	},
	// 初始化组件
	inintComponent : function() {
		layui.use([ 'layer', 'element' ], function() {
			layer = layui.layer;
			element = layui.element;			
			//查询数据库中的分类，将第一个二级分类放入到商品管理选项中的超链接中
			$.ajax({
				type : 'GET',
				url : WEB_ROOT + "/commodity/findFirstOfSecongCategory",
				dataType : 'json',
				success : function(res) {		
					if(res.success){
						$(".content_commodity #commodityManagement").attr("href",WEB_ROOT+"/commodity?commodityCategoryId="+res.msg);
					}else{
						$(".content_commodity #commodityManagement").attr("href","javascript:void(0);");
					}
				}
			});
			
//			var messageCount = $("a[name='information']").attr("messagecount");
//
//			if (messageCount > 0) {
//				common_ops.alert('您有新的未读消息');
//				if (!isLogin) {
//					$("a[name='loginName']").append(
//							"<span class='layui-badge-dot'></span>");
//					$("a[name='information']").append(
//							"<span class='layui-badge'>" + messageCount
//									+ "</span>");
//					isLogin = true;
//				}
//			}
		});

	},

	// 初始化事件
	eventBind : function() {
		layui.use([ 'layer', 'element', 'jquery', 'tree' ], function() {
			var layer = layui.layer, $ = layui.jquery, element = layui.element;// 导航的hover效果、二级菜单等功能，需要依赖element模块
			$('.top-nav-container .layui-nav-item').click(
					function() {
						var menu_index = $(this).index(
								'.top-nav-container .layui-nav-item');
						var ulName = $('.left_menu_ul:eq(' + menu_index + ')').attr("name");
						switch(ulName)
						{
							case 'message':
								$('li[name="left_message"]:eq(0)').addClass('first-item');
							    break;
							case 'mall':
								$('li[name="left_mall"]:eq(0)').addClass('first-item');
							    break;
							case 'administration':
								$('li[name="left_administration"]:eq(0)').addClass('first-item');
							    break;
							case 'system':
								$('li[name="left_system"]:eq(0)').addClass('first-item');
								break;
						}
						$('.top-nav-container .layui-nav-item').removeClass(
								'layui-this');
						$('.layui-nav .layui-nav-child dd').removeClass(
								'layui-this');
						$(this).addClass('layui-this');
						$('.left_menu_ul').addClass('hide');
						$('.left_menu_ul:eq(' + menu_index + ')').removeClass(
								'hide');
						$('.left_menu_ul .layui-nav-item').removeClass(
								'layui-this');
						$('.left_menu_ul:eq(' + menu_index + ')').find(
								'.first-item').addClass('layui-this');
						var url = $('.left_menu_ul:eq(' + menu_index + ')')
								.find('.first-item a').attr('href');
						$('.admin-iframe').attr('src', url);
						// 出现遮罩层
						$("#iframe-mask").show();
						// 遮罩层消失
						$("#admin-iframe").load(function() {
							$("#iframe-mask").fadeOut(100);
						});
					});

			// 左边菜单点击
//			$('.left_menu_ul .layui-nav-item').click(function() {
//				if ($(this).hasClass('layui-nav-title')) {
//					$(this).removeClass('layui-this');
//					return false;
//				}
//				$('.left_menu_ul .layui-nav-item').removeClass('layui-this');
//				$('.layui-nav .layui-nav-child dd').removeClass('layui-this');
//				$(this).addClass('layui-this');
//				// 出现遮罩层
//				$("#iframe-mask").show();
//				// 遮罩层消失
//				$("#admin-iframe").load(function() {
//					$("#iframe-mask").fadeOut(100);
//				});
//			});

			// 用户菜单点击
			$('.layui-nav .layui-nav-child dd').click(
					function() {
						if ($(this).hasClass('layui-nav-title')) {
							return false;
						}
						$('.left_menu_ul .layui-nav-item').removeClass(
								'layui-this');
						$('.top-nav-container .layui-nav-item').removeClass(
								'layui-this');
						$(this).addClass('layui-this');
						if ($(this).hasClass("message")) {
							$('.left_menu_ul').addClass('hide');
							$(".left_menu_ul .message").addClass('layui-this');
							$(".top-nav-container .message").addClass(
									'layui-this');
							$(".top-nav-container .message")
									.removeClass('hide');
							$('.content_put_message').removeClass('hide');
						}
						if ($(this).hasClass("user")) {

							$('.left_menu_ul').addClass('hide');
							$(".left_menu_ul .user").addClass('layui-this');
							$(".top-nav-container .user")
									.addClass('layui-this');
							$(".top-nav-container .user").removeClass('hide');
							$('.content_put_manage').removeClass('hide');
						}
						// 出现遮罩层
						$("#iframe-mask").show();
						// 遮罩层消失
						$("#admin-iframe").load(function() {
							$("#iframe-mask").fadeOut(100);
						});
					});

			// 权限树点击回到内容页面
			$('.content_manage_title').click(
					function() {
						$('.left_menu_ul .layui-nav-item').removeClass(
								'layui-this');
						$(this).parent().addClass('hide');
						$('.content_put_manage').find('.first-item').addClass(
								'layui-this');
						var url = $('.content_put_manage')
								.find('.first-item a').attr('href');
						$('.admin-iframe').attr('src', url);
						$('.content_put_manage').removeClass('hide');

					});
			
			// 商品树点击回到内容页面
			$('.content_commodity_title').click(
					function() {
						$('.left_menu_ul .layui-nav-item').removeClass(
								'layui-this');
						$(this).parent().addClass('hide');
						$('.content_put_commodity').find('.first-item').addClass(
								'layui-this');
						var url = $('.content_put_commodity')
								.find('.first-item a').attr('href');
						$('.admin-iframe').attr('src', url);
						$('.content_put_commodity').removeClass('hide');

					});

			// 权限树
			$('.content_manage').click(function() {
				loading = layer.load(2, {
					shade : [ 0.2, '#000' ]
				// 0.2透明度的白色背景
				});
				$('#content_manage_tree').empty();
				$.ajax({
					url : WEB_ROOT + "/permission/permissionTree",
					dataType : "json",
					type : "post",
					success : function(treeMenu) {
						layui.tree({
							elem : '#content_manage_tree' // 传入元素选择器
							,
							skin : 'white',
							target : 'main',
							nodes : treeMenu
//								[ {
//								"id" : 1,
//								"name" : "权限",
//								"href" : null,
//								"children" : treeMenu
//							} ]
						});
					}
				});
				$('.left_menu_ul').addClass('hide');
				$('.content_manage_container').removeClass('hide');
				layer.close(loading);
			});
			
			
			// 退出登陆
			$('.logout_btn').click(function() {
				loading = layer.load(2, {
					shade : [ 0.2, '#000' ]
				// 0.2透明度的白色背景
				});
				$.getJSON('', function(data) {
					if (data.code == 200) {
						layer.close(loading);
						layer.msg(data.msg, {
							icon : 1,
							time : 1000
						}, function() {
							location.reload();// do something
						});
					} else {
						layer.close(loading);
						layer.msg(data.msg, {
							icon : 2,
							anim : 6,
							time : 1000
						});
					}
				});
			});
			
			
			//改变点击效果
//			$("a[name='left_a']").click(function(){
//				$(".left-dl a[name='left_a']").attr("style","");
//				//添加左列表的下拉列表的点击效果
//				$(".left-dl a[name='left_a']").click(function(){
//					$(".left-dl a[name='left_a']").attr("style","");
//					$(this).attr("style","color: #1e9fff;");
//				})
//				$(".edging img").remove();
//				$("<img src='"+WEB_ROOT+"/plug-in/images/arrow.png' style='float:right;'>").insertBefore($(this));
//			});
			

		});
		// 当点击左侧个人消息时,更改count的值
		$("#left_information").click(function() {
			$("a[name='loginName'] .layui-badge-dot").remove();
			$("a[name='noticeMessage'] .layui-badge").remove();
		});

		// 右上角点击消息时，更改count的值
		$("a[name='noticeMessage']").click(function() {
			$("a[name='loginName'] .layui-badge-dot").remove();
			$("a[name='noticeMessage'] .layui-badge").remove();
		});

	},
	inintMessageRedis : function(){
		//一分钟轮询一次
		setInterval(function(){
			$.ajax({
				url:WEB_ROOT+'/message/redisPolling',
				type:'get',
				dataType:'json',
				success:function(res){
					console.log(res);
					console.log("消息");
					if (res.data == true) {
						common_ops.alert('您有新的未读消息',null);
						$("a[name='loginName']").append("<span class='layui-badge-dot'></span>");
						$("a[name='noticeMessage']").append("<span class='layui-badge-dot'></span>");
					}
				}
			})
		},60000)
	}
//	// 初始化websocket
//	initMessageWebscoket : function() {
//		var websocket;
//		// 首先判断是否 支持 WebSocket
//		if ('WebSocket' in window) {
//			websocket = new WebSocket("wss://" + WEB_SOCKET_PATH + "/websocket");
//		} else if ('MozWebSocket' in window) {
//			websocket = new MozWebSocket("wss://" + WEB_SOCKET_PATH
//					+ "/websocket");
//		} else {
//			websocket = new SockJS("https://" + WEB_SOCKET_PATH
//					+ "/socketjs/websocket");
//		}
//
//		// 打开时
//		websocket.onopen = function(evnt) {
//			send();
//		};
//		// 处理消息时
//		websocket.onmessage = function(evnt) {
//			
//			if (evnt.data != ("@copy")) {
//				var count = $("a[name='noticeMessage']").attr("messageCount");
//				var data = eval("("+evnt.data+")");
//				count++;
//				common_ops.alert(data.content);
//				$("a[name='loginName']").append("<span class='layui-badge-dot'></span>");
//				$("a[name='noticeMessage']").append(
//					"<span class='layui-badge'>" + count + "</span>");
//				$("a[name='noticeMessage']").attr("messagecount", count);
//			}
//			heartCheck.reset();
//		};
//		window.onbeforeunload = function() {
//
//			websocket.close();
//		}
//		function closeWebSocket() {
//			websocket.close();
//		}
//
//		// 发送消息
//		function send() {
//			var message = "@heart";
//			heartCheck.start();
//		}
//		var heartCheck = {
//			timeout : 5000,
//			timeoutObj : null,
//			reset : function() {
//				clearTimeout(this.timeoutObj);
//				this.start();
//			},
//			start : function() {
//				this.timeoutObj = setTimeout(function() {
//					websocket.send("@heart");
//				}, this.timeout)
//			}
//		}
//
//	},

};
$(function() {
	user_main_ops.init();
});