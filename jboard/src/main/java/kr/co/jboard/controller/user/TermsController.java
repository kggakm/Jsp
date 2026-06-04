package kr.co.jboard.controller.user;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.co.jboard.dto.TermsDTO;
import kr.co.jboard.service.TermsService;
import kr.co.jboard.service.UserService;

@WebServlet("/user/terms.do")
public class TermsController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	// 서비스 가져오기(열거상수 객체)
	private TermsService service = TermsService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 약관 데이터 가져오기
		TermsDTO termsDTO = service.findById(1);
		
		// Request 공유 참조
		req.setAttribute("termsDTO", termsDTO);
		
		// View 포워드
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/user/terms.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
	

}