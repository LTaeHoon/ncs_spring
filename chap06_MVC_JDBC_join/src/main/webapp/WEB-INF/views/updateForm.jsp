<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="<%=request.getContextPath() %>/update.do">
<div align="center">
	<table border="1">
		<tr>
			<th colspan="2" text-align="center">회원 정보</th>
		</tr>
		<tr>
			<th>아이디</th>
			<td><input name="id" readonly="readonly" value="${member.id }"/></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input name="passwd" type="password" value="${member.passwd }"/></td>
		</tr>
		<tr>
			<th>이름</th>
			<td><input name="name" value="${member.name }"/></td>
		</tr>
		<tr>
			<th>가입일</th>
			<td>${member.reg_date }</td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="수정"/></td>
		</tr>	
	</table>
	</div>
	</form>
</body>
</html>