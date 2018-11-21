;
var news_set_ops={
		init:function(){
			this.inintComponent();
			this.ueditor();
//			this.validateForm();
			this.eventBind();
		},
		eventBind:function(){
			// 立即添加按钮的点击事件
			$(".layui-input-block .layui-btn").click(function(){
				
				var nameTarget = $("input[name='name']");
				var name = nameTarget.val();
				
				var titleTarget = $("input[name='title']");
				var title = titleTarget.val();
				
				var coverImagePathTarget = $("input[name='coverImagePath']");
				var coverImagePath = coverImagePathTarget.val();
				
				var descriptionTarget = $("input[name='description']");
				var description = descriptionTarget.val();
				
				var content = $("textarea[name='content']").val();
				
				var id = $("input[name='id']").val();
				
				//判断是添加还是修改
				var url = rf.isEmpty(id) ? "/news" : "/news/" + id;
				var type = rf.isEmpty(id) ? 'POST' : 'PUT';
				
				$(".layui-input-block .layui-btn").addClass('layui-btn-disabled');
				$.ajax({
					type : type,
					url : WEB_ROOT + url,
					dataType : 'json',
					data : {
						id:id,
						name : name,
						title : title,
						coverImagePath : coverImagePath,
						description : description,
						content:content
					},
					success:function(res){
						$(".layui-input-block .layui-btn").removeClass("layui-btn-disabled");
						var callback = null;
						if (res.code == 0) {
							callback = function() {
								window.location.href = WEB_ROOT + '/news';
							};
						}
						common_ops.alert(res.msg, callback);
					},
					error:function(){
						$(".layui-input-block .layui-btn").removeClass("layui-btn-disabled");
					}
			    });
		   });
		},
		inintComponent:function(){
			//获取商品分类id
			var id = common_ops.g_getQueryString("id");
			$("input[name='id']").attr("value",id);
			
			if(id != null){
				
				$(".layui-tab-title").empty();
				$(".layui-tab-title").append("<li class='layui-this'>修改品牌</li>");
				$(".layui-input-block").empty();
				$(".layui-input-block").append("<button class='layui-btn news-set' lay-submit='' lay-filter='cate_add'>立即修改</button>");
				
				$.ajax({
					url:WEB_ROOT+"/news/info",
					data:{
						id:id
					},
					type:'get',
					dataType:'json',
					success:function(res){
						$("input[name='name']").val(res.data.name);
						$("input[name='title']").val(res.data.title);
						$("input[name='coverImagePath']").val(res.data.coverImagePath);
						$('img').attr('src',WEB_ROOT + res.data.coverImagePath);
						$("input[name='description']").val(res.data.description);
						
						//初始化赋值ueditor
						var ue = UE.getEditor('editor');
						ue.ready(function() {//编辑器初始化完成再赋值  
				            ue.setContent(res.data.content);  //赋值给UEditor  
				        }); 
					}
				})
			}
			
			//layui组件
			layui.use('upload', function() {
				  var upload = layui.upload;
				  upload.render({
				     elem: '#uploadImage',
				     url : WEB_ROOT+'/upload/image?imageType=6',
				     done : function(res) {
					     $("input[name='coverImagePath']").attr("value",res.data.imagePath);
					     $('img').attr('src',WEB_ROOT + res.data.imagePath);
					     console.log('上传完毕'); // 上传成功返回值，必须为json格式
				     }
			      });
				  
			});
		},
		ueditor:function(){
			var ue = UE.getEditor('editor', {
				toolbars : [ [ 'bold', 'italic', 'underline', 'removeformat',
					'formatmatch', 'autotypeset', '|', 'forecolor',
					'insertorderedlist', 'insertunorderedlist', 'selectall',
					'cleardoc', '|', 'rowspacingtop', 'rowspacingbottom',
					'lineheight', '|', 'customstyle', 'paragraph',
					'fontfamily', 'fontsize', '|', 'indent', '|',
					'justifyleft', 'justifycenter', 'justifyright',
					'justifyjustify', '|', 'simpleupload', '|',
					'horizontal', 'date', 'time', 'spechars', '|',
					'searchreplace', 'help' ] ],
					serverUrl: WEB_ROOT + "/upload/upload?imageType=6",
				zIndex : 0,
				elementPathEnabled:false
			});
	    }
//		,validateForm : function() {
//			$(".layui-form").validate();
//	   }
}
$(function(){
	news_set_ops.init();
})