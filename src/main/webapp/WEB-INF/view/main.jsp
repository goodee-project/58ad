<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	
	<body>
		<c:if test="${adCustomer == null}">
			<a href="${pageContext.request.contextPath}/customer/login">로그인페이지</a>
			<a href="${pageContext.request.contextPath}/customer/addCustomer">회원가입페이지</a>
		</c:if>
		<c:if test="${adCustomer != null}">
			<span>${adCustomer.adCustomerName}님 로그인했습니다.</span>
			<a href="${pageContext.request.contextPath}/customer/logout">로그아웃</a>
		</c:if>
	</body>
</html>