;
var commsion_index_ops = {
	init : function() {
		this.initComponent();
		this.eventBind();
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
			url:WEB_ROOT + "/commision/totalCommision",
			type:'get',
			dataType:'json',
			success:function(res){
				$('#totalCommision').append('<h4 style="height:40px;line-height:40px;text-indent:10px;color:#bbb;font-size:16px">'+"总佣金(元)"+"</h4>"
	    		+'<p style="height:80px;line-height:60px;text-align:center;color:#666;font-size:24px">'+res.data.totalCommision+"</p>")
			}}),
			$.ajax({
				url:WEB_ROOT + "/commision/totalInviteMoney",
				type:'get',
				dataType:'json',
				success:function(res){
					$('#totalInviteMoney').append('<h4 style="height:40px;line-height:40px;text-indent:10px;color:#bbb;font-size:16px">'+"总邀请金(元)"+"</h4>"
				    		+'<p style="height:80px;line-height:60px;text-align:center;color:#666;font-size:24px">'+res.data.totalInviteMoney+"</p>")
				}}),
		$.ajax({
			url:WEB_ROOT + "/commision/list",
			type:'get',
			dataType:'json',
			success:function(res){
				console.log(res.data);
				if(res.data.length==0){
					$("#tab1").append('<div class="aui-login-line" id="info">'+
                    "<h2>"+"暂无佣金"+"</h2>"+"</div>");
				}else{
				for (var i = 0; i < res.data.length; i++) {
					if(res.data[i].commision!=null){
 					$("#tab1").append('<div class="aui-order-list">'+'<div class="aui-flex">'
                    +'<div class="aui-flex-box">'+"<h3>"+"订单号:"+"<i>"+res.data[i].orderNo+"</i>"+"</h3>"+"</div>"+"</div>"+"<div class='aui-flex aui-flex-order'>"+"<div class='aui-order-img'>"
                    +'<img src="'+res.data[i].avatar+'" alt="">'+"</div>"+'<div class="aui-flex-box">'+"<h2>"+res.data[i].name+"</h2>"
                    +"<h4>"+"订单金额￥"+"<i>"+res.data[i].totalAmount+"</i>"+" 佣金"+"<em>"+"￥"+res.data[i].commision+"</em>"+"</h4>"+"</div>"+"</div>"+'<div class="aui-flex aui-flex-button">'
                    +'<div class="aui-flex-box time">'+"<h3>"+dateFtt("yyyy-MM-dd hh:mm:ss",new Date(res.data[i].createTime))+"</h3>"+"</div>"+"</div>"+"</div>"+"</div>")
					};
				}
				}
			}
		});
		$.ajax({
			url:WEB_ROOT + "/commision/inviteMoneyList",
			type:'get',
			dataType:'json',
			success:function(res){
				console.log(res.data);
				if(res.data.length==0){
					$("#tab2").append('<div class="aui-login-line" id="info">'+
                    "<h2>"+"暂无佣金"+"</h2>"+"</div>");
				}else{
				for (var i = 0; i < res.data.length; i++) {
					if(res.data[i].commision!=null){
 					$("#tab2").append('<div class="aui-order-list">'+'<div class="aui-flex">'
                    +'<div class="aui-flex-box">'+"<h3>"+"订单号:"+"<i>"+res.data[i].orderNo+"</i>"+"</h3>"+"</div>"+"</div>"+"<div class='aui-flex aui-flex-order'>"+"<div class='aui-order-img'>"
                    +'<img src="'+res.data[i].avatar+'" alt="">'+"</div>"+'<div class="aui-flex-box">'+"<h2>"+res.data[i].name+"</h2>"
                    +"<h4>"+"订单金额￥"+"<i>"+res.data[i].totalAmount+"</i>"+"邀请金"+"<em>"+"￥"+res.data[i].inviteMoney+"</em>"+"</h4>"+"</div>"+"</div>"+'<div class="aui-flex aui-flex-button">'
                    +'<div class="aui-flex-box time">'+"<h3>"+dateFtt("yyyy-MM-dd hh:mm:ss",new Date(res.data[i].createTime))+"</h3>"+"</div>"+"</div>"+"</div>"+"</div>")
					};
				}
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