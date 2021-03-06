;
var commodity_set_ops = {
		init:function(){
			
			this.inintComponent();
			this.eventBind();
		},
		// 校验表单
		validateForm : function() {
			return $(".formarea").validate();
		},
		renderFrom:function(){
			 layui.use('form', function(){
				   var form = layui.form;//高版本建议把括号去掉，有的低版本，需要加()
				   form.render();
			 });
		},
		eventBind:function(){
			var id;
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
								$("img[name='cover']").removeAttr("style");
								$("input[name='coverImagePath']").attr("value",res.data.imagePath);
								$("img[name='cover']").attr('src',WEB_ROOT + res.data.imagePath); 
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
					      
					    },done: function(res){
					    	console.log(res.data);
					    	$('#detailsImagth').append("<input value='"+res.data.imagePath+"' readonly='readonly' type='hidden' class='imagePath'/>")
					    }
					  });
				});
			   
			    
			   
				// 重置商品详情图的按钮
				$("button[name='detailsReset']").click(function() {
					$("#details img").remove();
					
					$(".imagePath").val('');
					$(".imagePath").remove();
				});
				
			   
			   //ajax后台添加数据
			   $(".layui-input-block .brand-set").click(function(){
				   //获取添加表里的数据
				   id = common_ops.g_getQueryString("id");
				   var name = $("input[name='name']").val();
				   var coverImagePath = $("input[name='coverImagePath']").val();
				   var description = $("textarea[name='description']").val();
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
				   
				   $(".imagePath").each(function(){
					   detailsImagePaths.push($(this).val());
				   });
				   console.log(detailsImagePaths);
				   var detailsImagePath=JSON.stringify(detailsImagePaths);
				   $.ajax({
					   url:WEB_ROOT+ url,
					   type:type,
					   data:{
						   id:id,
						   name:name,
						   coverImagePath:coverImagePath,
						   description:description,
						   fifthPrice:fifthPrice,
						   fourthPrice:fourthPrice,
						   thirdPrice:thirdPrice,
						   secondPrice:secondPrice,
						   firstPrice:firstPrice,
						   detailsImagePath:detailsImagePath,
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
			var id = common_ops.g_getQueryString("id");
			
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
						$("img[name='cover']").removeAttr("style");
						$("img[name='cover']").attr("src", WEB_ROOT+res.data.coverImagePath);
						for (var i = 0; i < res.data.detailsImagePaths.length; i++) {
							$("#details").append("<img alt='' border='none' name='details' src='"+WEB_ROOT+res.data.detailsImagePaths[i]+"' style='max-width:100px;'>");
							$('#detailsImagth').append("<input value='"+res.data.detailsImagePaths[i]+"' readonly='readonly' type='hidden' class='imagePath'/>")
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