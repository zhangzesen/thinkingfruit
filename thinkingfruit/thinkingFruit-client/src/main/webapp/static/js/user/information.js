;
var user_information_ops = {
	inint : function() {
		this.inintComponent();
		this.eventBind();
	},
	eventBind : function() {
		// 获取用户登录名
		var loginName = common_ops.g_getQueryString("loginName");	
		
		// 重新渲染页面
		layui.use('element', function() {
	       var element = layui.element;
	       element.init();
	    });
		
	},
	
	// 初始化页面参数
	inintComponent : function() {
		$.ajax({
			type : "GET",
			url : WEB_ROOT + "/user/info",
			dataType : "json",
			success:function(res){
				console.log(res.data);
				var loginNameTarget = $('input[name="loginName"]');
				loginNameTarget.val(res.data.loginName);
				
				var mobileTarget = $('input[name="mobile"]');
				mobileTarget.val(res.data.mobile);
				
				var emailTarget = $('input[name="email"]');
				emailTarget.val(res.data.email);
				
				var sexTarget = $('input[name="sex"]');
				if(res.data.sex == 0){
					sexTarget.val("男");
				}
				
				if(res.data.sex == 1){
					sexTarget.val("女");
				}

				var addressTarget = $('input[name="address"]');
				addressTarget.val(res.data.provName + "  " +
						res.data.cityName + "  " + res.data.townName);

				var statusTarget = $('input[name="status"]');
				if(res.data.status == 0){
					statusTarget.val("启用");
				}
				
				if(res.data.status == 1){
					statusTarget.val("禁用");
				}

				console.log(res.data.createTime.time);
				var createTimeTarget = $('input[name="createTime"]');
				createTimeTarget.val(getLocalTime(res.data.createTime.time));
//				var lastTimeTarget = $('input[name="lastTime"]');
//				lastTimeTarget.val(getLocalTime(res.data.loginOutTime.time));
				
				var roleNameTarget = $('input[name="roleName"]');
				roleNameTarget.val(res.data.roleName);
			}
		});
		
		function getLocalTime(nS) {  
		    var date = new Date(nS);
		    var yy = date.getFullYear();
		    var mm = date.getMonth()+1;
		    var dd = date.getDate();
		    var hh = date.getHours();
		    var mm = date.getMinutes();
		    var ss = date.getSeconds();
		    return yy+"-"+mm+"-"+dd + " " + hh + ":" + mm + ":" + ss;
		} 
	}
};

$(function() {
	user_information_ops.inint();
})