package kr.co.jboard.dao;

import kr.co.jboard.dto.FileDTO;
import kr.co.jboard.util.DBHelper;

public class FileDAO extends DBHelper {
	
	// 싱글톤
	private static FileDAO instance = new FileDAO();
	public static FileDAO getInstance() {
		return instance;
	}
	private FileDAO() {}
	
	// 기본 CRUD 메서드
	public FileDTO select(String fno) {
		
	}
}
