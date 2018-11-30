;
var news_info_ops = {
	init : function() {
		this.initComponent();
		this.eventBind();
	},
	initComponent : function() {
		var id = common_ops.g_getQueryString('id');
		$.ajax({
			url:WEB_ROOT + "/news/details",
			type:'get',
			data:{
				id:id
			},
			dataType:'json',
			success:function(res){
				console.log(res.data);
				console.log("11111"+res.data.content);
				$(".aui-scrollView").append(res.data.content)
			}
		});
		
		$(".aui-footer #home").click(function(){
			window.location.href = WEB_ROOT+'/home';
		});
		
		$(".aui-footer #news").click(function(){
			window.location.href = WEB_ROOT+'/news';
		});
		
		$(".aui-footer #my").click(function(){
			window.location.href = WEB_ROOT+'/my';
		});
	},
	eventBind : function() {
		
	},
	

}

$(function() {
	news_info_ops.init();
})