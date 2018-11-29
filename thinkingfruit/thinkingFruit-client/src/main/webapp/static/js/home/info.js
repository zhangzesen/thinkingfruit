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
			}
		});
		
		$("#home").click(function(){
			window.location.href = WEB_ROOT+'/home';
		}),
		$("#news").click(function(){
			console.log("news")
			window.location.href = WEB_ROOT+'/home/news';
		}),
		$("#my").click(function(){
			window.location.href = WEB_ROOT+'/home/my';
		});

	},
	eventBind : function() {
		
	},
	

}

$(function() {
	home_index_ops.init();
})