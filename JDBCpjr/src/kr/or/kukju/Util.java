package kr.or.kukju;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Util {
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("DB에 연결되었습니다.");
		}catch(ClassNotFoundException e) {
			System.out.println("DB연결에 실패했습니다.");
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String name = "LKJ";
		String password = "java";
		
		try {
			return DriverManager.getConnection(url, name, password);
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void close(Connection conn,
							 PreparedStatement pstmt,
							 Statement stmt,
							 ResultSet rs) {
		
		if (rs != null)
			try {
				rs.close();
			} catch (SQLException ex) {
			}
		if (stmt != null)
			try {
				stmt.close();
			} catch (SQLException ex) {
			}
		if (pstmt != null)
			try {
				pstmt.close();
			} catch (SQLException ex) {
			}
		if (conn != null)
			try {
				conn.close();
			} catch (SQLException ex) {
			}
		
	}
}
