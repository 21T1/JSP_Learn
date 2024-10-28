<%@page import="java.util.ArrayList"%>
<%@page import="loaiModal.Loai"%>
<%@page import="loaiModal.LoaiBO"%>
<%@page import="sachModal.Sach"%>
<%@page import="sachModal.SachBO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<jsp:include page="header.jsp"/>
	<div class="container">
		<div class="row">
			<div class="col-sm-2">
				<%	ArrayList<Loai> dsLoai = (ArrayList<Loai>) request.getAttribute("dsLoai");
					for (Loai loai : dsLoai) {%>
						<a href ="sachController?maLoai=<%=loai.getMaLoai() %>">
							<%=loai.getMaLoai() %>
						</a><hr>
				<%} %>
			</div>
			<div class="col-sm-8">
				<%	ArrayList<Sach> dsSach = (ArrayList<Sach>) request.getAttribute("dsSach");
					int n = dsSach.size();
					for (int i = 0; i < n/3 + 1; i++) { %>
						<div class="row">
						<% for (int j = 1; j <= 3; j++) {
							Sach sach = dsSach.get((i + 1) * 3 + j); %>
							<div class = "col-sm-4">
								<img src="<%=sach.getAnh() %>"> <br>
								<%=sach.getTenSach() %>		
								<a href="gioHangController?maSach=<%= sach.getMaSach() %>&tenSach=<%= sach.getTenSach() %>&gia=<%= sach.getGia()%>">
									<i class="fa-solid fa-cart-shopping"></i>
								</a>
							</div>
						<%	} %>
						</div>
				<% 	} %>
			</div>
			<div class="col-sm-2">
				<form action="sachController" method="post">
					<input type="text" name="txtTimKiem"> <br>
					<input type="submit" name="btnTimKiem" value="Tìm kiếm" class="btn-primary"> <br>
				</form>
			</div>
		</div>
	</div>
</body>
</html>