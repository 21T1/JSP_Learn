<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import="tam.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="loaiModal.Loai"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="container">
		<div class="row">
			<div class="col-sm-2">
				<c:forEach var="loai" items="${dsLoai}">
					<a href ="sachController?maLoai=${loai.getMaLoai()}">
						${loai.getTenLoai()}
					</a><hr>
				</c:forEach>
			</div>
			<div class="col-sm-8">
				<div align="center">
					<h3>Giỏ hàng</h3>
				</div>
				<c:choose>
					<c:when test="${sessionScope.login != null }">
						<c:if test="${sessionScope.gioHang != null }">
							<form action="suaXoa.jsp" method="post">
								<table class="table table-hover table-bordered">
									<tr>
										<th></th>
										<th>Mã sách</th>
										<th>Tên sách</th>
										<th>Giá</th>
										<th>Số lượng</th>
										<th></th>
										<th>Thành tiền</th>
										<th></th>
									</tr>
									<c:forEach var="hang" items="${sessionScope.gioHang.getDs()}">
										<tr>
											<td>
												<input type="checkbox" name="selected" value="${hang.getMaSach()}" />
											</td>
											<td>${hang.getMaSach()}</td>
											<td>${hang.getTenSach()}</td>
											<td>${hang.getGia()}</td>
											<td>${hang.getSoLuong()}</td>
											<td>
												<form action="suaXoa.jsp" method="post">
													<input type="number" name="txtSl" style="width: 50px;"><br>
													<button class="btn-link" type="submit" name="btnSua"
														value="${hang.getMaSach()}">Cập nhật</button>
													<br>
												</form>
											</td>
											<td>${hang.getThanhTien()}</td>
											<td><a href="suaXoa.jsp?maSach=${hang.getMaSach()}"> <i
													class="fa fa-trash"></i>
											</a></td>
										</tr>
									</c:forEach>
								</table>
								<input type="submit" name="btnXoaChon" value="Xóa chọn">
							</form>
							<form action="xacNhanController" method="post">
								<input type="submit" name="btnXacNhan" class="btn-primary"value="Xác nhận thanh toán">
							</form>
							<div align="right"> 
								Tổng tiền: ${gioHang.tong()}
							</div>						
						</c:if>
						<c:if test="${sessionScope.gioHang == null }">
							<div align="center">Giỏ hàng đang trống</div>
						</c:if>
					</c:when>
					<c:otherwise>
						<c:redirect url="dangNhapController"></c:redirect>
					</c:otherwise>
				</c:choose>
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