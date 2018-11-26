;
var member_set_ops={
		init:function(){
			this.inintComponent();
			this.eventBind();
		},
		eventBind:function(){
			
			var that = this;
			
			// 立即添加按钮的点击事件
			console.log("even")
			$(".layui-input-block .layui-btn").on("click",function(){
					
				var level = $("select[name='level']").val();
				var parentMemberId = $("input[name='parentMemberId']").val();
				var id = common_ops.g_getQueryString("id");
				console.log("level--》"+level);
				console.log("parentMemberId--》"+parentMemberId);
				console.log(id);
						$(".layui-input-block .layui-btn").addClass('layui-btn-disabled');
						$.ajax({
							type :'PUT',
							url : WEB_ROOT + "/member/"+id,
							dataType : 'json',
							data : {
								id:id,
								level: level,
								parentMemberId : parentMemberId
							},
							success:function(res){
								$(".layui-input-block .layui-btn").removeClass("layui-btn-disabled");
								var callback = null;
								if (res.code == 0) {
									callback = function() {
										window.location.href = WEB_ROOT + '/member';
									};
								}
								common_ops.alert(res.msg, callback);
							},
							error:function(){
								$(".layui-input-block .layui-btn").removeClass("layui-btn-disabled");
							}
						});
		   });
		},
		inintComponent:function(){
			var id = common_ops.g_getQueryString("id");
			console.log("id-->"+id);
			$.ajax({
				url:WEB_ROOT+'/member/selectInfo',
				type:'get',
				async:false,
				data:{
					id:id
				},
				dataType:'json',
				success:function(res){
					//上级id
					$("input[name='parentMemberId']").attr("value",res.data.parentMemberId);
					//级别
					$('.layui-tab-content select[name="level"]').val(res.data.level);
					}
				
			})
		}
}
$(function(){
	 member_set_ops.init();
})