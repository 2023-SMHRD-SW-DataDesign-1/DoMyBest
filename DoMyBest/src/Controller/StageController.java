package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import DAO.PhoneDTO;
import Model.CustomerDTO;
import Model.MemberDAO;

public class StageController {

	Random ran = new Random();
	Scanner scan = new Scanner(System.in);
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

	public void stageStart() {

//		ArrayList<Integer> answerList = new ArrayList<>();
		long startTime = System.currentTimeMillis();
		long endTime = startTime + TimeUnit.SECONDS.toMillis(60);
		int count = 0;
		while (System.currentTimeMillis() < endTime) {
			count++;
			System.out.println(count + " 번 손님");
			solveP();

		}

	}

	public void solveP() {
		long startTime = System.currentTimeMillis();
		long endTime = startTime + TimeUnit.SECONDS.toMillis(5);
		String answerL[] = { "빵", "양상추", "토마토", "마요네즈", "케첩", "불고기", "새우", "치킨", "치즈", "피클" };
		String answer = null;
		while (System.currentTimeMillis() < endTime) {

			int temp = ran.nextInt(24);
			char question[] = customList.get(temp).getRecipe().toCharArray();
			System.out.println(customList.get(temp).getHamburger() + "주세요");

			System.out.print("레시피 : ");
			for (int i = 0; i < question.length; i++) {
				for (int j = 0; j < answerL.length; j++) {
					if (question[i] == (char) (j + '0')) {
						System.out.print(answerL[j] + " ");
					}
				}
			}
			System.out.println();
			for (int i = 0; i < answerL.length; i++) {
				System.out.print("[" + (i) + "]" + answerL[i] + " ");
			}

			answer = scan.next();
			if (System.currentTimeMillis() > endTime) {
				System.out.println("타임아웃");
				break;
			}
			if (answer.equals(customList.get(temp).getRecipe())) {
				System.out.println("정답");
			} else {
				System.out.println("오답");
			}
			if (!answer.equals(null)) {
				break;
			}

		}

	}

}
