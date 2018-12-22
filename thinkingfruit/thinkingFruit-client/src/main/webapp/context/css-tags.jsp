<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = null;
	Integer serverPort = request.getServerPort();
	if (serverPort != 80 && serverPort != 443) {
		basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
	} else {
		if (path.equals("/")) {
			basePath = request.getScheme() + "://" + request.getServerName() ;
		} else {
			basePath = request.getScheme() + "://" + request.getServerName() + "/" + path;
		}
	}
%>
<%
	String admin="http://47.96.104.24:8080/thinkingFruit-admin";
%>
<meta charset="UTF-8">
<title>揽菁灵管理后台</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">

<link rel="stylesheet"
	href="<%=basePath%>/static/plugin/layui/css/layui.css">
<link rel="stylesheet" href="<%=basePath%>/static/css/common/global.css">
<link rel="shortcut icon" type="image/x-icon" href="<%=basePath %>/static/images/log.icon" media="screen" />