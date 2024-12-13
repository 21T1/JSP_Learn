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
        			<c:out value="${sachSua == null ? 'Thêm sách' : 'Sửa sách' }"></c:out>
        		</h3>
				<form action="themSuaSachAdminController?maSachSua=${sachSua == null ? '' : sachSua.getMaSach() }" method="post" enctype= "multipart/form-data">
					<div class="form-group">
						<label>Mã sách: </label>
                        <input type="text" class="form-control" placeholder="Mã sách" name="txtMaSach" value="${sachSua.getMaSach() }"/>
                    </div>
					<div class="form-group">
                    	<label>Tên sách: </label>
                        <input type="text" class="form-control" placeholder="Tên sách" name="txtTenSach" value="${sachSua.getTenSach() }" />
                    </div>
                    <div class="form-group">
                    	<label>Số lượng: </label>
                        <input type="number" class="form-control" placeholder="Số lượng" name="txtSl" value="${sachSua.getSoLuong() }" />
                    </div>
                    <div class="form-group">
                    	<label>Giá: </label>
                        <input type="number" class="form-control" placeholder="Giá" name="txtGia" value="${sachSua.getGia() }" />
                    </div>
					<div class="form-group">
						<label>Loại sách:</label>
						<select class="form-control" name="txtMaLoai" >
							<option selected disable value=""> -- Chọn loại --  </option>
					    	<c:forEach var="loai" items="${dsLoai }">
					    		<c:choose>
					    			<c:when test="${sachSua.getMaLoai() eq loai.getMaLoai()}">
						    			<option selected value="${loai.getMaLoai() }"> ${loai.getTenLoai() } </option>
						    		</c:when>
						    		<c:otherwise>
										<option value="${loai.getMaLoai() }"> ${loai.getTenLoai() } </option>		    			
						    		</c:otherwise>
					    		</c:choose>
					    	</c:forEach>
					    </select> 
					</div>
                    <div class="form-group">
                    	<label>Tác giả: </label>
                        <input type="text" class="form-control" placeholder="Tác giả" name="txtTacGia" value="${sachSua.getTacGia() }" />
                    </div>
                    <div class="form-group">
                    	<label>Ảnh:</label>
				        <input type="hidden" name="txtAnh" value="${sachSua.getAnh() }" />                    
				        <input type="file" class="form-control" name="txtAnh"
				                onchange="document.getElementById('uploadPhoto').src = window.URL.createObjectURL(this.files[0])" />
					</div>
					<div class="form-group">
						<img id="uploadPhoto" src="${sachSua.getAnh() }" class="img img-bordered" style="width:200px" />
					</div>
					<p style="color: red;"><c:out value="${message != null ? message : '' }"></c:out></p>
					
					<div class="form-group">
                        <c:if test="${sachSua == null }">
                        	<input type="submit" class="btn btn-primary form-control" name="btnSubmitSach" value="Xác nhận" />
                        </c:if>
                        <c:if test="${sachSua != null }">
                        	<input type="submit" class="btn btn-primary form-control" name="btnSubmitSach" value="Cập nhật" />
                        </c:if>
                    </div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>