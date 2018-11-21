;
var user_password_ops = {
	inint : function() {
		this.inintComponent();
		this.eventBind();
	},
	eventBind : function() {
		// 获取用户登录名
		var id = common_ops.g_getQueryString("id");	
		$(".btn-user-password-edit").click(function(){
			var oldLoginPassword = $("input[name='oldLoginPassword']").val();
			var newLoginPassword = $("input[name='newLoginPassword']").val();
			var sureLoginPassword = $("input[name='sureLoginPassword']").val();
			btnTarget = $(this);
			btnTarget.addClass('layui-btn-disabled');
			
			var url = rf.isEmpty(id) ? "/user/editPassword" : "/user/editPassword/" + id;
			
			$.ajax({
				type : "PUT",
				url : WEB_ROOT + url,
				dataType : 'json',
				data : {
					oldLoginPassword : oldLoginPassword,
					newLoginPassword : newLoginPassword,
					sureLoginPassword : sureLoginPassword
				},
				success : function(res) {
					btnTarget.removeClass('layui-btn-disabled');
					btnTarget.attr("disabled",false);
					var callback = null;
					if(res.code == 0){
						callback = function(){
							window.location.href = WEB_ROOT+'/user/information';
						};
					}
					common_ops.alert(res.msg,callback);
				}
			});
		});
		
		// 重新渲染页面
		layui.use('element', function() {
	       var element = layui.element;
	       element.init();
	    });
		
	},
	
	// 初始化页面参数
	inintComponent : function() {
		var id = common_ops.g_getQueryString("id");	
		if(id != null){
			$("#oldLoginPassword").hide();
			$("#sureLoginPassword").hide();
		}
	}
};

$(function() {
	user_password_ops.inint();
})