package kr.co.jboard.service;

import java.util.List;

import kr.co.jboard.dao.TermsDAO;
import kr.co.jboard.dto.TermsDTO;

public enum TermsService {

	// 열거 상수 객체(싱글톤)
	INSTANCE;
	
	// DAO 가져오기
	private TermsDAO dao = TermsDAO.getInstance();
	
	// DAO 호출 서비스 메서드
	public void register(TermsDTO dto) {
		dao.insert(dto);
	}
	
	public TermsDTO findById(int no) {
		return dao.select(no);
	}
	
	public List<TermsDTO> findAll() {
		return dao.selectAll();
	}
	
	public void modify(TermsDTO dto) {
		dao.update(dto);
	}
	
	public void remove(int no) {
		dao.delete(no);
	}
}