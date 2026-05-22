<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
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
	//String host = "jdbc:mysql://127.0.0.1:3306/studydb";
	//String user = "kggakm";
	//String pass = "1234";
	
	try {
		// 일반 JDBC 접속 방식
		// 1) 드라이버 로드
		//Class.forName("com.mysql.cj.jdbc.Driver");
		// 2) 데이터베이스 접속
		//Connection conn = DriverManager.getConnection(host, user, pass);
		
		// DBCP 방식
		// 1) JNDI 서비스 객체 생성
		Context initCtx = new InitialContext();
		Context ctx = (Context) initCtx.lookup("java:comp/env");
		
		// 2) 커넥션풀 데이터베이스 커넥션 가져오기
		DataSource ds = (DataSource) ctx.lookup("jdbc/studydb");
		Connection conn = ds.getConnection();
		
		// 3) SQL 실행 객체 생성
		String sql = "INSERT INTO `user1` VALUES (?,?,?,?)";
		PreparedStatement psmt = conn.prepareStatement(sql);
		psmt.setString(1, userid);
		psmt.setString(2, name);
		psmt.setString(3, hp);
		psmt.setString(4, age);		//21, '21'

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
	response.sendRedirect("/ch05/user1/list.jsp?register=success");
%>