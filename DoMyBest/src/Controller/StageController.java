package Controller;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import Model.CustomerDAO;
import Model.MemberDAO;
import javazoom.jl.player.MP3Player;

public class StageController {
	int money = 0;
	Random ran = new Random();
	Scanner scan = new Scanner(System.in);
	CustomerDAO cdao = new CustomerDAO();
	MP3Player mp3 = new MP3Player();
	MemberDAO mdao = new MemberDAO();

	public void stageStart() { // 스테이지 시작메소드 ( 60초 )
		int score = 0;
		mp3.play("C:/Users/smhrd/git/DoMyBest/DoMyBest/Music/bgm.mp3");
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
			mp3.play("C:/Users/smhrd/git/DoMyBest/DoMyBest/Music/bell.mp3");
//			mp3.play("C:/Users/sh/git/DoMyBest/DoMyBest/Music/bell.mp3"); // 수환 개인컴퓨터용
			score = solveP();

		}
		mp3.play("C:/Users/smhrd/git/DoMyBest/DoMyBest/Music/clear.mp3");
		
		
		
		while (true) {
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

	}

	public int solveP() { // 문제 푸는 메소드
		
		long startTime = System.currentTimeMillis();
		long endTime = startTime + TimeUnit.SECONDS.toMillis(15);
		long endTime2 = startTime + TimeUnit.SECONDS.toMillis(10);// 시간제한 5초
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
							if (j < recipeList.length - 1) {
								System.out.print(questionList[k] + " ☞ ");
							} else {
								System.out.print(questionList[k]);
							}
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
				if (System.currentTimeMillis() > endTime2) { // 지정한 시간을 넘어서 답을 쓴경우 타임아웃
					mp3.play("C:/Users/smhrd/git/DoMyBest/DoMyBest/Music/fail.mp3");
					System.out.println("\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n"
							+ "\n" + "\n" + "\n" + "\n" + "                  시간이 초과했어요. 손님이 집으로 돌아갔어요   ŏ̥̥̥̥םŏ̥̥̥̥  "
							+ "\n" + "                      ∧＿∧" + "\n" + "                    ( ´ •̥̥̥ ω •̥̥̥ )  ❀"
							+ "\n" + "                  ,, ( ヽ∩∩ ) ,, ヽ|〃 ,,," + "\n" + "\n" + "\n" + "\n" + "\n" + "\n"
							+ "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n");
					timeSleep(2000);
					break;
				}
				if ((char) (answerList.get(i) + '0') == recipeList[i]) {
					System.out.println("          ʚ(*´꒳`*)ɞ ~♡ 정답! 다음 재료번호 입력해주세요!" + "");
					System.out
							.println("\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n");
					mp3.play("C:/Users/smhrd/git/DoMyBest/DoMyBest/Music/chap.mp3");
//					mp3.play("C:/Users/sh/git/DoMyBest/DoMyBest/Music/chap.mp3"); // 수환 개인컴퓨터용
					if (cdao.cList().get(temp).getDifficult().equals("EASY")) {
						easyLine(i); // 햄버거 쌓이는 시각효과 메서드
					} else if (cdao.cList().get(temp).getDifficult().equals("NORMAL")) {
						normalLine(i);
					} else if (cdao.cList().get(temp).getDifficult().equals("HARD")) {
						hardLine(i);
					}
					if (i == (recipeList.length - 1)) {

						if (cdao.cList().get(temp).getDifficult().equals("EASY")) {
							money += 10;
						} else if (cdao.cList().get(temp).getDifficult().equals("NORMAL")) {
							money += 15;
						} else if (cdao.cList().get(temp).getDifficult().equals("HARD")) {
							money += 20;
						}
						mp3.play("C:/Users/smhrd/git/DoMyBest/DoMyBest/Music/success.mp3");
						System.out.println("                 ＊ ( ・´з`・)／성공 ~ 맛있는 버거가 만들어졌어요! "
								+ "\n" + "\n" + "                        냠냠 너무 맛있을 것 같아요~" + "\n" + "현재금액 : " + money
								+ "$" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n"
								+ "\n" + "\n" + "\n" + "\n" + "\n" + "\n");

						timeSleep(2000);
					}
				} else {
					mp3.play("C:/Users/smhrd/git/DoMyBest/DoMyBest/Music/fail.mp3");
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
		return money;

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
			System.out
					.println("⠀⠀⠀⠀⢸⣿⣿⣯⣤⣤⣤⣤⣤⡄⠀⠀⠀⠀⠉⢹⡄⠀⠀⠀⠛⠛⠋⠉⠹⡇                     ░░░░░░░░░░░░░░░░░░░░░░░░░░         ");

			System.out.println("⠀⠀⠀⠀⢸⣿⣿⠀⠀⠀⣀⣠⣤⣤⣤⣤⣤⣤⣤⣼⣇⣀⣀⣀⣛⣛⣒⣲⢾⡷              ⠀⠀⠀⠀⠀⠈⠁⠉⢿⣿⣿⣷⣿⣿⣿⣿⣿⣿⣿⡿⠿⠿⣿⣿⣿⣿⣿⣿⣿⠟⠟⠛⠿⠍ ⠀⠀⠀⠀⠀");
			System.out.println("⢀⠤⠒⠒⢼⣿⣿⠶⠞⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠁⠀⣼⠃        ⠀⠀⠀⠀⠀⠀⠀    ⠀  ⠹⠿⠻⣿⠛⠛⠿⣿⡿⠋⠀⠀⠀⠀⠉⠀⠈⠙⠙⢿⠅⠀⠀⠀⠀⠀⠀⠀⠀");
			System.out.println("⢮⠀⠀⠀⠀⣿⣿⣆⠀⠀⠻⣿⡿⠛⠉⠉⠁⠀⠉⠉⠛⠿⣿⣿⠟⠁⠀⣼⠃⠀              ⠀⠀⠀⠀⠀⠀⢰⣶⣶⣶⣶⣶⣶⣷⣾⣿⣿⣿⡿⣿⣿⣿⠛⠛⠛⠛⠛⠋⢛⣁⣀⣤⣄⠀⠀⠀⠀⠀⠀⠀");
			System.out.println("⠈⠓⠶⣶⣾⣿⣿⣿⣧⡀⠀⠈⠒⢤⣀⣀⡀⠀⠀⣀⣀⡠⠚⠁⠀⢀⡼⠃⠀⠀               ⠀⠀⠀⠀⠀⠀⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠏⠀⠀⠀⠀⠀⠀⠀");
			System.out.println("⠀⠀⠀⠈⢿⣿⣿⣿⣿⣿⣷⣤⣤⣤⣤⣭⣭⣭⣭⣭⣥⣤⣤⣤⣴⣟⠁⠀                        ⠈⠙⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠋⠉⠉⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
		} else if (n == 3) {
			System.out.println("⠄⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⣤⣴⣶⣶⣶⣶⣶⠶⣶⣤⣤⣀⠀⠀⠀⠀⠀⠀");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⢀⣤⣾⣿⣿⣿⠁⠀⢀⠈⢿⢀⣀⠀⠹⣿⣿⣿⣦⣄⠀⠀⠀");
			System.out.println("⠀⠀⠀⠀⠀⠀⣴⣿⣿⣿⣿⣿⠿⠀⠀⣟⡇⢘⣾⣽⠀⠀⡏⠉⠙⢛⣿⣷⡖⠀");
			System.out.println("⠀⠀⠀⠀⠀⣾⣿⣿⡿⠿⠷⠶⠤⠙⠒⠀⠒⢻⣿⣿⡷⠋⠀⠴⠞⠋⠁⢙⣿⣄                   ▓▓▓▓▓▓▓▓▓▓▓▓▓▓██▓▓▓▓▓▓▓▓▓▓▓▓⠀⠀⠀⠀⠀⠀⠀⠀");

			System.out
					.println("⠀⠀⠀⠀⢸⣿⣿⣯⣤⣤⣤⣤⣤⡄⠀⠀⠀⠀⠉⢹⡄⠀⠀⠀⠛⠛⠋⠉⠹⡇                     ░░░░░░░░░░░░░░░░░░░░░░░░░░         ");

			System.out.println("⠀⠀⠀⠀⢸⣿⣿⠀⠀⠀⣀⣠⣤⣤⣤⣤⣤⣤⣤⣼⣇⣀⣀⣀⣛⣛⣒⣲⢾⡷              ⠀⠀⠀⠀⠀⠈⠁⠉⢿⣿⣿⣷⣿⣿⣿⣿⣿⣿⣿⡿⠿⠿⣿⣿⣿⣿⣿⣿⣿⠟⠟⠛⠿⠍ ⠀⠀⠀⠀⠀");
			System.out.println("⢀⠤⠒⠒⢼⣿⣿⠶⠞⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠁⠀⣼⠃        ⠀⠀⠀⠀⠀⠀⠀    ⠀  ⠹⠿⠻⣿⠛⠛⠿⣿⡿⠋⠀⠀⠀⠀⠉⠀⠈⠙⠙⢿⠅⠀⠀⠀⠀⠀⠀⠀⠀");
			System.out.println("⢮⠀⠀⠀⠀⣿⣿⣆⠀⠀⠻⣿⡿⠛⠉⠉⠁⠀⠉⠉⠛⠿⣿⣿⠟⠁⠀⣼⠃⠀              ⠀⠀⠀⠀⠀⠀⢰⣶⣶⣶⣶⣶⣶⣷⣾⣿⣿⣿⡿⣿⣿⣿⠛⠛⠛⠛⠛⠋⢛⣁⣀⣤⣄⠀⠀⠀⠀⠀⠀⠀");
			System.out.println("⠈⠓⠶⣶⣾⣿⣿⣿⣧⡀⠀⠈⠒⢤⣀⣀⡀⠀⠀⣀⣀⡠⠚⠁⠀⢀⡼⠃⠀⠀               ⠀⠀⠀⠀⠀⠀⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠏⠀⠀⠀⠀⠀⠀⠀");
			System.out.println("⠀⠀⠀⠈⢿⣿⣿⣿⣿⣿⣷⣤⣤⣤⣤⣭⣭⣭⣭⣭⣥⣤⣤⣤⣴⣟⠁⠀                        ⠈⠙⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠋⠉⠉⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
		} else if (n == 4) {
			System.out.println("                                             ⠀⠀⠀⠀⠀⠀⠀    ⠀⠀⠀⠀⠀⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀  ⠀⠀⠀⠀");
			System.out.println("                                                    ⢀⣠⣤⣶⣶⣶⣾⣿⣽⣿⣷⣿⣷⣢⠽⢷⣶⣤⢀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
			System.out.println("⠄⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⣤⣴⣶⣶⣶⣶⣶⠶⣶⣤⣤⣀⠀⠀⠀⠀⠀⠀               ⠀⠀⠀ ⠀⠀⠀⣠⣶⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡗⢾⣿⣧⣷⢵⣦⡀⠀⠀⠀⠀⠀⠀⠀⠀");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⢀⣤⣾⣿⣿⣿⠁⠀⢀⠈⢿⢀⣀⠀⠹⣿⣿⣿⣦⣄⠀⠀⠀              ⠀⠀⠀  ⠀⠀⠸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣾⡆⠀⠀⠀⠀⠀⠀⠀");
			System.out.println("⠀⠀⠀⠀⠀⠀⣴⣿⣿⣿⣿⣿⠿⠀⠀⣟⡇⢘⣾⣽⠀⠀⡏⠉⠙⢛⣿⣷⡖⠀              ⠀⠀   ⠀⠀⣻⢿⣿⣿⣿⣿⣿⣭⣽⣿⣿⣦⣤⣴⣾⣭⣭⣭⣉⠙⡛⠛⠻⠿⠿⡗⠀⠀⠀⠀⠀⠀⠀");

			System.out.println("⠀⠀⠀⠀⠀⣾⣿⣿⡿⠿⠷⠶⠤⠙⠒⠀⠒⢻⣿⣿⡷⠋⠀⠴⠞⠋⠁⢙⣿⣄                   ▓▓▓▓▓▓▓▓▓▓▓▓▓▓██▓▓▓▓▓▓▓▓▓▓▓▓⠀⠀⠀⠀⠀⠀⠀⠀");

			System.out
					.println("⠀⠀⠀⠀⢸⣿⣿⣯⣤⣤⣤⣤⣤⡄⠀⠀⠀⠀⠉⢹⡄⠀⠀⠀⠛⠛⠋⠉⠹⡇                     ░░░░░░░░░░░░░░░░░░░░░░░░░░         ");

			System.out.println("⠀⠀⠀⠀⢸⣿⣿⠀⠀⠀⣀⣠⣤⣤⣤⣤⣤⣤⣤⣼⣇⣀⣀⣀⣛⣛⣒⣲⢾⡷              ⠀⠀⠀⠀⠀⠈⠁⠉⢿⣿⣿⣷⣿⣿⣿⣿⣿⣿⣿⡿⠿⠿⣿⣿⣿⣿⣿⣿⣿⠟⠟⠛⠿⠍ ⠀⠀⠀⠀⠀");
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
					"⠀⠀⠀⠀⠈⠻⢿⣛⠁⠀⠀⠀⠀⠑⢄⡠⠊⠀⠀⠀⠀⠈⣛⡿⠟⠁⠀⠀⠀                         ⢰⣶⣶⣶⣶⣶⣶⣷⣾⣿⣿⣿⡿⣿⣿⣿⠛⠛⠛⠛⠛⠋⢛⣁⣀⣤⣄⠀⠀⠀⠀⠀⠀⠀⠀");
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
					"⠀⠀⠀⠀⠈⠻⢿⣛⠁⠀⠀⠀⠀⠑⢄⡠⠊⠀⠀⠀⠀⠈⣛⡿⠟⠁⠀⠀⠀                         ⢰⣶⣶⣶⣶⣶⣶⣷⣾⣿⣿⣿⡿⣿⣿⣿⠛⠛⠛⠛⠛⠋⢛⣁⣀⣤⣄⠀⠀⠀⠀⠀⠀⠀⠀");
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
					"⠀⠀⠀⢀⡟⣀⣤⣌⡙⠋⠁⠀⠀⠀⠺⠗⠀⠀⠀⠈⠙⢋⣡⣤⣀⢻⡀⠀⠀                       ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒      ");

			System.out.println(
					"⠀⠀⠀⢸⣿⣿⣿⣿⣿⡄⠀⠰⢤⣤⠾⠷⣤⡤⠆⠀⢠⣿⣿⣿⣿⣿⡇⠀⠀                       ⠀⠈⠁⠉⢿⣿⣿⣷⣿⣿⣿⣿⣿⣿⣿⡿⠿⠿⣿⣿⣿⣿⣿⣿⣿⠟⠟⠛⠿⠍⠀⠀⠀⠀⠀⠀⠀");
			System.out.println(
					"⠀⠀⠀⠈⢿⣿⣿⣿⣿⠇⠀⠀⠘⡇⠀⠀⢸⠃⠀⠀⠸⣿⣿⣿⣿⡿⠁⠀⠀⠀                         ⠀⠀  ⠹⠿⠻⣿⠛⠛⠿⣿⡿⠋⠀⠀⠀⠀⠉⠀⠈⠙⠙⢿⠅⠀⠀⠀⠀⠀⠀⠀⠀   ");

			System.out.println(
					"⠀⠀⠀⠀⠈⠻⢿⣛⠁⠀⠀⠀⠀⠑⢄⡠⠊⠀⠀⠀⠀⠈⣛⡿⠟⠁⠀⠀⠀                         ⢰⣶⣶⣶⣶⣶⣶⣷⣾⣿⣿⣿⡿⣿⣿⣿⠛⠛⠛⠛⠛⠋⢛⣁⣀⣤⣄⠀⠀⠀⠀⠀⠀⠀⠀");
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
					"⠀⠀⠀⠀⢸⠀⠀⣿⣿⣤⣾⠃⠀⠀⠀⠀⠀⠀⠘⣷⣴⣿⣿⠀⠀⡇⠀⠀⠀                          ░░░░░░░░░░░░░░░░░░░░░░░░░░░░⠀        ");

			System.out.println(
					"⠀⠀⠀⢀⡟⣀⣤⣌⡙⠋⠁⠀⠀⠀⠺⠗⠀⠀⠀⠈⠙⢋⣡⣤⣀⢻⡀⠀⠀                       ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒      ");

			System.out.println(
					"⠀⠀⠀⢸⣿⣿⣿⣿⣿⡄⠀⠰⢤⣤⠾⠷⣤⡤⠆⠀⢠⣿⣿⣿⣿⣿⡇⠀⠀                       ⠀⠈⠁⠉⢿⣿⣿⣷⣿⣿⣿⣿⣿⣿⣿⡿⠿⠿⣿⣿⣿⣿⣿⣿⣿⠟⠟⠛⠿⠍⠀⠀⠀⠀⠀⠀⠀");
			System.out.println(
					"⠀⠀⠀⠈⢿⣿⣿⣿⣿⠇⠀⠀⠘⡇⠀⠀⢸⠃⠀⠀⠸⣿⣿⣿⣿⡿⠁⠀⠀⠀                         ⠀⠀  ⠹⠿⠻⣿⠛⠛⠿⣿⡿⠋⠀⠀⠀⠀⠉⠀⠈⠙⠙⢿⠅⠀⠀⠀⠀⠀⠀⠀⠀   ");

			System.out.println(
					"⠀⠀⠀⠀⠈⠻⢿⣛⠁⠀⠀⠀⠀⠑⢄⡠⠊⠀⠀⠀⠀⠈⣛⡿⠟⠁⠀⠀⠀                         ⢰⣶⣶⣶⣶⣶⣶⣷⣾⣿⣿⣿⡿⣿⣿⣿⠛⠛⠛⠛⠛⠋⢛⣁⣀⣤⣄⠀⠀⠀⠀⠀⠀⠀⠀");
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
					"⠀⠀⠀⠀⢸⠃⠀⣴⣾⠓⢢⠀⠀⠀⠀⠀⠀⠀⠀⡔⠚⣷⣦⠀⠘⡇⠀⠀⠀⠀                          ▓▓▓▓▓▓▓▓▓▓▓▓███▓▓▓▓▓▓▓▓▓▓▓⠀        ⠀");

			System.out.println(
					"⠀⠀⠀⠀⢸⠀⠀⣿⣿⣤⣾⠃⠀⠀⠀⠀⠀⠀⠘⣷⣴⣿⣿⠀⠀⡇⠀⠀⠀                          ░░░░░░░░░░░░░░░░░░░░░░░░░░░░⠀        ");

			System.out.println(
					"⠀⠀⠀⢀⡟⣀⣤⣌⡙⠋⠁⠀⠀⠀⠺⠗⠀⠀⠀⠈⠙⢋⣡⣤⣀⢻⡀⠀⠀                       ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒      ");

			System.out.println(
					"⠀⠀⠀⢸⣿⣿⣿⣿⣿⡄⠀⠰⢤⣤⠾⠷⣤⡤⠆⠀⢠⣿⣿⣿⣿⣿⡇⠀⠀                       ⠀⠈⠁⠉⢿⣿⣿⣷⣿⣿⣿⣿⣿⣿⣿⡿⠿⠿⣿⣿⣿⣿⣿⣿⣿⠟⠟⠛⠿⠍⠀⠀⠀⠀⠀⠀⠀");
			System.out.println(
					"⠀⠀⠀⠈⢿⣿⣿⣿⣿⠇⠀⠀⠘⡇⠀⠀⢸⠃⠀⠀⠸⣿⣿⣿⣿⡿⠁⠀⠀⠀                         ⠀⠀  ⠹⠿⠻⣿⠛⠛⠿⣿⡿⠋⠀⠀⠀⠀⠉⠀⠈⠙⠙⢿⠅⠀⠀⠀⠀⠀⠀⠀⠀   ");

			System.out.println(
					"⠀⠀⠀⠀⠈⠻⢿⣛⠁⠀⠀⠀⠀⠑⢄⡠⠊⠀⠀⠀⠀⠈⣛⡿⠟⠁⠀⠀⠀                         ⢰⣶⣶⣶⣶⣶⣶⣷⣾⣿⣿⣿⡿⣿⣿⣿⠛⠛⠛⠛⠛⠋⢛⣁⣀⣤⣄⠀⠀⠀⠀⠀⠀⠀⠀");
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
					"⠀⠀⠀⠀⢀⡟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢻⡀⠀⠀⠀⠀                          ░░░░▒▒▒▒▒▒░░░░░░░▒▒▒▒▒▒░░░░          ");

			System.out.println(
					"⠀⠀⠀⠀⢸⠃⠀⣴⣾⠓⢢⠀⠀⠀⠀⠀⠀⠀⠀⡔⠚⣷⣦⠀⠘⡇⠀⠀⠀⠀                          ▓▓▓▓▓▓▓▓▓▓▓▓███▓▓▓▓▓▓▓▓▓▓▓⠀        ⠀");

			System.out.println(
					"⠀⠀⠀⠀⢸⠀⠀⣿⣿⣤⣾⠃⠀⠀⠀⠀⠀⠀⠘⣷⣴⣿⣿⠀⠀⡇⠀⠀⠀                          ░░░░░░░░░░░░░░░░░░░░░░░░░░░░⠀        ");

			System.out.println(
					"⠀⠀⠀⢀⡟⣀⣤⣌⡙⠋⠁⠀⠀⠀⠺⠗⠀⠀⠀⠈⠙⢋⣡⣤⣀⢻⡀⠀⠀                       ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒      ");

			System.out.println(
					"⠀⠀⠀⢸⣿⣿⣿⣿⣿⡄⠀⠰⢤⣤⠾⠷⣤⡤⠆⠀⢠⣿⣿⣿⣿⣿⡇⠀⠀                       ⠀⠈⠁⠉⢿⣿⣿⣷⣿⣿⣿⣿⣿⣿⣿⡿⠿⠿⣿⣿⣿⣿⣿⣿⣿⠟⠟⠛⠿⠍⠀⠀⠀⠀⠀⠀⠀");
			System.out.println(
					"⠀⠀⠀⠈⢿⣿⣿⣿⣿⠇⠀⠀⠘⡇⠀⠀⢸⠃⠀⠀⠸⣿⣿⣿⣿⡿⠁⠀⠀⠀                         ⠀⠀  ⠹⠿⠻⣿⠛⠛⠿⣿⡿⠋⠀⠀⠀⠀⠉⠀⠈⠙⠙⢿⠅⠀⠀⠀⠀⠀⠀⠀⠀   ");

			System.out.println(
					"⠀⠀⠀⠀⠈⠻⢿⣛⠁⠀⠀⠀⠀⠑⢄⡠⠊⠀⠀⠀⠀⠈⣛⡿⠟⠁⠀⠀⠀                         ⢰⣶⣶⣶⣶⣶⣶⣷⣾⣿⣿⣿⡿⣿⣿⣿⠛⠛⠛⠛⠛⠋⢛⣁⣀⣤⣄⠀⠀⠀⠀⠀⠀⠀⠀");
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
					"⠀⠀⠘⢿⡇⠀⠀⠀⠘⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠃⠀⠀⠀⢸⡿⠃⠀⠀               ⠀⠀⠀     ⠀⠀⠀⠸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣾⡆⠀⠀⠀⠀ ⠀⠀⠀ ");
			System.out.println(
					"⠀⠀⠀⠈⠛⢶⠏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠹⡶⠛⠁⠀⠀⠀              ⠀⠀⠀⠀⠀      ⠀⣻⢿⣿⣿⣿⣿⣿⣭⣽⣿⣿⣦⣤⣴⣾⣭⣭⣭⣉⠙⡛⠛⠻⠿⠿⡗⠀        ");

			System.out.println(
					"⠀⠀⠀⠀⢀⡟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢻⡀⠀⠀⠀⠀                          ░░░░▒▒▒▒▒▒░░░░░░░▒▒▒▒▒▒░░░░          ");

			System.out.println(
					"⠀⠀⠀⠀⢸⠃⠀⣴⣾⠓⢢⠀⠀⠀⠀⠀⠀⠀⠀⡔⠚⣷⣦⠀⠘⡇⠀⠀⠀⠀                          ▓▓▓▓▓▓▓▓▓▓▓▓███▓▓▓▓▓▓▓▓▓▓▓⠀        ⠀");

			System.out.println(
					"⠀⠀⠀⠀⢸⠀⠀⣿⣿⣤⣾⠃⠀⠀⠀⠀⠀⠀⠘⣷⣴⣿⣿⠀⠀⡇⠀⠀⠀                          ░░░░░░░░░░░░░░░░░░░░░░░░░░░░⠀        ");

			System.out.println(
					"⠀⠀⠀⢀⡟⣀⣤⣌⡙⠋⠁⠀⠀⠀⠺⠗⠀⠀⠀⠈⠙⢋⣡⣤⣀⢻⡀⠀⠀                       ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒      ");

			System.out.println(
					"⠀⠀⠀⢸⣿⣿⣿⣿⣿⡄⠀⠰⢤⣤⠾⠷⣤⡤⠆⠀⢠⣿⣿⣿⣿⣿⡇⠀⠀                       ⠀⠈⠁⠉⢿⣿⣿⣷⣿⣿⣿⣿⣿⣿⣿⡿⠿⠿⣿⣿⣿⣿⣿⣿⣿⠟⠟⠛⠿⠍⠀⠀⠀⠀⠀⠀⠀");
			System.out.println(
					"⠀⠀⠀⠈⢿⣿⣿⣿⣿⠇⠀⠀⠘⡇⠀⠀⢸⠃⠀⠀⠸⣿⣿⣿⣿⡿⠁⠀⠀⠀                         ⠀⠀  ⠹⠿⠻⣿⠛⠛⠿⣿⡿⠋⠀⠀⠀⠀⠉⠀⠈⠙⠙⢿⠅⠀⠀⠀⠀⠀⠀⠀⠀   ");

			System.out.println(
					"⠀⠀⠀⠀⠈⠻⢿⣛⠁⠀⠀⠀⠀⠑⢄⡠⠊⠀⠀⠀⠀⠈⣛⡿⠟⠁⠀⠀⠀                         ⢰⣶⣶⣶⣶⣶⣶⣷⣾⣿⣿⣿⡿⣿⣿⣿⠛⠛⠛⠛⠛⠋⢛⣁⣀⣤⣄⠀⠀⠀⠀⠀⠀⠀⠀");
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
			System.out.println("⠀⠀⠀⠀⠣⡀⠀⢀⠠⠒⠀⠒⠀⠤⠤⠄⠀⢀⣀⣀⣀⣀⠀⠀⠤⠛⢿⣿⡿⠟⠁⠀                 ⢰⣶⣶⣶⣶⣶⣶⣷⣾⣿⣿⣿⡿⣿⣿⣿⠛⠛⠛⠛⠛⠋⢛⣁⣀⣤⣄⠀");
			System.out.println("                                                 ⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠏ ⠀");
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
			System.out.println("⠀⠀⠀⢀⡅⠀⠀⠀⠈⠃⠀⠀⠉⠛⠛⠛⠁⠀⠀⠀⠀⠀⠀⠀⠀⢀⣤⣤⣤⣤⠀⠀⠀⠔⠀              ⠈⠁⠉⢿⣿⣿⣷⣿⣿⣿⣿⣿⣿⣿⡿⠿⠿⣿⣿⣿⣿⣿⣿⣿⠟⠟⠛⠿⠍⠀");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀   ⣿⣿⣿⣿⣿⣿⠄                   ⠹⠿⠻⣿⠛⠛⠿⣿⡿⠋⠀⠀⠀⠀⠉⠀⠈⠙⠙⢿⠅    ");
			System.out.println("⠀⠀⠀⠀⠣⡀⠀⢀⠠⠒⠀⠒⠀⠤⠤⠄⠀⢀⣀⣀⣀⣀⠀⠀⠤⠛⢿⣿⡿⠟⠁⠀                 ⢰⣶⣶⣶⣶⣶⣶⣷⣾⣿⣿⣿⡿⣿⣿⣿⠛⠛⠛⠛⠛⠋⢛⣁⣀⣤⣄⠀");
			System.out.println("                                                 ⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠏ ⠀");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀                                      ⠈⠙⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠋⠉⠉⠉⠁⠀  ⠀");

		} else if (n == 2) {

			System.out.println("                                     ");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣠⣤⣤⣤⣤⣾⣿⣿⣦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀    ");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣾⣿⣿⣿⣿⡛⢫⣿⣿⡿⠉⠻⣿⣿⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⣶⣿⣿⠟⠛⠿⠿⠟⠀⠈⢩⠞⠁⠀⠉⠒⡈⢣⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⣸⡿⡿⢣⠔⠘⠀⠓⢦⠀⠀⠇⣠⣴⣶⣤⣄⠀⠀⠉⠀⠈⠐⠠⠀⠀⠀⠀⠀");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⣰⣿⡇⡰⠃⢀⣴⣶⣶⣦⡀⠀⣼⣿⡟⠙⣿⣿⡇⠀⠀⠀⠀⠀⠀⠈⢢⠀⠀ ");
			System.out.println("⠀⠀⠀⠀⠀⢠⣿⣿⡇⠁⢰⣿⡿⠛⢻⣿⣿⡄⠹⣿⣿⣾⣿⠟⠁⠀⠀⠀⠀⠀⠀⠀⠐⠀⠀  ");
			System.out.println("⠀⠀⠀⠀⢀⠊⠈⠛⣿⡇⠀⢸⣿⣷⣶⣾⣿⡟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠀⠀⠀            ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
			System.out.println("⠀⠀⠀⢀⡅⠀⠀⠀⠈⠃⠀⠀⠉⠛⠛⠛⠁⠀⠀⠀⠀⠀⠀⠀⠀⢀⣤⣤⣤⣤⠀⠀⠀⠔⠀              ⠈⠁⠉⢿⣿⣿⣷⣿⣿⣿⣿⣿⣿⣿⡿⠿⠿⣿⣿⣿⣿⣿⣿⣿⠟⠟⠛⠿⠍⠀");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀   ⣿⣿⣿⣿⣿⣿⠄                   ⠹⠿⠻⣿⠛⠛⠿⣿⡿⠋⠀⠀⠀⠀⠉⠀⠈⠙⠙⢿⠅    ");
			System.out.println("⠀⠀⠀⠀⠣⡀⠀⢀⠠⠒⠀⠒⠀⠤⠤⠄⠀⢀⣀⣀⣀⣀⠀⠀⠤⠛⢿⣿⡿⠟⠁⠀                 ⢰⣶⣶⣶⣶⣶⣶⣷⣾⣿⣿⣿⡿⣿⣿⣿⠛⠛⠛⠛⠛⠋⢛⣁⣀⣤⣄⠀");
			System.out.println("                                                 ⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠏ ⠀");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀                                      ⠈⠙⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠋⠉⠉⠉⠁⠀  ⠀");

		} else if (n == 3) {

			System.out.println("                                     ");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣠⣤⣤⣤⣤⣾⣿⣿⣦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀    ");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣾⣿⣿⣿⣿⡛⢫⣿⣿⡿⠉⠻⣿⣿⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⣶⣿⣿⠟⠛⠿⠿⠟⠀⠈⢩⠞⠁⠀⠉⠒⡈⢣⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⣸⡿⡿⢣⠔⠘⠀⠓⢦⠀⠀⠇⣠⣴⣶⣤⣄⠀⠀⠉⠀⠈⠐⠠⠀⠀⠀⠀⠀");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⣰⣿⡇⡰⠃⢀⣴⣶⣶⣦⡀⠀⣼⣿⡟⠙⣿⣿⡇⠀⠀⠀⠀⠀⠀⠈⢢⠀⠀ ");
			System.out.println("⠀⠀⠀⠀⠀⢠⣿⣿⡇⠁⢰⣿⡿⠛⢻⣿⣿⡄⠹⣿⣿⣾⣿⠟⠁⠀⠀⠀⠀⠀⠀⠀⠐⠀⠀            ▓█▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓█▓⠀");
			System.out.println("⠀⠀⠀⠀⢀⠊⠈⠛⣿⡇⠀⢸⣿⣷⣶⣾⣿⡟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠀⠀⠀            ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
			System.out.println("⠀⠀⠀⢀⡅⠀⠀⠀⠈⠃⠀⠀⠉⠛⠛⠛⠁⠀⠀⠀⠀⠀⠀⠀⠀⢀⣤⣤⣤⣤⠀⠀⠀⠔⠀              ⠈⠁⠉⢿⣿⣿⣷⣿⣿⣿⣿⣿⣿⣿⡿⠿⠿⣿⣿⣿⣿⣿⣿⣿⠟⠟⠛⠿⠍⠀");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀   ⣿⣿⣿⣿⣿⣿⠄                   ⠹⠿⠻⣿⠛⠛⠿⣿⡿⠋⠀⠀⠀⠀⠉⠀⠈⠙⠙⢿⠅    ");
			System.out.println("⠀⠀⠀⠀⠣⡀⠀⢀⠠⠒⠀⠒⠀⠤⠤⠄⠀⢀⣀⣀⣀⣀⠀⠀⠤⠛⢿⣿⡿⠟⠁⠀                 ⢰⣶⣶⣶⣶⣶⣶⣷⣾⣿⣿⣿⡿⣿⣿⣿⠛⠛⠛⠛⠛⠋⢛⣁⣀⣤⣄⠀");
			System.out.println("                                                 ⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠏ ⠀");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀                                      ⠈⠙⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠋⠉⠉⠉⠁⠀  ⠀");

		} else if (n == 4) {

			System.out.println("                                     ");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣠⣤⣤⣤⣤⣾⣿⣿⣦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀    ");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣾⣿⣿⣿⣿⡛⢫⣿⣿⡿⠉⠻⣿⣿⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⣶⣿⣿⠟⠛⠿⠿⠟⠀⠈⢩⠞⠁⠀⠉⠒⡈⢣⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⣸⡿⡿⢣⠔⠘⠀⠓⢦⠀⠀⠇⣠⣴⣶⣤⣄⠀⠀⠉⠀⠈⠐⠠⠀⠀⠀⠀⠀");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⣰⣿⡇⡰⠃⢀⣴⣶⣶⣦⡀⠀⣼⣿⡟⠙⣿⣿⡇⠀⠀⠀⠀⠀⠀⠈⢢⠀⠀             ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
			System.out.println("⠀⠀⠀⠀⠀⢠⣿⣿⡇⠁⢰⣿⡿⠛⢻⣿⣿⡄⠹⣿⣿⣾⣿⠟⠁⠀⠀⠀⠀⠀⠀⠀⠐⠀⠀            ▓█▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓█▓⠀");
			System.out.println("⠀⠀⠀⠀⢀⠊⠈⠛⣿⡇⠀⢸⣿⣷⣶⣾⣿⡟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠀⠀⠀            ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
			System.out.println("⠀⠀⠀⢀⡅⠀⠀⠀⠈⠃⠀⠀⠉⠛⠛⠛⠁⠀⠀⠀⠀⠀⠀⠀⠀⢀⣤⣤⣤⣤⠀⠀⠀⠔⠀              ⠈⠁⠉⢿⣿⣿⣷⣿⣿⣿⣿⣿⣿⣿⡿⠿⠿⣿⣿⣿⣿⣿⣿⣿⠟⠟⠛⠿⠍⠀");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀   ⣿⣿⣿⣿⣿⣿⠄                   ⠹⠿⠻⣿⠛⠛⠿⣿⡿⠋⠀⠀⠀⠀⠉⠀⠈⠙⠙⢿⠅    ");
			System.out.println("⠀⠀⠀⠀⠣⡀⠀⢀⠠⠒⠀⠒⠀⠤⠤⠄⠀⢀⣀⣀⣀⣀⠀⠀⠤⠛⢿⣿⡿⠟⠁⠀                 ⢰⣶⣶⣶⣶⣶⣶⣷⣾⣿⣿⣿⡿⣿⣿⣿⠛⠛⠛⠛⠛⠋⢛⣁⣀⣤⣄⠀");
			System.out.println("                                                 ⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠏ ⠀");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀                                      ⠈⠙⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠋⠉⠉⠉⠁⠀  ⠀");
		}

		else if (n == 5) {

			System.out.println("                                     ");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣠⣤⣤⣤⣤⣾⣿⣿⣦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀    ");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣾⣿⣿⣿⣿⡛⢫⣿⣿⡿⠉⠻⣿⣿⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⣶⣿⣿⠟⠛⠿⠿⠟⠀⠈⢩⠞⠁⠀⠉⠒⡈⢣⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⣸⡿⡿⢣⠔⠘⠀⠓⢦⠀⠀⠇⣠⣴⣶⣤⣄⠀⠀⠉⠀⠈⠐⠠⠀⠀⠀⠀⠀            ▓▓▓▓▓▓▓▓▓▓▓▓▓▓████▓▓▓▓▓▓▓▓▓▓▓▓");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⣰⣿⡇⡰⠃⢀⣴⣶⣶⣦⡀⠀⣼⣿⡟⠙⣿⣿⡇⠀⠀⠀⠀⠀⠀⠈⢢⠀⠀             ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
			System.out.println("⠀⠀⠀⠀⠀⢠⣿⣿⡇⠁⢰⣿⡿⠛⢻⣿⣿⡄⠹⣿⣿⣾⣿⠟⠁⠀⠀⠀⠀⠀⠀⠀⠐⠀⠀            ▓█▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓█▓⠀");
			System.out.println("⠀⠀⠀⠀⢀⠊⠈⠛⣿⡇⠀⢸⣿⣷⣶⣾⣿⡟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠀⠀⠀            ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
			System.out.println("⠀⠀⠀⢀⡅⠀⠀⠀⠈⠃⠀⠀⠉⠛⠛⠛⠁⠀⠀⠀⠀⠀⠀⠀⠀⢀⣤⣤⣤⣤⠀⠀⠀⠔⠀              ⠈⠁⠉⢿⣿⣿⣷⣿⣿⣿⣿⣿⣿⣿⡿⠿⠿⣿⣿⣿⣿⣿⣿⣿⠟⠟⠛⠿⠍⠀");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀   ⣿⣿⣿⣿⣿⣿⠄                   ⠹⠿⠻⣿⠛⠛⠿⣿⡿⠋⠀⠀⠀⠀⠉⠀⠈⠙⠙⢿⠅    ");
			System.out.println("⠀⠀⠀⠀⠣⡀⠀⢀⠠⠒⠀⠒⠀⠤⠤⠄⠀⢀⣀⣀⣀⣀⠀⠀⠤⠛⢿⣿⡿⠟⠁⠀                 ⢰⣶⣶⣶⣶⣶⣶⣷⣾⣿⣿⣿⡿⣿⣿⣿⠛⠛⠛⠛⠛⠋⢛⣁⣀⣤⣄⠀");
			System.out.println("                                                 ⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠏ ⠀");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀                                      ⠈⠙⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠋⠉⠉⠉⠁⠀  ⠀");

		}

		else if (n == 6) {

			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣠⣤⣤⣤⣤⣾⣿⣿⣦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀    ");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣾⣿⣿⣿⣿⡛⢫⣿⣿⡿⠉⠻⣿⣿⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⣶⣿⣿⠟⠛⠿⠿⠟⠀⠈⢩⠞⠁⠀⠉⠒⡈⢣⠀⠀⠀⠀⠀⠀⠀⠀⠀             ░░▒▒▒▒▒▒░░░░░░░░░░░░░░▒▒▒▒▒▒░░⠀");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⣸⡿⡿⢣⠔⠘⠀⠓⢦⠀⠀⠇⣠⣴⣶⣤⣄⠀⠀⠉⠀⠈⠐⠠⠀⠀⠀⠀⠀            ▓▓▓▓▓▓▓▓▓▓▓▓▓▓████▓▓▓▓▓▓▓▓▓▓▓▓");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⣰⣿⡇⡰⠃⢀⣴⣶⣶⣦⡀⠀⣼⣿⡟⠙⣿⣿⡇⠀⠀⠀⠀⠀⠀⠈⢢⠀⠀             ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
			System.out.println("⠀⠀⠀⠀⠀⢠⣿⣿⡇⠁⢰⣿⡿⠛⢻⣿⣿⡄⠹⣿⣿⣾⣿⠟⠁⠀⠀⠀⠀⠀⠀⠀⠐⠀⠀            ▓█▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓█▓⠀");
			System.out.println("⠀⠀⠀⠀⢀⠊⠈⠛⣿⡇⠀⢸⣿⣷⣶⣾⣿⡟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠀⠀⠀            ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
			System.out.println("⠀⠀⠀⢀⡅⠀⠀⠀⠈⠃⠀⠀⠉⠛⠛⠛⠁⠀⠀⠀⠀⠀⠀⠀⠀⢀⣤⣤⣤⣤⠀⠀⠀⠔⠀              ⠈⠁⠉⢿⣿⣿⣷⣿⣿⣿⣿⣿⣿⣿⡿⠿⠿⣿⣿⣿⣿⣿⣿⣿⠟⠟⠛⠿⠍⠀");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀   ⣿⣿⣿⣿⣿⣿⠄                   ⠹⠿⠻⣿⠛⠛⠿⣿⡿⠋⠀⠀⠀⠀⠉⠀⠈⠙⠙⢿⠅    ");
			System.out.println("⠀⠀⠀⠀⠣⡀⠀⢀⠠⠒⠀⠒⠀⠤⠤⠄⠀⢀⣀⣀⣀⣀⠀⠀⠤⠛⢿⣿⡿⠟⠁⠀                 ⢰⣶⣶⣶⣶⣶⣶⣷⣾⣿⣿⣿⡿⣿⣿⣿⠛⠛⠛⠛⠛⠋⢛⣁⣀⣤⣄⠀");
			System.out.println("                                                 ⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠏ ⠀");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀                                      ⠈⠙⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠋⠉⠉⠉⠁⠀  ⠀");
		}

		else if (n == 7) {

			System.out.println("                                                     ⢀⣠⣤⣶⣶⣶⣾⣿⣽⣿⣷⣿⣷⣢⠽⢷⣶⣤⢀ ");
			System.out.println("                                                  ⣠⣶⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡗⢾⣿⣧⣷⢵⣦⡀");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣠⣤⣤⣤⣤⣾⣿⣿⣦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀                  ⠸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣾⡆");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣾⣿⣿⣿⣿⡛⢫⣿⣿⡿⠉⠻⣿⣿⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀              ⣻⢿⣿⣿⣿⣿⣿⣭⣽⣿⣿⣦⣤⣴⣾⣭⣭⣭⣉⠙⡛⠛⠻⠿⠿⡗⠀");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⣶⣿⣿⠟⠛⠿⠿⠟⠀⠈⢩⠞⠁⠀⠉⠒⡈⢣⠀⠀⠀⠀⠀⠀⠀⠀⠀             ░░▒▒▒▒▒▒░░░░░░░░░░░░░░▒▒▒▒▒▒░░⠀");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⣸⡿⡿⢣⠔⠘⠀⠓⢦⠀⠀⠇⣠⣴⣶⣤⣄⠀⠀⠉⠀⠈⠐⠠⠀⠀⠀⠀⠀            ▓▓▓▓▓▓▓▓▓▓▓▓▓▓████▓▓▓▓▓▓▓▓▓▓▓▓");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⣰⣿⡇⡰⠃⢀⣴⣶⣶⣦⡀⠀⣼⣿⡟⠙⣿⣿⡇⠀⠀⠀⠀⠀⠀⠈⢢⠀⠀             ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
			System.out.println("⠀⠀⠀⠀⠀⢠⣿⣿⡇⠁⢰⣿⡿⠛⢻⣿⣿⡄⠹⣿⣿⣾⣿⠟⠁⠀⠀⠀⠀⠀⠀⠀⠐⠀⠀            ▓█▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓█▓⠀");
			System.out.println("⠀⠀⠀⠀⢀⠊⠈⠛⣿⡇⠀⢸⣿⣷⣶⣾⣿⡟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠀⠀⠀            ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
			System.out.println("⠀⠀⠀⢀⡅⠀⠀⠀⠈⠃⠀⠀⠉⠛⠛⠛⠁⠀⠀⠀⠀⠀⠀⠀⠀⢀⣤⣤⣤⣤⠀⠀⠀⠔⠀              ⠈⠁⠉⢿⣿⣿⣷⣿⣿⣿⣿⣿⣿⣿⡿⠿⠿⣿⣿⣿⣿⣿⣿⣿⠟⠟⠛⠿⠍⠀");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀   ⣿⣿⣿⣿⣿⣿⠄                   ⠹⠿⠻⣿⠛⠛⠿⣿⡿⠋⠀⠀⠀⠀⠉⠀⠈⠙⠙⢿⠅    ");
			System.out.println("⠀⠀⠀⠀⠣⡀⠀⢀⠠⠒⠀⠒⠀⠤⠤⠄⠀⢀⣀⣀⣀⣀⠀⠀⠤⠛⢿⣿⡿⠟⠁⠀                 ⢰⣶⣶⣶⣶⣶⣶⣷⣾⣿⣿⣿⡿⣿⣿⣿⠛⠛⠛⠛⠛⠋⢛⣁⣀⣤⣄⠀");
			System.out.println("                                                 ⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠏ ⠀");
			System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀                                      ⠈⠙⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠋⠉⠉⠉⠁⠀  ⠀");
		}

	}

	public void countDown() {

		System.out.println("\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n");
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
		System.out.println("\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n");
		timeSleep(1000);

		System.out.println("\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n");
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
		System.out.println("\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n");
		timeSleep(1000);

		System.out.println("\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n");
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
		System.out.println("\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n");
		timeSleep(1000);
	}

	public void timeSleep(int n) {
		try {
			Thread.sleep(n); // 1000 = 1초
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
