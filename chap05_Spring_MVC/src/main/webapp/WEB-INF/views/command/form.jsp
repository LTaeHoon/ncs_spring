<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글쓰기 폼</title>
</head>
<body>
	<h2> 글쓰기 폼 </h2>
	<form method="post"> <!-- action 생략 시 : 컨트롤러가 넘긴 url로 인식-->
		<input type="hidden" name="bno" value="0"/>
		제목 : <input name="title"/> <br>
		내용 : <input name="content"/> <br>					
		<input type="submit" value="전송"/>
	</form>
</body>
</html>