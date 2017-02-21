<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post">
		<div>
		<table border="1">
			
			<tr> <th colspan='3'>회원 등록하기</th> </tr>
			<tr>
				<th>아이디</th>
				<td><input name="id" size="20"/></td>	
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input name="passwd" type="password"/></td>	
			</tr>
			<tr>
				<th>이름</th>
				<td><input name="name"/></td>	
			</tr>
			<tr><td colspan="3"><input type="submit" value="보내기"/></td></tr>	
		</table>
		</div>
	</form>
</body>
</html>