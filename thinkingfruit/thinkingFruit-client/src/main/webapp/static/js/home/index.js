;
var home_index_ops = {
	init : function() {
		this.initComponent();
		this.eventBind();
	},
	initComponent : function() {
		$.ajax({
			url:WEB_ROOT + "/home/list",
			type:'get',
			dataType:'json',
			success:function(res){
				console.log(res.data);
				for (var i = 0; i < res.data.length; i++) {
					console.log(res.data[i].name);
					$(".aui-content").append('<div class="aui-card-list">'+'<div class="aui-card-list-header">'+res.data[i].name+'</div>'+'<div class="aui-card-list-content">'+'<img src="'+res.data[i].coverImagePath+'"'+'value="'+res.data[i].id+'" />'+'</div>'+'</div>')
			    }
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
		$(".aui-content").click(function(){
			var id= $(this).find('img').attr("value");
			alert("id"+id);
			window.location.href = WEB_ROOT + '/home/info?id='+id;
		});
	},
	

}

$(function() {
	home_index_ops.init();
})