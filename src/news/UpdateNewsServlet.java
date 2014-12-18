package news;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.News;

/**
 * Servlet implementation class updateNewsServlet
 */
@WebServlet("/UpdateNewsServlet")

public class UpdateNewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		NewsDao newsDao = new NewsDao();
		List<News> newsList = newsDao.updateNews();
//		System.out.print(newsList);
		newsList.remove(0);
		
		request.setAttribute("newsList",newsList);
		
		RequestDispatcher rd = request.getRequestDispatcher("/home/index.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
