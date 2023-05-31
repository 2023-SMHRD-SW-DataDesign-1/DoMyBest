package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedLongSynchronizer;

import Model.CustomerDTO;
import Model.MemberDAO;
import oracle.sql.CHAR;

public class ButtonController {
	Random ran = new Random();
	Scanner scan = new Scanner(System.in);
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
			if (conn != null)
				System.out.println("connect success");
			else
				System.out.println("connect fail");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ButtonController() { // 객체 생성과 동시에 customList에 값 추가할 생성자
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

	public void solveP() { // 문제 푸는 메소드
		long startTime = System.currentTimeMillis();
		long endTime = startTime + TimeUnit.SECONDS.toMillis(5);
		String questionList[] = { "빵", "양상추", "토마토", "마요네즈", "케첩", "불고기", "새우", "치킨", "치즈", "피클" };

		while (System.currentTimeMillis() < endTime) {

			int temp = ran.nextInt(customList.size());
			char recipeList[] = customList.get(temp).getRecipe().toCharArray(); // DB에 있는 recipe컬럼 값을 문자형 배열로 생성
			System.out.println(customList.get(temp).getHamburger() + "주세요");

			System.out.println();

			for (int j = 0; j < questionList.length; j++) {
				System.out.print("[" + (j) + "]" + questionList[j] + " ");
			}
			System.out.println();
			System.out.print("레시피 : ");

			for (int j = 0; j < recipeList.length; j++) { // question 배열과 answerL배열 값을 비교해 레시피 작성
				for (int k = 0; k < questionList.length; k++) {
					if (recipeList[j] == (char) (k + '0')) {
						System.out.print(questionList[k] + " ");
					}
				}
			}
			System.out.println();
			long remainingTime = endTime - System.currentTimeMillis();
			for (int j = 0; j < recipeList.length; j++) {
				Button bt = new Button();
				if (remainingTime > 0) {
					synchronized (bt) {
						try {
							bt.wait(endTime - System.currentTimeMillis());
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				} else {
					break;
				}
				if (recipeList[j] == bt.answerGet()) {
					System.out.println("정답");

				} else {
					System.out.println("오답");
					break;
				}
				if (System.currentTimeMillis() > endTime) { // 지정한 시간을 넘어서 답을 쓴경우 타임아웃
					System.out.println("타임아웃");
					break;
				}

			}
			break;

		}

	}

}
