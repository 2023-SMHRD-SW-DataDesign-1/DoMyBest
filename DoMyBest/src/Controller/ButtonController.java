package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import Model.CustomerDAO;
import Model.MemberDAO;

public class ButtonController {
	Random ran = new Random();
	Scanner scan = new Scanner(System.in);
	MemberDAO mdao = new MemberDAO();
	StageController scon = new StageController();
	CustomerDAO cdao = new CustomerDAO();
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs = null;



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
		long endTime = startTime + TimeUnit.SECONDS.toMillis(10);
		String questionList[] = { "빵", "양상추", "토마토", "마요네즈", "케첩", "불고기", "새우", "치킨", "치즈", "피클" };

		while (System.currentTimeMillis() < endTime) {

			int temp = ran.nextInt(cdao.cList().size());
			char recipeList[] = cdao.cList().get(temp).getRecipe().toCharArray(); // DB에 있는 recipe컬럼 값을 문자형 배열로 생성
			System.out.println(cdao.cList().get(temp).getHamburger() + "주세요");

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
					if (cdao.cList().get(temp).getDifficult().equals("EASY")) {
						scon.easyLine(j); // 햄버거 쌓이는 시각효과 메서드
					} else if (cdao.cList().get(temp).getDifficult().equals("NORMAL")) {
						scon.normalLine(j);
					} else if (cdao.cList().get(temp).getDifficult().equals("HARD")) {
						scon.hardLine(j);
					}

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
