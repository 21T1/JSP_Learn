<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="container">
		<div class="row" style="display: flex; justify-content: center;">
        	<div class="col-md-4">
				<form action="dangNhapController" method="post">
					<div class="form-group">
                        <input type="text" class="form-control" placeholder="Tên đăng nhập" name="txtName" />
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control" placeholder="Mật khẩu" name="txtPass" />
                    </div>
					<p style="color: red;">
						<c:out value="${message != null ? message : ''}"></c:out>
					</p>
					<div class="form-group">
                        <input type="submit" class="btn btn-primary form-control" name="btnSubmit" value="Đăng nhập" />
                    </div>
                    <a href="dangNhapAdminController">Đăng nhập Admin</a>
				</form>
			</div>
		</div>
	</div>
</body>
</html>