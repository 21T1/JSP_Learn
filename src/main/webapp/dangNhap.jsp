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
		String message = (String) request.getAttribute("message");
	%>
	<form action="dangNhapController" method="post">
		Tên đn: <input type="text" name="txtName"> <br> Mật khẩu:
		<input type="password" name="txtPass"> <br>
		<p><%= (message == null) ? "" : message %></p>
		<input type="submit" value="Đăng nhập" class="btn btn-primary">
	</form>
</body>
</html>