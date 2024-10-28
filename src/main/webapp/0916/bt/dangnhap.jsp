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
</head>
<body>
	<%	
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String message = "";
		String url = "https://ums.husc.edu.vn/";
		if(username != null && password !=null){
			if(username.equals("abc") && password.equals("123")){
				response.sendRedirect(url);	
			}else{
				message = "Thông tin đăng nhập không đúng!";
			}
		}
	%>
	<div style="margin: 0 auto; width: 245px;">
		<h3 style="color: #0d6efd;">GIẢNG VIÊN</h3>
		<form>
			<div class="form-group">
				<label><b>Tên đăng nhập:</b></label> <input type="text"
					class="form-control" name=username
					placeholder="Mã giảng viên/Email">
			</div>
			<div class="form-group">
				<label><b>Mật khẩu:</b></label> <input type="password"
					class="form-control" name="password" placeholder="Mật khẩu">
			</div>
			<p><%=message%></p>
			<input type="submit" class="btn btn-primary" style="width: 100%;"
				value="Đăng nhập"></input>
		</form>
	</div>
</body>
</html>