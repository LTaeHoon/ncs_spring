<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2> 글쓰기 결과 </h2>
	글번호 : ${vo2.bno}<br>
	글제목 : ${vo2.title }<br>
	글내용 : ${vo2.content }
	<hr>
	
	<a href="<%=request.getContextPath() %>/index.jsp">목록</a>
</body>
</html>