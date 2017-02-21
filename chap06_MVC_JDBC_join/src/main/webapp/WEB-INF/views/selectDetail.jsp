<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
	<table border="1">
		<tr>
			<th colspan="2" text-align="center">회원 정보</th>
		</tr>
		<tr>
			<th>아이디</th>
			<td>${member.id }</td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td>${member.passwd }</td>
		</tr>
		<tr>
			<th>이름</th>
			<td>${member.name }</td>
		</tr>
		<tr>
			<th>날짜</th>
			<td>${member.reg_date }</td>
		</tr>
		<tr>
			<td colspan="2"><a href="<%=request.getContextPath() %>/main.do">[목록보기]</a>&nbsp
			<a href="<%=request.getContextPath() %>/up.do?id=${member.id}">[수정]</a>&nbsp
			<a href="<%=request.getContextPath() %>/del.do?id=${member.id }">[삭제]</a></td>
		</tr>	
	</table>
	</div>
</body>
</html>