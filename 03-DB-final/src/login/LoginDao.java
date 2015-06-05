package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.User;

public class LoginDao {

	public User loginDao(User user) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		User returnUser = null;
		
		String address = "jdbc:mysql://192.168.56.102/NEWS";
		String id = "erin314";
		String pw = "1234";
		String sql = "SELECT ID, NAME, EMAIL, PWD FROM USER WHERE ID=? AND PWD=?";	
		try {	
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(address, id, pw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,user.getId());
			pstmt.setString(2,user.getPw());
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				returnUser = new User(rs.getString("ID"), rs.getString("PWD"), 
						rs.getString("NAME"),rs.getString("EMAIL"));
	
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			if(pstmt != null) try { pstmt.close(); } catch (SQLException e) {}				
			if(conn != null) try { conn.close(); } catch (SQLException e) {}				
		}
				
		
		return returnUser;
	}

}
