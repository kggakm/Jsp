package controller.user1;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

@WebServlet("/user/list.do")
public class ListController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	// Service 가져오기
	private User1Service service = User1Service.getInstance();

}
