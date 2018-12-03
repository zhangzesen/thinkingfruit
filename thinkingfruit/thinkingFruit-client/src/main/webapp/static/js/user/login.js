;
var user_login_ops = {
	init : function() {
		this.eventBind();
	},
	eventBind : function() {
		console.log("zzz");
		var that = this;
		$("#submit").click(function(){
			console.log("登录");
			that.login();
		});
		$("#register").click(function(){
			console.log("注册");
			that.register();
		})
		$(document).keydown(function(event) {
			if (event.keyCode == 13) {
				that.login();
			};
		});
	},
	register:function(){
		window.location.href = WEB_ROOT + '/agent/register';
	},
	login : function(){
		var btnTarget = $(this);
		var loginName = $("input[name='loginName']").val();
		var loginPassword = $("input[name='password']").val();
		var randCode = $("input[name='verification']").val();

		btnTarget.addClass('layui-btn-disabled');
		console.log("loginName:"+loginName);
		console.log("password:"+loginPassword);
		console.log("verification:"+randCode);
		$.ajax({
			url : WEB_ROOT + "/agent/login",
			data : {
				loginName : loginName,
				randCode : randCode,
				pswd : loginPassword
			},
			type : 'POST',
			dataType : 'json',
			success : function(res) {
				btnTarget.removeClass('layui-btn-disabled');
				var callback = null;
				if (res.code == 0) {
					window.location.href = WEB_ROOT + "/home";
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