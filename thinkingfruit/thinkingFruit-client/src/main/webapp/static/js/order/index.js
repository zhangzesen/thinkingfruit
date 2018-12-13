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
					$("#tab1").append('<div class="aui-order-list">'+'<div class="aui-flex">'
		                    +'<div class="aui-flex-box">'+"<h3>"+"已买入"+"</h3>"+"</div>"+"</div>"+"<div class='aui-flex aui-flex-order'>"+"<div class='aui-order-img'>"
		                    +'<img src="'+res.data[i].coverImagePath+'" alt="">'+"</div>"+'<div class="aui-flex-box">'+"<h2>"+res.data[i].name+"</h2>"
		                    +"<h4>"+"共"+'<i class="count">'+res.data[i].count+"</i>"+"件商品"+"</h4>"+"</div>"+"</div>"+'<div class="aui-flex aui-flex-button">'
		                    +'<div class="aui-flex-box" value="'+res.data[i].count+'">'
		                    +'<button class="extract" value="'+res.data[i].commodityId+'">'+"提货"+"</button>"+"</div>"+'<div class="aui-flex-box" style="margin-left:-60%;">'+'<button class="supplement" value="'+res.data[i].commodityId+'">'+"补充"+"</button>"+"</div>"+"</div>"+"</div>")
				
				$(".supplement").bind("click",function(){
					var commodityId=$(this).attr("value");
					window.location.href = WEB_ROOT+'/home/info?id='+commodityId;
				})
				$(".extract").bind("click",function(){
					var count=$(this).parent().attr("value");
					var commodityId=$(this).attr("value");
					console.log("count"+count);
					console.log("commodityId"+commodityId);
					console.log("count"+count);
					window.location.href = WEB_ROOT+'/order/extract?commodityId='+commodityId+"&count="+count;
				})
				}
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
					var status = res.data[i].orderStatus;
					
					switch (status) {
					case "0":
 					$("#tab2").append('<div class="aui-order-list">'+'<div class="aui-flex">'
                    +'<div class="aui-flex-box">'+"<h3>"+"已申请，等待公司发货"+"</h3>"+"</div>"+"</div>"+"<div class='aui-flex aui-flex-order'>"+"<div class='aui-order-img'>"
                    +'<img src="'+res.data[i].coverImagePath+'" value="'+res.data[i].coverImagePath+'" alt="">'+"</div>"+'<div class="aui-flex-box">'+"<h2>"+res.data[i].orderMemberName+"</h2>"
                    +"<h4>"+"共"+'<i id="count">'+res.data[i].commodityCount+"</i>"+"件商品"+"</h4>"+"</div>"+"</div>"+'<div class="aui-flex aui-flex-button">'
                    +'<div class="aui-flex-box time">'+"<h3>"+new Date(res.data[i].createTime).format("yyyy-MM-dd hh:mm:ss")+"</h3>"+"</div>"+"</div>"+"</div>")
					break;
				    case "1":
				    $("#tab3").append('<div class="aui-order-list">'+'<div class="aui-flex">'
		                    +'<div class="aui-flex-box">'+"<h3>"+"公司已发货，等待收货"+"</h3>"+"</div>"+"</div>"+"<div class='aui-flex aui-flex-order'>"+"<div class='aui-order-img'>"
		                    +'<img src="'+res.data[i].coverImagePath+'" value="'+res.data[i].coverImagePath+'" alt="">'+"</div>"+'<div class="aui-flex-box">'+"<h2>"+res.data[i].orderMemberName+"</h2>"
		                    +"<h4>"+"共"+'<i id="count">'+res.data[i].commodityCount+"</i>"+"件商品"+"</h4>"+"</div>"+"</div>"+'<div class="aui-flex aui-flex-button">'
		                    +'<div class="aui-flex-box time">'+"<h3>"+new Date(res.data[i].confirmTime).format("yyyy-MM-dd hh:mm:ss")+"</h3>"+"</div>"+"</div>"+"</div>")
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