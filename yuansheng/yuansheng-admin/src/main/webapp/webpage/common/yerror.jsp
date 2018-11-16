<%@ page language="java" isELIgnored="false" pageEncoding="utf-8"
	isErrorPage="true"%>
<%@ page import="org.slf4j.Logger,org.slf4j.LoggerFactory"%>
<%
	response.setStatus(200);
%>

<!DOCTYPE html>
<html>
<head>
<title>Exception - 异常信息</title>
<link type="image/x-icon" rel="shortcut icon" href="images/icon.png">
</head>

<body>
	<%
		Exception ex = (Exception) request.getAttribute("ex");
	%>
	<H2>
		Exception:<%=ex.getMessage()%>
	</H2>
</body>
</html>