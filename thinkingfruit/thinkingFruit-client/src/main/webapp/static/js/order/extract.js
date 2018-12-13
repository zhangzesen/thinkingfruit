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
		console.log("count--->"+count);
		$("button").click(function(){
			$that = $(this);
			// 在点击事件之间需要讲按钮置灰
			$that.attr("disabled","true");
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
				
				console.log(res.data);
				if(res.code == 0){
					callback = function() {
						window.location.href = WEB_ROOT+'/order/depot';
					};
					common_ops.alert(res.msg, callback);
				}
				
			});
		}else{
			common_ops.alert("提取数量大于余额！");
			$that.removeAttr("disabled");
		};
		});
		
	},
	

}

$(function() {
	order_extract_ops.init();
})