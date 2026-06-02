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
	public CommentDTO select(String cno) {
		
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
		List<CommentDTO> dtoList = new ArrayList<>();
		
		try {
			 conn = getConnection();
			 stmt = conn.createStatement();
			 
			 rs = stmt.executeQuery(SQL.SELECT_ALL_COMMENT);
			 
			 while(rs.next()) {
				 CommentDTO dto = new CommentDTO();
				 dtoList.add(dto);
			 }
			 closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dtoList;
	}
	
	public void insert(CommentDTO dto) {
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.INSERT_COMMENT);
			psmt.executeUpdate();
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void update(CommentDTO dto) {
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.UPDATE_COMMENT);
			psmt.executeUpdate();
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void delete(String cno) {
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.DELETE_COMMENT);
			psmt.executeUpdate();
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}