package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import Model.CustomerDAO;
import Model.MemberDAO;
import javazoom.jl.player.MP3Player;

public class ButtonController {
	Random ran = new Random();
	Scanner scan = new Scanner(System.in);
	MemberDAO mdao = new MemberDAO();
	StageController scon = new StageController();
	CustomerDAO cdao = new CustomerDAO();
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs = null;
	MP3Player mp3 = new MP3Player();

	public void stageStart() { // 스테이지 시작메소드 ( 60초 )

		mp3.play("Music/bgm.mp3");

		long startTime = System.currentTimeMillis();
		long endTime = startTime + TimeUnit.SECONDS.toMillis(60);
		int count = 0;
		while (System.currentTimeMillis() < endTime) {
			count++;
			System.out.println("¸¸♬·¯·♩¸¸♪·¯·♫¸¸¸♬·¯·♩¸¸♪·¯·♫¸¸¸¸¸♬··¯·♩¸¸♪·¯·♫¸¸¸¸¸♬");
			System.out.println("　　　　　　 ∧＿∧");
			System.out.println("　　　　　　（｡･ω･｡)つ━☆☆*");
			System.out.println("　　　　　　⊂　　 ノ 　　　☆☆");
			System.out.println("　　　　　　　し-Ｊ　　　°。+ * 。");
			System.out.println("　　　　　　　　　　　　　　" + count + "번째 손님 등장! ｡ﾟ");
			System.out.println("　　　　　　　　　　　　　　　　　ﾟ･｡･ﾟ");
			System.out.println("¸¸♬·¯·♩¸¸♪·¯·♫¸¸¸♬·¯·♩¸¸♪·¯·♫¸¸¸¸¸♬··¯·♩¸¸♪·¯·♫¸¸¸¸¸♬");
			System.out.println();
			System.out.println("                   ♫ 띵 동 ♪  ");
			mp3.play("Music/bell.mp3");
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
			System.out.println(cdao.cList().get(temp).getName() + " 님의 주문입니다.");
			System.out.println("        " + "•────[ 주문 목록 ] " + cdao.cList().get(temp).getHamburger() + "────•");
			System.out.println();
			System.out.println(" ⭑:༅｡.｡༅::✼✿ ──────현재 재료 목록────── ✿✼:*ﾟ:༅｡.｡༅:*･ﾟﾟ･⭑" + "\n");

			for (int j = 0; j < questionList.length; j++) {
				System.out.print("[" + (j) + "]" + questionList[j] + " ");
			}
			System.out.println();
			System.out.println();
			System.out.println("         ╔═══ 자, 그럼 햄버거를 한 번 만들어 볼까요?═══╗");
			System.out.print("☆⁺˚*♡⁺˚*☆ ☽⋅─────•[ 햄버거 제조 순서 ]≫≫ ");

			System.out.println();
			long remainingTime = endTime - System.currentTimeMillis();
			for (int j = 0; j < recipeList.length; j++) {
				for (int k = 0; k < recipeList.length; k++) { // question 배열과 answerL배열 값을 비교해 레시피 작성
					for (int l = 0; l < questionList.length; l++) {
						if (recipeList[k] == (char) (l + '0')) {
							System.out.print(questionList[l] + " ");
						}
					}
				}
				System.out.println("         재료 번호를 순서대로 클릭 해 주세요");
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
					System.out.println("          ʚ(*´꒳`*)ɞ ~♡ 정답! 다음 재료번호 입력해주세요!" + "");
					if (cdao.cList().get(temp).getDifficult().equals("EASY")) {
						scon.easyLine(j); // 햄버거 쌓이는 시각효과 메서드
					} else if (cdao.cList().get(temp).getDifficult().equals("NORMAL")) {
						scon.normalLine(j);
					} else if (cdao.cList().get(temp).getDifficult().equals("HARD")) {
						scon.hardLine(j);
					}

				} else {
					System.out.println("        ŏ̥̥̥̥םŏ̥̥̥̥ 잘못된 재료번호입니다. 손님이 화가나서 돌아갔어요 ŏ̥̥̥̥םŏ̥̥̥̥ ");
					System.out.println();
					System.out.println();
					break;
				}
				if (System.currentTimeMillis() > endTime) { // 지정한 시간을 넘어서 답을 쓴경우 타임아웃
					System.out.println("시간이 초과했어요 ŏ̥̥̥̥םŏ̥̥̥̥  손님이 집으로 돌아갔어요ŏ̥̥̥̥םŏ̥̥̥̥  ");
					break;
				}

			}
			break;

		}

	}

}
