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
				$(".aui-order-list").bind("click",function(){
					var id= $(this).find('img').attr("value");
					alert("id"+id);
					window.location.href = WEB_ROOT + '/agent/teamInfo?id='+id;
					});
			}
		});
		
		

	},
	eventBind : function() {
		
	},
	

}

$(function() {
	team_index_ops.init();
})