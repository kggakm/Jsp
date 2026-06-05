package kr.co.jboard.service;

import java.util.List;

import kr.co.jboard.dao.ArticleDAO;
import kr.co.jboard.dto.ArticleDTO;
import kr.co.jboard.dto.PageGroupDTO;

public enum ArticleService {

	// 열거 상수 객체(싱글톤)
	INSTANCE;
	
	// DAO 가져오기
	private ArticleDAO dao = ArticleDAO.getInstance();
	
	// 페이지 계산 서비스 메서드
	public int getCurrentPage(String page) {
		int currentPage = 1;
		
		if(page != null) {
			currentPage = Integer.parseInt(page);
		}
		
		return currentPage;
	}
	public int getLastPageNum(int total) {
		int lastPageNum = (int) Math.ceil(total / 10.0);
		return lastPageNum;
	}
	public int getStart(int currentPage) {
		return (currentPage - 1) * 10;
	}
	
	public int getCurrentStartNum(int total, int currentPage) {
		int start = (currentPage - 1) * 10;
		return total - start;
	}
	
	public PageGroupDTO getCurrentPageGroup(int currentPage, int lastPageNum) {
		
		int currentPageGroup = (int) Math.ceil(currentPage / 10.0);
		int pageGroupStart = (currentPageGroup -1) * 10 + 1;
		int pageGroupEnd = currentPageGroup * 10;
		
		if(pageGroupEnd > lastPageNum) {
			pageGroupEnd = lastPageNum;
		}
		
		return new PageGroupDTO(pageGroupStart, pageGroupEnd);
		
	}
	
	// DAO 호출 서비스 메서드
	public int getCount() {
		return dao.selectCount();
	}
	
	public int register(ArticleDTO dto) {
		return dao.insert(dto);
	}
	
	public ArticleDTO findById(String ano) {
		return dao.select(ano);
	}
	
	public List<ArticleDTO> findAll(int start) {
		return dao.selectAll(start);
	}
	
	public void modify(ArticleDTO dto) {
		dao.update(dto);
	}
	
	public void remove(String ano) {
		dao.delete(ano);
	}
}