;
var user_index_ops = {
	init : function() {
		this.eventBind();
		this.inintComponent();
	},
	eventBind : function() {
		// 重置表单按钮.使用时class为layui-btn layui-btn-warm btn-reset到的重置按钮
		$(".btn-reset").click(function() {
			$('input').val('');
			$(".layui-form select option[value='']").attr("selected", true);
		});
	},
	inintComponent : function() {
		layui.use([ 'table', 'layer', 'laydate', 'laypage' ], function() {
			laydate = layui.laydate;// 日期插件
			laypage = layui.laypage;// 分页
			layer = layui.layer;// 弹出层
			table = layui.table;

			// 表格渲染
			var tableIns = table.render({
				elem : '#dateTable' // 指定原始表格元素选择器（推荐id选择器） //容器高度
				,
				cols : [ [ // 标题栏
				{
					field : 'id',
					title : 'ID',
					align : 'center',
					width : 50,
					rowspan: 2
				}, {
					field : 'loginName',
					title : '登录名',
					align : 'center',
					rowspan: 2
				}, {
					field : 'nickname',
					title : '昵称',
					align : 'center',
					rowspan: 2
				}, {
					field : 'sexStr',
					title : '性别',
					align : 'center',
					rowspan: 2
				}, {
					field : 'email',
					title : '邮箱',
					align : 'center',
					rowspan: 2
				}, {
					field : 'mobile',
					title : '手机号',
					align : 'center',
					rowspan: 2
				}, {
					field : 'roleName',
					title : '角色',
					align : 'center',
					rowspan: 2
				}, {
					align: 'center', 
					title: '地址', 
					colspan: 4
				}, {
					fixed : 'right',
					title : '操作',
					width : 230,
					align : 'center',
					rowspan: 2,
					templet : '#barOption'
				} ], [
				      {field: 'provName', title: '省'}
				      ,{field: 'cityName', title: '市'}
				      ,{field: 'townName', title: '区'}
				    ] ]
				// , id: 'dataCheck'
				,
				url : WEB_ROOT + "/user/pagination",
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

			// 查询信息
			$(".btn-serach").on('click', function() {
				var nicknameStr = $("input[ name='nicknameStr']").val();
				var loginNameStr = $("input[ name='loginNameStr']").val();

				var startTime = $("input[ name='startTime']").val();
				var endTime = $("input[ name='endTime']").val();

				tableIns.reload({
					where : { // 设定异步数据接口的额外参数，任意设
						nicknameStr : nicknameStr,
						loginNameStr : loginNameStr,
						startTime : startTime,
						endTime : endTime
					},
					page : {
						curr : 1
					// 重新从第 1 页开始
					}
				});
			});

			table.on('tool(table-data)', function(obj) {
				var data = obj.data;
				var id = data.id;
				if (obj.event == 'detail') {
					// 跳转用户添加页面
					window.location.href = WEB_ROOT + '/user/set?id='
							+ id;
				} else if(obj.event == 'del'){
					var callback = {
						'ok' : function(){
							// 异步删除用户
							$.ajax({
								url:WEB_ROOT + '/user',
								data:{
									id:id,
									_method:'delete'
								},
								type:'POST',
								dataType:"json",
								success:function(res){
									var callback = null;
									if (res.code == 0) {
										callback = function() {
											window.location.href = WEB_ROOT
													+ '/user';
										}
									}
									common_ops.alert(res.msg, callback);
								}
							});
						},
						'cancle' : null
					};
					common_ops.confirm("是否确定删除"+data.loginName,callback);
				}else{
					// 跳转修改密码界面
					window.location.href = WEB_ROOT + '/user/password?id=' + id;
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
$(function() {
	user_index_ops.init();
})