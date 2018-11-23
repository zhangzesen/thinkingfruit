var site_set_ops = {
	init : function() {
		this.inintComponent();
	},
	
	
	
	inintComponent : function() {
		
		var that = this;
		$(".layui-input-block button[lay-filter='site_edit']").html("立即修改");
		$(".layui-tab-title .ops-title").html("分佣修改");
	  	var id = common_ops.g_getQueryString("id");
	  	$.ajax({
	  		url:WEB_ROOT+'/site/'+id,
	  		type:'GET',
	  		dataType:'json'
	  	}).done(function(res){
	  		if(res.code == 0){
	  			//将从后台获取的值赋给jsp
	  			$('.layui-tab-content input[name="level"]').val(res.data.level);
	  			$('.layui-tab-content input[name="levelName"]').val(res.data.levelName);
	  			$('.layui-tab-content input[name="levelingDiscount"]').val(res.data.levelingDiscount);
	  			$('.layui-tab-content input[name="crossLevelDiscount"]').val(res.data.crossLevelDiscount);
	  			$('.layui-tab-content input[name="reverseLevelDiscount"]').val(res.data.reverseLevelDiscount);
	  		}else{
	  			common_ops.alert(res.msg);
	  		}
	  	});

		
		
		$(".layui-input-block .layui-btn").click(function(event) {
			
			$that = $(this);
			// 在点击事件之间需要讲按钮置灰
			$that.addClass('layui-btn-disabled');
			$that.attr("disabled","true");
				//从jsp获取值
			   var id =  common_ops.g_getQueryString("id");
               var levelName = $('.layui-form input[name="levelName"]').val();
               var levelingDiscount = $('.layui-form input[name="levelingDiscount"]').val();
               var crossLevelDiscount = $('.layui-form input[name="crossLevelDiscount"]').val();
               var reverseLevelDiscount = $('.layui-form input[name="reverseLevelDiscount"]').val();
			//向controller的update传商品数据
			   $.ajax({
				   url:WEB_ROOT+'/site/edit',
				   type:"PUT",
				   traditional: true,
				   data:{
					   id:id,
					   levelName:levelName,
					   levelingDiscount:levelingDiscount,
					   crossLevelDiscount:crossLevelDiscount,
					   reverseLevelDiscount:reverseLevelDiscount
				   },
				   dataType:'json'
	  			}).done(function(res){
	  				   var callback=function(){
						   $that.removeClass('layui-btn-disabled');
						   $that.removeAttr("disabled");
					   };
					   var msg = res.msg;
					   if(res.code == 0){
						   window.location.href = WEB_ROOT+'/site';
						   common_ops.alert(msg, callback);
					   }else{
						   common_ops.alert(msg, callback);
					   }
	  				});
		});
	}
};


$(function() {
	site_set_ops.init();
});
