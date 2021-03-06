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
				var expressNo = $("input[name='expressNo']").val();
				var logistics = $("select[name='logistics']").val();
				var orderStatus=$("input[name='orderStatus']").val();
				console.log("orderStatus=====>"+orderStatus);
				
				var status;
				switch (orderStatus) {
				   case "待发货":
					   status=0;
				     break;
				   case "待收货":
					   status=1;
				     break;
				   case "已完成":
					   status=2;
				     break;
				}
				$(".layui-input-block .layui-btn").addClass('layui-btn-disabled');
				var type =common_ops.g_getQueryString("type");
				var url;
				//判断是发货还是取消订单
				if(type== 'deliver'){
					url=WEB_ROOT + "/order/deliver"
				}else if(type== 'cancel'){
					url=WEB_ROOT + "/order/cancel"
				}
				console.log("url"+url);
				$.ajax({
	  				url:url,
		  			type:'PUT',
		  			data:{
						id:id,
						expressNo:expressNo,
						logistics:logistics,
						orderStatus:status
					},
		  			dataType:'json'
	  			}).done(function(res){
	  				$(".layui-input-block .layui-btn").removeClass("layui-btn-disabled");
					var callback = null;
					if (res.code == 0) {
						callback = function() {
							window.location.href = WEB_ROOT + '/order';
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
				   url:WEB_ROOT+"/order/info",
				   dataType:'json',
				   async:false,
				   success:function(res){
					   console.log(res);
					   
					   /*--------------------------------------------	*/
					   //选择快递类型
					   var commodityId=res.data.commodityId;
					   var logistics = res.data.logistics;
							$.ajax({
								   data:{},
								   type:'GET',
								   url:WEB_ROOT+"/logistics",
								   dataType:'json',
								   async:false,
								   success:function(res){
									   console.log(res.data)
									   for(var i=0;i<res.data.length;i++){
										   if(logistics == res.data[i].logisticsNo){
											   $("#logistics").append("<option selected='selected' value='"+res.data[i].logisticsNo+"'>"+res.data[i].express+"</option")
										   }else{
											   $("#logistics").append("<option value='"+res.data[i].logisticsNo+"'>"+res.data[i].express+"</option")
										   }
									   }
									   form.render('select');
								   }
							   });
					  
					   
					   $("input[name='id']").attr("value",res.data.id);
					   $("input[name='orderNo']").attr("value",res.data.orderNo);
					   $("input[name='orderMemberName']").val(res.data.orderMemberName);
					   $("input[name='province']").attr("value",res.data.province);
					   $("input[name='city']").attr("value",res.data.city);
					   $("input[name='town']").attr("value",res.data.town);
					   $("input[name='address']").val(res.data.address);
					   $("input[name='remark']").attr("value",res.data.remark);
					   $("input[name='expressNo']").attr("value",res.data.expressNo);
					   $("input[name='commodityName']").attr("value",res.data.commodityName);
					   $("input[name='commodityCount']").attr("value",res.data.commodityCount);
					   $("select[name='logistics']").attr("value",res.data.logistics);
					   console.log("id"+id);
					   console.log("res.data.orderStatus"+res.data.orderStatus)
					   switch (res.data.orderStatus) {
					   case "0":
						   $("input[name='orderStatus']").val("待发货");
					     break;
					   case "1":
						   $("input[name='orderStatus']").val("待收货");
					     break;
					   case "2":
						   $("input[name='orderStatus']").val("已完成");
					     break;
					   }
					   
					   atime = res.data.confirmTime;
					   console.log(dateFtt("yyyy-MM-dd hh:mm:ss",new Date(atime)));
					   if(res.data.orderStatus==0){
						   $("input[name='confirmTime']").val("未发货");
					   }else{
						   $("input[name='confirmTime']").val(dateFtt("yyyy-MM-dd hh:mm:ss",new Date(atime)));
						   
					   }

					   
				   }
			   });
		   }
		   //添加info.jsp的按钮文字
		   	if(type == 'detail'){
			   $(".layui-input-block").empty();
			   $(".layui-input-block").append("<input onclick='history.go(-1)' type='button' value='返回' class='layui-btn layui-btn-lg'>");
			   
			}else if(type == 'cancel'){
				$(".layui-input-block").empty();
				$(".layui-input-block").append("<button class='layui-btn' lay-submit='' lay-filter='cate_add'>确认取消</button>");
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