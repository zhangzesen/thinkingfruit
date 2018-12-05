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
		$("button").click(function(){
			var name=$('.name').val();
			var mobile=$('.mobile').val();
			var takeCount=$('.takeCount').val();
			var province=$('.province').val();
			var city=$('.city').val();
			var town=$('.town').val();
			var address=$('.address').val();
			$.ajax({
				url:WEB_ROOT+'/order/send',
				data:{
					name:name,
					mobile:mobile,
					takeCount:takeCount,
					province:province,
					identityNo:identityNo,
					city:city,
			        town:town,
			        address:address
				},
				type:'PUT',
				dataType:'json'
			}).done(function(res){
				console.log(res.data);
				if(res.code == 0){
					window.location.href = WEB_ROOT+'/order/depot';
				}
				
			});
		});
	},
	

}

$(function() {
	order_extract_ops.init();
})