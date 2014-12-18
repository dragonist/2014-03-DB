package news;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Comment;
import entity.User;


@WebServlet("/MakeNewsCommentServlet")
public class MakeNewsCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session= request.getSession();
		User user = (User)session.getAttribute("loginUser");
		String commentUser = user.getId();
		
		String commentContent = request.getParameter("content");
		String commentNewsIdString = request.getParameter("newsId");
		int commentNewsId = Integer.parseInt(commentNewsIdString);
		
		Comment comment = new Comment(commentUser, commentContent, commentNewsId);
		
		System.out.print(comment);
		NewsDao newsDao = new NewsDao();
		int updatedRows = newsDao.makeNewsComment(comment);
		
		if(updatedRows > 0) {
			response.sendRedirect("/UpdateCommentServlet?newsId="+commentNewsIdString);
		} else {
			response.sendRedirect("/home/news/makeNewsError.jsp");
		}
		
	
	}

}
