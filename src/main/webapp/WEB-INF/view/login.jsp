<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
	
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>

	<body>
		<h1>로그인 페이지</h1>
		
		
		<form action="${pageContext.request.contextPath}/customer/login" method="post" id="form1">
			<table border="1">
				<tr>
					<td>아이디</td>
					<td><input type="text" name="customerId" id="customerId"></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="customerPw" id="customerPw"></td>
				</tr>
			</table>
			<button type="submit" id="submitBtn">로그인</button>
		</form>
		
		<a href="${pageContext.request.contextPath}/customer/logoutPage">통합페이지로 이동</a>
	</body>
	
</html>