;
var home_index_ops = {
	init : function() {
		this.initComponent();
		this.eventBind();
	},
	initComponent : function() {
		var id = common_ops.g_getQueryString('id');
		$.ajax({
			url:WEB_ROOT + "/home/details",
			type:'get',
			data:{
				id:id
			},
			dataType:'json',
			success:function(res){
				console.log(res.data);
				$(".aui-content").append('<div class="aui-card-list">'+'<div class="aui-card-list-header">'+res.data.name+'</div>'+'<div class="aui-card-list-content">'+'<img src="'+res.data.coverImagePath+'"'+'value="'+res.data.id+'" />'+'</div>'+'</div>')
				$(".aui-course-list #price").text(res.data.price);
				for (var i = 0; i < res.data.detailsImagePaths.length; i++) {
					console.log("detailsImagePaths==="+res.data.detailsImagePaths[i]);
					$(".aui-page-box").append('<p><img src="'+res.data.detailsImagePaths[i]+'/>"</p>');
				}
				$(".aui-page-box #description").text(res.data.description);
			}
		});
		
		$(".aui-footer #home").click(function(){
			window.location.href = WEB_ROOT+'/home';
		});
		
		$(".aui-footer #purchase").click(function(){
			window.location.href = WEB_ROOT+'/home/set';
		});
	},
	eventBind : function() {
		
	},
	

}

$(function() {
	home_index_ops.init();
})