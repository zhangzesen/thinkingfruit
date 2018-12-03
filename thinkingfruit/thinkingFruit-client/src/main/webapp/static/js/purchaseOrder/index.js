;
var order_index_ops = {
	init : function() {
		this.initComponent();
		this.eventBind();
		this.getId();
	},
	initComponent : function() {
		$.ajax({
			url:WEB_ROOT + "/purchaseOrder/list",
			type:'get',
			dataType:'json',
			success:function(res){
				console.log(res.data);
				for (var i = 0; i < res.data.length; i++) {
					console.log(res.data[i].orderStatus);
					var status = res.data[i].orderStatus;
					switch (status) {
					case "1":
 					$("#tab1").append('<div class="aui-order-list">'+'<div class="aui-flex">'
                    +'<div class="aui-flex-box">'+"<h3>"+"我的需求"+"</h3>"+"</div>"+"</div>"+"<div class='aui-flex aui-flex-order'>"+"<div class='aui-order-img'>"
                    +'<img src="'+res.data[i].name+'" alt="">'+"</div>"+'<div class="aui-flex-box">'+"<h2>"+res.data[i].name+"</h2>"
                    +"<h4>"+"共"+"<i>"+res.data[i].name+"</i>"+"件商品 需付款"+"<em>"+"￥"+res.data[i].name+"</em>"+"</h4>"+"</div>"+"</div>"+'<div class="aui-flex aui-flex-button">'
                    +'<div class="aui-flex-box time">'+"<h3>"+res.data[i].name+"</h3>"+"</div>"+'<div class="aui-flex-box">'
                    +'<button class="aui-order-cancel">'+"取消订单"+"</button>"+"</div>"+"</div>"+"</div>")
					break;
				    case "2":
				    $("#tab2").append('<div class="aui-order-list">'+'<div class="aui-flex">'
		                    +'<div class="aui-flex-box">'+"<h3>"+"我的需求"+"</h3>"+"</div>"+"</div>"+"<div class='aui-flex aui-flex-order'>"+"<div class='aui-order-img'>"
		                    +'<img src="'+res.data[i].name+'" alt="">'+"</div>"+'<div class="aui-flex-box">'+"<h2>"+res.data[i].name+"</h2>"
		                    +"<h4>"+"共"+"<i>"+res.data[i].name+"</i>"+"件商品 需付款"+"<em>"+"￥"+res.data[i].name+"</em>"+"</h4>"+"</div>"+"</div>"+'<div class="aui-flex aui-flex-button">'
		                    +'<div class="aui-flex-box time">'+"<h3>"+res.data[i].name+"</h3>"+"</div>"+"</div>"
		                    +"</div>")
				    break;
				    case "4":
				    $("#tab3").append('<div class="aui-order-list">'+'<div class="aui-flex">'
		                    +'<div class="aui-flex-box">'+"<h4>"+"下级"+"<i>"+res.data[i].name+"</i>"+"的需求"+"</h4>"+"</div>"+"</div>"+"<div class='aui-flex aui-flex-order'>"+"<div class='aui-order-img'>"
		                    +'<img src="'+res.data[i].name+'" alt="">'+"</div>"+'<div class="aui-flex-box">'+"<h2>"+res.data[i].name+"</h2>"
		                    +"<h4>"+"共"+"<i>"+res.data[i].name+"</i>"+"件商品 需付款"+"<em>"+"￥"+res.data[i].name+"</em>"+"</h4>"+"</div>"+"</div>"+'<div class="aui-flex aui-flex-button">'
		                    +'<div class="aui-flex-box time">'+"<h3>"+res.data[i].name+"</h3>"+"</div>"+'<div class="aui-flex-box">'
		                    +'<button class="aui-order-cancel">'+"发货"+"</button>"+"</div>"+"</div>"+"</div>")
		            break;
				    case "5":
				    $("#tab4").append('<div class="aui-order-list">'+'<div class="aui-flex">'
		                    +'<div class="aui-flex-box">'+"<h4>"+"下级"+"<i>"+res.data[i].name+"</i>"+"的需求"+"</h4>"+"</div>"+"</div>"+"<div class='aui-flex aui-flex-order'>"+"<div class='aui-order-img'>"
		                    +'<img src="'+res.data[i].name+'" alt="">'+"</div>"+'<div class="aui-flex-box">'+"<h2>"+res.data[i].name+"</h2>"
		                    +"<h4>"+"共"+"<i>"+res.data[i].name+"</i>"+"件商品 需付款"+"<em>"+"￥"+res.data[i].name+"</em>"+"</h4>"+'<div class="aui-flex aui-flex-button">'
		                    +'<div class="aui-flex-box time">'+"<h3>"+res.data[i].name+"</h3>"+"</div>"+"</div>"
		                    +"</div>")
		            break;
				}
				}
			}
		});
		
		

	},
	eventBind : function() {
		
	},
	

}

$(function() {
	order_index_ops.init();
})