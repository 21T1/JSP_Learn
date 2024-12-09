<%@page import="lichSuModal.LichSu"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp"/>
	<%	ArrayList<LichSu> dsLichSu = (ArrayList<LichSu>) request.getAttribute("dsLichSu");
		if (dsLichSu != null) { %> 
		<div class="container">
			<h3>Đã thanh toán</h3>
			<table class="table table-hover table-bordered">
				<tr>
					<th>Tên sách</th>
					<th>Ngày mua</th>
					<th>Giá</th>
					<th>Số lượng mua</th>
					<th>Thành tiền</th>
				</tr>
			<%	for (LichSu lichSu : dsLichSu) { 
					if (lichSu.isDaMua()) {%>
						<tr>
							<td><%= lichSu.getTenSach() %></td>
							<td><%= lichSu.getNgayMua() %></td>
							<td><%= lichSu.getGia() %></td>
							<td><%= lichSu.getSoLuongMua() %></td>
							<td><%= lichSu.getThanhTien() %></td>
						</tr>
				<% 	}
				}%>
			</table>	
			
			<h3>Chưa thanh toán</h3>
			<table class="table table-hover table-bordered">
				<tr>
					<th>Tên sách</th>
					<th>Ngày mua</th>
					<th>Giá</th>
					<th>Số lượng mua</th>
					<th>Thành tiền</th>
				</tr>
			<%	for (LichSu lichSu : dsLichSu) { 
					if (!lichSu.isDaMua()) {%>
						<tr>
							<td><%= lichSu.getTenSach() %></td>
							<td><%= lichSu.getNgayMua() %></td>
							<td><%= lichSu.getGia() %></td>
							<td><%= lichSu.getSoLuongMua() %></td>
							<td><%= lichSu.getThanhTien() %></td>
						</tr>
				<% 	}
				}%>
			</table>	
		</div>
 	<%	} %>
 	</body>
</html>