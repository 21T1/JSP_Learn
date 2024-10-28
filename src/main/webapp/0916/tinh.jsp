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
		try {
			int a = Integer.parseInt(request.getParameter("txtA"));
			int b = Integer.parseInt(request.getParameter("txtB"));
			int c = a + b;
			/*out.print(a + " + " + b + " = " + c);*/
			response.sendRedirect("maytinh.jsp?a=" + a + "&b=" + b+ "&kq=" + c);
		} catch (Exception e) { %>
	<a href="maytinh.jsp">Máy tính</a>
	<%}
	%>
</body>
</html>