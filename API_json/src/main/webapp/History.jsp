<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="java.util.*" %>
<%@ page import="example.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>위치 히스토리 보기</title>
<script>
function newPage()  {
	document.getElementById('click').click();
	}
</script>
<style>
table {
	width: 100%;
	border: 1px solid;
	border-collapse: collapse;
	border-color : #C1C1C1;
	font-size : 10pt;
}

tr.colored:nth-child(even){

  background-color:#F2F2F2;
}

tr.colored:nth-child(odd){

  background-color:#FFFFFF;

}

th, td {
	border: 1px solid;
	border-collapse: collapse;
	border-color : #C1C1C1;
	height: 35px;
}

th {
	background-color: #3cb371;
	color: white;
}

</style>
</head>
<body>

<h1>위치 히스토리 목록</h1>
	<a href="Home.jsp">홈</a> |
	<a id = "click" href="History.jsp">히스토리 목록</a> |
	<a href="addDatabase.jsp">Open API 와이파이 정보 가져오기</a> |
	<a href="bookmark-list.jsp">북마크 보기</a> |
	<a href="bookmark-group.jsp">북마크 그룹 관리</a>
	<br>
	<br>
	
	<table>
		<tr>
			<th>ID</th>
			<th>x좌표</th>
			<th>Y좌표</th>
			<th>조회일자</th>
			<th>비고</th>
		</tr>

		<tbody>
		<%List<wifiInfo> wifilist = History.selectHist();
		int i = wifilist.size()+1;
		for(wifiInfo wifi : wifilist){
		i = i-1;%>
		<tr class= colored>
		<td style = "padding: 0 0 0 5px;"> <%=i%> </td>
		<form method ="post" action = "History.jsp">
		<input type = "hidden" name = nums value= <%=wifi.getNum()%>>
		<td style = "padding: 0 0 0 5px;" > <%=wifi.getX좌표()%> </td>
		<td style = "padding: 0 0 0 5px;" > <%=wifi.getY좌표()%> </td>
		<td style = "padding: 0 0 0 5px;"> <%=wifi.getTime()%> </td>
		<td align = center> <input type = "submit" value = "삭제" >
		<%
		if (request.getParameter("nums") != null){
		String number  = request.getParameter("nums");
		if (!number.equals("0")){
			History.delete(number);%>
			<script>
			location.replace("http://localhost:8080/API_json/History.jsp")
			</script>
		<%
			}
		}
		%>

		</td>
		</form>
		<%} %>
		</tr>
		</tbody>
</body>
</html>