;
var news_index_ops = {
	init : function() {
		this.initComponent();
		this.eventBind();
	},
	initComponent : function() {
		function dateFtt(fmt,date)   
		   {  
		     var o = {   
		       "M+" : date.getMonth()+1,                 //月份   
		       "d+" : date.getDate(),                    //日   
		       "h+" : date.getHours(),                   //小时   
		       "m+" : date.getMinutes(),                 //分   
		       "s+" : date.getSeconds(),                 //秒   
		       "q+" : Math.floor((date.getMonth()+3)/3), //季度   
		       "S"  : date.getMilliseconds()             //毫秒   
		     };   
		     if(/(y+)/.test(fmt))   
		       fmt=fmt.replace(RegExp.$1, (date.getFullYear()+"").substr(4 - RegExp.$1.length));   
		     for(var k in o)   
		       if(new RegExp("("+ k +")").test(fmt))   
		     fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));   
		     return fmt;   
		   } 
		$.ajax({
			async: false,
			url:WEB_ROOT + "/news/list",
			type:'get',
			dataType:'json',
			success:function(res){
				console.log(res.data);
				for (var i = 0; i < res.data.length; i++) {
					console.log(res.data[i].name);
					$(".aui-scrollView").append('<div class="aui-card-list">'+'<div class="aui-card-list-header">'+res.data[i].name+'</div>'+'<div class="aui-card-list-content">'+'<img style="height:250px;" class="aaa" src="'+WEB_ROOT_ADMIN+res.data[i].coverImagePath+'"'+'value="'+res.data[i].id+'" />'+'</div>'+'<div class="aui-card-list-footer">'+dateFtt("yyyy-MM-dd hh:mm:ss",new Date(res.data[i].createTime))+'</div>'+'</div>')
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