;
var order_info_ops={
		init:function(){
			this.inintComponent();
			this.eventbind();
		},eventbind:function(){
		
			
			// 立即添加按钮的点击事件
			$('#button').on('click',function () {
				
				//var id = $("input[name='id']").val();
				var id = common_ops.g_getQueryString("id");
				console.log("参数："+id);
				$(".layui-input-block .layui-btn").addClass('layui-btn-disabled');
				var type =common_ops.g_getQueryString("type");
				$.ajax({
	  				url:WEB_ROOT + "/purchase/deliver",
		  			type:'PUT',
		  			data:{
						id:id
					},
		  			dataType:'json'
	  			}).done(function(res){
	  				$(".layui-input-block .layui-btn").removeClass("layui-btn-disabled");
					var callback = null;
					if (res.code == 0) {
						callback = function() {
							window.location.href = WEB_ROOT + '/purchase';
						};
					}
					console.log(res);
					common_ops.alert(res.msg, callback);
	  			});
		   })
		   
		
		   
		   
	   },
		
	   
	   inintComponent : function() {
		   //时间格式
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
		   layui.use([ 'form', 'layer'], function() {
				var layer = layui.layer;// 弹出层
				var form = layui.form;
				
		   var id = common_ops.g_getQueryString("id");
		   var type =common_ops.g_getQueryString("type");
		   console.log("id"+id+"---->type"+type);
		   if(id!=null){
			   $(".layui-tab-title").empty();
			   $(".layui-tab-title").append("<li class='layui-this'>订单详情</li>");
			   
			   $.ajax({
				   data:{
					   id:id
				   },
				   type:'get',
				   url:WEB_ROOT+"/purchase/info",
				   dataType:'json',
				   async:false,
				   success:function(res){
					   console.log(res);
					   
					   /*--------------------------------------------	*/
					   //选择快递类型
					   
					   $("input[name='id']").attr("value",res.data.id);
					   $("input[name='orderNo']").attr("value",res.data.orderNo);
					   $("input[name='orderMemberName']").val(res.data.orderMemberName);
					   $("input[name='superiorMemberId']").attr("value",res.data.superiorMemberId);
					   $("input[name='inviterId']").attr("value",res.data.inviterId);
					   $("input[name='inviterProportion']").val(res.data.inviterProportion);
					   $("input[name='superiorProportion']").attr("value",res.data.superiorProportion);
					   $("input[name='commodityName']").attr("value",res.data.commodityName);
					   $("input[name='commodityCount']").attr("value",res.data.commodityCount);
					   $("input[name='commodityPrice']").attr("value",res.data.commodityPrice);
					   console.log("id"+id);
					   console.log("res.data.orderStatus"+res.data.orderStatus);
					   console.log("isFirst"+res.data.isFirst);
					   switch (res.data.orderStatus) {
					   case "1":
						   $("input[name='orderStatus']").val("已下单");
					     break;
					   case "2":
						   $("input[name='orderStatus']").val("已完成");
					     break;
					   }
					   switch (res.data.isFirst) {
					   case "0":
						   $("input[name='isFirst']").val("首单");
					     break;
					   case "1":
						   $("input[name='isFirst']").val("非首单");
					     break;
					   }
					   
					   atime = res.data.createTime;
					   console.log(dateFtt("yyyy-MM-dd hh:mm:ss",new Date(atime)));
					   $("input[name='createTime']").val(dateFtt("yyyy-MM-dd hh:mm:ss",new Date(atime)));
					   

					   
				   }
			   });
		   }
		   //添加info.jsp的按钮文字
		   	if(type == 'detail'){
			   $(".layui-input-block").empty();
			   $(".layui-input-block").append("<input onclick='history.go(-1)' type='button' value='返回' class='layui-btn layui-btn-lg'>");
			   
			}else if(type == 'deliver'){
				$(".layui-input-block").empty();
				$(".layui-input-block").append("<button class='layui-btn' lay-submit='' lay-filter='cate_add'>确认发货</button>");
			}
		  });
		   
	   }
};
$(function(){
	order_info_ops.init();
})