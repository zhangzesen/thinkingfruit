;
var news_index_ops = {
	init : function() {
		console.log("123456789")
		this.initComponent();
		this.eventBind();
	},
	initComponent : function() {
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
	news_index_ops.init();
})