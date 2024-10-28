<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>testing</title>
</head>
<body>
	Bạn đang chọn trang:
	<%=request.getParameter("t") %>
	<hr>
	<%for (int i = 1; i <= 20; i++) { %>
	<a href="tc.jsp?t=<%=i%>"><%=i%></a>
	<%} %>
</body>
</html>