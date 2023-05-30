package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class MemberDAO {
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs = null;

	private void getConn() {
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			String dburl = "jdbc:oracle:thin:@localhost:1521:xe";
			String dbuser = "campus_g_0530_1";
			String dbpw = "smhrd1";

			conn = DriverManager.getConnection(dburl, dbuser, dbpw);
			if (conn != null)
				System.out.println("connect success");
			else
				System.out.println("connect fail");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int insertMember(String id, String pw, String name) {
		getConn();
		String sql = "insert into MEMBER values(?,?,?)";
		int cnt = 0;

		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, name);
			pst.setString(2, pw);
			pst.setString(3, name);

			cnt = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			allClose();
		}
		return cnt;

	}

	
	
	
	
	
	private void allClose() {
		try {
			if (pst != null)
				pst.close();
			if (conn != null)
				conn.close();
			if (rs != null)
				rs.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

}
