<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" isELIgnored="false" pageEncoding="utf-8"%>
<%-- <%@ include file="/context/begin-tags.jsp"%> --%>
<!DOCTYPE html>
<html>
<head>
<title>500</title>
<link type="image/x-icon" rel="shortcut icon"
	href="<%=%>/plug-in/images/ys-top-2.png">
<link type="text/css" rel="stylesheet" href="<%=%>/plug-in/css/common/error.css">
</head>
<body>
<%
		Exception ex = (Exception) request.getAttribute("ex");
		List<String> strings = new ArrayList<String>();
		String[] string = new String[5];
		if(ex.getMessage() == null){
			string[0] = ex.toString();
			strings.add(0,string[0]);
		}
		else{
		string = ex.getMessage().split("\n");
		for (int i = 0; i < string.length; i++) {
			strings.add(i, string[i]);
		}	
		}
		int len = strings.size();
	%>
	<div class="exception" style="margin-top: 20px;">
		Exception:
		<c:choose>
			<c:when test="<%=len == 1%>"><%=string[0]%></c:when>
			<c:when test="<%=len == 2%>"><%=string[0]%><%=string[1]%></c:when>
			<c:otherwise><%=string[0]%><%=string[1]%><%=string[2]%></c:otherwise>
		</c:choose>
	</div>
	<div id="container">
		<img class="png" src="<%=%>/plug-in/images/500.png" />
	</div>
	
	<div id="cloud" class="png"></div>
</body>
</html>