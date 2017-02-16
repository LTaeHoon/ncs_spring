<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2> 검색된 결과 </h2>
	게임유형 : ${search.type}<br>
	검색어 : ${search.query }<br>
	
	경로 : <%=request.getContextPath() %><br>
	<a href="<%=request.getContextPath() %>/select/main.do">목록</a>
</body>
</html>