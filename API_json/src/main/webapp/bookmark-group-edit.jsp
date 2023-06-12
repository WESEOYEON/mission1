<%@page import="example.Bookmark"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="example.*"%>
<%
request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<style>
table {
	width: 100%;
	border: 1px solid;
	border-collapse: collapse;
	border-color: #C1C1C1;
}

th, td {
	border: 1px solid;
	border-collapse: collapse;
	border-color: #C1C1C1;
	height: 40px;
}

th {
	background-color: #3cb371;
	color: white;
	font-size: 14pt;
}

td {
	padding: 0 0 0 10px;
}
</style>
<meta charset="UTF-8">
<title>북마크 그룹 수정하기</title>
</head>
<body>
	<h1>북마크 그룹 수정</h1>
	<a href="Home.jsp">홈</a> |
	<a href="History.jsp">히스토리 목록</a> |
	<a href="addDatabase.jsp">Open API 와이파이 정보 가져오기</a> |
	<a href="bookmark-list.jsp">북마크 보기</a> |
	<a href="bookmark-group.jsp">북마크 그룹 관리</a>
	<br>
	<br>

	<%
	String idx = request.getParameter("nums");
		String order = request.getParameter("order");
	%>
	<form method="post" action="bookmark-group-edit.jsp">
		<table>
			<input type="hidden" name="nums" value=<%=idx%>>
			<%
			bookmarkInfo mark = Bookmark.selectOne(Integer.parseInt(idx));
			%>
			<colgroup>
				<col style="width: 10%">
				<col style="width: 90%">
			</colgroup>
			<tr>
				<th>북마크이름</th>
				<td><input type="text" name="newName"
					placeHolder='<%=mark.getName()%>'></td>
			</tr>
			<tr>
				<th>순서</th>
				<td bgcolor="#F2F2F2"><input type="text" name="newNums"
					placeHolder='<%=order%>'></td>
			</tr>
			<tr>
				<td colspan=17, align=center><button type="submit">수정</button></td>
			</tr>
		</table>
	</form>
	<%
	if (request.getParameter("newName") != null && request.getParameter("newNums") == "") {
			String newName = request.getParameter("newName");
			int nums = mark.getNumber();
			Bookmark.edit(newName, nums, Integer.parseInt(idx));
	%>
	<script>
		location.replace("http://localhost:8080/API_json/bookmark-group.jsp")
	</script>
	<%
	}

		if (request.getParameter("newName") == "" && request.getParameter("newNums") != null) {
		String newName2 = mark.getName();
		int nums2 = Integer.parseInt(request.getParameter("newNums"));
		Bookmark.edit(newName2, nums2, Integer.parseInt(idx));
	%>
	<script>
		location.replace("http://localhost:8080/API_json/bookmark-group.jsp")
	</script>
	<%
	}
		if (request.getParameter("newName") != null && request.getParameter("newNums") != null) {
		String newName3 = request.getParameter("newName");
		int nums3 = Integer.parseInt(request.getParameter("newNums"));
		Bookmark.edit(newName3, nums3, Integer.parseInt(idx));
	%>
	<script>
		location.replace("http://localhost:8080/API_json/bookmark-group.jsp")
	</script>

	<%
	}
	%>
</body>
</html>