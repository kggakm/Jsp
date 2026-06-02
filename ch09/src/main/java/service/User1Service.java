package service;

/*
	Service 컴포넌트
	 - Controller와 DAO 사이에 상호작용을 대리하는 MVC 모델 컴포넌트
	 - Business 로직 처리에 사용하는 컴포넌트
 */

public class User1Service {
	
	// 싱글톤
	private static User1Service instance = new User1Service();
	public static User1Service getInstance() {
		return instance;
	}
	private User1Service() {}
	
	// DAO 객체 가져오기
	private User1DAO dao = User1DAO.getInstance();

}
