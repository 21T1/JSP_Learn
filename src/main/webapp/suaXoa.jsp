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
	<%-- <c:set var="maSach" value="${maSach }" />
	<c:set var="maSachSua" value="${btnSua }" />
	<c:set var="sl" value="${txtSl }" /> --%>
	<%	String maSach = request.getParameter("maSach");
		String maSachSua = request.getParameter("btnSua");
		String sl = request.getParameter("txtSl");
		String[] ds = request.getParameterValues("selected");
		if (session.getAttribute("gioHang") != null) {
			GioHangBO gioHang = (GioHangBO) session.getAttribute("gioHang");
			if (maSach != null) {
				gioHang.xoa(maSach);
			}
			if (maSachSua != null) {
				gioHang.capNhat(maSachSua, Long.parseLong(sl));
			}
			if(request.getParameter("btnXoaChon") != null) {
				for (String ma: ds)
			    	gioHang.xoa(ma);
			}
			session.setAttribute("gioHang", gioHang);
			response.sendRedirect("hienThiGioHangController");
		}
	%>
</body>
</html>