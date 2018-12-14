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
			// 在点击事件之间需要讲按钮置灰
			$that = $(this);
			$that.attr("disabled","true");
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
				console.log(res);
				if(res.code == 0){
					callback = function() {
						window.location.href = WEB_ROOT+'/cash';
					};
					common_ops.alert(res.msg, callback);
				}else if(res.code == -1){
					common_ops.alert(res.msg);
					$that.removeAttr("disabled");
				}
				
			});
			}
		});
	},
	

}

$(function() {
	cash_index_ops.init();
})