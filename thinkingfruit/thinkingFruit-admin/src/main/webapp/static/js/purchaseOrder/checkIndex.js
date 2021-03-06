;
var purchaseOrder_checkIndex_ops = {
	init : function() {
		this.inintComponent();
		this.eventbind();
	},
	eventbind : function() {

		layui.use(['table','layer', 'laydate', 'laypage'],function(){
			var table = layui.table;
		
			table.on('tool(table-data)', function(obj) {
				var data = obj.data;
				var id = data.id;
				var commodityCount=data.commodityCount;
				console.log("commodityCount"+commodityCount);
				if(obj.event == 'cancel'){
					//取消订单
					$.ajax({
		  				url:WEB_ROOT + "/purchase/cancelCheck",
			  			type:'PUT',
			  			data:{
							id:id,
							commodityCount:commodityCount
						},
			  			dataType:'json'
		  			}).done(function(res){
		  				$(".layui-input-block .layui-btn").removeClass("layui-btn-disabled");
						var callback = null;
						if (res.code == 0) {
							callback = function() {
								window.location.href = WEB_ROOT + '/purchase/checkOrder';
							};
						}
						console.log(res);
						common_ops.alert(res.msg, callback);
		  			});
				}else if(obj.event == 'check'){
					//审核通过
					$.ajax({
		  				url:WEB_ROOT + "/purchase/check",
			  			type:'PUT',
			  			data:{
							id:id
						},
			  			dataType:'json'
		  			}).done(function(res){
		  				$(".layui-input-block .layui-btn").removeClass("layui-btn-disabled");
						var callback = null;
						if (res.code == 0) {
							callback = function() {
								window.location.href = WEB_ROOT + '/purchase/checkOrder';
							};
						}
						console.log(res);
						common_ops.alert(res.msg, callback);
		  			});
				}
			})
			
			// 重置表单按钮.使用时class为layui-btn layui-btn-warm btn-reset到的重置按钮
			$(".btn-reset").click(function() {
				$('.layui-input-inline input').val('');
				$(".layui-form-pane .startTime").val('');
				$(".layui-form-pane .endTime").val('');
				$(".layui-form select option[value='']").attr("selected", true);
				$(".layui-this").attr("class",'');
			});
			
	/*		$("#play").click(function(){
				$("#bgMusic").get(0).play();
				$("#play").value="播放";
			})*/
			
			
		});
	},
	inintComponent : function() {

		layui.use([ 'table', 'layer', 'laydate', 'laypage' ,'form'],function() {
							laydate = layui.laydate;// 日期插件
							laypage = layui.laypage;// 分页
							layer = layui.layer;// 弹出层
							table = layui.table;
							var form = layui.form;
								
				$("#orderStatus").append("<option value='0'>未审核</option>");
				$("#orderStatus").append("<option value='1'>已审核</option>");
				form.render();
			   // 表格渲染
			   var tableIns = table.render({
			       elem: '#dateTable'                  //指定原始表格元素选择器（推荐id选择器）  //容器高度
			    	   , cols: [[                  //标题栏
	                       {field: 'id', title: '编号',align: 'center', width:'5%'}
				           , {field: 'orderNo', title: '订单号', width:'17%',align: 'center'}
				           , {field: 'orderMemberName', title: '代理人', width:'8%',align: 'center'}
					       , {field: 'certificateImage', width:'15%' , style:'height:50;',title: '凭证图片', align: 'center',templet:'<div><img style="height:50px;width:100%" src="'+WEB_ROOT+'{{d.certificateImage}}'+'"></div>'}
				           , {field: 'checkStatus', title: '订单审核状态', width:'8%',align: 'center'}
				           , {field: 'commodityName', title: '商品名', width:'8%',align: 'center'}
				           , {field: 'commodityCount', title: '商品数量', width:'8%',align: 'center'}
				           , {field: 'createTime', title: '订单时间',align: 'center', width:'18%',templet:'#date_formate'}
				           , {title: '操作',width:'15%',align: 'center', templet:'#barOption'} //这里的toolbar值是模板元素的选择器
				       ]]
			       , id: 'dataCheck'
			       , url: WEB_ROOT + "/purchase/paginationCheck"
			       , method: 'get'
			       , page: true
			       , limit: 10 //默认采用30
			       , limits :[10]
			       , loading: false
			       , done: function (res, curr, count) {
			    	   console.log(res);

			           //得到当前页码
			           console.log(curr);

			           //得到数据总量
			           console.log(count);
			           
			           //放大图片
			           hoverOpenImg();
			           
			           $("[data-field='checkStatus']").children().each(function(){  
			        	   if($(this).text()=='0'){  
			        		   $(this).text("未审核").css("color","#FF5722");
			        		   $(".add_btn").css("display","inline-block");
			        		   $(".cancel_btn").css("display","inline-block");
			        	   }else if($(this).text()=='1'){  
			        		   $(this).text("已审核")  
			        	   }
			           })
			           
			           
			           
			       }
			   });
			   
			 //查询信息
			$(".btn-serach").on('click',function(){
			    console.log("点击事件")
				var orderNo = $(".layui-form-pane .orderNo").val();
				var startTime = $(".layui-form-pane .startTime").val();
				var endTime = $(".layui-form-pane .endTime").val();
				var orderMemberName = $(".layui-form-pane .orderMemberName").val();
				
				tableIns.reload({
						where: { //设定异步数据接口的额外参数，任意设
							orderNo: orderNo,
							startTime : startTime,
							endTime : endTime,
							orderMemberName: orderMemberName
						}
						,page: {
						  curr: 1 //重新从第 1 页开始
						}
				});
			});
			
			var start = {
				elem : ".layui-form-item input[name='startTime']",
				min : '2017-01-01 23:59:59',
				max : '2099-06-16 23:59:59',
				format : 'yyyy-MM-dd HH:mm:ss',
				type : 'datetime',
				trigger : 'click',
				zIndex : 99999999,
				ready : function(data) {
					start.min = data; // 开始日选好后，重置结束日的最小日期
				},
				change : function(value, date, endDate) {
					start.value = value;
				}
			};

			var end = {
				elem : ".layui-form-item input[name='endTime']",
				min : '2017-01-01 23:59:59',
				max : '2099-06-16 23:59:59',
				format : 'yyyy-MM-dd HH:mm:ss',
				type : 'datetime',
				trigger : 'click',
				zIndex : 99999999,
				ready : function(data) {
					end.max = data; // 结束日选好后，重置开始日的最大日期
				},
				change : function(value, date, endDate) {
					end.value = value;
				}
			};

							laydate.render(start);
							laydate.render(end);
						});
	}
};
$(function() {
	purchaseOrder_checkIndex_ops.init();
})