;
var team_index_ops = {
	init : function() {
		this.initComponent();
		this.eventBind();
	},
	initComponent : function() {
		$.ajax({
			url:WEB_ROOT + "/agent/teamList",
			type:'get',
			dataType:'json',
			success:function(res){
				console.log(res.data);
				for (var i = 0; i < res.data.length; i++) {
					console.log(res.data[i].name);
					$("#tab1").append('<div class="aui-order-list">'+'<div class="aui-flex">'
                    +'<div class="aui-flex-box">'+"<h3>"+res.data[i].name+"</h3>"+"</div>"+"<div class='aui-order-pay'>"
                    +"<p>"+res.data[i].name+"</p>"+"</div>"+"</div>"+"<div class='aui-flex aui-flex-order'>"+"<div class='aui-order-img'>"
                    +'<img src="'+res.data[i].name+'" alt="">'+"</div>"+'<div class="aui-flex-box">'+"<h2>"+res.data[i].name+"</h2>"
                    +"<h4>"+res.data[i].name+"<i>"+res.data[i].name+"</i>"+"元"+"</h4>"+"</div>"+"</div>"+'<div class="aui-flex">'
                    +'<div class="aui-flex-box">'+"<h3>"+res.data[i].name+"</h3>"+"</div>"+'<div class="aui-order-pay">'
                    +"<p>"+res.data[i].name+"</p>"+"</div>"+"</div>"+"</div>")
			    }
			}
		}),
		$.ajax({
			url:WEB_ROOT + "/agent/invite",
			type:'get',
			dataType:'json',
			success:function(res){
				console.log(res.data);
					console.log(res.data.name);
					$("#tab2").append('<div class="aui-order-list">'+'<div class="aui-flex">'
                    +'<div class="aui-flex-box">'+"<h3>"+res.name+"</h3>"+"</div>"+"<div class='aui-order-pay'>"
                    +"<p>"+res.data.name+"</p>"+"</div>"+"</div>"+"<div class='aui-flex aui-flex-order'>"+"<div class='aui-order-img'>"
                    +'<img src="'+res.data.name+'" alt="">'+"</div>"+'<div class="aui-flex-box">'+"<h2>"+res.data.name+"</h2>"
                    +"<h4>"+res.data.name+"<i>"+res.data.name+"</i>"+"元"+"</h4>"+"</div>"+"</div>"+'<div class="aui-flex">'
                    +'<div class="aui-flex-box">'+"<h3>"+res.data.name+"</h3>"+"</div>"+'<div class="aui-order-pay">'
                    +"<p>"+res.data.name+"</p>"+"</div>"+"</div>"+"</div>")
			}
		});
		

	},
	eventBind : function() {
		
	},
	

}

$(function() {
	team_index_ops.init();
})