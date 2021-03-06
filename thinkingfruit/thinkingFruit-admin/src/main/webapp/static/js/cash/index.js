;
var cash_index_ops={
		init:function(){
			this.inintComponent();
			this.eventBind();
		},
		eventBind:function(){
			// 重置表单按钮.使用时class为layui-btn layui-btn-warm btn-reset到的重置按钮
			$(".btn-reset").click(function() {
				$('.layui-form input').val('');
				$(".layui-form select option[value='']").attr("selected", true);
			});
		},
		inintComponent:function(){
			layui.use([ 'table', 'layer', 'laydate', 'laypage' ],function() {
				laydate = layui.laydate;// 日期插件
				laypage = layui.laypage;// 分页
				layer = layui.layer;// 弹出层
				table = layui.table;

				   // 表格渲染
				   var tableIns = table.render({
				       elem: '#dateTable'                  //指定原始表格元素选择器（推荐id选择器）  //容器高度
				       , cols: [[                  //标题栏
	                       {field: 'id', title: '编号',align: 'center',width:'5%'}
				           , {field: 'loginName', title: '登录名', align: 'center',width:'10%'}
				           , {field: 'cash', title: '提现金额(元)',align: 'center',width:'10%'}
				           , {field: 'name', title: '真实姓名', align: 'center',width:'10%'}
				           , {field: 'openBank', title: '开户银行',align: 'center',width:'18%'}
				           , {field: 'bankNumber', title: '银行卡号',align: 'center',width:'18%'}
				           , {field: 'status', title: '状态',align: 'center',width:'8%'}
				           , {field: 'createTime', title: '申请时间',align: 'center',width:'12%'}
				           , {field:'right' ,width:'10%', title: '操作', align: 'center', templet: '#barOption'} //这里的toolbar值是模板元素的选择器
				       ]]
//				       , id: 'dataCheck'
				       , url: WEB_ROOT + "/cash/pagination"
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
				           
				           //时间进行处理
				           $("[data-field='createTime']").children().each(function(){
				      
				        		if($(this).text()=='[object Object]'){
				        			var atime = res.data[$(this).parent().parent().attr("data-index")].createTime;
				        			var time = 1900+atime.year+"-"+(atime.month+1)+"-"+atime.date+" "+atime.hours+":"+atime.minutes
				        			$(this).text(time);  
				        		}
				           })
				           
				           //状态处理
				           $("[data-field='status']").children().each(function(){
				      
				        		if($(this).text()=='0'){
				        			$(this).empty();
				        			$(this).append("未提现").css("color","#FF5722");
				        			$(this).parent().parent().find(".completed_btn").remove();
				        			$(this).parent().parent().find(".edit_btn").css("display","inline-block");
				        		}else if($(this).text()=='1'){
				        			$(this).empty();
				        			$(this).append("已提现");
				        			$(this).parent().parent().find(".edit_btn").remove();
				        			$(this).parent().parent().find(".completed_btn").css("display","inline-block").attr('disabled',"true");
				        		}
				           })
				       }
				   });
				   
				 //查询信息
				$(".btn-serach").on('click',function(){						
					var loginName = $("input[ name='loginName']").val();
					var status = $("select[ name='status']").val();
					
						
					var startTime = $("input[ name='startTime']").val();
					var endTime = $("input[ name='endTime']").val();
						
					tableIns.reload({
							where: { //设定异步数据接口的额外参数，任意设
								loginName: loginName,
								status: status,
								startTime : startTime,
								endTime : endTime
							}
							,page: {
								 curr: 1 //重新从第 1 页开始
							}
					});
				});
				
				//修改提现状态
				table.on('tool(table-data)', function(obj) {
					var data = obj.data;
					var id = data.id;
					if(obj.event == 'edit'){
						var outMsg=common_ops.confirm("是否确认提现?",
							{'ok':function(){
								
								$.ajax({
									type:'get',
									url:WEB_ROOT + '/cash/set?id='+id,
									dataType:'json',
									success:function(res){
										var callback = null;
										if (res.code == 0) {
											callback = function() {
												window.location.href = WEB_ROOT + '/cash';
											}
										}
										common_ops.alert(res.msg, callback);
									}
								})
							},'cancel':null
							});
//						window.location.href = WEB_ROOT + '/cash/set?id='+id;
					}				
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
}
$(function(){
	cash_index_ops.init();
})