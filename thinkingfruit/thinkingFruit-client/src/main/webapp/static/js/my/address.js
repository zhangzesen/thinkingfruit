;
var my_information_ops = {
	init : function() {
		this.initComponent();
		this.eventBind();
	},
	initComponent : function() {
		$.ajax({
			url:WEB_ROOT+'/agent/address',
			data:{},
			type:'GET',
			dataType:'json'
		}).done(function(res){
			console.log(res.data);
			if(res.code == 0&&res.data!=null){
				$('#id').val(res.data.id);
				$('#province').val(res.data.province);
				$('#city').val(res.data.city);
				$('#town').val(res.data.town);
				$('#address').val(res.data.address);
			}
			
		});
		
		
		$("#home").click(function(){
			window.location.href = WEB_ROOT+'/home';
		}),
		$("#news").click(function(){
			console.log("news")
			window.location.href = WEB_ROOT+'/news';
		}),
		$("#my").click(function(){
			window.location.href = WEB_ROOT+'/my';
		});

	},
	eventBind : function() {
		$("#update").click(function(){
			var id=$('#id').val();
			var province=$('#province').val();
			var city=$('#city').val();
			var town=$('#town').val();
			var address=$('#address').val();
			console.log("id"+id);
			console.log("province"+province);
			console.log("city"+city);
			console.log("town"+town);
			console.log("address"+address);
			$.ajax({
				url:WEB_ROOT+'/agent/update',
				data:{
					id:id,
					province:province,
					city:city,
					town:town,
					address:address
				},
				type:'PUT',
				dataType:'json'
			}).done(function(res){
				console.log(res.data);
				if(res.code == 0){
					window.location.href = WEB_ROOT+'/my';
				}
				
			});
		});
	},
	

}

$(function() {
	my_information_ops.init();
})