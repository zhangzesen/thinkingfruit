;
var my_information_ops = {
	init : function() {
		this.initComponent();
		this.eventBind();
	},
	initComponent : function() {
		$.ajax({
			url:WEB_ROOT+'/agent/information',
			data:{},
			type:'GET',
			dataType:'json'
		}).done(function(res){
			console.log(res.data);
			if(res.code == 0){
				$('#id').val(res.data.id);
				$('#loginName').val(res.data.loginName);
				$('#gender').val(res.data.gender);
				$('#mobile').val(res.data.mobile);
				$('#name').val(res.data.name);
				$('#inviterId').val(res.data.inviterId);
				$('#inviterUpperId').val(res.data.inviterUpperId);
				$('#identityNo').val(res.data.identityNo);
				$('#memberLevelId').val(res.data.memberLevelId);
			}
			
		});
		
		
		$("#home").click(function(){
			window.location.href = WEB_ROOT+'/home';
		}),
		$("#news").click(function(){
			console.log("news")
			window.location.href = WEB_ROOT+'/news';
		}),
		$("#my").click(function(){
			window.location.href = WEB_ROOT+'/my';
		});

	},
	eventBind : function() {
		$("#update").click(function(){
			var id=$('#id').val();
			var gender=$('#gender').val();
			var mobile=$('#mobile').val();
			var name=$('#name').val();
			var identityNo=$('#identityNo').val();
			var loginName=$('#loginName').val();
			var inviterId=$('inviterId').val();
			var inviterUpperId=$('#inviterUpperId').val();
			var memberLevelId=$('#memberLevelId').val();
			console.log("id"+id);
			console.log("gender"+gender);
			console.log("mobile"+mobile);
			console.log("name"+name);
			console.log("identityNo"+identityNo);
			$.ajax({
				url:WEB_ROOT+'/my/update',
				data:{
					id:id,
					gender:gender,
					mobile:mobile,
					name:name,
					identityNo:identityNo
				},
				type:'PUT',
				dataType:'json'
			}).done(function(res){
				console.log(res.data);
				if(res.code == 0){
					window.location.href = WEB_ROOT+'/my';
				}
				
			});
		});
	},
	

}

$(function() {
	my_information_ops.init();
})