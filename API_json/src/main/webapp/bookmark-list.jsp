<%@page import="javax.swing.plaf.basic.BasicBorders.MarginBorder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*" %>
<%@ page import="example.*" %>
<!DOCTYPE html>
<html>
<head>
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
	font-size : 11pt;
    cursor: pointer;
    }
</style>
<meta charset="UTF-8">
<title>북마크 목록 보기</title>
</head>
<body>
<h1>북마크 목록</h1>
	<a href="Home.jsp">홈</a> |
	<a href="History.jsp">히스토리 목록</a> |
	<a href="addDatabase.jsp">Open API 와이파이 정보 가져오기</a> |
	<a href="bookmark-list.jsp">북마크 보기</a> |
	<a href="bookmark-group.jsp">북마크 그룹 관리</a>
	<br>
	<br>
	<form method ="post" id = 'test' action = "bookmark-group.jsp">

	<table>
		<tr>
			<th>ID</th>
			<th>북마크이름</th>
			<th>와이파이명</th>
			<th>등록일자</th>
			<th>비고</th>
		</tr>
		<tbody>
		<%
		List<bookmarkInfo> bookmarkList = Bookmark.selectBookmark();
				for(bookmarkInfo mark : bookmarkList){
			String wifiName = "";
			if (mark.getWifiName() == null ){
				wifiName = "";
			} else {
				wifiName = mark.getWifiName();
			}
			String regidate = "";
			if (mark.getRegiwifiDate() == null ){
				regidate = "";
			}else {
				regidate = mark.getRegiwifiDate();
			}
		%>
		<tr class= colored>
			<td style = "padding: 0 0 0 5px;"> <%= mark.getIdx()%> </td>
			<td style = "padding: 0 0 0 5px;"> <%= mark.getName()%> </td>
			<td style = "padding: 0 0 0 5px;"> 
			<a href = "detail.jsp?number=<%=mark.getWifiNumber()%>">
			<%=wifiName%>
			</a>
			 </td>
			<td style = "padding: 0 0 0 5px;"> <%=regidate%> </td>
			<td style = "padding: 0 0 0 5px;" align = center>
			<input type = "hidden" name = id value= <%= mark.getIdx() %>>
			<a href = "bookmark-delete.jsp?id=<%=mark.getIdx()%>">
				삭제
				</a>
			</td>
		<%
		}
		%>
		</tr>
		</tbody>
		</table>
		</form>
</body>
</html>