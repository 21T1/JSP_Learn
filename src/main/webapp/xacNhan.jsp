<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<c:choose>
		<c:when test="${sessionScope.loginAdmin != null }">
			<div class="container">
				<c:if test="${dsChuaThanhToan != null }">
					<div align="center">
						<h3>Xác nhận đơn hàng</h3>
					</div>
					<table class="table table-hover table-bordered">
						<tr>
							<th>Mã hóa đơn</th>
							<th>Mã khách hàng</th>
							<th>Ngày mua</th>
							<th></th>
						</tr>
						<c:forEach var="item" items="${dsChuaThanhToan }">
							<tr>
								<td>${item.getMaHoaDon() }</td>
								<td>${item.getMaKhachHang() }</td>
								<td>${item.getNgayMua() }</td>
								<td><a href="xuLyXacNhanAdminController?maHoaDon=${item.getMaHoaDon()}" class="btn btn-submit">Xác nhận</a></td>
							</tr>
						</c:forEach>
					</table>		
				</c:if>		
				<c:if test="${dsChuaThanhToan == null }">
					<div align="center">
						<h3>Không có đơn hàng cần xác nhận</h3>
					</div>
				</c:if>
			</div>
		</c:when>
		<c:otherwise>
			<c:redirect url="dangNhapAdminController" />
		</c:otherwise>
	</c:choose>
</body>
</html>