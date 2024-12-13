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
	<jsp:include page="headerAdmin.jsp" />
	<div class="container">
		<div class="row" style="display: flex; justify-content: center;">
        	<div class="col-md-4">
				<form action="dangNhapAdminController" method="post">
					<div class="form-group">
                        <input type="text" class="form-control" placeholder="Tên đăng nhập" name="txtName" />
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control" placeholder="Mật khẩu" name="txtPass" />
                    </div>
                    
                    <c:catch var="catchException">
                    	<c:set var="count" value="${loginCount }"></c:set>
	                    <c:if test="${count >= 5 }">
	                    	<div class="form-group">
								<input type="text" class="form-control" placeholder="Captcha" name="answer"/> <br>
								<img src="simpleCaptcha.jpg" />
							</div>
	                    </c:if>
                    </c:catch>
                    <c:if test="${catchException != null }">
                    	<c:out value="${catException.message }"></c:out>
                    </c:if>
                    
					<p style="color: red;">
						<c:out value="${message != null ? message : ''}"></c:out>
					</p>
					
					<div class="form-group">
                        <input type="submit" class="btn btn-primary form-control" name="btnSubmit" value="Đăng nhập" />
                    </div>
                    <a href="dangNhapController">Đăng nhập Khách hàng</a>                
				</form>
			</div>
		</div>
	</div>
</body>
</html>