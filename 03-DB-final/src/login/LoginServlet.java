package login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.User;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/home/user/login.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String loginId = request.getParameter("loginId");
		String loginPw = request.getParameter("loginPw");
		
		User user = new User(loginId,loginPw);
		LoginDao dao = new LoginDao();
		User returnUser = dao.loginDao(user);
		
		if(returnUser !=null){
			HttpSession session = request.getSession();
			session.setAttribute("loginUser",returnUser);
			RequestDispatcher rd = request.getRequestDispatcher("/home/user/loginSuccess.jsp");
			rd.forward(request,response);
			
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/home/user/loginError.jsp");
			rd.forward(request, response);
		}
	}

}
