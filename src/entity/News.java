package entity;

import java.util.List;

public class News {
	
	private int newsId;
	private String title;
	private String company;
	private String date;
	private String content;
	private String userId;
	private int hasComment; // 있으면 11 없으면 10 
	private List<Comment> commentList = null;
	
	
	public News(String title, String company, String content, String userId) {
		this.title = title;
		this.company = company;
		this.content = content;
		this.userId = userId;
	}


	public News(int newsId, String title, String company, String date,
			String content, String userId) {
		this.newsId = newsId;
		this.title = title;
		this.company = company;
		this.date = date;
		this.content = content;
		this.userId = userId;
	}

	public void addComment(List commentList){
		this.commentList = commentList;
	}

	public int getNewsId() {
		return newsId;
	}


	public String getTitle() {
		return title;
	}


	public String getCompany() {
		return company;
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
}
