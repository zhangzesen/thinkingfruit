;
var user_login_ops = {
	init : function() {
		this.initComponent();
		this.eventBind();
	},
	initComponent : function() {
		layui.use([ 'form', 'element' ], function() {
			layer = layui.layer;
			element = layui.element;
			if (window != top) {
				top.location.href = location.href;
			}
		});

	},
	eventBind : function() {
		console.log("zzz");
		var that = this;
		$("#login").click(function(){
			console.log("登录");
			that.login();
		});
		$("#submit").click(function(){
			console.log("注册");
			that.register();
		})
		$(document).keydown(function(event) {
			if (event.keyCode == 13) {
				that.login();
			};
		});
	},
	login:function(){
		window.location.href = WEB_ROOT + '/agent/login';
	},
	register : function(){
		var btnTarget = $(this);
		var loginName = $("input[name='loginName']").val();
		var loginPassword = $("input[name='loginPassword']").val();
		var randCode = $("input[name='verification']").val();
		var mobile = $("input[name='mobile']").val();
		var inviterId = common_ops.g_getQueryString('inviterId');
		btnTarget.addClass('layui-btn-disabled');
		console.log("loginName:"+loginName);
		console.log("password:"+loginPassword);
		console.log("verification:"+randCode);
		console.log("mobile:"+mobile);
		console.log("inviterId:"+inviterId);
		$.ajax({
			url : WEB_ROOT + "/agent/register",
			data : {
				loginName : loginName,
				randCode : randCode,
				pswd : loginPassword,
				mobile:mobile,
				inviterId:inviterId
			},
			type : 'POST',
			dataType : 'json',
			success : function(res) {
				btnTarget.removeClass('layui-btn-disabled');
				var callback = null;
				if (res.code == 0) {
					window.location.href = WEB_ROOT + "/agent/login";
				} else {
					callback = function() {
						$(".code img").attr('src',WEB_ROOT + '/randCodeImage?id='+ Math.random());
					};
					common_ops.alert(res.msg, callback);
				}
			},
			error : btnTarget.removeClass('layui-btn-diabled')
		});

	}



}

$(function() {
	user_login_ops.init();
})