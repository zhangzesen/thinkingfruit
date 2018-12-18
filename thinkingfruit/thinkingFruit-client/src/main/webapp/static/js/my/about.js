;
var my_about_ops = {
	init : function() {
		this.initComponent();
		this.eventBind();
	},
	initComponent : function() {
		var id = common_ops.g_getQueryString('id');
		$.ajax({
			url:WEB_ROOT + "/my/findAbout",
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
	},
	eventBind : function() {
		
	},
	

}

$(function() {
	 my_about_ops.init();
})