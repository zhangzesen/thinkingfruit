;
var commodity_index_ops = {
		init:function(){
			this.inintComponent();
			this.eventBind();
		},
		eventBind:function(){
			
			//设置添加按钮的点击事件
			$(".btn-add").click(function(){
				window.location.href = WEB_ROOT + '/commodity/set';
			});
			
			//设计搜索的重置按钮事件
			$(".btn-reset").click(function() {
				$('.layui-form-pane input').val('');
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
	                    {field: 'id', title: '编号',align: 'center', width: 70}
				        , {field: 'name', title: '商品名', align: 'center'}
				        , {field: 'coverImagePath', title: '展示图片', align: 'center',templet:'<div><img src="'+WEB_ROOT+'{{d.coverImagePath}}"></div>'}
				        , {field: 'sales', title: '商品销量', align: 'center'}
				        , {field: 'stock', title: '商品库存', align: 'center'}
				        , {field: 'description', title: '商品卖点',align: 'center'}
				        , {fixed: 'right', title: '操作', width: 250,height: 40, align: 'center', templet: '#barOption'} //这里的toolbar值是模板元素的选择器
				    ]]
				    , id: 'dataCheck'
				    , url: WEB_ROOT + "/commodity/pagination"
				    , method: 'get'
				    , page: true
				    , limit: 10 //默认采用30t
				    , limits :[10]
				    , loading: false
				    , done: function (res, curr, count) {
				    	console.log(res);

				        //得到当前页码
				        console.log(curr);

				        //得到数据总量
				        console.log(count);
				    }
				});
				
				//查询信息
				$(".btn-serach").on('click',function(){						
					var name = $("input[ name='name']").val();
					var description = $("input[ name='description']").val();
					
					tableIns.reload({
							where: { //设定异步数据接口的额外参数，任意设
								name: name,
								description: description
							}
							,page: {
							  curr: 1 //重新从第 1 页开始
							}
					});
				});
				
				//表格中的操作
				table.on('tool(table-data)', function(obj) {
					var data = obj.data;
					var id = data.id;
					if(obj.event == 'detail'){
						//查看商品信息
						window.location.href = WEB_ROOT + '/commodity/message?id='+id;
					}else if(obj.event == 'del'){
						//ajax删除
						var msg = "确认删除";
						var callback = {
							'ok' : function() {
								$.ajax({
									type : 'post',
									url : WEB_ROOT + "/commodity/" + data.id,
									data : {
										_method : 'delete',
										id : id
									},
									dataType : 'json',
									success : function(res) {
										var callback = null;
										if (res.code == 0) {
											callback = function() {
												window.location.href = WEB_ROOT + '/commodity';
											}
										}
										common_ops.alert(res.msg, callback);
									}
								});
							},
							'cancle' : null
						};
						common_ops.confirm(msg, callback);
					}else{
						//修改商品信息
						window.location.href = WEB_ROOT + '/commodity/set?id='+id;
					}				
				});
				
				
			})
		}
}
$(function(){
	commodity_index_ops.init();
})