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
		<form action="${pageContext.request.contextPath}/customer/addCustomer" method="post" id="addForm1">
			<table border="1">
				<tr>
					<td>ID</td>
					<td>
						<input type="text" name="customerId" id="customerId">
						<button type="button" id="btn2" onclick="duplicateId()">중복확인</button>
						<span id="duplicateId"></span>
					</td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="customerPw" id="customerPw"></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="customerName" id="customerName"></td>
				</tr>
				<tr>
					<td>연락처</td>
					<td>
						<select name="customerPhone1" id="customerPhone1">
							<option value="010">010</option>
							<option value="011">011</option>
							<option value="012">012</option>
							<option value="013">013</option>
							<option value="02">02</option>
						</select>
						-
						<input type="text" name="customerPhone2" oninput="this.value = this.value.replace(/[^0-9]/g, '').replace(/(\..*)\./g, '$1');" maxlength="4" id="customerPhone2">
						-
						<input type="text" name="customerPhone3" oninput="this.value = this.value.replace(/[^0-9]/g, '').replace(/(\..*)\./g, '$1');" maxlength="4" id="customerPhone3">
					</td>
				</tr>
				<tr>
					<td>이메일</td>
					<td>
						<input type="text" name="customerEmail1" id="customerEmail1">
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
			<button type="button" id="submitBtn">가입하기</button>
		</form>
	</body>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
	<script>
		$(document).ready(function() {
			let allCheck = false;
			
			$('#submitBtn').click(function() {
				if($('#customerId').val() != null && $('#customerId').val() != '') {
					if($('#customerPw').val() != null && $('#customerPw').val() != '') {
						if($('#customerName').val() != null && $('#customerName').val() != '') {
							if($('#customerPhone2').val() != null && $('#customerPhone2').val() != '' && $('#customerPhone2').val().length >= 3) {
								if($('#customerPhone3').val() != null && $('#customerPhone3').val() != '' && $('#customerPhone3').val().length >= 3) {
									if($('#customerEmail1').val() != null && $('#customerEmail1').val() != '') {
										if($('#domain').val() != null && $('#domain').val() != '') {
											if($('#duplicateId').text() != '사용불가능 한 아이디입니다.' && $('#duplicateId').text() != '') {
												allCheck = true;
											} else {
												alert('ID중복확인이 필요합니다.');
											}
										} else {
											alert('이메일2 입력해주세요.');
										}
									} else {
										alert('이메일 입력해주세요.');
										$('#customerEmail1').focus();
									}
								} else {
									alert('핸드폰 번호를 입력해주세요.');
									$('#customerPhone3').focus();
								}
							} else {
								alert('핸드폰 번호를 입력해주세요.');
								$('#customerPhone2').focus();
							}
						} else {
							alert('이름을 입력해주세요.');
							$('#customerName').focus();
						}
					} else {
						alert('비밀번호를 입력해주세요.');
						$('#customerPw').focus();
					}
				} else {
					alert('ID를 입력해주세요.');
					$('#customerId').focus();
				}
				
				if(allCheck) {
					console.log('allCheck true');
					$('#addForm1').submit();
				}
			})
		})
	</script>
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
	
	<script>
		function duplicateId() {
			if($('#customerId').val().length > 0 && $('#customerId').val() != '') {
				$.ajax({
					url:'customerIdCk'
					, type:'get'
					, data : {customerId:$('#customerId').val()}
					, success:function(model){ // model : 'YES' / 'NO'
						if(model=='YES') {
							// 사용가능한 아이디
							$('#duplicateId').text('사용가능한 ID입니다.');
						} else {
							// 사용중인 아이디
							$('#duplicateId').text('사용불가능 한 아이디입니다.');
						}
					}
				});
			} else {
				alert('ID를 입력해주세요.');
			}
		}
	</script>
	
</html>