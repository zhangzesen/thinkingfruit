;
var member_upExamine_ops = {
		init:function(){
			this.eventBind();
			this.inintComponent();
		},
		eventBind:function(){
			// 重置表单按钮.使用时class为layui-btn layui-btn-warm btn-reset到的重置按钮
			$(".btn-reset").click(function() {
				$('input').val('');
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
	                       {field: 'id', title: 'ID',align: 'center', width:'5%'}
				           , {field: 'loginName', title: '登录名', align: 'center',width:'10%'}
				           , {field: 'mobile',title: '手机号',align: 'center',width:'15%'}
				           , {field: 'inviterId',title: '邀请者id',align: 'center',width:'10%'}
				           , {field: 'memberLevelName',title: '邀请者等级',align: 'center',width:"10%"}
				           , {field: 'createTime',title: '注册时间',templet: '#date_formate',align: 'center',width:"15%"}
				           , {field: 'upgradeTime',title: '升级时间',templet: '#date_formate2',align: 'center',width:"15%"}
				           , {fixed: 'right', title: '操作', width:'20%',height: 40, align: 'center', templet: '#barOption'} 
				       ]]
//				       , id: 'dataCheck'
				       , url: WEB_ROOT + "/member/upExamineList"
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
				           $("[data-field='memberLevelName']").children().each(function(){
							      
				        		if($(this).text()==0){
				        			$(this).empty();
				        			$(this).text("公司"); 
				        		}
				           });
				       }
				   });
				
					//查询信息
				$(".btn-serach").on('click',function(){	
					var loginName = $("input[ name='loginName']").val();
						
					var startTime = $("input[ name='startTime']").val();
					var endTime = $("input[ name='endTime']").val();
					console.log("搜索结果--》"+loginName,startTime,endTime);
				    tableIns.reload({
							where: { //设定异步数据接口的额外参数，任意设
								loginName:loginName,
								startTime : startTime,
								endTime : endTime
							}
							,page: {
							curr: 1 //重新从第 1 页开始
							}
					});
				});
				   
				table.on('tool(table-data)', function(obj) {
					var data = obj.data;
					var id = data.id;
					var event = obj.event;
					switch (event) {
					case 'examine':
						//一级分类编辑事件
						window.location.href = WEB_ROOT + '/member/upExamineSet?id='+id;
						break;
					case 'del':
						$.ajax({
							type :'PUT',
							url : WEB_ROOT + "/member/cancelUpgrade",
							dataType : 'json',
							data : {
								id:id
							},
							success:function(res){
								$(".layui-input-block .layui-btn").removeClass("layui-btn-disabled");
								var callback = null;
								if (res.code == 0) {
									callback = function() {
										window.location.href = WEB_ROOT + '/member/upExamine';
									};
								}
								common_ops.alert(res.msg, callback);
							}
						});
						break;
					}
					
				})
				   
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
	member_upExamine_ops.init();
})