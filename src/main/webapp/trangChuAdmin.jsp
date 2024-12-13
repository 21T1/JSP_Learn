<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
</head>
<body>
	<jsp:include page="headerAdmin.jsp"/>
	<div class="container">
		<div class="row">
			<!-- Loại sách -->
			<div class="col-sm-2">
				<c:forEach var="loai" items="${dsLoai}">
						<a href ="sachController?maLoai=${loai.getMaLoai()}">
							${loai.getTenLoai()}
						</a><hr>
				</c:forEach>
			</div>
			
			<!-- Sách -->
			<div class="col-sm-8">
				<div class="row">
	            	<div class="row">
	   					<c:forEach var="sach" items="${dsSach}">
							<div class="col-xs-4" style="height: 330px;">
								<form action="quanLySachAdminController?maSach=${sach.getMaSach()}" method="post">
									<img src="${sach.getAnh()}" style="height: 250px; width: 100%; object-fit: cover; overflow: hidden;"> <br>
									<p style="height: 30px;">${sach.getTenSach()}</p>		
									<input class="btn btn-success" type="submit" name="submit" value="Sửa"">
									<input class="btn btn-danger" type="submit" name="submit" value="Xóa"">
								</form>
			               </div>		
			        	</c:forEach>
	            	</div>
				</div>
			</div>
			
			<div class="col-sm-2">
				<form action="sachAdminController" method="post">
					<input type="text" name="txtTimKiem"> <br>
					<input type="submit" name="btnTimKiem" value="Tìm kiếm" class="btn-primary"> <br>
				</form>
			</div>
		</div>
	</div>
</body>
</html>