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
	<%String message = (String) request.getAttribute("message");%>
	
	<div class="container">
		<div class="row" style="display: flex; justify-content: center;">
        	<div class="col-md-4">
				<form action="uploadFileController" method="post" enctype= "multipart/form-data">
					<div class="form-group">
                        <input type="text" class="form-control" placeholder="Họ và tên" name="txtHoTen" />
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="Địa chỉ" name="txtDiaChi" />
                    </div>
                    <div class="form-group">
                        <input type="file" class="form-control" name="txtFile" />
                    </div>
					<p style="color: red;"><%= (message == null) ? "" : message %></p>
					
					<div class="form-group">
                        <input type="submit" class="btn btn-primary form-control" name="btnSubmit" value="Đăng nhập" />
                    </div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>