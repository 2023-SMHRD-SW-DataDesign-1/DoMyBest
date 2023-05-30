package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DAO.PhoneDTO;
import Model.CustomerDTO;
import Model.MemberDAO;

public class StageController {

	ArrayList<CustomerDTO> customList = new ArrayList<>();
	MemberDAO mdao = new MemberDAO();
	Connection conn;
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

	public StageController() {
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

				customList.add(new CustomerDTO(name, gender, hamburger, recipe));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<CustomerDTO> cList() {
		return customList;

	}

}
