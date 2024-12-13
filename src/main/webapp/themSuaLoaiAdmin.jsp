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
        		<h3 align="center">
        			<c:out value="${loaiSua == null ? 'Thêm loại' : 'Chỉnh sửa loại'  }"></c:out>
        		</h3>
				<form action="themSuaLoaiAdminController?maLoaiSua=${loaiSua == null ? '' : loaiSua.getMaLoai() }" method="post">
					<div class="form-group">
						<label>Mã loại: </label>
                        <input type="text" class="form-control" placeholder="Mã sách" name="txtMaLoai" value="${loaiSua.getMaLoai() }"/>
                    </div>
					<div class="form-group">
                    	<label>Tên loại: </label>
                        <input type="text" class="form-control" placeholder="Tên sách" name="txtTenLoai" value="${loaiSua.getTenLoai() }" />
                    </div>
                 
					<p style="color: red;"><c:out value="${message != null ? message : '' }"></c:out></p>
					
					<div class="form-group">
                        <c:if test="${loaiSua == null }">
                        	<input type="submit" class="btn btn-primary form-control" name="btnSubmitLoai" value="Xác nhận" />
                        </c:if>
                        <c:if test="${loaiSua != null }">
                        	<input type="submit" class="btn btn-primary form-control" name="btnSubmitLoai" value="Cập nhật" />
                        </c:if>
                    </div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>