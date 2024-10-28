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
		String a = request.getParameter("a"); 
		String b = request.getParameter("b");
		String kq = request.getParameter("kq"); 
	%>
	<form action="tinh.jsp" method="POST">
		a = <input type="number" name="txtA" value=<%=(a == null ? "0" : a)%>>
		<br> b = <input type="number" name="txtB"
			value=<%=(b == null ? "0" : b) %>> <br> kq = <input
			type="number" name="txtKq" value=<%=(kq == null ? "0" : kq)%>>
		<br> <input type="submit" value="tinh">
	</form>
</body>
</html>