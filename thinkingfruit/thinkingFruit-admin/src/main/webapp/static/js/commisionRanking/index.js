;
var commisionRanking_index_ops = {
		init:function(){
			this.eventBind();
			this.inintComponent();
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
	                       {field: 'id', title: '排名',align: 'center', width:'25%'}
	                       , {field: 'memberId', title: '用户ID',align: 'center', width:'25%'}
				           , {field: 'name', title: '用户姓名', align: 'center', width:'25%'}
				           , {field: 'personTotalCommision', title: '个人总佣金',align: 'center', width:'25%'}
				       ]]
//				       , id: 'dataCheck'
				       , url: WEB_ROOT + "/ranking/pagination"
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
				       }
				   });
				   
					 //查询信息
					$(".btn-serach").on('click',function(){						
						var nickname = $("input[ name='nickname']").val();
						var name = $("input[ name='name']").val();
						var memberId = $("input[ name='memberId']").val();
							
						tableIns.reload({
								where: { //设定异步数据接口的额外参数，任意设
									nickname: nickname,
									memberId: memberId,
									name:name
								}
								,page: {
									 curr: 1 //重新从第 1 页开始
								}
						});
					});
				
			});
		}
}
$(function(){
	commisionRanking_index_ops.init();
})