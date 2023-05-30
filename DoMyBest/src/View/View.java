package View;

import java.util.ArrayList;
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
				System.out.println("======= 로그인 =======");
				System.out.print("ID를 입력 >> ");
				String id = scan.next();
				System.out.print("PW를 입력 >>");
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
				System.out.println("게임 내 랭킹을 조회합니다.");
				MemberDAO rankingCon = new MemberDAO();
				for (int i = 0; i < rankingCon.rankingMember().size(); i++) {
					System.out.print("Id = " + rankingCon.rankingMember().get(i).getId() + " ");
					System.out.print("Name = " + rankingCon.rankingMember().get(i).getName() + " ");
					System.out.print("Score = " + rankingCon.rankingMember().get(i).getScore() + " ");
					System.out.println();
				}
//				ArrayList<MemberDTO> result = lankingCon.lankingMember();

			} else if (num == 4) {
				System.out.println("프로그램을 종료합니다.");
				break;

			} else {
				System.out.println("숫자를 잘못 입력하셨습니다.");
			}
		}
	}

}
