;
var commodity_set_ops = {
		init:function(){
			this.inintComponent();
			this.eventBind();
		},
		eventBind:function(){
			
			var that = this;
			
			   //layui组件
			   layui.use('upload', function() {
					 var upload = layui.upload;
					 
					 //视频上传
					 upload.render({
							elem: '#uploadVideo',
							url : WEB_ROOT+'/upload/video?videoType=0',
							accept:'video',
							done : function(res) {
								// 上传成功返回值，必须为json格式
								common_ops.alert("上传成功",null);
								$("input[name='videoPath']").attr("value",res.data.videoPath);
								
								//添加视频
								$("#video").attr("src",WEB_ROOT+res.data.videoPath);
							}
					});
					//封面图片上传
					 upload.render({
							elem: '#uploadImage',
							url : WEB_ROOT+'/upload/image?imageType=2',
							done : function(res) {
								// 上传成功返回值，必须为json格式
								$("input[name='coverImagePath']").attr("value",res.data.imagePath);
								$("img[name='cover']").attr('src',WEB_ROOT + res.data.imagePath); 
							}
					});
					 
					//二维码背景上传
					 upload.render({
							elem: '#qrBackgroundImage',
							url : WEB_ROOT+'/upload/image?imageType=2',
							done : function(res) {
								// 上传成功返回值，必须为json格式
								$("input[name='qrBackgroundImagePath']").attr("value",res.data.imagePath);
								$("img[name='qrBackground']").attr('src',WEB_ROOT + res.data.imagePath); 
							}
					});
					 
					//轮播图片上传
					 upload.render({
					    elem: '#previewImage'
					    ,url: WEB_ROOT+'/upload/image?imageType=2'
					    ,multiple: true
					    ,before: function(obj){
					      obj.preview(function(index, file, result){
					        $('#preview').append('<img src="'+ result +'" alt="'+ file.name +'" class="layui-upload-img">')
					      });
					    }
					    ,done: function(res){
					    	var imagePath = $("input[name='previewImagePath']").val();
					    	if(rf.isEmpty(imagePath)){
					    		$("input[name='previewImagePath']").attr("value",res.data.imagePath);
					    	}else{
					    		$("input[name='previewImagePath']").attr("value",imagePath+";"+res.data.imagePath);
					    	}
					    }
					  });
					 
					//详情图片上传
					 upload.render({
					    elem: '#detailsImage'
					    ,url: WEB_ROOT+'/upload/image?imageType=2'
					    ,multiple: true
					    ,before: function(obj){
					      obj.preview(function(index, file, result){
					        $('#details').append('<img src="'+ result +'" alt="'+ file.name +'" class="layui-upload-img">')
					      });
					    }
					    ,done: function(res){
					    	var imagePath = $("input[name='detailsImagePath']").val();
					    	if(rf.isEmpty(imagePath)){
					    		$("input[name='detailsImagePath']").attr("value",res.data.imagePath);
					    	}else{
					    		$("input[name='detailsImagePath']").attr("value",imagePath+";"+res.data.imagePath);
					    	}
					    }
					  });
				});
			   
			    // 重置轮视频的按钮
				$("button[name='videoReset']").click(function() {
					$("#video").attr("src","");
					$("input[name='videoPath']").val('');
				});
			   
			    // 重置轮播图的按钮
				$("button[name='previewReset']").click(function() {
					$("#preview img").remove();
					$("input[name='previewImagePath']").val('');
				});
			   
				// 重置商品详情图的按钮
				$("button[name='detailsReset']").click(function() {
					$("#details img").remove();
					$("input[name='detailsImagePath']").val('');
				});
				
				// 重置表单按钮.使用时class为layui-btn layui-btn-warm btn-reset到的重置按钮
				$(".btn-reset").click(function() {
					$('.layui-input-inline input').val('');
					
					$("input[name='consumerCommodityPrice']").val(0);
					$("input[name='wholesaleCommodityPrice']").val(0);
					$("input[name='wholesaleSecondCommodityPrice']").val(0);
					$("input[name='agentCommodityPriceAgent']").val(0);
					$("input[name='agentSecondCommodityPriceAgent']").val(0);
					
					$('.layui-input-inline textarea').val('');
					$("img[name='cover']").attr("src","");
					$("input[name='coverImagePath']").val('');
					$("#preview img").remove();
					$("input[name='previewImagePath']").val('');
					$("#details img").remove();
					$("input[name='detailsImagePath']").val('');
					
					layui.use('form', function() {
				        var form = layui.form; //只有执行了这一步，部分表单元素才会自动修饰成功
				        form.render();
				    });
				});
				
			   //当输入商品名存在时,从数据库中提取一些不用重复填写的部分
			   $("input[name='name']").blur(function(){
				   var name = $(this).val();
				   $.ajax({
						type : 'GET',
						url : WEB_ROOT + '/commodity/queryCommodity',
						dataType : 'json',
						data : {
							name : name
						},
						success:function(res){
							console.log(res);
							if(res.data!=null){
								console.log(res);
								$("input[name='name']").val(res.data.name);
								$("input[name='videoPath']").val(res.data.videoPath);
								$("input[name='coverImagePath']").val(res.data.coverImagePath);
								$("input[name='qrBackgroundImagePath']").val(res.data.qrBackgroundImagePath);
								$("input[name='previewImagePath']").val(res.data.previewImagePathCollection);
								$("input[name='detailsImagePath']").val(res.data.detailsImagePathCollection);
								$("textarea[name='description']").val(res.data.description);
								$("input[name='approvalNumber']").val(res.data.approvalNumber);
								
								//添加图片
								$("img[name='cover']").attr("src", WEB_ROOT+res.data.coverImagePath);
								
								//添加图片
								$("img[name='qrBackground']").attr("src", WEB_ROOT+res.data.qrBackgroundImagePath);
								
								//添加视频
								$("#video").attr("src",WEB_ROOT+res.data.videoPath);
								
								for (var i = 0; i < res.data.previewImagePath.length; i++) {
									$("#preview").append("<img alt='' border='none' name='preview' src='"+WEB_ROOT+res.data.previewImagePath[i]+"' style='max-width:100px;'>");
								}
								
								for (var i = 0; i < res.data.detailsImagePath.length; i++) {
									$("#details").append("<img alt='' border='none' name='details' src='"+WEB_ROOT+res.data.detailsImagePath[i]+"' style='max-width:100px;'>");
								}
								
								//特殊分类
								if(res.data.isNew == 0){
									$("#isNew").attr("checked",true);
								}
								if(res.data.isDeclaration == 0){
									$("#isDeclaration").attr("checked",true);
								}
								if(res.data.isSpecial == 0){
									$("#isSpecial").attr("checked",true);
								}
								if(res.data.isPeas == 0){
									$("#isPeas").attr("checked",true);
								}
								if(res.data.isburst == 0){
									$("#isburst").attr("checked",true);
								}
								layui.use('form', function() {
							        var form = layui.form; //只有执行了这一步，部分表单元素才会自动修饰成功
							        form.render();
							    });
							}
						}
				    });
			   })
			   
			   //价格输入框的键盘事件
			   $("input[name='commodityPrice']").bind('input porpertychange',function(){
				   var commodityPrice = $("input[name='commodityPrice']").val();
				   var consumerCommodityPrice = commodityPrice*0.8;
				   var wholesaleCommodityPrice = commodityPrice*0.74;
				   var wholesaleSecondCommodityPrice = commodityPrice*0.72;
				   var agentCommodityPriceAgent = commodityPrice*0.7;
				   var agentSecondCommodityPriceAgent = commodityPrice*0.67;
				   $("input[name='consumerCommodityPrice']").val(consumerCommodityPrice);
				   $("input[name='wholesaleCommodityPrice']").val(wholesaleCommodityPrice);
				   $("input[name='wholesaleSecondCommodityPrice']").val(wholesaleSecondCommodityPrice);
				   $("input[name='agentCommodityPriceAgent']").val(agentCommodityPriceAgent);
				   $("input[name='agentSecondCommodityPriceAgent']").val(agentSecondCommodityPriceAgent);
			   });
			   
			   //ajax后台添加数据
			   $(".layui-input-block .brand-set").click(function(){
				   
				   //获取添加表里的数据
				   var name = $("input[name='name']").val();
				   var videoPath = $("input[name='videoPath']").val();
				   var coverImagePath = $("input[name='coverImagePath']").val();
				   var previewImagePathCollection = $("input[name='previewImagePath']").val();
				   var detailsImagePathCollection = $("input[name='detailsImagePath']").val();
				   var qrBackgroundImagePath = $("input[name='qrBackgroundImagePath']").val();
				   var description = $("textarea[name='description']").val();
				   var commoditySpecation = $("input[name='commoditySpecation']").val();
				   var commoditySpecationStock = $("input[name='commoditySpecationStock']").val();
				   var commodityPrice = $("input[name='commodityPrice']").val();
				   var consumerCommodityPrice = $("input[name='consumerCommodityPrice']").val();
				   var wholesaleCommodityPrice = $("input[name='wholesaleCommodityPrice']").val();
				   var agentCommodityPriceAgent = $("input[name='agentCommodityPriceAgent']").val();
				   var index = $("input[name='index']").val();
				   
				   var wholesaleSecondCommodityPrice = $("input[name='wholesaleSecondCommodityPrice']").val();
				   var agentSecondCommodityPriceAgent = $("input[name='agentSecondCommodityPriceAgent']").val();
				   var approvalNumber = $("input[name='approvalNumber']").val();
				   var peas = $("input[name='peas']").val();
				   var categoryId = $("input[name='categoryId']").val();
				   var specationId = $("input[name='specationId']").val();
				   var isNew = 1;
				   var isDeclaration = 1;
				   var isSpecial = 1;
				   var isPeas = 1;
				   var isburst = 1;
				   
				   $("input:checkbox[name='isOrNo']:checked").each(function() { // 遍历name=standard的多选框
					    if($(this).val() == 1){
					    	isNew = 0;
					    }
					    if($(this).val() == 2){
					    	isDeclaration = 0;
					    }
					    if($(this).val() == 3){
					    	isSpecial = 0;
					    }
					    if($(this).val() == 4){
					    	isPeas = 0;
					    }
					    if($(this).val() == 5){
					    	isburst = 0;
					    }
			       });
				   
				   console.log(qrBackgroundImagePath);
				   
				   //判断是添加还是修改
				   var url = rf.isEmpty(specationId) ? "/commodity" : "/commodity/" + specationId;
				   var type = rf.isEmpty(specationId) ? 'POST' : 'PUT';
				   
				   $(".layui-input-block .layui-btn").addClass('layui-btn-disabled');
				   
				   $.ajax({
					   url:WEB_ROOT+ url,
					   type:type,
					   data:{
						   name:name,
						   videoPath:videoPath,
						   coverImagePath:coverImagePath,
						   previewImagePathCollection:previewImagePathCollection,
						   detailsImagePathCollection:detailsImagePathCollection,
						   qrBackgroundImagePath:qrBackgroundImagePath,
						   description:description,
						   index:index,
						   commoditySpecation:commoditySpecation,
						   commoditySpecationStock:commoditySpecationStock,
						   commodityPrice:commodityPrice,
						   consumerCommodityPrice:consumerCommodityPrice,
						   wholesaleCommodityPrice:wholesaleCommodityPrice,
						   wholesaleSecondCommodityPrice:wholesaleSecondCommodityPrice,
						   agentCommodityPriceAgent:agentCommodityPriceAgent,
						   agentSecondCommodityPriceAgent:agentSecondCommodityPriceAgent,
						   approvalNumber:approvalNumber,
						   isNew:isNew,
						   isDeclaration:isDeclaration,
						   isSpecial:isSpecial,
						   isPeas:isPeas,
						   isburst:isburst,
						   peas:peas,
						   categoryId:categoryId,
						   specationId:specationId
					   },
					   dataType:'json',
					   success:function(res){
						   $(".layui-input-block .layui-btn").removeClass("layui-btn-disabled");
						   var callback = null;
						   if(res.code == 0){
							   callback = function(){
								   window.location.href = WEB_ROOT + "/commodity?categoryId="+categoryId;
							   }
						   }
						   common_ops.alert(res.msg,callback);
					   },
					   error:function(){
					       $(".layui-input-block .layui-btn").removeClass("layui-btn-disabled");
					   }
				   });
			   });
		},
		inintComponent:function(){
			//获取商品分类id
			var categoryId = common_ops.g_getQueryString("categoryId");
			$("input[name='categoryId']").attr("value",categoryId);
			var specationId = common_ops.g_getQueryString("id");
			$("input[name='specationId']").attr("value",specationId);
			if(specationId != null){
				
				$("#btn").empty();
				$("#btn").append("<button class='layui-btn brand-set' lay-submit='' lay-filter='cate_add'>立即修改</button>");
				   
				$(".layui-tab-title").empty();
				$(".layui-tab-title").append("<li class='layui-this'>修改商品信息</li>");
				
				$.ajax({
					url:WEB_ROOT + "/commodity/info",
					data:{
						specationId:specationId
					},
					async:false,
					type:'get',
					dataType:'json',
					success:function(res){
						$("input[name='name']").val(res.data.name);
						$("input[name='videoPath']").val(res.data.videoPath);
						$("input[name='coverImagePath']").val(res.data.coverImagePath);
						$("input[name='qrBackgroundImagePath']").val(res.data.qrBackgroundImagePath);
						$("input[name='previewImagePath']").val(res.data.previewImagePathCollection);
						$("input[name='detailsImagePath']").val(res.data.detailsImagePathCollection);
						$("textarea[name='description']").val(res.data.description);
						$("input[name='commoditySpecation']").val(res.data.commoditySpecation);
						$("input[name='commoditySpecationStock']").val(res.data.commoditySpecationStock);
						$("input[name='commodityPrice']").val(res.data.commodityPrice);
						$("input[name='consumerCommodityPrice']").val(res.data.consumerCommodityPrice);
						$("input[name='wholesaleCommodityPrice']").val(res.data.wholesaleCommodityPrice);
						$("input[name='agentCommodityPriceAgent']").val(res.data.agentCommodityPriceAgent);  
						$("input[name='wholesaleSecondCommodityPrice']").val(res.data.wholesaleSecondCommodityPrice);
						$("input[name='agentSecondCommodityPriceAgent']").val(res.data.agentSecondCommodityPriceAgent);
						$("input[name='approvalNumber']").val(res.data.approvalNumber);
						$("input[name='peas']").val(res.data.peas);
						$("input[name='index']").val(res.data.index);
						
						//添加图片qrBackgroundImagePath
						$("img[name='cover']").attr("src", WEB_ROOT+res.data.coverImagePath);
						
						//添加图片
						$("img[name='qrBackground']").attr("src", WEB_ROOT+res.data.qrBackgroundImagePath);
						
						//添加视频
						$("#video").attr("src",WEB_ROOT+res.data.videoPath);
						
						for (var i = 0; i < res.data.previewImagePath.length; i++) {
							$("#preview").append("<img alt='' border='none' name='preview' src='"+WEB_ROOT+res.data.previewImagePath[i]+"' style='max-width:100px;'>");
						}
						
						for (var i = 0; i < res.data.detailsImagePath.length; i++) {
							$("#details").append("<img alt='' border='none' name='details' src='"+WEB_ROOT+res.data.detailsImagePath[i]+"' style='max-width:100px;'>");
						}
						
						//特殊分类
						if(res.data.isNew == 0){
							$("#isNew").attr("checked",true);
						}
						if(res.data.isDeclaration == 0){
							$("#isDeclaration").attr("checked",true);
						}
						if(res.data.isSpecial == 0){
							$("#isSpecial").attr("checked",true);
						}
						if(res.data.isPeas == 0){
							$("#isPeas").attr("checked",true);
						}
						if(res.data.isburst == 0){
							$("#isburst").attr("checked",true);
						}
						layui.use('form', function() {
					        var form = layui.form; //只有执行了这一步，部分表单元素才会自动修饰成功
					        form.render();
					    });
						
					}
				})
			}
			
		}
}
$(function(){
	commodity_set_ops.init();
})