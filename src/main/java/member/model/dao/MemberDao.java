package member.model.dao;

import static common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import member.model.vo.Member;

public class MemberDao {
	public MemberDao() {
	}

	// 일반회원 로그인
	public Member commonLogin(Connection conn, String mid, String mpwd) {
		Member member = new Member();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select * from member where member_Id = ? and member_Pwd = ?";

		try {
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, mid);
			pstmt.setString(2, mpwd);

			rset = pstmt.executeQuery();
      

			if (rset.next()) {

				member.setMemberSeq(rset.getInt("member_seq"));
				member.setMemberId(mid);
				member.setMemberPwd("");
				member.setMemberNick(rset.getString("member_nick"));
				member.setMemberEmail(rset.getString("member_email"));
				member.setMemberGrade(rset.getString("member_grade"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return member;
	}


	//sns계정 로그인(네이버 카카오)
	public Member snsLogin(Connection conn, String memail) {
		Member member = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select * from member where member_email = ?";

		try {
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, memail);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				member = new Member();
				member.setMemberSeq(rset.getInt("member_seq"));
				member.setMemberId(rset.getString("member_id"));
				member.setMemberPwd("");
				member.setMemberNick(rset.getString("member_nick"));
				member.setMemberEmail(memail);
				member.setMemberGrade(rset.getString("member_grade"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return member;
	}

	// 회원가입 처리용
	public int insertMember(Connection conn, Member member) {
		int result = 0;
		String query = "insert into member values ((member_seq.nextval),?,?,?,?,1)";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPwd());
			pstmt.setString(3, member.getMemberEmail());
			pstmt.setString(4, member.getMemberNick());

			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	// 아이디 중복 체크용
	public int selectCheckid(Connection conn, String mid) {
		int idc = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select * from member where member_id = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, mid);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				idc = 1; // select 절의 항목 순번으로도 값 추출할 수 있음
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return idc;
	}

	// 이메일 중복 체크용
	public int selectCheckemail(Connection conn, String memail) {
		int emc = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select * from member where member_email = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memail);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				emc = 1; // select 절의 항목 순번으로도 값 추출할 수 있음
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return emc;
	}

	// 회원아이디 조회용
	public Member findMemberid(Connection conn, String memail) {
		Member mem = new Member();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select * from member where member_email = ?";

		try {
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, memail);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				mem.setMemberId(rset.getString("member_id"));
				mem.setMemberPwd(rset.getString("member_pwd"));
				mem.setMemberNick(rset.getString("member_nick"));
				mem.setMemberEmail(memail);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return mem;
	}

	// 회원 패스워드변경을 위한 조회용
	public Member findMemberpwd(Connection conn, String mid, String memail) {
		Member mem = new Member();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select * from member where member_id = ? and member_email = ?";

		try {
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, mid);
			pstmt.setString(2, memail);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				mem.setMemberSeq(rset.getInt("member_seq"));
				mem.setMemberId(mid);
				mem.setMemberPwd(rset.getString("member_pwd"));
				mem.setMemberNick(rset.getString("member_nick"));
				mem.setMemberEmail(memail);
				mem.setMemberGrade(rset.getString("member_grade"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return mem;
	}

	// 회원 패스워드 변경용
	public int updatePwd(Connection conn, Member member) {
		int result = 0;
		PreparedStatement pstmt = null;

		String query = "update member set member_pwd = ? where member_id = ? and member_email = ?";
		try {
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, member.getMemberPwd());
			pstmt.setString(2, member.getMemberId());
			pstmt.setString(3, member.getMemberEmail());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	// 관리자 회원 등급 변경용
	public int managementMember(Connection conn, String memberSeq, String memberGrade) {
		int result = 0;
		PreparedStatement pstmt = null;

		String query = "update member set member_grade = ? where member_seq = ?";

		try {
			pstmt = conn.prepareStatement(query);

			if (memberGrade.equals("1")) {

				pstmt.setString(1, "2");
				pstmt.setString(2, memberSeq);

			} else if (memberGrade.equals("2")) {
				pstmt.setString(1, "1");
				pstmt.setString(2, memberSeq);
			}

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int updateMemberInfo(Connection conn, String userid, String nickname) {
		int result = 0;

		PreparedStatement pstmt = null;

		String query = "UPDATE MEMBER SET MEMBER_NICK = ? " + "WHERE MEMBER_ID = ?";
		try {
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, nickname);
			pstmt.setString(2, userid);

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int updateMemberpwd(Connection conn, Member member) {

		int result = 0;

		PreparedStatement pstmt = null;

		String query = "UPDATE MEMBER SET MEMBER_PWD = ? " + "WHERE MEMBER_ID = ?";
		try {
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, member.getMemberPwd());
			pstmt.setString(2, member.getMemberId());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	// 회원 검색
	public ArrayList<Member> selectSearchMemberId(Connection conn, String keyword) {
		ArrayList<Member> list = new ArrayList<Member>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select * from member where not member_grade = '0' and member_id like ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");

			rset = pstmt.executeQuery();

			while (rset.next()) {
				Member member = new Member();

				member.setMemberSeq(rset.getInt("member_seq"));
				member.setMemberId(rset.getString("member_id"));
				member.setMemberEmail(rset.getString("member_email"));
				member.setMemberNick(rset.getString("member_nick"));
				member.setMemberGrade(rset.getString("member_grade"));

				list.add(member);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

	// 관리자 제외 전체 멤버 리스트 표시
	public ArrayList<Member> selectList(Connection conn) {

		ArrayList<Member> list = new ArrayList<Member>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select * from member where not member_grade = '0'";

		try {
			pstmt = conn.prepareStatement(query);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				Member member = new Member();

				member.setMemberSeq(rset.getInt("member_seq"));
				member.setMemberId(rset.getString("member_id"));
				member.setMemberPwd(rset.getString("member_pwd"));
				member.setMemberEmail(rset.getString("member_email"));
				member.setMemberNick(rset.getString("member_nick"));
				member.setMemberGrade(rset.getString("member_grade"));

				list.add(member);
			}
		} catch (Exception e) {
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public ArrayList<Member> againList(Connection conn, String memberId) {

		ArrayList<Member> list = new ArrayList<Member>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select * from member where not member_grade = '0' and member_id like ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + memberId + "%");

			rset = pstmt.executeQuery();

			while (rset.next()) {
				Member member = new Member();

				member.setMemberSeq(rset.getInt("member_seq"));
				member.setMemberId(rset.getString("member_id"));
				member.setMemberEmail(rset.getString("member_email"));
				member.setMemberNick(rset.getString("member_nick"));
				member.setMemberGrade(rset.getString("member_grade"));

				list.add(member);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

	// 내용으로 검색 .. 게시판
	public ArrayList<Member> selectSearchContent(Connection conn, String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	// 회원등급으로 검색 .. 게시판
	public ArrayList<Member> selectSearchMemberGrade(Connection conn, String keyword) {
		ArrayList<Member> list = new ArrayList<Member>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select * from member where not member_grade = '0' and member_grade like ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + keyword + "%");

			rset = pstmt.executeQuery();

			while (rset.next()) {
				Member member = new Member();

				member.setMemberSeq(rset.getInt("member_seq"));
				member.setMemberId(rset.getString("member_id"));
				member.setMemberEmail(rset.getString("member_email"));
				member.setMemberNick(rset.getString("member_nick"));
				member.setMemberGrade(rset.getString("member_grade"));

				list.add(member);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

}
