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
                    +'<div class="aui-flex-box">'+"<h3>"+"级别"+"</h3>"+"</div>"+"<div class='aui-order-pay'>"
                    +"<p>"+res.data[i].memberLevelName+"</p>"+"</div>"+"</div>"+"<div class='aui-flex aui-flex-order'>"+"<div class='aui-order-img'>"
                    +'<img src="'+res.data[i].avatar+'" alt="">'+"</div>"+'<div class="aui-flex-box">'+"<h2>"+res.data[i].name+"</h2>"
                    +"<h4>"+"个人销售额"+"<i>"+res.data[i].salesVolume+"</i>"+"元"+"</h4>"+"</div>"+"</div>"+'<div class="aui-flex aui-flex-button">'
                	+"</div>"+"</div>")
			    }
			}
		}),
		$.ajax({
			url:WEB_ROOT + "/agent/teamAgent",
			type:'get',
			dataType:'json',
			success:function(res){
				console.log(res.data);
				
			}
		}),
		$.ajax({
			url:WEB_ROOT + "/agent/inviter",
			type:'get',
			dataType:'json',
			success:function(res){
				console.log(res.data);
				if(res.data==null){
					$("#inviter #memberLevelName").text("最高级别");
					$("#inviter #name").text("公司");
					$("#inviter #salesVolume").text("未统计");
				}else if(res.data!=null){
					
					$("#inviter #memberLevelName").text(res.data.memberLevelName);
					$("#inviter #name").text(res.data.name);
					$("#inviter #avatar").attr("src",res.data.avatar);
					$("#inviter #salesVolume").text(res.data.salesVolume);
				}
			}
		});
		

	},
	eventBind : function() {
		
	},
	

}

$(function() {
	team_index_ops.init();
})