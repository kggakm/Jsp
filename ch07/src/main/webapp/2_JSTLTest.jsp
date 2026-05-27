<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>2_JSTLTest</title>
	</head>
	<body>
		<h3>2.JSTL(Java Standards Tag Library) 실습</h3>
		
		<h4>스크립트릿 방식</h4>
		<%
			// 변수선언
			String str = "hello";
			out.println("<p>str : " + str + "</p>");
			
			// 조건문	
			// 반복문	
			// 문자열처리	
		
		%>
		
		<h4>JSTL 방식</h4>
		<!-- 변수선언 -->
		<c:set var="str" value="hello"/>
		<p>str : ${str}</p>
		
	
	</body>
</html>