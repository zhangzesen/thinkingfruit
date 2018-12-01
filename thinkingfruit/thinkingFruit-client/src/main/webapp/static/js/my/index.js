;
var my_index_ops = {
	init : function() {
		console.log("123456789")
		this.initComponent();
		this.eventBind();
	},
	initComponent : function() {
		$("#information").click(function(){
			window.location.href = WEB_ROOT+'/my/information';
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