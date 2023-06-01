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
	int money = 0;
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
		int score = 0;
		mp3.play("C:/Users/smhrd/git/DoMyBest/DoMyBest/Music/bgm.mp3");

		long startTime = System.currentTimeMillis();
		long endTime = startTime + TimeUnit.SECONDS.toMillis(20);
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
			mp3.play("C:/Users/smhrd/git/DoMyBest/DoMyBest/Music/bell.mp3");
			score = solveP();

		}
		mp3.play("C:/Users/smhrd/git/DoMyBest/DoMyBest/Music/clear.mp3");

		System.out.println("\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n"
				+ "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n");
		System.out.println("                                 토닥토닥");
		System.out.println("                                (\\__/)");
		System.out.println("                               （｀•.• )づ__/)");
		System.out.println("                               （つ　 /( •.• )");
		System.out.println("                                 しーＪ (nnノ)");
		System.out.println("                    오늘도 열심히 버거를 만드느라 고생했어요!");
		System.out.println();
		System.out.println(
				"\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n");

		timeSleep(3000);

		while (true) {
			System.out.println("\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n"
					+ "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n");
			System.out.println(". ʕ⑅˶>⤙<˶ʔ");
			System.out.println("ପ(  づ  づ )ଓ(최고!)");
			System.out.println();
			System.out.println("╓═════ 랭킹을 등록하시겠어요?═════╖");
			System.out.println("     [1] 등록   [2] 등록안함");
			System.out.print("     번호를 입력해주세요 >>>");
			int num = scan.nextInt();
			if (num == 1) {
				System.out.print(" ･ﾟ✧*:･ﾟ✧ 아이디를 입력해주세요 >> ");
				String id = scan.next();
				mdao.rankingInsert(id, score);
				break;
			} else if (num == 2) {
				System.out.println("( ‘ o ‘ ) 등록을 하지 않습니다. 초기화면으로 돌아갑니다");
				break;
			} else {
				System.out.println("(❛⌓❛ ) 잘못된 입력입니다. 다시 입력해주세요 ");
			}
		}

		timeSleep(2000);

		System.out.println("\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n"
				+ "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n");
		if (mp3.isPlaying()) {
			mp3.stop(); // plyaing이 true면 재생중인 곡 정지
		}

	}

	public int solveP() { // 문제 푸는 메소드

		long startTime = System.currentTimeMillis();
		long endTime = startTime + TimeUnit.SECONDS.toMillis(12);
		long endTime2 = startTime + TimeUnit.SECONDS.toMillis(10);
		String questionList[] = { "빵", "양상추", "토마토", "마요네즈", "케첩", "불고기", "새우", "치킨", "치즈", "피클" };

		while (System.currentTimeMillis() < endTime) {

			int temp = ran.nextInt(cdao.cList().size());
			char recipeList[] = cdao.cList().get(temp).getRecipe().toCharArray(); // DB에 있는 recipe컬럼 값을 문자형 배열로 생성
			System.out.println("────────✧ " + cdao.cList().get(temp).getName() + " 님의 주문 ✧───────────────────────");
			System.out.println("         " + "•──────[  " + cdao.cList().get(temp).getHamburger() + "  ]──────•");
			System.out.println();
			System.out.println("       ╔═════ 현재 JAVA BURGER 재료 목록 ═════╗");

			for (int l = 0; l < questionList.length; l++) {
				if (l == 5) {
					System.out.print("[" + (l) + "]" + questionList[l] + "  ");
				} else {
					System.out.print("[" + (l) + "]" + questionList[l] + "\t" + "  ");
				}
				if (l == 4) {
					System.out.println();
				}
			}

			long remainingTime = endTime - System.currentTimeMillis();
			for (int j = 0; j < recipeList.length; j++) {
				System.out.println();
				System.out.println();
				System.out.println("☆⁺˚*♡⁺˚*☆ ☽⋅─────•[ 햄버거 제조 순서 ]────☆⁺˚*♡⁺˚*☆─ ");
				System.out.println("--------------------------------------------------------------");
				System.out.print("      ");
				for (int k = 0; k < recipeList.length; k++) { // question 배열과 answerL배열 값을 비교해 레시피 작성
					for (int l = 0; l < questionList.length; l++) {
						if (recipeList[k] == (char) (l + '0')) {
							System.out.print(questionList[l] + " ☞ ");
						}
					}
				}
				System.out.println();
				System.out.println("--------------------------------------------------------------");
				System.out.println("         재료 번호를 순서대로 클릭 해 주세요" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n"
						+ "\n" + "\n" + "\n");
				if (System.currentTimeMillis() > endTime2) { // 지정한 시간을 넘어서 답을 쓴경우 타임아웃
					System.out.println("\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n"
							+ "\n" + "\n" + "\n" + "\n" + "                  시간이 초과했어요. 손님이 집으로 돌아갔어요   ŏ̥̥̥̥םŏ̥̥̥̥  "
							+ "\n" + "                      ∧＿∧" + "\n" + "                    ( ´ •̥̥̥ ω •̥̥̥ )  ❀"
							+ "\n" + "                  ,, ( ヽ∩∩ ) ,, ヽ|〃 ,,," + "\n" + "\n" + "\n" + "\n" + "\n" + "\n"
							+ "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n");
					timeSleep(2000);
					break;
				}
				Button bt = new Button();
				if (remainingTime > 0) {
					synchronized (bt) {
						try {
							bt.wait(endTime - System.currentTimeMillis());
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					mp3.play("C:/Users/smhrd/git/DoMyBest/DoMyBest/Music/chap.mp3");
//					mp3.play("C:/Users/sh/git/DoMyBest/DoMyBest/Music/chap.mp3"); // 수환 개인컴퓨터용
				} else {
					break;
				}
				if (recipeList[j] == bt.answerGet()) {
					System.out.println("          ʚ(*´꒳`*)ɞ ~♡ 정답! 다음 재료번호 입력해주세요!" + "");
					System.out
							.println("\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n"+ "\n" + "\n" + "\n" + "\n" + "\n"+ "\n" + "\n"+ "\n" + "\n" + "\n" + "\n" + "\n");
					if (cdao.cList().get(temp).getDifficult().equals("EASY")) {
						scon.easyLine(j); // 햄버거 쌓이는 시각효과 메서드
					} else if (cdao.cList().get(temp).getDifficult().equals("NORMAL")) {
						scon.normalLine(j);
					} else if (cdao.cList().get(temp).getDifficult().equals("HARD")) {
						scon.hardLine(j);
					}

				} else {
					System.out.println("\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n"
							+ "\n" + "\n" + "\n" + "\n" + "           햄버거 순서가 잘못됐어요. 손님이 집으로 돌아갔어요   ŏ̥̥̥̥םŏ̥̥̥̥  "
							+ "\n" + "                      ∧＿∧" + "\n" + "                    ( ´ •̥̥̥ ω •̥̥̥ )  ❀"
							+ "\n" + "                  ,, ( ヽ∩∩ ) ,, ヽ|〃 ,,," + "\n" + "\n" + "\n" + "\n" + "\n" + "\n"
							+ "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n");
					System.out.println();
					System.out.println();
					timeSleep(2000);
					break;
				}

				if (j == (recipeList.length - 1)) {

					if (cdao.cList().get(temp).getDifficult().equals("EASY")) {
						money += 10;
					} else if (cdao.cList().get(temp).getDifficult().equals("NORMAL")) {
						money += 15;
					} else if (cdao.cList().get(temp).getDifficult().equals("HARD")) {
						money += 20;
					}
					mp3.play("C:/Users/smhrd/git/DoMyBest/DoMyBest/Music/success.mp3");
					System.out.println("\n"+"\n"+"\n"+"                 ＊ ( ・´з`・)／성공 ~ 맛있는 버거가 만들어졌어요! " + "\n" + "\n"
							+ "                        냠냠 너무 맛있을 것 같아요~" + "\n" + "\n"
							+ "                               매출 : " + money + "$" + "\n" + "\n" + "\n" + "\n" + "\n"
							+ "\n" + "\n" + "\n" );
					timeSleep(2000);
				}

			}
			break;

		}
		return money;

	}

	public void timeSleep(int n) {
		try {
			Thread.sleep(n); // 1000 = 1초
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
