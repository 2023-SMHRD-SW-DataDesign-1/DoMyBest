package Controller;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import Model.CustomerDAO;
import javazoom.jl.player.MP3Player;

public class StageController {

	Random ran = new Random();
	Scanner scan = new Scanner(System.in);
	CustomerDAO cdao = new CustomerDAO();
	MP3Player mp3 = new MP3Player();

	public void stageStart() { // 스테이지 시작메소드 ( 60초 )

//		mp3.play("C:/Users/smhrd/git/DoMyBest/DoMyBest/Music/bgm.mp3");
//		mp3.play("C:/Users/sh/git/DoMyBest/DoMyBest/Music/bgm.mp3"); // 수환 개인컴퓨터용

		long startTime = System.currentTimeMillis();
		long endTime = startTime + TimeUnit.SECONDS.toMillis(60);
		int count = 0;
		while (System.currentTimeMillis() < endTime) {
			count++;
			System.out.println("¸¸♬·¯·♩¸¸♪·¯·♫¸¸¸♬·¯·♩¸¸♪·¯·♫¸¸¸¸¸♬··¯·♩¸¸♪·¯·♫¸¸¸¸¸♬");
			System.out.println(" 　　　　　　∧＿∧");
			System.out.println("　　　　　 （｡･ω･｡)つ━☆☆* 띵 ~ 동 ♪ ");
			System.out.println("　　　　　　⊂　　 ノ 　　 　☆☆");
			System.out.println("　　　　　　　し-Ｊ　　   °。 * 。");
			System.out.println("　　　　　　　　　    " + count + "번째 손님 등장!ﾟ");
			System.out.println("　　　　　　　　　　　　　　  ﾟ･｡･ﾟ");
			System.out.println("¸¸♬·¯·♩¸¸♪·¯·♫¸¸¸♬·¯·♩¸¸♪·¯·♫¸¸¸¸¸♬··¯·♩¸¸♪·¯·♫¸¸¸¸¸♬");
			System.out.println();
//			mp3.play("C:/Users/smhrd/git/DoMyBest/DoMyBest/Music/bell.mp3");
//			mp3.play("C:/Users/sh/git/DoMyBest/DoMyBest/Music/bell.mp3"); // 수환 개인컴퓨터용
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

			int temp = ran.nextInt(cdao.cList().size()); // DB 손님리스트 랜덤뽑기
			char recipeList[] = cdao.cList().get(temp).getRecipe().toCharArray(); // DB에 있는 recipe컬럼 값을 문자형 배열로 생성
			System.out.println("────────✧ " + cdao.cList().get(temp).getName() + " 님의 주문 ✧───────────────────────");
			System.out.println("         " + "•──────[  " + cdao.cList().get(temp).getHamburger() + "  ]──────•");
			System.out.println();
			System.out.println("       ╔═════ 현재 JAVA BURGER 재료 목록 ═════╗");
//////////////////////////////////답안 분리 로직//////////////////////////////////////////////////////
			for (int i = 0; i < recipeList.length; i++) {
				//
//				System.out.println(" ✎✎✎﹏﹏﹏﹏재료를 활용해 햄버거를 만들어 봐요!﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏﹏");
				System.out.println();
//				for (int l = 0; l < questionList.length; l++) {
//					if (l == 3) {
//						System.out.print("[" + (l) + "]" + questionList[l] + " ");
//					} else if (l == 8) {
//						System.out.print("[" + (l) + "]" + questionList[l] + "\t" + "  ");
//					} else {
//						System.out.print("[" + (l) + "]" + questionList[l] + "\t");
//						if (l == 4) {
//							System.out.println();
//						}
//					}
//				}

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

				System.out.println();
				//
				//
				System.out.println();
				System.out.println("☆⁺˚*♡⁺˚*☆ ☽⋅─────•[ 햄버거 제조 순서 ]────☆⁺˚*♡⁺˚*☆─ ");
				System.out.println("--------------------------------------------------------------");
				System.out.print("      ");
				for (int j = 0; j < recipeList.length; j++) { // question 배열과 answerL배열 값을 비교해 레시피 작성
					for (int k = 0; k < questionList.length; k++) {
						if (recipeList[j] == (char) (k + '0')) {
							System.out.print(questionList[k] + " ☞ ");
						}
					}
				}
				System.out.println();
				System.out.println("--------------------------------------------------------------");
				System.out.println();
				//
				System.out.println();
				System.out.print("    재료 번호를 순서대로 하나씩만 입력 후 엔터를 눌러주세요 >>");
				answerList.add(scan.nextInt());
				if ((char) (answerList.get(i) + '0') == recipeList[i]) {
					System.out.println("          ʚ(*´꒳`*)ɞ ~♡ 정답! 다음 재료번호 입력해주세요!" + "");
					System.out
							.println("\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n");
//					mp3.play("C:/Users/smhrd/git/DoMyBest/DoMyBest/Music/chap.mp3");
//					mp3.play("C:/Users/sh/git/DoMyBest/DoMyBest/Music/chap.mp3"); // 수환 개인컴퓨터용
					if (cdao.cList().get(temp).getDifficult().equals("EASY")) {
						easyLine(i); // 햄버거 쌓이는 시각효과 메서드
					} else if (cdao.cList().get(temp).getDifficult().equals("NORMAL")) {
						normalLine(i);
					} else if (cdao.cList().get(temp).getDifficult().equals("HARD")) {
						hardLine(i);
					}
					if (i == (recipeList.length - 1)) {
						System.out.println("성공!" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n");
						timeSleep(2000);
					}
				} else {
					System.out.println("\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n"
							+ "\n" + "\n" + "\n" + "\n" + "        ŏ̥̥̥̥םŏ̥̥̥̥ 잘못된 재료번호입니다. 손님이 화가나서 돌아갔어요 ŏ̥̥̥̥םŏ̥̥̥̥ "
							+ "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n"
							+ "\n" + "\n" + "\n");
					System.out.println();
					System.out.println();
					timeSleep(2000);
					break;
				}
				if (System.currentTimeMillis() > endTime) { // 지정한 시간을 넘어서 답을 쓴경우 타임아웃
					System.out.println("\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n"
							+ "\n" + "\n" + "\n" + "\n" + "시간이 초과했어요 ŏ̥̥̥̥םŏ̥̥̥̥  손님이 집으로 돌아갔어요ŏ̥̥̥̥םŏ̥̥̥̥  " + "\n"
							+ "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n"
							+ "\n" + "\n");
					timeSleep(2000);
					break;
				}
			}
			break;
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

	public void easyLine(int n) {

		if (n == 0) {
			System.out.println("⠄⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⣤⣴⣶⣶⣶⣶⣶⠶⣶⣤⣤⣀⠀⠀⠀⠀⠀⠀");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⢀⣤⣾⣿⣿⣿⠁⠀⢀⠈⢿⢀⣀⠀⠹⣿⣿⣿⣦⣄⠀⠀⠀");
			System.out.println("⠀⠀⠀⠀⠀⠀⣴⣿⣿⣿⣿⣿⠿⠀⠀⣟⡇⢘⣾⣽⠀⠀⡏⠉⠙⢛⣿⣷⡖⠀");
			System.out.println("⠀⠀⠀⠀⠀⣾⣿⣿⡿⠿⠷⠶⠤⠙⠒⠀⠒⢻⣿⣿⡷⠋⠀⠴⠞⠋⠁⢙⣿⣄");
			System.out.println("⠀⠀⠀⠀⢸⣿⣿⣯⣤⣤⣤⣤⣤⡄⠀⠀⠀⠀⠉⢹⡄⠀⠀⠀⠛⠛⠋⠉⠹⡇");
			System.out.println("⠀⠀⠀⠀⢸⣿⣿⠀⠀⠀⣀⣠⣤⣤⣤⣤⣤⣤⣤⣼⣇⣀⣀⣀⣛⣛⣒⣲⢾⡷");
			System.out.println("⢀⠤⠒⠒⢼⣿⣿⠶⠞⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠁⠀⣼⠃");
			System.out.println("⢮⠀⠀⠀⠀⣿⣿⣆⠀⠀⠻⣿⡿⠛⠉⠉⠁⠀⠉⠉⠛⠿⣿⣿⠟⠁⠀⣼⠃⠀              ⠀⠀⠀⠀⠀⠀⢰⣶⣶⣶⣶⣶⣶⣷⣾⣿⣿⣿⡿⣿⣿⣿⠛⠛⠛⠛⠛⠋⢛⣁⣀⣤⣄⠀⠀⠀⠀⠀⠀⠀");
			System.out.println("⠈⠓⠶⣶⣾⣿⣿⣿⣧⡀⠀⠈⠒⢤⣀⣀⡀⠀⠀⣀⣀⡠⠚⠁⠀⢀⡼⠃⠀⠀               ⠀⠀⠀⠀⠀⠀⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠏⠀⠀⠀⠀⠀⠀⠀");
			System.out.println("⠀⠀⠀⠈⢿⣿⣿⣿⣿⣿⣷⣤⣤⣤⣤⣭⣭⣭⣭⣭⣥⣤⣤⣤⣴⣟⠁⠀                        ⠈⠙⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠋⠉⠉⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
		} else if (n == 1) {

			System.out.println("⠄⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⣤⣴⣶⣶⣶⣶⣶⠶⣶⣤⣤⣀⠀⠀⠀⠀⠀⠀");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⢀⣤⣾⣿⣿⣿⠁⠀⢀⠈⢿⢀⣀⠀⠹⣿⣿⣿⣦⣄⠀⠀⠀");
			System.out.println("⠀⠀⠀⠀⠀⠀⣴⣿⣿⣿⣿⣿⠿⠀⠀⣟⡇⢘⣾⣽⠀⠀⡏⠉⠙⢛⣿⣷⡖⠀");
			System.out.println("⠀⠀⠀⠀⠀⣾⣿⣿⡿⠿⠷⠶⠤⠙⠒⠀⠒⢻⣿⣿⡷⠋⠀⠴⠞⠋⠁⢙⣿⣄");
			System.out.println("⠀⠀⠀⠀⢸⣿⣿⣯⣤⣤⣤⣤⣤⡄⠀⠀⠀⠀⠉⢹⡄⠀⠀⠀⠛⠛⠋⠉⠹⡇");
			System.out.println("⠀⠀⠀⠀⢸⣿⣿⠀⠀⠀⣀⣠⣤⣤⣤⣤⣤⣤⣤⣼⣇⣀⣀⣀⣛⣛⣒⣲⢾⡷              ⠀⠀⠀⠀⠀⠈⠁⠉⢿⣿⣿⣷⣿⣿⣿⣿⣿⣿⣿⡿⠿⠿⣿⣿⣿⣿⣿⣿⣿⠟⠟⠛⠿⠍ ⠀⠀⠀⠀⠀");
			System.out.println("⢀⠤⠒⠒⢼⣿⣿⠶⠞⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠁⠀⣼⠃        ⠀⠀⠀⠀⠀⠀⠀⠀      ⠹⠿⠻⣿⠛⠛⠿⣿⡿⠋⠀⠀⠀⠀⠉⠀⠈⠙⠙⢿⠅⠀⠀⠀⠀⠀⠀⠀⠀");

			System.out.println("⢮⠀⠀⠀⠀⣿⣿⣆⠀⠀⠻⣿⡿⠛⠉⠉⠁⠀⠉⠉⠛⠿⣿⣿⠟⠁⠀⣼⠃⠀              ⠀⠀⠀⠀⠀⠀⢰⣶⣶⣶⣶⣶⣶⣷⣾⣿⣿⣿⡿⣿⣿⣿⠛⠛⠛⠛⠛⠋⢛⣁⣀⣤⣄⠀⠀⠀⠀⠀⠀⠀");
			System.out.println("⠈⠓⠶⣶⣾⣿⣿⣿⣧⡀⠀⠈⠒⢤⣀⣀⡀⠀⠀⣀⣀⡠⠚⠁⠀⢀⡼⠃⠀⠀               ⠀⠀⠀⠀⠀⠀⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠏⠀⠀⠀⠀⠀⠀⠀");
			System.out.println("⠀⠀⠀⠈⢿⣿⣿⣿⣿⣿⣷⣤⣤⣤⣤⣭⣭⣭⣭⣭⣥⣤⣤⣤⣴⣟⠁⠀                        ⠈⠙⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠋⠉⠉⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
		} else if (n == 2) {
			System.out.println("⠄⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⣤⣴⣶⣶⣶⣶⣶⠶⣶⣤⣤⣀⠀⠀⠀⠀⠀⠀");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⢀⣤⣾⣿⣿⣿⠁⠀⢀⠈⢿⢀⣀⠀⠹⣿⣿⣿⣦⣄⠀⠀⠀");
			System.out.println("⠀⠀⠀⠀⠀⠀⣴⣿⣿⣿⣿⣿⠿⠀⠀⣟⡇⢘⣾⣽⠀⠀⡏⠉⠙⢛⣿⣷⡖⠀");
			System.out.println("⠀⠀⠀⠀⠀⣾⣿⣿⡿⠿⠷⠶⠤⠙⠒⠀⠒⢻⣿⣿⡷⠋⠀⠴⠞⠋⠁⢙⣿⣄");
			System.out.println(
					"⠀⠀⠀⠀⢸⣿⣿⣯⣤⣤⣤⣤⣤⡄⠀⠀⠀⠀⠉⢹⡄⠀⠀⠀⠛⠛⠋⠉⠹⡇                          ░░░░░░░░░░░░░░░░░░░░░░░░░░         ");

			System.out.println("⠀⠀⠀⠀⢸⣿⣿⠀⠀⠀⣀⣠⣤⣤⣤⣤⣤⣤⣤⣼⣇⣀⣀⣀⣛⣛⣒⣲⢾⡷              ⠀⠀⠀⠀⠀⠈⠁⠉⢿⣿⣿⣷⣿⣿⣿⣿⣿⣿⣿⡿⠿⠿⣿⣿⣿⣿⣿⣿⣿⠟⠟⠛⠿⠍ ⠀⠀⠀⠀⠀");
			System.out.println("⢀⠤⠒⠒⢼⣿⣿⠶⠞⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠁⠀⣼⠃        ⠀⠀⠀⠀⠀⠀⠀    ⠀  ⠹⠿⠻⣿⠛⠛⠿⣿⡿⠋⠀⠀⠀⠀⠉⠀⠈⠙⠙⢿⠅⠀⠀⠀⠀⠀⠀⠀⠀");
			System.out.println("⢮⠀⠀⠀⠀⣿⣿⣆⠀⠀⠻⣿⡿⠛⠉⠉⠁⠀⠉⠉⠛⠿⣿⣿⠟⠁⠀⣼⠃⠀              ⠀⠀⠀⠀⠀⠀⢰⣶⣶⣶⣶⣶⣶⣷⣾⣿⣿⣿⡿⣿⣿⣿⠛⠛⠛⠛⠛⠋⢛⣁⣀⣤⣄⠀⠀⠀⠀⠀⠀⠀");
			System.out.println("⠈⠓⠶⣶⣾⣿⣿⣿⣧⡀⠀⠈⠒⢤⣀⣀⡀⠀⠀⣀⣀⡠⠚⠁⠀⢀⡼⠃⠀⠀               ⠀⠀⠀⠀⠀⠀⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠏⠀⠀⠀⠀⠀⠀⠀");
			System.out.println("⠀⠀⠀⠈⢿⣿⣿⣿⣿⣿⣷⣤⣤⣤⣤⣭⣭⣭⣭⣭⣥⣤⣤⣤⣴⣟⠁⠀                        ⠈⠙⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠋⠉⠉⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
		} else if (n == 3) {
			System.out.println("⠄⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⣤⣴⣶⣶⣶⣶⣶⠶⣶⣤⣤⣀⠀⠀⠀⠀⠀⠀");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⢀⣤⣾⣿⣿⣿⠁⠀⢀⠈⢿⢀⣀⠀⠹⣿⣿⣿⣦⣄⠀⠀⠀");
			System.out.println("⠀⠀⠀⠀⠀⠀⣴⣿⣿⣿⣿⣿⠿⠀⠀⣟⡇⢘⣾⣽⠀⠀⡏⠉⠙⢛⣿⣷⡖⠀");
			System.out.println(
					"⠀⠀⠀⠀⠀⣾⣿⣿⡿⠿⠷⠶⠤⠙⠒⠀⠒⢻⣿⣿⡷⠋⠀⠴⠞⠋⠁⢙⣿⣄                        ▓▓▓▓▓▓▓▓▓▓▓▓▓▓██▓▓▓▓▓▓▓▓▓▓▓▓⠀⠀⠀⠀⠀⠀⠀⠀");

			System.out.println(
					"⠀⠀⠀⠀⢸⣿⣿⣯⣤⣤⣤⣤⣤⡄⠀⠀⠀⠀⠉⢹⡄⠀⠀⠀⠛⠛⠋⠉⠹⡇                         ░░░░░░░░░░░░░░░░░░░░░░░░░░         ");
			System.out.println("⠀⠀⠀⠀⢸⣿⣿⠀⠀⠀⣀⣠⣤⣤⣤⣤⣤⣤⣤⣼⣇⣀⣀⣀⣛⣛⣒⣲⢾⡷              ⠀⠀⠀⠀⠀⠈⠁⠉⢿⣿⣿⣷⣿⣿⣿⣿⣿⣿⣿⡿⠿⠿⣿⣿⣿⣿⣿⣿⣿⠟⠟⠛⠿⠍ ⠀⠀⠀⠀⠀");
			System.out.println("⢀⠤⠒⠒⢼⣿⣿⠶⠞⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠁⠀⣼⠃        ⠀⠀⠀⠀⠀⠀    ⠀⠀  ⠹⠿⠻⣿⠛⠛⠿⣿⡿⠋⠀⠀⠀⠀⠉⠀⠈⠙⠙⢿⠅⠀⠀⠀⠀⠀⠀⠀⠀");
			System.out.println("⢮⠀⠀⠀⠀⣿⣿⣆⠀⠀⠻⣿⡿⠛⠉⠉⠁⠀⠉⠉⠛⠿⣿⣿⠟⠁⠀⣼⠃⠀              ⠀⠀⠀⠀⠀⠀⢰⣶⣶⣶⣶⣶⣶⣷⣾⣿⣿⣿⡿⣿⣿⣿⠛⠛⠛⠛⠛⠋⢛⣁⣀⣤⣄⠀⠀⠀⠀⠀⠀⠀");
			System.out.println("⠈⠓⠶⣶⣾⣿⣿⣿⣧⡀⠀⠈⠒⢤⣀⣀⡀⠀⠀⣀⣀⡠⠚⠁⠀⢀⡼⠃⠀⠀               ⠀⠀⠀⠀⠀⠀⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠏⠀⠀⠀⠀⠀⠀⠀");
			System.out.println("⠀⠀⠀⠈⢿⣿⣿⣿⣿⣿⣷⣤⣤⣤⣤⣭⣭⣭⣭⣭⣥⣤⣤⣤⣴⣟⠁⠀                        ⠈⠙⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠋⠉⠉⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
		} else if (n == 4) {
			System.out.println(
					"                                             ⠀⠀⠀⠀⠀⠀⠀    ⠀⠀⠀⠀⠀⠀     ⠀⠀⠀⠀⠀⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀  ⠀⠀⠀⠀");
			System.out.println(
					"                                                               ⢀⣠⣤⣶⣶⣶⣾⣿⣽⣿⣷⣿⣷⣢⠽⢷⣶⣤⢀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
			System.out
					.println("⠄⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⣤⣴⣶⣶⣶⣶⣶⠶⣶⣤⣤⣀⠀⠀⠀⠀⠀⠀               ⠀⠀ ⠀⠀⠀⠀⠀⠀⣠⣶⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡗⢾⣿⣧⣷⢵⣦⡀⠀⠀⠀⠀⠀⠀⠀⠀");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⢀⣤⣾⣿⣿⣿⠁⠀⢀⠈⢿⢀⣀⠀⠹⣿⣿⣿⣦⣄⠀⠀⠀              ⠀⠀⠀ ⠀⠀⠀⠀⠸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣾⡆⠀⠀⠀⠀⠀⠀⠀");
			System.out.println("⠀⠀⠀⠀⠀⠀⣴⣿⣿⣿⣿⣿⠿⠀⠀⣟⡇⢘⣾⣽⠀⠀⡏⠉⠙⢛⣿⣷⡖⠀              ⠀⠀ ⠀⠀⠀⠀⠀⣻⢿⣿⣿⣿⣿⣿⣭⣽⣿⣿⣦⣤⣴⣾⣭⣭⣭⣉⠙⡛⠛⠻⠿⠿⡗⠀⠀⠀⠀⠀⠀⠀");

			System.out.println(
					"⠀⠀⠀⠀⠀⣾⣿⣿⡿⠿⠷⠶⠤⠙⠒⠀⠒⢻⣿⣿⡷⠋⠀⠴⠞⠋⠁⢙⣿⣄                        ▓▓▓▓▓▓▓▓▓▓▓▓▓▓██▓▓▓▓▓▓▓▓▓▓▓▓⠀⠀⠀⠀⠀⠀⠀⠀");
			System.out.println(
					"⠀⠀⠀⠀⢸⣿⣿⣯⣤⣤⣤⣤⣤⡄⠀⠀⠀⠀⠉⢹⡄⠀⠀⠀⠛⠛⠋⠉⠹⡇                         ░░░░░░░░░░░░░░░░░░░░░░░░░░         ");
			System.out.println("⠀⠀⠀⠀⢸⣿⣿⠀⠀⠀⣀⣠⣤⣤⣤⣤⣤⣤⣤⣼⣇⣀⣀⣀⣛⣛⣒⣲⢾⡷                ⠀⠀⠀⠈⠁⠉⢿⣿⣿⣷⣿⣿⣿⣿⣿⣿⣿⡿⠿⠿⣿⣿⣿⣿⣿⣿⣿⠟⠟⠛⠿⠍ ⠀⠀⠀⠀⠀");
			System.out.println("⢀⠤⠒⠒⢼⣿⣿⠶⠞⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠁⠀⣼⠃        ⠀⠀⠀⠀⠀⠀⠀    ⠀  ⠹⠿⠻⣿⠛⠛⠿⣿⡿⠋⠀⠀⠀⠀⠉⠀⠈⠙⠙⢿⠅⠀⠀⠀⠀⠀⠀⠀⠀");
			System.out.println("⢮⠀⠀⠀⠀⣿⣿⣆⠀⠀⠻⣿⡿⠛⠉⠉⠁⠀⠉⠉⠛⠿⣿⣿⠟⠁⠀⣼⠃⠀              ⠀⠀⠀⠀⠀⠀⢰⣶⣶⣶⣶⣶⣶⣷⣾⣿⣿⣿⡿⣿⣿⣿⠛⠛⠛⠛⠛⠋⢛⣁⣀⣤⣄⠀⠀⠀⠀⠀⠀⠀");
			System.out.println("⠈⠓⠶⣶⣾⣿⣿⣿⣧⡀⠀⠈⠒⢤⣀⣀⡀⠀⠀⣀⣀⡠⠚⠁⠀⢀⡼⠃⠀⠀               ⠀⠀⠀⠀⠀⠀⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠏⠀⠀⠀⠀⠀⠀⠀");
			System.out.println("⠀⠀⠀⠈⢿⣿⣿⣿⣿⣿⣷⣤⣤⣤⣤⣭⣭⣭⣭⣭⣥⣤⣤⣤⣴⣟⠁⠀                        ⠈⠙⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠋⠉⠉⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
		}

	}

	public void normalLine(int n) {

		if (n == 0) {
			System.out.println("⠀⢰⣦⣤⣤⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⣤⣤⣴⡆⠀");
			System.out.println("⠀⢸⣿⣿⣿⠉⠉⠲⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⠖⠉⠉⣿⣿⣿⡇⠀");
			System.out.println("⠀⠈⢿⣿⡏⠀⠀⠀⠈⢳⣠⡴⠶⠖⠒⠒⠲⠶⢦⣄⡞⠁⠀⠀⠀⢹⣿⡿⠁⠀");
			System.out.println("⠀⠀⠘⢿⡇⠀⠀⠀⠘⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠃⠀⠀⠀⢸⡿⠃⠀⠀");
			System.out.println("⠀⠀⠀⠈⠛⢶⠏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠹⡶⠛⠁⠀⠀⠀");
			System.out.println("⠀⠀⠀⠀⢀⡟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢻⡀⠀⠀⠀⠀");
			System.out.println("⠀⠀⠀⠀⢸⠃⠀⣴⣾⠓⢢⠀⠀⠀⠀⠀⠀⠀⠀⡔⠚⣷⣦⠀⠘⡇⠀⠀⠀⠀");
			System.out.println("⠀⠀⠀⠀⢸⠀⠀⣿⣿⣤⣾⠃⠀⠀⠀⠀⠀⠀⠘⣷⣴⣿⣿⠀⠀⡇⠀⠀⠀⠀");
			System.out.println("⠀⠀⠀⢀⡟⣀⣤⣌⡙⠋⠁⠀⠀⠀⠺⠗⠀⠀⠀⠈⠙⢋⣡⣤⣀⢻⡀⠀⠀⠀");
			System.out.println("⠀⠀⠀⢸⣿⣿⣿⣿⣿⡄⠀⠰⢤⣤⠾⠷⣤⡤⠆⠀⢠⣿⣿⣿⣿⣿⡇⠀⠀⠀");
			System.out.println("⠀⠀⠀⠈⢿⣿⣿⣿⣿⠇⠀⠀⠘⡇⠀⠀⢸⠃⠀⠀⠸⣿⣿⣿⣿⡿⠁⠀⠀⠀");
			System.out.println(
					"⠀⠀⠀⠀⠈⠻⢿⣛⠁⠀⠀⠀⠀⠑⢄⡠⠊⠀⠀⠀⠀⠈⣛⡿⠟⠁⠀⠀⠀                          ⢰⣶⣶⣶⣶⣶⣶⣷⣾⣿⣿⣿⡿⣿⣿⣿⠛⠛⠛⠛⠛⠋⢛⣁⣀⣤⣄⠀⠀⠀⠀⠀⠀⠀⠀");
			System.out.println(
					"⠀⠀⠀⠀⠀⠀⠀⠉⠛⠶⣤⣄⣀⣀⣀⣀⣀⣀⣠⣴⠶⠛⠉⠀⠀⠀⠀⠀⠀                         ⠀⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠏⠀⠀⠀⠀⠀⠀⠀⠀");
			System.out.println(
					"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠉⠉⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀                        ⠀⠀⠀⠀⠀⠈⠙⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠋⠉⠉⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
		} else if (n == 1) {
			System.out.println("⠀⢰⣦⣤⣤⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⣤⣤⣴⡆⠀");
			System.out.println("⠀⢸⣿⣿⣿⠉⠉⠲⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⠖⠉⠉⣿⣿⣿⡇⠀");
			System.out.println("⠀⠈⢿⣿⡏⠀⠀⠀⠈⢳⣠⡴⠶⠖⠒⠒⠲⠶⢦⣄⡞⠁⠀⠀⠀⢹⣿⡿⠁⠀");
			System.out.println("⠀⠀⠘⢿⡇⠀⠀⠀⠘⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠃⠀⠀⠀⢸⡿⠃⠀⠀");
			System.out.println("⠀⠀⠀⠈⠛⢶⠏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠹⡶⠛⠁⠀⠀⠀");
			System.out.println("⠀⠀⠀⠀⢀⡟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢻⡀⠀⠀⠀⠀");
			System.out.println("⠀⠀⠀⠀⢸⠃⠀⣴⣾⠓⢢⠀⠀⠀⠀⠀⠀⠀⠀⡔⠚⣷⣦⠀⠘⡇⠀⠀⠀⠀");
			System.out.println("⠀⠀⠀⠀⢸⠀⠀⣿⣿⣤⣾⠃⠀⠀⠀⠀⠀⠀⠘⣷⣴⣿⣿⠀⠀⡇⠀⠀⠀⠀");
			System.out.println("⠀⠀⠀⢀⡟⣀⣤⣌⡙⠋⠁⠀⠀⠀⠺⠗⠀⠀⠀⠈⠙⢋⣡⣤⣀⢻⡀⠀⠀⠀");
			System.out.println(
					"⠀⠀⠀⢸⣿⣿⣿⣿⣿⡄⠀⠰⢤⣤⠾⠷⣤⡤⠆⠀⢠⣿⣿⣿⣿⣿⡇⠀⠀                       ⠀⠈⠁⠉⢿⣿⣿⣷⣿⣿⣿⣿⣿⣿⣿⡿⠿⠿⣿⣿⣿⣿⣿⣿⣿⠟⠟⠛⠿⠍⠀⠀⠀⠀⠀⠀⠀");
			System.out.println(
					"⠀⠀⠀⠈⢿⣿⣿⣿⣿⠇⠀⠀⠘⡇⠀⠀⢸⠃⠀⠀⠸⣿⣿⣿⣿⡿⠁⠀⠀⠀                         ⠀⠀  ⠹⠿⠻⣿⠛⠛⠿⣿⡿⠋⠀⠀⠀⠀⠉⠀⠈⠙⠙⢿⠅⠀⠀⠀⠀⠀⠀⠀⠀   ");

			System.out.println(
					"⠀⠀⠀⠀⠈⠻⢿⣛⠁⠀⠀⠀⠀⠑⢄⡠⠊⠀⠀⠀⠀⠈⣛⡿⠟⠁⠀⠀⠀                          ⢰⣶⣶⣶⣶⣶⣶⣷⣾⣿⣿⣿⡿⣿⣿⣿⠛⠛⠛⠛⠛⠋⢛⣁⣀⣤⣄⠀⠀⠀⠀⠀⠀⠀⠀");
			System.out.println(
					"⠀⠀⠀⠀⠀⠀⠀⠉⠛⠶⣤⣄⣀⣀⣀⣀⣀⣀⣠⣴⠶⠛⠉⠀⠀⠀⠀⠀⠀                         ⠀⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠏⠀⠀⠀⠀⠀⠀⠀⠀");
			System.out.println(
					"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠉⠉⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀                        ⠀⠀⠀⠀⠀⠈⠙⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠋⠉⠉⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
		} else if (n == 2) {
			System.out.println("⠀⢰⣦⣤⣤⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⣤⣤⣴⡆⠀");
			System.out.println("⠀⢸⣿⣿⣿⠉⠉⠲⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⠖⠉⠉⣿⣿⣿⡇⠀");
			System.out.println("⠀⠈⢿⣿⡏⠀⠀⠀⠈⢳⣠⡴⠶⠖⠒⠒⠲⠶⢦⣄⡞⠁⠀⠀⠀⢹⣿⡿⠁⠀");
			System.out.println("⠀⠀⠘⢿⡇⠀⠀⠀⠘⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠃⠀⠀⠀⢸⡿⠃⠀⠀");
			System.out.println("⠀⠀⠀⠈⠛⢶⠏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠹⡶⠛⠁⠀⠀⠀");
			System.out.println("⠀⠀⠀⠀⢀⡟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢻⡀⠀⠀⠀⠀");
			System.out.println("⠀⠀⠀⠀⢸⠃⠀⣴⣾⠓⢢⠀⠀⠀⠀⠀⠀⠀⠀⡔⠚⣷⣦⠀⠘⡇⠀⠀⠀⠀");
			System.out.println("⠀⠀⠀⠀⢸⠀⠀⣿⣿⣤⣾⠃⠀⠀⠀⠀⠀⠀⠘⣷⣴⣿⣿⠀⠀⡇⠀⠀⠀⠀");
			System.out.println(
					"⠀⠀⠀⢀⡟⣀⣤⣌⡙⠋⠁⠀⠀⠀⠺⠗⠀⠀⠀⠈⠙⢋⣡⣤⣀⢻⡀⠀⠀                          ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒      ");

			System.out.println(
					"⠀⠀⠀⢸⣿⣿⣿⣿⣿⡄⠀⠰⢤⣤⠾⠷⣤⡤⠆⠀⢠⣿⣿⣿⣿⣿⡇⠀⠀                       ⠀⠈⠁⠉⢿⣿⣿⣷⣿⣿⣿⣿⣿⣿⣿⡿⠿⠿⣿⣿⣿⣿⣿⣿⣿⠟⠟⠛⠿⠍⠀⠀⠀⠀⠀⠀⠀");
			System.out.println(
					"⠀⠀⠀⠈⢿⣿⣿⣿⣿⠇⠀⠀⠘⡇⠀⠀⢸⠃⠀⠀⠸⣿⣿⣿⣿⡿⠁⠀⠀⠀                         ⠀⠀  ⠹⠿⠻⣿⠛⠛⠿⣿⡿⠋⠀⠀⠀⠀⠉⠀⠈⠙⠙⢿⠅⠀⠀⠀⠀⠀⠀⠀⠀   ");
			System.out.println(
					"⠀⠀⠀⠀⠈⠻⢿⣛⠁⠀⠀⠀⠀⠑⢄⡠⠊⠀⠀⠀⠀⠈⣛⡿⠟⠁⠀⠀⠀                          ⢰⣶⣶⣶⣶⣶⣶⣷⣾⣿⣿⣿⡿⣿⣿⣿⠛⠛⠛⠛⠛⠋⢛⣁⣀⣤⣄⠀⠀⠀⠀⠀⠀⠀⠀");
			System.out.println(
					"⠀⠀⠀⠀⠀⠀⠀⠉⠛⠶⣤⣄⣀⣀⣀⣀⣀⣀⣠⣴⠶⠛⠉⠀⠀⠀⠀⠀⠀                         ⠀⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠏⠀⠀⠀⠀⠀⠀⠀⠀");
			System.out.println(
					"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠉⠉⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀                        ⠀⠀⠀⠀⠀⠈⠙⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠋⠉⠉⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
		} else if (n == 3) {
			System.out.println("⠀⢰⣦⣤⣤⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⣤⣤⣴⡆⠀");
			System.out.println("⠀⢸⣿⣿⣿⠉⠉⠲⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⠖⠉⠉⣿⣿⣿⡇⠀");
			System.out.println("⠀⠈⢿⣿⡏⠀⠀⠀⠈⢳⣠⡴⠶⠖⠒⠒⠲⠶⢦⣄⡞⠁⠀⠀⠀⢹⣿⡿⠁⠀");
			System.out.println("⠀⠀⠘⢿⡇⠀⠀⠀⠘⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠃⠀⠀⠀⢸⡿⠃⠀⠀");
			System.out.println("⠀⠀⠀⠈⠛⢶⠏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠹⡶⠛⠁⠀⠀⠀");
			System.out.println("⠀⠀⠀⠀⢀⡟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢻⡀⠀⠀⠀⠀");
			System.out.println("⠀⠀⠀⠀⢸⠃⠀⣴⣾⠓⢢⠀⠀⠀⠀⠀⠀⠀⠀⡔⠚⣷⣦⠀⠘⡇⠀⠀⠀⠀");
			System.out.println(
					"⠀⠀⠀⠀⢸⠀⠀⣿⣿⣤⣾⠃⠀⠀⠀⠀⠀⠀⠘⣷⣴⣿⣿⠀⠀⡇⠀⠀⠀                             ░░░░░░░░░░░░░░░░░░░░░░░░░░░░⠀        ");

			System.out.println(
					"⠀⠀⠀⢀⡟⣀⣤⣌⡙⠋⠁⠀⠀⠀⠺⠗⠀⠀⠀⠈⠙⢋⣡⣤⣀⢻⡀⠀⠀                         ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒      ");
			System.out.println(
					"⠀⠀⠀⢸⣿⣿⣿⣿⣿⡄⠀⠰⢤⣤⠾⠷⣤⡤⠆⠀⢠⣿⣿⣿⣿⣿⡇⠀⠀                       ⠀⠈⠁⠉⢿⣿⣿⣷⣿⣿⣿⣿⣿⣿⣿⡿⠿⠿⣿⣿⣿⣿⣿⣿⣿⠟⠟⠛⠿⠍⠀⠀⠀⠀⠀⠀⠀");
			System.out.println(
					"⠀⠀⠀⠈⢿⣿⣿⣿⣿⠇⠀⠀⠘⡇⠀⠀⢸⠃⠀⠀⠸⣿⣿⣿⣿⡿⠁⠀⠀⠀                         ⠀⠀  ⠹⠿⠻⣿⠛⠛⠿⣿⡿⠋⠀⠀⠀⠀⠉⠀⠈⠙⠙⢿⠅⠀⠀⠀⠀⠀⠀⠀⠀   ");
			System.out.println(
					"⠀⠀⠀⠀⠈⠻⢿⣛⠁⠀⠀⠀⠀⠑⢄⡠⠊⠀⠀⠀⠀⠈⣛⡿⠟⠁⠀⠀⠀                          ⢰⣶⣶⣶⣶⣶⣶⣷⣾⣿⣿⣿⡿⣿⣿⣿⠛⠛⠛⠛⠛⠋⢛⣁⣀⣤⣄⠀⠀⠀⠀⠀⠀⠀⠀");
			System.out.println(
					"⠀⠀⠀⠀⠀⠀⠀⠉⠛⠶⣤⣄⣀⣀⣀⣀⣀⣀⣠⣴⠶⠛⠉⠀⠀⠀⠀⠀⠀                         ⠀⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠏⠀⠀⠀⠀⠀⠀⠀⠀");
			System.out.println(
					"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠉⠉⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀                        ⠀⠀⠀⠀⠀⠈⠙⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠋⠉⠉⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
		} else if (n == 4) {
			System.out.println("⠀⢰⣦⣤⣤⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⣤⣤⣴⡆⠀");
			System.out.println("⠀⢸⣿⣿⣿⠉⠉⠲⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⠖⠉⠉⣿⣿⣿⡇⠀");
			System.out.println("⠀⠈⢿⣿⡏⠀⠀⠀⠈⢳⣠⡴⠶⠖⠒⠒⠲⠶⢦⣄⡞⠁⠀⠀⠀⢹⣿⡿⠁⠀");
			System.out.println("⠀⠀⠘⢿⡇⠀⠀⠀⠘⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠃⠀⠀⠀⢸⡿⠃⠀⠀");
			System.out.println("⠀⠀⠀⠈⠛⢶⠏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠹⡶⠛⠁⠀⠀⠀");
			System.out.println("⠀⠀⠀⠀⢀⡟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢻⡀⠀⠀⠀⠀");
			System.out.println(
					"⠀⠀⠀⠀⢸⠃⠀⣴⣾⠓⢢⠀⠀⠀⠀⠀⠀⠀⠀⡔⠚⣷⣦⠀⠘⡇⠀⠀⠀⠀                              ▓▓▓▓▓▓▓▓▓▓▓▓███▓▓▓▓▓▓▓▓▓▓▓⠀        ⠀");

			System.out.println(
					"⠀⠀⠀⠀⢸⠀⠀⣿⣿⣤⣾⠃⠀⠀⠀⠀⠀⠀⠘⣷⣴⣿⣿⠀⠀⡇⠀⠀⠀                             ░░░░░░░░░░░░░░░░░░░░░░░░░░░░⠀        ");
			System.out.println(
					"⠀⠀⠀⢀⡟⣀⣤⣌⡙⠋⠁⠀⠀⠀⠺⠗⠀⠀⠀⠈⠙⢋⣡⣤⣀⢻⡀⠀⠀                         ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒      ");
			System.out.println(
					"⠀⠀⠀⢸⣿⣿⣿⣿⣿⡄⠀⠰⢤⣤⠾⠷⣤⡤⠆⠀⢠⣿⣿⣿⣿⣿⡇⠀⠀                       ⠀⠈⠁⠉⢿⣿⣿⣷⣿⣿⣿⣿⣿⣿⣿⡿⠿⠿⣿⣿⣿⣿⣿⣿⣿⠟⠟⠛⠿⠍⠀⠀⠀⠀⠀⠀⠀");
			System.out.println(
					"⠀⠀⠀⠈⢿⣿⣿⣿⣿⠇⠀⠀⠘⡇⠀⠀⢸⠃⠀⠀⠸⣿⣿⣿⣿⡿⠁⠀⠀⠀                         ⠀⠀  ⠹⠿⠻⣿⠛⠛⠿⣿⡿⠋⠀⠀⠀⠀⠉⠀⠈⠙⠙⢿⠅⠀⠀⠀⠀⠀⠀⠀⠀   ");
			System.out.println(
					"⠀⠀⠀⠀⠈⠻⢿⣛⠁⠀⠀⠀⠀⠑⢄⡠⠊⠀⠀⠀⠀⠈⣛⡿⠟⠁⠀⠀⠀                          ⢰⣶⣶⣶⣶⣶⣶⣷⣾⣿⣿⣿⡿⣿⣿⣿⠛⠛⠛⠛⠛⠋⢛⣁⣀⣤⣄⠀⠀⠀⠀⠀⠀⠀⠀");
			System.out.println(
					"⠀⠀⠀⠀⠀⠀⠀⠉⠛⠶⣤⣄⣀⣀⣀⣀⣀⣀⣠⣴⠶⠛⠉⠀⠀⠀⠀⠀⠀                         ⠀⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠏⠀⠀⠀⠀⠀⠀⠀⠀");
			System.out.println(
					"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠉⠉⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀                        ⠀⠀⠀⠀⠀⠈⠙⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠋⠉⠉⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
		} else if (n == 5) {
			System.out.println("⠀⢰⣦⣤⣤⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⣤⣤⣴⡆⠀");
			System.out.println("⠀⢸⣿⣿⣿⠉⠉⠲⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⠖⠉⠉⣿⣿⣿⡇⠀");
			System.out.println("⠀⠈⢿⣿⡏⠀⠀⠀⠈⢳⣠⡴⠶⠖⠒⠒⠲⠶⢦⣄⡞⠁⠀⠀⠀⢹⣿⡿⠁⠀");
			System.out.println("⠀⠀⠘⢿⡇⠀⠀⠀⠘⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠃⠀⠀⠀⢸⡿⠃⠀⠀");
			System.out.println("⠀⠀⠀⠈⠛⢶⠏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠹⡶⠛⠁⠀⠀⠀");
			System.out.println(
					"⠀⠀⠀⠀⢀⡟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢻⡀⠀⠀⠀⠀                              ░░░░▒▒▒▒▒▒░░░░░░░▒▒▒▒▒▒░░░░          ");

			System.out.println(
					"⠀⠀⠀⠀⢸⠃⠀⣴⣾⠓⢢⠀⠀⠀⠀⠀⠀⠀⠀⡔⠚⣷⣦⠀⠘⡇⠀⠀⠀⠀                              ▓▓▓▓▓▓▓▓▓▓▓▓███▓▓▓▓▓▓▓▓▓▓▓⠀        ⠀");
			System.out.println(
					"⠀⠀⠀⠀⢸⠀⠀⣿⣿⣤⣾⠃⠀⠀⠀⠀⠀⠀⠘⣷⣴⣿⣿⠀⠀⡇⠀⠀⠀                             ░░░░░░░░░░░░░░░░░░░░░░░░░░░░⠀        ");
			System.out.println(
					"⠀⠀⠀⢀⡟⣀⣤⣌⡙⠋⠁⠀⠀⠀⠺⠗⠀⠀⠀⠈⠙⢋⣡⣤⣀⢻⡀⠀⠀                         ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒      ");
			System.out.println(
					"⠀⠀⠀⢸⣿⣿⣿⣿⣿⡄⠀⠰⢤⣤⠾⠷⣤⡤⠆⠀⢠⣿⣿⣿⣿⣿⡇⠀⠀                       ⠀⠈⠁⠉⢿⣿⣿⣷⣿⣿⣿⣿⣿⣿⣿⡿⠿⠿⣿⣿⣿⣿⣿⣿⣿⠟⠟⠛⠿⠍⠀⠀⠀⠀⠀⠀⠀");
			System.out.println(
					"⠀⠀⠀⠈⢿⣿⣿⣿⣿⠇⠀⠀⠘⡇⠀⠀⢸⠃⠀⠀⠸⣿⣿⣿⣿⡿⠁⠀⠀⠀                         ⠀⠀  ⠹⠿⠻⣿⠛⠛⠿⣿⡿⠋⠀⠀⠀⠀⠉⠀⠈⠙⠙⢿⠅⠀⠀⠀⠀⠀⠀⠀⠀   ");
			System.out.println(
					"⠀⠀⠀⠀⠈⠻⢿⣛⠁⠀⠀⠀⠀⠑⢄⡠⠊⠀⠀⠀⠀⠈⣛⡿⠟⠁⠀⠀⠀                          ⢰⣶⣶⣶⣶⣶⣶⣷⣾⣿⣿⣿⡿⣿⣿⣿⠛⠛⠛⠛⠛⠋⢛⣁⣀⣤⣄⠀⠀⠀⠀⠀⠀⠀⠀");
			System.out.println(
					"⠀⠀⠀⠀⠀⠀⠀⠉⠛⠶⣤⣄⣀⣀⣀⣀⣀⣀⣠⣴⠶⠛⠉⠀⠀⠀⠀⠀⠀                         ⠀⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠏⠀⠀⠀⠀⠀⠀⠀⠀");
			System.out.println(
					"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠉⠉⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀                        ⠀⠀⠀⠀⠀⠈⠙⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠋⠉⠉⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
		} else if (n == 6) {
			System.out.println("⠀⢰⣦⣤⣤⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⣤⣤⣴⡆⠀");
			System.out.println(
					"⠀⢸⣿⣿⣿⠉⠉⠲⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⠖⠉⠉⣿⣿⣿⡇                      ⠀ ⠀⠀⠀⠀⠀⠀⠀⢀⣠⣤⣶⣶⣶⣾⣿⣽⣿⣷⣿⣷⣢⠽⢷⣶⣤⢀⠀⠀⠀⠀⠀⠀⠀⠀⠀ ⠀⠀⠀");
			System.out.println(
					"⠀⠈⢿⣿⡏⠀⠀⠀⠈⢳⣠⡴⠶⠖⠒⠒⠲⠶⢦⣄⡞⠁⠀⠀⠀⢹⣿⡿⠁⠀                ⠀⠀⠀⠀⠀ ⠀ ⠀⠀⣠⣶⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡗⢾⣿⣧⣷⢵⣦⡀⠀⠀⠀⠀⠀   ⠀⠀⠀");
			System.out.println(
					"⠀⠀⠘⢿⡇⠀⠀⠀⠘⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠃⠀⠀⠀⢸⡿⠃⠀⠀               ⠀⠀⠀      ⠀⠀⠀⠸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣾⡆⠀⠀⠀⠀ ⠀⠀⠀ ");
			System.out.println(
					"⠀⠀⠀⠈⠛⢶⠏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠹⡶⠛⠁⠀⠀⠀              ⠀⠀⠀⠀⠀      ⠀⠀⣻⢿⣿⣿⣿⣿⣿⣭⣽⣿⣿⣦⣤⣴⣾⣭⣭⣭⣉⠙⡛⠛⠻⠿⠿⡗⠀        ");

			System.out.println(
					"⠀⠀⠀⠀⢀⡟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢻⡀⠀⠀⠀⠀                              ░░░░▒▒▒▒▒▒░░░░░░░▒▒▒▒▒▒░░░░          ");
			System.out.println(
					"⠀⠀⠀⠀⢸⠃⠀⣴⣾⠓⢢⠀⠀⠀⠀⠀⠀⠀⠀⡔⠚⣷⣦⠀⠘⡇⠀⠀⠀⠀                              ▓▓▓▓▓▓▓▓▓▓▓▓███▓▓▓▓▓▓▓▓▓▓▓⠀        ⠀");
			System.out.println(
					"⠀⠀⠀⠀⢸⠀⠀⣿⣿⣤⣾⠃⠀⠀⠀⠀⠀⠀⠘⣷⣴⣿⣿⠀⠀⡇⠀⠀⠀                              ░░░░░░░░░░░░░░░░░░░░░░░░░░░░⠀        ");
			System.out.println(
					"⠀⠀⠀⢀⡟⣀⣤⣌⡙⠋⠁⠀⠀⠀⠺⠗⠀⠀⠀⠈⠙⢋⣡⣤⣀⢻⡀⠀⠀                           ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒      ");
			System.out.println(
					"⠀⠀⠀⢸⣿⣿⣿⣿⣿⡄⠀⠰⢤⣤⠾⠷⣤⡤⠆⠀⢠⣿⣿⣿⣿⣿⡇⠀⠀                       ⠀⠈⠁⠉⢿⣿⣿⣷⣿⣿⣿⣿⣿⣿⣿⡿⠿⠿⣿⣿⣿⣿⣿⣿⣿⠟⠟⠛⠿⠍⠀⠀⠀⠀⠀⠀⠀");
			System.out.println(
					"⠀⠀⠀⠈⢿⣿⣿⣿⣿⠇⠀⠀⠘⡇⠀⠀⢸⠃⠀⠀⠸⣿⣿⣿⣿⡿⠁⠀⠀⠀                         ⠀⠀  ⠹⠿⠻⣿⠛⠛⠿⣿⡿⠋⠀⠀⠀⠀⠉⠀⠈⠙⠙⢿⠅⠀⠀⠀⠀⠀⠀⠀⠀   ");
			System.out.println(
					"⠀⠀⠀⠀⠈⠻⢿⣛⠁⠀⠀⠀⠀⠑⢄⡠⠊⠀⠀⠀⠀⠈⣛⡿⠟⠁⠀⠀⠀                          ⢰⣶⣶⣶⣶⣶⣶⣷⣾⣿⣿⣿⡿⣿⣿⣿⠛⠛⠛⠛⠛⠋⢛⣁⣀⣤⣄⠀⠀⠀⠀⠀⠀⠀⠀");
			System.out.println(
					"⠀⠀⠀⠀⠀⠀⠀⠉⠛⠶⣤⣄⣀⣀⣀⣀⣀⣀⣠⣴⠶⠛⠉⠀⠀⠀⠀⠀⠀                         ⠀⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠏⠀⠀⠀⠀⠀⠀⠀⠀");
			System.out.println(
					"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠉⠉⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀                        ⠀⠀⠀⠀⠀⠈⠙⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠋⠉⠉⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
		}

	}

	public void hardLine(int n) {

		if (n == 0) {
			System.out.println("                                     ");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣠⣤⣤⣤⣤⣾⣿⣿⣦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀    ");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣾⣿⣿⣿⣿⡛⢫⣿⣿⡿⠉⠻⣿⣿⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⣶⣿⣿⠟⠛⠿⠿⠟⠀⠈⢩⠞⠁⠀⠉⠒⡈⢣⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⣸⡿⡿⢣⠔⠘⠀⠓⢦⠀⠀⠇⣠⣴⣶⣤⣄⠀⠀⠉⠀⠈⠐⠠⠀⠀⠀⠀⠀");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⣰⣿⡇⡰⠃⢀⣴⣶⣶⣦⡀⠀⣼⣿⡟⠙⣿⣿⡇⠀⠀⠀⠀⠀⠀⠈⢢⠀⠀⠀");
			System.out.println("⠀⠀⠀⠀⠀⢠⣿⣿⡇⠁⢰⣿⡿⠛⢻⣿⣿⡄⠹⣿⣿⣾⣿⠟⠁⠀⠀⠀⠀⠀⠀⠀⠐⠀⠀⠀");
			System.out.println("⠀⠀⠀⠀⢀⠊⠈⠛⣿⡇⠀⢸⣿⣷⣶⣾⣿⡟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠀⠀⠀");
			System.out.println("⠀⠀⠀⢀⡅⠀⠀⠀⠈⠃⠀⠀⠉⠛⠛⠛⠁⠀⠀⠀⠀⠀⠀⠀⠀⢀⣤⣤⣤⣤⠀⠀⠀⠔⠀ ⠀");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀   ⣿⣿⣿⣿⣿⣿⠄⠀⠀ ");
			System.out.println("⠀⠀⠀⠀⠣⡀⠀⢀⠠⠒⠀⠒⠀⠤⠤⠄⠀⢀⣀⣀⣀⣀⠀⠀⠤⠛⢿⣿⡿⠟⠁⠀⠀⠀⠀⠀         ⢰⣶⣶⣶⣶⣶⣶⣷⣾⣿⣿⣿⡿⣿⣿⣿⠛⠛⠛⠛⠛⠋⢛⣁⣀⣤⣄⠀");
			System.out.println("                                                    ⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠏ ⠀");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀                                      ⠈⠙⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠋⠉⠉⠉⠁⠀  ⠀");
		} else if (n == 1) {
			System.out.println("                                     ");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣠⣤⣤⣤⣤⣾⣿⣿⣦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀    ");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣾⣿⣿⣿⣿⡛⢫⣿⣿⡿⠉⠻⣿⣿⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⣶⣿⣿⠟⠛⠿⠿⠟⠀⠈⢩⠞⠁⠀⠉⠒⡈⢣⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⣸⡿⡿⢣⠔⠘⠀⠓⢦⠀⠀⠇⣠⣴⣶⣤⣄⠀⠀⠉⠀⠈⠐⠠⠀⠀⠀⠀⠀");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⣰⣿⡇⡰⠃⢀⣴⣶⣶⣦⡀⠀⣼⣿⡟⠙⣿⣿⡇⠀⠀⠀⠀⠀⠀⠈⢢⠀⠀⠀");
			System.out.println("⠀⠀⠀⠀⠀⢠⣿⣿⡇⠁⢰⣿⡿⠛⢻⣿⣿⡄⠹⣿⣿⣾⣿⠟⠁⠀⠀⠀⠀⠀⠀⠀⠐⠀⠀⠀");
			System.out.println("⠀⠀⠀⠀⢀⠊⠈⠛⣿⡇⠀⢸⣿⣷⣶⣾⣿⡟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠀⠀⠀");
			System.out.println("⠀⠀⠀⢀⡅⠀⠀⠀⠈⠃⠀⠀⠉⠛⠛⠛⠁⠀⠀⠀⠀⠀⠀⠀⠀⢀⣤⣤⣤⣤⠀⠀⠀⠔⠀          ⠈⠁⠉⢿⣿⣿⣷⣿⣿⣿⣿⣿⣿⣿⡿⠿⠿⣿⣿⣿⣿⣿⣿⣿⠟⠟⠛⠿⠍⠀");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀   ⣿⣿⣿⣿⣿⣿⠄                ⠹⠿⠻⣿⠛⠛⠿⣿⡿⠋⠀⠀⠀⠀⠉⠀⠈⠙⠙⢿⠅    ");
			System.out.println("⠀⠀⠀⠀⠣⡀⠀⢀⠠⠒⠀⠒⠀⠤⠤⠄⠀⢀⣀⣀⣀⣀⠀⠀⠤⠛⢿⣿⡿⠟⠁⠀⠀⠀⠀⠀         ⢰⣶⣶⣶⣶⣶⣶⣷⣾⣿⣿⣿⡿⣿⣿⣿⠛⠛⠛⠛⠛⠋⢛⣁⣀⣤⣄⠀");
			System.out.println("                                                    ⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠏ ⠀");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀                                      ⠈⠙⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠋⠉⠉⠉⠁⠀  ⠀");

		} else if (n == 2) {

			System.out.println("                                     ");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣠⣤⣤⣤⣤⣾⣿⣿⣦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀    ");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣾⣿⣿⣿⣿⡛⢫⣿⣿⡿⠉⠻⣿⣿⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⣶⣿⣿⠟⠛⠿⠿⠟⠀⠈⢩⠞⠁⠀⠉⠒⡈⢣⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⣸⡿⡿⢣⠔⠘⠀⠓⢦⠀⠀⠇⣠⣴⣶⣤⣄⠀⠀⠉⠀⠈⠐⠠⠀⠀⠀⠀⠀");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⣰⣿⡇⡰⠃⢀⣴⣶⣶⣦⡀⠀⣼⣿⡟⠙⣿⣿⡇⠀⠀⠀⠀⠀⠀⠈⢢⠀⠀ ");
			System.out.println("⠀⠀⠀⠀⠀⢠⣿⣿⡇⠁⢰⣿⡿⠛⢻⣿⣿⡄⠹⣿⣿⣾⣿⠟⠁⠀⠀⠀⠀⠀⠀⠀⠐⠀⠀  ");
			System.out.println("⠀⠀⠀⠀⢀⠊⠈⠛⣿⡇⠀⢸⣿⣷⣶⣾⣿⡟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠀⠀⠀          ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
			System.out.println("⠀⠀⠀⢀⡅⠀⠀⠀⠈⠃⠀⠀⠉⠛⠛⠛⠁⠀⠀⠀⠀⠀⠀⠀⠀⢀⣤⣤⣤⣤⠀⠀⠀⠔⠀          ⠈⠁⠉⢿⣿⣿⣷⣿⣿⣿⣿⣿⣿⣿⡿⠿⠿⣿⣿⣿⣿⣿⣿⣿⠟⠟⠛⠿⠍⠀");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀   ⣿⣿⣿⣿⣿⣿⠄                ⠹⠿⠻⣿⠛⠛⠿⣿⡿⠋⠀⠀⠀⠀⠉⠀⠈⠙⠙⢿⠅    ");
			System.out.println("⠀⠀⠀⠀⠣⡀⠀⢀⠠⠒⠀⠒⠀⠤⠤⠄⠀⢀⣀⣀⣀⣀⠀⠀⠤⠛⢿⣿⡿⠟⠁⠀⠀⠀⠀⠀         ⢰⣶⣶⣶⣶⣶⣶⣷⣾⣿⣿⣿⡿⣿⣿⣿⠛⠛⠛⠛⠛⠋⢛⣁⣀⣤⣄⠀");
			System.out.println("                                                    ⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠏ ⠀");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀                                      ⠈⠙⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠋⠉⠉⠉⠁⠀  ⠀");

		} else if (n == 3) {

			System.out.println("                                     ");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣠⣤⣤⣤⣤⣾⣿⣿⣦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀    ");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣾⣿⣿⣿⣿⡛⢫⣿⣿⡿⠉⠻⣿⣿⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⣶⣿⣿⠟⠛⠿⠿⠟⠀⠈⢩⠞⠁⠀⠉⠒⡈⢣⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⣸⡿⡿⢣⠔⠘⠀⠓⢦⠀⠀⠇⣠⣴⣶⣤⣄⠀⠀⠉⠀⠈⠐⠠⠀⠀⠀⠀⠀");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⣰⣿⡇⡰⠃⢀⣴⣶⣶⣦⡀⠀⣼⣿⡟⠙⣿⣿⡇⠀⠀⠀⠀⠀⠀⠈⢢⠀⠀ ");
			System.out.println("⠀⠀⠀⠀⠀⢠⣿⣿⡇⠁⢰⣿⡿⠛⢻⣿⣿⡄⠹⣿⣿⣾⣿⠟⠁⠀⠀⠀⠀⠀⠀⠀⠐⠀⠀           ▓█▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓█▓⠀");
			System.out.println("⠀⠀⠀⠀⢀⠊⠈⠛⣿⡇⠀⢸⣿⣷⣶⣾⣿⡟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠀⠀⠀          ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
			System.out.println("⠀⠀⠀⢀⡅⠀⠀⠀⠈⠃⠀⠀⠉⠛⠛⠛⠁⠀⠀⠀⠀⠀⠀⠀⠀⢀⣤⣤⣤⣤⠀⠀⠀⠔⠀          ⠈⠁⠉⢿⣿⣿⣷⣿⣿⣿⣿⣿⣿⣿⡿⠿⠿⣿⣿⣿⣿⣿⣿⣿⠟⠟⠛⠿⠍⠀");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀   ⣿⣿⣿⣿⣿⣿⠄                ⠹⠿⠻⣿⠛⠛⠿⣿⡿⠋⠀⠀⠀⠀⠉⠀⠈⠙⠙⢿⠅    ");
			System.out.println("⠀⠀⠀⠀⠣⡀⠀⢀⠠⠒⠀⠒⠀⠤⠤⠄⠀⢀⣀⣀⣀⣀⠀⠀⠤⠛⢿⣿⡿⠟⠁⠀⠀⠀⠀⠀         ⢰⣶⣶⣶⣶⣶⣶⣷⣾⣿⣿⣿⡿⣿⣿⣿⠛⠛⠛⠛⠛⠋⢛⣁⣀⣤⣄⠀");
			System.out.println("                                                    ⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠏ ⠀");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀                                      ⠈⠙⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠋⠉⠉⠉⠁⠀  ⠀");

		} else if (n == 4) {

			System.out.println("                                     ");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣠⣤⣤⣤⣤⣾⣿⣿⣦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀    ");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣾⣿⣿⣿⣿⡛⢫⣿⣿⡿⠉⠻⣿⣿⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⣶⣿⣿⠟⠛⠿⠿⠟⠀⠈⢩⠞⠁⠀⠉⠒⡈⢣⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⣸⡿⡿⢣⠔⠘⠀⠓⢦⠀⠀⠇⣠⣴⣶⣤⣄⠀⠀⠉⠀⠈⠐⠠⠀⠀⠀⠀⠀");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⣰⣿⡇⡰⠃⢀⣴⣶⣶⣦⡀⠀⣼⣿⡟⠙⣿⣿⡇⠀⠀⠀⠀⠀⠀⠈⢢⠀⠀           ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
			System.out.println("⠀⠀⠀⠀⠀⢠⣿⣿⡇⠁⢰⣿⡿⠛⢻⣿⣿⡄⠹⣿⣿⣾⣿⠟⠁⠀⠀⠀⠀⠀⠀⠀⠐⠀⠀           ▓█▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓█▓⠀");
			System.out.println("⠀⠀⠀⠀⢀⠊⠈⠛⣿⡇⠀⢸⣿⣷⣶⣾⣿⡟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠀⠀⠀          ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
			System.out.println("⠀⠀⠀⢀⡅⠀⠀⠀⠈⠃⠀⠀⠉⠛⠛⠛⠁⠀⠀⠀⠀⠀⠀⠀⠀⢀⣤⣤⣤⣤⠀⠀⠀⠔⠀          ⠈⠁⠉⢿⣿⣿⣷⣿⣿⣿⣿⣿⣿⣿⡿⠿⠿⣿⣿⣿⣿⣿⣿⣿⠟⠟⠛⠿⠍⠀");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀   ⣿⣿⣿⣿⣿⣿⠄                ⠹⠿⠻⣿⠛⠛⠿⣿⡿⠋⠀⠀⠀⠀⠉⠀⠈⠙⠙⢿⠅    ");
			System.out.println("⠀⠀⠀⠀⠣⡀⠀⢀⠠⠒⠀⠒⠀⠤⠤⠄⠀⢀⣀⣀⣀⣀⠀⠀⠤⠛⢿⣿⡿⠟⠁⠀⠀⠀⠀⠀         ⢰⣶⣶⣶⣶⣶⣶⣷⣾⣿⣿⣿⡿⣿⣿⣿⠛⠛⠛⠛⠛⠋⢛⣁⣀⣤⣄⠀");
			System.out.println("                                                    ⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠏ ⠀");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀                                      ⠈⠙⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠋⠉⠉⠉⠁⠀  ⠀");
		}

		else if (n == 5) {

			System.out.println("                                     ");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣠⣤⣤⣤⣤⣾⣿⣿⣦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀    ");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣾⣿⣿⣿⣿⡛⢫⣿⣿⡿⠉⠻⣿⣿⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⣶⣿⣿⠟⠛⠿⠿⠟⠀⠈⢩⠞⠁⠀⠉⠒⡈⢣⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⣸⡿⡿⢣⠔⠘⠀⠓⢦⠀⠀⠇⣠⣴⣶⣤⣄⠀⠀⠉⠀⠈⠐⠠⠀⠀⠀⠀⠀          ▓▓▓▓▓▓▓▓▓▓▓▓▓▓████▓▓▓▓▓▓▓▓▓▓▓▓");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⣰⣿⡇⡰⠃⢀⣴⣶⣶⣦⡀⠀⣼⣿⡟⠙⣿⣿⡇⠀⠀⠀⠀⠀⠀⠈⢢⠀⠀           ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
			System.out.println("⠀⠀⠀⠀⠀⢠⣿⣿⡇⠁⢰⣿⡿⠛⢻⣿⣿⡄⠹⣿⣿⣾⣿⠟⠁⠀⠀⠀⠀⠀⠀⠀⠐⠀⠀           ▓█▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓█▓⠀");
			System.out.println("⠀⠀⠀⠀⢀⠊⠈⠛⣿⡇⠀⢸⣿⣷⣶⣾⣿⡟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠀⠀⠀          ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
			System.out.println("⠀⠀⠀⢀⡅⠀⠀⠀⠈⠃⠀⠀⠉⠛⠛⠛⠁⠀⠀⠀⠀⠀⠀⠀⠀⢀⣤⣤⣤⣤⠀⠀⠀⠔⠀          ⠈⠁⠉⢿⣿⣿⣷⣿⣿⣿⣿⣿⣿⣿⡿⠿⠿⣿⣿⣿⣿⣿⣿⣿⠟⠟⠛⠿⠍⠀");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀   ⣿⣿⣿⣿⣿⣿⠄                ⠹⠿⠻⣿⠛⠛⠿⣿⡿⠋⠀⠀⠀⠀⠉⠀⠈⠙⠙⢿⠅    ");
			System.out.println("⠀⠀⠀⠀⠣⡀⠀⢀⠠⠒⠀⠒⠀⠤⠤⠄⠀⢀⣀⣀⣀⣀⠀⠀⠤⠛⢿⣿⡿⠟⠁⠀⠀⠀⠀⠀         ⢰⣶⣶⣶⣶⣶⣶⣷⣾⣿⣿⣿⡿⣿⣿⣿⠛⠛⠛⠛⠛⠋⢛⣁⣀⣤⣄⠀");
			System.out.println("                                                    ⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠏ ⠀");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀                                      ⠈⠙⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠋⠉⠉⠉⠁⠀  ⠀");

		}

		else if (n == 6) {

			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣠⣤⣤⣤⣤⣾⣿⣿⣦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀    ");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣾⣿⣿⣿⣿⡛⢫⣿⣿⡿⠉⠻⣿⣿⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⣶⣿⣿⠟⠛⠿⠿⠟⠀⠈⢩⠞⠁⠀⠉⠒⡈⢣⠀⠀⠀⠀⠀⠀⠀⠀⠀            ░░▒▒▒▒▒▒░░░░░░░░░░░░░░▒▒▒▒▒▒░░⠀");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⣸⡿⡿⢣⠔⠘⠀⠓⢦⠀⠀⠇⣠⣴⣶⣤⣄⠀⠀⠉⠀⠈⠐⠠⠀⠀⠀⠀⠀          ▓▓▓▓▓▓▓▓▓▓▓▓▓▓████▓▓▓▓▓▓▓▓▓▓▓▓");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⣰⣿⡇⡰⠃⢀⣴⣶⣶⣦⡀⠀⣼⣿⡟⠙⣿⣿⡇⠀⠀⠀⠀⠀⠀⠈⢢⠀⠀           ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
			System.out.println("⠀⠀⠀⠀⠀⢠⣿⣿⡇⠁⢰⣿⡿⠛⢻⣿⣿⡄⠹⣿⣿⣾⣿⠟⠁⠀⠀⠀⠀⠀⠀⠀⠐⠀⠀           ▓█▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓█▓⠀");
			System.out.println("⠀⠀⠀⠀⢀⠊⠈⠛⣿⡇⠀⢸⣿⣷⣶⣾⣿⡟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠀⠀⠀          ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
			System.out.println("⠀⠀⠀⢀⡅⠀⠀⠀⠈⠃⠀⠀⠉⠛⠛⠛⠁⠀⠀⠀⠀⠀⠀⠀⠀⢀⣤⣤⣤⣤⠀⠀⠀⠔⠀          ⠈⠁⠉⢿⣿⣿⣷⣿⣿⣿⣿⣿⣿⣿⡿⠿⠿⣿⣿⣿⣿⣿⣿⣿⠟⠟⠛⠿⠍⠀");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀   ⣿⣿⣿⣿⣿⣿⠄                ⠹⠿⠻⣿⠛⠛⠿⣿⡿⠋⠀⠀⠀⠀⠉⠀⠈⠙⠙⢿⠅    ");
			System.out.println("⠀⠀⠀⠀⠣⡀⠀⢀⠠⠒⠀⠒⠀⠤⠤⠄⠀⢀⣀⣀⣀⣀⠀⠀⠤⠛⢿⣿⡿⠟⠁⠀⠀⠀⠀⠀         ⢰⣶⣶⣶⣶⣶⣶⣷⣾⣿⣿⣿⡿⣿⣿⣿⠛⠛⠛⠛⠛⠋⢛⣁⣀⣤⣄⠀");
			System.out.println("                                                    ⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠏ ⠀");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀                                      ⠈⠙⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠋⠉⠉⠉⠁⠀  ⠀");
		}

		else if (n == 7) {

			System.out.println("                                                        ⢀⣠⣤⣶⣶⣶⣾⣿⣽⣿⣷⣿⣷⣢⠽⢷⣶⣤⢀ ");
			System.out.println("                                                     ⣠⣶⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡗⢾⣿⣧⣷⢵⣦⡀");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣠⣤⣤⣤⣤⣾⣿⣿⣦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀              ⠸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣾⡆");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣾⣿⣿⣿⣿⡛⢫⣿⣿⡿⠉⠻⣿⣿⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀          ⣻⢿⣿⣿⣿⣿⣿⣭⣽⣿⣿⣦⣤⣴⣾⣭⣭⣭⣉⠙⡛⠛⠻⠿⠿⡗⠀");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⣶⣿⣿⠟⠛⠿⠿⠟⠀⠈⢩⠞⠁⠀⠉⠒⡈⢣⠀⠀⠀⠀⠀⠀⠀⠀⠀            ░░▒▒▒▒▒▒░░░░░░░░░░░░░░▒▒▒▒▒▒░░⠀");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⣸⡿⡿⢣⠔⠘⠀⠓⢦⠀⠀⠇⣠⣴⣶⣤⣄⠀⠀⠉⠀⠈⠐⠠⠀⠀⠀⠀⠀          ▓▓▓▓▓▓▓▓▓▓▓▓▓▓████▓▓▓▓▓▓▓▓▓▓▓▓");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⣰⣿⡇⡰⠃⢀⣴⣶⣶⣦⡀⠀⣼⣿⡟⠙⣿⣿⡇⠀⠀⠀⠀⠀⠀⠈⢢⠀⠀           ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
			System.out.println("⠀⠀⠀⠀⠀⢠⣿⣿⡇⠁⢰⣿⡿⠛⢻⣿⣿⡄⠹⣿⣿⣾⣿⠟⠁⠀⠀⠀⠀⠀⠀⠀⠐⠀⠀           ▓█▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓█▓⠀");
			System.out.println("⠀⠀⠀⠀⢀⠊⠈⠛⣿⡇⠀⢸⣿⣷⣶⣾⣿⡟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠀⠀⠀          ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
			System.out.println("⠀⠀⠀⢀⡅⠀⠀⠀⠈⠃⠀⠀⠉⠛⠛⠛⠁⠀⠀⠀⠀⠀⠀⠀⠀⢀⣤⣤⣤⣤⠀⠀⠀⠔⠀          ⠈⠁⠉⢿⣿⣿⣷⣿⣿⣿⣿⣿⣿⣿⡿⠿⠿⣿⣿⣿⣿⣿⣿⣿⠟⠟⠛⠿⠍⠀");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀   ⣿⣿⣿⣿⣿⣿⠄                ⠹⠿⠻⣿⠛⠛⠿⣿⡿⠋⠀⠀⠀⠀⠉⠀⠈⠙⠙⢿⠅    ");
			System.out.println("⠀⠀⠀⠀⠣⡀⠀⢀⠠⠒⠀⠒⠀⠤⠤⠄⠀⢀⣀⣀⣀⣀⠀⠀⠤⠛⢿⣿⡿⠟⠁⠀⠀⠀⠀⠀         ⢰⣶⣶⣶⣶⣶⣶⣷⣾⣿⣿⣿⡿⣿⣿⣿⠛⠛⠛⠛⠛⠋⢛⣁⣀⣤⣄⠀");
			System.out.println("                                                    ⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠏ ⠀");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀                                      ⠈⠙⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠋⠉⠉⠉⠁⠀  ⠀");
		}

	}

	public void countDown() {

		System.out.println("\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n");
		System.out.println("       ` ` ` ``` ` `      ");
		System.out.println("      ``##########``      ");
		System.out.println(" ```#################`    ");
		System.out.println("  `#####`        #####``` ");
		System.out.println("  ` ``   `   ` `  `####` `");
		System.out.println("                `  `####  ");
		System.out.println("                `  `#### `");
		System.out.println("                  `####` `");
		System.out.println("       `    ``  `#####`   ");
		System.out.println("         ###########``    ");
		System.out.println("         ###########`     ");
		System.out.println("             `  `#####` ` ");
		System.out.println("             ```   `####  ");
		System.out.println("                    ##### ");
		System.out.println("                    `####`");
		System.out.println("                    `#### ");
		System.out.println("    ```          `  ##### ");
		System.out.println("` ####`` `       `######  ");
		System.out.println("  `###################``  ");
		System.out.println("    ``#############` `    ");
		System.out.println("     ` ``   `   `` `  `   ");
		System.out.println("\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n");
		timeSleep(2000);
		
		System.out.println("\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n");
		System.out.println("         `` ` `  `        ");
		System.out.println("       ``########`        ");
		System.out.println("     ################``   ");
		System.out.println("  `######`     ``######   ");
		System.out.println("  ##### `  ` ```   #####``");
		System.out.println(" ` `##             `####  ");
		System.out.println("                `   ####``");
		System.out.println("                    ####` ");
		System.out.println("                 ` ##### `");
		System.out.println("                ``#####` `");
		System.out.println("                `#####`   ");
		System.out.println("           `  `#####` `   ");
		System.out.println("             #####````    ");
		System.out.println("           ######         ");
		System.out.println("    `` ```#####`          ");
		System.out.println("     ` `##### `           ");
		System.out.println("  ` ``#####``             ");
		System.out.println("   `#####  ``             ");
		System.out.println("  `###################### ");
		System.out.println("  `######################`");
		System.out.println("`  `                   `` ");
		System.out.println("\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n");
		timeSleep(2000);
		
		System.out.println("\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n");
		System.out.println("           `    ``        ");
		System.out.println("            `####`        ");
		System.out.println("         `#######         ");
		System.out.println("    ` `##########         ");
		System.out.println("     #####`  ####         ");
		System.out.println("     `#``` ` ####         ");
		System.out.println("           ` ####         ");
		System.out.println("           ` ####         ");
		System.out.println("           ` ####         ");
		System.out.println("           ` ####         ");
		System.out.println("           ` ####         ");
		System.out.println("           ` ####         ");
		System.out.println("           ` ####         ");
		System.out.println("           ` ####         ");
		System.out.println("           ` ####         ");
		System.out.println("           ` ####         ");
		System.out.println("           ` ####         ");
		System.out.println("           ` ####         ");
		System.out.println("           ` ####         ");
		System.out.println("          `` ####` `      ");
		System.out.println("                  `       ");
		System.out.println("\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n");
		timeSleep(2000);
	}
	
	public void timeSleep(int n) {
		try {
			Thread.sleep(n); // 1000 = 1초
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
