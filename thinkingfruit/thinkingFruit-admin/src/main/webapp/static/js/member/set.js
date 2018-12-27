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
				var memberLevelId = $("select[name='memberLevelId']").val();
				var inviterId = $("input[name='inviterId']").val();
				console.log("inviterId"+inviterId);
				console.log("memberLevelId"+memberLevelId);
				var id = common_ops.g_getQueryString("id");
				console.log(id);
						$(".layui-input-block .layui-btn").addClass('layui-btn-disabled');
						$.ajax({
							type :'GET',
							url : WEB_ROOT + "/member/details",
							dataType : 'json',
							data : {
								id: inviterId
							},
							success:function(res){
							if(res.data.memberLevelId<=memberLevelId||inviterId==0){
								$.ajax({
									type :'PUT',
									url : WEB_ROOT + "/member/update",
									dataType : 'json',
									data : {
										id:id,
										memberLevelId: memberLevelId,
										inviterId : inviterId
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
							}else{
								common_ops.alert("邀请人级别必须大于等于本级别");
							}
							},
						});
					
		   });
		},
		inintComponent:function(){
			var id = common_ops.g_getQueryString("id");
			console.log("id-->"+id);
			$.ajax({
				url:WEB_ROOT+'/member/details',
				type:'get',
				async:false,
				data:{
					id:id
				},
				dataType:'json',
				success:function(res){
					//上级id
					$("input[name='inviterId']").attr("value",res.data.inviterId);
					//级别
					$('.layui-tab-content select[name="memberLevelId"]').val(res.data.memberLevelId);
					}
				
			})
		}
}
$(function(){
	 member_set_ops.init();
})