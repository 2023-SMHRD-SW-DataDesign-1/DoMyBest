package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CustomerDAO {

	ArrayList<CustomerDTO> customList = new ArrayList<>();
	MemberDAO mdao = new MemberDAO();
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs = null;

	public void getConn() { // JDBC 연결메소드
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String dburl = "jdbc:oracle:thin:@project-db-stu.smhrd.com:1524:xe";
			String dbuser = "campus_g_0530_1";
			String dbpw = "smhrd1";

			conn = DriverManager.getConnection(dburl, dbuser, dbpw);
			if (conn != null) {
//				System.out.println("connect success");
			} else {
//				System.out.println("connect fail");				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public CustomerDAO() { // 객체 생성과 동시에 customList에 값 추가할 생성자
		getConn();
		try {
			String sql = "select * from customer";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				String name = rs.getString(1);
				String gender = rs.getString(2);
				String hamburger = rs.getString(3);
				String recipe = rs.getString(4);
				String difficult = rs.getString(5);

				customList.add(new CustomerDTO(name, gender, hamburger, recipe, difficult));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<CustomerDTO> cList() {
		return customList;

	}

}
