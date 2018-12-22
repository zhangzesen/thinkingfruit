;
var home_index_ops = {
	init : function() {
		this.initComponent();
	},
	initComponent : function() {
		console.log("zz");
		console.log(WEB_ROOT);
		console.log(WEB_ROOT_ADMIN);
		$.ajax({
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
					console.log("id--->"+id)
					window.location.href = WEB_ROOT + '/home/info?id='+id;
				});
			}
		});
		$.ajax({
			url:WEB_ROOT + "/home/imgList",
			type:'get',
			dataType:'json',
			success:function(res){
				console.log("123456789"+res.data);
				for (var i = 0; i < res.data.length; i++) {
					console.log(res.data[i].coverImagePath);
					$(".slider-wrapper").append('<div class="slider-item">'
					+'<a href="<%=basePath%>/home/info?id='+res.data[i].id+'">'+'<img src="'+WEB_ROOT_ADMIN+res.data[i].coverImagePath+'">'+
				     "</a>"+"</div>")
			    }
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