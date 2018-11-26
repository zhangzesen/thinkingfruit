;
var permission_set_ops={
	init:function(){
		this.inintComponent();
		this.eventbind();
		this.validateForm();
	},
	eventbind:function(){
		// 立即添加按钮的点击事件
		$(".layui-btn").click(function() {
			var nameTarget = $('input[name="name"]');
			var name = nameTarget.val();
			
			var urlTarget = $('input[name="url"]');
			var url =urlTarget.val();
			
			var hrefTarget = $('input[name="href"]');
			var href = hrefTarget.val();
			
			var levelTarget = $('input[name="level"]');
			var level = levelTarget.val();
			
			var parentIdTarget = $('.parentId option:selected');
			var parentId = parentIdTarget.val();
			
			var descriptionTarget = $('textarea[name="description"]');
			var description = descriptionTarget.val();
			
			var data = {
				name : name,
				url : url,
				href : href,
				level : level,
				description : description,
				parentId : parentId
			};

			var id = common_ops.g_getQueryString("id");	
			// 判断是添加还是修改
			var url = rf.isEmpty(id) ? "/permission" : "/permission/" + id;
			var type = rf.isEmpty(id) ? 'POST' : 'PUT';
			
			$(".layui-btn").addClass('layui-btn-disabled');
			$.ajax({
				type : type,
				url : WEB_ROOT + url,
				dataType : 'json',
				data :data,
				success:function(res){
					$(".layui-input-block .layui-btn").removeClass("layui-btn-disabled");
					var callback = null;
					if (res.code == 0) {
						callback = function() {
							window.location.href = WEB_ROOT + '/permission';
						};
					}
					common_ops.alert(res.msg, callback);
				}
		    });
	   })
	   
   },
   validateForm : function() {
//		return $(".layui-form").validate();
   },
   inintComponent : function() {
	   layui.use([ 'form', 'element', 'layer'], function() {
			layer = layui.layer;
			form = layui.form;
			element = layui.element;
	   // 获取连接中的参数id
	   var id = common_ops.g_getQueryString("id");
	   var parentIdTarget = $('select[name="parentId"]');
	   
	   // 获取所有权限,生成上级权限的下拉选框
		$.ajax({
			   url : WEB_ROOT + "/permission/all",
			   type : "GET",
			   success : function(res){
				   var str = '<option value="">请选择</option>' +
				   		'<option value="0" selected="">≡ 作为上级权限 ≡</option>';
				   for(var i = 0; i < res.length; i++){
					   str += '<option value="' + res[i].id + '"';
					   str += '>' + res[i].name + '</option>';
				   }
				   parentIdTarget.append(str);
				   form.render('select');
			   }
		   });
	   // 判断该操作是添加还是修改
	   if(id!=null){
		   $(".layui-input-block .layui-btn").empty();
		   $(".layui-input-block .layui-btn").append("立即修改");
		   
		   $(".layui-tab layui-tab-card .layui-tab-title").empty();
		   $(".layui-tab layui-tab-card .layui-tab-title").append("<li class='layui-this'>修改权限</li>");
			
		   $(".add-edit").empty();
		   $(".add-edit").append("修改权限");
		   $.ajax({
			   data : {
				   id : id
			   },
			   type : 'get',
			   url : WEB_ROOT + "/permission/info",
			   dataType : 'json',
			   success : function(res){
				   $("input[name='id']").attr("value",res.data.id);
				   $("input[name='name']").attr("value",res.data.name);
//				   $("input[name='parentId']").attr("value",res.data.parentId);
				   $("input[name='level']").attr("value",res.data.level);
				   $("input[name='url']").attr("value",res.data.url);
				   $("input[name='href']").attr("value",res.data.href);
				   $("textarea[name='description']").val(res.data.description);
				   
				   // 获取所有权限,生成上级权限的下拉选框
					$.ajax({
						   url : WEB_ROOT + "/permission/all",
						   type : "GET",
						   success : function(result){
							   var str = '<option value="">请选择</option>' +
							   		'<option value="0">≡ 作为上级权限 ≡</option>';
							   for(var i = 0; i < result.length; i++){
								   if(result[i].id == res.data.parentId){
									   str += '<option value="' + result[i].id + '" selected=""';
									   str += '>' + result[i].name + '</option>';
								   }else{
									   str += '<option value="' + result[i].id + '"';
									   str += '>' + result[i].name + '</option>';
								   }
							   }
							   parentIdTarget.append(str);
							   form.render('select');
						   }
					   });
			   }
		   });
	   }else{
			// 获取所有权限,生成上级权限的下拉选框
			$.ajax({
				   url : WEB_ROOT + "/permission/all",
				   type : "GET",
				   success : function(res){
					   var str = '<option value="">请选择</option>' +
					   		'<option value="0" selected="">≡ 作为上级权限 ≡</option>';
					   for(var i = 0; i < res.length; i++){
						   str += '<option value="' + res[i].id + '"';
						   str += '>' + res[i].name + '</option>';
					   }
					   parentIdTarget.append(str);
					   form.render('select');
				   }
			   });
	   }
	   });
   }
   
};
$(function(){
	permission_set_ops.init();
})