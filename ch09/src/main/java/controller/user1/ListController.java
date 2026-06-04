package controller.user1;

import java.io.IOException;
import java.util.List;

import dto.User1DTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.User1Service;

@WebServlet("/user1/list.do")
public class ListController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	// Service 가져오기
	private User1Service service = User1Service.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String mode = req.getParameter("mode");
		
		System.out.println(mode);
		
		// User1 데이터 요청
		List<User1DTO> dtoList = service.findAll();
		System.out.println(dtoList);
		
		if(mode == null) {
			
			// View 데이터 참조(Controller에서 View로 forward 하기 때문에 Controller와 View는 같은 Request Scope를 가짐)
			req.setAttribute("dtoList", dtoList);
			
			// View forward
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/user1/list.jsp");
			dispatcher.forward(req, resp);
		}
	}

}
