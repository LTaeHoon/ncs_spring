<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2> 생성된 계정 </h2>
	<br>
	<ul>
		<li>아이디 : ${account.id }</li>
		<li>이름 : ${account.name }</li>
		<li>우편번호 : ${account.zipcode}</li>
		<li>주소 : ${account.address1 }-${account.address2 }</li>
		
	</ul>
	<hr>
	<a href="<%=request.getContextPath() %>/index.jsp">index.jsp</a>
	
</body>
</html>