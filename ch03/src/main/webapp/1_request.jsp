<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>1_request</title>
	</head>
	<body>
		<h3>1.request 내장객체</h3>
		
		<h4>GET 요청</h4>
		<a href="./proc/result1.jsp?userid=a101">result1</a> <!-- 주소 뒤 ? 파라미터(쿼리스트링) 전송 -->
		<a href="./proc/result2.jsp?userid=a101&name=홍길동">result2</a> <!-- 주소 뒤 ? 파라미터(쿼리스트링) 전송 -->
		<a href="./proc/result3.jsp?userid=a101&name=홍길동&age=21">result3</a> <!-- 주소 뒤 ? 파라미터(쿼리스트링) 전송 -->
		
		<h4>POST 요청</h4>
		<form action="./proc/result4.jsp" method="post">
			<input type="text" name="userid"/><br>
			<input type="text" name="name"/><br>
			<input type="number" name="age"/><br>
			<input type="submit" value="전송하기"/><br>
		</form>
	
	</body>
</html>