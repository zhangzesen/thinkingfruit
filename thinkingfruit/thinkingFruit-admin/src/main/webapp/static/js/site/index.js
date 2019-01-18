var site_index_ops = {
	init:function(){
		this.inintComponent();
	},
	inintComponent:function(){
		
  		
		layui.use([ 'table', 'layer', 'laypage' ],function() {
			laypage = layui.laypage;// 分页
			layer = layui.layer;// 弹出层
			table = layui.table;
			var tableIns = table.render({
				 // 设置table组件控制的元素
				 elem: '#dateTable',
				 cols: [[                  //标题栏
					 {field: 'level',title: '代理级别',align: 'center',width:'12%'},
					 {field: 'levelName', title: '代理名称',align: 'center',width:'12%'},
					 {field: 'levelingDiscount', title: '平级分佣/邀请奖比例',align: 'center', width:'20%'},
					 {field: 'crossLevelDiscount', title: '跨级分佣/邀请奖比例',align: 'center', width:'20%'},
					 {field: 'reverseLevelDiscount',title: '反向级别分佣/邀请奖比例',align: 'center',width:'20%'},
					 {fixed: 'right', title: '操作', width: '16%', align: 'center', templet: '#barOption'}
					 ]],
				  url: WEB_ROOT + "/site/pagination",
				  method: 'get',
				  page: true,
				  limit: 10,
				  limits :[10],
				  loading: false,
				  done:function(res, curr, count){
					   console.log(res);
				  }
			 
			 });
			
			table.on('tool(table-data)', function(obj) {
				var data = obj.data;
				var id = data.id;
				var event = obj.event;
				switch (event) {
				case 'edit':
					//一级分类编辑事件
					window.location.href = WEB_ROOT+'/site/set?id='+id;
					break;
				}
				
					
			});
			
		});
	},
	
	
}
$(function(){
	site_index_ops.init();
})

