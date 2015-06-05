package entity;

import java.util.List;

public class Comment {


	private int commentId;
	private String date;
	private String content;
	private String userId;
	private int newsId;
	private int parentId;
	private int hasChild; 	//있으면 11 없으면 10 
	private List<Comment> commentList = null;
	
//	 COMMENT_ID | int(11)     | NO   | PRI | NULL              | auto_increment              |
//	 | DATE       | timestamp   | NO   |     | CURRENT_TIMESTAMP | on update CURRENT_TIMESTAMP |
//	 | CONTENT    | text        | YES  |     | NULL              |                             |
//	 | USER_ID    | varchar(45) | NO   | MUL | NULL              |                             |
//	 | NEWS_ID    | int(11)     | NO   | MUL | NULL              |                             |
//	 | PARENT_ID  
//	public Comment(int commentId, String date, String content,
//			String userId, String news) {
//		super();
//		this.commentId = commentId;
//		this.hasChild = hasChild;
//		this.date = date;
//		this.content = content;
//		this.userId = userId;
//	}
	


	public Comment(String userId, String content, int newsId) {

		this.userId = userId;
		this.content = content;
		this.newsId = newsId;
	
	}


	
	public Comment(int commentId, String date, String content, String userId,
			int newsId, int parentId) {
		super();
		this.commentId = commentId;
		this.date = date;
		this.content = content;
		this.userId = userId;
		this.newsId = newsId;
		this.parentId = parentId;
		
	}



	public int getCommentId() {
		return commentId;
	}
	
	
	
	public String getDate() {
		return date;
	}
	
	
	
	public String getContent() {
		return content;
	}
	
	
	
	public String getUserId() {
		return userId;
	}
	
	
	
	public int getNewsId() {
		return newsId;
	}
	
	
	
	public int getParentId() {
		return parentId;
	}
	
	
	
	public int getHasChild() {
		return hasChild;
	}
	
	
	
	public List<Comment> getCommentList() {
		return commentList;
	}



	@Override
	public String toString() {
		return "Comment [content=" + content + ", userId=" + userId
				+ ", newsId=" + newsId + "]";
	}
	
	
	
	

}
