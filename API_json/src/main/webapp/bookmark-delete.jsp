<%@page import="example.Bookmark"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*" %>
<%@ page import="example.*" %>
<!DOCTYPE html>
<html>
<head>
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
	font-size : 12pt;
}
td{
	padding: 0 0 0 10px;
}

</style>
<meta charset="UTF-8">
<title>와이파이 정보 구하기</title>
</head>
<body>
<h1>북마크 삭제</h1>
	<a href="Home.jsp">홈</a> |
	<a href="History.jsp">히스토리 목록</a> |
	<a href="addDatabase.jsp">Open API 와이파이 정보 가져오기</a> |
	<a href="bookmark-list.jsp">북마크 보기</a> |
	<a href="bookmark-group.jsp">북마크 그룹 관리</a>
	<br><br>
	북마크를 삭제하시겠습니까?
	<br><br>
	
	<%
		String idx = request.getParameter("id");
			bookmarkInfo mark = new bookmarkInfo();
			String wifiName = "";
			String regidate = "";
			if (idx.equals("0") ){
		%>

	<%
	} else {
			mark = Bookmark.detail(idx);
			if (mark.getWifiName() == null){
		wifiName = "";
			} else {
		wifiName = mark.getWifiName();
			}
			
			if (mark.getRegiwifiDate() == null ){
		regidate = "";
			}else {
		regidate = mark.getRegiwifiDate();
			}
		}
	%>
	<form method ="get" action = "bookmark-delete.jsp">
	<table>
	<colgroup>
		<col style = "width: 20%">
		<col style = "width: 70%"  >
	</colgroup>
		<tbody>
			<tr>
				<th>북마크이름</th>
				<td>
					<%=mark.getName()%>
				</td>
			</tr>
			<tr>
				<th>와이파이명</th>
				<td bgcolor = "#F2F2F2" >
				<%=wifiName%>
				</td>
			</tr>
			<tr>
				<th>등록일자</th>
				<td>
				<%=regidate%>
				</td>
			</tr>
				<input type = "hidden" name = id  value= <%=idx%>>
				<input type = "hidden" name = delete  value= 1>

			<tr bgcolor = "#F2F2F2">
			<td colspan=17 align=center>
				<a href = "bookmark-list.jsp">돌아가기</a> | 
				<input type = "submit" value ="삭제" >
				<%
				if (request.getParameter("delete")!=null){
						if(request.getParameter("delete").equals("1")){
						Bookmark.deleteWifiInfo(idx);
				%>
				<script>
				location.replace("http://localhost:8080/API_json/bookmark-list.jsp")
				</script>
				<%
					}
				}
				%>
			</td>
			</tr>
		</tbody>
	</table>
	</form>
</body>
</html>