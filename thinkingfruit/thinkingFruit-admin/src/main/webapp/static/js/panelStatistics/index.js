;
var statistics_index_ops = {
	init : function() {
		console.log("统计js");
		this.inintComponent();
		this.eventBind();
	},
	
	eventBind : function() {

	},
	
	inintComponent:function(){
		layui.use([ 'table', 'layer', 'laydate', 'laypage' ],function() {
	        layer.msg('欢迎您使用爱因思果管理系统！「^_^」');
		});
	
		   $.ajax({
			   type:'get',
			   url:WEB_ROOT+"/statistics/redisCache",
			   dataType:'json',
			   async:false,
			   success:function(res){
				   console.dir(res.data);
					//总
				   $(".memberTotal").text(res.data.allTotal.memberTotal);
				   $(".transactionTotal").text(res.data.allTotal.transactionTotal);
				   $(".orderTotal").text(res.data.allTotal.orderTotal);
				   $(".commodityTotal").text(res.data.allTotal.commodityTotal);
				   $(".cashTotal").text(res.data.allTotal.cashTotal);
				   //日
				   $(".transactionTotalDay").text(res.data.dayStatistics.transactionTotal);
				   $(".newMember").text(res.data.dayStatistics.memberTotal);
				   //月
				   $(".transactionTotalMonth").text(res.data.monthStatistics.transactionTotal);
				   //折线
				   var arr= [];//交易金额数组
					var arrTime=[];//时间数组
					var orderArr = [];//订单量
					var a; 
					
					for(var i=0;i<res.data.lineChart.length;i++){
						arr.push(res.data.lineChart[i].transactionTotal);
						/*arrTime.push(res.data.lineChart[i].createTime.year+1900+"-"+(res.data.lineChart[i].createTime.month+1)+"-"+
								(res.data.lineChart[i].createTime.date-1));*/
						a = timestampToTime(res.data.lineChart[i].createTime)
						console.log(a)
						arrTime.push(a)
						orderArr.push(res.data.lineChart[i].orderTotal);
					}
					console.log("arrTime"+arrTime);
					console.log("arr"+arr);
					echarts_ops.line("折线图","transactionTotal","",arrTime,arr);
					echarts_ops.line("折线图","orderTotal","",arrTime,orderArr);
			   }
		   });
		   
		   function timestampToTime(timestamp) {
		        var date = new Date(timestamp);//时间戳为10位需*1000，时间戳为13位的话不需乘1000
		        Y = date.getFullYear() + '-';
		        M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
		        D = date.getDate() + ' ';
		        return Y+M+D;
		    }
		   
	},
	
	eventBind : function() {
		chart_data = null;
		province = new Array();
		$.each(threeSelectData, function(k, v) {
			var provinceName = null;
			if (k.indexOf('黑龙江') == (-1) && k.indexOf('内蒙古') == (-1)) {
				provinceName = k.substring(0, 2);
			} else {
				provinceName = k.substring(0, 3);
			}
			province.push(provinceName);
		});

		var myChart = echarts.init(document.getElementById('main'));
		var option = {
			title : {
				text : '订单量',
				x : 'center'
			},
			tooltip : {// 提示框组件。
				trigger : 'item'// 数据项图形触发，主要在散点图，饼图等无类目轴的图表中使用。
			},
			legend : {
				orient : 'horizontal',// 图例的排列方向
				x : 'left',// 图例的位置
				data : [ '订单量' ]
			},

			visualMap : {// 颜色的设置 dataRange
				x : 'left',
				y : 'center',
				splitList : [ {
					start : 1500
				}, {
					start : 900,
					end : 1500
				}, {
					start : 310,
					end : 1000
				}, {
					start : 200,
					end : 300
				}, {
					start : 50,
					end : 200,
					label : '50 到 200（自定义label）'
				}, {
					start : 1,
					end : 50,
					label : '5（自定义特殊颜色）'
				}, {
					start : 0,
					end : 0
				} ],
				text : [ '高', '低' ],// 文本，默认为数值文本
				color : [ '#E0022B', '#E09107', '#A3E00B' ]
			},
			toolbox : {// 工具栏
				show : true,
				orient : 'vertical',// 工具栏 icon 的布局朝向
				x : 'right',
				y : 'center',
				feature : {// 各工具配置项。
					mark : {
						show : true
					},
					dataView : {
						show : true,
						readOnly : false
					},// 数据视图工具，可以展现当前图表所用的数据，编辑后可以动态更新。
					restore : {
						show : true
					},// 配置项还原。
					saveAsImage : {
						show : true
					}
				// 保存为图片。
				}
			},
			roamController : {// 控制地图的上下左右放大缩小 图上没有显示
				show : true,
				x : 'right',
				mapTypeControl : {
					'china' : true
				}
			},
			series : [ {
				name : '订单量',
				type : 'map',
				mapType : 'china',
				roam : true,// 是否开启鼠标缩放和平移漫游
				itemStyle : {// 地图区域的多边形 图形样式
					normal : {// 是图形在默认状态下的样式
						label : {
							show : true,// 是否显示标签
							textStyle : {
								color : "rgb(249, 249, 249)"
							}
						}
					},
					emphasis : {// 是图形在高亮状态下的样式,比如在鼠标悬浮或者图例联动高亮时
						label : {
							show : true
						}
					}
				},
				top : "10%",// 组件距离容器的距离
				data : []
			} ]
		};
		myChart.setOption(option);
		myChart.on('mouseover', function(params) {
			var dataIndex = params.dataIndex;
			console.log(params);
		});
		console.log(province);
		console.log(JSON.stringify(province));

		$
				.ajax({
					type : 'GET',
					async : false,
					dataType : 'json',
				/*	data : {
						"key" : "map"
					},*/
					url : WEB_ROOT + '/statistics/redisCache',
					success : function(res) {
						console.log(res);
						console.log(res.data.map);
							chart_data = "[{ name : \'"
								+ res.data.map.list[0].name + "\' , value : "
								+ res.data.map.list[0].value + " }";
						for (var i = 1; i < res.data.map.list.length; i++) {
							chart_data = chart_data + ",{ name : \'"
									+ res.data.map.list[i].name
									+ "\' , value : "
									+ res.data.map.list[i].value + " }";
						}
						chart_data = chart_data + "]";
						console.log(chart_data);
						myChart.setOption({
							series : [ {
								name : '订单量',
								type : 'map',
								mapType : 'china',
								roam : true,// 是否开启鼠标缩放和平移漫游
								itemStyle : {// 地图区域的多边形 图形样式
									normal : {// 是图形在默认状态下的样式
										label : {
											show : true,// 是否显示标签
											textStyle : {
												color : "rgb(249, 249, 249)"
											}
										}
									},
									emphasis : {// 是图形在高亮状态下的样式,比如在鼠标悬浮或者图例联动高亮时
										label : {
											show : true
										}
									}
								},
								top : "10%",// 组件距离容器的距离
								data : eval('(' + chart_data + ')')
								//data : eval(chart_data )
							} ]
						});

					}
				});

	}
	
	

};
$(function() {
	statistics_index_ops.init();
})