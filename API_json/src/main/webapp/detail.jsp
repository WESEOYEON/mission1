<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="example.*" %>
<%
request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>와이파이 상세보기</title>

<style>
table {
	width: 80%;
	border: 1px solid;
	border-collapse: collapse;
	border-color : #C1C1C1;
}



th, td {
	border: 1px solid;
	border-collapse: collapse;
	border-color : #C1C1C1;
	height: 40px;
}

th {
	background-color: #3cb371;
	color : white;
	font-size : 14pt;
}
td{
	padding: 0 0 0 10px;
}

</style>
</head>
<body>
	<h1>와이파이 상세보기</h1>
	<a href="Home.jsp">홈</a> |
	<a href="History.jsp">히스토리 목록</a> |
	<a href="addDatabase.jsp">Open API 와이파이 정보 가져오기</a> |
	<a href="bookmark-list.jsp">북마크 보기</a> |
	<a href="bookmark-group.jsp">북마크 그룹 관리</a>
	<br>
	<br>
	<%
	String wifiName = request.getParameter("number");
	wifiInfo wifiOne = wifi.detail(wifiName);
	%>
	<form method ="post" action = "detail.jsp">
	<input type="hidden" name="number" value=<%=wifiName%>>
	<select name = "bookmarkName">
	<option value = "" selected hidden>북마크 그룹 이름 선택</option>
	<%
	List<bookmarkInfo> bookmarkList = Bookmark.selectBookmark();
			for(bookmarkInfo mark : bookmarkList){
	%>
	<option name = "wifiName"> <%=mark.getName()%> </option>
	<%
	}
	%>
	</select>
	<button type="submit">북마크 추가하기</button>
	</form>

	<br>
	<%
	if (request.getParameter("number") != null && request.getParameter("bookmarkName") != null){
		wifiInfo wifi2 = wifi.detail(request.getParameter("number"));
		String wifiName2 = wifi2.getMainADD();
		String wifiNumber = wifi2.getNumber();
		String bookmarkName2 = request.getParameter("bookmarkName");
		out.println(wifiName2);
		out.print(bookmarkName2);
		Bookmark.addBookmark(wifiName2, request.getParameter("bookmarkName"), wifiNumber);
	%>
	<script>
	location.replace("http://localhost:8080/API_json/bookmark-list.jsp")
	</script>
	<%
	}
	%>
	<table>
	<colgroup>
		<col style = "width: 20%">
		<col style = "width: 70%"  >
	</colgroup>
		<tbody>
			<tr>
				<th>거리(Km)</th>
				<td>
					<%= wifiOne.getDist() %>
				</td>
			</tr>
			<tr>
				<th>관리번호</th>
				<td bgcolor = "#F2F2F2" >
				<%= wifiOne.getNumber() %>
				</td>
			</tr>
			<tr>
				<th>자치구</th>
				<td>
				<%= wifiOne.getSigu() %>
				</td>
			</tr>
			<tr>
				<th>와이파이명</th>
				<td bgcolor = "#F2F2F2">
				<%= wifiOne.getMainADD() %>
				</td>
			</tr>
			<tr>
				<th>도로명주소</th>
				<td>
				<%= wifiOne.getAdd1() %>
				</td>
			</tr>
			<tr>
				<th>상세주소</th>
				<td bgcolor = "#F2F2F2">
				<%= wifiOne.getAdd2() %>
				</td>
			</tr>
			<tr>
				<th>설치위치(층)</th>
				<td>
				<%= wifiOne.getFloor() %>
				</td>
			</tr>
			<tr>
				<th>설치유형</th>
				<td bgcolor = "#F2F2F2">
				<%= wifiOne.getType() %>
				</td>
			</tr>
			<tr>
				<th>설치기관</th>
				<td>
				<%= wifiOne.getInst() %>
				</td>
			</tr>
			<tr>
				<th>서비스구분</th>
				<td bgcolor = "#F2F2F2">
				<%= wifiOne.getService() %>
				</td>
			</tr>
			<tr>
				<th>망종류</th>
				<td>
				<%= wifiOne.getCmcwr() %>
				</td>
			</tr>
			<tr>
				<th>설치년도</th>
				<td bgcolor = "#F2F2F2">
				<%= wifiOne.getYear() %>
				</td>
			</tr>
			<tr>
				<th>실내외구분</th>
				<td>
				<%= wifiOne.getInout()%>
				</td>
				
			</tr>
			<tr>
				<th>WIFI접속환경</th>
				<td bgcolor = "#F2F2F2">
				<%= wifiOne.getEnvironment() %>
				</td>
			</tr>
			<tr>
				<th>X좌표</th>
				<td>
				<%= wifiOne.getLnt() %>
				</td>
			</tr>
			<tr>
				<th>Y좌표</th>
				<td bgcolor = "#F2F2F2">
				<%= wifiOne.getLat() %>
				</td>
			</tr>
			<tr>
				<th>작업일자</th>
				<td>
				<%= wifiOne.getDay() %>
				</td>
			</tr>
		</tbody>
	
	
	</table>
</body>
</html>