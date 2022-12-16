package board.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

/**
 * db.properties파일의 내용으로 DB정보를 설정하는 방법
 * 방법1) Properties 객체 이용하기 
 */
public class JDBCUtil3 {
	
	static ResourceBundle bundle; // 객체 변수 선언

	
	
	// 클래스 호출시 딱 1번만 실행됨
	static {
		
		bundle = ResourceBundle.getBundle("db"); // 객체 생성
		
		try {
			Class.forName(bundle.getString("driver"));
//			System.out.println("드라이버 로딩 성공!");
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패!!!");
			e.printStackTrace();
		}
		
	}
	
	
	public static Connection getConnection() {
		
		try {
			return DriverManager.getConnection(
					bundle.getString("url"), 
					bundle.getString("username"), 
					bundle.getString("password"));
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 자원반납
	 * @param conn
	 * @param pstmt
	 * @param stmt
	 * @param rs
	 */
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
