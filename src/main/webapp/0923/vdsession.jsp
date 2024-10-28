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
		String nn = request.getParameter("txtn");
		if (session.getAttribute("s") == null) {
			session.setAttribute("s", 0);
		}
		if (nn != null) {
			int n = Integer.parseInt(nn);
			int s = (int) session.getAttribute("s");
			s += n;
			session.setAttribute("s", s);
			out.println("Tong: " + session.getAttribute("s"));
		}
	%>

	<a href="../0916/mt.jsp">Mở trang máy tính</a>
	<form action="vdsession.jsp" method="post">
		n = <input type="number" name="txtn"> <input type="submit"
			value="Tong">
	</form>
</body>
</html>