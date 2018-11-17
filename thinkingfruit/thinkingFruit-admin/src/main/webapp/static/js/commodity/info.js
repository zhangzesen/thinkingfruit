;
var commodity_info_ops = {
		init:function(){
			this.inintComponent();
			this.eventBind();
		},
		eventBind:function(){
			
		},
		inintComponent:function(){
			var specationId = common_ops.g_getQueryString("id");
			
			$.ajax({
				url:WEB_ROOT + "/commodity/info",
				data:{
					specationId:specationId
				},
				type:'get',
				dataType:'json',
				success:function(res){
					$("input[name='name']").val(res.data.name);
					$("input[name='videoPath']").val(res.data.videoPath);
					$("input[name='coverImagePath']").val(res.data.coverImagePath);
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
					
					//添加视频
					$("#video").attr("src",WEB_ROOT+res.data.videoPath);
					console.log("video:"+WEB_ROOT+res.data.videoPath);
//					http://localhost:8080/smurfs-admin/upload/video/commodity/1528957379348.mp4
					
					//添加图片
					$("img[name='cover']").attr("src", WEB_ROOT+res.data.coverImagePath)
					
					$("img[name='qrBackground']").attr("src", WEB_ROOT+res.data.qrBackgroundImagePath)
					
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
$(function(){
	commodity_info_ops.init();
})