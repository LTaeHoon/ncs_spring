<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>회원 목록</h3>
		<div align="center">
			<table border="1">
				<tr><th colspan='4' text-align="right"><a href="<%=request.getContextPath()%>/reg.do">등록</a> </th></tr>
				<tr>
					<td>아이디</td>
					<td>비밀번호</td>
					<td>이름</td>
					<td>가입일자</td>
				</tr>
				<c:forEach items="${memberList}" var="member">
				<tr>
					<td><a href="seldetail.do?id=${member.id}">${member.id }</a></td>
					<td>${member.passwd }</td>
					<td>${member.name }</td>
					<td>${member.reg_date }</td>
				</tr>
				</c:forEach>
			</table>
		</div>
	
</body>
</html>