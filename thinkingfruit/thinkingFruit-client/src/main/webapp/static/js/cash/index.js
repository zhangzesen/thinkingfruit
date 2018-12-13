;
var cash_index_ops = {
	init : function() {
		this.initComponent();
	},
	initComponent : function() {
		$.ajax({
			url:WEB_ROOT+'/cash/balance',
			data:{},
			type:'GET',
			dataType:'json'
		}).done(function(res){
			console.log(res.data);
			$('#balance').append("<h4>"+"可提现余额(元)"+"</h4>"+
    		'<p type="text" id="balance">'+res.data.balance+"</input>")
			
		});
		$("#withdrawal").click(function(){
			var balance=$('p').text();
			console.log("balance"+balance);
			var cash=$('#cash').val();
			console.log("cash"+cash);
			var openBank=$('#openBank').val();
			var bankNumber=$('#bankNumber').val();
			var account=$('#account').val();
			if(cash>balance){
				common_ops.alert("余额不足！")
			}else{
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
					common_ops.alert("提现成功，等待转账")
				}
				
			});
			}
		});
	},
	

}

$(function() {
	cash_index_ops.init();
})