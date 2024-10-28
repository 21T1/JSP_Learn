<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String date = request.getParameter("date");
	String month = request.getParameter("month");
	String year = request.getParameter("year");
	String s = "";
	if (date != null && month != null && year != null){
		s = "Bạn đã chọn: Ngày " + date
			+ " tháng " + month
			+ " năm " + year;
	}
	%>
	<form>
		<select class="form-select" name="date">
			<option selected disabled>Ngày</option>
			<%for (int i = 1; i <= 31; i++){ %>
			<option value=<%=i %>><%=i %></option>
			<%} %>
		</select> <select class="form-select" name="month">
			<option selected disabled>Tháng</option>
			<%for (int i = 1; i <= 12; i++){ %>
			<option value=<%=i %>><%=i %></option>
			<%} %>
		</select> <select class="form-select" name="year">
			<option selected disabled>Năm</option>
			<%for (int i = 0; i <= 10; i++){ %>
			<option value=<%=2024 - i %>><%=2024 - i %></option>
			<%} %>
		</select> <input type="submit" value="Chọn">
	</form>
	<%=s %>
</body>
</html>