<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/select/game.do" method="post">
		게임 타입 : 
			<select name ="type">
				<c:forEach var="searchType" items="${searchTypeList}">
					<option value="${searchType.gno}">${searchType.gtype}</option>		
				</c:forEach>
			</select>
			<br>
			검색어 : <input name="query"/>
			<input type="submit" value="선택"/>
	
	</form>
</body>
</html>