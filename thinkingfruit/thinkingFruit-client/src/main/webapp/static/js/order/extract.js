;
var order_extract_ops = {
	init : function() {
		this.initComponent();
		this.eventBind();
	},
	initComponent : function() {
		var id = common_ops.g_getQueryString('id');
		var count = common_ops.g_getQueryString('count');
		console.log('count'+count);
		$.ajax({
			url:WEB_ROOT+'/order/extractInfo',
			data:{},
			type:'GET',
			dataType:'json'
		}).done(function(res){
			console.log(res.data);
			if(res.code == 0){
				$('.count').val(count);
				$('.name').val(res.data.memberName);
				$('.mobile').val(res.data.mobile);
				$('.province').val(res.data.province);
				$('.city').val(res.data.city);
				$('.town').val(res.data.town);
				$('.address').val(res.data.town);
			}
		});
	},
	eventBind : function() {
		var commodityId= common_ops.g_getQueryString('commodityId');
		var count = common_ops.g_getQueryString('count');
		$("button").click(function(){
			var cashCount=$('.cashCount').val();
			console.log("cashCount"+cashCount)
			var name=$('.name').val();
			var mobile=$('.mobile').val();
			var province=$('.province').val();
			var city=$('.city').val();
			var town=$('.town').val();
			var address=$('.address').val();
			if(cashCount<=count){
			$.ajax({
				url:WEB_ROOT+'/order/update',
				data:{
					commodityId:commodityId,
					cashCount:cashCount,
					name:name,
					mobile:mobile,
					province:province,
					city:city,
			        town:town,
			        address:address
				},
				type:'PUT',
				dataType:'json'
			}).done(function(res){
				alert("订单已生成，等待发货")
				console.log(res.data);
				if(res.code == 0){
					window.location.href = WEB_ROOT+'/order/depot';
				}
				
			});
		}else{
			alert("提取数量大于余额！");
		};
		});
		
	},
	

}

$(function() {
	order_extract_ops.init();
})