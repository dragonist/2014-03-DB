package register;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.User;


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/home/user/register.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		String userName = request.getParameter("userName");
		String userMail = request.getParameter("userMail");
		
		User user = new User(userId, userPw, userName, userMail);
		
		RegisterDao registerDao = new RegisterDao();
		int updatedRows = registerDao.registerDao(user);
		RequestDispatcher rd;
		
		
		if(updatedRows > 0) {
			rd = request.getRequestDispatcher("/home/user/registerSuccess.jsp");
		} else {
			rd = request.getRequestDispatcher("/home/user/registerError.jsp");
		}
		
		rd.forward(request, response);
		
		
	}

}
