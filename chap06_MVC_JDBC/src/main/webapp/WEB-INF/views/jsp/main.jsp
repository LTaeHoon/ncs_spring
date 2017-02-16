<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>상품 목록 화면</title>
<link rel="stylesheet" type="text/css" href="resources/css/main.css">
</head>
<body>
<div align="center" class="body">
<h2>상품 목록 화면</h2>
<table border="1">
	<tr class="header">
		<th align="center" width="80">상품ID</th>
		<th align="center" width="250">상품명</th>
		<th align="center" width="100">가격</th>
	</tr>
	<!-- itemList 키값 있는 경우 상품목록 출력 -->
	<c:forEach items="${itemList}" var="item">
		<tr class="record">
			<td align="center">${item.item_id}</td>
			<td align="center">
			<!-- 상품명을 클릭하면 해당 상품의 id를
			     get방식으로 넘긴다. -->
			<a href="content.do?item_id=${item.item_id}">
			${item.item_name}</a>
			</td>
			<td align="right">${item.item_price}원</td>
		</tr>
	</c:forEach>
</table>
</div>
</body>
</html>