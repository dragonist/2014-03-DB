package entity;

public class User {
	
	private String Id;
	private String Pw;
	private String Name;
	private String Mail;
	
	

	public String getId() {
		return Id;
	}



	public String getPw() {
		return Pw;
	}



	public String getName() {
		return Name;
	}



	public String getMail() {
		return Mail;
	}



	public User(String id, String pw, String name, String mail) {
		Id = id;
		Pw = pw;
		Name = name;
		Mail = mail;
	}

	public User(String loginId, String loginPw) {
		Id = loginId;
		Pw = loginPw;
	}
	
}
