;
var home_buy_ops = {
	init : function() {
		this.initComponent();
		this.eventBind();
	},
	initComponent : function() {
		var id = common_ops.g_getQueryString('id');
		var price = common_ops.g_getQueryString('price');
		console.log("name"+name);
		$("#price_item_1").text(price);
		$("#total_item_1").text(price);
		$.ajax({
			url:WEB_ROOT + "/home/details",
			type:'get',
			data:{
				id:id
			},
			dataType:'json',
			success:function(res){
				console.log(res.data);
				$(".goods").append('<div class="aui-card-list-header" id="name">'+res.data.name+'</div>'+'<div class="aui-card-list-content">'
				+'<img src="'+WEB_ROOT_ADMIN+res.data.coverImagePath+'"'+'value="'+res.data.id+'"/>'+"</div>")
				$(".aui-card-list-footer #price").text(res.data.price);
				for (var i = 0; i < res.data.detailsImagePaths.length; i++) {
					console.log("detailsImagePaths==="+res.data.detailsImagePaths[i]);
					$(".descriptionImg").append("<p>"+'<img src="'+WEB_ROOT_ADMIN+'/'+res.data.detailsImagePaths[i]+'"/>'+"</p>");
				}		
			}
		});
		layui.use('upload', function() {
			 var upload = layui.upload;
			//凭证图片上传
			 upload.render({
					elem: '#uploadImage',
					url : WEB_ROOT+'/upload/image?imageType=16',
					auto: false,
	                bindAction: "#btnHide",
					loading: true,
					choose: function(obj){  //上传前选择回调方法
						var files = obj.pushFile();
                        var index, file, indexArr = [];
                        for(index in files) {
                            indexArr.push(index);
                        };
                        var iaLen = indexArr.length;
                        file = files[indexArr[iaLen - 1]];
                        for(var i = 0; i < iaLen - 1; i++) {
                            delete files[indexArr[i]];
                        }
                        try {
                            if(file.size > 200 * 300) {
                                delete files[index];
                                photoCompress(file, {
                                    quality: 0.5,
                                }, function(base64Codes) {
                                    var bl = convertBase64UrlToBlob(base64Codes);
                                    obj.resetFile(index, bl, file.name);
                                    $("#btnHide").trigger("click");
                                });
                            } else {
                                $("#btnHide").trigger("click");
                            }
                        } catch(e) {
                            $("#btnHide").trigger("click");
                        }
//						$('#uploadImage').imageCompress({
//						    'quality':50,
//						    'onloadStart': function(result){
//						        console.log('读取图片开始'+result);
//						    },
//						    'onloadEnd': function(result){
//						        console.log('读取图片结束'+result);
//						    },
//						    'oncompressStart': function(result){
//						        console.log('压缩图片开始'+result);
//						    },
//						    'oncompressEnd': function(result){
//						        console.log('压缩图片结束'+result);
//						        $('#preview').append(result);
//						        $('#preview').find('img').addClass('preview');
//						    },
//						    'callback': function(){
//						        console.log('处理完毕');
//						    }
//						});
                    },
					done : function(res) {
						console.log("res.data.imagePath"+res.data.imagePath);
						// 上传成功返回值，必须为json格式
						$("#uploadImage").attr("value",res.data.imagePath); 
						$("#certificateImage").attr("src",WEB_ROOT + res.data.imagePath); 
						console.log("dizhi"+$("#uploadImage").attr("value"));
					}
			});
	   })
		$("#purchase").click(function(){
			console.log("购买");
			var commodityPrice=price;
			var commodityName=$("#name").text();
			console.log("commodityName"+commodityName)
			var commodityCount=$("#qty_item_1").val();
			var orderTotalPrice=$("#total_item_1").text();
			console.log("orderTotalPrice"+orderTotalPrice);
			console.log("commodityCount"+commodityCount);
			var certificateImage=$("#uploadImage").attr("value");
			console.log('$("#uploadImage")'+$("#uploadImage"));
			console.log("certificateImage"+certificateImage)
			if(commodityCount.length!=0&&certificateImage!=null&&certificateImage.length!=0&&commodityCount!=0){
			$.ajax({
				url:WEB_ROOT + "/home/purchase",
				type:'POST',
				data:{
					commodityId:id,
					commodityName:commodityName,
					commodityCount:commodityCount,
					commodityPrice:commodityPrice,
					certificateImage:certificateImage,
					orderTotalPrice:orderTotalPrice
				},
				dataType:'json',
				success:function(res){
					if(res.code==500057){
						callback = function() {
							window.location.href = WEB_ROOT+'my/information';
						};
						common_ops.alert(res.msg, callback);
					}else{
					callback = function() {
						window.location.href = WEB_ROOT+'/home';
					};
					common_ops.alert(res.msg, callback);
					};
				}
			});
			}else{
			common_ops.alert("请填写商品数量并上传交易凭证");}
		})
	},
	eventBind : function() {
		
	},
	

}

$(function() {
	home_buy_ops.init();
})