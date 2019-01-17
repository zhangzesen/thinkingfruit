;
var member_upExamineSet_ops={
		init:function(){
			this.inintComponent();
			this.eventBind();
		},
		eventBind:function(){
			
			var that = this;
			
			// 立即添加按钮的点击事件
			$(".layui-input-block .layui-btn").on("click",function(){
				if(memberLevelId.length==0||commodityId.length==0||commodityCount.length==0){
			    	common_ops.g_getQueryString("请填写完整信息")
			    }else{
			    	if(numValid(commodityId)&&numValid(commodityCount)&&commodityId>=0&&commodityCount>=0){	
				var memberLevelId = $("select[name='memberLevelId']").val();
				var commodityId = $("select[name='commodityId']").val();
				var commodityCount = $("input[name='commodityCount']").val();
				console.log("memberLevelId"+memberLevelId);
				console.log("commodityId"+commodityId);
				console.log("commodityCount"+commodityCount);
				var id = common_ops.g_getQueryString("id");
				console.log("id"+id);
				$(".layui-input-block .layui-btn").addClass('layui-btn-disabled');
					$.ajax({
						type :'POST',
						url : WEB_ROOT + "/purchase/upExamineUpdate",
						dataType : 'json',
						data : {
							orderMemberId:id,
							memberLevel: memberLevelId,
							commodityId:commodityId,
							commodityCount:commodityCount
						},
						success:function(res){
							$(".layui-input-block .layui-btn").removeClass("layui-btn-disabled");
							var callback = null;
							if (res.code == 0) {
								callback = function() {
									window.location.href = WEB_ROOT + '/member/upExamine';
								};
							}
							common_ops.alert(res.msg, callback);
						},
						error:function(){
							$(".layui-input-block .layui-btn").removeClass("layui-btn-disabled");
						}
					});}else{common_ops.alert("请填写正确的数字");}}
		   });
		},
		inintComponent:function(){
			$.ajax({
				url:WEB_ROOT+'/commodity/listCommodity',
				type:'get',
				async:false,
				dataType:'json',
				success:function(res){
					console.log(res.data);
					$.each(res.data, function(i, v) {
						$("select[name='commodityId']").append(
								"<option value=" + v.id + ">" + v.name
										+ "</option>");
					});
				}
			})
		}
}
$(function(){
	member_upExamineSet_ops.init();
})