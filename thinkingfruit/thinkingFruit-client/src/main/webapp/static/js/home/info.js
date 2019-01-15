;
var home_index_ops = {
	init : function() {
		this.initComponent();
		this.eventBind();
	},
	initComponent : function() {
		var id = common_ops.g_getQueryString('id');
		$.ajax({
			url:WEB_ROOT + "/home/details",
			 async: false,
			type:'get',
			data:{
				id:id
			},
			dataType:'json',
			success:function(res){
				console.log(res.data);
				$(".goods").append('<div class="aui-card-list-header" id="name">'+res.data.name+'</div>'+'<div class="aui-card-list-content">'
				+'<img src="'+WEB_ROOT_ADMIN+res.data.coverImagePath+'"'+'value="'+res.data.id+'"/>'+"</div>")
				$(".aui-card-list-footer #price").text(res.data.price);
				for (var i = 0; i < res.data.detailsImagePaths.length; i++) {
					console.log("detailsImagePaths==="+res.data.detailsImagePaths[i]);
					$(".descriptionImg").append("<p>"+'<img src="'+WEB_ROOT_ADMIN+'/'+res.data.detailsImagePaths[i]+'"/>'+"</p>");
				}
				$(".aui-page-box #description").text(res.data.description);
				$("#price").attr("value",res.data.price);
				//绑定监听事件
//				$('#count').bind('input propertychange', function() {
//					var temp=/^[0-9]*$/;
//					var Booleans=temp.test($('#count').val());
//					console.log($('#count').val())
//					if(Booleans==false){
//						common_ops.alert("请输入数字");
//						$('#count').val("");
//					}else if($(this).val().lenght<=5){
//						common_ops.alert("购买数量不能超过五位数");
//						$('#count').val("");
//					}else{
//		            $('#priceTall').html($(this).val()*res.data.price);}
//		        });
			}
		});
		var price=$("#price").attr('value');
		var name=$("#name").text();
		console.log("price"+price);
		$("#purchase").click(function(){
			window.location.href = WEB_ROOT+'/home/buy?id='+id+'&price='+price+'&name='+name;
		});
		$(".aui-footer #home").click(function(){
			window.location.href = WEB_ROOT+'/home';
		});
//		layui.use('upload', function() {
//			 var upload = layui.upload;
//			//凭证图片上传
//			 upload.render({
//					elem: '#uploadImage',
//					url : WEB_ROOT+'/upload/image?imageType=16',
//					done : function(res) {
//						console.log("res.data.imagePath"+res.data.imagePath);
//						// 上传成功返回值，必须为json格式
//						$("#uploadImage").attr("value",res.data.imagePath); 
//						$("#certificateImage").attr("src",WEB_ROOT + res.data.imagePath); 
//					}
//			});
//	   })
//		$("#purchase").click(function(){
//			console.log("购买");
//			var commodityPrice=$("#price").text();
//			var commodityName=$("#name").text();
//			var commodityCount=$("#count").val();
//			var orderTotalPrice=$("#priceTall").text();
//			var certificateImage=$("#uploadImage").attr("value");
//			console.log("certificateImage"+certificateImage)
//			if(commodityCount.length!=0&&certificateImage!=null&&certificateImage.length!=0){
//			$.ajax({
//				url:WEB_ROOT + "/home/purchase",
//				type:'POST',
//				data:{
//					commodityId:id,
//					commodityName:commodityName,
//					commodityCount:commodityCount,
//					commodityPrice:commodityPrice,
//					certificateImage:certificateImage,
//					orderTotalPrice:orderTotalPrice
//				},
//				dataType:'json',
//				success:function(res){
//					if(res.code==500057){
//						callback = function() {
//							window.location.href = WEB_ROOT+'my/information';
//						};
//						common_ops.alert(res.msg, callback);
//					}else{
//					callback = function() {
//						window.location.href = WEB_ROOT+'/home';
//					};
//					common_ops.alert(res.msg, callback);
//					};
//				}
//			});
//			}else{
//			common_ops.alert("请填写商品数量并上传交易凭证");}
//		})
	},
	eventBind : function() {
		
	},
	

}

$(function() {
	home_index_ops.init();
})