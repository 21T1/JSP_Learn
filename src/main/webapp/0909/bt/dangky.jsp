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
<link rel="stylesheet" href="dangky.css">
</head>
<body>
	<div class="container">
		<div class="card">
			<h5 class="card-header">ĐĂNG KÝ</h5>
			<div class="card-body">
				<p class="card-text">Đăng ký nhanh qua Facebook</p>
				<button class="btn btn-primary">Login with facebook</button>
			</div>
			<a href="#">Đăng ký mới bằng tài khoản TaiLieu.VN</a>
			<p>Bạn cần kích hoạt tài khoản qua Email sau khi đăng ký để nhận
				ngay 50 ePoints thưởng từ TaiLieu.VN</p>
			<form action="home.jsp" method="POST">
				<div class="form-group row">
					<div class="col-sm-6">
						<input class="form-control col-sm-6" type="text"
							placeholder="Nhập Username">
					</div>
					<div class="col-sm-6">
						<input class="form-control col-sm-6" type="text"
							placeholder="Nhập Họ và Tên">
					</div>
				</div>
				<div class="form-group row">
					<div class="col-sm-6">
						<input class="form-control col-sm-6" type="text"
							placeholder="Nhập mật khẩu">
					</div>
					<div class="col-sm-2">
						<select class="form-select">
							<option selected disabled>Giới Tính</option>
							<option value="True">Nam</option>
							<option value="False">Nữ</option>
						</select>
					</div>
				</div>
				<div class="form-group row">
					<div class="col-sm-6">
						<input class="form-control col-sm-6" type="text"
							placeholder="Nhập lại mật khẩu">
					</div>
					<div class="col-sm-2">
						<select class="form-select">
							<option disable>Ngày</option>
							<%
							for (int i = 1; i <= 31; i++) {
							%>
							<option><%=i%></option>
							<%
							}
							%>
						</select>
					</div>
					<div class="col-sm-2">
						<select class="form-select">
							<option>Tháng</option>
							<%
							for (int i = 1; i <= 12; i++) {
							%>
							<option><%=i%></option>
							<%
							}
							%>
						</select>
					</div>
					<div class="col-sm-2">
						<select class="form-select">
							<option selected disabled>Năm</option>
							<%
							for (int i = 1960; i <= 1999; i++) {
							%>
							<option value=<%=i%>><%=i%></option>
							<%
							}
							%>
						</select>
					</div>
				</div>
				<div class="form-group row">
					<div class="col-sm-6">
						<input class="form-control" type="text"
							placeholder="Nhập địa chỉ Email">
					</div>
					<div class="col-sm-2">
						<select class="form-select">
							<option>Tỉnh/TP</option>
						</select>
					</div>
				</div>
				<div class="form-group row">
					<div class="col-sm-6">
						<input class="form-control" type="text"
							placeholder="Nhập lại địa chỉ Email">
					</div>
					<div class="col">
						<input class="form-control" type="text"
							placeholder="Nhập mã captcha">
					</div>
					<div class="col">
						<button type="button" class="btn btn-link">Chọn mã xác
							nhận khác.</button>
					</div>
				</div>
				<button type="submit" class="btn btn-primary">Chọn mã xác
					nhận khác.</button>
				<div class="form-check">
					<input class="form-check-input" type="checkbox" value=""
						id="flexCheckChecked" checked> <label
						class="form-check-label" for="flexCheckChecked"> Tôi đồng
						ý với các Chính Sách và Thỏa Thuận Sử Dụng của TaiLieu.VN </label>
				</div>
			</form>
		</div>
	</div>
</body>
</html>