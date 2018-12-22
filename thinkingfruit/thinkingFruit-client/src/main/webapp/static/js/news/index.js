;
var news_index_ops = {
	init : function() {
		this.initComponent();
		this.eventBind();
	},
	initComponent : function() {
		$.ajax({
			url:WEB_ROOT + "/news/list",
			type:'get',
			dataType:'json',
			success:function(res){
				console.log(res.data);
				for (var i = 0; i < res.data.length; i++) {
					console.log(res.data[i].name);
					$(".aui-scrollView").append('<div class="aui-card-list">'+'<div class="aui-card-list-header">'+res.data[i].name+'</div>'+'<div class="aui-card-list-content">'+'<img src="'+WEB_ROOT_ADMIN+res.data[i].coverImagePath+'"'+'value="'+res.data[i].id+'" />'+'</div>'+'<div class="aui-card-list-footer">'+res.data[i].createTime+'</div>'+'</div>')
			    }
				$(".aui-card-list").bind("click",function(){
					var id= $(this).find('img').attr("value");
					window.location.href = WEB_ROOT + '/news/info?id='+id;
					});
			}
		});
		
		
		
		$("#home").click(function(){
			window.location.href = WEB_ROOT+'/home';
		}),
		$("#news").click(function(){
			console.log("news")
			window.location.href = WEB_ROOT+'/news';
		}),
		$("#my").click(function(){
			window.location.href = WEB_ROOT+'/my';
		});

	},
	eventBind : function() {
		
	},
	

}

$(function() {
	news_index_ops.init();
})