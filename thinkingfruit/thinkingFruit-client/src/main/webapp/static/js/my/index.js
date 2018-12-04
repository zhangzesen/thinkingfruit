;
var my_index_ops = {
	init : function() {
		this.initComponent();
		this.eventBind();
	},
	initComponent : function() {
		//修改完善信息
		$("#information").click(function(){
			window.location.href = WEB_ROOT+'/my/information';
		}),
		//用户退出
		$("#loginOut").click(function(){
			$.ajax({
				url:WEB_ROOT+'/my/loginOut',
				data:{},
				type:'GET',
				dataType:'json'
			}).done(function(res){
				if(res.code == 0){
					window.location.href = WEB_ROOT+'/agent/login';
				}
				
			});
		}),
		
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
	my_index_ops.init();
})