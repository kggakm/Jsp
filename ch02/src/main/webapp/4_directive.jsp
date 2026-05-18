<%@ page import="sub1.Account"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>4_directive</title>
	</head>
	<body>
		<h3>4.지시자</h3>
		
		<%
			Account kb = new Account("국민은행", "101-12-1001", "김유신", 1000);
			kb.deposit(30000);
			kb.withdraw(5000);
			kb.show(out);
		%>
	
	</body>
</html>