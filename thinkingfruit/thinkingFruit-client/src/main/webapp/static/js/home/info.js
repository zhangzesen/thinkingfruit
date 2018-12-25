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
			type:'get',
			data:{
				id:id
			},
			dataType:'json',
			success:function(res){
				console.log(res.data);
				$(".goods").append('<div class="aui-card-list-header">'+res.data.name+'</div>'+'<div class="aui-card-list-content">'
				+'<img src="'+WEB_ROOT_ADMIN+res.data.coverImagePath+'"'+'value="'+res.data.id+'"/>'+"</div>")
				$(".aui-card-list-footer #price").text(res.data.price);
				for (var i = 0; i < res.data.detailsImagePaths.length; i++) {
					console.log("detailsImagePaths==="+res.data.detailsImagePaths[i]);
					$(".descriptionImg").append('<p><img src="'+WEB_ROOT_ADMIN+'/'+res.data.detailsImagePaths[i]+'/>"</p>');
				}
				$(".aui-page-box #description").text(res.data.description);
				//绑定监听事件
				$('#count').bind('input propertychange', function() {
					var temp=/^[0-9]*$/;
					var Booleans=temp.test($('#count').val());
					console.log($('#count').val())
					if(Booleans==false){
						common_ops.alert("请输入数字");
						$('#count').val("");
					}else{
		            $('#priceTall').html($(this).val()*res.data.price);}
		        });

				
			}
		});
		
		$(".aui-footer #home").click(function(){
			window.location.href = WEB_ROOT+'/home';
		});
		
		$("#purchase").click(function(){
			console.log("购买");
			var commodityPrice=$("#price").text();
			var commodityName=$("#name").text();
			var commodityCount=$("#count").val();
			var orderTotalPrice=$("#priceTall").text();
			$.ajax({
				url:WEB_ROOT + "/home/purchase",
				type:'POST',
				data:{
					commodityId:id,
					commodityName:commodityName,
					commodityCount:commodityCount,
					commodityPrice:commodityPrice,
					orderTotalPrice:orderTotalPrice
				},
				dataType:'json',
				success:function(res){
					callback = function() {
						window.location.href = WEB_ROOT+'/home';
					};
					common_ops.alert(res.msg, callback);
				}
			});
		})
	},
	eventBind : function() {
		
	},
	

}

$(function() {
	home_index_ops.init();
})