;
var my_index_ops = {
	init : function() {
		this.initComponent();
		this.eventBind();
	},
	initComponent : function() {
		//头部信息
		$.ajax({
			async: false,
			url:WEB_ROOT+'/my/info',
			data:{},
			type:'GET',
			dataType:'json'
		}).done(function(res){
			console.log(res.data);
				$('#mobile').html(res.data.mobile);
				$('#name').html(res.data.loginName);
				$('#balanceNumber').html(res.data.balance);
				$('#avatar').attr("src",res.data.avatar);
		})
		$.ajax({
			url:WEB_ROOT+'/my/commisionInfo',
			data:{},
			type:'GET',
			dataType:'json'
		}).done(function(res){
			console.log("推广费"+res.data);
				$('#commisionNumber').html(res.data.totalCost);
		})
		$.ajax({
			url:WEB_ROOT+'/my/teamInfo',
			data:{},
			type:'GET',
			dataType:'json'
		}).done(function(res){
			console.log("人数"+res.data);
			if(res.data.teamNumbers==0){
				res.data.teamNumbers=1;
			}
				$('#teamNumber').html(res.data.teamNumbers);
		})
		//修改完善信息
		$("#information").click(function(){
			window.location.href = WEB_ROOT+'/my/information';
		}),
		//用户退出
		$("#loginOut").click(function(){
			var outMsg=common_ops.confirm("是否确认退出?",
					{'ok':function(){
						console.log("确认退出！")
						$.ajax({
							url:WEB_ROOT+'/my/loginOut',
							data:{},
							type:'GET',
							dataType:'json'
						}).done(function(res){
							window.location.href = WEB_ROOT+'/agent/login';
						});
					},
					'cancel':null});
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
			 var html="<img src='http://qr.liantu.com/api.php?&bg=ffffff&fg=005824&gc=00a650&logo="+"http://www.517310.com/thinkingFruit-client/static/images/log.png"+"&text="+"http://www.517310.com/thinkingFruit-client/agent/register?inviterId="+memberId+"'>";
			 console.log("html"+html)
        layer.open({
              type: 1,
              skin: '', //样式类名
              title:"扫一扫，加入爱因思果！",
              offset: 'auto',
              area: ['300px', '350px'], //宽高
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
			        ,content: '<div style="padding: 50px; line-height: 22px; background-color: #393D49; color: #fff; font-weight: 300;">确认要升级吗？亲!<br>升级规则务必请仔细阅读！</br><br>升级详情请看[关于]选项<br><br>请保持手机畅通等待客服联系^_^</div>'
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
			window.location.href = WEB_ROOT+'/my/about';
		})
	},
	

}

$(function() {
	my_index_ops.init();
})