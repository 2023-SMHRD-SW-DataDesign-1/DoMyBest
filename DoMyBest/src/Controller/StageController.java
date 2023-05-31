package Controller;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import Model.CustomerDAO;

public class StageController {

	Random ran = new Random();
	Scanner scan = new Scanner(System.in);

	CustomerDAO cdao = new CustomerDAO();

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
		long endTime = startTime + TimeUnit.SECONDS.toMillis(10); // 시간제한 5초
		String questionList[] = { "빵", "양상추", "토마토", "마요네즈", "케첩", "불고기", "새우", "치킨", "치즈", "피클" };
		ArrayList<Integer> answerList = new ArrayList<>();

//		String answer = null;
		while (System.currentTimeMillis() < endTime) {

			int temp = ran.nextInt(24); // 손님(24)명중에 랜덤뽑기 customList.size로 변경해도 될듯?
			char recipeList[] = cdao.cList().get(temp).getRecipe().toCharArray(); // DB에 있는 recipe컬럼 값을 문자형 배열로 생성
			System.out.println(cdao.cList().get(temp).getHamburger() + "주세요");
			System.out.print("레시피 : ");

			for (int i = 0; i < recipeList.length; i++) { // question 배열과 answerL배열 값을 비교해 레시피 작성
				for (int j = 0; j < questionList.length; j++) {
					if (recipeList[i] == (char) (j + '0')) {
						System.out.print(questionList[j] + " ");
					}
				}
			}
			System.out.println();
			for (int i = 0; i < questionList.length; i++) {
				System.out.print("[" + (i) + "]" + questionList[i] + " ");
			}
			System.out.println();
//////////////////////////////////답안 분리 로직//////////////////////////////////////////////////////
			for (int i = 0; i < recipeList.length; i++) {
				answerList.add(scan.nextInt());
				if ((char) (answerList.get(i) + '0') == recipeList[i]) {
					System.out.println("정답");
					// 아스키아트 메서드 불러올 곳

				} else {
					System.out.println("오답");
					break;
				}
				if (System.currentTimeMillis() > endTime) { // 지정한 시간을 넘어서 답을 쓴경우 타임아웃
					System.out.println("타임아웃");
					break;
				}
			}
/////////////////////////////////////////////////////////////////////////////////////////////////////////			

//////////////////////////한줄 답안 로직////////////////////////////////////////
//			answer = scan.next();

//			if (answer.equals(customList.get(temp).getRecipe())) {
//				System.out.println("정답");
//			} else {
//				System.out.println("오답");
//			}
//			if (!answer.equals(null)) { 
//				break;
//			}
//////////////////////////////////////////////////////////////////////////////////
		}

	}

}
