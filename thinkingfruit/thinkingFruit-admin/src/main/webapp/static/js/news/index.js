;
var news_index_ops={
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
			
			//设置添加按钮的点击事件
			$(".btn-add").click(function(){
				window.location.href = WEB_ROOT + '/news/set';
			});
		},
		inintComponent:function(){
			layui.use([ 'table', 'layer', 'laydate', 'laypage' ], function() {
				laydate = layui.laydate;// 日期插件
				laypage = layui.laypage;// 分页
				layer = layui.layer;// 弹出层
				table = layui.table;
				
				   // 表格渲染
				   var tableIns = table.render({
				       elem: '#dateTable'                  //指定原始表格元素选择器（推荐id选择器）  //容器高度
				       , cols: [[                          //标题栏
                             {field: 'id', title: '编号',align: 'center',width:'7%'}
				           , {field: 'name', title: '资讯名称', align: 'center',width:'20%'}
				           , {field: 'title', title: '资讯标题',width:'20%',align: 'center'}
				           , {field: 'coverImagePath', title: '封面图片', align: 'center',width:'17%',templet:'<div><img src="'+WEB_ROOT+'{{d.coverImagePath}}"></div>'}
				           , {field: 'createTime', title: '创建时间',align: 'center',width:'20%'}
				           , {title: '操作',width:'17%',height: 40, align: 'center', templet: '#barOption',width:'17%'} //这里的toolbar值是模板元素的选择器
				       ]]
				       , id: 'dataCheck'
				       , url: WEB_ROOT + "/news/pagination"
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
				           
				           hoverOpenImg();
				           //对时间进行处理
				           $("[data-field='createTime']").children().each(function(){
							      
				        		if($(this).text()=='[object Object]'){
				        			var atime = res.data[$(this).parent().parent().attr("data-index")].createTime;
				        			var time = 1900+atime.year+"-"+(atime.month+1)+"-"+atime.date+" "+atime.hours+":"+atime.minutes
				        			$(this).text(time);  
				        		}
				           })
				       }
				   });
				   
					//查询信息
					$(".btn-serach").on('click',function(){						
						var title = $("input[ name='title']").val();
						
						var startTime = $("input[ name='startTime']").val();
						var endTime = $("input[ name='endTime']").val();
						
						tableIns.reload({
								where: { //设定异步数据接口的额外参数，任意设
									title: title,
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
						if(obj.event == 'detail'){
							//修改新闻信息
							window.location.href = WEB_ROOT + '/news/set?id='+id;
						}else{
							//ajax删除
							var msg = "确认删除";
							var callback = {
								'ok' : function() {
									$.ajax({
										type : 'post',
										url : WEB_ROOT + "/news/" + data.id,
										data : {
											_method : 'delete',
											id : id
										},
										dataType : 'json',
										success : function(res) {
											var callback = null;
											if (res.code == 0) {
												callback = function() {
													window.location.href = WEB_ROOT + '/news';
												}
											}
											common_ops.alert(res.msg, callback);
										}
									});
								},
								'cancle' : null
							};
							common_ops.confirm(msg, callback);
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
	news_index_ops.init();
})