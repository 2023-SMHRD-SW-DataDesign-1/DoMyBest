package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

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

	public void getConn() {  // JDBC 연결메소드
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

	public StageController() {  // 객체 생성과 동시에 customList에 값 추가할 생성자
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

	public void stageStart() { // 스테이지 시작메소드 ( 60초 )

		long startTime = System.currentTimeMillis();
		long endTime = startTime + TimeUnit.SECONDS.toMillis(60);
		int count = 0;
		while (System.currentTimeMillis() < endTime) {
			count++;
			System.out.println(count + " 번 손님");
			solveP();

		}

	}

	public void solveP() {  // 문제 푸는 메소드
		long startTime = System.currentTimeMillis();
		long endTime = startTime + TimeUnit.SECONDS.toMillis(10);   // 시간제한 5초
		String answerL[] = { "빵", "양상추", "토마토", "마요네즈", "케첩", "불고기", "새우", "치킨", "치즈", "피클" }; 
		String answer = null;
		while (System.currentTimeMillis() < endTime) {

			int temp = ran.nextInt(24);    // 손님(24)명중에 랜덤뽑기     customList.size로 변경해도 될듯?
			char question[] = customList.get(temp).getRecipe().toCharArray();   // DB에 있는 recipe컬럼 값을 문자형 배열로 생성
			System.out.println(customList.get(temp).getHamburger() + "주세요");
			System.out.print("레시피 : ");
			
			for (int i = 0; i < question.length; i++) {  // question 배열과 answerL배열 값을 비교해 레시피 작성
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
			if (System.currentTimeMillis() > endTime) {  // 지정한 시간을 넘어서 답을 쓴경우 타임아웃
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
