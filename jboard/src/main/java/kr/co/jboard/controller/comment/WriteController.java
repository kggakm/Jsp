package kr.co.jboard.controller.comment;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.co.jboard.dto.CommentDTO;
import kr.co.jboard.service.CommentService;

@WebServlet("/comment/write.do")
public class WriteController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private CommentService service = CommentService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		// 전송 파라미터 수신
		String page = req.getParameter("page");
		String parent = req.getParameter("parent");
		String content = req.getParameter("content");
		String writer = req.getParameter("writer");
		String regip = req.getRemoteAddr();
		
		// 서비스 전달용 DTO 생성
		CommentDTO dto = new CommentDTO();
		dto.setParent(parent);
		dto.setContent(content);
		dto.setWriter(writer);
		dto.setRegip(regip);
		
		// 서비스 호출
		service.register(dto);
		
		// 화면 이동
		resp.sendRedirect("/jboard/article/view.do?page=" + page + "&ano=" + parent);
	}

		
	
}
