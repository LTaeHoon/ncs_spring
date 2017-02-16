<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>index</title>
</head>
<body>
	<h2> 시작 페이지 </h2>
	<!-- spring.mvc.test -->
	<a href="<%=request.getContextPath() %>/home.do">HomeController</a><br>
	<!-- spring.mvc.ch01 -->
	<a href="<%=request.getContextPath() %>/hello.do">ch01_HelloController</a><br>
	<!-- spring.mvc.ch02 : url : 가상폴더/가상파일, view: 시작폴더/하위폴더--> 
	<a href="<%=request.getContextPath() %>/command/object.do">ch02_CommandController</a><br>
	<!-- spring.mvc.ch03 : get 방식 파라미터 전송--> 
	<a href="<%=request.getContextPath() %>/param/userInfo.do?name=hong&age=23">ch03_ParamController</a><br>
	<!-- spring.mvc.ch03 : get 방식 파라미터 전송(age 없는 경우)--> 
	<a href="<%=request.getContextPath() %>/param/userInfo.do?name=hong">ch03_ParamController</a><br>
	
	<!-- spring.mvc.exam : 로그인 처리 -->
	<a href="<%=request.getContextPath() %>/login.do">ExamController</a><br>
	<!-- spring.mvc.ch04 : Model 객체-->
	<a href="<%=request.getContextPath() %>/model.do?op1=100&op2=200">ModelController</a><br>
	<!-- spring.mvc.ch05 : cookie 생성/확인 -->
	<a href="<%=request.getContextPath() %>/cookie/make.do">CookieController(make)</a><br>
	<a href="<%=request.getContextPath() %>/cookie/view.do">CookieController(view)</a><br>
	<!-- spring.mvc.exam2 -->
	<a href="<%=request.getContextPath() %>/account/create.do">AccountController</a><br>
	<!-- spring.mvc.ch06 : 예외처리 -->
	<a href="<%=request.getContextPath() %>/select/main.do">SelectController</a><br>
	
</body>
</html>