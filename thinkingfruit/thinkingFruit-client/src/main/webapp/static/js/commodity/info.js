;
var commodity_info_ops = {
		init:function(){
			this.inintComponent();
			this.eventBind();
		},
		eventBind:function(){
			
		},
		inintComponent:function(){
			//获取商品id
			var id = common_ops.g_getQueryString("id");
			$.ajax({
				url:WEB_ROOT + "/commodity/info",
				data:{
					id:id
				},
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
$(function(){
	commodity_info_ops.init();
})