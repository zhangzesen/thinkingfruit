$(function() {
	//只能输入int类型
	$(".hds-int").attr("onkeyup","value=value.replace(/[^\\d]/g,'')");
	
	//手机号
	$(".hds-mobile").attr("onkeyup","value=value.replace(/^[\\d]{5,20}$/,'')");
	
})