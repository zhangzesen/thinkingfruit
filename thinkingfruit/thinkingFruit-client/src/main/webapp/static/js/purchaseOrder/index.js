;
var order_index_ops = {
	init : function() {
		this.initComponent();
		this.eventbind();
	},
	initComponent : function() {
		function dateFtt(fmt,date)   
		   {  
		     var o = {   
		       "M+" : date.getMonth()+1,                 //月份   
		       "d+" : date.getDate(),                    //日   
		       "h+" : date.getHours(),                   //小时   
		       "m+" : date.getMinutes(),                 //分   
		       "s+" : date.getSeconds(),                 //秒   
		       "q+" : Math.floor((date.getMonth()+3)/3), //季度   
		       "S"  : date.getMilliseconds()             //毫秒   
		     };   
		     if(/(y+)/.test(fmt))   
		       fmt=fmt.replace(RegExp.$1, (date.getFullYear()+"").substr(4 - RegExp.$1.length));   
		     for(var k in o)   
		       if(new RegExp("("+ k +")").test(fmt))   
		     fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));   
		     return fmt;   
		   } 
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
                    +'<div class="aui-flex-box">'+"<h3>"+"待上级确认订单"+"</h3>"+"</div>"+"</div>"+"<div class='aui-flex aui-flex-order'>"+"<div class='aui-order-img'>"
                    +'<img src="'+res.data[i].coverImagePath+'" alt="">'+"</div>"+'<div class="aui-flex-box">'+"<h2>"+res.data[i].commodityName+"</h2>"
                    +"<h4>"+"共"+"<i>"+res.data[i].commodityCount+"</i>"+"件商品 需付款"+"<em>"+"￥"+res.data[i].orderTotalPrice+"</em>"+"</h4>"+"</div>"+"</div>"+'<div class="aui-flex aui-flex-button">'
                    +'<div class="aui-flex-box time">'+"<h3>"+dateFtt("yyyy-MM-dd hh:mm:ss",new Date(res.data[i].createTime))+"</h3>"+"</div>"+'<div class="aui-flex-box">'
                    +'<button  class="cancel" value="'+res.data[i].orderNo+'" style="text-align: right;">'+"取消订单"+"</button>"+"</div>"+"</div>"+"</div>")
					break;
				    case "2":
				    $("#tab2").append('<div class="aui-order-list">'+'<div class="aui-flex">'
		                    +'<div class="aui-flex-box">'+"<h3>"+"上级已确认订单"+"</h3>"+"</div>"+"</div>"+"<div class='aui-flex aui-flex-order'>"+"<div class='aui-order-img'>"
		                    +'<img src="'+res.data[i].coverImagePath+'" alt="" value="'+res.data[i].commodityId+'">'+"</div>"+'<div class="aui-flex-box">'+"<h2>"+res.data[i].commodityName+"</h2>"
		                    +"<h4>"+"共"+"<i>"+res.data[i].commodityCount+"</i>"+"件商品 需付款"+"<em>"+"￥"+res.data[i].orderTotalPrice+"</em>"+"</h4>"+"</div>"+"</div>"+'<div class="aui-flex aui-flex-button">'
		                    +'<div class="aui-flex-box time">'+"<h3>"+dateFtt("yyyy-MM-dd hh:mm:ss",new Date(res.data[i].confirmTime))+"</h3>"+"</div>"+"</div>"
		                    +"</div>")
				    break;
				}
				}
				
				$(".cancel").bind("click",function(){
					console.log($(this).attr("value"));
					var that=$(this);
					var orderNo=$(this).attr("value");
					$.ajax({
		  				url:WEB_ROOT + "/purchaseOrder/cancel",
			  			type:'PUT',
			  			data:{
			  				orderNo:orderNo
						},
			  			dataType:'json'
		  			}).done(function(res){
		  				that.removeClass("layui-btn-disabled");
						var callback = null;
						if (res.code == 0) {
							callback = function() {
								window.location.href = WEB_ROOT + '/purchaseOrder';
							};
						}
						console.log(res);
						common_ops.alert(res.msg, callback);
		  			});
				});
			}
		});
		$.ajax({
			url:WEB_ROOT + "/purchaseOrder/needList",
			type:'get',
			dataType:'json',
			success:function(res){
				console.log(res.data);
				for (var i = 0; i < res.data.length; i++) {
					console.log(res.data[i].orderStatus);
					var status = res.data[i].orderStatus;
					switch (status) {
				    case "1":
				    $("#tab3").append('<div class="aui-order-list">'+'<div class="aui-flex">'
		                    +'<div class="aui-flex-box">'+"<h4>"+"下级申请购买订单"+"<i>"+res.data[i].orderMemberName+"</i>"+"的需求"+"</h4>"+"</div>"+"</div>"+"<div class='aui-flex aui-flex-order'>"+"<div class='aui-order-img'>"
		                    +'<img src="'+res.data[i].coverImagePath+'" alt="" >'+"</div>"+'<div class="aui-flex-box">'+"<h2>"+res.data[i].commodityName+"</h2>"
		                    +"<h4>"+"共"+"<i>"+res.data[i].commodityCount+"</i>"+"件商品 需付款"+"<em>"+"￥"+res.data[i].orderTotalPrice+"</em>"+"</h4>"+"</div>"+"</div>"+'<div class="aui-flex aui-flex-button">'
		                    +'<div class="aui-flex-box time">'+"<h3>"+dateFtt("yyyy-MM-dd hh:mm:ss",new Date(res.data[i].createTime))+"</h3>"+"</div>"+'<div class="aui-flex-box" >'
		                    +'<button class="confirm" value="'+res.data[i].orderNo+'">'+"发货"+"</button>"+"</div>"+"</div>"+"</div>")
		            break;
				    case "2":
				    $("#tab4").append('<div class="aui-order-list">'+'<div class="aui-flex">'
		                    +'<div class="aui-flex-box">'+"<h4>"+"已确认下级订单"+"<i>"+res.data[i].orderMemberName+"</i>"+"的需求"+"</h4>"+"</div>"+"</div>"+"<div class='aui-flex aui-flex-order'>"+"<div class='aui-order-img'>"
		                    +'<img src="'+res.data[i].coverImagePath+'" alt="" value="'+res.data[i].commodityId+'">'+"</div>"+'<div class="aui-flex-box">'+"<h2>"+res.data[i].commodityName+"</h2>"
		                    +"<h4>"+"共"+"<i>"+res.data[i].commodityCount+"</i>"+"件商品 需付款"+"<em>"+"￥"+res.data[i].orderTotalPrice+"</em>"+"</h4>"+"</div>"+"</div>"+'<div class="aui-flex aui-flex-button">'
		                    +'<div class="aui-flex-box time">'+"<h3>"+dateFtt("yyyy-MM-dd hh:mm:ss",new Date(res.data[i].confirmTime))+"</h3>"+"</div>"+"</div>"
		                    +"</div>")
		            break;
				}
				}
				$(".confirm").bind("click",function(){
					console.log($(this).attr("value"));
					var that=$(this);
					var orderNo=$(this).attr("value");
					$.ajax({
		  				url:WEB_ROOT + "/purchaseOrder/confirm",
			  			type:'PUT',
			  			data:{
			  				orderNo:orderNo
						},
			  			dataType:'json'
		  			}).done(function(res){
		  				that.removeClass("layui-btn-disabled");
						var callback = null;
						if (res.code == 0) {
							callback = function() {
								window.location.href = WEB_ROOT + '/purchaseOrder';
							};
						}
						console.log(res);
						common_ops.alert(res.msg, callback);
		  			});
				});
			}
		
		});
		

	},eventbind:function(){
		
	}
	

}

$(function() {
	order_index_ops.init();
})