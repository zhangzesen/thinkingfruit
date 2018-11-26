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
		var that = this;
		$(".button").click(function(){
			that.login();
		});
		$(document).keydown(function(event) {
			if (event.keyCode == 13) {
				that.login();
			};
		});
	},
	
	login : function(){
		var btnTarget = $(this);
		var loginName = $("input[name='loginName']")
				.val();
		var loginPassword = $(
				"input[name='password']").val();
		var randCode = $("input[name='verification']")
				.val();

		btnTarget.addClass('layui-btn-disabled');
		console.log("loginName:"+loginName);
		console.log("password:"+loginPassword);
		console.log("verification:"+randCode);
		$.ajax({
			url : WEB_ROOT + "/user/login",
			data : {
				name : loginName,
				randCode : randCode,
				password : loginPassword
			},
			type : 'POST',
			dataType : 'json',
			success : function(res) {
				btnTarget.removeClass('layui-btn-disabled');
				var callback = null;
				if (res.code == 0) {
					window.location.href = WEB_ROOT + "/main";
				} else {
					callback = function() {
						$(".code img").attr(
								'src',
								WEB_ROOT + '/randCodeImage?id='
										+ Math.random());
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