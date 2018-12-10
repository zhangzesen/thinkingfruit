;
var commsion_index_ops = {
	init : function() {
		this.initComponent();
		this.eventBind();
	},
	initComponent : function() {
		$.ajax({
			url:WEB_ROOT + "/commision/list",
			type:'get',
			dataType:'json',
			success:function(res){
				console.log(res.data);
				for (var i = 0; i < res.data.length; i++) {
					if(res.data[i].commision!=null){
 					$("#tab1").append('<div class="aui-order-list">'+'<div class="aui-flex">'
                    +'<div class="aui-flex-box">'+"<h3>"+"订单号:"+"<i>"+res.data[i].orderNo+"</i>"+"</h3>"+"</div>"+"</div>"+"<div class='aui-flex aui-flex-order'>"+"<div class='aui-order-img'>"
                    +'<img src="'+res.data[i].coverImagePath+'" alt="">'+"</div>"+'<div class="aui-flex-box">'+"<h2>"+res.data[i].name+"</h2>"
                    +"<h4>"+"订单金额￥"+"<i>"+res.data[i].orderAmout+"</i>"+" 佣金"+"<em>"+"￥"+res.data[i].commision+"</em>"+"</h4>"+"</div>"+"</div>"+'<div class="aui-flex aui-flex-button">'
                    +'<div class="aui-flex-box time">'+"<h3>"+res.data[i].createTime+"</h3>"+"</div>"+"</div>"+"</div>"+"</div>")
					}else{
				    $("#tab2").append('<div class="aui-order-list">'+'<div class="aui-flex">'
		                    +'<div class="aui-flex-box">'+"<h3>"+"订单号:"+"<i>"+res.data[i].orderNo+"</i>"+"</h3>"+"</div>"+"</div>"+"<div class='aui-flex aui-flex-order'>"+"<div class='aui-order-img'>"
		                    +'<img src="'+res.data[i].coverImagePath+'" alt="">'+"</div>"+'<div class="aui-flex-box">'+"<h2>"+res.data[i].name+"</h2>"
		                    +"<h4>"+"订单金额￥"+"<i>"+res.data[i].orderAmout+"</i>"+" 邀请金"+"<em>"+"￥"+res.data[i].commision+"</em>"+"</h4>"+"</div>"+"</div>"+'<div class="aui-flex aui-flex-button">'
		                    +'<div class="aui-flex-box time">'+"<h3>"+res.data[i].createTime+"</h3>"+"</div>"+"</div>"+"</div>"+"</div>")
				   
					};
				}
			}
		});
		
		

	},
	eventBind : function() {
		
	},
	

}

$(function() {
	commsion_index_ops.init();
})