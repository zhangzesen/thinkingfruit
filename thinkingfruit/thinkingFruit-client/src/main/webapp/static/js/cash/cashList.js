;
var cash_cashList_ops = {
	init : function() {
		this.initComponent();
	},
	initComponent : function() {
		$.ajax({
			url:WEB_ROOT+'/cash/list',
			data:{},
			type:'GET',
			dataType:'json'
		}).done(function(res){
			console.log(res.data);
			if(res.code == 0){
				for (var i = 0; i < res.data.length; i++) {
					if(res.data[i].status==0){
						console.log("已申请");
						$("#tab1").append('<div class="aui-order-list"><div class="aui-flex"><div class="aui-flex-box"><h3>已申请</h3></div></div>'
							+'<div class="aui-flex aui-flex-order"><div class="aui-flex-box"><h2>银行:'+res.data[i].openBank+'</h2><h4>卡号:'+res.data[i].bankNumber+'</h4><h4>金额:'+res.data[i].cash+'元</h4></div></div>'
							+'<div class="aui-flex aui-flex-button"><div class="aui-flex-box time"><h3>发起申请时间:'+res.data[i].createTime+'</h3></div></div></div>'
						);
					}else if(res.data[i].status==1){
						console.log("已完成");
						$("#tab2").append('<div class="aui-order-list"><div class="aui-flex"><div class="aui-flex-box"><h3>已申请</h3></div></div>'
							+'<div class="aui-flex aui-flex-order"><div class="aui-flex-box"><h2>银行:'+res.data[i].openBank+'</h2><h4>卡号:'+res.data[i].bankNumber+'</h4><h4>金额:'+res.data[i].cash+'元</h4></div></div>'
							+'<div class="aui-flex aui-flex-button"><div class="aui-flex-box time"><h3>完成时间:'+res.data[i].updateTime+'</h3></div></div></div>'
						);
					}
				}
			}
			
		});
		
	}
	

}

$(function() {
	cash_cashList_ops.init();
})