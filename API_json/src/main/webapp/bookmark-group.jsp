<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="example.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>북마크 그룹</title>
<style>
table {
	width: 100%;
	height: 100px;
	border: 1px solid;
	border-collapse: collapse;
	border-color : #C1C1C1;
	font-size : 11pt;
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

input.submitLink {
    background-color: transparent;
    color: blue;
    text-decoration: underline;
    border: none;
    cursor: pointer;
    font-size : 11pt;
    }
</style>
</head>
<body>
<h1>북마크 그룹</h1>
	<a href="Home.jsp">홈</a> |
	<a href="History.jsp">히스토리 목록</a> |
	<a href="addDatabase.jsp">Open API 와이파이 정보 가져오기</a> |
	<a href="bookmark-list.jsp">북마크 보기</a> |
	<a href="bookmark-group.jsp">북마크 그룹 관리</a>
	<br><br>
	<button type = "button" onclick = "location.href='bookmark-group-add.jsp'">북마크 그룹 추가</button>
	<br>
	<br> 
	<table>
		<tr>
			<th>ID</th>
			<th>북마크이름</th>
			<th>순서</th>
			<th>등록일자</th>
			<th>수정일자</th>
			<th>비고</th>
		</tr>
		<tbody>
		<%
		List<bookmarkInfo> bookmarkList = Bookmark.selectBookmark();
				int i = 0;
				for(bookmarkInfo mark : bookmarkList){
				i = i+1;
				String edit ="";
				if (mark.getEditDate() == null){
				edit ="";
				} else {
			edit = mark.getEditDate();
				}
		%>
		<tr class= colored>
		<td style = "padding: 0 0 0 5px;"> <%=mark.getIdx()%> </td>
		<form method ="post" id = 'test' action = "bookmark-group.jsp">
			<input type = "hidden" name = nums value= <%=mark.getIdx()%>>
			<td style = "padding: 0 0 0 5px;" > <%=mark.getName()%> </td>
			<td style = "padding: 0 0 0 5px;" > <%=mark.getNumber()%> </td>
			<input type = "hidden" name = order value= <%=mark.getNumber()%>>
			<td style = "padding: 0 0 0 5px;" > <%=mark.getRegiDate()%> </td>
			<td style = "padding: 0 0 0 5px;"> <%=edit%></td>
			<td align = center>
			<%
			String a = String.valueOf(mark.getIdx());
				String b = String.valueOf(mark.getNumber());
			%>
			<a href="bookmark-group-edit.jsp?nums=<%=a%>&order=<%=b%>">수정</a>
			<input type = "submit" value = "삭제" class = "submitLink">
		<%
		if (request.getParameter("nums") != null){
				String number  = request.getParameter("nums");
				if (!number.equals("0")){
			Bookmark.delete(number);
		%>
			<script>
			location.replace("http://localhost:8080/API_json/bookmark-group.jsp")
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
	</table>
</body>
</html>