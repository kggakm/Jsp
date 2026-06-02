package dao;

import dto.User1DTO;
import util.DBHelper;

// DAO(Data Access Object) : 데이터베이스와 상호작용(SQL 처리)하는 MVC 컴포넌트
public class User1DAO extends DBHelper {
	
	// 싱글톤
	private static User1DAO instance = new User1DAO();
	public static User1DAO getInstance() {
		return instance;
	}
	private User1DAO() {}
	
	// 기본 CRUD 메서드
	public void insert(User1DTO dto) {
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.INSERT_USER1);
		}
		
	}
	
	
}
