;
var cash_index_ops = {
	init : function() {
		this.eventBind();
	},
	eventBind : function() {
		$("#withdrawal").click(function(){
			var cash=$('#cash').val();
			var openBank=$('#openBank').val();
			var bankNumber=$('#bankNumber').val();
			var account=$('#account').val();
			console.log("cash"+cash);
			console.log("openBank"+openBank);
			console.log("bankNumber"+bankNumber);
			console.log("account"+account);
			$.ajax({
				url:WEB_ROOT+'/cash/withdrawal',
				data:{
					cash:cash,
					openBank:openBank,
					bankNumber:bankNumber,
					account:account
				},
				type:'POST',
				dataType:'json'
			}).done(function(res){
				console.log(res.data);
				if(res.code == 0){
					window.location.href = WEB_ROOT+'/cash';
				}
				
			});
		});
	},
	

}

$(function() {
	cash_index_ops.init();
})