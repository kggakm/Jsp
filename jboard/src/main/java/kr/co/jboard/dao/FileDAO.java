package kr.co.jboard.dao;

import java.util.ArrayList;
import java.util.List;

import kr.co.jboard.dto.FileDTO;
import kr.co.jboard.util.DBHelper;
import kr.co.jboard.util.SQL;

public class FileDAO extends DBHelper {
	
	// 싱글톤
	private static FileDAO instance = new FileDAO();
	public static FileDAO getInstance() {
		return instance;
	}
	private FileDAO() {}
	
	
	// 기본 CRUD 메서드
	public FileDTO select(String fno) {
		
		// 반환용 DTO
		FileDTO dto = null;
		
		try {
			conn = getConnection();						
			psmt = conn.prepareStatement(SQL.SELECT_FILE);
			
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				dto = new FileDTO();
			}			
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	
	public List<FileDTO> selectAll() {
		
		// 반환용 List
		List<FileDTO> dtoList = new ArrayList<>();
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL.SELECT_ALL_FILE);
			
			while(rs.next()) {
				FileDTO dto = new FileDTO();
				dtoList.add(dto);
			}
			
			closeAll();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}
	
	public void insert(FileDTO dto) {
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.INSERT_FILE);
			psmt.setInt(1, dto.getAno());
			psmt.setString(2, dto.getOfname());
			psmt.setString(3, dto.getSfname());
			psmt.executeUpdate();
			closeAll();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void update(FileDTO dto) {
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.UPDATE_FILE);
			psmt.executeUpdate();
			closeAll();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(String fno) {
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.DELETE_FILE);
			psmt.executeUpdate();
			closeAll();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}