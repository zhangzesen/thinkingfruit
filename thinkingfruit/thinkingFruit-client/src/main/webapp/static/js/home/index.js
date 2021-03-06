;
var home_index_ops = {
	init : function() {
		this.initComponent();
	},
	initComponent : function() {
		$.ajax({
			async: false,
			url:WEB_ROOT + "/home/imgList",
			type:'get',
			dataType:'json',
			async:false,
			success:function(res){
				for (var i = 0; i < res.data.length; i++) {
					console.log(res.data[i].coverImagePath);
					$(".slider-wrapper").append('<div class="slider-item">'
					+'<a href="'+WEB_ROOT+'/home/info?id='+res.data[i].id+'">'+'<img src="'+WEB_ROOT_ADMIN+res.data[i].coverImagePath+'">'+
				     "</a>"+"</div>")
			    }
			}
		});
		$.ajax({
			async: false,
			url:WEB_ROOT + "/home/list",
			type:'get',
			dataType:'json',
			success:function(res){
				console.log(res.data);
				for (var i = 0; i < res.data.length; i++) {
					console.log(res.data[i].name);
					$(".aui-content").append('<div class="aui-card-list">'+'<div class="aui-card-list-header">'+res.data[i].name+'</div>'+'<div class="aui-card-list-content">'+'<img src="'+WEB_ROOT_ADMIN+res.data[i].coverImagePath+'"'+'value="'+res.data[i].id+'" />'+'</div>'+'</div>')
			    }
				$(".aui-card-list").bind("click",function(){
					var id= $(this).find('img').attr("value");
					window.location.href = WEB_ROOT + '/home/info?id='+id;
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

	}	

}

$(function() {
	home_index_ops.init();
})