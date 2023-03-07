<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html>
	
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>

	<body>
		<h1>광고 회원등록</h1>
		<form action="${pageContext.request.contextPath}/customer/addCustomer" method="post">
			<table border="1">
				<tr>
					<td>ID</td>
					<td>
						<input type="text" name="customerId">
						<button type="button" id="btn2">중복확인</button>
					</td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="customerPw"></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="customerName"></td>
				</tr>
				<tr>
					<td>연락처</td>
					<td>
						<select name="customerPhone1">
							<option value="010">010</option>
							<option value="011">011</option>
							<option value="012">012</option>
							<option value="013">013</option>
							<option value="02">02</option>
						</select>
						-
						<input type="text" name="customerPhone2" oninput="this.value = this.value.replace(/[^0-9]/g, '').replace(/(\..*)\./g, '$1');" maxlength="4">
						-
						<input type="text" name="customerPhone3" oninput="this.value = this.value.replace(/[^0-9]/g, '').replace(/(\..*)\./g, '$1');" maxlength="4">
					</td>
				</tr>
				<tr>
					<td>이메일</td>
					<td>
						<input type="text" name="customerEmail1">
						@
						<input type="text" name="customerEmail2" readonly="readonly" id="domain">
						<select id="selectDomain" onchange="changeMail()">
							<option value="" selected>선택해주세요.</option>
							<option value="naver.com">naver.com</option>
							<option value="gmail.com">gmail.com</option>
							<option value="1">직접입력</option>
						</select>
					</td>
				</tr>
			</table>
			<button type="button">가입하기</button>
		</form>
	</body>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
	<script>
		function changeMail() {
			let domain = $('#domain');
			if($('#selectDomain option:selected').val() != '1') {
				domain.val($('#selectDomain option:selected').val());
				domain.attr('readonly', true);
			} else {
				domain.val('');
				domain.attr('readonly', false);
			}
		}
	</script>
	
</html>