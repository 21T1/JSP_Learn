<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	<c:choose>
		<c:when test="${sessionScope.login != null }">
			<div class="container">
				<c:if test="${dsLichSu != null }">
					<h3>Chưa thanh toán</h3>
					<table class="table table-hover table-bordered">
						<tr>
							<th>Tên sách</th>
							<th>Ngày mua</th>
							<th>Giá</th>
							<th>Số lượng mua</th>
							<th>Thành tiền</th>
						</tr>
						<c:forEach var="lichSu" items="${dsLichSu }">
							<c:if test="${!lichSu.isDaMua() }">
								<tr>
									<td>${lichSu.getTenSach() }</td>
									<td>${lichSu.getNgayMua() }</td>
									<td>${lichSu.getGia() }</td>
									<td>${lichSu.getSoLuongMua() }</td>
									<td>${lichSu.getThanhTien() }</td>
								</tr>
							</c:if>
						</c:forEach>
					</table>		
					
					<h3>Đã thanh toán</h3>
					<table class="table table-hover table-bordered">
						<tr>
							<th>Tên sách</th>
							<th>Ngày mua</th>
							<th>Giá</th>
							<th>Số lượng mua</th>
							<th>Thành tiền</th>
						</tr>
						<c:forEach var="lichSu" items="${dsLichSu }">
							<c:if test="${lichSu.isDaMua() }">
								<tr>
									<td>${lichSu.getTenSach() }</td>
									<td>${lichSu.getNgayMua() }</td>
									<td>${lichSu.getGia() }</td>
									<td>${lichSu.getSoLuongMua() }</td>
									<td>${lichSu.getThanhTien() }</td>
								</tr>
							</c:if>
						</c:forEach>
					</table>
				</c:if>		
				<c:if test="${dsLichSu == null }">
					<h3>Chưa có lịch sử mua hàng</h3>
				</c:if>
			</div>
		</c:when>
		<c:otherwise>
			<c:redirect url="dangNhapController" />
		</c:otherwise>
	</c:choose>
</body>
</html>