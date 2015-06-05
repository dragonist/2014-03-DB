package news;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.News;
import entity.User;

/**
 * Servlet implementation class MakeCommentServlet
 */
@WebServlet("/MakeCommentCommentServlet")
public class MakeCommentCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session= request.getSession();
		User user = (User)session.getAttribute("loginUser");
		String newsUser = user.getId();
		
		String newsTitle = request.getParameter("newsTitle");
		String newsCompany = request.getParameter("newsCompany");
		String newsContent = request.getParameter("newsContent");
		
		News news = new News(newsTitle, newsCompany, newsContent, newsUser);
		
		NewsDao newsDao = new NewsDao();
		int updatedRows = newsDao.makeNews(news);
		RequestDispatcher rd;
		
		
		if(updatedRows > 0) {
			rd = request.getRequestDispatcher("/home/news/makeNewsSuccess.jsp");
		} else {
			rd = request.getRequestDispatcher("/home/news/makeNewsError.jsp");
		}
		
		rd.forward(request, response);
	
	}

}
