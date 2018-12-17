;
var my_index_ops = {
	init : function() {
		this.initComponent();
		this.eventBind();
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
	
  
	eventBind : function() {
		//二维码
		$("#invite").click(function(){
			 var html="<img src='http://qr.liantu.com/api.php?&bg=ffffff&fg=000000&text="+"http://localhost:8080/thinkingFruit-client/agent/register?memberId=" + memberId+"'>";
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
			  $('#upLevel').click(function(){
				  console.log("12346487")
			      //示范一个公告层
			      layer.open({
			        type: 1
			        ,title: false //不显示标题栏
			        ,closeBtn: false
			        ,area: '300px;'
			        ,shade: 0.8
			        ,id: 'LAY_layuipro' //设定一个id，防止重复弹出
			        ,btn: ['我要升级', '取消']
			        ,btnAlign: 'b'
			        ,moveType: 1 //拖拽模式，0或者1
			        ,content: '<div style="padding: 50px; line-height: 22px; background-color: #393D49; color: #fff; font-weight: 300;">确认要升级吗？亲!<br>升级规则：~~~~~~~~~~~<br><br>请保持手机畅通^_^</div>'
			        ,success: function(layero){
			          var btn = layero.find('.layui-layer-btn');
			          btn.find('.layui-layer-btn0').click(function(){
			        	  $.ajax({
			      			url:WEB_ROOT+'/my/upLevel',
			      			data:{},
			      			type:'PUT',
			      			dataType:'json'
			      		}).done(function(res){
			      			common_ops.alert("申请成功，请等待客服联系！")
			      		})
			          });
			        }
			      });
			  }),
		$("#information").click(function(){
			window.location.href = WEB_ROOT+'/my/information';
		}),
		$("#balance").click(function(){
			window.location.href = WEB_ROOT+'/cash';
		}),
		$("#team").click(function(){
			window.location.href = WEB_ROOT+'/agent/team';
		}),
		$("#commision").click(function(){
			window.location.href = WEB_ROOT+'/commision';
		}),
		$("#address").click(function(){
			window.location.href = WEB_ROOT+'/my/address';
		}),
		$("#order").click(function(){
			window.location.href = WEB_ROOT+'/purchaseOrder';
		}),
		$("#depot").click(function(){
			window.location.href = WEB_ROOT+'/order/depot';
		}),
		$("#about").click(function(){
			window.location.href = WEB_ROOT+'/home';
		})
	},
	

}

$(function() {
	my_index_ops.init();
})