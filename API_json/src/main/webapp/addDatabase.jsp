<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<%@ page import="example.*" %>
<html>
<head>
<meta charset="UTF-8">
<title>와이파이 정보를 받아옵니다.</title>
</head>
<body>
	<%
	example.run first = new example.run();
	first.update();
	%>

	<h1>
	<center><%=wifi.getNums()%>개의 WIFI정보를 정상적으로 저장하였습니다.</center>
	</h1>
	<br>
	<center><a href = "Home.jsp">홈으로가기</a></center>
	
</body>
</html>