<%@ page import="java.sql.*" %>
<%@ page import="khachHangModal.*"%>
<%@ page import="ketNoiModal.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%	KetNoi ketNoi = new KetNoi();
	ketNoi.ketNoi();
	String sql = "select * from KhachHang "
			+ "where tendn = ? and pass = ?";
	PreparedStatement pstmt = ketNoi.cn.prepareStatement(sql);
	pstmt.setString(1, "nkchung");
	pstmt.setString(2, "123");
	ResultSet rs = pstmt.executeQuery();
	if (rs.next()) {
		out.println("True");
	}
	
	rs.close();
	ketNoi.cn.close();
		%>
</body>
</html>