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
	<jsp:include page="header.jsp"/>
	<div class="container">
		<div class="row">
			<!-- Loại sách -->
			<div class="col-sm-2">
				<%	ArrayList<Loai> dsLoai = (ArrayList<Loai>) request.getAttribute("dsLoai");
					for (Loai loai : dsLoai) {%>
						<a href ="sachController?maLoai=<%=loai.getMaLoai() %>">
							<%=loai.getTenLoai()%>
						</a><hr>
				<%} %>
			</div>
			
			<!-- Sách -->
			<div class="col-sm-8">
				<div class="row">
					<% 	ArrayList<Sach> dsSach = (ArrayList<Sach>) request.getAttribute("dsSach");
						int countSach = (Integer) request.getAttribute("countSach");
						int countP = (Integer) request.getAttribute("countP");
						int currentP = 1;
						if (request.getParameter("p") != null) {
						 	currentP = Integer.parseInt(request.getParameter("p"));
						}
												
						int quantity = 9, row = 3;
						if (currentP == countP) {
							quantity = countSach - (currentP - 1) * quantity;
							row = quantity / 3;
							if (quantity % 3 != 0) {
								row += 1;
							}
						}
			        	if (dsSach != null) {
			        		out.print("Ok");
				            for (int i = 0; i < row; i++) { %>
            				<div class="row">
				                <% 	for (int j = 0; j < 3; j++) {
						                int index = i * 3 + j;
						                
						                if (currentP != countP || (currentP == countP && index < quantity)) {
						                	Sach sach = dsSach.get(index); %>
						                    <div class="col-sm-4">
						                        <img src="<%=sach.getAnh() %>"> <br>
												<p><%=sach.getTenSach() %></p>		
												<a href="gioHangController?maSach=<%= sach.getMaSach() %>&tenSach=<%= sach.getTenSach() %>&gia=<%= sach.getGia()%>">
													<i class="fa-solid fa-cart-shopping"></i>
												</a>
						                    </div>		
		                			<%	} 
	                				}%>
            				</div>
        				<% 	} 
        				} %>
				</div>
			</div>
			
			<div class="col-sm-2">
				<form action="sachController" method="post">
					<input type="text" name="txtTimKiem"> <br>
					<input type="submit" name="btnTimKiem" value="Tìm kiếm" class="btn-primary"> <br>
				</form>
			</div>
		</div>
		
		<!-- Phân trang -->
		<nav aria-label="Page navigation example">
			<ul class="pagination" style="display: flex; justify-content: center;">
			    <li class="page-item">
					<a class="page-link" href="#" aria-label="Previous">
					    <span aria-hidden="true">&laquo;</span>
				      	<span class="sr-only">Previous</span>
					  </a>
				</li>
				<%	for (int i = 1; i <= countP; i++) { 
						if (currentP == i) {%>
						    <li class="page-item active">
						    	<a class="page-link" href="sachController?p=<%=i%>"><%=i%></a>
					    	</li>
			   		<%	} else { %>
			   				<li class="page-item">
						    	<a class="page-link" href="sachController?p=<%=i%>"><%=i%></a>
					    	</li>
					<%	}
					} 	%>
				<li class="page-item">
				 	<a class="page-link" href="#" aria-label="Next">
				    	<span aria-hidden="true">&raquo;</span>
				        <span class="sr-only">Next</span>
		  			</a>
			    </li>
	  		</ul>
		</nav>
	</div>
</body>
</html>