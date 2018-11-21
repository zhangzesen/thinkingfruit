;
var user_set_ops = {
	inint : function() {
		this.inintComponent();
		this.eventBind();
	},
	eventBind : function() {
		// 获取用户ID
		var id = common_ops.g_getQueryString("id");	
		
		// 失焦事件判断用户是否存在
		$("input[name='loginName']").blur(function(){
			var loginName = $(this).val();
			var data = rf.isEmpty(id) ? {loginName : loginName} : {loginName : loginName, id : id};
			$.ajax({
				type : "GET",
				url : WEB_ROOT + "/user/checkName",
				dataType : 'json',
				data : data,
				success : function(res) {
					var callback = null;
					if(res.code != 0){
						common_ops.alert(res.msg,callback);
					}
				},
			});
		});
		
		// 点击添加用户或者修改用户
		$(".layui-btn").click(function() {
			
			var nicknameTarget = $("input[name='nickname']");
			var nickname = nicknameTarget.val();
			
			var loginNameTarget = $("input[name='loginName']");
			var loginName = loginNameTarget.val();
			
			var sexTarget = $("input[name='sex']:checked");
			var sex = sexTarget.val();

			var emailTarget = $("input[name='email']");
			var email = emailTarget.val();

			var provNameTarget = $("select[name='provName']");
			var provName = provNameTarget.val();
			
			var cityNameTarget = $("select[name='cityName']");
			var cityName = cityNameTarget.val();
			
			var townNameTarget = $("select[name='townName']");
			var townName = townNameTarget.val();
			
			var mobileTarget = $("input[name='mobile']");
			var mobile = mobileTarget.val();
			
			var roleIdTarget = $("select[name='role'] option:selected");
			var roleId = roleIdTarget.val();
			
			// 如果id为空,为编辑操作..
			var loginPassword = null;
			var surePassword = null;
			if (id == null) {
				var loginPasswordTarget = $(".layui-form-item input[name='loginPassword']");
				loginPassword = loginPasswordTarget.val();

				var surePasswordTarget = $(".layui-form-item input[name='surePassword']");
				surePassword = surePasswordTarget.val();
			}else{
				loginPassword = "000000";
			}
			
			var data = {
				"nickname" : nickname,
				"loginName" : loginName,
				"sex" : sex,
				"email" : email,
				"provName" : provName,
				"cityName" : cityName,
				"townName" : townName,
				"mobile" : mobile,
				"roleId" : roleId,
				"pswd" : loginPassword,
				"surePassword" : surePassword
				};
			var url = rf.isEmpty(id) ? "/user" : "/user/" + id;
			var type = rf.isEmpty(id) ? 'POST' : 'PUT';
			
			var btnTarget = $(this);
			btnTarget.addClass('layui-btn-disabled');
			btnTarget.attr("disabled",true);
				
			$.ajax({
				type : type,
				url : WEB_ROOT + url,
				dataType : 'json',
				data : data,
				success : function(res) {
					btnTarget.removeClass('layui-btn-disabled');
					btnTarget.attr("disabled",false);
					var callback = null;
					if(res.code == 0){
						callback = function(){
							window.location.href = WEB_ROOT+'/user';
						};
					}
					common_ops.alert(res.msg,callback);
				},
				error:btnTarget.removeClass('layui-btn-disabled')
			});
		});
		
		// 重新渲染页面
//		layui.use('element', function() {
//	       var element = layui.element;
//	       element.init();
//	    });
		
	},
	
	// 初始化页面参数
	inintComponent : function() {
		layui.use([ 'form', 'element', 'layer'], function() {
			layer = layui.layer;
			form = layui.form;
			element = layui.element;
	   var id = common_ops.g_getQueryString("id");	
	   var roleTarget = $('select[name="role"]');
	  
	   
	   
	   if(id!=null){
		   $(".editbtn .layui-btn").empty();
		   $(".editbtn .layui-btn").append("立即修改");
		   
		   $(".layui-tab layui-tab-card .layui-tab-title").empty();
		   $(".layui-tab layui-tab-card .layui-tab-title").append("<li class='layui-this'>修改用户</li>");
		   
		   $(".add-edit").empty();
		   $(".add-edit").append("修改用户");
		   $.ajax({
			   data:{
				   id:id
			   },
			   type:'get',
			   url:WEB_ROOT+"/user/info",
			   dataType:'json',
			   success:function(res){
				   $("input[name='id']").attr("value",res.data.id);
				   $("input[name='nickname']").attr("value",res.data.nickname);
				   $("input[name='loginName']").attr("value",res.data.loginName);
				   $('input[type="radio"]').each(function (){ 
					   if($(this).val() == res.data.sex){
						   $(this).attr("checked","checked");
					   }else{
						   $(this).removeAttr("checked");
					   }
					}); 
				   form.render('radio');
				   
				   $("input[name='email']").val(res.data.email);
				   var defaults = {
							s1 : 'provName',
							s2 : 'cityName',
							s3 : 'townName',
							v1 : res.data.provName,
							v2 : res.data.cityName,
							v3 : res.data.townName
					};
				   treeSelect(defaults);
				   $("input[name='mobile']").val(res.data.mobile);
				   $.ajax({
					   url : WEB_ROOT + "/role/all",
					   type : "GET",
					   success : function(result){
						   var str = '<option value="">请选择</option>';
						   for(var i = 0; i < result.length; i++){
							   if(result[i].id == res.data.roleId){
								   str += '<option value="' + result[i].id + '" selected="selected"';
								   str += '>' + result[i].name + '</option>';
							   }else{
								   str += '<option value="' + result[i].id + '"';
								   str += '>' + result[i].name + '</option>';
							   }
						   }
						   roleTarget.append(str);
						   form.render('select');
					   }
				   });
				   $('#loginPassword').hide();
				   $('#surePassword').hide();
			   }
		   });
	   }else{
		   // 获取所有角色,生成角色下拉选框
		   $.ajax({
			   url : WEB_ROOT + "/role/all",
			   type : "GET",
			   success : function(res){
				   var str = '<option value="">请选择</option>';
				   for(var i = 0; i < res.length; i++){
					   str += '<option value="' + res[i].id + '"';
					   str += '>' + res[i].name + '</option>';
				   }
				   roleTarget.append(str);
				   form.render('select');
			   }
		   });
	   }
	});
	}
};

$(function() {
	user_set_ops.inint();
})