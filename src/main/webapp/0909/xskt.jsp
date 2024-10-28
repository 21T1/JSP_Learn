<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	Hôm nay, ngày
	<%=request.getParameter("date") %>
	tháng
	<%=request.getParameter("month") %>
	năm
	<%=request.getParameter("year") %>
	<br> Chọn ngày:
	<select onChange="window.location.href += this.value">
		<%for(int i = 1; i <= 31; i++) {%>
		<option value="?date=<%=i%>"><%=i%></option>
		<%} %>
	</select> Chọn tháng:
	<select onChange="window.location.href += this.value">
		<%for(int i = 1; i <= 12; i++) {%>
		<option value="&month=<%=i%>"><%=i%></option>
		<%} %>
	</select> Chọn năm:
	<select onChange="window.location.href += this.value">
		<%for(int i = 0; i < 10; i++) {%>
		<option value="&year=<%=2024 - i%>"><%=2024 - i%></option>
		<%} %>
	</select>
</body>
</html>