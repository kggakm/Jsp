package dao;

import java.util.ArrayList;
import java.util.List;

import dto.User1DTO;
import util.DBHelper;
import util.SQL;

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
			psmt.setString(1, dto.getUserid());
			psmt.setString(2, dto.getName());
			psmt.setString(3, dto.getHp());
			psmt.setInt(4, dto.getAge());
			
			psmt.executeUpdate();
			closeAll();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public User1DTO select(String userid) {
		
		// 반환용 DTO 선언
		User1DTO dto = null;
		
		try {
			conn = getConnection();
			
			psmt = conn.prepareStatement(SQL.SELECT_USER1);
			psmt.setString(1, userid);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				dto = new User1DTO(); // DTO 생성
				dto.setUserid(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setHp(rs.getString(3));
				dto.setAge(rs.getInt(4));
			}
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dto;
	}
	
	public List<User1DTO> selectAll() {
		
		// 반환용 리스트 선언
		List<User1DTO> dtoList = new ArrayList<>();
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL.SELECT_ALL_USER1);
			
			while(rs.next()) {
				User1DTO dto = new User1DTO();
				dto.setUserid(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setHp(rs.getString(3));
				dto.setAge(rs.getInt(4));
				dtoList.add(dto);
			}
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dtoList;	
	}
	
	public void update(User1DTO dto) {
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.UPDATE_USER1);
			psmt.setString(1, dto.getName());
			psmt.setString(2, dto.getHp());
			psmt.setInt(3, dto.getAge());
			psmt.setString(4, dto.getUserid());
			psmt.executeUpdate();
			closeAll();		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void delete(String userid) {
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(SQL.DELETE_USER1);
			psmt.setString(1, userid);
			psmt.executeUpdate();
			closeAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}