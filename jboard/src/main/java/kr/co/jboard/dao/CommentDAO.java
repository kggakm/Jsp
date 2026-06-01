package kr.co.jboard.dao;

import java.util.ArrayList;
import java.util.List;

import kr.co.jboard.dto.CommentDTO;
import kr.co.jboard.util.DBHelper;
import kr.co.jboard.util.SQL;

public class CommentDAO extends DBHelper {
	
	// 싱글톤
	private static CommentDAO instance = new CommentDAO();
	public static CommentDAO getInstance() {
		return instance;
	}
	
	private CommentDAO() {}
	
	// 기본 CRUD 메서드
	public CommentDTO select(String userid) {
		
		// 반환용 DTO
		CommentDTO dto = null;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.SELECT_COMMENT);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				dto = new CommentDTO();
			}
			closeAll();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	
	public List<CommentDTO> selectAll() {
		
		// 반환용 List
		List<UserDTO> dtoList = new 
		
		try {
			 conn = getConnection();
			 stmt = conn.createStatement();
			 
			 rs = stmt.executeQuery(SQL.SELECT_ALL_USER);
			 
			 while(rs.next()) {
				UserDTO dto = new UserDTO();
				dto.setAno(rs.getInt(1));
				dto.setType(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setContent(rs.getString(3));
				dto.setComment(rs.getInt(4));
				dto.setFile(rs.getInt(5));
				dto.setHit(rs.getInt(6));
				dto.setWriter(rs.getString(1));
				dto.setRegip(rs.getString(1));
				dto.setWdate(rs.getString(1));
			 }
			 closeAll();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dtoList;
	}
	
	public void insert(UserDTO dto) {
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.INSERT_USER);
			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getContent());
			psmt.setString(3, dto.getWriter());
			psmt.setString(4, dto.getRegip());
			psmt.excuteUpdate();
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void update(UserDTO dto) {
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.UPDATE_USER);
			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getContent());
			psmt.setInt(3, dto.getAno());
			psmt.excuteUpdate();
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void delete(String ano) {
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.DELETE_USER);
			psmt.setString(1, ano));
			psmt.excuteUpdate();
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	

}
