package news;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Comment;
import entity.News;

@WebServlet("/UpdateCommentServlet")
public class UpdateCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String newsId = request.getParameter("newsId");
		NewsDao newsDao = new NewsDao();
		News news = newsDao.getNews(newsId);
		List<Comment> commentList = newsDao.getComment(newsId);
		
//		System.out.print(commentList.get(0));
		request.setAttribute("news", news);
		request.setAttribute("commentList",commentList);
		
		RequestDispatcher rd = request.getRequestDispatcher("/home/news/showNews.jsp");
		rd.forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


}
