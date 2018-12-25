;
var member_setPswd_ops={
		init:function(){
			this.inintComponent();
			this.eventBind();
		},
		eventBind:function(){
			// 立即添加按钮的点击事件
			console.log("even")
			$(".layui-input-block .layui-btn").on("click",function(){
					
				var id = common_ops.g_getQueryString("id");
				console.log(id);
						$(".layui-input-block .layui-btn").addClass('layui-btn-disabled');
						$.ajax({
							type :'PUT',
							url : WEB_ROOT + "/member/updatePswd",
							dataType : 'json',
							data : {
								id:id,
								pswd:pswd,
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
		
		}
}
$(function(){
	 member_setPswd_ops.init();
})