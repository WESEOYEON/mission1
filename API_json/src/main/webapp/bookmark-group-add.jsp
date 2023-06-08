<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="example.*" %>
<% request.setCharacterEncoding("UTF-8"); %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>북마크 그룹 추가하기</title>
<style>
table {
	width: 100%;
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
<h1>북마크 그룹 추가</h1>
	<a href="Home.jsp">홈</a> |
	<a href="History.jsp">위치 히스토리 목록</a> |
	<a href="addDatabase.jsp">Open API 와이파이 정보 가져오기</a> |
	<a href="bookmark-list.jsp">북마크 보기</a> |
	<a href="bookmark-group.jsp">북마크 그룹 관리</a>
	<br><br>
	<form method ="post" action = "bookmark-group-add.jsp">
	<table>
	<colgroup>
		<col style = "width: 10%">
		<col style = "width: 90%"  >
	</colgroup>
		<tr>
			<th>북마크이름</th>
			<td><input type="text" name="bookmarkname" ></td>
		</tr>
		<tr>
			<th>순서</th>
			<td bgcolor = "#F2F2F2"><input type="text" name="bookmarknum" ></td>
		</tr>
		<tr>
			<td colspan=17, align=center><button type="submit">추가</button></td>
		</tr>
	</table>
	</form>
	<%
	if (request.getParameter("bookmarkname") != null && request.getParameter("bookmarknum")!= null){
		String name = request.getParameter("bookmarkname");
		int nums = Integer.parseInt(request.getParameter("bookmarknum"));
		Bookmark.saveBookmark(name, nums);
	%>
	<script>
	location.replace("http://localhost:8080/API_json/bookmark-group.jsp")
	</script>
	<%
		}
	%>
	
	
</body>
</html>