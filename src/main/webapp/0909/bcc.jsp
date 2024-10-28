<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>
	<h1 style="text-align: center;">BẢNG CỬU CHƯƠNG</h1>
	<table class="table table-bordered table-striped">
		<%for (int  j= 1; j <= 9; j++){ %>
		<tr>
			<%for (int i = 1; i <= 9; i++){ %>
			<td style="text-align: center;"><%=i %> * <%=j %> = <%=i*j %></td>
			<%} %>
		</tr>
		<%} %>
	</table>
</body>
</html>