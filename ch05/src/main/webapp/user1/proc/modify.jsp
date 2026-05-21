<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	// 전송 데이터 수신
	String userid 	= request.getParameter("userid");
	String name 	= request.getParameter("name");
	String hp 		= request.getParameter("hp");
	String age 		= request.getParameter("age");
	
	
	//----------------------------------
	// 데이터베이스 작업
	//----------------------------------
	String host = "jdbc:mysql://127.0.0.1:3306/studydb";
	String user = "kggakm";
	String pass = "1234";
	
	try {
		// 1) 드라이버 로드
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// 2) 데이터베이스 접속
		Connection conn = DriverManager.getConnection(host, user, pass);
		
		// 3) SQL 실행 객체 생성
		String sql = "UPDATE `User1` SET ";
		sql += "name=?,";
		sql += "hp=?,";
		sql += "age=? ";
		sql += "WHERE userid=?";
		PreparedStatement psmt = conn.prepareStatement(sql);
		psmt.setString(1, name);
		psmt.setString(2, hp);
		psmt.setString(3, age);
		psmt.setString(4, userid);		//21, '21'

		// 4) SQL 실행
		psmt.executeUpdate();

		// 5) 결과셋 처리(SELECT일 경우)
		// 6) 데이터베이스 종료
		psmt.close();
		conn.close();
		
	} catch(Exception e) {
		e.printStackTrace();
	}
	
	// 목록 이동
	response.sendRedirect("/ch05/user1/list.jsp?modify=success");
%>