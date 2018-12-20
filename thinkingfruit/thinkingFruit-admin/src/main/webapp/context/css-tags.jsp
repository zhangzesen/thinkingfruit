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
<meta charset="UTF-8">
<title>爱因思果后台管理</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">

<link rel="stylesheet"
	href="<%=basePath%>/static/plugin/layui/css/layui.css">
<link rel="stylesheet" href="<%=basePath%>/static/css/common/global.css">
