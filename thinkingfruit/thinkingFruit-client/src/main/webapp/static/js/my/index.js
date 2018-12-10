;
var my_index_ops = {
	init : function() {
		this.initComponent();
		this.eventBind();
		this.share();
	},
	initComponent : function() {
		$.ajax({
			url:WEB_ROOT+'/my/info',
			data:{},
			type:'GET',
			dataType:'json'
		}).done(function(res){
			console.log(res.data);
				$('#head').append("<h1>"+res.data.name+"</h1>"
				+'<p style="color:#757575">'+"余额:"+'<em style="color:#f39c26">'+res.data.balance+"</em>"+"元"+"</p>");
				
		})
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
	//二维码
	share:function(){ 
		$("#invite").click(function(){
			 var html="<img src='http://qr.liantu.com/api.php?&bg=ffffff&fg=000000&text="+"http://localhost:8080/thinkingFruit-client/agent/login?memberId=" + memberId+"'>";
        layer.open({
              type: 1,
              skin: '', //样式类名
              title:false,
              offset: 'auto',
              area: ['300px', '300px'], //宽高
              closeBtn: 1, //不显示关闭按钮
              shade: 0,
              anim: 2,
              shadeClose: true, //开启遮罩关闭
              content:html
            });
		});
    },
	eventBind : function() {
		
	},
	

}

$(function() {
	my_index_ops.init();
})