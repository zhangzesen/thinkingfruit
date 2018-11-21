;
var role_set_ops = {
	inint : function() {
		this.inintComponent();
		this.eventBind();
	},
	eventBind : function() {
		var ids = [];
		// 获取角色ID
		var id = common_ops.g_getQueryString("id");	
		var treeUrl = rf.isEmpty(id) ? "/role/permissionTree" : "/role/permissionTree/" + id;
		$.ajax({
			url : WEB_ROOT + treeUrl,
			dataType : 'json',
			type : 'get',
			success : function(res) {
				layui.use('tree', function() {
					var tree = layui.tree({
						elem : '#permissionTree', // 指定元素，生成的树放到哪个元素上
						check : 'checkbox', // 勾选风格
						skin : 'as', // 设定皮肤
						change : function(item) { // checkbox获取选中的值
							ids=item;
						},
						data : {// 为元素添加额外数据，即在元素上添加data-xxx="yyy"，可选
							hasChild : true
						},
						nodes : res
					});

				});
			}
		})
		
		$(".layui-btn").click(function() {
			
			var userRoleNameTarget = $("input[name='name']");
			var userRoleName = userRoleNameTarget.val();
			var userRoleDescriptionTarget = $("textarea[name='description']");
			var userRoleDescription = userRoleDescriptionTarget.val();
			var idsTarget = $("#permissionTree");

			var id = $('input[name="id"]').val();
			var data = {
				"ids" : ids,
				"name" : userRoleName,
				"description" : userRoleDescription
				};
			var url = rf.isEmpty(id) ? "/role" : "/role/" + id;
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
							window.location.href = WEB_ROOT+'/role';
						};
					}
					common_ops.alert(res.msg,callback);
				},
				error:btnTarget.removeClass('layui-btn-disabled')
			});
		});
	},
	
	// 初始化页面参数
	inintComponent : function() {
	   var id = common_ops.g_getQueryString("id");	
	   if(id!=null){
		   $(".layui-input-block .layui-btn").empty();
		   $(".layui-input-block .layui-btn").append("立即修改");
		   
		   $(".layui-tab layui-tab-card .layui-tab-title").empty();
		   $(".layui-tab layui-tab-card .layui-tab-title").append("<li class='layui-this'>修改角色</li>");
		   
		   $(".add-edit").empty();
		   $(".add-edit").append("修改角色");
		   $.ajax({
			   data:{
				   id:id
			   },
			   type:'get',
			   url:WEB_ROOT+"/role/info",
			   dataType:'json',
			   success:function(res){
				   $("input[name='id']").attr("value",res.data.id);
				   $("input[name='name']").attr("value",res.data.name);
				   $("textarea[name='description']").val(res.data.description);
			   }
		   });
	   }
	}
};

$(function() {
	role_set_ops.inint();
})