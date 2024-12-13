<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="tam.GioHangBO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="maSach" value="${param.maSach }" />
	<c:set var="maSachSua" value="${param.btnSua }" />
	<c:set var="sl" value="${param.txtSl }" />
	<c:set var="ds" value="${paramValues.selected }" />
		<c:if test="${sessionScope.gioHang != null }">
			<c:set value="${sessionScope.gioHang }" var="gioHang"/>
			<c:if test="${maSach != null }">
				<c:out value="${gioHang.xoa(maSach) }"></c:out>
			</c:if>
			<c:if test="${maSachSua != null }">
				<c:out value="${gioHang.capNhat(maSachSua, Long.parseLong(sl)) }"></c:out>				
			</c:if>
			
			<c:if test="${param.btnXoaChon != null }">
				<c:forEach var="ma" items="${ds }" >
					<c:out value="${gioHang.xoa(ma) }"></c:out>
				</c:forEach>
			</c:if>		
			<c:set scope="session" var="gioHang" value="${gioHang }" />	
			<c:redirect url="hienThiGioHangController" />
		</c:if>
</body>
</html>