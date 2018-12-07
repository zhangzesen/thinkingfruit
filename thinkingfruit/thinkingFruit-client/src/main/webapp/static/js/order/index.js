;
var order_index_ops = {
	init : function() {
		this.initComponent();
		this.eventBind();
	},
	initComponent : function() {
		//云仓库列表
		$.ajax({
			url:WEB_ROOT + "/order/depotList",
			type:'get',
			dataType:'json',
			success:function(res){
				console.log(res.data);
				for (var i = 0; i < res.data.length; i++) {
					console.log("res1"+res.data[i].count);
					console.log("res2"+res.data[i].count);
					$("#tab1").append('<div class="aui-order-list">'+'<div class="aui-flex">'
		                    +'<div class="aui-flex-box">'+"<h3>"+"已买入"+"</h3>"+"</div>"+"</div>"+"<div class='aui-flex aui-flex-order'>"+"<div class='aui-order-img'>"
		                    +'<img src="'+res.data[i].name+'" alt="">'+"</div>"+'<div class="aui-flex-box">'+"<h2>"+res.data[i].name+"</h2>"
		                    +"<h4>"+"共"+'<i class="count" value="'+res.data[i].count+'">'+res.data[i].count+"</i>"+"件商品"+"</h4>"+"</div>"+"</div>"+'<div class="aui-flex aui-flex-button">'
		                    +'<div class="aui-flex-box time">'+"<h3>"+res.data[i].name+"</h3>"+"</div>"+'<div class="aui-flex-box">'
		                    +'<button class="extract" value="'+res.data[i].commodityId+'">'+"提货"+"</button>"+'<button class="supplement">'+"补充货物"+"</button>"+"</div>"+"</div>"+"</div>")
				
				}
				$(".supplement").bind("click",function(){
					window.location.href = WEB_ROOT+'/home';
				})
				$(".extract").bind("click",function(){
					var count=$(".count").attr("value");
					var commodityId=$(this).attr("value");
					console.log("count"+count);
					alert("commodityId"+commodityId);
					alert("count"+count);
					window.location.href = WEB_ROOT+'/order/extract?commodityId='+commodityId+"&count="+count;
				})
			}
		}),
		//订单列表
		$.ajax({
			url:WEB_ROOT + "/order/orderList",
			type:'get',
			dataType:'json',
			success:function(res){
				console.log(res.data);
				for (var i = 0; i < res.data.length; i++) {
					console.log("res2"+res.data[i].commodityCount);
					var status = res.data[i].orderStatus;
					switch (status) {
					case "0":
 					$("#tab2").append('<div class="aui-order-list">'+'<div class="aui-flex">'
                    +'<div class="aui-flex-box">'+"<h3>"+"已买入"+"</h3>"+"</div>"+"</div>"+"<div class='aui-flex aui-flex-order'>"+"<div class='aui-order-img'>"
                    +'<img src="'+res.data[i].name+'" value="'+res.data[i].name+'" alt="">'+"</div>"+'<div class="aui-flex-box">'+"<h2>"+res.data[i].name+"</h2>"
                    +"<h4>"+"共"+'<i id="count">'+res.data[i].commodityCount+"</i>"+"件商品"+"</h4>"+"</div>"+"</div>"+'<div class="aui-flex aui-flex-button">'
                    +'<div class="aui-flex-box time">'+"<h3>"+res.data[i].name+"</h3>"+"</div>"+"</div>"+"</div>")
					break;
				    case "1":
				    $("#tab3").append('<div class="aui-order-list">'+'<div class="aui-flex">'
		                    +'<div class="aui-flex-box">'+"<h3>"+"我的需求"+"</h3>"+"</div>"+"</div>"+"<div class='aui-flex aui-flex-order'>"+"<div class='aui-order-img'>"
		                    +'<img src="'+res.data[i].name+'" alt="">'+"</div>"+'<div class="aui-flex-box">'+"<h2>"+res.data[i].name+"</h2>"
		                    +"<h4>"+"共"+"<i>"+res.data[i].commodityCount+"</i>"+"件商品"+"</h4>"+"</div>"+"</div>"+'<div class="aui-flex aui-flex-button">'
		                    +'<div class="aui-flex-box time">'+"<h3>"+res.data[i].name+"</h3>"+"</div>"
		                    +"</div>"
		                    +"</div>")
				    break;
				}
					$(".Confirm").bind("click",function(){
						window.location.href = WEB_ROOT+'/home';
					})
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