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
	<c:if test="${sessionScope.login != null}">
		<jsp:include page="header.jsp" />
		<c:remove var="login" scope="session" />
		<c:redirect url="dangNhapController" />
	</c:if>
	<c:if test="${sessionScope.loginAdmin != null}">
		<jsp:include page="headerAdmin.jsp" />
		<c:remove var="loginAdmin" scope="session" />
		<c:redirect url="dangNhapAdminController" />
	</c:if>
</body>
</html>