package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDAO {
	Connection conn = null;
	PreparedStatement psmt;
	ResultSet rs = null;

	public void getConn() {
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			String dburl = "jdbc:oracle:thin:@project-db-stu.smhrd.com:1524:xe";
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

	public void insertMember(MemberDTO dto) {
		getConn();
		String sql = "insert into MEMBER(id, pw, name) values(?,?,?)";
		int row = 0;

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getPw());
			psmt.setString(3, dto.getName());

			row = psmt.executeUpdate();

			if (row > 0) {
				System.out.println("성공");
			} else {
				System.out.println("실패");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			allClose();
		}

	}

	private void allClose() {
		try {
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
			if (rs != null)
				rs.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

}
