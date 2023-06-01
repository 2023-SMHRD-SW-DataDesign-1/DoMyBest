package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDAO {

	// 전역변수 지정
	Connection conn = null;
	PreparedStatement psmt;
	ResultSet rs = null;
	int row = 0;

	// 기능 메소드 생성
	public void getConn() { // 연결
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			String dburl = "jdbc:oracle:thin:@project-db-stu.smhrd.com:1524:xe";
			String dbuser = "campus_g_0530_1";
			String dbpw = "smhrd1";

			conn = DriverManager.getConnection(dburl, dbuser, dbpw);
			if (conn != null) {
//				System.out.println("connect success");
			} else {
//				System.out.println("connect fail");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insertMember(MemberDTO dto) { // 회원가입
		getConn();
		String sql = "insert into MEMBER(id, pw, name) values(?,?,?)";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getPw());
			psmt.setString(3, dto.getName());

			row = psmt.executeUpdate();

			if (row > 0) {
				System.out.println("         (๑^᎑^๑)っ 축하드립니다. 회원가입에 성공했습니다.");
			} else {
				System.out.println("         :(;ﾞﾟωﾟ'): 죄송합니다. 회원가입에 실패했습니다.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			allClose();
		}

	}

	public String loginMember(MemberDTO dto) { // 로그인
		getConn();
		String name = null;

		try {
			String sql = "select name from member where id = ? and pw = ?";

			psmt = conn.prepareStatement(sql);

			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getPw());

			rs = psmt.executeQuery();

			if (rs.next()) {
				name = rs.getString("name");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			allClose();
		}
		return name;
	}

	public void rankingInsert(String id, int score) {
		getConn();
		
		try {
			String sql = "update member set score = ? where id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, score);
			psmt.setString(2, id);
			
			row = psmt.executeUpdate();
			
			if(row>0) {
				System.out.println();
				System.out.println("☆ヾ(ゝω・＊）찡긋- 랭킹 등록 완료");
			}else {
				System.out.println(" Σ( ﾟдﾟ)ﾟдﾟ) 어멋! 랭킹 등록 실패");
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			allClose();
		}
		
		
	}
	
	
	public ArrayList<MemberDTO> rankingMember() { // 랭킹조회
		getConn();
		// MemberDTO dto;
		ArrayList<MemberDTO> Mlist = new ArrayList<>();

		try {
			String sql = "select id, name, score from member where score is not null order by score desc";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				String id = rs.getString(1);
				String name = rs.getString(2);
				int score = rs.getInt(3);
				Mlist.add(new MemberDTO(id, name, score));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			allClose();
		}
		return Mlist;
	}

	public void memberDelete(String id) { // 회원정보 삭제
		getConn();

		try {
			String sql = "delete from MEMBER where id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);

			int cnt = psmt.executeUpdate();
			if (cnt > 0)
				System.out.println(" (*･ω･)ω<*) 삭제가 완료됐습니다!");
			else
				System.out.println("（ｰωｰ*  )-= 존재하는 아이디가 없습니다.");
		}
		
		catch (Exception e) {
			e.printStackTrace();
		} finally {
			allClose();
		}
	}

	private void allClose() { // 종료
		try {
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
			if (rs != null)
				rs.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

}
