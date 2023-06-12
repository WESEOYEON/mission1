<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="example.*" %>
<!DOCTYPE html>
<html>
<head>
<script>
	function clickBtn() {
		window.navigator.geolocation.getCurrentPosition(function(position) {
			var lat = position.coords.latitude;
			var lnt = position.coords.longitude;
			console.log("LAT:" + lat);
			console.log("LNT:" + lnt);
			document.getElementById("LAT").value = lat;
			document.getElementById("LNT").value = lnt;
		}, function(error) { //error
			switch (error.code) {
			case error.PERMISSION_DENIED:
				str = "사용자 거부";
				break;
			case error.POSITION_UNAVAILABLE:
				str = "지리정보 없음";
				break;
			case error.TIMEOUT:
				str = "시간 초과";
				break;
			case error.UNKNOWN_ERROR:
				str = "알수없는 에러";
				break;
			}
			document.getElementById("notLat").value = str;
			document.getElementById("notLnt").value = str;
		});
	}
	
</script>

<style>
table {
	width: 100%;
	height: 100px;
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
}

th {
	background-color: #3cb371;
	color: white;
}
</style>


<meta charset="UTF-8">
<title>와이파이 정보 구하기</title>
</head>
<body>
	<% 
	String LAT  = request.getParameter("LAT");
	String LNT = request.getParameter("LNT");
    if (LAT == null || LNT == null){
        LAT = "0.0";
        LNT = "0.0";
    } else {
        LAT = request.getParameter("LAT");
        LNT = request.getParameter("LNT");
    }
	%>
	<h1>와이파이 정보 구하기</h1>
	<a href="Home.jsp">홈</a> |
	<a href="History.jsp">히스토리 목록</a> |
	<a href="addDatabase.jsp">Open API 와이파이 정보 가져오기</a> |
	<a href="bookmark-list.jsp">북마크 보기</a> |
	<a href="bookmark-group.jsp">북마크 그룹 관리</a>
	<br>
	<br>
	
	
	
	<form action="Home.jsp" method="get">
		LAT : <input type="text" id='LAT' name="LAT" value = <%=LAT%> >
		, LNT : <input type="text" id='LNT' name="LNT" value = <%=LNT%>>
		<input type="button" value="내 위치 가져오기" onclick="clickBtn();">
		<button type="submit">근처 WIFI 정보 보기</button>
	</form>
	<br>

	<table>
		<tr>
			<th>거리(Km)</th>
			<th>관리번호</th>
			<th>자치구</th>
			<th>와이파이명</th>
			<th>도로명주소</th>
			<th>상세주소</th>
			<th>설치위치(층)</th>
			<th>설치유형</th>
			<th>설치기관</th>
			<th>서비스구분</th>
			<th>망종류</th>
			<th>설치년도</th>
			<th>실내외구분</th>
			<th>WIFI접속환경</th>
			<th>X좌표</th>
			<th>Y좌표</th>
			<th>작업일자</th>
		</tr>
		<tbody> 
			
			<%
			if (LAT != "0.0" && LNT != "0.0" && LAT !="" && LNT != ""){
				double LATdouble = Double.parseDouble(LAT);
				double LNTdouble = Double.parseDouble(LNT);
				History.saveHist(LATdouble, LNTdouble);
				wifi.insertDist(LATdouble, LNTdouble);
				List<wifiInfo> wifilist = wifi.selectDist(LATdouble, LNTdouble);
				for(wifiInfo wifi : wifilist){
			%>
				<tr class= colored>
				<td style = "padding : 0 0 0 5px"> <%=wifi.getDist()%> </td>
				<td align = center> <%=wifi.getNumber()%> </td>
				<td style = "padding: 0 0 0 2px"> <%=wifi.getSigu()%> </td>
				<td style = "padding: 0 0 0 2px;" width ="10%" > 
				<a href = "detail.jsp?number=<%=wifi.getNumber()%>">
				<%=wifi.getMainADD()%> 
				</a>
				</td>
				<td style = "padding: 0 0 0 2px;"  width = "10%" > <%=wifi.getAdd1()%> </td>
				<td style = "padding: 0 0 0 2px;" width = "15%""> <%=wifi.getAdd2()%> </td>
				<td style = "padding: 0 0 0 2px"> <%= wifi.getFloor()%> </td>
				<td style = "padding: 0 0 0 2px"> <%= wifi.getType()%> </td>
				<td style = "padding: 0 0 0 2px"> <%= wifi.getInst()%> </td>
				<td style = "padding: 0 0 0 2px"> <%= wifi.getService()%> </td>
				<td style = "padding: 0 0 0 2px"> <%= wifi.getCmcwr()%> </td>
				<td style = "padding: 0 0 0 2px"> <%= wifi.getYear() %> </td>
				<td style = "padding: 0 0 0 2px"> <%= wifi.getInout()%> </td>
				<td style = "padding: 0 0 0 2px"> <%= wifi.getEnvironment()%> </td>
				<td> <%=wifi.getLnt()%> </td>
				<td> <%=wifi.getLat()%> </td>
				<td style = "padding: 0 0 0 2px"> <%= wifi.getDay()%> </td>
				</tr>
			<%
				}
			} else {			
				String str = "위치 저장 후 조회해 주세요.";
				out.write("<td colspan=\"17\" , align=center>" + str + "</td>");
			}
			%>
		</tbody>

	</table>

	<br>
	<br>
</body>
</html>