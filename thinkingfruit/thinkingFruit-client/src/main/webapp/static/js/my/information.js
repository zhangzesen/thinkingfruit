;
var my_information_ops = {
	init : function() {
		this.initComponent();
		this.eventBind();
	},
	initComponent : function() {
		 layui.use('upload', function() {
			 var upload = layui.upload;
			//封面图片上传
			 upload.render({
					elem: '#set',
					url : WEB_ROOT+'/upload/image?imageType=2',
					done : function(res) {
						// 上传成功返回值，必须为json格式
						console.log("res"+res);
						$("img[name='HeadPortrait']").attr('src',WEB_ROOT + res.data.imagePath); 
					}
			 });
		 });
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
			
			//绑定监听事件
			$('#mobile').bind('input propertychange', function() {
				var temp=/^[1][3,4,5,7,8][0-9]{9}$/;
				var Booleans=temp.test($('#mobile').val());
				if(Booleans==false){
					common_ops.alert("请输入正确的号码");
					$('#mobile').val("");
				}
	        });
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