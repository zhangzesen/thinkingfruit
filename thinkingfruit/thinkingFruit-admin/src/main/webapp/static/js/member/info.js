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
				url:WEB_ROOT+'/member/details',
				type:'get',
				async:false,
				data:{
					id:id
				},
				dataType:'json',
				success:function(res){
					var memberLevelName;
					console.log(res.data);
					
					var memberLevelId= res.data.memberLevelId;
					console.log("memberLevelId"+memberLevelId);
					if(memberLevelId=='1'){
						memberLevelName="联创";
					}else if(memberLevelId=='2'){
						memberLevelName="春事";
					}else if(memberLevelId=='3'){
						memberLevelName="总监";
					}else if(memberLevelId=='4'){
						memberLevelName="SVIP";
					}else if(memberLevelId=='5'){
						memberLevelName="VIP";
					}else{
						memberLevelName="无级别";
					}
					console.log("memberLevelName"+memberLevelName);
					$("input[name='id']").attr("value",res.data.id);
					$("input[name='loginName']").attr("value",res.data.loginName);
					$("input[name='name']").attr("value",res.data.name);
					$("input[name='gender']").attr("value",res.data.gender);
					$("input[name='mobile']").attr("value",res.data.mobile);
					$("input[name='identityNo']").attr("value",res.data.identityNo);
					$("input[name='memberLevelId']").attr("value",memberLevelName);
					$("input[name='inviterId']").attr("value",res.data.inviterId);
					$("input[name='inviterUpperId']").attr("value",res.data.inviterUpperId);
					
				}
			})
		}
}
$(function(){
	member_info_ops.init();
})