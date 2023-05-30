package View;

import java.util.Scanner;

import Controller.StageController;
import Model.MemberDAO;
import Model.MemberDTO;

public class View {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		// Controller 의 메소드를 호출하기위해 Stagecontroller 객체 호출
		StageController con = new StageController();

		System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");
		System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠟⠛⠉⠉⠉⠉⠉⠀⠉⠉⠉⠉⠛⠿⠿⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");
		System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠟⠉⠀⠀⠀⠀⠀⠀⠀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠙⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");
		System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠋⠀⠀⠀⢀⠀⠀⠀⠀⠀⢾⡿⠃⠀⠀⠀⢾⣷⡄⠀⠀⠀⠀⠀⠀⠈⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");
		System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠟⠀⠀⠀⠀⣴⣿⠇⠀⠀⠀⠀⠀⠀⠀⣀⣀⠀⠀⠙⠃⠀⠀⠀⢀⣀⠀⠀⠀⠘⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");
		System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡏⠀⠀⠀⠀⠀⠈⠁⠀⠀⠀⠀⠀⠀⠀⢸⣿⠟⠀⠀⠀⠀⠀⠀⠀⠘⢿⡷⠀⠀⠀⠀⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");
		System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣿⣿⣿⣿⣿⣿⣿⣿⣿");
		System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");
		System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿");
		System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");
		System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");
		System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣀⣿⣿⣿⣿⣿⣿⣿⣿⣿");
		System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");
		System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣶⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");
		System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣦⣀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣀⣠⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");
		System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");
		System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");
		System.out.println(".########..##⣿⣿⣿⣿##.########...######...########.########.");
		System.out.println(".##⣿⣿⣿⣿##.##⣿⣿⣿⣿##.##⣿⣿⣿⣿⣿##.##⣿⣿⣿⣿##..##⣿⣿⣿⣿⣿.##⣿⣿⣿⣿##");
		System.out.println(".##⣿⣿⣿⣿##.##⣿⣿⣿⣿##.##⣿⣿⣿⣿⣿##.##⣿⣿⣿⣿⣿⣿..##⣿⣿⣿⣿⣿..##⣿⣿⣿⣿##");
		System.out.println(".########.##⣿⣿⣿⣿##.########..##⣿⣿#####.#######..########.");
		System.out.println(".##⣿⣿⣿⣿##.##⣿⣿⣿⣿##.##⣿⣿⣿##...##⣿⣿⣿⣿##..##⣿⣿⣿⣿⣿..##⣿⣿⣿⣿##..");
		System.out.println(".##⣿⣿⣿⣿##.##⣿⣿⣿⣿##.##⣿⣿⣿⣿##..##⣿⣿⣿⣿##..##⣿⣿⣿⣿⣿..##⣿⣿⣿⣿##.");
		System.out.println(".########.#######..##⣿⣿⣿⣿⣿##..######...########.##⣿⣿⣿⣿⣿##");
		System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");
		System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");
		System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀HELLO!⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");
		System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀WELCOME TO JAVA HAMBURGER⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");
		System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀ARE YOU READY?⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");
		System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");
		System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");
		while (true) {
			System.out.println("===============JAVA HAMBURER GAME 회원 시스템================");
			System.out.print("[1] 회원 가입 [2] 로그인 [3] 랭킹조회 [4] 회원 삭제 [5] 게임 종료  >>");
			System.out.println();
			int num = scan.nextInt();
			// 회원가입
			if (num == 1) {
				System.out.println("======= 회원가입 =======");
				System.out.print("ID를 입력하세요 >> ");
				String id = scan.next();
				System.out.print("PW를 입력하세요 >>");
				String pw = scan.next();
				System.out.print("NAME를 입력하세요 >>");
				String name = scan.next();

				MemberDAO insertCon = new MemberDAO();

				insertCon.insertMember(new MemberDTO(id, pw, name));

				// 로그인
			} else if (num == 2) {
				System.out.println("══════════════════ ೋღ 로그인🌺 ღೋ ══════════════════════");
				System.out.print("원하는 ID를 입력해주세요 >> ");
				String id = scan.next();
				System.out.print("원하는 PW를 입력해주세요 >>");
				String pw = scan.next();

				MemberDAO loginCon = new MemberDAO();
				String name = loginCon.loginMember(new MemberDTO(id, pw));

				if (name != null) {
					System.out.println(name + "님이 로그인하셨습니다.");
					System.out.print("♪~ ♬ ♪♬~♪ ♪~ ♬ ♪♬~♪ ♪~ ♬ ♪♬~~ ♬ ♪~ ♬ ♪♬~♪ ♪~ ");

					// 게임 들어가서 어떻게 게임 진행될건지는 여기서부터~!
					// 생각해보기~!

				} else {
					System.out.println("아이디와 비밀번호를 잘못입력하셨습니다.");
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
					System.out.print((i+1)+"등 아이디는 ➳" + rankingCon.rankingMember().get(i).getId() + " ");
					System.out.print("이름은 ➳ " + rankingCon.rankingMember().get(i).getName() + " ");
					System.out.print("점수는 ➳" + rankingCon.rankingMember().get(i).getScore() + " ");
					System.out.println();
				}

			} else if (num == 4) {
				System.out.println("══════════════════ ೋღ 회원정보 삭제🌺 ღೋ ══════════════════════");
				System.out.print("삭제하고 싶은 아이디 입력 : ");
	            String id = scan.next();
//	            
	            MemberDAO deleteCon = new MemberDAO();
                String result = deleteCon.memberDelete(new MemberDTO(id));
               
//	            
//	            System.out.println("회원 삭제에 "+result+"하셨습니다.");
			} else if (num == 5) {
				System.out.println("프로그램을 종료합니다.");
				break;

			} else {
				System.out.println("숫자를 잘못 입력하셨습니다.");
			}
		}
	}

}
