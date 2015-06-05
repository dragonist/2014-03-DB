package news;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import entity.Comment;
import entity.News;

public class NewsDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	String address = "jdbc:mysql://192.168.56.102/NEWS";
	String id = "erin314";
	String pw = "1234";
	
	public int makeNews(News news) {
		
		
		String sql = "INSERT INTO NEWS(TITLE, COMPANY, CONTENT, USER_ID) VALUES(?,?,?,?)";	
		int updatedRows = 0;    
		
		try {	
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(address, id, pw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,news.getTitle());
			pstmt.setString(2,news.getCompany());
			pstmt.setString(3,news.getContent());
			pstmt.setString(4,news.getUserId());
			System.out.println("pstmt: "+pstmt); 
			
			updatedRows = pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			if(pstmt != null) try { pstmt.close(); } catch (SQLException e) {}				
			if(conn != null) try { conn.close(); } catch (SQLException e) {}				
		}
		
		return updatedRows;
	}

	public List<News> updateNews() {
		ResultSet rs = null;		
		String sql = "SELECT * FROM NEWS";

		List<News>newsList = new LinkedList<News>();
		try {

			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(address, id, pw);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				newsList.add(new News(rs.getInt(1),rs.getString(2),rs.getString(3),
									rs.getString(4),rs.getString(5),rs.getString(6)));
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			if(pstmt != null) try { pstmt.close(); } catch (SQLException e) {}				
			if(conn != null) try { conn.close(); } catch (SQLException e) {}				
		}
		
		return newsList;
	}
	public News getNews(String newsId) {
		ResultSet rs = null;		
		News news = null;
		String sql = "SELECT * FROM NEWS WHERE NEWS_ID =?";
		try {	

			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(address, id, pw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(newsId));
			rs = pstmt.executeQuery();
			while(rs.next()){
				news = new News(rs.getInt(1),rs.getString(2),rs.getString(3),
									rs.getString(4),rs.getString(5),rs.getString(6));
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			if(pstmt != null) try { pstmt.close(); } catch (SQLException e) {}				
			if(conn != null) try { conn.close(); } catch (SQLException e) {}				
		}
		
		return news;
	}

	public List<Comment> getComment(String newsId) {
		ResultSet rs = null;		
		List<Comment> commentList = new LinkedList<Comment>();
		String sql = "SELECT * FROM COMMENT WHERE NEWS_ID=?";
		try {	
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(address, id, pw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(newsId));
			rs = pstmt.executeQuery();
			
			
			while(rs.next()){
				commentList.add(new Comment(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4),rs.getInt(5), rs.getInt(6)));
			}
//			System.out.println(commentList.get(0)+">>>>>>");
			
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			if(pstmt != null) try { pstmt.close(); } catch (SQLException e) {}				
			if(conn != null) try { conn.close(); } catch (SQLException e) {}				
		}
		
		return commentList;
	}

	public int makeNewsComment(Comment comment) {

		
		String sql = "INSERT INTO COMMENT(CONTENT, USER_ID, NEWS_ID, PARENT_ID) VALUES(?,?,?,1)";	
		int updatedRows = 0;    
		
		try {	
			

			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(address, id, pw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,comment.getContent());
			pstmt.setString(2,comment.getUserId());
			pstmt.setInt(3,comment.getNewsId());
			
			updatedRows = pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			if(pstmt != null) try { pstmt.close(); } catch (SQLException e) {}				
			if(conn != null) try { conn.close(); } catch (SQLException e) {}				
		}
		
		return updatedRows;
	
	}

}
