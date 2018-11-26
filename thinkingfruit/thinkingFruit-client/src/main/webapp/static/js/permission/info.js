;
var permission_info_ops = {
	init : function() {
		this.inintComponent();
	},
	inintComponent : function() {
		layui.use([ 'table', 'layer' ], function() {
			layer = layui.layer;// 弹出层
			table = layui.table;
			// 获取连接中的参数id
			var id = common_ops.g_getQueryString("id");
			console.log("获取连接中的参数id:"+id);
			// 表格渲染
			var tableIns = table.render({
				elem : '#dateTable' // 指定原始表格元素选择器（推荐id选择器） //容器高度
				,
				cols : [ [ // 标题栏
				{
					field : 'id',
					title : '权限ID',
					align : 'center',
					width : 100
				}, {
					field : 'name',
					title : '权限名称',
					align : 'center'
				}, {
					field : 'parentId',
					title : '父权限ID',
					align : 'center',
					width : 100
				}, {
					field : 'url',
					title : '权限url',
					align : 'center'
				}, {
					field : 'description',
					title : '权限描述',
					align : 'center'
				} ] ]
				,
				loading : false,
				url : WEB_ROOT + "/permission/pagination/" + id,
				method : 'get',
				page : true,
				limit : 10 // 默认采用30
				,
				limits : [ 10 ],
				loading : false,
				done : function(res, curr, count) {
					console.log(res);
	
					// 得到当前页码
					console.log(curr);
	
					// 得到数据总量
					console.log(count);
				}
			});
		});
	}
}
$(function() {
	permission_info_ops.init();
})