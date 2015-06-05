package register;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import entity.User;

public class RegisterDao {

	public int registerDao(User user) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String address = "jdbc:mysql://192.168.56.102/NEWS";
		String id = "erin314";
		String pw = "1234";
		String sql = "INSERT INTO USER(ID, NAME, EMAIL, PWD) VALUES(?,?,?,?)";	
		int updatedRows = 0;
		
		
		try {	
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(address, id, pw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,user.getId());
			pstmt.setString(2,user.getName());
			pstmt.setString(3,user.getMail());
			pstmt.setString(4,user.getPw());
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

}
