<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="khachHangModal.KhachHang" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css"
	integrity="sha512-Kc323vGBEqzTmouAECnVceyQqyqdsSiqLQISBL29aUW4U/M7pSPA/gEUZQqv1cwx4OnYxTxve5UMg5GT6L4JJg=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="sachController">Trang chủ</a>
			</div>
			<ul class="nav navbar-nav">
				<li class=""><a href="hienThiGioHangController">Giỏ hàng</a></li>
				<li><a href="xacNhanController">Xác nhận đặt mua</a></li>
				<li><a href="lichSuController">Lịch sử mua hàng</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li>
					<c:choose>
						<c:when test="${sessionScope.login == null}">
							<a href="dangNhapController">
								<span class="glyphicon glyphicon-user"></span> Login 
							</a>
						</c:when>
						<c:otherwise>
							<a href="datHang.jsp">Xin chào: ${sessionScope.login.getHoTen()}</a> 
						</c:otherwise>
					</c:choose>
				</li>
				<c:if test="${sessionScope.login != null}">
					<li>
						<a href="logout.jsp">
							<span class="glyphicon glyphicon-log-out"></span>Logout
						</a>
					</li>
				</c:if>							
			</ul>
		</div>
	</nav>
</body>
</html>