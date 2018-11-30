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
				$(".aui-content").append('<div class="aui-card-list">'+'<div class="aui-card-list-header" id="name">'+res.data.name+'</div>'+'<div class="aui-card-list-content">'+'<img src="'+res.data.coverImagePath+'"'+'value="'+res.data.id+'" />'+'</div>'+'</div>')
				$(".aui-card-list-footer #price").text(res.data.price);
				for (var i = 0; i < res.data.detailsImagePaths.length; i++) {
					console.log("detailsImagePaths==="+res.data.detailsImagePaths[i]);
					$(".aui-page-box").append('<p><img src="'+res.data.detailsImagePaths[i]+'/>"</p>');
				}
				$(".aui-page-box #description").text(res.data.description);
				$('#count').bind('input propertychange', function() {
		            $('#priceTall').html($(this).val()*res.data.price);
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