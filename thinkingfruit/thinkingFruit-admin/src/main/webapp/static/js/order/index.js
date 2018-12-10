;
var order_index_ops = {
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
				if(obj.event == 'detail'){
					//查看详情
					window.location.href = WEB_ROOT + '/order/set?id='+id+'&type=detail';
				}else if(obj.event == 'cancel'){
					//取消订单
					window.location.href = WEB_ROOT + '/order/set?id='+id+'&type=cancel';
				}else if(obj.event == 'deliver'){
					//发货
					window.location.href = WEB_ROOT + '/order/set?id='+id+'&type=deliver';
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
								
				$("#orderStatus").append("<option value='0'>待发货</option>");
				$("#orderStatus").append("<option value='1'>待收货</option>");
				$("#orderStatus").append("<option value='2'>已完成</option>");
				form.render();
			   // 表格渲染
			   var tableIns = table.render({
			       elem: '#dateTable'                  //指定原始表格元素选择器（推荐id选择器）  //容器高度
			    	   , cols: [[                  //标题栏
	                       {field: 'id', title: '编号',align: 'center', width:'7%'}
				           , {field: 'orderNo', title: '订单号', width:'11%',align: 'center'}
				           , {field: 'orderMemberName', title: '收件人', width:'11%',align: 'center'}
				           , {field: 'mobile', title: '手机号', width:'11%',align: 'center'}
				           , {field: 'sendMethod', title: '配送方式', width:'7%',align: 'center'}
				           , {field: 'orderStatus', title: '订单状态', width:'11%',align: 'center'}
				           , {field: 'commodityCount', title: '商品数量', width:'7%',align: 'center'}
				           , {field: 'createTime', title: '创建时间', width:'15%',align: 'center',templet:'#date_formate'}
				           , {fixed: 'right',title: '操作',width:'22%',align: 'center', templet: '#barOption'} //这里的toolbar值是模板元素的选择器
				       ]]
			       , id: 'dataCheck'
			       , url: WEB_ROOT + "/order/pagination"
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
			           $("[data-field='orderStatus']").children().each(function(){  
			               if($(this).text()=='0'){  
			                  $(this).text("待发货");
			                  $(".add_btn").css("display","inline-block");
			                  $(".cancel_btn").css("display","inline-block");
			               }else if($(this).text()=='1'){  
			                  $(this).text("待收货");
			                  $(".cancel_btn").css("display","inline-block");
			               }else if($(this).text()=='2'){  
			                  $(this).text("已完成")  
			               }
			               $(".look_btn").css("display","inline-block");
			           }) 
			           
			           $("[data-field='sendMethod']").children().each(function(){  
			               if($(this).text()=='0'){  
			                  $(this).text("邮寄")  
			               }else if($(this).text()=='1'){  
			                  $(this).text("自取")  
			               }
			           })  
			           
			       }
			   });
			   
			 //查询信息
			$(".btn-serach").on('click',function(){
				var orderNo = $(".layui-form-pane .orderNo").val();
				var startTime = $(".layui-form-pane .startTime").val();
				var endTime = $(".layui-form-pane .endTime").val();
				var orderMemberName = $(".layui-form-pane .orderMemberName").val();
				var orderStatus = $(".layui-this").attr("lay-value");
				console.log(orderNo+"     "+startTime+"      "+endTime+"      "+orderStatus+"     "+orderMemberName);
				$(".btn-export-excel").attr("href",WEB_ROOT+"/order/export?orderNo="+orderNo+"&startTime="+startTime+"&endTime="+endTime+"&orderMemberName="+orderMemberName+"&orderStatus="+orderStatus);
				
				tableIns.reload({
						where: { //设定异步数据接口的额外参数，任意设
							orderNo: orderNo,
							orderStatus: orderStatus,
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
	order_index_ops.init();
})