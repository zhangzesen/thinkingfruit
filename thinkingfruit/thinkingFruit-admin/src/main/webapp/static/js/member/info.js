;
var member_info_ops = {
		init:function(){
			this.inintComponent();
			this.eventBind();
		},
		eventBind:function(){
			
		},
		inintComponent:function(){
			//查询用户详细信息
			var id = common_ops.g_getQueryString("id");
			console.log(id);
			$.ajax({
				url:WEB_ROOT+'/member/selectInfo',
				type:'get',
				async:false,
				data:{
					id:id
				},
				dataType:'json',
				success:function(res){
					console.log(res)
					$("input[name='nicknameStr']").attr("value",res.data.nicknameStr);
					$("input[name='gender']").attr("value",res.data.gender);
					$("input[name='mobile']").attr("value",res.data.mobile);
					$("input[name='country']").attr("value",res.data.country);
					$("input[name='city']").attr("value",res.data.city);
					$("input[name='identityNo']").attr("value",res.data.identityNo);
					$("input[name='level']").attr("value",res.data.level);
					$("input[name='parentMemberId']").attr("value",res.data.parentMemberId);
				}
			})
		}
}
$(function(){
	member_info_ops.init();
})