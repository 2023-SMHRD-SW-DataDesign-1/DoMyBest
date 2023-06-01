package View;

import java.util.Scanner;

import Controller.ButtonController;
import Controller.StageController;
import Controller.ViewController;
import Model.MemberDAO;
import Model.MemberDTO;
import javazoom.jl.player.MP3Player;

public class View {

	public static void main(String[] args) {
		MP3Player mp3 = new MP3Player();

		mp3.play("C:/Users/smhrd/git/DoMyBest/DoMyBest/Music/mainbgm.mp3");
		ViewController vcon = new ViewController();
		StageController keygame = new StageController();
		ButtonController mousegame = new ButtonController();
//		vcon.mainView();
		System.out.println("\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n");
		Scanner scan = new Scanner(System.in);
		// Controller 의 메소드를 호출하기위해 Stagecontroller 객체 호출
		StageController con = new StageController();

		while (true) {
			System.out.println("            JAVA BURGER에 온 것을 환영합니다!    ");
			System.out.println("             ₊    ˚   ✩    ｡˚      ˚ ☽");
			System.out.println("             ˚  ₊        /) /)   ₊   ✩    ｡");
			System.out.println("             ˚    ✩  ( •̥ ˕ •̥)     ｡  ˚");
			System.out.println("               ₊˚｡    c(“)(“)   ₊ ˚ ✩");
			System.out.println("             ‘’’’’ꕤ’’’’’’’’’’’’’’ꕤ’’’’’’’’’");
			System.out.println("              ꕤ         ꕤ          ꕤ");
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("═══════════ ೋღ JAVA HAMBURGER GAME 회원 시스템🌺 ღೋ ═══════════");
			System.out.print("[1] 회원 가입 [2] 로그인 [3] 랭킹조회 [4] 회원 삭제 [5] 게임 종료  >>");
			System.out.println();
			System.out.print("          원하시는 번호를 입력해주세요 >>>>>>  ");
			int num = scan.nextInt();
			System.out.println("\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n");
			System.out.println("\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n");
			System.out.println();
			// 회원가입
			if (num == 1) {
				System.out.println("\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n");
				System.out.println(" ⠀⠀⠀ ⠀⠀⠀⠀ ⠀⠀⠀⠀ ⠀⠀⠀ ⠀⠀⠀/)＿/)☆ ");
			    System.out.println("⠀ ⠀⠀⠀ ⠀⠀⠀⠀ ⠀⠀⠀⠀ ⠀⠀⠀⠀／(๑^᎑^๑)っ ＼");
			    System.out.println(" ⠀⠀⠀⠀ ⠀⠀⠀⠀ ⠀⠀⠀ ⠀⠀⠀／|￣∪￣ ￣ |＼／");
			    System.out.println("⠀ ⠀⠀⠀ ⠀⠀⠀⠀ ⠀⠀⠀⠀ ⠀⠀⠀ |＿＿_＿＿|／");
			    System.out.println();
			    System.out.println("             JAVA BURGER에 오신 것을 환영해요!");
			    System.out.println();
			    System.out.println();
			    System.out.println();
				System.out.println("══════════════════════ ೋღ 회원가입🌺 ღೋ ══════════════════════");
				System.out.print("원하는 ID를 입력하세요 >> ");
				String id = scan.next();
				System.out.print("원하는 PW를 입력하세요 >> ");
				String pw = scan.next();
				System.out.print("원하는 NAME를 입력하세요 >> ");
				String name = scan.next();
				System.out.println("\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n"+"\n");

				MemberDAO insertCon = new MemberDAO();

				insertCon.insertMember(new MemberDTO(id, pw, name));
             
				// 로그인
			} else if (num == 2) {

				while (true) {
					System.out.println("══════════════════ ೋღ 로그인🌺 ღೋ ══════════════════");
					System.out.print("ID를 입력해주세요 >> ");
					String id = scan.next();
					System.out.print("PW를 입력해주세요 >> ");
					String pw = scan.next();

					MemberDAO loginCon = new MemberDAO();
					String name = loginCon.loginMember(new MemberDTO(id, pw));

					if (name != null) {
						System.out.println(name + "님이 로그인하셨습니다.");
						System.out.println();
						System.out.println("══════════════════   " + name + "님 안녕하세요!　══════════════════ ");
						while (true) {
							System.out.println("➳➳➳➳➳➳➳➳➳➳➳[  게임을 시작하시겠습니까?  ]➳➳➳➳➳➳➳➳➳➳➳");
							System.out.println("                   [1] 예  [2] 아니오");
							System.out.println();
							System.out.print("            번호를 입력해주세요  >>>>>  ");
							num = scan.nextInt();
							if (num == 1) {
								while (true) {
									System.out.println();
									System.out.println("➳➳➳➳➳➳➳➳➳➳[  게임모드를 선택해주세요 ]➳➳➳➳➳➳➳➳➳➳");
									System.out.println("         [1] 키보드모드 [2] 마우스모드 ");
									System.out.print("            번호를 입력해주세요  >>>>>  ");
									num = scan.nextInt();
									if (num == 1) {

										mp3.stop();
										System.out.println("게임을 시작합니다!");
										keygame.timeSleep(1000);
										System.out.println(
												"\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n"+ "\n" + "\n" + "\n" + "\n");
										System.out.println("        .............Behind Story............");
										System.out.println("         햄버거가 너무 좋아서 세끼 햄버거만 먹던 나는..");
										System.out.println("        열심히 돈을 모아서 JAVA HAMBURGER를 차렸다.");
										System.out.println("           그리고 드디어 오늘은 가게를 오픈하는 날!");
										System.out.println(" 나의 손맛이 들어간 맛있는 버거의 맛을 사람들이 알아주길 바라며...");
										System.out.println("            설레는 마음으로 가게 운영을 시작해보자!");
										System.out.println(
												"\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n"+ "\n" + "\n" + "\n" + "\n");

										keygame.timeSleep(3000);
										keygame.countDown();

										keygame.stageStart();
										System.out.println();
										System.out.println();
										break;
									} else if (num == 2) {
										mp3.stop();
										System.out.println("게임을 시작합니다!");

										mousegame.timeSleep(1000);
										keygame.countDown();
										mousegame.stageStart();
										System.out.println();
										System.out.println();
										break;
									} else {
										System.out.println("잘못된 입력입니다 •(  • _ •。)");
									}
								}
								break;

							} else if (num == 2) {
								break;
							} else {
								System.out.println("잘못된 입력입니다 •(  • _ •。)" + "\n");
							}
						}

						// 게임 들어가서 어떻게 게임 진행될건지는 여기서부터~!
						// 생각해보기~!
						break;
					} else if (name == null) {
						System.out.println("아이디와 비밀번호를 잘못입력하셨습니다. •(  • _ •。)" + "\n");
					}
				}

			} else if (num == 3) {
				System.out.println("╭➳➳➳➳➳♡⃘♡⃘♡⃘♡⃘♡⃘♡⃘♡⃘♡⃘♡⃘♡⃘♡⃘♡⃘♡⃘♡⃘♡⃘♡⃘♡⃘♡⃘♡┈┈┈┈┈┈╮");
				System.out.println("      이 구역의 랭킹탐정이 랭킹을 조회합니다.");
				System.out.println("    랭킹탐정의 선글라스가 반짝이며 랭킹을 조회합니다.");
				System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
				System.out.println("█░░░░░░░░▀█▄▀▄▀██████░▀█▄▀▄▀██████░");
				System.out.println("░░░░░░░░░░░▀█▄█▄███▀░░░ ▀██▄█▄███▀░");

				MemberDAO rankingCon = new MemberDAO();
				for (int i = 0; i < rankingCon.rankingMember().size(); i++) {
					System.out.print((i + 1) + "등 아이디는 ➳" + rankingCon.rankingMember().get(i).getId() + " ");
					System.out.print("이름은 ➳ " + rankingCon.rankingMember().get(i).getName() + " ");
					System.out.print("점수는 ➳" + rankingCon.rankingMember().get(i).getScore() + " ");
					System.out.println();
				}

			} else if (num == 4) {
				System.out.println("════════════════════ ೋღ 회원정보 삭제🌺 ღೋ ════════════════════");
				System.out.println("(つ˵•́ω•̀˵)つ━☆ﾟ.*･｡ﾟ҉̛༽̨҉҉ﾉ 삭제 요정이 도와드리겠습니다 뿅(つ˵•́ω•̀˵)つ━☆ﾟ.*･｡ﾟ҉̛༽̨҉҉ﾉ");
				System.out.println();
				System.out.print("삭제하고 싶은 아이디 입력 : ");
				String id = scan.next();
//	            
				MemberDAO deleteCon = new MemberDAO();
				deleteCon.memberDelete(id);

//	            
//	            System.out.println("회원 삭제에 "+result+"하셨습니다.");
			} else if (num == 5) {
				System.out.println("프로그램을 종료합니다.");
				break;

			} else {
				System.out.println("숫자를 잘못 입력하셨습니다.•(  • _ •。)");
			}
		}
	}

}
