<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%String strN = request.getParameter("n");%>
	<form>
		<div class="form-group">
			<label>Nhập n:</b></label><br> <input type="number"
				class="form-control" name="n">
		</div>
		<input type="submit" value="Hiển thị">
	</form>
	<p>
		Bảng cửu chương
		<%=(strN == null) ? "..." : strN %>
	</p>
	<%
		if(strN != null){ 
			int n = Integer.parseInt(strN);
	%>
	<table>
		<%for(int i = 1; i < 10; i++){ %>
		<tr>
			<td><%=n %> * <%=i %> = <%=n * i %></td>
		</tr>
		<%} %>
	</table>
	<%} %>

</body>
</html>