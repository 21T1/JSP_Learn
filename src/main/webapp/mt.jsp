<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<jsp:include page="header.jsp" />
	<%
		String a = (String) request.getAttribute("a");
		String b = (String) request.getAttribute("b");
		String kq = (String) request.getAttribute("result");
	%>

	<form action="tinhController" method="post">
		a = <input type="number" name="txtA" value=<%= a == null ? "0" : a%>>
		<br> b = <input type="number" name="txtB"
			value=<%= b == null ? "0" : b%>> <br> kq = <input
			type="number" name="txtKq" value=<%= kq%>> <br> <input
			type="submit" name="submit" value="+"> <input type="submit"
			name="submit" value="-"> <input type="submit" name="submit"
			value="x"> <input type="submit" name="submit" value="/">

	</form>
</body>
</html>