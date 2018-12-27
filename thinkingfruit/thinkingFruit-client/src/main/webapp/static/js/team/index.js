;
var team_index_ops = {
	init : function() {
		this.initComponent();
		this.eventBind();
	},
	initComponent : function() {
		$.ajax({
			async: false,
			url:WEB_ROOT + "/agent/teamAgent",
			type:'get',
			dataType:'json',
			success:function(res){
				console.log(res.data);
				if(res.data.salesVolume==null){res.data.salesVolume=0}
				$("#me").append('<div class="aui-order-list">'+'<div class="aui-flex">'
	                    +'<div class="aui-flex-box">'+"<h3>"+"级别"+"</h3>"+"</div>"+"<div class='aui-order-pay'>"
	                    +"<p>"+res.data.memberLevelName+"</p>"+"</div>"+"</div>"+"<div class='aui-flex aui-flex-order'>"+"<div class='aui-order-img'>"
	                    +'<img src="'+res.data.avatar+'" alt="">'+"</div>"+'<div class="aui-flex-box">'+"<h2>"+res.data.name+"</h2>"+"<h2>"+"联系方式："+"<i>"+res.data.mobile+"</i>"+"</h>"
	                    +"<h4>"+"销售额："+"<i>"+res.data.salesVolume+"</i>"+"元"+"</h4>"+"<h4>"+"团队销售额："+"<i>"+res.data.salesVolume+"</i>"+"元"+"</h4>"+"</div>"+"</div>"+'<div class="aui-flex aui-flex-button">'
	                	+"</div>"+"</div>")
				
			}
		}),
		$.ajax({
			async: false,
			url:WEB_ROOT + "/agent/teamList",
			type:'get',
			dataType:'json',
			success:function(res){
				console.log(res.data);
				for (var i = 0; i < res.data.length; i++) {
					if(res.data[i].salesVolume==null){res.data[i].salesVolume=0}
					if(res.data[i].name==null){res.data[i].name="暂未完善信息"}
					console.log(res.data[i].name);
					$("#team").append('<div class="aui-order-list">'+'<div class="aui-flex">'
                    +'<div class="aui-flex-box">'+"<h3>"+"级别"+"</h3>"+"</div>"+"<div class='aui-order-pay'>"
                    +"<p>"+res.data[i].memberLevelName+"</p>"+"</div>"+"</div>"+"<div class='aui-flex aui-flex-order'>"+"<div class='aui-order-img'>"
                    +'<img src="'+res.data[i].avatar+'" alt="">'+"</div>"+'<div class="aui-flex-box">'+"<h2>"+res.data[i].name+"</h2>"+"<h2>"+"联系方式："+"<i>"+res.data[i].mobile+"</i>"+"</h>"
                    +"<h4>"+"销售额："+"<i>"+res.data[i].salesVolume+"</i>"+"元"+"</h4>"+"<h4>"+"团队人数："+"<i>"+res.data[i].teamNumbers+"</i>"+"人"+"</h4>"+"</div>"+"</div>"+'<div class="aui-flex aui-flex-button">'
                	+"</div>"+"</div>")
			    }
			}
		}),
		$.ajax({
			async: false,
			url:WEB_ROOT + "/agent/inviter",
			type:'get',
			dataType:'json',
			success:function(res){
				console.log(res.data);
				if(res.data==null){
					$("#inviter #memberLevelName").text("最高级别");
					$("#inviter #name").text("公司");
					$("#inviter #mobile").text("123456798");
				}else if(res.data!=null){
					
					$("#inviter #memberLevelName").text(res.data.memberLevelName);
					$("#inviter #name").text(res.data.name);
					$("#inviter #avatar").attr("src",res.data.avatar);
					$("#inviter #mobile").text(res.data.mobile);
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