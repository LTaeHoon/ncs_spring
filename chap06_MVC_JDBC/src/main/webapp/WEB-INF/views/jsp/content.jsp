<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<title>상품 상세 화면</title>
<link rel="stylesheet" type="text/css" href="resources/css/content.css">
</head>
<body>
<div align="center" class="body">
<h2 id="title">상품 상세 화면</h2>
<table>
	<tr>
		<td> <img src="resources/img/${item.item_pic}"> </td>
		<td align="center">
		<table>
			<tr height="50">
				<th width="80">상품명</th>
				<td width="160">${item.item_name}</td>
			</tr>
			<tr height="50">
				<th width="80">가격</th>
				<td width="160">${item.item_price}원</td>
			</tr>
			<tr height="50">
				<th width="80">비고</th>
				<td width="160">${item.item_des}</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				  <a href="<%=request.getContextPath() %>/main.do">
				  <input type="button" value="목록 이동" class="btn"></a>
				</td>
			</tr>
		</table>
		</td>
	</tr>
</table>
</div>
</body>
</html>