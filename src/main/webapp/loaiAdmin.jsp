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
	<jsp:include page="headerAdmin.jsp"></jsp:include>
	<div class="container">
		<h3 align="center">Quản lý loại</h3>
		<table class="table table-hover table-bordered">
			<tr>
				<th>Mã loại</th>
				<th>Tên loại</th>
				<th></th>
			</tr>
			<c:forEach var="loai" items="${dsLoai }">
				<form action="quanLyLoaiAdminController?maLoai=${loai.getMaLoai()}" method="post">
					<tr>
						<td>${loai.getMaLoai() }</td>
						<td>${loai.getTenLoai() }</td>
						<td >
							<input class="btn btn-success" type="submit" name="submitLoai" value="Sửa">
							<input class="btn btn-danger" type="submit" name="submitLoai" value="Xóa">
						</td>
					</tr>
				</form>			
			</c:forEach>
		</table>	
	</div>	
</body>
</html>