;
var commision_info_ops = {
		init:function(){
			this.eventBind();
			this.inintComponent();
		},
		eventBind:function(){
			
		},
		inintComponent:function(){
			var id = common_ops.g_getQueryString("id");
			
			$.ajax({
				url:WEB_ROOT+'/commision/message',
				type:'get',
				async:false,
				data:{
					id:id
				},
				dataType:'json',
				success:function(res){
					$("input[name='orderNo']").attr("value",res.data.orderNo);
					
					//对时间进行处理
					var atime = res.data.createTime;
					var time = 1900+atime.year+"-"+(atime.month+1)+"-"+atime.date+" "+atime.hours+":"+atime.minutes
					
					$("input[name='createTime']").attr("value",time);
					$("input[name='totalAmount']").attr("value",res.data.totalAmount);
					$("input[name='commision']").attr("value",res.data.commision);
					$("input[name='percent']").attr("value",res.data.percent);
					$("textarea[name='nicknames']").val(res.data.nicknames);
				}
			})
		}
}
$(function(){
	commision_info_ops.init();
})
