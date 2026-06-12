package kr.co.jboard.controller.article;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.co.jboard.dto.ArticleDTO;
import kr.co.jboard.dto.CommentDTO;
import kr.co.jboard.service.ArticleService;
import kr.co.jboard.service.CommentService;

@WebServlet("/article/view.do")
public class ViewController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	// 서비스 가져오기(열거상수 객체)
	private ArticleService service = ArticleService.INSTANCE;
	private CommentService commentService = CommentService.INSTANCE;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String page = req.getParameter("page");
		String ano = req.getParameter("ano");
		
		// 해당 글 조회수 업데이트하기
		service.plusHit(ano);
		
		// 조회글 가져오기
		ArticleDTO articleDTO = service.findById(ano);
		
		// 댓글 가져오기
		List<CommentDTO> commentList = commentService.findAll(ano);
		
		// View 공유 참조
		req.setAttribute("page", page);
		req.setAttribute("articleDTO", articleDTO);
		req.setAttribute("commentList", commentList);
		
		
		// View 포워드
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/article/view.jsp");
		dispatcher.forward(req, resp);	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
	

}