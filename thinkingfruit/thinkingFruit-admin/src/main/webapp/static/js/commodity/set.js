;
var commodity_set_ops = {
		init:function(){
			this.inintComponent();
			this.eventBind();
		},
		eventBind:function(){
			var id;
			var previewImagePaths=new Array();
			var detailsImagePaths=new Array();
			var that = this;
			
			   //layui组件
			   layui.use('upload', function() {
					 var upload = layui.upload;
					 
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
					    	previewImagePaths.push(res.data.imagePath);
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
					    	detailsImagePaths.push(res.data.imagePath);
					    }
					  });
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
				
			   
			   //ajax后台添加数据
			   $(".layui-input-block .brand-set").click(function(){
				   //获取添加表里的数据
				   var name = $("input[name='name']").val();
				   var coverImagePath = $("input[name='coverImagePath']").val();
				   var description = $("textarea[name='description']").val();
				   var stock = $("input[name='stock']").val();
				   var fifthPrice = $("input[name='fifthPrice']").val();
				   var fourthPrice = $("input[name='fourthPrice']").val();
				   var thirdPrice = $("input[name='thirdPrice']").val();
				   var secondPrice = $("input[name='secondPrice']").val();
				   var firstPrice = $("input[name='firstPrice']").val();
				   var approvalNumber = $("input[name='approvalNumber']").val();
				   //判断是添加还是修改
				   var url = rf.isEmpty(id) ? "/commodity/add" : "/commodity/edit";
				   var type = rf.isEmpty(id) ? 'POST' : 'PUT';
				   
				   $(".layui-input-block .layui-btn").addClass('layui-btn-disabled');
				   var previewImagePath=JSON.stringify(previewImagePaths);
				   var detailsImagePath=JSON.stringify(detailsImagePaths);
				   $.ajax({
					   url:WEB_ROOT+ url,
					   type:type,
					   data:{
						   name:name,
						   coverImagePath:coverImagePath,
						   description:description,
						   fifthPrice:fifthPrice,
						   fourthPrice:fourthPrice,
						   thirdPrice:thirdPrice,
						   secondPrice:secondPrice,
						   firstPrice:firstPrice,
						   previewImagePath:previewImagePath,
						   detailsImagePath:detailsImagePath,
						   stock:stock,
						   approvalNumber:approvalNumber
					   },
					   dataType:'json',
					   success:function(res){
						   $(".layui-input-block .layui-btn").removeClass("layui-btn-disabled");
						   var callback = null;
						   if(res.code == 0){
							   callback = function(){
								   window.location.href = WEB_ROOT + "/commodity";
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
			//获取商品id
			id = common_ops.g_getQueryString("id");
			if(id != null){
				
				$("#btn").empty();
				$("#btn").append("<button class='layui-btn brand-set' lay-submit='' lay-filter='cate_add'>立即修改</button>");
				   
				$(".layui-tab-title").empty();
				$(".layui-tab-title").append("<li class='layui-this'>修改商品信息</li>");
				
				$.ajax({
					url:WEB_ROOT + "/commodity/info",
					data:{
						id:id
					},
					async:false,
					type:'get',
					dataType:'json',
					success:function(res){
						$("input[name='name']").val(res.data.name);
						$("textarea[name='description']").val(res.data.description);
						$("input[name='fifthPrice']").val(res.data.fifthPrice)
						$("input[name='fourthPrice']").val(res.data.fourthPrice);
						$("input[name='thirdPrice']").val(res.data.thirdPrice);
						$("input[name='secondPrice']").val(res.data.secondPrice);
						$("input[name='firstPrice']").val(res.data.firstPrice);
						$("input[name='stock']").val(res.data.stock);
						$("input[name='approvalNumber']").val(res.data.approvalNumber);
						$("input[name='coverImagePath']").val(res.data.coverImagePath);
						
						//添加展示图片
						$("img[name='cover']").attr("src", WEB_ROOT+res.data.coverImagePath);
						
						for (var i = 0; i < res.data.previewImagePaths.length; i++) {
							$("#preview").append("<img alt='' border='none' name='preview' src='"+WEB_ROOT+res.data.previewImagePaths[i]+"' style='max-width:100px;'>");
						}
						
						for (var i = 0; i < res.data.detailsImagePaths.length; i++) {
							$("#details").append("<img alt='' border='none' name='details' src='"+WEB_ROOT+res.data.detailsImagePaths[i]+"' style='max-width:100px;'>");
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